package com.mypj.DAO;

import java.util.List;

import com.mypj.VO.MovieInTheaterVO;

public interface IF_MovieInTheaterDAO {

	void addMnT(MovieInTheaterVO vo)throws Exception;

	List<MovieInTheaterVO> getMnTList()throws Exception;

	void delMnT(int no)throws Exception;

	List<MovieInTheaterVO> theaterSearchList(String searchWord)throws Exception;

	List<MovieInTheaterVO> getTheaterListByMovie(int movieNo)throws Exception;

	List<MovieInTheaterVO> getShowTimeLisetByMnT(MovieInTheaterVO vo)throws Exception;

}
