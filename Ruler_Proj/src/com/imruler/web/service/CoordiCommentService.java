package com.imruler.web.service;

import java.util.List;

import com.imruler.web.entity.CoordiComment;
import com.imruler.web.entity.CoordiCommentView;

public interface CoordiCommentService
{
	List<CoordiCommentView> getList(int cb_id);
	
	CoordiComment get(int cb_id);

	int insert(CoordiComment coordiComment);
	int update(CoordiComment coordiComment);
	int delete(int id);
	int deleteByCoodiBoardId(int cb_id);
	int secretComment(int id);
}
