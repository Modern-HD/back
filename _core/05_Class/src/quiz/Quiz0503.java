package quiz;

public class Quiz0503 {

	public static void main(String[] args) {
		// 아래의 조건을 참고 및 추리하여 코드를 작성해보세요
		// a. 피보나치 수열 출력
		// b. 확인하고 싶은 수열의 자리수(정수) 입력 받기
		// c. 수열 계산하는 메서드는 int fibo(int n)
		
		for(int i = 0; i < 10; i++) {
			System.out.print(fibo(i) + " ");
		}
		System.out.println();
		System.out.println(fibo(10));
	}

	private static int fibo(int num) {
		if (num == 0 || num == 1) {
			return 1;
		} else {
			return fibo(num-1) + fibo(num-2);
		}
	}
	
}
