package org.codingpedia.demo.rest.entities;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Podcast entity 
 * 
 * @author ama
 *
 */
@XmlRootElement
public class Podcast implements Serializable {

	private static final long serialVersionUID = -8039686696076337053L;

	/** id of the podcas */
	private Long id;
	
	/** title of the podcast */
	private String title;
		
	/** link of the podcast on Podcastpedia.org */
	private String linkOnPodcastpedia;
	
	/** url of the feed */
	private String feed;
	
	/** description of the podcast */
	private String description; 
		
	/** when an episode was last published on the feed*/
	private Date insertionDate;

	public Podcast(){}
	
	public Podcast(String title, String linkOnPodcastpedia, String feed,
			String description) {
		
		this.title = title;
		this.linkOnPodcastpedia = linkOnPodcastpedia;
		this.feed = feed;
		this.description = description;
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLinkOnPodcastpedia() {
		return linkOnPodcastpedia;
	}

	public void setLinkOnPodcastpedia(String linkOnPodcastpedia) {
		this.linkOnPodcastpedia = linkOnPodcastpedia;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFeed() {
		return feed;
	}

	public void setFeed(String feed) {
		this.feed = feed;
	}

	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}
		
}
