package com.imruler.web.dao;

import java.util.List;

import com.imruler.web.entity.TradeBoard;
import com.imruler.web.entity.TradeBoardView;



public interface TradeBoardDao {
	List<TradeBoardView> getList();
	List<TradeBoardView> getList(int page);
	List<TradeBoardView> getList(int page, String field, String query);
	
	
	int insert(TradeBoard tradeboard);
	int update(TradeBoard tradeboard);
	int delete(int id);
	
	TradeBoard getPrevById(int id);
	TradeBoard getNextById(int id);
	int getListCount(String field, String query);
	
	

}
