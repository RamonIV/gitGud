package assignment1;

import java.sql.Date;

public class GoodGoodFilm {
	private String movieName;
	private String rating;
	private String releaseDate;
	private boolean wouldYouTakeTheFam;
	private int howManyDabsTaken;
	private float fidgetSpinnerTime;
	private String additionalComments;
	
	GoodGoodFilm(String movieName, String rating, String releaseDate, boolean wouldYouTakeTheFam, int howManyDabsTaken, float fidgetSpinnerTime, String additionalComments){
		this.movieName = movieName;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.wouldYouTakeTheFam = wouldYouTakeTheFam;
		this.howManyDabsTaken = howManyDabsTaken;
		this.fidgetSpinnerTime = fidgetSpinnerTime;
		this.additionalComments = additionalComments;
	}
	
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public boolean isWouldYouTakeTheFam() {
		return wouldYouTakeTheFam;
	}

	public void setWouldYouTakeTheFam(boolean wouldYouTakeTheFam) {
		this.wouldYouTakeTheFam = wouldYouTakeTheFam;
	}

	public int getHowManyDabsTaken() {
		return howManyDabsTaken;
	}

	public void setHowManyDabsTaken(int howManyDabsTaken) {
		this.howManyDabsTaken = howManyDabsTaken;
	}

	public float getFidgetSpinnerTime() {
		return fidgetSpinnerTime;
	}

	public void setFidgetSpinnerTime(float fidgetSpinnerTime) {
		this.fidgetSpinnerTime = fidgetSpinnerTime;
	}

	public String getAdditionalComments() {
		return additionalComments;
	}

	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}
	
}
