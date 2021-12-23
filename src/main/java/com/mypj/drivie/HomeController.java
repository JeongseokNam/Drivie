package com.mypj.drivie;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mypj.service.IF_ReserveService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Inject IF_ReserveService reserveService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "member/signUpForm";
	}
	
	@GetMapping("/signin")
	public String signin() {
		return "member/signInForm";
	}

	@GetMapping("/reserveChk")
	public String reserveChk(Model model,HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		model.addAttribute("reserveList",reserveService.getMyList(id));
		return "member/reserveChk";
	}
	
}
