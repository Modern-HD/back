package quiz;

import java.text.DecimalFormat;

class Ex03 {
	double base = 5.0;
	double height = 3.5;
	
	double getArea() {
		return base * height / 2;
	}
	
	double getHypotenuse() {
		return Math.sqrt((base * base) + (height * height));
	}
	
	double getPerimeter() {
		return base + height + getHypotenuse();
	}
}

public class Quiz0603 {

	public static void main(String[] args) {
		DecimalFormat frmt = new DecimalFormat("0.00");
		Ex03 ob = new Ex03();
		System.out.println("삼각형의 넓이: " +ob.getArea());
		System.out.println("빗변길이: " + frmt.format(ob.getHypotenuse()));
		System.out.println("둘레길이: " + frmt.format(ob.getPerimeter()));
	}
	
}
