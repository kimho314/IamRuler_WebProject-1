package com.imruler.web.dao;

import com.imruler.web.entity.TradeComment;
import com.imruler.web.entity.TradeView;

public interface TradeCommentDao {
	TradeView getComment(int id);
	int insertTradeComment(TradeComment tradeComment);
}

