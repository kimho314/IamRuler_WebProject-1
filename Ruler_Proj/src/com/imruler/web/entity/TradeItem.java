package com.imruler.web.entity;

public class TradeItem {
	private int itemId;
	private String bodyShape;
	private String category;
	private String region;
	
	public TradeItem() {
		
	}

	// for inserting
	public TradeItem(String bodyShape, String category, String region) {
		this.bodyShape = bodyShape;
		this.category = category;
		this.region = region;
	}
	
	// for selecting
	public TradeItem(int itemId, String bodyShape, String category, String region) {
		this.itemId = itemId;
		this.bodyShape = bodyShape;
		this.category = category;
		this.region = region;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getBodyShape() {
		return bodyShape;
	}

	public void setBodyShape(String bodyShape) {
		this.bodyShape = bodyShape;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "TradeItem [itemId=" + itemId + ", bodyShape=" + bodyShape + ", category=" + category + ", region=" + region
				+ "]";
	}
	
	
	
	
	

}
