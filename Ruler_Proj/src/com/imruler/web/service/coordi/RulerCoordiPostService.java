package com.imruler.web.service.coordi;

import com.imruler.web.dao.CoordiPostDetailViewDao;
import com.imruler.web.dao.jdbc.JdbcCoordiPostDetailViewDao;
import com.imruler.web.entity.CoordiPostDetailView;
import com.imruler.web.service.CoordiPostService;

public class RulerCoordiPostService implements CoordiPostService
{
	private CoordiPostDetailViewDao coordiPostdetailDao;
	
	public RulerCoordiPostService()
	{
		coordiPostdetailDao = new JdbcCoordiPostDetailViewDao();
	}

	@Override
	public CoordiPostDetailView getCoordiPostDetailById(int id)
	{
		// TODO getCoordiPostDetailById
		return coordiPostdetailDao.get(id);
	}

}
