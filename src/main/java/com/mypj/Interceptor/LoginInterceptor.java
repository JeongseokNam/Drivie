package com.mypj.Interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(); // 세션id가져오기
		Object grade = session.getAttribute("grade");//로그인을 하지않았거나, 관리자일경우
		if (grade == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인을 해주세요.'); location.href='home';</script>");
			out.flush();
			return false;
		}else if ((Integer)grade==1||(Integer)grade==2) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('관리자 계정입니다. 관리자페이지로 이동합니다.'); location.href='admin';</script>");
			out.flush();
			return false;
		}
		return true;
	}

}
