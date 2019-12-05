package com.imruler.web.service.mypage;

import java.util.List;

import com.imruler.web.dao.DibsDao;
import com.imruler.web.dao.jdbc.JdbcRulerDibsDao;
import com.imruler.web.entity.Dibs;
import com.imruler.web.entity.DibsView;
import com.imruler.web.service.DibsService;

public class RulerDibsService implements DibsService{
	private DibsDao dibsDao;
	public RulerDibsService() {
		dibsDao = new JdbcRulerDibsDao();
	}
	@Override
	public List<DibsView> getDibsListById(int id) {
		return dibsDao.getListById(id);
	}

	@Override
	public List<DibsView> getDibsListById(int id, int page) {
		return dibsDao.getListById(id, page);
	}

	@Override
	public int insertDibs(Dibs dibs) {
		return dibsDao.insert(dibs);
	}

	@Override
	public int updateDibs(Dibs dibs) {
	
		return dibsDao.update(dibs);
	}

	@Override
	public int deleteDibs(int id, int board_id) {
		return dibsDao.delete(id, board_id);
	}

	@Override
	public int getDibsCountById(int id) {
		
		return dibsDao.getCountById(id);
	}

	@Override
	public int getDibsCountByBoardId(int board_id) {
		
		return  dibsDao.getCountByBoardId(board_id);
	}
	@Override
	public List<Dibs> getDibsListByMemberId(int mId)
	{
		// TODO getDibsListByMemberId
		return dibsDao.getDibsListByMemberId(mId);
	}

}
