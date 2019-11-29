package com.imruler.web.dao;

import java.util.List;
import com.imruler.web.entity.CoordiBoardView;


public interface CoordiBoardViewDao
{
	List<CoordiBoardView> getList(int page, String gender);
	List<CoordiBoardView> getList(int page, String gender , String bodyspape);
	CoordiBoardView get(int cb_id);	
	int getListCount(String gender, String bodyspape);
}
