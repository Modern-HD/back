package com.myweb.www.domain;

public class ProductVO {
	private long pno;
	private String category;
	private String pname;
	private int price;
	private String writer;
	private String description;
	private String madeBy;
	private String regAt;
	private String modAt;
	private int readCount;
	private int cmtQty;
	
	public ProductVO() {}
	
	//register
	public ProductVO(String pname, int price, String writer, String description, String madeBy, String category) {
		this.pname = pname;
		this.price = price;
		this.writer = writer;
		this.description = description;
		this.madeBy = madeBy;
		this.category = category;
	}
	
	//modify
	public ProductVO(long pno, String category, String pname, int price, String description, String madeBy) {
		this.pno = pno;
		this.category = category;
		this.pname = pname;
		this.price = price;
		this.description = description;
		this.madeBy = madeBy;
	}

	public long getPno() {
		return pno;
	}

	public void setPno(long pno) {
		this.pno = pno;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMadeBy() {
		return madeBy;
	}
	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}
	public String getRegAt() {
		return regAt;
	}
	public void setRegAt(String regAt) {
		this.regAt = regAt;
	}
	public String getModAt() {
		return modAt;
	}
	public void setModAt(String modAt) {
		this.modAt = modAt;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getCmtQty() {
		return cmtQty;
	}

	public void setCmtQty(int cmtQty) {
		this.cmtQty = cmtQty;
	}
	
	
}
