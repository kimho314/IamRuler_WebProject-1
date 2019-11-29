package com.imruler.web.service.coordi;

import java.util.List;

import com.imruler.web.dao.CoordiBoardDao;
import com.imruler.web.dao.CoordiBoardViewDao;
import com.imruler.web.dao.jdbc.JdbcCoordiBoardDao;
import com.imruler.web.dao.jdbc.JdbcCoordiBoardViewDao;
import com.imruler.web.entity.CoordiBoard;
import com.imruler.web.entity.CoordiBoardView;
import com.imruler.web.service.CoordiBoardService;

public class RulerCoordiBoardService implements CoordiBoardService
{
	private CoordiBoardViewDao coordiBoardViewDao;
	private CoordiBoardDao coordiBoardDao;
	
	public RulerCoordiBoardService()
	{
		coordiBoardViewDao = new JdbcCoordiBoardViewDao();
		coordiBoardDao = new JdbcCoordiBoardDao();
	}

	@Override
	public List<CoordiBoardView> getList(int page, String gender)
	{
		// TODO getList(int page, String gender)
		return getList(page, gender, "");
	}

	@Override
	public List<CoordiBoardView> getList(int page, String gender, String bodyspape)
	{
		// TODO getList(int page, String gender, String bodyspape)
		return coordiBoardViewDao.getList(page, gender, bodyspape);
	}

	@Override
	public CoordiBoardView getCoordiBoardView(int cb_id)
	{
		// TODO Auto-generated method stub
		return coordiBoardViewDao.get(cb_id);
	}	

	@Override
	public int getListCount(String gender, String bodyspape)
	{
		// TODO getListCount
		return coordiBoardViewDao.getListCount(gender, bodyspape);
	}

	@Override
	public CoordiBoard getCoordiBoard(int id)
	{
		// TODO Auto-generated method stub
		return coordiBoardDao.get(id);
	}

	@Override
	public int insert(CoordiBoard coordiBoard)
	{
		// TODO Auto-generated method stub
		return coordiBoardDao.insert(coordiBoard);
	}

	@Override
	public int update(CoordiBoard coordiBoard)
	{
		// TODO Auto-generated method stub
		return coordiBoardDao.update(coordiBoard);
	}

	@Override
	public int delete(int id)
	{
		// TODO Auto-generated method stub
		return coordiBoardDao.delete(id);
	}

	@Override
	public int getMaxId()
	{
		// TODO Auto-generated method stub
		return coordiBoardDao.getMaxId();
	}

}
