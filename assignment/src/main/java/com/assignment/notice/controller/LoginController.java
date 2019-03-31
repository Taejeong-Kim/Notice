package com.assignment.notice.controller;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assignment.notice.model.dto.MemberDTO;
import com.assignment.notice.service.MemberService;

@Controller
public class LoginController {
	
	@Inject
	MemberService memberService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginCheck(ModelAndView mv, MemberDTO user, HttpServletRequest req, 
												HttpServletResponse resp, HttpSession session) {
		MemberDTO member = memberService.getMember(user);

		if(null == member) {
			mv.addObject("message", "아이디 혹은 비밀번호를 확인해주세요.");
			mv.addObject("href","/");
			mv.setViewName("comMessage");
		} else {
			session.setAttribute("member", user);
			String saveId = req.getParameter("saveId");
			if(null != saveId) {
				// 아이디 저장
				Cookie setCookie = new Cookie("saveId", user.getUser_id());
				setCookie.setMaxAge(7*24*60*60);
				resp.addCookie(setCookie);
			} else {
				// 쿠키 saveId의 value를 null로 설정.
				Cookie ck = new Cookie("saveId", null);
				// 유효시간을 0으로 설정 후 추가.
				ck.setMaxAge(0);
				resp.addCookie(ck);
			}
			mv.setViewName("redirect:/NoticeList");
		}
		return mv;
	}
	
	@RequestMapping(value="/logout")
	public ModelAndView logOut(ModelAndView mv, HttpSession session) {
		session.invalidate();
		
		mv.addObject("message","로그아웃 되었습니다.");
		mv.addObject("href","/");
		mv.setViewName("comMessage");
		
		return mv;
	}
}
