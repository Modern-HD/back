package overloading;

public class CalculateArea {

	public static void main(String[] args) {
		// 메서드의 오버로딩 규칙
		// 1. 메서드의 파라미터 형태기 달라야 한다
		// - 파라미터의 타입과 순서가 달라야 함
		// 2. 메서드의 리턴타입은 오버로딩에 영향을 주지 않는다.
		// 즉, 메서드의 이름이 같아도 파라미터의 형태가 다르면
		// 다른 메서드로 인식하여 매핑된다.
		int width = 100;
		double height = 40;
		// 1. 삼각형의 면적을 구하는 area 메서드를 만들어보세요
		double tryArea = area(width, height);
		
		int w = 50;
		int h = 40;
		// 2. 사각형의 면적을 구하는 area 메서드를 만들어보세요
		int sqrArea = area(w, h);
		
		double r = 2.5;
		final double PI = 3.141592;
		// 3. 원의 면적을 구하는 area 메서드를 만들어보세요
		final double cirArea = area(r, PI);
		
		System.out.println("삼각형: " + tryArea + " 사각형: " + sqrArea + " 원: " + cirArea);
	}
	
	public static double area(int w, double h) {
		return w*h/2;
	}
	
	public static int area(int w, int h) {
		return w*h;
	}
	
	public static final double area(double r, final double PI) {
		return r*r*PI;
	}

}
