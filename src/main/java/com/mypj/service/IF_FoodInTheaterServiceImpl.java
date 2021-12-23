package com.mypj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mypj.DAO.IF_FoodDAO;
import com.mypj.DAO.IF_FoodInTheaterDAO;
import com.mypj.VO.FoodInTheaterVO;

@Service
public class IF_FoodInTheaterServiceImpl implements IF_FoodInTheaterService{
	@Inject IF_FoodInTheaterDAO FnTDAO;

	@Override
	public List<FoodInTheaterVO> getFnTList() throws Exception {
		// TODO Auto-generated method stub
		return FnTDAO.getFnTList();
	}

	@Override
	public void addFnT(FoodInTheaterVO vo) throws Exception {
		// TODO Auto-generated method stub
		FnTDAO.addFnT(vo);
	}

	@Override
	public void delFnT(int no) throws Exception {
		// TODO Auto-generated method stub
		FnTDAO.delFnT(no);
	}

	@Override
	public List<FoodInTheaterVO> getSearchFnTList(String searchWord) throws Exception {
		// TODO Auto-generated method stub
		return FnTDAO.getSearchFnTList(searchWord);
	}
}
