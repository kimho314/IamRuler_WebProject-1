package com.imruler.web.entity;

import java.util.Date;

public class TradeView {
	private int bId;
	private String bTitle;
	private String bContent;
	private String bTag;
	private int bHit;
	private Date bRegdate;
	private int bUserId;
	private int itemId;
	private String itemBodyshape;
	private String itemCategory;
	private String itemRegion;
	private int imgId;
	private int imgBoardId;
	private String img;
	private int cId;
	private String cContent;
	private int cUserId;
	private Date cRegdate;
	private int mId;
	private String mUserName;
	private String mPwd;
	private String mPhone;
	private String mEmail;
	private int mHeight;
	private int mWeight;
	private String mGender;
	private int mAge;
	private String mBodyshape;

	public TradeView() {

	}
	
	public TradeView(int bId, String bTitle, String bContent, String bTag, int bHit, Date bRegdate, int bUserId,
			int itemId, String itemBodyshape, String itemCategory, String itemRegion, int imgId, int imgBoardId,
			String img, int cId, String cContent, int cUserId, Date cRegdate, int mId, String mUserName, String mPwd,
			String mPhone, String mEmail, int mHeight, int mWeight, String mGender, int mAge, String mBodyshape) {
		this.bId = bId;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bTag = bTag;
		this.bHit = bHit;
		this.bRegdate = bRegdate;
		this.bUserId = bUserId;
		this.itemId = itemId;
		this.itemBodyshape = itemBodyshape;
		this.itemCategory = itemCategory;
		this.itemRegion = itemRegion;
		this.imgId = imgId;
		this.imgBoardId = imgBoardId;
		this.img = img;
		this.cId = cId;
		this.cContent = cContent;
		this.cUserId = cUserId;
		this.cRegdate = cRegdate;
		this.mId = mId;
		this.mUserName = mUserName;
		this.mPwd = mPwd;
		this.mPhone = mPhone;
		this.mEmail = mEmail;
		this.mHeight = mHeight;
		this.mWeight = mWeight;
		this.mGender = mGender;
		this.mAge = mAge;
		this.mBodyshape = mBodyshape;
	}

	public TradeView(int bId, int cId, String cContent, int cUserId, Date cRegdate, int mId, String mUserName) {
		this.bId = bId;
		this.cId = cId;
		this.cContent = cContent;
		this.cUserId = cUserId;
		this.cRegdate = cRegdate;
		this.mId = mId;
		this.mUserName = mUserName;
	}

	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbTag() {
		return bTag;
	}
	public void setbTag(String bTag) {
		this.bTag = bTag;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public Date getbRegdate() {
		return bRegdate;
	}
	public void setbRegdate(Date bRegdate) {
		this.bRegdate = bRegdate;
	}
	public int getbUserId() {
		return bUserId;
	}
	public void setbUserId(int bUserId) {
		this.bUserId = bUserId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemBodyshape() {
		return itemBodyshape;
	}
	public void setItemBodyshape(String itemBodyshape) {
		this.itemBodyshape = itemBodyshape;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getItemRegion() {
		return itemRegion;
	}
	public void setItemRegion(String itemRegion) {
		this.itemRegion = itemRegion;
	}
	public int getImgId() {
		return imgId;
	}
	public void setImgId(int imgId) {
		this.imgId = imgId;
	}
	public int getImgBoardId() {
		return imgBoardId;
	}
	public void setImgBoardId(int imgBoardId) {
		this.imgBoardId = imgBoardId;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	
	public int getcUserId() {
		return cUserId;
	}

	public void setcUserId(int cUserId) {
		this.cUserId = cUserId;
	}

	public Date getcRegdate() {
		return cRegdate;
	}

	public void setcRegdate(Date cRegdate) {
		this.cRegdate = cRegdate;
	}

	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmUserName() {
		return mUserName;
	}
	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}
	public String getmPwd() {
		return mPwd;
	}
	public void setmPwd(String mPwd) {
		this.mPwd = mPwd;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public int getmHeight() {
		return mHeight;
	}
	public void setmHeight(int mHeight) {
		this.mHeight = mHeight;
	}
	public int getmWeight() {
		return mWeight;
	}
	public void setmWeight(int mWeight) {
		this.mWeight = mWeight;
	}
	public String getmGender() {
		return mGender;
	}
	public void setmGender(String mGender) {
		this.mGender = mGender;
	}
	public int getmAge() {
		return mAge;
	}
	public void setmAge(int mAge) {
		this.mAge = mAge;
	}
	public String getmBodyshape() {
		return mBodyshape;
	}
	public void setmBodyshape(String mBodyshape) {
		this.mBodyshape = mBodyshape;
	}

	@Override
	public String toString() {
		return "TradeView [bId=" + bId + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bTag=" + bTag + ", bHit="
				+ bHit + ", bRegdate=" + bRegdate + ", bUserId=" + bUserId + ", itemId=" + itemId + ", itemBodyshape="
				+ itemBodyshape + ", itemCategory=" + itemCategory + ", itemRegion=" + itemRegion + ", imgId=" + imgId
				+ ", imgBoardId=" + imgBoardId + ", img=" + img + ", cId=" + cId + ", cContent=" + cContent
				+ ", cUserId=" + cUserId + ", cRegdate=" + cRegdate + ", mId=" + mId + ", mUserName=" + mUserName
				+ ", mPwd=" + mPwd + ", mPhone=" + mPhone + ", mEmail=" + mEmail + ", mHeight=" + mHeight + ", mWeight="
				+ mWeight + ", mGender=" + mGender + ", mAge=" + mAge + ", mBodyshape=" + mBodyshape + "]";
	}
}
