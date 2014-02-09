package org.codingpedia.demo.rest.service.integration;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codingpedia.demo.rest.entities.Podcast;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Assert;
import org.junit.Test;

public class RestDemoServiceIT {

	@Test
	public void testGetPodcasts() throws JsonGenerationException,
			JsonMappingException, IOException {

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeature.class);

		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client
				.target("http://localhost:8888/demo-rest-spring-jersey-tomcat-mybatis-0.0.1-SNAPSHOT/podcasts/");

		Builder request = webTarget.request();
		request.header("Content-type", MediaType.APPLICATION_JSON);

		Response response = request.get();
		Assert.assertTrue(response.getStatus() == 200);

		List<Podcast> podcasts = response
				.readEntity(new GenericType<List<Podcast>>() {
				});

		ObjectMapper mapper = new ObjectMapper();
		System.out.print(mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(podcasts));

		Assert.assertTrue("At least one podcast is present",
				podcasts.size() > 0);
	}

	@Test
	public void testGetPodcast() throws JsonGenerationException,
			JsonMappingException, IOException {

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeature.class);

		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client
				.target("http://localhost:8888/demo-rest-spring-jersey-tomcat-mybatis-0.0.1-SNAPSHOT/podcasts/2");

		Builder request = webTarget.request(MediaType.APPLICATION_JSON);

		Response response = request.get();
		Assert.assertTrue(response.getStatus() == 200);

		Podcast podcast = response.readEntity(Podcast.class);

		ObjectMapper mapper = new ObjectMapper();
		System.out
				.print("Received podcast from database *************************** "
						+ mapper.writerWithDefaultPrettyPrinter()
								.writeValueAsString(podcast));

	}
}
