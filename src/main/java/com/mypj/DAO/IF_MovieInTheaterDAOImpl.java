package com.mypj.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mypj.VO.MovieInTheaterVO;

@Repository
public class IF_MovieInTheaterDAOImpl implements IF_MovieInTheaterDAO{
	@Inject
	SqlSession sqlSession;
	private String mapperQuerry = "com.mypj.DAO.IF_MovieInTheaterDAO";
	@Override
	public void addMnT(MovieInTheaterVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(mapperQuerry+".insertMnT",vo);
	}
	@Override
	public List<MovieInTheaterVO> getMnTList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".getMnTList");
	}
	@Override
	public void delMnT(int no) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(mapperQuerry+".deleteMnT",no);
	}
	@Override
	public List<MovieInTheaterVO> theaterSearchList(String searchWord) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".theaterSearchList",searchWord);
	}
	@Override
	public List<MovieInTheaterVO> getTheaterListByMovie(int movieNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".getTheaterListByMovie",movieNo);
	}
	@Override
	public List<MovieInTheaterVO> getShowTimeLisetByMnT(MovieInTheaterVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".getShowTimeLisetByMnT",vo);
	}
}
