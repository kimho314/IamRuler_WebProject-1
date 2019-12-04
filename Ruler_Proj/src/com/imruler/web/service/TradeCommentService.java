package com.imruler.web.service;

import com.imruler.web.entity.TradeComment;

public interface TradeCommentService{
	//List<TradeComment> getComment(int id);
	
	int insertTradeComment(TradeComment tradeComment);
	int updateTradeComment(TradeComment tradeComment);
	int deleteTradeComment(int id);
}
