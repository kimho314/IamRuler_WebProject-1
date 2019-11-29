package com.imruler.web.dao;

import com.imruler.web.entity.TradeComment;

public interface TradeCommentDao {
	//List<TradeView> getComment(int id);
	//List<TradeComment> getComment(int id);
	
	int insertTradeComment(TradeComment tradeComment);
	//int updateTradeComment(TradeComment tradeComment);
	int deleteTradeComment(int id);
}

