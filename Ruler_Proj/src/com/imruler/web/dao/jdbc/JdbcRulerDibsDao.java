package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.imruler.web.dao.DibsDao;
import com.imruler.web.entity.Dibs;
import com.imruler.web.entity.DibsView;

public class JdbcRulerDibsDao implements DibsDao
{

	@Override
	public List<DibsView> getListById(int id)
	{
		return getListById(id, 1);
	}

	@Override
	public List<DibsView> getListById(int id, int page)
	{
		List<DibsView> list = new ArrayList<>();
		String sql = "SELECT * FROM DIBSLISTVIEW WHERE MEMBER_ID=? ORDER BY DIBS_ID DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		Connection con = null;
		PreparedStatement st = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.setInt(2, (page - 1) * 10);
			st.setInt(3, page * 10);
			ResultSet rs = st.executeQuery();
			while (rs.next())
			{
				int dibsId = rs.getInt("DIBS_ID");
				int memberId = rs.getInt("MEMBER_ID");
				String memo = rs.getString("MEMO");
				int coordiId = rs.getInt("COORDI_ID");
				String img = getImgbyCoordiId(coordiId);
				Date regdate = rs.getDate("REGDATE");
				int hit = rs.getInt("HIT");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String tag = rs.getString("TAG");

				DibsView dibsview = new DibsView(dibsId, memberId, memo, coordiId, regdate, hit, img, title, content,
						tag);
				//System.out.println(dibsview);
				list.add(dibsview);
			}
			st.close();
			con.close();

		}
		catch (ClassNotFoundException e)
		{
			if (st != null)
				st = null;
			if (con != null)
				con = null;

			e.printStackTrace();
		}
		catch (SQLException e)
		{
			if (st != null)
				st = null;
			if (con != null)
				con = null;
			e.printStackTrace();
		}
		return list;
	}

	//이미지 가져오기 
	public String getImgbyCoordiId(int coordiId)
	{
		String img = null;
		String sql = "SELECT * FROM COORDI_IMG WHERE COORDI_ID=" + coordiId;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		Connection con = null;
		Statement st = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next())
				img = rs.getString("IMG");
			else
				img = null;

			st.close();
			con.close();

		}
		catch (ClassNotFoundException e)
		{
			if (st != null)
				st = null;
			if (con != null)
				con = null;
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			if (st != null)
				st = null;
			if (con != null)
				con = null;
			e.printStackTrace();
		}
		return img;
	}

	@Override
	public int insert(Dibs dibs)
	{
		System.out.println(dibs.toString());
		int result = 0;
		String sql = "INSERT INTO DIBS_LIST (ID,MEMBER_ID,MEMO,COORDI_ID) VALUES ((SELECT NVL(MAX(ID),0)+1 FROM DIBS_LIST),?,?,?)";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		Connection con = null;
		PreparedStatement st = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			st = con.prepareStatement(sql);

			st.setInt(1, dibs.getMemberId());
			st.setString(2, dibs.getMemo());
			st.setInt(3, dibs.getCoordiId());
			result = st.executeUpdate();
			st.close();
			con.close();

		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Dibs dibs)
	{
		int result = 0;
		String sql = "UPDATE DIBS_LIST SET MEMO=? WHERE ID=?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";		

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, dibs.getMemo());
			st.setInt(2, dibs.getDibsId());

			result = st.executeUpdate();
			st.close();
			con.close();

		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(int id, int board_id)
	{
		int result = 0;
		String sql = "DELETE DIBS_LIST WHERE MEMBER_ID=? AND COORDI_ID=?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";		

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "RULER", "33333");
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);
			st.setInt(2, board_id);

			result = st.executeUpdate();
			st.close();
			con.close();

		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getCountByBoardId(int board_id)
	{
		int result = 0;
		String sql = "SELECT COUNT(MEMBER_ID) count FROM DIBS_LIST GROUP BY COORDI_ID HAVING COORDI_ID=?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "RULER", "33333");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, board_id);
			ResultSet rs = st.executeQuery();
			if (rs.next())
				result = rs.getInt("count");
			st.close();
			con.close();

		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getCountById(int id)
	{
		int result = 0;
		String sql = "SELECT COUNT(COORDI_ID) count FROM DIBS_LIST GROUP BY MEMBER_ID HAVING MEMBER_ID=?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "RULER", "33333");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next())
				result = rs.getInt("count");
			st.close();
			con.close();

		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
}
