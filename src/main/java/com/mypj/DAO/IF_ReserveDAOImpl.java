package com.mypj.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mypj.VO.ReservationVO;

@Repository
public class IF_ReserveDAOImpl implements IF_ReserveDAO{
	@Inject SqlSession sqlSession;
	private String mapperQuerry="com.mypj.DAO.IF_ResrveDAO";
	@Override
	public void addReservatrion(ReservationVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(mapperQuerry+(".addReservatrion"),vo);
	}
	@Override
	public int getReserveNo() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapperQuerry+".getReserveNo");
	}
	@Override
	public List<ReservationVO> getMyList(String id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".getMyList",id);
	}
}
