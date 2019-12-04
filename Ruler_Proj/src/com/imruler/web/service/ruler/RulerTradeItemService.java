package com.imruler.web.service.ruler;

import com.imruler.web.dao.TradeItemDao;
import com.imruler.web.dao.jdbc.JdbcTradeItemDao;
import com.imruler.web.entity.TradeItem;
import com.imruler.web.service.TradeItemService;

public class RulerTradeItemService implements TradeItemService {
	
	private TradeItemDao tradeItemDao;
	
	public RulerTradeItemService() {
		tradeItemDao = new JdbcTradeItemDao();
	}

	@Override
	public int insert(TradeItem tradeItem) {
		return tradeItemDao.insert(tradeItem);
	}

	@Override
	public int update(TradeItem tradeItem) {
		return tradeItemDao.update(tradeItem);
	}

	@Override
	public int deleteByTradeBoardId(int id) {
		return tradeItemDao.deleteByTradeBoardId(id);
	}

}
