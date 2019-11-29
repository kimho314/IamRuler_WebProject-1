package com.imruler.web.dao;

import com.imruler.web.entity.CoordiImg;

public interface CoordiImgDao
{
	CoordiImg get(int id);

	int insert(CoordiImg coordiImg);
	int update(CoordiImg coordiImg);
	int delete(int id);
	int deleteByCoordiBoardId(int cb_id);
}
