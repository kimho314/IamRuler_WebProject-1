package com.imruler.web.dao;


import com.imruler.web.entity.CoordiContent;



public interface CoordiContentDao
{
	CoordiContent get(int id);

	int insert(CoordiContent coordiContent);
	int update(CoordiContent coordiContent);
	int delete(int id);
}
