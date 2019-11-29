package com.imruler.web.service.ruler;

import java.util.List;

import com.imruler.web.dao.TradeBoardDao;
import com.imruler.web.dao.TradeCommentDao;
import com.imruler.web.dao.TradeViewDao;
import com.imruler.web.dao.jdbc.JdbcTradeBoardDao;
import com.imruler.web.dao.jdbc.JdbcTradeCommentDao;
import com.imruler.web.dao.jdbc.JdbcTradeViewDao;
import com.imruler.web.entity.TradeBoard;
import com.imruler.web.entity.TradeBoardView;
import com.imruler.web.entity.TradeComment;
import com.imruler.web.entity.TradeView;
import com.imruler.web.service.TradeCommentService;
import com.imruler.web.service.TradeService;
import com.imruler.web.service.TradeViewService;

public class RulerTradeService implements TradeService, TradeViewService, TradeCommentService{
	private TradeBoardDao tradeBoardDao;
	private TradeViewDao tradeViewDao;
	private TradeCommentDao tradeCommentDao;
	
	public RulerTradeService() {
		tradeBoardDao = new JdbcTradeBoardDao();
		tradeViewDao = new JdbcTradeViewDao();
		tradeCommentDao = new JdbcTradeCommentDao();
	}

	@Override
	public List<TradeBoardView> getTradeList() {
		return getTradeList(1, "title", "");
	}

	@Override
	public List<TradeBoardView> getTradeList(int page) {
		return getTradeList(page, "title", "");
	}

	@Override
	public List<TradeBoardView> getTradeList(int page, String field, String query) {
		return tradeBoardDao.getList(page, field, query);
	}

	@Override
	public TradeView getTrade(int id) {
		return tradeViewDao.get(id);
	}
	
	@Override
	public List<TradeView> getComment(int id) {
		return tradeViewDao.getComment(id);
	}

	@Override
	public TradeBoard getPrevTrade(int id) {
		return tradeBoardDao.getPrevById(id);
	}

	@Override
	public TradeBoard getNextTrade(int id) {
		return tradeBoardDao.getNextById(id);
	}

	@Override
	public int insertTrade(TradeBoard tradeBoard) {
		return tradeBoardDao.insert(tradeBoard);
	}

	@Override
	public int updateTrade(TradeBoard tradeBoard) {
		// return tradeBoardDao.update(tradeboard);
		return 0;
	}

	@Override
	public int deleteTrade(int id) {
		return tradeBoardDao.delete(id);
	}

	@Override
	public int tradeListCount(String field, String query) {
		return tradeBoardDao.getListCount(field, query);
	}

//	@Override
//	public List<TradeView> getComment(int id) {
//		return tradeViewDao.get(id);
//	}

	@Override
	public int insertTradeComment(TradeComment tradeComment) {
		return tradeCommentDao.insertTradeComment(tradeComment);
	}

//	@Override
//	public int updateTradeComment(TradeComment tradeComment) {
//		return tradeCommentDao.updateTradeComment(tradeComment);
//	}
	
	@Override
	public int deleteTradeComment(int id) {
		return tradeCommentDao.deleteTradeComment(id);
	}

	

	

}
