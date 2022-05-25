package quiz;

import java.util.Scanner;

public class Quiz0505 {

	public static void main(String[] args) {
		// 아래의 조건을 참고 및 추리하여 코드를 작성해보세요
		// a. 4번 문제의 연산을 담당할 메서드에 파리미터 사용
		// b. 두 개의 정수를 입력받는 메서드를 배열로 반환하기
		// c. 입력 받는 메서드는 배열과 반복문으로 구성하기
		// d. 연산자를 선택하는 메서드를 정수형으로 반환하기
		
		System.out.println("결과: " + calc(getNums()));
	}
	
	public static int[] getNums() {
		int[] nums = new int[2];
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<nums.length; i++) {
			System.out.println((i+1) + "번째 수를 입력하세요. > ");
			int num = sc.nextInt();
			nums[i] = num;
		}
		return nums;
	}
	
	public static int calc(int[] nums) {
		int result = 0;
		int oper = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("0: +, 1: -, 2: *, 3: /, 4: %");
		System.out.println("연산자를 선택해주세요. > ");
		oper = sc.nextInt();
		switch (oper) {
		case 0: result = sum(nums[0], nums[1]); break;
		case 1: result = subtract(nums[0], nums[1]); break;
		case 2: result = multiply(nums[0], nums[1]); break;
		case 3:
			if (nums[1] == 0) {
				System.out.println("연산불가!, 0으로 나눌 수 없습니다.");
				return 0;
			}
			result = divide(nums[0], nums[1]);
			break;
		case 4:
			if (nums[1] == 0) {
				System.out.println("연산불가!, 0으로 나눌 수 없습니다.");
				return 0;
			}
			result = remainder(nums[0], nums[1]);
			break;
		default:
			System.out.println("올바른 값을 입력해주세요.");
			break;
		}
		return result;
	}
	
	public static int sum(int a, int b) {
		return a + b;
	}
	
	public static int subtract(int a, int b) {
		return a - b;
	}
	
	public static int multiply(int a, int b) {
		return a * b;
	}
	
	public static int divide(int a, int b) {
		return a / b;
	}
	
	public static int remainder(int a, int b) {
		return a % b;
	}
}
