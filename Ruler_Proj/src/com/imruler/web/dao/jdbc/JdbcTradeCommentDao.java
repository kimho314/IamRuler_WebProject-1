package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.imruler.web.dao.TradeCommentDao;
import com.imruler.web.entity.TradeComment;
import com.imruler.web.entity.TradeView;

public class JdbcTradeCommentDao implements TradeCommentDao {

	@Override
	public TradeView getComment(int id) {
		TradeView tradeView = null;
		Connection con = null;
		PreparedStatement st = null;
		String sql = "SELECT * FROM(SELECT M.ID M_ID, M.USER_NAME M_USER_NAME, C.CONTENT C_CONTENT, C.REGDATE C_REGDATE, C.ID C_ID, C.BOARD_ID C_BOARD_ID FROM TRADE_COMMENT C LEFT OUTER JOIN MEMBER M ON C.USER_ID=M.ID);\r\n" + 
				"";
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			st = con.prepareStatement(sql); 
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				 int bId = rs.getInt("b_id");
				 int cId = rs.getInt("c_id");
				 String cContent = rs.getString("c_content");
				 int cUserId = rs.getInt("c_user_id");
				 Date cRegdate = rs.getDate("c_regdate");
				 int mId = rs.getInt("m_id");
				 String mUserName = rs.getString("m_user_name");
				
				 tradeView = new TradeView(bId, cId, cContent, cUserId, cRegdate, mId, mUserName);
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
		
		return tradeView;
	}
	
	public int insertTradeComment(TradeComment tradeComment) {
		int result = 0;
		
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		String sql = "INSERT INTO TRADE_COMMENT(ID, CONTENT, USER_ID, REGDATE, BOARD_ID) VALUES((SELECT NVL(MAX(ID),0)+1 FROM TRADE_COMMENT), ?,?,(TO_DATE(SYSDATE,'YYYY-MM-DD')),?)";
		
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			st = con.prepareStatement(sql);
			st.setString(1, tradeComment.getcContent());
			st.setInt(2, tradeComment.getcUserId());
			st.setInt(3, tradeComment.getcBId());
			
			System.out.println(sql);
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
