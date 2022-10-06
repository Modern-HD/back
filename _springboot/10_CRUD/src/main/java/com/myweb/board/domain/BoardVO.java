package com.myweb.board.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Alias("bvo")
public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private int readCount;
	private String regDate;
	private String regId;
	private String modDate;
	private String modId;
	private char isRemoved;
}
