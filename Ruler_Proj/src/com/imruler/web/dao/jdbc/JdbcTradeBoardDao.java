package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imruler.web.dao.TradeBoardDao;
import com.imruler.web.entity.TradeBoard;
import com.imruler.web.entity.TradeBoardView;

public class JdbcTradeBoardDao implements TradeBoardDao {

	@Override
	public List<TradeBoardView> getList() {
		return getList(1,"title","");
	}

	@Override
	public List<TradeBoardView> getList(int page) {
		return getList(page, "title", "");
	}

	@Override
	public List<TradeBoardView> getList(int page, String field, String query) {
		List<TradeBoardView> list = new ArrayList<TradeBoardView>();
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, T.* " +
						"FROM (SELECT * FROM TRADEBOARDVIEW WHERE " + field +
						" LIKE ? ORDER BY B_REGDATE DESC) T" + 
						")WHERE NUM BETWEEN ? AND ?";
		Connection con = null;
		PreparedStatement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, ((page - 1)+1) * 10);
			st.setInt(3, page * 10);
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				TradeBoardView trade = new TradeBoardView(/**/
						rs.getInt("b_id"), /**/
						rs.getString("title"), /**/
						rs.getString("content"), /**/
						rs.getString("tag"), /**/
						rs.getInt("b_hit"), /**/
						rs.getDate("b_regdate"), /**/
						rs.getInt("b_user_id"), /**/
						rs.getInt("i_id"), /**/
						rs.getString("bodyshape"), /**/
						rs.getString("category"), /**/
						rs.getString("region"));

				list.add(trade);
			}
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			}catch(SQLException e) {}
		}

		return list;
	}

	


	@Override
	public int insert(TradeBoard tradeboard) {
		int result = 0;
		Connection con = null;
		PreparedStatement st = null;
		
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		String sql = "INSERT INTO TRADE_BOARD(ID, TITLE, CONTENT, TAG, USER_ID) VALUES((SELECT NVL(MAX(ID),0)+1 FROM TRADE_BOARD), ?,?,?,?)";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			st = con.prepareStatement(sql);
			st.setString(1, tradeboard.getTitle());
			st.setString(2, tradeboard.getContent());
			st.setString(3, tradeboard.getTag());
			st.setInt(4, tradeboard.getUser_id());
			
			
			result = st.executeUpdate();

			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			}catch(SQLException e) {}
		}
		
		return result;
	}
	
	
	

	@Override
	public int update(TradeBoard tradeboard) {
		int result = 0;

		String sql = "UPDATE TRADE_BOARD SET TITLE=?,CONTENT=?,TAG=?,REGDATE=?,USER_ID=? WHERE ID=?";
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			st = con.prepareStatement(sql);
			st.setString(1, tradeboard.getTitle());
			st.setString(2, tradeboard.getContent());
			st.setString(3, tradeboard.getTag());
			st.setDate(4, tradeboard.getRegdate());
			st.setInt(5, tradeboard.getUser_id());
			st.setInt(6, tradeboard.getId());
				
			result = st.executeUpdate();

			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			}catch(SQLException e) {}
		}

		return result;
	}

	@Override
	public int delete(int id) {
		TradeBoard tradeBoard = null;
		int result = 0;

		String sql = "DELETE FROM TRADE_BOARD WHERE ID=?";
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
	
		Connection con = null;
		PreparedStatement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			st = con.prepareStatement(sql);

			st.setInt(1, id);

			result = st.executeUpdate();

			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			}catch(SQLException e) {}
		}

		return result;
	}

	@Override
	public TradeBoard getPrevById(int id) {
		TradeBoard trade = null;

		String sql = "SELECT * FROM (SELECT * FROM TRADE_BOARD ORDER BY REGDATE DESC)"
				+ "WHERE REGDATE < (SELECT REGDATE FROM TRADE_BOARD WHERE ID=?) AND ROWNUM=1";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333"); 
			st = con.prepareStatement(sql); 
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String tag = rs.getString("TAG");
				int hit = rs.getInt("HIT");
				Date regDate = rs.getDate("REGDATE");
				int user_id = rs.getInt("USER_ID");

				trade = new TradeBoard(id, title, content, tag, hit, regDate, user_id);

			}
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			}catch(SQLException e) {}
		}

		return trade;
	}

	@Override
	public TradeBoard getNextById(int id) {
		TradeBoard trade = null;

		String sql = "SELECT * FROM (SELECT * FROM TRADE_BOARD ORDER BY REGDATE ASC)"
				+ "WHERE REGDATE > (SELECT REGDATE FROM TRADE_BOARD WHERE ID=?) AND ROWNUM=1";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333"); 
			st = con.prepareStatement(sql); 
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String tag = rs.getString("TAG");
				int hit = rs.getInt("HIT");
				Date regDate = rs.getDate("REGDATE");
				int user_id = rs.getInt("USER_ID");

				trade = new TradeBoard(id, title, content, tag, hit, regDate, user_id);

			}
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			}catch(SQLException e) {}
		}

		return trade;
	}

	@Override
	public int getListCount(String field, String query) {
		int count=0;
		
		String sql = "SELECT COUNT(ID) COUNT FROM TRADE_BOARD WHERE "+field+" LIKE ? ";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
			count = rs.getInt("count");

			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			}catch(SQLException e) {}
		}
		
		return count;
	}

	@Override
	public List<TradeBoard> getListByUserId(int userId, int page) { // for 내 작성글 
		List<TradeBoard> list = new ArrayList<>();
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, B.*\r\n" + 
				"FROM (SELECT * FROM BOARDLISTVIEW WHERE USER_ID=? ORDER BY REGDATE DESC) B)WHERE NUM BETWEEN ? AND ?;";
		Connection con = null;
		PreparedStatement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			st = con.prepareStatement(sql);
			st.setInt(1, userId);
			st.setInt(2, ((page - 1)+1) * 8);
			st.setInt(3, page * 8);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				TradeBoard trade = new TradeBoard(/**/
						rs.getInt("id"), /**/
						rs.getString("title"), /**/
						rs.getDate("regdate"), /**/
						rs.getInt("user_id"), /**/
						rs.getInt("hit"), /**/
						rs.getString("type"));
				list.add(trade);
			}
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			}catch(SQLException e) {}
		}

		return list;
	
	}
	
	

}
