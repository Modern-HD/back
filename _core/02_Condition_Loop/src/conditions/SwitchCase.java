package conditions;

import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		// 영어로 계절을 입력하면(대소문자 구분하지 않음)
		// 한국어로 번역하며 출력하는 프로세스 만들어보세요
		// switch case 문으로 작성
		
		Scanner sc = new Scanner(System.in);
		System.out.println("영어로 계절을 입력해주세요");
		String fs = sc.next().toLowerCase();
		
		switch (fs) {
		case "spring":
			System.out.println("봄");
			break;
			
		case "summer":
			System.out.println("여름");
			break;
			
		case "fall":
			System.out.println("가을");
			break;
			
		case "winter":
			System.out.println("겨울");
			break;
			
		default :
			System.out.println("정확한 값을 입력해주세요");
			break;
		}
	}
	
}
