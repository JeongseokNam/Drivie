package com.mypj.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mypj.VO.MemberVO;

@Repository
public class IF_MemberDAOImpl implements IF_MemberDAO{
@Inject SqlSession sqlSession;

	private String mapperQuerry="com.mypj.DAO.IF_MemberDAO";
	
	@Override
	public String idChk(String id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapperQuerry+".idChk",id);
	}

	@Override
	public void addMember(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(mapperQuerry+".insertMember",vo);
	}

	@Override
	public MemberVO getMemberInfo(String id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapperQuerry+".selectMemberInfo", id);
	}

	@Override
	public void updateMemberInfo(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(mapperQuerry+".updateMemberInfo",vo);
	}

	@Override
	public List<MemberVO> getMemberList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuerry+".selectMemberList");
	}

	@Override
	public void deleteMember(String id) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(mapperQuerry+".deleteMember",id);
	}


}
