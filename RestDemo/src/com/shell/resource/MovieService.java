package com.shell.resource;

import java.util.ArrayList;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.shell.bean.Movie;

@Path("/movie-service")
public class MovieService {	
	ArrayList<Movie> movies;
	
	public MovieService(){
		movies = new ArrayList<>();
		Movie movie1 = new Movie();
		movie1.setMovieId(101);
		movie1.setTitle("Bahubali");
		
		Movie movie2 = new Movie();
		movie2.setMovieId(102);
		movie2.setTitle("Super 30");
		
		Movie movie3 = new Movie();
		movie3.setMovieId(103);
		movie3.setTitle("Avengers");
		
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		
	}
	
	@GET
	@Path("/movies")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Movie> getMovies(){
		return movies;
	}
	
	@GET
	@Path("/movies/{moviename}")
	@Produces(MediaType.APPLICATION_JSON)	
	public Movie getMovieDetails(@PathParam("moviename") String title){
		Movie m = null;
		System.out.println(title);
		for(Movie movie : movies){
			if(movie.getTitle().equals(title)){
				m = movie;
				break;
			}
		}
		return m;
	}
	
	
	@POST
	@Path("add-movie")
	@Produces(MediaType.APPLICATION_JSON)   
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Movie> addMovie(Movie movie){
		movies.add(movie);
		return movies;
	}
	
	@POST
	@Path("a-movie")
	@Produces(MediaType.APPLICATION_JSON)   
	@Consumes(MediaType.APPLICATION_JSON)
	public Movie[] aMovie(Movie movie){
		Movie [] movies = new Movie[2];
		movies[0] = movie;
		movies[1] = movie;
		return movies;
	}
	
	
	
	
	
	
	
	
	
	
	

}
