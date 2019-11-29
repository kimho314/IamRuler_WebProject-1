package com.imruler.web.service;

import com.imruler.web.entity.CoordiImg;

public interface CoordiImgService
{
	CoordiImg get(int id);

	int insert(CoordiImg coordiImg);
	int update(CoordiImg coordiImg);
	int delete(int id);
	int deleteByCoordiBoardId(int cb_id);
}
