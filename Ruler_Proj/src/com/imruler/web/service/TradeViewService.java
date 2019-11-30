package com.imruler.web.service;

import java.util.List;

import com.imruler.web.entity.TradeView;

public interface TradeViewService {
	TradeView getTrade(int id); // detail
	List<TradeView> getComment(int id);
}
