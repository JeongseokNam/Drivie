package com.mypj.DAO;

import java.util.List;

import com.mypj.VO.FoodInTheaterVO;

public interface IF_FoodInTheaterDAO {

	List<FoodInTheaterVO> getFnTList()throws Exception;

	void addFnT(FoodInTheaterVO vo)throws Exception;

	void delFnT(int no)throws Exception;

	List<FoodInTheaterVO> getSearchFnTList(String searchWord)throws Exception;

	List<Integer> getFoodNoList(int setTheaterNo);

}
