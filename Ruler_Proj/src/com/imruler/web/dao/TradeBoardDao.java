package com.imruler.web.dao;

import java.util.List;

import com.imruler.web.entity.TradeBoard;
import com.imruler.web.entity.TradeBoardView;
import com.imruler.web.entity.TradeView;

public interface TradeBoardDao {
	List<TradeBoardView> getList();
	List<TradeBoardView> getList(int page);
	List<TradeBoardView> getList(int page, String field, String query);
	List<TradeBoard> getListByUserId(int userId, int page); // for 내 작성글
	
	int insert(TradeBoard tradeboard);
	int update(TradeBoard tradeboard);
	int delete(int id);
	
	TradeBoard getPrevById(int id);
	TradeBoard getNextById(int id);
	int getBoardId();
	
	int getListCount(String field, String query);
	int getListCountByUserId(int userId);
	
	int getBoardUserId(int b_id);
}
