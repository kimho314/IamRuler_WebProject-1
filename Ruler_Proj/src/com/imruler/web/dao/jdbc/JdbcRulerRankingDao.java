package com.imruler.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.imruler.web.dao.RankingDao;
import com.imruler.web.entity.Ranking;

public class JdbcRulerRankingDao implements RankingDao{

	@Override
	public List<Ranking> getList() { // 전체 
		List<Ranking> list = new ArrayList<>();
		
		String sql = "SELECT * FROM SHOPPING_URL ORDER BY HIT DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY";
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		   try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,"RULER","33333");
				Statement st = con.createStatement();
				ResultSet rs= st.executeQuery(sql);
				while(rs.next()) {
					String mall_url = rs.getString("url");
				 	String mall_name = rs.getString("mall_name");
				    int hit = rs.getInt("hit");
				    int type = rs.getInt("type");
				    String img = rs.getString("img");
					Ranking Ranking = new Ranking(mall_url,mall_name, hit,type,img);
					list.add(Ranking);
				}
				st.close();
				con.close();
					
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}
	@Override
	public List<Ranking> getListByType(int type) { // 성별 
		List<Ranking> list = new ArrayList<>();
		String sql = null;
		if(type==0) {//남성
			 sql = "SELECT * FROM SHOPPING_URL WHERE TYPE=0 ORDER BY HIT DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY";
		}else if(type==1){ // 여성
			 sql = "SELECT * FROM SHOPPING_URL WHERE TYPE=1 ORDER BY HIT DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY";
		}else {
			//에러
		}
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,"RULER","33333");
				Statement st = con.createStatement();
				ResultSet rs= st.executeQuery(sql);
				while(rs.next()) {
					String mall_url = rs.getString("url");
				 	String mall_name = rs.getString("mall_name");
				    int hit = rs.getInt("hit");
				    int mall_type = rs.getInt("type");
				    String mall_img = rs.getString("img");
					
					Ranking Ranking = new Ranking(mall_url,mall_name, hit,mall_type,mall_img);
					list.add(Ranking);
				}
				st.close();
				con.close();
					
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		return list;
	}
	@Override
	public int insert(Ranking ranking) {
		int result= 0;
		String sql = "INSERT INTO SHOPPING_URL VALUES (?,?,?,?,?)";
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		   try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,"RULER","33333");
				PreparedStatement st = con.prepareStatement(sql);
				 st.setString(1, ranking.getUrl());
				 st.setString(2, ranking.getMall_name());
				 st.setInt(3, ranking.getHit());
				 st.setInt(4, ranking.getType());
				 st.setString(5, ranking.getImg());
				
				result = st.executeUpdate();
				st.close();
				con.close();
					
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   return result;
	}

	

}
