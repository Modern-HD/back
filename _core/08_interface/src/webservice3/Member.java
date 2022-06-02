package webservice3;

// 2. Member 객체는 email(중복되지 않음), pwd, nickname, grade(숫자) 속성

public class Member {
	
	private String email;
	private String pwd;
	private String nickname;
	private int grade;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void reset() {
		this.email = "";
		this.pwd = "";
		this.nickname = "";
		this.grade = 0;
	}
	
}
