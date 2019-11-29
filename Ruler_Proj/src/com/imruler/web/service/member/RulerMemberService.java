package com.imruler.web.service.member;

import java.util.List;

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
		} else if (member.getUserName() == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int isDuplicatedId(String userId, String userPwd, String userPwdRequest, String phone, String email) {
		// TODO isDuplicatedId
		List<Member> member = memberDao.getList();
		if(userId.length() <= 3) {
			return 1;
		}
		for (Member key : member) { // 유저 아이디가 중복되는지 확인
			if (key.getUserName().equals(userId)) {
				return 1;
			}
		}

		if (!userPwd.equals(userPwdRequest) || userPwd == null || userPwd.equals(null) || userPwd.equals("") || userPwd.length() <=3) { // 비밀번호 재확인
			return 2;
		}

		for (Member key : member) { // 핸드폰 번호가 중복되는지 확인
			if (key.getPhone().equals(phone) || phone.length() != 11) {
				return 3;
			}
		}

		for (Member key : member) { // 이메일이 중복되는지 확인
			if (key.getEmail().equals(email)) {
				return 4;
			}
		}

		return 0;
	}

	@Override
	public int insertMember(Member member) {
		// TODO insertMember
		System.out.println("인서트1");
		return memberDao.insert(member);
	}

	@Override
	public int deleteMember(int id) {
		// TODO deleteMember
		return memberDao.delete(id);
	}

	@Override
	public List<Member> getNoticeList() {
		// TODO getNoticeList
		return memberDao.getList();
	}

	@Override
	public Member get(String userName) {
		// TODO Auto-generated method stub
		return memberDao.get(userName);
	}
}
