package com.mypj.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mypj.VO.TheaterVO;

@Repository
public class IF_TheaterDAOImpl implements IF_TheaterDAO{
	@Inject SqlSession sqlSession;
	private String mapperQuerry = "com.mypj.DAO.IF_TheaterDAO";
	@Override
	public void insertTheater(TheaterVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(mapperQuerry+".insertTheater",vo);
	}
	@Override
	public List<TheaterVO> getTheaterList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".getTheaterList");
	}
	@Override
	public TheaterVO selectTheater(int no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapperQuerry+".selectTheater",no);
	}
	@Override
	public void updateTheater(TheaterVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(mapperQuerry+".updateTheater",vo);
	}
	@Override
	public void deleteTheater(int no) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(mapperQuerry+".deleteTheater",no);
	}
	@Override
	public List<TheaterVO> searchTheater(String searchWord) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".searchTheater",searchWord);
	}
}
