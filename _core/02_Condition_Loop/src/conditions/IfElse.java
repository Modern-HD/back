package conditions;

import java.util.Scanner;

public class IfElse {

	public static void main(String[] args) {
		// 현재 시간을(24시간 기준)을 입력받아
		// 9시 이전이면 굿모닝 출력
		// 14시 이전이면 굿앱터눈
		// 22시 이전이면 굿나잇
		
		Scanner sc = new Scanner(System.in);
		System.out.print("현재 시간을 입력해주세요 > ");
		int now = sc.nextInt();
		
		if (now < 9) {
			System.out.println("굿모닝");
		} else if (now < 14) {
			System.out.println("굿앱터눈");
		} else if (now < 22) {
			System.out.println("굿나잇");
		} else {
			System.out.println("주무세요");
		}
				
	}
	
}
