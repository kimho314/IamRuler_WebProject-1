package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.imruler.web.dao.TradeViewDao;
import com.imruler.web.entity.TradeBoard;
import com.imruler.web.entity.TradeView;

public class JdbcTradeViewDao implements TradeViewDao{
	
	@Override
	public TradeView get(int id) {
		TradeView tradeView = null;
		Connection con = null;
		PreparedStatement st = null;
		String sql = "SELECT * FROM TRADEVIEW WHERE B_ID=?";
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "RULER", "33333");
			st = con.prepareStatement(sql); 
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				 int bId = rs.getInt("b_id");
				 String bTitle = rs.getString("b_title");
				 String bContent = rs.getString("b_content");
				 String bTag = rs.getString("b_tag");
				 int bHit = rs.getInt("b_hit");
				 Date bRegdate = rs.getDate("b_regdate");
				 int bUserId = rs.getInt("b_user_id");
				 int itemId = rs.getInt("item_id"); 
				 String itemBodyshape = rs.getString("item_bodyshape");
				 String itemCategory = rs.getString("item_category");
				 String itemRegion = rs.getString("item_region");
				 int imgId = rs.getInt("img_id");
				 int imgBoardId = rs.getInt("img_board_id");
				 String img = rs.getString("img");
				 int cId = rs.getInt("c_id");
				 String cContent = rs.getString("c_content");
				 int cUserId = rs.getInt("c_user_id");
				 Date cRegdate = rs.getDate("c_regdate");
				 int mId = rs.getInt("m_id");
				 String mUserName = rs.getString("m_user_name");
				 String mPwd = rs.getString("m_pwd");
				 String mPhone = rs.getString("m_phone");
				 String mEmail = rs.getString("m_email");
				 int mHeight = rs.getInt("m_height");
				 int mWeight = rs.getInt("m_weight");
				 String mGender = rs.getString("m_gender");
				 int mAge = rs.getInt("m_age");
				 String mBodyshape = rs.getString("m_bodyshape");
				
				 tradeView = new TradeView(bId, bTitle, bContent, bTag, bHit, bRegdate, bUserId, itemId, itemBodyshape,
						itemCategory, itemRegion, imgId, imgBoardId, img, cId, cContent, cUserId, cRegdate, mId, mUserName, mPwd, mPhone,
						mEmail, mHeight, mWeight, mGender, mAge, mBodyshape);
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
	

}
