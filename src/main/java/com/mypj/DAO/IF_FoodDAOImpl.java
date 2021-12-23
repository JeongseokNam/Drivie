package com.mypj.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mypj.VO.FoodVO;

@Repository
public class IF_FoodDAOImpl implements IF_FoodDAO{
	@Inject SqlSession sqlSession;
	private String mapperQuerry="com.mypj.DAO.IF_FoodDAO";
	@Override
	public List<FoodVO> getFoodList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".selectFoodList");
	}
	@Override
	public void addFood(FoodVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(mapperQuerry+".insertFood",vo);
	}
	@Override
	public FoodVO selectFood(int no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapperQuerry+".selectFood",no);
	}
	@Override
	public void modFood(FoodVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(mapperQuerry+".updateFood",vo);
	}
	@Override
	public void delFood(int no) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(mapperQuerry+".deleteFood",no);
	}
	@Override
	public List<FoodVO> searchFood(String searchWord) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".searchFood",searchWord);
	}
}
