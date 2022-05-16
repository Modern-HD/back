package loops;

import java.util.Iterator;
import java.util.Scanner;

public class ForEx {

	public static void main(String[] args) {
		// 원하는 단을 입력하여 그 단의 구구단을 출력
		// for문 이용하기
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 단을 입력하세요");
		int inputNum = sc.nextInt();
		
		for (int i = 1; i<10; i++) {
			System.out.printf("%d X %d = %2d\n", inputNum, i, inputNum*i);
		}
	}
	
}
