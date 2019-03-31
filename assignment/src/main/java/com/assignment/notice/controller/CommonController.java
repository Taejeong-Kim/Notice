package com.assignment.notice.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {
	
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mv, HttpServletRequest req, HttpSession session) {
		// 이미 로그인 한 경우
		if(null != session.getAttribute("member")) {
			mv.setViewName("redirect:/NoticeList");
			return mv;
		}
		
		Cookie[] getCookie = req.getCookies();
		String saveId = null;
		if(getCookie != null) {
			for(int i=0; i<getCookie.length;i++) {
				Cookie c = getCookie[i];
				String name = c.getName();
				String value = c.getValue();
				if(name.equals("saveId")) saveId = value;
			}
		}
		mv.addObject("saveId",saveId);
		mv.setViewName("index");
		return mv;
	}
}
