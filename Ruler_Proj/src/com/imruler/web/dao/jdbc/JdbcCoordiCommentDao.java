package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.imruler.web.dao.CoordiCommentDao;
import com.imruler.web.entity.CoordiComment;

public class JdbcCoordiCommentDao implements CoordiCommentDao
{

	@Override
	public CoordiComment get(int id)
	{
		CoordiComment coordiComment = null;
		String sql = "SELECT\r\n" + 
				"    id,\r\n" + 
				"    content,\r\n" + 
				"    user_id,\r\n" + 
				"    regdate,\r\n" + 
				"    board_id,\r\n" + 
				"    open_status\r\n" + 
				"	 FROM coordi_comment" + 
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
				coordiComment = new CoordiComment(rs.getInt("id"), rs.getString("content"), rs.getInt("user_id"),
						rs.getDate("regdate"), rs.getInt("board_id"), rs.getInt("open_status"));
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

		return coordiComment;
	}

	@Override
	public int insert(CoordiComment coordiComment)
	{
		int result = 0;
		String sql = "INSERT INTO coordi_comment (\r\n" + 
				"    id,\r\n" + 
				"    content,\r\n" + 
				"    user_id,\r\n" + 
				"    board_id,\r\n" + 
				"    open_status\r\n" + 
				") VALUES ((SELECT NVL(MAX(ID),0)+1 FROM coordi_comment),?,?,?,?)";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";

		Connection con = null;
		PreparedStatement pst = null;

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			pst = con.prepareStatement(sql);

			pst.setString(1, coordiComment.getContent());
			pst.setInt(2, coordiComment.getUserId());
			pst.setInt(3, coordiComment.getBoardId());
			pst.setInt(4, coordiComment.getOpenStat());

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
	public int update(CoordiComment coordiComment)
	{
		int result = 0;
		String sql = "UPDATE coordi_comment\r\n" + 
				"SET content=?, user_id=?, board_id=?, open_status=? WHERE ID = ?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";

		Connection con = null;
		PreparedStatement pst = null;

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			pst = con.prepareStatement(sql);
			
			pst.setString(1, coordiComment.getContent());
			pst.setInt(2, coordiComment.getUserId());
			pst.setInt(3, coordiComment.getBoardId());
			pst.setInt(4, coordiComment.getOpenStat());
			pst.setInt(5, coordiComment.getId());

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
		String sql = "DELETE FROM coordi_comment\r\n" + 
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
	public int secretComment(int id)
	{
		int result = 0;
		String sql = "UPDATE coordi_comment\r\n" + 
				"SET open_status = 1" + 
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
	public int deleteByCoordiBoardId(int cb_id)
	{
		int result = 0;
		String sql = "DELETE FROM coordi_comment\r\n" + 
				"WHERE board_id = ?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
	
		Connection con = null;
		PreparedStatement pst = null;

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			pst = con.prepareStatement(sql);

			pst.setInt(1, cb_id);
			
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

}
