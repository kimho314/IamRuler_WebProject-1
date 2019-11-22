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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
