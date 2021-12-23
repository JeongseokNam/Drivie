package com.mypj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mypj.DAO.IF_MovieDAO;
import com.mypj.VO.MovieVO;

@Service
public class IF_MovieServiceImpl implements IF_MovieService {
	@Inject
	IF_MovieDAO movieDAO;

	@Override
	public void addMovie(MovieVO vo) throws Exception {
		int nowNo=movieDAO.getMovieNo();
		vo.setNo(nowNo);		
		movieDAO.insertMovie(vo);

	}

	@Override
	public List<MovieVO> getMovieList() throws Exception {
		// TODO Auto-generated method stub
		return movieDAO.getMovieList();
	}

	@Override
	public MovieVO selectMovie(int no) throws Exception {
		// TODO Auto-generated method stub
		return movieDAO.selectMovie(no);
	}

	@Override
	public void modMovie(MovieVO vo) throws Exception {
		// TODO Auto-generated method stub
		movieDAO.modMovie(vo);
	}

	@Override
	public void delMovie(int no) throws Exception {
		// TODO Auto-generated method stub
		movieDAO.delMovie(no);
	}

	@Override
	public List<MovieVO> searchMovie(String searchWord) throws Exception {
		// TODO Auto-generated method stub
		return movieDAO.searchMovie(searchWord);
	}

}
