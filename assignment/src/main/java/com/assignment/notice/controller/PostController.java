package com.assignment.notice.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assignment.notice.model.dto.MemberDTO;
import com.assignment.notice.model.dto.PostDTO;
import com.assignment.notice.service.PostService;

@Controller
public class PostController {
	
	@Inject
	PostService postService;
	
	@RequestMapping(value="/NoticeList", method=RequestMethod.GET)
	public ModelAndView NoticeList(ModelAndView mv, HttpSession session, HttpServletRequest req) {
		if(!isLogin(session)) {
			mv.addObject("message","먼저 로그인을 해주세요.");
			mv.addObject("href","/");
			mv.setViewName("comMessage");
			return mv;
		}
		
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		if("admin".equals(member.getUser_id())) mv.addObject("isAdmin","true");
		
		String pageStr = req.getParameter("page");
		try {Integer.parseInt(pageStr);} catch(Exception e) {pageStr = "1";}
		if(StringUtils.isEmpty(pageStr)|| Integer.parseInt(pageStr) < 1) pageStr = "1";
		
		int page = Integer.parseInt(pageStr);		// 현재 페이지
		int postAllCnt = postService.getAllCount();	// 전체 글 개수
		int postPerPage = 10;						// 한 페이지 당 출력 개수
		int pageAllCnt = postAllCnt / postPerPage;	// 총 페이지 
		int pageCnt = 5;							// 하단 출력 페이지 개수
		
		if(postAllCnt % postPerPage > 0) pageAllCnt++;	// 추가 페이지
		if(pageAllCnt < page) page = pageAllCnt;	// 총 페이지 수보다 큰 페이지로 접근할 경우
		
		int startPage = ((page-1) / pageCnt) * pageCnt + 1;	// 시작 페이지
		int endPage = startPage + pageCnt - 1;
		
		if (endPage > pageAllCnt) {
		    endPage = pageAllCnt;
		}
		int startPostNo = (page-1) * postPerPage + 1;
		int endPostNo = page * postPerPage;
		
		List<PostDTO> noticeList = postService.postList(startPostNo, endPostNo);
		
		mv.addObject("noticeList", noticeList);
		mv.addObject("pageAllCnt", pageAllCnt);
		mv.addObject("startPage", startPage);
		mv.addObject("endPage", endPage);
		mv.addObject("currPage",page);
		mv.setViewName("noticeList");
		return mv;
	}
	
	@RequestMapping("/NoticeWrite")
	public ModelAndView NoticeWrite(ModelAndView mv, HttpSession session) {
		if(!isLogin(session)) {
			mv.addObject("message","먼저 로그인을 해주세요.");
			mv.addObject("href","/");
			mv.setViewName("comMessage");
			return mv;
		}
		
		mv.setViewName("noticeWrite");
		
		return mv;
	}
	
	@RequestMapping(value="/NoticeInsert", method=RequestMethod.POST)
	public ModelAndView NoticeInsert(ModelAndView mv, PostDTO post, HttpSession session) {
		if(!isLogin(session)) {
			mv.addObject("message","먼저 로그인을 해주세요.");
			mv.addObject("href","/");
			mv.setViewName("comMessage");
			return mv;
		}
		
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		post.setWriter(member.getUser_id());
		
		int res = postService.insertPost(post);
		
		if(res > 0) mv.addObject("message","저장되었습니다.");
		else mv.addObject("message","에러가 발생하였습니다.");
		
		mv.addObject("href","NoticeList");
		mv.setViewName("comMessage");
		
		return mv;
	}
	
	@RequestMapping(value="/NoticeView", method=RequestMethod.GET)
	public ModelAndView NoticeView(ModelAndView mv, HttpServletRequest req, HttpSession session) {
		if(!isLogin(session)) {
			mv.addObject("message","먼저 로그인을 해주세요.");
			mv.addObject("href","/");
			mv.setViewName("comMessage");
			return mv;
		}
		
		String postNo = req.getParameter("post_no");
		try {Integer.parseInt(postNo);} catch(Exception e) {postNo = null;}
		if(null == postNo) {
			mv.setViewName("redirect:/NoticeList");
			return mv;
		}
		
		PostDTO post = postService.getPost(Integer.parseInt(postNo));
		
		// 주소 직접 입력 방지
		if(null == post) {
			mv.addObject("message","잘못된 접근입니다.");
			mv.addObject("href","/");
			mv.setViewName("comMessage");
			return mv;
		}
		
		postService.increaseCount(post.getPostNo());
		
		mv.addObject("post", post);
		mv.setViewName("noticeView");
		return mv;
	}
	
	@RequestMapping(value="/NoticeUpdate", method=RequestMethod.POST)
	public ModelAndView NoticeUpdate(ModelAndView mv, PostDTO post, HttpSession session) {
		
		if(!isLogin(session)) {
			mv.addObject("message","먼저 로그인을 해주세요.");
			mv.addObject("href","/");
			mv.setViewName("comMessage");
			return mv;
		}
		
		if(null == post) {
			mv.addObject("message","잘못된 접근입니다.");
			mv.addObject("href","/");
			mv.setViewName("comMessage");
			return mv;
		}
		
		post = postService.getPost(post.getPostNo());
		
		mv.addObject("post", post);
		mv.addObject("mode", "mdfy");
		mv.setViewName("noticeWrite");
		return mv;
	}
	
	@RequestMapping(value="/NoticeUpdate_Ok", method=RequestMethod.POST)
	public ModelAndView NoticeUpdateOk(ModelAndView mv, PostDTO post, HttpSession session) {
		
		if(null == post) {
			mv.addObject("message","잘못된 접근입니다.");
			mv.addObject("href","/");
			mv.setViewName("comMessage");
			return mv;
		}
		
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		post.setWriter(member.getUser_id());
		
		int res = postService.updatePost(post);
		
		if(res > 0) mv.addObject("message","수정되었습니다.");
		else mv.addObject("message","에러가 발생하였습니다.");
		
		mv.addObject("href","NoticeView?post_no="+post.getPostNo());
		mv.setViewName("comMessage");
		
		return mv;
	}
	
	@RequestMapping(value="/NoticeDelete", method=RequestMethod.POST)
	public ModelAndView NoticeDelete(ModelAndView mv, PostDTO post, HttpSession session) {
		if(null == post) {
			mv.addObject("message","잘못된 접근입니다.");
			mv.addObject("href","/");
			mv.setViewName("comMessage");
			return mv;
		}
		
		int res = postService.deletePost(post.getPostNo());
		
		if(res > 0) mv.addObject("message","삭제되었습니다.");
		else mv.addObject("message","에러가 발생하였습니다.");
		
		mv.addObject("href","NoticeList");
		mv.setViewName("comMessage");
		
		return mv;
	}
	
	public boolean isLogin(HttpSession session) {
		if(null != session.getAttribute("member")) {
			return true; 
		}
		
		return false;
	}
}
