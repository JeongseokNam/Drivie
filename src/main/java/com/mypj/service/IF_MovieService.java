package com.mypj.service;

import java.util.List;

import com.mypj.VO.MovieVO;
import com.mypj.VO.TheaterVO;

public interface IF_MovieService {

	void addMovie(MovieVO vo)throws Exception;

	List<MovieVO> getMovieList()throws Exception;

	MovieVO selectMovie(int no) throws Exception;

	void modMovie(MovieVO vo)throws Exception;

	void delMovie(int no)throws Exception;

	List<MovieVO> searchMovie(String searchWord)throws Exception;

}
