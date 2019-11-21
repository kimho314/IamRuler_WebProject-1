package com.imruler.web.entity;

public class Dibs {
	int dibsId;
	String memberId;
	String memo;
    int coordiId;   
    
    public Dibs(int dibsId,String memberId,  int coordiId) { // 메모 없이
		this.memberId = memberId;
		this.coordiId = coordiId;
		this.dibsId = dibsId;
	}
	public Dibs(int dibsId,String memberId, String memo, int coordiId) {
		this.memberId = memberId;
		this.memo = memo;
		this.coordiId = coordiId;
		this.dibsId = dibsId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getCoordiId() {
		return coordiId;
	}
	public void setCoordiId(int coordiId) {
		this.coordiId = coordiId;
	}
	public int getDibsId() {
		return dibsId;
	}
	public void setDibsId(int dibsId) {
		this.dibsId = dibsId;
	}
	@Override
	public String toString() {
		return "Dibs [dibsId=" + dibsId + ", memberId=" + memberId + ", memo=" + memo + ", coordiId=" + coordiId + "]";
	}
	
}
