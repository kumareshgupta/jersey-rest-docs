package com.rs.demo;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/authorservice")
public class AuthorService {

	private  ArrayList<Author> authorsList;
	
	//public AuthorService() 
	{
		authorsList = new ArrayList<>();
		Author author1 = new Author();
		author1.setId(110);
		author1.setName("Aniruddh");
		author1.setSalary(52000.00);
		
		Author author2 = new Author();
		author2.setId(120);
		author2.setName("Shashwat");
		author2.setSalary(45000.00);
		
		Author author3 = new Author();
		author3.setId(130);
		author3.setName("Kumaresh");
		author3.setSalary(35000.00);
		
		authorsList.add(author1);
		authorsList.add(author2);
		authorsList.add(author3);
		
	}
	
	@GET
	@Path("authors")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
	//@Produces(MediaType.APPLICATION_XML)

	public ArrayList<Author> displayAuthors(){
		return authorsList;
	}
	
	@GET
	@Path("total-salary")
	@Produces(MediaType.APPLICATION_JSON)
	public double totalSalary() {
		double salary = 0.0;
		for(Author author : authorsList) {
			salary = salary + author.getSalary();
		}
		return salary;
	}
	
	@GET
	@Path("author-salary/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public double authorSalary(@PathParam("name") String authorName) {
		double salary = 0.0;
		for(Author author : authorsList) {
			if(author.getName().equals(authorName)) {
				salary = author.getSalary();
				break;
			}
		}
		return salary;
	}
	
	@GET
	@Path("authors/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Author authorDetails(@PathParam("name") String authorName) {
		//Author author = new Author();
		for(Author author : authorsList) {
			if(author.getName().equals(authorName)) {
				return author;
			}
		}
		return null;
	}
	
	
	
	@POST
	@Path("add-author")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Author> addAuthor(@Context HttpHeaders httpHeaders, Author author) {
		System.out.println(httpHeaders.getRequestHeaders().toString());
		System.out.println(httpHeaders.getHeaderString("Accept"));
		System.out.println(httpHeaders.getLength());
		authorsList.add(author);
		System.out.println(authorsList);
		//return Response.ok(authorsList).build();
		return authorsList;
	}
	
}
