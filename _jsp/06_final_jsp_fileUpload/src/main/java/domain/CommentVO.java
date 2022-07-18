package domain;


public class CommentVO {
	private long cno;
	private long bno;
	private String writer;
	private String content;
	private String reg_at;
	private String mod_at;
	
	public CommentVO() {}
	
	// register
	public CommentVO(long bno, String writer, String content) {
		this.bno = bno;
		this.writer = writer;
		this.content = content;
	}

	// list
	public CommentVO(long cno, long bno, String writer, String content, String reg_at, String mod_at) {
		this(cno, content);
		this.bno = bno;
		this.writer = writer;
		this.mod_at = mod_at;
	}
	
	// modify
	public CommentVO(long cno, String content) {
		this.cno = cno;
		this.content = content;
	}

	public long getCno() {
		return cno;
	}



	public void setCno(long cno) {
		this.cno = cno;
	}


	public long getBno() {
		return bno;
	}


	public void setBno(long bno) {
		this.bno = bno;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getReg_at() {
		return reg_at;
	}


	public void setReg_at(String reg_at) {
		this.reg_at = reg_at;
	}


	public String getMod_at() {
		return mod_at;
	}


	public void setMod_at(String mod_at) {
		this.mod_at = mod_at;
	}
	
	
}

/*
create table comment (
cno bigint not null auto_increment,
bno bigint default -1,
writer varchar(100) default "removed user",
content varchar(1000) not null,
reg_at datetime default current_timestamp,
mod_at datetime default current_timestamp,
primary key(cno)
) default charset=utf8mb4 collate=utf8mb4_general_ci;
*/