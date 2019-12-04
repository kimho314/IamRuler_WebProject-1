package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.imruler.web.dao.TradeItemDao;
import com.imruler.web.entity.TradeBoard;
import com.imruler.web.entity.TradeImg;
import com.imruler.web.entity.TradeItem;

public class JdbcTradeItemDao implements TradeItemDao{
	
//	@Override
//	public int select(JdbcTradeBoardDao jdbctradeBoard) {
		
//		TradeBoard tradeBoard = null;
//		String sql = "SELECT * FROM TRADE_BOARD WHERE ID=?";
//		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
	
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection(url, "RULER", "33333"); // Ŀ�ؼ� ����
//			PreparedStatement st = con.prepareStatement(sql); //
//			st.setInt(1, id);
//			ResultSet rs = st.executeQuery();
//	
//			while (rs.next()) {
//				String title = rs.getString("TITLE");
//				String content = rs.getString("CONTENT");
//				String tag = rs.getString("TAG");
//				int hit = rs.getInt("HIT");
//				Date regDate = rs.getDate("REGDATE");
//				String userId = rs.getString("USER_ID");
//				tradeBoard = new TradeBoard(id, title, content, tag, hit, regDate, userId);
//	
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
//		}
//	
//		return tradeBoard;
//	}
	@Override
	public int insert(TradeItem tradeItem) {
			int result = 0;
			 
			String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
			String sql = "INSERT INTO TRADE_ITEM(ID, BODYSHAPE, CATEGORY, REGION) VALUES(?,?,?,?)";
			
			Connection con = null;
			PreparedStatement st = null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url, "RULER", "33333");
				st = con.prepareStatement(sql);
				st.setInt(1, tradeItem.getItemId());
				st.setString(2, tradeItem.getBodyShape());
				st.setString(3, tradeItem.getCategory());
				st.setString(4, tradeItem.getRegion());
				System.out.println(tradeItem.toString());
				
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
	public int update(TradeItem tradeItem) {
		int result = 0;

		String sql = "UPDATE TRADE_ITEM SET BODYSHAPE=?,CATEGORY=?,REGION=? WHERE ID=?";
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "RULER", "33333");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, tradeItem.getBodyShape());
			st.setString(2, tradeItem.getCategory());
			st.setString(3, tradeItem.getRegion());
			st.setInt(4, tradeItem.getItemId());

			result = st.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteByTradeBoardId(int id) {
		TradeItem tradeItem = null;
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		String sql = "DELETE TRADE_ITEM WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			st = con.prepareStatement(sql);

			st.setInt(1, id);
			
			result = st.executeUpdate();
			
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
