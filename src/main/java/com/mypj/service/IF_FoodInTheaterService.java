package com.mypj.service;

import java.util.List;

import com.mypj.VO.FoodInTheaterVO;

public interface IF_FoodInTheaterService {

	List<FoodInTheaterVO> getFnTList()throws Exception;

	void addFnT(FoodInTheaterVO vo)throws Exception;

	void delFnT(int no)throws Exception;

	List<FoodInTheaterVO> getSearchFnTList(String searchWord)throws Exception;


}
