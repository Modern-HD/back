package quiz;

class Student {
	String name;
	int classes;
	int number;
	int korean;
	int eng;
	int math;
	
	int getTotal() {
		return korean + eng + math;
	}
	double getAvg() {
		return getTotal()/3;
	}
}

public class Quiz0604 {
	
	public static void main(String[] args) {
		Student itsMe = new Student();
		itsMe.name = "홍길동";
		itsMe.classes = 2;
		itsMe.number = 20;
		itsMe.korean = 90;
		itsMe.eng = 40;
		itsMe.math = 80;
		System.out.println(itsMe.getTotal());
		System.out.println(itsMe.getAvg());
		
	}
	
}
