package com.imruler.web.service;

import com.imruler.web.entity.TradeImg;

public interface TradeImgService {
	int insert(TradeImg tradeImg);
	int update(TradeImg tradeImg);
	int delete(int id);
	int deleteByTradeBoardId(int boardId);

}
