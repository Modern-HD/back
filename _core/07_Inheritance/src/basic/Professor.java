package basic;

public class Professor extends Person {

	private String[] subjects;
	
	public Professor() {
		System.out.println("This is Professor Instance");
	}

	public String[] getSubjects() {
		return subjects;
	}

	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}
	
	
}
