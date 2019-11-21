package com.imruler.web.dao;

import java.util.List;

import com.imruler.web.entity.Ranking;

public interface RankingDao {
	List<Ranking> getList(); // 전체 
	List<Ranking> getListByType(int type); // 성별 
	
	int insert(Ranking ranking);
}
