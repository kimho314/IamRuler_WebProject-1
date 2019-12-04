package com.imruler.web.entity;

public class TradeImg {
	private int id;
	private int boardId;
	private String img;
	
	public TradeImg() {
	}
	
	public TradeImg(int id, int boardId, String img) {
		this.id = id;
		this.boardId = boardId;
		this.img = img;
	}

	public TradeImg(int boardId, String img) {
		this.boardId = boardId;
		this.img = img;
	}

	public TradeImg(String img) {
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "TradeImg [id=" + id + ", boardId=" + boardId + ", img=" + img + "]";
	}

	
	
}
