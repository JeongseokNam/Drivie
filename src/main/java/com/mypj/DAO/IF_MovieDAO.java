package com.mypj.DAO;

import java.util.List;

import com.mypj.VO.MovieVO;

public interface IF_MovieDAO {

	void insertMovie(MovieVO vo) throws Exception;
	
	int getMovieNo()throws Exception;

	List<MovieVO> getMovieList() throws Exception;

	MovieVO selectMovie(int no) throws Exception;

	void modMovie(MovieVO vo)throws Exception;

	void delMovie(int no)throws Exception;

	List<MovieVO> searchMovie(String searchWord) throws Exception;
}
