package quiz;

import java.util.Scanner;

public class Quiz1 {
	
	public static void main(String[] args) {
		// 24절기 맞추기 게임
		String[] seasonal = {
				"입춘", "우수", "경칩", "춘분",
				"청명", "곡우", "입하",
				"소만", "망종", "하지", "소서", "대서",
				"입추", "처서", "백로", "추분",
				"한로", "상강", "입동",
				"소설", "대설", "동지", "소한", "대한"
		};
		// ? 번째 절기는 무엇입니까? >
		// 정답 or 오답입니다 > 정답은 ?
		// 몇 번 시도했는지 출력
		
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		int quizNum = (int)Math.floor(Math.random()*24);
//		int quizNum = 24;
		while(true) {
			System.out.printf("%d 번째 절기는 무엇입니까? > \n", quizNum+1);
			String myAns = (String)sc.next();
			count++;
			if(seasonal[quizNum].compareTo(myAns) == 0) {
				break;
			} else {
				System.out.println("오답!");
			}
		}
		System.out.printf("정답! %d회 시도하셨습니다.\n", count);
	}
	
}
