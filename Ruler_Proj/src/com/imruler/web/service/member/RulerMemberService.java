package com.imruler.web.service.member;

import com.imruler.web.dao.MemberDao;
import com.imruler.web.dao.jdbc.JdbcMemberDao;
import com.imruler.web.entity.Member;
import com.imruler.web.service.MemberService;

public class RulerMemberService implements MemberService {
	private MemberDao memberDao; // Entity와 일치 시킨다
//	데이터베이스를 사용하는 경우는 Table과 이름을 일치시킨다.

	public RulerMemberService() {
		// TODO 기본생성자
		memberDao = new JdbcMemberDao();
	}

	@Override
	public boolean isValidMember(String userId, String userPwd) {
		// TODO isValidMember
		Member member = memberDao.get(userId);

		if (member == null) {
			return false;
		} else if (!member.getPwd().equals(userPwd)) {
			return false;
		}else if (member.getUserName() == null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean isDuplicatedId(String userId) {
		// TODO isDuplicatedId
		return false;
	}

	@Override
	public int insertMember(Member member) {
		// TODO insertMember
		return memberDao.insert(member);
	}

	@Override
	public int deleteMember(int id) {
		// TODO Auto-generated method stub
		return memberDao.delete(id);
	}
}
