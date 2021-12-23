package com.mypj.Interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object grade = session.getAttribute("grade");//로그인을 하지않았거나, 일반회원일경우
			if (grade!=null) {
				if ((Integer)grade==0) {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('관리자가 아닙니다. 고객센터에 문의하세요.'); location.href='home';</script>");
					out.flush();
					return false;
				}
			}else if (grade==null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('관리자가 아닙니다. 고객센터에 문의하세요.'); location.href='home';</script>");
				out.flush();
				return false;
			}
		return true;
	}
}
