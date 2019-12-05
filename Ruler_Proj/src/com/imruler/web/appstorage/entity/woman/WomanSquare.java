package com.imruler.web.appstorage.entity.woman;

import com.imruler.web.appstorage.ClothSize;

public class WomanSquare {
	
	public WomanSquare() {
		// TODO Auto-generated constructor stub
	}
	
	public int[] WomanSquare(int x,int y) {
		
		int shoulderWidth = 0; // 어깨너비 -2
		int chestBreadth = 0; // 가슴단면 -2
		int waistWidth = 0; // 허리단면 -3
		int sleeveLength = 0; // 소매길이
		int crotchWidth = 0; // 밑위길이
		int thighWidth = 0;//허벅지 단면
		int hemWidth = 0;// 밑단 단면
		int topTotalLength = 0; // 상의 총장
		int pantsTotalLength = 0; // 바지 총장
		int skirtTotalLength = 0; // 치마 총장
		int onePieceTotalLength = 0; // 원피스 총장
		int skirtHemWidth = 0; // 치마 밑단 단면
		
		int size[] = new int[12];
		
		ClothSize clothSize = new ClothSize(); 
		
		if(x>=150) {
			x = ((x / 2) * 2 - 150)/2;
		} else {x=0;}
		
		if(y>=48) {
			y = ((y / 2) * 2 - 48)/2;
		}else {	y=0;}
		
		int key = clothSize.woman(x, y);
		
		switch (key) {
		case 85:
			shoulderWidth = 35;
			chestBreadth = 38;
			waistWidth = 29;
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
			shoulderWidth = 36;
			chestBreadth = 41;
			waistWidth = 32;
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
			shoulderWidth = 37;
			chestBreadth = 45;
			waistWidth = 30;
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
			shoulderWidth = 38;
			chestBreadth = 48;
			waistWidth = 39;
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
			shoulderWidth = 39;
			chestBreadth = 52;
			waistWidth = 43;
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
			shoulderWidth = 40;
			chestBreadth = 55;
			waistWidth = 47;
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
		size[0] = shoulderWidth;
		size[1] = chestBreadth;
		size[2] = waistWidth;
		size[3] = sleeveLength;
		size[4] = crotchWidth;
		size[5] = thighWidth;
		size[6] = hemWidth;
		size[7] = topTotalLength;
		size[8] = pantsTotalLength;
		size[9] = skirtTotalLength;
		size[10] = onePieceTotalLength;
		size[11] = skirtHemWidth;
		return size;
	}
}
