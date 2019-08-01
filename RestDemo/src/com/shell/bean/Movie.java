package com.shell.bean;

public class Movie {
	private int movieId;
	private String title;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + "]";
	}
	
	
}
