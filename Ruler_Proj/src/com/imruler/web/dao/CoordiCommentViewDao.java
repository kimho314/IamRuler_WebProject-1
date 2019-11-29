package com.imruler.web.dao;

import java.util.List;

import com.imruler.web.entity.CoordiCommentView;


public interface CoordiCommentViewDao
{
	List<CoordiCommentView> getList(int cb_id);
	CoordiCommentView get(int ccmt_id);	
}
