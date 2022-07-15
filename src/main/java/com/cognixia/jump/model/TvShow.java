package com.cognixia.jump.model;

// model to be used in a future DAO class
public class TvShow {
	
	// TvShow model has a variable based on every column in the table
	// The table is named "tv_show"comes from the "progress_tracker" database
	private int id;
	private String name;
	private String leadingActor;
	private String director;
	private int numOfSeasons;
	private int numOfEpisodes;
	private String genre;
	private int audienceScore;
	private String rating;
	private String firstEpisodeName;
	private String status;
	
	// Two default constructors that are to create new objects of this class
	public TvShow() {
		this(-1, "NA", "NA", "NA", 0, 0, "NA", 0, "NA", "NA", "NA");
	}
	
	// This constructor was auto-generated
	public TvShow(int id, String name, String leadingActor, String director, int numOfSeasons, int numOfEpisodes,
			String genre, int audienceScore, String rating, String firstEpisodeName, String status) {
		super();
		this.id = id;
		this.name = name;
		this.leadingActor = leadingActor;
		this.director = director;
		this.numOfSeasons = numOfSeasons;
		this.numOfEpisodes = numOfEpisodes;
		this.genre = genre;
		this.audienceScore = audienceScore;
		this.rating = rating;
		this.firstEpisodeName = firstEpisodeName;
		this.status = status;
	}

	// A list of auto-generated getter and setter functions for every variable 
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeadingActor() {
		return leadingActor;
	}

	public void setLeadingActor(String leadingActor) {
		this.leadingActor = leadingActor;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getNumOfSeasons() {
		return numOfSeasons;
	}

	public void setNumOfSeasons(int numOfSeasons) {
		this.numOfSeasons = numOfSeasons;
	}

	public int getNumOfEpisodes() {
		return numOfEpisodes;
	}

	public void setNumOfEpisodes(int numOfEpisodes) {
		this.numOfEpisodes = numOfEpisodes;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getAudienceScore() {
		return audienceScore;
	}

	public void setAudienceScore(int audienceScore) {
		this.audienceScore = audienceScore;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFirstEpisodeName() {
		return firstEpisodeName;
	}

	public void setFirstEpisodeName(String firstEpisodeName) {
		this.firstEpisodeName = firstEpisodeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// Overriden toString() method to display any object of this class
	@Override
	public String toString() {
		return "TvShow [id=" + id + ", name=" + name + ", leadingActor=" + leadingActor + ", director=" + director
				+ ", numOfSeasons=" + numOfSeasons + ", numOfEpisodes=" + numOfEpisodes + ", genre=" + genre
				+ ", audienceScore=" + audienceScore + ", rating=" + rating + ", firstEpisodeName=" + firstEpisodeName
				+ ", status=" + status + "]";
	}
	
}
