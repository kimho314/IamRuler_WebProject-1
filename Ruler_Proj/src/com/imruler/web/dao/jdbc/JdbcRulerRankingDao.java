package com.imruler.web.dao.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.imruler.web.dao.RankingDao;
import com.imruler.web.entity.Ogtag;
import com.imruler.web.entity.Ranking;

public class JdbcRulerRankingDao implements RankingDao{

	@Override
	public List<Ranking> getList() { // 전체 
		return getListByType(3);
	}
	@Override
	public List<Ranking> getListByType(int type) { // 성별 
		List<Ranking> list = new ArrayList<>();
		String sql = null;
		switch (type) {
		case 0:
			sql = "SELECT * FROM SHOPPING_URL WHERE TYPE=0 ORDER BY HIT DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY";
			break;
		case 1:
			sql = "SELECT * FROM SHOPPING_URL WHERE TYPE=1 ORDER BY HIT DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY";
			break;
		default:
			 sql = "SELECT * FROM SHOPPING_URL ORDER BY HIT DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY";
			break;
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
					if(mall_img == null || mall_img.equals("")) 
						if(getOgtag(mall_url).getSitetxt() != null && !getOgtag(mall_url).getSitetxt().equals(""))
							mall_img = getOgtag(mall_url).getSitetxt();
						else
							mall_img="/images/noimg.gif";
					
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

	// 웹 크롤링 
		private Ogtag getOgtag(String url) { // url을 통한 쇼핑몰 이름, 경로, 대표이미지 크롤링 
			String sitetitle = null;
			String sitetxt = null;
			String siteurl = null;
			Ogtag og = null;
			 // 입력받은 url에 해당하는 html을 요청하고 OGTag들을 가져온다.
		    try {
		        Document doc  = Jsoup.connect(url).get();
		        Elements ogTags = doc.select("meta[property^=og:]");
		     //   Elements imgTags = doc.select("img");
		       
		        if(ogTags != null && !ogTags.equals(""))
		        // 필요한 OGTag를 추려낸다
		        for (int i = 0; i < ogTags.size(); i++) {
		            Element tag = ogTags.get(i);	 
		            String text = tag.attr("property");
		            if ("og:url".equals(text)) {
		            	siteurl = tag.attr("content");
		            } else if ("og:image".equals(text)) {
		            	sitetxt = tag.attr("content");
		            }  else if ("og:title".equals(text)) {
		            	sitetitle =tag.attr("content");
		            }		            
		        }
//		        if(sitetxt == null || sitetxt.equals(""))
//		        	sitetxt = url+imgTags.get(0).attr("src");
		        og = new Ogtag(sitetitle,sitetxt,siteurl);
		    } catch (IOException e) {

		    }
		   // System.out.println(siteurl+","+sitetxt+","+sitetitle);
		    return  og;
		}

}
