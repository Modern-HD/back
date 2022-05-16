package quiz;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		// Q1, 3자리 이상의 정수 L, 2자리 이하의 자연수 a, b를 입력받아
		// L까지의 a, b의 배수 개수를 구하세요
		
		int L, a, b, abMin;
		int aCount = 0, bCount = 0, abCount = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("3자리 이상의 정수 L을 입력해주세요 > ");
		L = sc.nextInt();
		if (L <= 99 || L >= 1000) {
			System.out.println("ERROR: 3자리 이상의 정수를 입력해주세요.");
			return;
		}
		System.out.println("2자리 이하의 자연수 a를 입력해주세요 > ");
		a = sc.nextInt();
		if (a >= 100 || a <= 0) {
			System.out.println("ERROR: 2자리 이상의 자연수를 입력해주세요.");
			return;
		}
		System.out.println("2자리 이하의 자연수 b를 입력해주세요 > ");
		b = sc.nextInt();
		if (b >= 100 || b <= 0) {
			System.out.println("ERROR: 2자리 이상의 자연수를 입력해주세요.");
			return;
		}
		abMin = a * b;
		for(int i=1; i < a*b; i++) {
			if(i%a == 0 && i%b == 0) {
				abMin = i;
				break;
			}
		}
		aCount = L/a;
		bCount = L/b;
		abCount = L/abMin;
		
		System.out.println("L까지의 a의 배수 개수: " + aCount);
		System.out.println("L까지의 b의 배수 개수: " + bCount);
		System.out.printf("a, b의 최소공배수: %d, L까지의 a, b의 최소공배수의 배수 개수: %d", abMin, abCount);
	}
	
}
