package com.imruler.web.dao;

import java.util.List;

import com.imruler.web.entity.TradeComment;

public interface TradeCommentDao {
	//List<TradeView> getComment(int id);
	//List<TradeComment> getComment(int id);
	List<TradeComment> getCommentListByUserId(int userId); // 찜목록용 COMMENTLISTVIEW
	List<TradeComment> getCommentListByUserId(int userId,int page);  // 찜목록용 
	
	int insertTradeComment(TradeComment tradeComment);
	//int updateTradeComment(TradeComment tradeComment);
	int deleteTradeComment(int id);
}

