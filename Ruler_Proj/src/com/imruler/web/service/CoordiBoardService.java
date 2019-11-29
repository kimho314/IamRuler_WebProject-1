package com.imruler.web.service;

import java.util.List;

import com.imruler.web.entity.CoordiBoard;
import com.imruler.web.entity.CoordiBoardView;

public interface CoordiBoardService
{
	List<CoordiBoardView> getList(int page, String gender);
	List<CoordiBoardView> getList(int page, String gender , String bodyspape);
	CoordiBoardView getCoordiBoardView(int cb_id);	

	int getListCount(String gender, String bodyspape);
	
	
	CoordiBoard getCoordiBoard(int id);

	int insert(CoordiBoard coordiBoard);
	int update(CoordiBoard coordiBoard);
	int delete(int id);
	
	int getMaxId();
}
