package com.mypj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mypj.DAO.IF_MemberDAO;
import com.mypj.VO.MemberVO;

@Service
public class IF_MemberServiceImpl implements IF_MemberService{
	@Inject IF_MemberDAO memberDAO;
	
	@Override
	public String idChk(String id) throws Exception {
		return memberDAO.idChk(id);
	}

	@Override
	public void addMember(MemberVO vo) throws Exception {
		memberDAO.addMember(vo);
	}

	@Override
	public MemberVO getMemberInfo(String id) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.getMemberInfo(id);
	}

	@Override
	public void updateMemberInfo(MemberVO vo) throws Exception{
		// TODO Auto-generated method stub
		memberDAO.updateMemberInfo(vo);
	}

	@Override
	public List<MemberVO> getMemberList() throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.getMemberList();
	}

	@Override
	public void delMember(String id) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.deleteMember(id);
	}
	
}
