package org.codingpedia.demo.rest.service;

import org.codingpedia.demo.rest.util.CORSResponseFilter;
import org.codingpedia.demo.rest.util.LoggingResponseFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * Registers the components to be used by the JAX-RS application  
 * 
 * @author ama
 *
 */
public class MyDemoApplication extends ResourceConfig {

    /**
	* Register JAX-RS application components.
	*/	
	public MyDemoApplication(){
		register(RequestContextFilter.class);
		register(PodcastRestService.class);
		register(JacksonFeature.class);		
		register(LoggingResponseFilter.class);
		register(CORSResponseFilter.class);
	}
}
