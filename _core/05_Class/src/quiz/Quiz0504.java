package quiz;

import java.util.Scanner;

public class Quiz0504 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 아래의 조건을 참고 및 추리하여 코드를 작성해보세요
		// a. 나머지 연산을 포함한 사칙연산 계산기 만들기
		// b. main 메서드는 각 기능을 담당할 메서드만 호출함
		// c. 각 연산 메서드는 반환형과 파라미터가 없다
		// d. 모든 멤버들은 static 이다.
		
		sum();
		subtract();
		multiply();
		divide();
		remainder();
	}
	
	public static void sum() {
		int[] nums = new int[2];
		for(int i=0; i<nums.length; i++) {
			System.out.println((i+1) + "번째 수를 입력하세요. > ");
			int num = sc.nextInt();
			nums[i] = num;
		}
		System.out.println("결과: " + (nums[0]+nums[1]));
	}
	
	public static void subtract() {
		int[] nums = new int[2];
		for(int i=0; i<nums.length; i++) {
			System.out.println((i+1) + "번째 수를 입력하세요. > ");
			int num = sc.nextInt();
			nums[i] = num;
		}
		System.out.println("결과: " + (nums[0]-nums[1]));
	}
	
	public static void multiply() {
		int[] nums = new int[2];
		for(int i=0; i<nums.length; i++) {
			System.out.println((i+1) + "번째 수를 입력하세요. > ");
			int num = sc.nextInt();
			nums[i] = num;
		}
		System.out.println("결과: " + (nums[0]*nums[1]));
	}
	
	public static void divide() {
		int[] nums = new int[2];
		for(int i=0; i<nums.length; i++) {
			System.out.println((i+1) + "번째 수를 입력하세요. > ");
			int num = sc.nextInt();
			if (i == 1 && num == 0) {
				System.out.println("0은 입력하실 수 없습니다.");
				i--;
				continue;
			}
			nums[i] = num;
		}
		System.out.println("결과: " + (nums[0]/nums[1]));
	}
	
	public static void remainder() {
		int[] nums = new int[2];
		for(int i=0; i<nums.length; i++) {
			System.out.println((i+1) + "번째 수를 입력하세요. > ");
			int num = sc.nextInt();
			if (i == 1 && num == 0) {
				System.out.println("0은 입력하실 수 없습니다.");
				i--;
				continue;
			}
			nums[i] = num;
		}
		System.out.println("결과: " + (nums[0]%nums[1]));
	}
	
}
