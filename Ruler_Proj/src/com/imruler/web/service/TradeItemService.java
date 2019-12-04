package com.imruler.web.service;

import com.imruler.web.entity.TradeItem;

public interface TradeItemService {
	int insert(TradeItem tradeItem);
	int update(TradeItem tradeItem);
	int deleteByTradeBoardId(int id);
}
