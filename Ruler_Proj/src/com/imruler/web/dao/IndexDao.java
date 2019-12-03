package com.imruler.web.dao;

import com.imruler.web.entity.Member;

public interface IndexDao {

	Member get(int id, int height, int weidth, String gender, int age, String bodyshape);

	int top(int x, int y, String gender, String bodyshape, int shoulderWidth, int chestBreadth, int sleeveLength, int topTotalLength);
	int outer(int x, int y, String gender, String bodyshape, int shoulderWidth, int chestBreadth, int sleeveLength, int topTotalLength);
	int pants(int x, int y, String gender, String bodyshape, int waistWidth, int thighWidth, int crotchWidth, int hemWidth, int pantsTotalLength);
	int skirt(int x, int y, String gender, String bodyshape, int waistWidth, int skirtHemWidth, int skirtTotalLength);
	int onePiece(int x, int y, String gender, String bodyshape, int shoulderWidth, int chestBreadth, int sleeveLength, int onePieceTotalLength);

}
