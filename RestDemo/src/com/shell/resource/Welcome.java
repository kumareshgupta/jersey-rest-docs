package com.shell.resource;

import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/welcome")
public class Welcome {

	@GET
	//@Produces("text/plain")
	@Produces(MediaType.TEXT_PLAIN)
	public String welcomeMe(){
		return "Welcome to Jersey World";
	}
	
	@GET
	//@Produces("text/xml")
	@Produces(MediaType.TEXT_XML)
	public String welcomeMeXML(){
		String message = "<?xml version='1.0' ?>" 
				+ "<welcome>Welcome to Jersey</welcome>";  
		return message;
	}
	
	@GET
	@Path("{username}")
	//@Produces("text/html")
	@Produces(MediaType.TEXT_HTML)
	public String welcomeMeHTML(@PathParam("username") String userName){
		String message = "<html><body>" 
				+ "<h1>" + userName.toUpperCase() + "! Welcome to Jersey</h1>"
				+ "</body></html>";  
		return message;
	}
	
	
	
}
