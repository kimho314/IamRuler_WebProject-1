package com.imruler.web.service.coordi;

import java.util.List;

import com.imruler.web.dao.CoordiCommentDao;
import com.imruler.web.dao.CoordiCommentViewDao;
import com.imruler.web.dao.jdbc.JdbcCoordiCommentDao;
import com.imruler.web.dao.jdbc.JdbcCoordiCommentViewDao;
import com.imruler.web.entity.CoordiComment;
import com.imruler.web.entity.CoordiCommentView;
import com.imruler.web.service.CoordiCommentService;

public class RulerCoordiCommentService implements CoordiCommentService
{
	private CoordiCommentViewDao coordiCommentViewDao;
	private CoordiCommentDao coordiCommentDao;
	
	public RulerCoordiCommentService()
	{
		coordiCommentViewDao = new JdbcCoordiCommentViewDao();
		coordiCommentDao = new JdbcCoordiCommentDao();
	}

	@Override
	public List<CoordiCommentView> getList(int cb_id)
	{
		// TODO List<CoordiCommentView> getList(int cb_id)
		return coordiCommentViewDao.getList(cb_id);
	}

	@Override
	public CoordiComment get(int id)
	{
		// TODO Auto-generated method stub
		return coordiCommentDao.get(id);
	}

	@Override
	public int insert(CoordiComment coordiComment)
	{
		// TODO Auto-generated method stub
		return coordiCommentDao.insert(coordiComment);
	}

	@Override
	public int update(CoordiComment coordiComment)
	{
		// TODO Auto-generated method stub
		return coordiCommentDao.update(coordiComment);
	}

	@Override
	public int delete(int id)
	{
		// TODO Auto-generated method stub
		return coordiCommentDao.delete(id);
	}

	@Override
	public int secretComment(int id)
	{
		// TODO Auto-generated method stub
		return coordiCommentDao.secretComment(id);
	}

	@Override
	public int deleteByCoodiBoardId(int cb_id)
	{
		// TODO Auto-generated method stub
		return coordiCommentDao.deleteByCoordiBoardId(cb_id);
	}

	

}
