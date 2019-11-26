package com.imruler.web.service;

import java.util.List;

import com.imruler.web.entity.Member;

public interface MemberService {
	List<Member> getNoticeList();
	boolean isValidMember(String userId, String userPwd);

	boolean isDuplicatedId(String userId, String userPwd, String userPwdRequest, String phone, String email);
	int insertMember(Member member);
	int deleteMember(int id);
}
