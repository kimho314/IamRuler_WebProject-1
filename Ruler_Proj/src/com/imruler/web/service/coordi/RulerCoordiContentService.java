package com.imruler.web.service.coordi;

import com.imruler.web.dao.CoordiContentDao;
import com.imruler.web.dao.jdbc.JdbcCoordiContentDao;
import com.imruler.web.entity.CoordiContent;
import com.imruler.web.service.CoordiContentService;

public class RulerCoordiContentService implements CoordiContentService
{
	
	private CoordiContentDao coordiContentDao;
	
	public RulerCoordiContentService()
	{
		// TODO Auto-generated constructor stub
		coordiContentDao = new JdbcCoordiContentDao();
	}

	@Override
	public CoordiContent get(int id)
	{
		// TODO Auto-generated method stub
		return coordiContentDao.get(id);
	}

	@Override
	public int insert(CoordiContent coordiContent)
	{
		// TODO Auto-generated method stub
		return coordiContentDao.insert(coordiContent);
	}

	@Override
	public int update(CoordiContent coordiContent)
	{
		// TODO Auto-generated method stub
		return coordiContentDao.update(coordiContent);
	}

	@Override
	public int delete(int id)
	{
		// TODO Auto-generated method stub
		return coordiContentDao.delete(id);
	}

}
