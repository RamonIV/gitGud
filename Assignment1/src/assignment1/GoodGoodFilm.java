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
}
