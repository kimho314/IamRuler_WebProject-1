package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.imruler.web.dao.TradeImgDao;
import com.imruler.web.entity.TradeImg;

public class JdbcTradeImgDao implements TradeImgDao{

	@Override
	public int insert(TradeImg tradeImg) {
		int result=0;
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		String sql = "INSERT INTO TRADE_IMG (ID, BOARD_ID, IMG) VALUES(?,?,?)";
		
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			st = con.prepareStatement(sql);
			st.setInt(1, tradeImg.getId());
			st.setInt(2, tradeImg.getBoardId());
			st.setString(3, tradeImg.getImg());
			
			System.out.println(tradeImg.toString());
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
	public int update(TradeImg tradeImg) {
		int result=0;
		return result;
	}
	

}
