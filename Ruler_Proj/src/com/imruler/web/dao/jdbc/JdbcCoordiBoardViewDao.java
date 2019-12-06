package com.imruler.web.dao.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imruler.web.dao.CoordiBoardViewDao;
import com.imruler.web.entity.CoordiBoardView;


public class JdbcCoordiBoardViewDao implements CoordiBoardViewDao
{
	
	@Override
	public List<CoordiBoardView> getList(int page, String gender)
	{		
		return getList(page, gender, "");
	}

	@Override
	public List<CoordiBoardView> getList(int page, String gender, String bodyshape)
	{
		List<CoordiBoardView> list = new ArrayList<>();
		CoordiBoardView coordiBoardView = null;
		
		String sql = "SELECT * FROM(SELECT ROWNUM NUM2, N.* FROM(SELECT ROWNUM NUM, N.* "
				+ "FROM(SELECT * FROM coordi_board_view where co_gender = "+ "'" + gender + "'" + ") N\r\n" + 
				"WHERE co_bodyshape LIKE ? ORDER BY cb_regdate DESC) N) WHERE NUM2 BETWEEN ? AND ?";
		/*
		 * String sql = "SELECT * FROM(\r\n" +
		 * "SELECT ROWNUM NUM, N.* FROM(\r\n" +
		 * "SELECT * FROM coordi_board_view where co_gender = " + "'" + gender + "'" + ") N\r\n" +
		 * "WHERE co_bodyshape LIKE ?)\r\n" +
		 * "WHERE NUM BETWEEN ? AND ?\r\n" +
		 * "ORDER BY cb_regdate DESC";
		 */
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement pst = null;
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER","33333");
			pst = con.prepareStatement(sql);
			pst.setString(1, bodyshape + "%");
			pst.setInt(2, (page - 1) * 10 + 1);
			pst.setInt(3, page * 10);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) 
			{
				coordiBoardView = new CoordiBoardView(rs.getInt("m_id"), rs.getString("m_user_name"), rs.getInt("cb_id"), rs.getInt("cb_notice_stat"),
						rs.getInt("cb_hit"), rs.getDate("cb_regdate"), rs.getInt("cb_dibs"), rs.getString("cct_title"), rs.getString("cct_content"),
						rs.getString("cct_tag"), rs.getInt("ci_id"), rs.getString("ci_img"), rs.getString("co_gender"), rs.getString("co_bodyshape"),
						rs.getInt("dl_id"), rs.getInt("dl_member_id"), rs.getInt("dl_coordi_id"), rs.getString("dl_memo"));

				list.add(coordiBoardView);
			}

			rs.close();
			pst.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();			
		} finally {
			if(pst != null || con != null)
			{
				try
				{
					pst.close();
					con.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		return list;
	}

	@Override
	public CoordiBoardView get(int cb_id)
	{
		CoordiBoardView coordiBoardView = null;
		String sql = "SELECT\r\n" + 
				"    m_id,\r\n" + 
				"    m_user_name,\r\n" + 
				"    cb_id,\r\n" + 
				"    cb_notice_stat,\r\n" + 
				"    cb_hit,\r\n" + 
				"    cb_regdate,\r\n" + 
				"    cb_dibs,\r\n" + 
				"    cct_title,\r\n" + 
				"    cct_content,\r\n" + 
				"    cct_tag,\r\n" + 
				"    ci_id,\r\n" + 
				"    ci_img,\r\n" + 
				"    co_gender,\r\n" + 
				"    co_bodyshape,\r\n" + 
				"    dl_id,\r\n" + 
				"    dl_memo\r\n" + 
				"	 FROM coordi_board_view\r\n" + 
				"	 WHERE CB_ID = ?";

		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement pst = null;
	
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER","33333");
			pst = con.prepareStatement(sql);

			pst.setInt(1, cb_id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				coordiBoardView = new CoordiBoardView(rs.getInt("m_id"), rs.getString("m_user_name"), rs.getInt("cb_id"), rs.getInt("cb_notice_stat"),
						rs.getInt("cb_hit"), rs.getDate("cb_regdate"), rs.getInt("cb_dibs"), rs.getString("cct_title"), rs.getString("cct_content"),
						rs.getString("cct_tag"), rs.getInt("ci_id"), rs.getString("ci_img"), rs.getString("co_gender"), rs.getString("co_bodyshape"),
						rs.getInt("dl_id"), rs.getInt("dl_member_id"), rs.getInt("dl_coordi_id"), rs.getString("dl_memo"));
			}
			rs.close();
			pst.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();			
		} finally {
			if(pst != null || con != null)
			{
				try
				{
					pst.close();
					con.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

		return coordiBoardView;
	}

	
	@Override
	public int getListCount(String gender, String bodyshape)
	{
		// TODO getListCount
		int listCount = 0;
		
		String sql = "SELECT COUNT(N.CB_ID) CB_COUNT FROM (\r\n" + 
				"SELECT * FROM coordi_board_view\r\n" + 
				"WHERE co_gender = "+ "'" + gender + "'" + ") N\r\n" + 
				"WHERE N.co_bodyshape LIKE ?";

		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER","33333");
			pst = con.prepareStatement(sql);

			pst.setString(1, bodyshape + "%");

			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				listCount = rs.getInt("cb_count");
			}
			
			rs.close();
			pst.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();			
		} finally {
			if(pst != null || con != null)
			{
				try
				{
					pst.close();
					con.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		
		return listCount;
	}

	

	

}
