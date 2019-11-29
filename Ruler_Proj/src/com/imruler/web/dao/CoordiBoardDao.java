package com.imruler.web.dao;

import com.imruler.web.entity.CoordiBoard;

public interface CoordiBoardDao
{
	CoordiBoard get(int id);

	int insert(CoordiBoard coordiBoard);
	int update(CoordiBoard coordiBoard);
	int delete(int id);
	
	int getMaxId();
}
