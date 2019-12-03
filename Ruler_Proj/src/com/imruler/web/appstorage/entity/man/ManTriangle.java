package com.imruler.web.appstorage.entity.man;

import com.imruler.web.appstorage.ClothSize;

public class ManTriangle {
	
	public ManTriangle() {
		// TODO Auto-generated constructor stub
	}
	
	public int[] ManTriangle(int x,int y) {
		
		int shoulderWidth = 0; // 어깨너비 -1
		int chestBreadth = 0; // 가슴단면 -5
		int waistWidth = 0; // 허리단면 -2
		int sleeveLength = 0; // 소매길이
		int crotchWidth = 0; // 밑위길이
		int thighWidth = 0;//허벅지 단면
		int hemWidth = 0;// 밑단 단면
		int topTotalLength = 0; // 상의 총장
		int pantsTotalLength = 0; // 바지 총장
		
		int size[] = new int[9];
		
		ClothSize clothSize = new ClothSize(); 
		
		x = ((x / 2) * 2 - 158)/2;
		y = ((y / 2) * 2 - 56)/2;
		
		int key = clothSize.woman(x, y);
		
		switch (key) {
		case 90:
			shoulderWidth = 39;
			chestBreadth = 39;
			waistWidth = 36;
			sleeveLength = 61;
			crotchWidth = 19;
			thighWidth = 27;
			hemWidth = 15;
			topTotalLength = 66;
			pantsTotalLength = 99;
			break;
		case 95:
			shoulderWidth = 41;
			chestBreadth = 43;
			waistWidth = 40;
			sleeveLength = 62;
			crotchWidth = 24;
			thighWidth = 28;
			hemWidth = 16;
			topTotalLength = 69;
			pantsTotalLength = 100;
			break;
		case 100:
			shoulderWidth = 43;
			chestBreadth = 47;
			waistWidth = 45;
			sleeveLength = 63;
			crotchWidth = 26;
			thighWidth = 29;
			hemWidth = 17;
			topTotalLength = 72;
			pantsTotalLength = 102;
			break;
		case 105:
			shoulderWidth = 45;
			chestBreadth = 51;
			waistWidth = 50;
			sleeveLength = 64;
			crotchWidth = 28;
			thighWidth = 30;
			hemWidth = 19;
			topTotalLength = 74;
			pantsTotalLength = 103;
			break;
		case 110:
			shoulderWidth = 47;
			chestBreadth = 55;
			waistWidth = 55;
			sleeveLength = 65;
			crotchWidth = 30;
			thighWidth = 31;
			hemWidth = 20;
			topTotalLength = 75;
			pantsTotalLength = 104;
			break;
		case 115:
			shoulderWidth = 49;
			chestBreadth = 59;
			waistWidth = 60;
			sleeveLength = 66;
			crotchWidth = 31;
			thighWidth = 33;
			hemWidth = 21;
			topTotalLength = 78;
			pantsTotalLength = 106;
			break;
		}
		return size;
	}
}
