package com.imruler.web.entity;

public class Ranking {
	 	String url;
	 	String mall_name;
	    int hit;
	    int type;
	    String img;
		public Ranking(String url, String mall_name, int hit, int type,String img) {
			this.url = url;
			this.mall_name = mall_name;
			this.hit = hit;
			this.type = type;
			this.img = img;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getMall_name() {
			return mall_name;
		}
		public void setMall_name(String mall_name) {
			this.mall_name = mall_name;
		}
		public int getHit() {
			return hit;
		}
		public void setHit(int hit) {
			this.hit = hit;
		}
		public int getType() {
			return type;
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
		public void setType(int type) {
			this.type = type;
		}
		@Override
		public String toString() {
			return "Ranking [url=" + url + ", mall_name=" + mall_name + ", hit=" + hit + ", type=" + type + ", img="
					+ img + "]";
		}	
}
