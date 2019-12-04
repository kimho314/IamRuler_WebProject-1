package com.imruler.web.service.ruler;

import com.imruler.web.dao.TradeImgDao;
import com.imruler.web.dao.jdbc.JdbcTradeImgDao;
import com.imruler.web.entity.TradeImg;
import com.imruler.web.service.TradeImgService;

public class RulerTradeImgService implements TradeImgService{
	
	private TradeImgDao tradeImgDao;
	
	public RulerTradeImgService() {
		tradeImgDao = new JdbcTradeImgDao();
	}

	@Override
	public int insert(TradeImg tradeImg) {
		return tradeImgDao.insert(tradeImg);
	}

	@Override
	public int update(TradeImg tradeImg) {
		return tradeImgDao.update(tradeImg);
	}

	@Override
	public int delete(int id) {
		return tradeImgDao.delete(id);
	}

	@Override
	public int deleteByTradeBoardId(int boardId) {
		return tradeImgDao.deleteByTradeBoardId(boardId);
	}

}
