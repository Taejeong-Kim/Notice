package com.assignment.notice.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.assignment.notice.model.dto.MemberDTO;

@Mapper
public interface MemberDAO {

	public MemberDTO getMember(MemberDTO member);
}
