package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.imruler.web.dao.CoordiOptionDao;
import com.imruler.web.entity.CoordiOption;

public class JdbcCoordiOptionDao implements CoordiOptionDao
{

	@Override
	public CoordiOption get(int id)
	{
		CoordiOption coordiOption = null;
		String sql = "SELECT\r\n" + 
				"    id,\r\n" + 
				"    bodyshape,\r\n" + 
				"    gender\r\n" + 
				"	 FROM coordi_option" + 
				"    WHERE ID = ?";

		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER","33333");
			pst = con.prepareStatement(sql);

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				coordiOption = new CoordiOption(rs.getInt("id"), rs.getString("bodyshpae"), rs.getString("gender"));
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

		return coordiOption;
	}

	@Override
	public int insert(CoordiOption coordiOption)
	{
		int result = 0;

		String sql = "INSERT INTO coordi_option (\r\n" + 
				"    id,\r\n" + 
				"    bodyshape,\r\n" + 
				"    gender\r\n" + 
				")  VALUES (?,?,?)";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER","33333");
			pst = con.prepareStatement(sql);
			System.out.println(coordiOption.getId());
			pst.setInt(1, coordiOption.getId());
			pst.setString(2, coordiOption.getBodyShape());
			pst.setString(3, coordiOption.getGender());
			
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
	public int update(CoordiOption coordiOption)
	{
		int result = 0;

		String sql = "UPDATE coordi_option SET bodyshape=?, gender=? WHERE id=?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER","33333");
			pst = con.prepareStatement(sql);
			
			pst.setString(1, coordiOption.getBodyShape());
			pst.setString(2, coordiOption.getGender());
			pst.setInt(3, coordiOption.getId());
			
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

		String sql = "DELETE FROM coordi_option WHERE id = ?";
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
