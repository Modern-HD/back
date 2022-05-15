package conditions;

import java.util.Scanner;

public class RSPGame {

	public static void main(String[] args) {
		// 가위바위보 게임 만들기
		// 1. 컴퓨터가 랜덤을 가위바위보를 선택
		// 2. 나도 가위바위보를 입력
		// 3. 숭무패 결과 출력
		
		int comChoice = (int)Math.floor(Math.random()*3);
		System.out.println(comChoice);
		
		Scanner myInput = new Scanner(System.in);
		System.out.println("0: 가위, 1: 바위, 2: 보 중에 하나를 입력해주새요 > ");
		int myChoice = myInput.nextInt();
		String result;
		
		if (myChoice == comChoice) {
			System.out.println("무승부");
		} else {
			switch (myChoice) {
			case 0:
				result = comChoice == 1 ? "패배" : "승리";
				System.out.println(result);
				break;
				
			case 1:
				result = comChoice == 2 ? "패배" : "승리";
				System.out.println(result);
				break;
				
			case 2:
				result = comChoice == 0 ? "패배" : "승리";
				System.out.println(result);
				break;
				
			default:
				System.out.println("0, 1, 2 중에서 입력해주세요");
				break;
			}
		}
		System.out.println("게임종료");
		
	}
	
}
