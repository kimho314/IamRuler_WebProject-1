package com.imruler.web.service.member;

import java.util.List;

import org.jsoup.internal.StringUtil;

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
		if (userId.length() <= 3) { // 아이디 길이확인
			System.out.println("아이디 길이부족");
			return 1;
		}

		if (userId.length() >= 17) {
			System.out.println("아이디 길이초과");
			return 1;
		}

		for (Member key : member) { // 유저 아이디가 중복되는지 확인
			if (key.getUserName().equals(userId)) {
				System.out.println("아이디 중복");
				return 1;
			}
		}

		if (userPwd.length() <= 3) { // 비밀번호 길이확인
			System.out.println("비밀번호 길이부족");
			return 2;
		}

		if (userPwd.length() >= 17) {
			System.out.println("비밀번호 길이초과");
			return 2;
		}

		if (!userPwd.equals(userPwdRequest) || userPwd == null || userPwd.equals(null) || userPwd.equals("")
				|| userPwd.length() <= 3) { // 비밀번호 재확인
			System.out.println("비밀번호 재확인 오류");
			return 2;
		}

		for (Member key : member) { // 핸드폰 번호가 중복되는지 확인
			if (key.getPhone().equals(phone)) {
				System.out.println("핸드폰번호 중복");
				return 3;
			}
		}

		for (Member key : member) { // 이메일이 중복되는지 확인
			if (key.getEmail().equals(email)) {
				System.out.println("이메일 중복");
				return 4;
			}
		}
		
		
		if (email.substring(email.indexOf(".")).length() != 4) {
			System.out.println("이메일 끝글자 오류");
			System.out.println(email.substring(email.indexOf(".")));
			return 4;
		} 

		return 0;
	}

	@Override
	public int isDuplicatedIdMyInfo(String userId, String userPwd, String userPwdRequest, String phone, String email) {
		// TODO isDuplicatedId
		List<Member> member = memberDao.getList();

		if (!userPwd.equals(userPwdRequest) || userPwd == null || userPwd.equals(null) || userPwd.equals("")
				|| userPwd.length() <= 3) { // 비밀번호 재확인
			return 1;
		}

		for (Member key : member) { // 핸드폰 번호가 중복되는지 확인
			if (!key.equals(null)) {
				if (key.getPhone().equals(phone) || phone.length() != 11) {
					return 2;
				}
			}
		}

		for (Member key : member) { // 이메일이 중복되는지 확인
			if (!key.equals(null)) {
				if (key.getEmail().equals(email)) {
					return 3;
				}
			}
		}

		return 0;
	}

	@Override
	public int insertMember(Member member) {
		// TODO insertMember
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

	@Override
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return memberDao.update(member);
	}

	@Override
	public int myInfoDeleteMember(int id) {
		// TODO deleteMember
		return memberDao.myInfoDelete(id);
	}

	@Override
	public String idFinder(String email) {
		// TODO Auto-generated method stub
		List<Member> member = memberDao.getList();
		String userId = "해당하는 아이디가 없습니다.";
		for (Member key : member) { // 핸드폰 번호가 중복되는지 확인
			if (!key.equals(null)) {
				if (key.getEmail().equals(email)) {
					userId = "아이디는 \'" + key.getUserName() + "\' 입니다.";
					System.out.println("아이디찾기");
					return userId;
				}
			}
		}
		System.out.println("아이디찾기 오류");
		return userId;
	}

	@Override
	public String pwdFinder(String userId, String phone) {
		// TODO Auto-generated method stub
		List<Member> member = memberDao.getList();
		String userPwd = "해당하는 아이디가 없거나 핸드폰 번호가 틀립니다.";
		for (Member key : member) { // 핸드폰 번호가 중복되는지 확인
			if (!key.equals(null)) {
				if (key.getUserName().equals(userId) && key.getPhone().equals(phone)) {
					userPwd = "비밀번호는 \'" + key.getPwd() + "\' 입니다.";
					System.out.println("비밀번호찾기");
					return userPwd;
				}
			}
		}
		System.out.println("비밀번호찾기 오류");
		return userPwd;
	}
}
