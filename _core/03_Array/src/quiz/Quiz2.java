package quiz;

import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		// 테스트에 참여할 인원수를 입력하세요 >
		// 1번째 사람의 이름을 입력하세요 >
		// 1번째 사람의 국어점수 입력 >
		// 1번째 사람의 영어점수 입력 >
		// ....
		// 3번째 사람의 수학점수 입력 >
		
		// 이름 국어 영어 수학 총점 평균
		// aaa  88 99  87 ?    ?
		// .........
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("테스트에 참여할 인원수를 입력하세요");
		int inputNum = sc.nextInt();
		String[][] students = new String[inputNum][4];
		for(int i = 0; i < students.length; i++) {
			System.out.println(i+1 + " 번째 사람의 이름을 입력해주세요 > ");
			String name = sc.next();
			students[i][0] = name;
			
			System.out.println(students[i][0] + "의 국어 점수를 입력해주세요 > ");
			String korean = sc.next();
			students[i][1] = korean;
			
			System.out.println(students[i][0] + "의 영어 점수를 입력해주세요 > ");
			String eng = sc.next();
			students[i][2] = eng;
			
			System.out.println(students[i][0] + "의 수학 점수를 입력해주세요 > ");
			String math = sc.next();
			students[i][3] = math;
		}
		System.out.println("\n\t\t<성적발표>\n");
		System.out.printf("%4s\t %3s\t %3s\t %3s\t %3s\t %4s\n","이름", "국어", "영어", "수학", "총점" , "평균");
		for(int i = 0; i < students.length; i++) {
			int sum = Integer.parseInt(students[i][1]) + Integer.parseInt(students[i][2]) + Integer.parseInt(students[i][3]);
			float avg = sum/(float)3;
			System.out.printf("%4s\t %3s\t %3s\t %3s\t %3d\t %4.1f\n", students[i][0],students[i][1], students[i][2], students[i][3], sum, avg);
		}
	}
	
}
