package com.imruler.web.service;

import java.util.List;

import com.imruler.web.entity.Ranking;

public interface RankingService {
	List<Ranking> getRankingList(); // 전체
	List<Ranking> getRankingList(int type); // 성별별
	
	
	int insertRanking(Ranking ranking);
	/*
	int updateNotice(Ranking ranking);
	 */
}
