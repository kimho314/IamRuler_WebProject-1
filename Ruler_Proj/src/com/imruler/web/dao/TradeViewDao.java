package com.imruler.web.dao;

import java.util.List;

import com.imruler.web.entity.TradeView;

public interface TradeViewDao {
	TradeView get(int id);
	List<TradeView> getComment(int id);
	
}
