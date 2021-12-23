package com.mypj.drivie;

import java.util.HashMap;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mypj.VO.MemberVO;
import com.mypj.service.IF_MemberService;

@Controller
public class MemberController{
	@Inject
	IF_MemberService memberService;
	
	
	
	@PostMapping("/idChk")
	@ResponseBody 
	public String idChk(@RequestParam("id") String id) throws Exception{
		String tempId=memberService.idChk(id);
		return tempId;
	}
	
	@PostMapping("/signUp")
	public String signUp(MemberVO vo) throws Exception{
		memberService.addMember(vo);
		return "redirect:/home";
	}
	
	@PostMapping("/signIn")
	public String signIn(MemberVO vo) throws Exception{
		memberService.addMember(vo);
		return "redirect:/home";
	}
	@PostMapping("/memberChk")
	@ResponseBody
	public String memberChk(HttpServletRequest request) throws Exception {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberVO tempVo = memberService.getMemberInfo(id);
		String tempUrl=null;
		if (tempVo!=null) {
			if (pw.equals(tempVo.getPw())) {
				HttpSession session = request.getSession();
				session.setAttribute("no", tempVo.getNo());
				session.setAttribute("name", tempVo.getName());
				session.setAttribute("id", tempVo.getId());
				session.setAttribute("grade", tempVo.getGrade());
				tempUrl="home";
			}
		}
		return tempUrl;
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		session.invalidate();	
		return "redirect:/home";		
	}
	@GetMapping("/memberInfo")
	public String memberInfo(HttpServletRequest request,Model model) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		model.addAttribute("vo",memberService.getMemberInfo(id));
		return "member/memberInfo";
	}
	@PostMapping("/modMemberInfo")
	public String modMemberInfo(MemberVO vo)throws Exception{
		memberService.updateMemberInfo(vo);
		return "redirect:/memberInfo";
	}
	
	
}
