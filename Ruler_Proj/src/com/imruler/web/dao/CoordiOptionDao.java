package com.imruler.web.dao;

import com.imruler.web.entity.CoordiOption;

public interface CoordiOptionDao
{
	CoordiOption get(int id);

	int insert(CoordiOption coordiOption);
	int update(CoordiOption coordiOption);
	int delete(int id);
}
