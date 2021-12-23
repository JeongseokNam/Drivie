package com.mypj.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mypj.VO.MovieVO;

@Repository
public class IF_MovieDAOImlp implements IF_MovieDAO {
	@Inject
	SqlSession sqlSession;

	private String mapperQuerry = "com.mypj.DAO.IF_MovieDAO";

	@Override
	public void insertMovie(MovieVO vo) throws Exception {
		sqlSession.insert(mapperQuerry+".insertMovie",vo);

	}

	@Override
	public int getMovieNo() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapperQuerry+".getMovieNo");
	}

	@Override
	public List<MovieVO> getMovieList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".getMovieList");
	}

	@Override
	public MovieVO selectMovie(int no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapperQuerry+".selectMovie",no);
	}

	@Override
	public void modMovie(MovieVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(mapperQuerry+".updateMovie",vo);
	}

	@Override
	public void delMovie(int no) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(mapperQuerry+".deleteMovie",no);
	}

	@Override
	public List<MovieVO> searchMovie(String searchWord) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".searchMovie",searchWord);
	}
}
