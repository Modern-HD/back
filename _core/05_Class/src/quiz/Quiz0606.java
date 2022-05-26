package quiz;

class Ex06 {
	final double PI = 3.141592;
	
	double area(int r) {
		return r * r * PI;
	}
	
	double area(int a, int b) {
		return a * b;
	}
	
	double area(int a, int b, int c) {
		return (a + b) * c / 2;
	}
}

public class Quiz0606 {
	
	public static void main(String[] args) {
		Ex06 myCalc = new Ex06();
		
		System.out.println(myCalc.area(3));
		System.out.println(myCalc.area(4,5));
		System.out.println(myCalc.area(3, 4, 7));
	}
}
