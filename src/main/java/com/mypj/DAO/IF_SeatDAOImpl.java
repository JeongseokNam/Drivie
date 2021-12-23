package com.mypj.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mypj.VO.SeatFlagVO;
import com.mypj.VO.SeatVO;

@Repository
public class IF_SeatDAOImpl implements IF_SeatDAO{
	@Inject SqlSession sqlSession;
	private String mapperQuerry = "com.mypj.DAO.IF_SeatDAO";
	@Override
	public SeatVO getSeatList(int setMnTNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapperQuerry+".getSeatList", setMnTNo);
	}
	@Override
	public List<SeatFlagVO> getSeatFlag(int setMnTNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".getSeatFlag", setMnTNo);
	}
}
