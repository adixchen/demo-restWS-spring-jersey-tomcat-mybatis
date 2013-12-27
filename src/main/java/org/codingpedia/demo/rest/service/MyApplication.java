package org.codingpedia.demo.rest.service;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class MyApplication extends ResourceConfig {

    /**
	* Register JAX-RS application components.
	*/	
	public MyApplication(){
		register(RequestContextFilter.class);
		register(PodcastRestService.class);
		register(JacksonFeature.class);
		
	}
}
