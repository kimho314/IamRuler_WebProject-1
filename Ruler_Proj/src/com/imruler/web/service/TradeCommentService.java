package com.imruler.web.service;

import com.imruler.web.entity.TradeComment;

public interface TradeCommentService{
	int insertTradeComment(TradeComment tradeComment);
	//int updateTradeComment(TradeComment tradeComment);
	int deleteTradeComment(int id);
}
