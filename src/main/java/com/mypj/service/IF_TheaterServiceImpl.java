package com.mypj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mypj.DAO.IF_TheaterDAO;
import com.mypj.VO.TheaterVO;

@Service
public class IF_TheaterServiceImpl implements IF_TheaterService{
	@Inject IF_TheaterDAO theaterDAO;
	
	@Override
	public void addTheater(TheaterVO vo) throws Exception {
		// TODO Auto-generated method stub
		theaterDAO.insertTheater(vo);
	}

	@Override
	public List<TheaterVO> getTheaterList() throws Exception {
		// TODO Auto-generated method stub
		return theaterDAO.getTheaterList();
	}

	@Override
	public TheaterVO selectTheater(int no) throws Exception {
		// TODO Auto-generated method stub
		return theaterDAO.selectTheater(no);
	}

	@Override
	public void modTheater(TheaterVO vo) throws Exception {
		// TODO Auto-generated method stub
		theaterDAO.updateTheater(vo);
	}

	@Override
	public void delTheater(int no) throws Exception {
		// TODO Auto-generated method stub
		theaterDAO.deleteTheater(no);
	}

	@Override
	public List<TheaterVO> searchTheater(String searchWord) throws Exception {
		// TODO Auto-generated method stub
		return theaterDAO.searchTheater(searchWord);
	}

	
	
}
