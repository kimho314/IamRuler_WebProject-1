package com.imruler.web.service;

import com.imruler.web.entity.Member;

public interface MemberService {
	boolean isValidMember(String userId, String userPwd);
	boolean isDuplicatedId(String userId);
	int insertMember(Member member);
	int deleteMember(int id);
}
