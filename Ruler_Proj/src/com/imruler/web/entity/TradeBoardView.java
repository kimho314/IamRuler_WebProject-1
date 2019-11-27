package com.imruler.web.entity;

import java.sql.Date;

public class TradeBoardView extends TradeBoard{
	  	private int i_id;
	    private String bodyshape;
	    private String category;
	    private String region;

		public TradeBoardView() {
			
		}

		public TradeBoardView(int id, String title, String content, String tag, int hit, Date regdate, String user_id, 
				int i_id, String bodyshape, String category, String region) {
			super(id, title, content, tag, hit, regdate, user_id);
			this.i_id = i_id;
			this.bodyshape = bodyshape;
			this.category = category;
			this.region = region;
		}

		

		public int getI_id() {
			return i_id;
		}

		public void setI_id(int i_id) {
			this.i_id = i_id;
		}

		public String getBodyshape() {
			return bodyshape;
		}

		public void setBodyshape(String bodyshape) {
			this.bodyshape = bodyshape;
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
			return "TradeBoardView [i_id=" + i_id + ", bodyshape=" + bodyshape + ", category=" + category + ", region="
					+ region + "]";
		}

		
		
	    
	    
	    

}
