package quiz;

import java.util.Scanner;

public class Quiz0506 {

	public static void main(String[] args) {
		// 아래의 조건을 참고 및 추리하여 코드를 작성해보세요
		// a. 5번 문제의 연산을 담당할 메서드의 파라미터의 자료형을 배열형으로 변환하기
		
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
		case 0: result = sum(nums); break;
		case 1: result = subtract(nums); break;
		case 2: result = multiply(nums); break;
		case 3:
			if (nums[1] == 0) {
				System.out.println("연산불가!, 0으로 나눌 수 없습니다.");
				return 0;
			}
			result = divide(nums);
			break;
		case 4:
			if (nums[1] == 0) {
				System.out.println("연산불가!, 0으로 나눌 수 없습니다.");
				return 0;
			}
			result = remainder(nums);
			break;
		default:
			System.out.println("올바른 값을 입력해주세요.");
			break;
		}
		return result;
	}
	
	public static int sum(int[] nums) {
		return nums[0] + nums[1];
	}
	
	public static int subtract(int[] nums) {
		return nums[0] - nums[1];
	}
	
	public static int multiply(int[] nums) {
		return nums[0] * nums[1];
	}
	
	public static int divide(int[] nums) {
		return nums[0] / nums[1];
	}
	
	public static int remainder(int[] nums) {
		return nums[0] % nums[1];
	}
}
