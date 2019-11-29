package com.imruler.web.service.coordi;

import com.imruler.web.dao.CoordiImgDao;
import com.imruler.web.dao.jdbc.JdbcCoordiImgDao;
import com.imruler.web.entity.CoordiImg;
import com.imruler.web.service.CoordiImgService;

public class RulerCoordiImgService implements CoordiImgService
{
	private CoordiImgDao coordiImgDao;
	
	public RulerCoordiImgService()
	{
		// TODO Auto-generated constructor stub
		coordiImgDao = new JdbcCoordiImgDao();
	}

	@Override
	public CoordiImg get(int id)
	{
		// TODO Auto-generated method stub
		return coordiImgDao.get(id);
	}

	@Override
	public int insert(CoordiImg coordiImg)
	{
		// TODO Auto-generated method stub
		return coordiImgDao.insert(coordiImg);
	}

	@Override
	public int update(CoordiImg coordiImg)
	{
		// TODO Auto-generated method stub
		return coordiImgDao.update(coordiImg);
	}

	@Override
	public int delete(int id)
	{
		// TODO Auto-generated method stub
		return coordiImgDao.delete(id);
	}

	@Override
	public int deleteByCoordiBoardId(int cb_id)
	{
		// TODO Auto-generated method stub
		return coordiImgDao.deleteByCoordiBoardId(cb_id);
	}

}
