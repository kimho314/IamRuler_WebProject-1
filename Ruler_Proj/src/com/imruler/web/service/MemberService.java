package com.imruler.web.service;

import java.util.List;

import com.imruler.web.entity.Member;

public interface MemberService {
	List<Member> getNoticeList();

	Member get(String userName);
	
	Member get(int userId);
	
	boolean isValidMember(String userId, String userPwd);

	int isDuplicatedId(String userId, String userPwd, String userPwdRequest, String phone, String email);

	int insertMember(Member member);

	int updateMember(Member member);
	
	int deleteMember(int id);

	int isDuplicatedIdMyInfo(String userId, String userPwd, String userPwdRequest, String phone, String email);

	int myInfoDeleteMember(int id);
	
	String idFinder(String email);
	
	String pwdFinder(String userId, String phone);
}
