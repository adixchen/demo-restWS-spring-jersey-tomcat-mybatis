package org.codingpedia.demo.rest.service;
import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class PodcastRestServiceTestWithRestAssured {

	@Test
	public void testPodcastFetchSuccessful(){
		expect().
			body("id", equalTo("2")).
			body("title", equalTo("- The Naked Scientists Podcast - Stripping Down Science")).
		when().
			get("/demo-rest-spring-jersey-tomcat-mybatis-0.0.1-SNAPSHOT/podcasts/2");
	}
}
