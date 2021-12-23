package com.mypj.service;

import java.util.List;

import com.mypj.VO.TheaterVO;

public interface IF_TheaterService {

	void addTheater(TheaterVO vo)throws Exception;

	List<TheaterVO> getTheaterList()throws Exception;

	TheaterVO selectTheater(int no)throws Exception;

	void modTheater(TheaterVO vo)throws Exception;

	void delTheater(int no)throws Exception;

	List<TheaterVO> searchTheater(String searchWord)throws Exception;



}
