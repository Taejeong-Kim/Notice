package com.assignment.notice.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.assignment.notice.model.dao.MemberDAO;
import com.assignment.notice.model.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO memberDao;
	
	@Override
	public MemberDTO getMember(MemberDTO member) {
		
		return memberDao.getMember(member);
	}

}
