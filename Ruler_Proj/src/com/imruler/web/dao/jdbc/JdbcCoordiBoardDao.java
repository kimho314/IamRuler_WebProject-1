package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.imruler.web.dao.CoordiBoardDao;
import com.imruler.web.entity.CoordiBoard;

public class JdbcCoordiBoardDao implements CoordiBoardDao
{

	@Override
	public CoordiBoard get(int id)
	{
		CoordiBoard coordiBaord = null;
		String sql = "SELECT\r\n" + 
				"    id,\r\n" + 
				"    notice_status,\r\n" + 
				"    hit,\r\n" + 
				"    regdate,\r\n" + 
				"    dibs,\r\n" + 
				"    user_id\r\n" + 
				"	 FROM\r\n" + 
				"    coordi_board" + 
				"    WHERE id = ?";

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
				coordiBaord = new CoordiBoard(rs.getInt("id"), rs.getInt("notice_status"), rs.getInt("hit"),
						rs.getDate("regdate"), rs.getInt("dibs"), rs.getInt("user_id"));
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

		return coordiBaord;
	}

	@Override
	public int insert(CoordiBoard coordiBoard)
	{
		int result = 0;
		String sql = "INSERT INTO coordi_board (\r\n" + 
				"    id,\r\n" + 		
				"    user_id\r\n" + 
				") VALUES ((SELECT NVL(MAX(ID),0)+1 FROM coordi_board),?)";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";

		Connection con = null;
		PreparedStatement pst = null;

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, coordiBoard.getUserId());

			result = pst.executeUpdate();
			
			pst.close();
			con.close();

		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (pst != null || con != null)
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
	public int update(CoordiBoard coordiBoard)
	{
		int result = 0;
		String sql = "UPDATE coordi_board\r\n" + 
				"SET notice_status=?, hit=?, dibs=?, user_id=? WHERE ID = ?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";

		Connection con = null;
		PreparedStatement pst = null;

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, coordiBoard.getNoticeStatus());
			pst.setInt(2, coordiBoard.getUserId());
			pst.setInt(3, coordiBoard.getDibs());
			pst.setInt(4, coordiBoard.getUserId());
			pst.setInt(5, coordiBoard.getId());

			result = pst.executeUpdate();
			
			pst.close();
			con.close();

		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (pst != null || con != null)
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
		String sql = "DELETE FROM coordi_board\r\n" + 
				"WHERE id = ?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
	
		Connection con = null;
		PreparedStatement pst = null;

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			pst = con.prepareStatement(sql);

			pst.setInt(1, id);
			
			result = pst.executeUpdate();
			
			pst.close();
			con.close();

		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (pst != null || con != null)
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
	public int getMaxId()
	{
		int result = 0;
		String sql = "SELECT MAX(ID) MAX_ID FROM  coordi_board";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
	
		Connection con = null;
		PreparedStatement pst = null;

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			pst = con.prepareStatement(sql);
			
			
			ResultSet rs  = pst.executeQuery();
			if(rs.next())
			{
				result = rs.getInt("max_id");
			}
			
			pst.close();
			con.close();

		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (pst != null || con != null)
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
