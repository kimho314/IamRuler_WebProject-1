package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imruler.web.dao.CoordiCommentViewDao;
import com.imruler.web.entity.CoordiCommentView;

public class JdbcCoordiCommentViewDao implements CoordiCommentViewDao
{

	@Override
	public List<CoordiCommentView> getList(int cb_id)
	{
		List<CoordiCommentView> ccmtList = new ArrayList<>();
		CoordiCommentView coordiCommentView = null;

		String sql = "SELECT * FROM coordi_comment_view\r\n" + 
				"WHERE CB_ID = ? ORDER BY CCMT_REGDATE DESC";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER","33333");
			pst = con.prepareStatement(sql);
			pst.setInt(1, cb_id);
			

			ResultSet rs = pst.executeQuery();

			while (rs.next()) 
			{
				coordiCommentView = new CoordiCommentView(rs.getInt("cb_id"), rs.getInt("ccmt_open_stat") ,rs.getInt("ccmt_id"), rs.getString("ccmt_content"),
						rs.getInt("ccmt_user_id"), rs.getDate("ccmt_regdate"), rs.getInt("ccmt_bid"),
						rs.getInt("m_id"), rs.getString("m_user_name"));

				ccmtList.add(coordiCommentView);
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
		
		return ccmtList;
	}

	@Override
	public CoordiCommentView get(int ccmt_id)
	{
		CoordiCommentView coordiCommentView = null;

		String sql = "SELECT * FROM coordi_comment_view\r\n" + 
				"WHERE CCMT_ID = ?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER","33333");
			pst = con.prepareStatement(sql);
			pst.setInt(1, ccmt_id);
			

			ResultSet rs = pst.executeQuery();
			if(rs.next()) 
			{
				coordiCommentView = new CoordiCommentView(rs.getInt("cb_id"), rs.getInt("ccmt_open_stat") ,rs.getInt("ccmt_id"), rs.getString("ccmt_content"),
						rs.getInt("ccmt_user_id"), rs.getDate("ccmt_regdate"), rs.getInt("ccmt_bid"),
						rs.getInt("m_id"), rs.getString("m_user_name"));
			
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
		
		return coordiCommentView;
	}

}
