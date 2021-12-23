package com.mypj.DAO;

import java.util.List;

import com.mypj.VO.TheaterVO;

public interface IF_TheaterDAO {

	void insertTheater(TheaterVO vo)throws Exception;

	List<TheaterVO> getTheaterList()throws Exception;

	TheaterVO selectTheater(int no)throws Exception;

	void updateTheater(TheaterVO vo)throws Exception;

	void deleteTheater(int no)throws Exception;

	List<TheaterVO> searchTheater(String searchWord)throws Exception;

}
