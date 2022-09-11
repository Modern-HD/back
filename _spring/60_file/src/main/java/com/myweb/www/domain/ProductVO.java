package com.myweb.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
	private int fileCount;
	
	public ProductVO() {}
	
	//register
	public ProductVO(String pname, String category ,int price, String writer, String description, String madeBy) {
		this.pname = pname;
		this.category = category;
		this.price = price;
		this.writer = writer;
		this.description = description;
		this.madeBy = madeBy;
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

}
