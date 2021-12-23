package com.mypj.service;

import java.util.List;

import com.mypj.VO.MemberVO;

public interface IF_MemberService {
	
	String idChk(String id) throws Exception;

	void addMember(MemberVO vo) throws Exception;

	MemberVO getMemberInfo(String id) throws Exception;

	void updateMemberInfo(MemberVO vo) throws Exception;

	List<MemberVO> getMemberList()throws Exception;

	void delMember(String id)throws Exception;


}
