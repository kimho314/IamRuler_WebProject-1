package com.imruler.web.service;

import com.imruler.web.entity.CoordiOption;

public interface CoordiOptionService
{
	CoordiOption get(int id);

	int insert(CoordiOption coordiOption);
	int update(CoordiOption coordiOption);
	int delete(int id);
}
