package com.ruler.web.service;

import com.ruler.web.entity.Member;

public interface MemberService {
	boolean isValidMember(String userId, String userPwd);
	boolean isDuplicatedId(String userId);
	int insertMember(Member member);
}
