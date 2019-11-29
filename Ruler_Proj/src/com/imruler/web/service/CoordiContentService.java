package com.imruler.web.service;

import com.imruler.web.entity.CoordiContent;

public interface CoordiContentService
{
	CoordiContent get(int id);

	int insert(CoordiContent coordiContent);
	int update(CoordiContent coordiContent);
	int delete(int id);
}
