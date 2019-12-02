package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imruler.web.dao.TradeCommentDao;
import com.imruler.web.entity.TradeBoard;
import com.imruler.web.entity.TradeComment;
import com.imruler.web.entity.TradeView;

public class JdbcTradeCommentDao implements TradeCommentDao {

//	@Override
//	public List<TradeComment> getComment(int id) {
//		List<TradeComment> list = new ArrayList<>();
//		Connection con = null;
//		PreparedStatement st = null;
//		String sql = "SELECT * FROM(SELECT M.ID M_ID, M.USER_NAME M_USER_NAME, C.CONTENT C_CONTENT, C.REGDATE C_REGDATE, C.ID C_ID, C.BOARD_ID C_BOARD_ID FROM TRADE_COMMENT C LEFT OUTER JOIN MEMBER M ON C.USER_ID=M.ID);\r\n" + 
//				"";
//		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection(url, "RULER", "33333");
//			st = con.prepareStatement(sql); 
//			st.setInt(1, id);
//			ResultSet rs = st.executeQuery();
//			
//			while (rs.next()) {
//				int cId = rs.getInt("c_id");
//				String cContent = rs.getString("c_content");
//				int cUserId = rs.getInt("c_user_id");
//				Date cRegdate = rs.getDate("c_regdate");
//				int cBId = rs.getInt("c_b_id");
//
//				TradeComment tradeComment = new TradeComment(id, cContent, cUserId, cRegdate, cBId);
//				list.add(tradeComment);
//			}
//			st.close();
//			con.close();
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				if(st != null)
//					st.close();
//				if(con != null)
//					con.close();
//			}catch(SQLException e) {}
//		}
//		
//		return list;
//	}
	
	public int insertTradeComment(TradeComment tradeComment) {
		int result = 0;
		
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		String sql = "INSERT INTO TRADE_COMMENT(ID, CONTENT, USER_ID, REGDATE, BOARD_ID, OPEN_STATUS) VALUES((SELECT NVL(MAX(ID),0)+1 FROM TRADE_COMMENT), ?,?,SYSTIMESTAMP,?,?)";
		
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			st = con.prepareStatement(sql);
			st.setString(1, tradeComment.getcContent());
			st.setInt(2, tradeComment.getcUserId());
			st.setInt(3, tradeComment.getcBId());
			st.setInt(4, tradeComment.getcOpenStatus());
			
			System.out.println(tradeComment.getcContent()+"userId:"+tradeComment.getcUserId()+"BID:"+tradeComment.getcBId()+"open:"+tradeComment.getcOpenStatus());
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
	public int deleteTradeComment(int id) {
		TradeComment tradeComment = null;
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		String sql = "DELETE TRADE_COMMENT WHERE ID=?";

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
	public List<TradeComment> getCommentListByUserId(int userId) { // for 내 작성글
		return getCommentListByUserId(userId, 1);
	}

	@Override
	public List<TradeComment> getCommentListByUserId(int userId, int page) { // for 내 작성글
		List<TradeComment> list = new ArrayList<>();
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, T.*\r\n" + 
				"FROM (SELECT * FROM COMMENTLISTVIEW WHERE USER_ID=? ORDER BY REGDATE DESC) C)WHERE NUM BETWEEN ? AND ?;";
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
				TradeComment trade = new TradeComment(/**/
						rs.getInt("ID"), /**/
						rs.getString("CONTENT"), /**/
						rs.getInt("USER_ID"), /**/
						rs.getDate("REGDATE"), /**/
						rs.getInt("BOARD_ID"), /**/
						rs.getString("TYPE"));
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
	public int updateTradeComment(TradeComment tradeComment) {
			Connection con = null;
			PreparedStatement st = null;
			int result = 0;

			String sql = "UPDATE TRADE_COMMENT SET CONTENT=? WHERE ID=?";
			String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url, "RULER", "33333");
				st = con.prepareStatement(sql);
				st.setString(1, tradeComment.getcContent());
				//st.setInt(2, tradeComment.getcUserId());
				//st.setDate(4, tradeComment.getcRegdate());
				//st.setInt(2, tradeComment.getcBId());
				st.setInt(2, tradeComment.getcId());

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
	
	
	


	

}
