package com.imruler.web.entity;

import java.util.Date;
// 찜목록 조회용 뷰
public class DibsView extends Dibs{
    
	Date regdate;
    int hit;
    String img;
    String title;
    String content;
    String tag;
    
	public DibsView(int dibsId, String memberId, String memo, int coordiId, Date regdate, int hit, String img,
			String title, String content, String tag) {
		super(dibsId, memberId, memo, coordiId);
		this.regdate = regdate;
		this.hit = hit;
		this.img = img;
		this.title = title;
		this.content = content;
		this.tag = tag;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
    
}
