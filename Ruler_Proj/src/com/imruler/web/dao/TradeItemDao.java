package com.imruler.web.dao;

import com.imruler.web.entity.TradeBoard;
import com.imruler.web.entity.TradeItem;


public interface TradeItemDao {
	//int select(JdbcTradeBoardDao jdbctradeBoard);
	int insert(TradeItem tradeItem);
	int update(TradeItem tradeItem);
}
	
