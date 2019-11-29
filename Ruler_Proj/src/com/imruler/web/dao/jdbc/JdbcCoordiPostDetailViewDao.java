package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.imruler.web.dao.CoordiPostDetailViewDao;
import com.imruler.web.entity.CoordiPostDetailView;

public class JdbcCoordiPostDetailViewDao implements CoordiPostDetailViewDao
{

	@Override
	public CoordiPostDetailView get(int id)
	{
		CoordiPostDetailView coordiPostDetailView = null;
		String sql = "SELECT  m_id, m_user_name, cb_id, cb_notice_stat, cb_hit, cb_regdate, \r\n" + 
				"cb_dibs, cct_title, cct_content, cct_tag, ci_id, ci_img, co_gender, co_bodyshape \r\n" + 
				"FROM coordi_post_detail_view WHERE cb_id = ?";

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
				coordiPostDetailView = new CoordiPostDetailView(rs.getInt("m_id"), rs.getString("m_user_name"), rs.getInt("cb_id"),
						rs.getInt("cb_notice_stat"), rs.getInt("cb_hit"), rs.getDate("cb_regdate"), rs.getInt("cb_dibs"),
						rs.getString("cct_title"), rs.getString("cct_content"), rs.getString("cct_tag"), rs.getInt("ci_id"),
						rs.getString("ci_img"), rs.getString("co_gender"), rs.getString("co_bodyshape"));
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

		return coordiPostDetailView;
	}

}
