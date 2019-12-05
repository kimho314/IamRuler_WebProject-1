package com.imruler.web.dao;

import java.util.List;

import com.imruler.web.entity.Dibs;
import com.imruler.web.entity.DibsView;

public interface DibsDao {
	List<DibsView> getListById(int id); // 사용자아이디로 찜목록 1페이지 조회 
	List<DibsView> getListById(int id,int page); // 사용자아이디로 찜목록 페이지별 조회 
	List<Dibs> getDibsListByMemberId(int mId);
	
	int insert(Dibs dibs); // 찜 추가
	int update(Dibs dibs); // 메모 수정
	int delete(int id,int board_id);	// 찜 삭제
	
	int getCountById(int id); // 찜목록 갯수 조회
	int getCountByBoardId(int board_id); // 게시판 번호로 찜 갯수 조회
}
