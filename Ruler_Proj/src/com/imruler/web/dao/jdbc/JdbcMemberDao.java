package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imruler.web.dao.MemberDao;
import com.imruler.web.entity.Member;

public class JdbcMemberDao implements MemberDao {

	@Override
	public List<Member> getList() {
		List<Member> list = new ArrayList<>();
		String sql = "select id, user_name, pwd, phone, email, height, weight, gender, age, bodyshape " + "from Member "
				+ "order by id desc;";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			if (rs.next()) {
				Member member = new Member(rs.getInt("id"), rs.getString("userName"), rs.getString("pwd"),
						rs.getString("phone"), rs.getString("email"), rs.getInt("height"), rs.getInt("weight"),
						rs.getString("gender"), rs.getInt("age"), rs.getString("bodyshape"));
				list.add(member);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return list;
	}

	@Override
	public Member get(String userName) {
		Member member = null;
		String sql = "SELECT ID , USER_NAME, PWD, PHONE, EMAIL, HEIGHT, WEIGHT, GENDER, AGE, BODYSHAPE  FROM Member WHERE USER_NAME=?";

		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			pst = con.prepareStatement(sql);

			pst.setString(1, userName);

			rs = pst.executeQuery();

			if (rs.next()) {
				member = new Member(rs.getInt("ID"), rs.getString("USER_NAME"), rs.getString("PWD"),
						rs.getString("PHONE"), rs.getString("EMAIL"), rs.getInt("HEIGHT"), rs.getInt("WEIGHT"),
						rs.getString("GENDER"), rs.getInt("AGE"), rs.getString("BODYSHAPE"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return member;
	}

	@Override
	public int insert(Member member) {
		// TODO insert
		int result = 0;

		String sql = "INSERT INTO Member(ID, USER_NAME, PWD, PHONE, EMAIL, HEIGHT, WEIGHT, GENDER, AGE, BODYSHAPE) VALUES((SELECT NVL(MAX(ID),0)+1 FROM MEMBER),?,?,?,?,?,?,?,?,?)";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";

		Connection con = null;
		PreparedStatement pst = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			pst = con.prepareStatement(sql);

			pst.setString(1, member.getUserName());
			pst.setString(2, member.getPwd());
			pst.setString(3, member.getPhone());
			pst.setString(4, member.getEmail());
			pst.setInt(5, member.getHeight());
			pst.setInt(6, member.getWeight());
			pst.setString(7, member.getGender());
			pst.setInt(8, member.getAge());
			pst.setString(9, member.getBodyshape());

			result = pst.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return result;
	}

	@Override
	public int update(Member member) {
		// TODO 회원정보수정
		int result = 0;

//		update 테이블명 set 컬럼명=들어갈값 where 조건문
		String sql = "UPDATE Member SET PWD=?, GENDER=?, AGE=?, PHONE=?, EMAIL=?, HEIGHT=?, WEIGHT=?, BODYSHAPE=? where USER_NAME=?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";

		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			pst = con.prepareStatement(sql);

			pst.setString(1, member.getPwd());
			pst.setString(2, member.getGender());
			pst.setInt(3, member.getAge());
			pst.setString(4, member.getPhone());
			pst.setString(5, member.getEmail());
			pst.setInt(6, member.getHeight());
			pst.setInt(7, member.getWeight());
			pst.setString(8, member.getBodyshape());
			pst.setString(9, member.getUserName());

			result = pst.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return result;
	}
	
	@Override
	public int myInfoDelete(int id) {
		int result = 0;
		String sql = "UPDATE MEMBER SET PHONE=NULL, EMAIL=NULL WHERE ID=?";

		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";

		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			pst = con.prepareStatement(sql);

			pst.setInt(1, id);

			result = pst.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return result;
	}

	@Override
	public int delete(int id) {
		int result = 0;
		String sql = "UPDATE MEMBER SET USER_NAME=NULL, PWD=NULL, PHONE=NULL, EMAIL=NULL, HEIGHT=NULL, WEIGHT=NULL, GENDER=NULL, AGE=NULL, BODYSHAPE=NULL WHERE ID=?";

		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";

		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			pst = con.prepareStatement(sql);

			pst.setInt(1, id);

			result = pst.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return result;
	}

}
