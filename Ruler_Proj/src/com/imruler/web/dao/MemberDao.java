package com.imruler.web.dao;

import java.util.List;
import com.imruler.web.entity.Member;



public interface MemberDao {

	List<Member> getList();
	Member get(String userName);

	int insert(Member member);
	int update(Member member);
	int delete(int id);
	int myInfoDelete(int id);
	
}
