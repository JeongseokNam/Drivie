package com.mypj.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.mypj.VO.FoodInTheaterVO;

@Service
public class IF_FoodInTheaterDAOImpl implements IF_FoodInTheaterDAO{
	@Inject SqlSession sqlSession;
	private String mapperQuerry = "com.mypj.DAO.IF_FoodInTheaterDAO";
	@Override
	public List<FoodInTheaterVO> getFnTList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".getFnTList");
	}
	@Override
	public void addFnT(FoodInTheaterVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(mapperQuerry+".insertFnt",vo);
	}
	@Override
	public void delFnT(int no) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(mapperQuerry+".deleteFnT",no);
	}
	@Override
	public List<FoodInTheaterVO> getSearchFnTList(String searchWord) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".searchListe",searchWord);
	}
	@Override
	public List<Integer> getFoodNoList(int setTheaterNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".getFoodNoList",setTheaterNo);
	}
}
