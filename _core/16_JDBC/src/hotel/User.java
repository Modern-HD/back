package hotel;

public class User {
	private String name;
	private String tel;
	private int age;
	private boolean gen;
	
	public User() {}
	public User(String name, String tel, int age, boolean gen) {
		this.name = name;
		this.tel = tel;
		this.age = age;
		this.gen = gen;
	}
	public boolean isGen() {
		return gen;
	}
	public void setGen(boolean gen) {
		this.gen = gen;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
