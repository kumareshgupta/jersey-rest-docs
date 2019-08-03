package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/welcome")
public class Welcome {
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String welcomeMeXML() {
		String resource = "<?xml version='1.0' ?>" + " <welcome>Welcome To All</welcome>";
		return resource;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String welcomeMeHTML() {
		String resource = "<!DOCTYPE html>\r\n" + 
				"<HTML><BODY>" + " <H1>Welcome To All HT  </H1>" + "</BODY></HTML>";
		return resource;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String welcomeMePLAIN() {
		String resource = "Welcome To All test";
		return resource;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String welcomeMeJSON() {
		String resource = "Welcome To All";
		return resource;
	}
	
	@GET
	@Path("/user/{username}")
	@Produces(MediaType.TEXT_HTML)
	public String getUser(@PathParam("username") String userName) {
		return "<H2>Welcome " + userName + "</H2>";
	}
	
	
}
