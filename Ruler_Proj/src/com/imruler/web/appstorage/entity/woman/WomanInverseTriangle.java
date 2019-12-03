package com.imruler.web.appstorage.entity.woman;

import com.imruler.web.appstorage.ClothSize;

public class WomanInverseTriangle {
	
	public WomanInverseTriangle() {
		// TODO Auto-generated constructor stub
	}
	
	public int[] WomanInverseTriangle(int x, int y) {
		
		int shoulderWidth = 0; // 어깨너비 -1
		int chestBreadth = 0; // 가슴단면 -1
		int waistWidth = 0; // 허리단면 -2
		int sleeveLength = 0; // 소매길이
		int crotchWidth = 0; // 밑위길이
		int thighWidth = 0;// 허벅지 단면
		int hemWidth = 0;// 밑단 단면
		int topTotalLength = 0; // 상의 총장
		int pantsTotalLength = 0; // 바지 총장
		int skirtTotalLength = 0; // 치마 총장
		int onePieceTotalLength = 0; // 원피스 총장
		int skirtHemWidth = 0; // 치마 밑단 단면
		
		int size[] = new int[12];

		ClothSize clothSize = new ClothSize();

		x = ((x / 2) * 2 - 150) / 2;
		y = ((y / 2) * 2 - 48) / 2;

		int key = clothSize.woman(x, y);

		switch (key) {
		case 85:
			shoulderWidth = 36;
			chestBreadth = 39;
			waistWidth = 31;
			sleeveLength = 52;
			crotchWidth = 18;
			thighWidth = 23;
			hemWidth = 12;
			topTotalLength = 63;
			pantsTotalLength = 95;
			skirtTotalLength = 38;
			onePieceTotalLength = 78;
			skirtHemWidth = 25;
			break;
		case 90:
			shoulderWidth = 37;
			chestBreadth = 42;
			waistWidth = 33;
			sleeveLength = 53;
			crotchWidth = 19;
			thighWidth = 24;
			hemWidth = 13;
			topTotalLength = 66;
			pantsTotalLength = 96;
			skirtTotalLength = 40;
			onePieceTotalLength = 80;
			skirtHemWidth = 26;
			break;
		case 95:
			shoulderWidth = 38;
			chestBreadth = 46;
			waistWidth = 31;
			sleeveLength = 55;
			crotchWidth = 20;
			thighWidth = 25;
			hemWidth = 14;
			topTotalLength = 69;
			pantsTotalLength = 97;
			skirtTotalLength = 42;
			onePieceTotalLength = 82;
			skirtHemWidth = 27;
			break;
		case 100:
			shoulderWidth = 39;
			chestBreadth = 49;
			waistWidth = 40;
			sleeveLength = 57;
			crotchWidth = 24;
			thighWidth = 28;
			hemWidth = 15;
			topTotalLength = 72;
			pantsTotalLength = 100;
			skirtTotalLength = 44;
			onePieceTotalLength = 83;
			skirtHemWidth = 28;
			break;
		case 105:
			shoulderWidth = 40;
			chestBreadth = 53;
			waistWidth = 44;
			sleeveLength = 58;
			crotchWidth = 26;
			thighWidth = 29;
			hemWidth = 16;
			topTotalLength = 74;
			pantsTotalLength = 100;
			skirtTotalLength = 46;
			onePieceTotalLength = 85;
			skirtHemWidth = 29;
			break;
		case 110:
			shoulderWidth = 41;
			chestBreadth = 56;
			waistWidth = 48;
			sleeveLength = 60;
			crotchWidth = 27;
			thighWidth = 30;
			hemWidth = 17;
			topTotalLength = 75;
			pantsTotalLength = 100;
			skirtTotalLength = 46;
			onePieceTotalLength = 85;
			skirtHemWidth = 30;
			break;
		}
		return size;
	}
}
