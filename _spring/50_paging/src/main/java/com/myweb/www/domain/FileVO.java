package com.myweb.www.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FileVO {
	private String uuid;
	private String saveDir;
	private String fileName;
	private int fileType;
	private long pno;
	private long fileSzie;
	private String regAt;
}
