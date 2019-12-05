package com.imruler.web.service;

import java.util.List;

import com.imruler.web.entity.TradeBoard;
import com.imruler.web.entity.TradeBoardView;

public interface TradeService {
	List<TradeBoardView> getTradeList();
	List<TradeBoardView> getTradeList(int page);
	List<TradeBoardView> getTradeList(int page, String field, String query);
	
	TradeBoard getPrevTrade(int id);
	TradeBoard getNextTrade(int id);
	
	int insertTrade(TradeBoard tradeBoard);
	int updateTrade(TradeBoard tradeBoard);
	int deleteTrade(int id);
	
	int getBoardId();
	
	int tradeListCount(String field, String query);
	int getListCountByUserId(int userId);
	int getCommentListCountByUserId(int userId);

	int getBoardUserId(int b_id);
}
