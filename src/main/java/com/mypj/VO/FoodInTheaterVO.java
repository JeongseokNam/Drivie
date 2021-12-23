package com.mypj.VO;

public class FoodInTheaterVO {
	int no = 0;
	int food_no = 0;
	int theater_no = 0;
	
	private FoodVO foodVO;
	private TheaterVO theaterVO;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getFood_no() {
		return food_no;
	}
	public void setFood_no(int food_no) {
		this.food_no = food_no;
	}
	public int getTheater_no() {
		return theater_no;
	}
	public void setTheater_no(int theater_no) {
		this.theater_no = theater_no;
	}
	public FoodVO getFoodVO() {
		return foodVO;
	}
	public void setFoodVO(FoodVO foodVO) {
		this.foodVO = foodVO;
	}
	public TheaterVO getTheaterVO() {
		return theaterVO;
	}
	public void setTheaterVO(TheaterVO theaterVO) {
		this.theaterVO = theaterVO;
	}
}
