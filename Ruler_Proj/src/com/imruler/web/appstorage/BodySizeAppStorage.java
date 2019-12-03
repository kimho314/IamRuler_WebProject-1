package com.imruler.web.appstorage;

public final class BodySizeAppStorage {
	private static final BodySizeAppStorage BODY_SIZE = new BodySizeAppStorage();
	
	public BodySizeAppStorage() {
		int shoulderWidth = 0; // 어깨너비 
		int chestBreadth = 0; // 가슴단면 
		int waistWidth = 0; // 허리단면 
		int sleeveLength = 0; // 소매길이
		int crotchWidth = 0; // 밑위길이
		int thighWidth = 0;//허벅지 단면
		int hemWidth = 0;// 밑단 단면
		int skirtHemWidth = 0; // 치마 밑단 단면
		int topTotalLength = 0; // 상의 총장
		int pantsTotalLength = 0; // 바지 총장
		int skirtTotalLength = 0; // 치마 총장
		int onePieceTotalLength = 0; // 원피스 총장
		
	}
	public static BodySizeAppStorage getBodySize() {
		return BODY_SIZE;
	}
}
