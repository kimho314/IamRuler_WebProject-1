package com.imruler.web.service.ranking;

import java.util.List;

import com.imruler.web.dao.RankingDao;
import com.imruler.web.dao.jdbc.JdbcRulerRankingDao;
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

}
