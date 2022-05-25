package quiz;

public class Quiz0502 {

	public static void main(String[] args) {
		// 아래의 조건을 참고 및 추리하여 코드를 작성해보세요.
		// a. 입력 받은 값을 compute(item, qty, price) 메서드로 처리
		// b. 출력 예)
		//		-입력-
		//		품명: apple
		//	 	수량: 10
		//		단가: 1200
		//		-출력-
		//		품명: apple
		//		금액: 12000
		
		compute("apple", 10, 1200);
	}

	private static void compute(String item, int qty, int price) {
		System.out.println("품명: " + item);
		System.out.println("단가: " + qty * price);
	}
	
}
