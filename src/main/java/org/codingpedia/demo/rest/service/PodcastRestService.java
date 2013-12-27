package org.codingpedia.demo.rest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codingpedia.demo.rest.dao.PodcastDao;
import org.codingpedia.demo.rest.entities.Podcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/podcasts")
public class PodcastRestService {

	private static final String HOST = "http://localhost:8080/demo-rest-spring-jersey-tomcat-mybatis-0.0.1-SNAPSHOT";
	
	@Autowired
	private PodcastDao podcastDao; 
	
	/************************************ CREATE ************************************/
	@POST @Path("create")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_HTML})	
	public Response createPodcast(Podcast podcast) {
		Long id = podcastDao.createPodcast(podcast);
		
		return Response.status(201).entity(buildNewPodcastResourceURL(id)).build(); 		
	}	
		
	@POST @Path("createPodcasts")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response createPodcasts(List<Podcast> podcasts) {
		for(Podcast podcast : podcasts){
			podcastDao.createPodcast(podcast);			
		}
		
		return Response.status(204).build(); 	
	}
	
	@POST @Path("create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.TEXT_HTML})	
	public Response createPodcastFromForm(
						@FormParam("title") String title,
						@FormParam("linkOnPodcastpedia") String linkOnPodcastpedia,
						@FormParam("feed") String feed,
						@FormParam("description") String description
						) {
		Podcast podcast = new Podcast(title, linkOnPodcastpedia, feed, description);
		Long id = podcastDao.createPodcast(podcast);
		
		return Response.status(201).entity(buildNewPodcastResourceURL(id)).build(); 		
	}	

	
	/************************************ READ ************************************/
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Podcast> getPodcasts() {
		return podcastDao.getPodcasts();
	}
		
	@GET @Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Podcast findById(@PathParam("id") Long id) {		
		return podcastDao.getPodcastById(id);
	}

	
	/************************************ UPDATE ************************************/
	/**
	 * Updates the attributes of the podcast received via JSON for the given @param id
	 * 
	 * If the podcast does not exist yet in the database (verified by <strong>id</strong>) then
	 * the application will try to create a new podcast resource in the db
	 * 
	 * @param id
	 * @param podcast
	 * @return
	 */
	@PUT @Path("{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_HTML})	
	public Response updatePodcastById(@PathParam("id") Long id, Podcast podcast) {
		if(podcast.getId() == null) podcast.setId(id);
		String message; 
		int status; 
		if(podcastWasUpdated(podcast)){
			status = 200; //OK
			message = "Podcast has been updated";
		} else if(podcastCanBeCreated(podcast)){
			podcastDao.createPodcast(podcast);
			status = 201; //Created 
			message = "The podcast you provided has been added to the database";
		} else {
			status = 406; //Not acceptable
			message = "The information you provided is not sufficient to perform either an UPDATE or "
					+ " an INSERTION of the new podcast resource <br/>"
					+ " If you want to UPDATE please make sure you provide an existent <strong>id</strong> <br/>"
					+ " If you want to insert a new podcast please provide at least a <strong>title</strong> and the <strong>feed</strong> for the podcast resource";
		}
		
		return Response.status(status).entity(message).build();		
	}

	private boolean podcastWasUpdated(Podcast podcast) {
		return podcastDao.updatePodcast(podcast) == 1;
	}

	private boolean podcastCanBeCreated(Podcast podcast) {
		return podcast.getFeed() != null && podcast.getTitle()!=null;
	}	
	
	/************************************ DELETE ************************************/
	@DELETE @Path("{id}")
	@Produces({MediaType.TEXT_HTML})
	public Response deletePodcastById(@PathParam("id") Long id) {
		String responseMessage;
		int status;
		if(podcastDao.deletePodcastById(id) == 1){
			responseMessage = "Podcast successfully removed";
			status = 204;
		} else {
			responseMessage = "Podcast with the id " + id + " is not present in the database";
			status = 404;
		}
				
		return Response.status(status).entity(responseMessage).build();
	}
	
	@DELETE
	@Produces({MediaType.TEXT_HTML})
	public Response deletePodcasts() {
		podcastDao.deletePodcasts();
		return Response.status(200).entity("All podcasts have been successfully removed").build();
	}	
	
	/************************************ PRIVATE METHODS ************************************/	
	/**
	 * Build html text pointing to the new created podcast resource
	 * 
	 * @param id
	 * @return
	 */
	private String buildNewPodcastResourceURL(Long id) {
		String podcastUrl = HOST + "/podcasts/" + String.valueOf(id);		
		StringBuffer message = new StringBuffer("A new podcast has been created at <a href=\"");
		message.append(podcastUrl);
		message.append("\"/>");
		message.append(podcastUrl);
		message.append("</a>");
		
		return message.toString();
	}	
}
