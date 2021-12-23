package com.mypj.service;

import java.util.List;

import com.mypj.VO.FoodVO;

public interface IF_FoodService {

	List<FoodVO> getFoodList() throws Exception;

	void addFood(FoodVO vo)throws Exception;

	FoodVO selectFood(int no)throws Exception;

	void modFood(FoodVO vo)throws Exception;

	void delFood(int no)throws Exception;

	List<FoodVO> searchFood(String searchWord)throws Exception;

	List<FoodVO> getFoodListByTheaterNo(int setTheaterNo)throws Exception;

}
