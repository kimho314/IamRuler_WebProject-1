package com.imruler.web.dao;

import java.util.List;

import com.imruler.web.entity.TradeComment;

public interface TradeCommentDao {
	List<TradeComment> getCommentListByUserId(int userId); // for 내 작성글
	List<TradeComment> getCommentListByUserId(int userId,int page);  // for 내 작성글 
	
	int insertTradeComment(TradeComment tradeComment);
	int updateTradeComment(TradeComment tradeComment);
	int deleteTradeComment(int id);
}

