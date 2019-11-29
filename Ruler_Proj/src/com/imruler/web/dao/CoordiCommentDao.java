package com.imruler.web.dao;

import com.imruler.web.entity.CoordiComment;

public interface CoordiCommentDao
{
	CoordiComment get(int id);
	
	int insert(CoordiComment coordiComment);
	int update(CoordiComment coordiComment);
	int delete(int id);
	int deleteByCoordiBoardId(int cb_id);
	int secretComment(int id);
}
