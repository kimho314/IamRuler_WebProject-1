package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.imruler.web.dao.CoordiImgDao;
import com.imruler.web.entity.CoordiImg;

public class JdbcCoordiImgDao implements CoordiImgDao
{

	@Override
	public CoordiImg get(int id)
	{
		CoordiImg coordiImg = null;
		String sql = "SELECT\r\n" + 
				"    id,\r\n" + 
				"    coordi_id,\r\n" + 
				"    img" + 
				"	 FROM coordi_img" + 
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
				coordiImg = new CoordiImg(rs.getInt("id"), rs.getInt("coordi_id"), rs.getString("img"));
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

		return coordiImg;
	}

	@Override
	public int insert(CoordiImg coordiImg)
	{
		int result = 0;

		String sql = "INSERT INTO coordi_img (\r\n" + 
				"    id,\r\n" + 
				"    coordi_id,\r\n" + 
				"    img\r\n" + 
				")  VALUES ((SELECT NVL(MAX(ID),0)+1 FROM coordi_img),?,?)";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER","33333");
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, coordiImg.getCoordiId());
			pst.setString(2, coordiImg.getImg());
			
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
	public int update(CoordiImg coordiImg)
	{
		int result = 0;

		String sql = "UPDATE coordi_img SET coordi_id=?, img=? WHERE id=?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER","33333");
			pst = con.prepareStatement(sql);
			
			
			pst.setInt(1, coordiImg.getCoordiId());
			pst.setString(2, coordiImg.getImg());	
			pst.setInt(3, coordiImg.getId());
			
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

		String sql = "DELETE FROM coordi_img\r\n" + 
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

	@Override
	public int deleteByCoordiBoardId(int cb_id)
	{
		int result = 0;

		String sql = "DELETE FROM coordi_img\r\n" + 
				"WHERE coordi_id = ?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER","33333");
			pst = con.prepareStatement(sql);
			pst.setInt(1, cb_id);			
			
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
