package com.imruler.web.service.coordi;

import com.imruler.web.dao.CoordiOptionDao;
import com.imruler.web.dao.jdbc.JdbcCoordiOptionDao;
import com.imruler.web.entity.CoordiOption;
import com.imruler.web.service.CoordiOptionService;

public class RulerCoordiOptionService implements CoordiOptionService
{
	private CoordiOptionDao coordiOptionDao;
	
	public RulerCoordiOptionService()
	{
		// TODO Auto-generated constructor stub
		coordiOptionDao = new JdbcCoordiOptionDao();
	}
	
	
	@Override
	public CoordiOption get(int id)
	{
		// TODO Auto-generated method stub
		return coordiOptionDao.get(id);
	}

	@Override
	public int insert(CoordiOption coordiOption)
	{
		// TODO Auto-generated method stub
		return coordiOptionDao.insert(coordiOption);
	}

	@Override
	public int update(CoordiOption coordiOption)
	{
		// TODO Auto-generated method stub
		return coordiOptionDao.update(coordiOption);
	}

	@Override
	public int delete(int id)
	{
		// TODO Auto-generated method stub
		return coordiOptionDao.delete(id);
	}

}
