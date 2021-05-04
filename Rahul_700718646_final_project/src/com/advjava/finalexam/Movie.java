package com.advjava.finalexam;
public class Movie {

	protected int movie_id;
	protected String movie_name;
	protected String seats_available;
	protected String price;
	protected String rating;
	protected String theatre_screen;
	
	
	
	public Movie(int movie_id, String movie_name, String seats_available, String price, String rating,
			String theatre_screen) {
		super();
		this.movie_id = movie_id;
		this.movie_name = movie_name;
		this.seats_available = seats_available;
		this.price = price;
		this.rating = rating;
		this.theatre_screen = theatre_screen;
	}
	
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getMovie_id() {
	return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getSeats_available() {
		return seats_available;
	}
	public void setSeats_available(String seats_available) {
		this.seats_available = seats_available;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getTheatre_screen() {
		return theatre_screen;
	}
	public void setTheatre_screen(String theatre_screen) {
		this.theatre_screen = theatre_screen;
	}
	
	
	
	}

