package com.mypj.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mypj.DAO.IF_FoodDAO;
import com.mypj.DAO.IF_FoodInTheaterDAO;
import com.mypj.VO.FoodVO;

@Service
public class IF_FoodServiceImpl implements IF_FoodService{
@Inject IF_FoodDAO foodDAO;
@Inject IF_FoodInTheaterDAO FnTDAO;
	@Override
	public List<FoodVO> getFoodList() throws Exception {
		// TODO Auto-generated method stub
		return foodDAO.getFoodList();
	}

	@Override
	public void addFood(FoodVO vo) throws Exception{
		// TODO Auto-generated method stub
		foodDAO.addFood(vo);
	}

	@Override
	public FoodVO selectFood(int no) throws Exception {
		// TODO Auto-generated method stub
		return foodDAO.selectFood(no);
	}

	@Override
	public void modFood(FoodVO vo) throws Exception {
		// TODO Auto-generated method stub
		foodDAO.modFood(vo);
	}

	@Override
	public void delFood(int no) throws Exception {
		// TODO Auto-generated method stub
		foodDAO.delFood(no);
	}

	@Override
	public List<FoodVO> searchFood(String searchWord) throws Exception {
		// TODO Auto-generated method stub
		return foodDAO.searchFood(searchWord);
	}

	@Override
	public List<FoodVO> getFoodListByTheaterNo(int setTheaterNo) throws Exception {
		
		return foodDAO.getFoodList();
	}
}
