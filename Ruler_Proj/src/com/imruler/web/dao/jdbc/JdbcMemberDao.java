package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.imruler.web.dao.MemberDao;
import com.imruler.web.entity.Member;



public class JdbcMemberDao implements MemberDao {

	@Override
	public List<Member> getList() {
		// TODO 회원목록 보여줄게있나
		return null;
	}

	@Override
	public Member get(String id) {
		Member member = null;
		String sql = "SELECT ID , userName, pwd, phone, email, height, weight, gender, age, bodyshape  FROM Member WHERE ID=?";

		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "RULER","33333");
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				member = new Member(rs.getInt("id"), rs.getString("userName"), rs.getString("pwd"),
						rs.getString("phone"), rs.getString("email"), rs.getInt("height"), rs.getInt("weight"), rs.getString("gender"), rs.getInt("age"), rs.getString("bodyshape"));
			}
			rs.close();
			pst.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}

	@Override
	public int insert(Member member) {
		// TODO insert
		int result = 0;

		String sql = "INSERT INTO Member(ID, USER_NAME, PWD, PHONE, EMAIL, HEIGHT, WEIGHT, GENDER, AGE, BODYSHAPE) VALUES((SELECT NVL(MAX(ID),0)+1 FROM MEMBER),?,?,?,?,?,?,?,?,?)";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, member.getUserName());
			pst.setString(2, member.getPwd());
			pst.setString(3, member.getPhone());
			pst.setString(4, member.getEmail());
			pst.setInt(5, member.getHeight());
			pst.setInt(6, member.getWidth());
			pst.setString(7, member.getGender());
			pst.setInt(8, member.getAge());
			pst.setString(9, member.getBodyshape());

			result = pst.executeUpdate();

			pst.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int update(Member member) {
		// TODO 이건 지금 제 역할이 아닙니다
		return 0;
	}

	@Override
	public int delete(int id) {
		int result = 0;
		String sql = "UPDATE MEMBER SET USER_NAME=NULL, PWD=NULL, PHONE=NULL, EMAIL=NULL, HEIGHT=NULL, WEIGHT=NULL, GENDER=NULL, AGE=NULL, BODYSHAPE=NULL WHERE ID=?";

		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "RULER","33333");
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, id);

			result = pst.executeUpdate();

			pst.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
