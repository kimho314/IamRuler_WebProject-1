package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.imruler.web.dao.CoordiContentDao;
import com.imruler.web.entity.CoordiContent;


public class JdbcCoordiContentDao implements CoordiContentDao
{	

	@Override
	public CoordiContent get(int id)
	{
		CoordiContent coordiContent = null;
		String sql = "SELECT\r\n" + 
				"    id,\r\n" + 
				"    title,\r\n" + 
				"    content,\r\n" + 
				"    tag\r\n" + 
				"    FROM coordi_content" + 
				"    WHERE ID = ?";

		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement  pst = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER","33333");
			pst = con.prepareStatement(sql);

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				coordiContent = new CoordiContent(rs.getInt("id"), rs.getString("title"), rs.getString("content"), rs.getString("tag"));
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

		return coordiContent;
	}

	@Override
	public int insert(CoordiContent coordiContent)
	{
		int result = 0;

		String sql = "INSERT INTO coordi_content (\r\n" + 
				"    id,\r\n" + 
				"    title,\r\n" + 
				"    content,\r\n" + 
				"    tag\r\n" + 
				") VALUES (?,?,?,?)";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement  pst = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER","33333");
			pst = con.prepareStatement(sql);
			pst.setInt(1, coordiContent.getId());
			pst.setString(2, coordiContent.getTitle());
			pst.setString(3, coordiContent.getContent());
			pst.setString(4, coordiContent.getTag());
			
			result = pst.executeUpdate();

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

		return result;
	}

	@Override
	public int update(CoordiContent coordiContent)
	{
		int result = 0;

		String sql = "UPDATE coordi_content SET title=?, content=?, tag=? WHERE id=?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement  pst = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER","33333");
			pst = con.prepareStatement(sql);
			
			pst.setString(1, coordiContent.getTitle());
			pst.setString(2, coordiContent.getContent());
			pst.setString(3, coordiContent.getTag());
			pst.setInt(4, coordiContent.getId());
			
			result = pst.executeUpdate();

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

		return result;
	}

	@Override
	public int delete(int id)
	{
		int result = 0;

		String sql = "DELETE FROM coordi_content\r\n" + 
					"WHERE id = ?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER","33333");
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			
			
			result = pst.executeUpdate();

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

		return result;
	}

}
