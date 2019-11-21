package com.imruler.web.service;

import java.util.List;

import com.imruler.web.entity.Dibs;
import com.imruler.web.entity.DibsView;

public interface DibsService {
	List<DibsView> getDibsListById(String id); // 사용자아이디로 찜목록 1페이지 조회 
	List<DibsView> getDibsListById(String id,int page); // 사용자아이디로 찜목록 페이지별 조회 
	
	int insertDibs(Dibs dibs); // 찜 추가
	int updateDibs(Dibs dibs); // 메모 수정
	int deleteDibs(String id,int board_id);	// 찜 삭제
	
	int getDibsCountById(String id); // 찜목록 갯수 조회
	int getDibsCountByBoardId(int board_id); // 게시판 번호로 찜 갯수 조회
}
