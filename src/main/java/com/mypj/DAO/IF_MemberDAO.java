package com.mypj.DAO;

import java.util.List;

import com.mypj.VO.MemberVO;

public interface IF_MemberDAO {

	String idChk(String id) throws Exception;

	void addMember(MemberVO vo) throws Exception;

	MemberVO getMemberInfo(String id) throws Exception;

	void updateMemberInfo(MemberVO vo)throws Exception;

	List<MemberVO> getMemberList()throws Exception;

	void deleteMember(String id)throws Exception;


}
