package com.imruler.web.service.ranking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.imruler.web.dao.RankingDao;
import com.imruler.web.dao.jdbc.JdbcRulerRankingDao;
import com.imruler.web.entity.Ogtag;
import com.imruler.web.entity.Ranking;
import com.imruler.web.service.RankingService;
	
public class RulerRankingService implements RankingService{
	private RankingDao rankingdao;
	
	public RulerRankingService() {
		rankingdao = new JdbcRulerRankingDao();
	}
	@Override
	public List<Ranking> getRankingList() {
		return rankingdao.getList();
	}

	@Override
	public int insertRanking(Ranking ranking) {
		return rankingdao.insert(ranking);
	}
	@Override
	public List<Ranking> getRankingList(int type) {
		return rankingdao.getListByType(type);
	}

	
//	private List<Ogtag> getOgList(List<Ranking> rankingList) { // url을 통한 쇼핑몰 이름, 경로, 대표이미지 크롤링 
//		List<Ogtag> list = new ArrayList<>();
//		for (Ranking r : rankingList)
//			list.add(getOgtag(r.getUrl()));
//		return  list;
//	}
}
