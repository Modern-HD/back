package quiz;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		// 숫자 야구 게임
		int[] comNums = new int[3];
		int[] myNums = new int[3];
		int[] results = new int[3];
		int count = 0;
		boolean result = true;
		Scanner sc = new Scanner(System.in);
		
		do {
			int ranNum = (int)Math.floor(Math.random()*9)+1;
			comNums[0] = ranNum;
			for(int i = 1; i < comNums.length; i++) {
				for(int j = 0; j < i; j++) {
					ranNum = (int)Math.floor(Math.random()*9)+1;
					if (ranNum == comNums[j]) {
						j--;
						continue;
					}
				}
				comNums[i] = ranNum;
			}
			for (int i : comNums) {
				System.out.printf("%d,", i);
			}
		
			System.out.println();
			
			for(int i = 0; i < myNums.length; i++) {
				System.out.println(i+1 + "번째 번호를 입력해주세요");
				myNums[i] = sc.nextInt();
			}
			
			int strike = 0;
			int ball = 0;
			boolean isOut = true;
			
			for(int i = 0; i < comNums.length; i++) {
				for(int j = 0; j < myNums.length; j++) {
					if (comNums[i] == myNums[j]) {
						isOut = false;
						if(i == j) {
							strike++; 
						} else {
							ball++;
						}
					}
				}
			}
			if(isOut) {
				results[2] += 1;
				System.out.println("아웃입니다!");
			} else {
				System.out.print("스트라이크: ");
				System.out.print(strike == 0 ? "X" : "");
				for(int i = 0; i < strike; i++) {
					System.out.print("⦿");
				}
				System.out.print(", 볼: ");
				System.out.print(ball == 0 ? "X" : "");
				for(int i = 0; i < ball; i++) {
					System.out.print("◯");
				}
				System.out.println();
				results[0] += strike;
				results[1] += ball;
			}
			count++;
			System.out.printf("현재 상황 S: %d, B: %d, O: %d, 시도횟수: %d\n", results[0], results[1], results[2], count);
			
			if(results[0]>=3) {
				System.out.println("게임종료");
				result = false;
			}
			
		} while(result);
		
		}
	}
	
