package quiz;

import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
		// Optional
		// 호텔 예약 프로그램
		
		boolean exit = true;
		Scanner sc = new Scanner(System.in);
		
		int[][][] hotel = new int[15][20][2];
		for(int i = 0; i < hotel.length; i++) {
			for(int j = 0; j < hotel[i].length; j++) {
					hotel[i][j][0] = (i+1)*100 + (j+1);
					hotel[i][j][1] = 0;
				}
			}
		
		do {
			int inputNum = 0;
			System.out.println("===============호텔 관리 메뉴==============");
			System.out.println("0: 현황 조회, 1: 입실, 2: 퇴실 3: 프로그램 종료");
			System.out.println("숫자를 입력해주세요 > ");
			inputNum = sc.nextInt();
			if (inputNum == 0) {
				for(int i = 0; i < hotel.length; i++) {
					for(int j = 0; j < hotel[i].length; j++) {
						System.out.print(hotel[i][j][0]+"호: " + (hotel[i][j][1] == 0 ? "입실가능" : "사용 중")+((j+1)%5==0 ? "\n" : "\t"));
					}
				}
				System.out.println();
			} else if(inputNum == 1) {
				System.out.println("입실할 호실을 입력해주세요. > ");
				inputNum = sc.nextInt();
				int floor = (int)inputNum/100 - 1;
				int room =	inputNum - (floor+1)*100 - 1;
				if (hotel[floor][room][1] == 0) {
					hotel[floor][room][1] = 1;
					System.out.println("입실완료");
				} else {
					System.out.println("이미 사용 중인 방입니다.");
				}
			} else if(inputNum == 2) {
				System.out.println("퇴실할 호실을 입력해주세요. > ");
				inputNum = sc.nextInt();
				int floor = (int)inputNum/100 - 1;
				int room =	inputNum - (floor+1)*100 - 1;
				if (hotel[floor][room][1] == 0) {
					System.out.println("빈 방입니다.");
				} else {
					hotel[floor][room][1] = 0;
					System.out.println("퇴실완료");
				}
			} else if(inputNum == 3) {
				exit = false;
			} else {
				System.out.println("올바른 숫자를 입력해주세요.");
			}
		} while(exit);
		System.out.println("프로그램을 종료합니다.");
		}
	}
