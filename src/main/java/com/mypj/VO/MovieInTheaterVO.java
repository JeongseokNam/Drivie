package com.mypj.VO;

public class MovieInTheaterVO {
	private int no = 0;
	private int movie_no = 0;
	private int theater_no = 0;
	private String showtime=null;
	
	private MovieVO movieVO;
	private TheaterVO theaterVO;
	
	public MovieVO getMovieVO() {
		return movieVO;
	}
	public void setMovieVO(MovieVO movieVO) {
		this.movieVO = movieVO;
	}
	public TheaterVO getTheaterVO() {
		return theaterVO;
	}
	public void setTheaterVO(TheaterVO theaterVO) {
		this.theaterVO = theaterVO;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getMovie_no() {
		return movie_no;
	}
	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}
	public int getTheater_no() {
		return theater_no;
	}
	public void setTheater_no(int theater_no) {
		this.theater_no = theater_no;
	}
	public String getShowtime() {
		return showtime;
	}
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}
}
