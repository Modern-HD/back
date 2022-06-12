package hotel;

import java.util.Scanner;

public class Hotel {

	private Scanner sc;
	private HotelService svc;
	
	public Hotel() {
		sc = new Scanner(System.in);
		svc = new HotelService();
		boolean flag = true;
//		System.out.println("총 층수를 입력해주세요 > ");
//		int dFloor = sc.nextInt();
//		System.out.println("층당 방 수를 입력해주세요 > ");
//		int dRoom = sc.nextInt();
		int dFloor = 7; int dRoom = 10;
		while (flag) {
			flag = choiceMenu(dFloor, dRoom);
		}
		System.out.println("프로그램을 종료합니다.");
	}

	private boolean choiceMenu(int dFloor, int dRoom) {
		System.out.println("=========== 호텔 관리 시스템 ==========");
		System.out.println("1.객실현황 2.입실 3.퇴실 4.객실상세 5.고객조회 Etc.프로그램 종료");
		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			roomsStatus(dFloor, dRoom);
			break;
		case 2:
			enter();
			break;
		case 3:
			leave();
			break;
		case 4:
			roomDetail();
			break;
		case 5:
			userDetail();
			break;
		default:
			return false;
		}
		return true;
		
		
	}

	private void roomsStatus(int dFloor, int dRoom) {
		svc.roomsStatus(dFloor, dRoom);
	}

	private void enter() {
		System.out.println("입실할 호실을 입력해주세요 > ");
		int rno = sc.nextInt();
		if(svc.isEmpty(rno)) {
			System.out.println("며칠 뒤에 퇴실할 것인지 입력해주세요 > ");
			int plusDays = sc.nextInt();
			svc.enter(rno, plusDays, userForm());
		} else {
			System.out.println("이미 사용 중인 방입니다.");
		}
	} 

	private void leave() {
		System.out.println("퇴실할 호실을 입력해주세요 > ");
		int rno = sc.nextInt();
		if(svc.isEmpty(rno)) {
			System.out.println("빈 방 입니다.");
		} else {
			svc.leave(rno);
		}
	}

	private void roomDetail() {
		System.out.println("조회할 호실을 입력해주세요 > ");
		int rno = sc.nextInt();
		if(svc.isEmpty(rno)) {
			System.out.println("빈 방 입니다.");
		} else {
			svc.roomDetail(rno);
		}
	}

	private void userDetail() {
		System.out.println("조회할 호실을 입력해주세요 > ");
		int rno = sc.nextInt();
		if(svc.isEmpty(rno)) {
			System.out.println("빈 방 입니다.");
		} else {
			svc.userDetail(rno);
		}
	}
	
	private User userForm() {
		System.out.println("대표자명을 입력해주세요 > ");
		String uname = sc.next();
		System.out.println("전화번호를 입력해주세요 > ");
		String tel = sc.next();
		System.out.println("나이를 입력해주세요 > ");
		int age = sc.nextInt();
		System.out.println("성별을 입력해주세요 (1.남성 2.여성) > ");
		boolean gen = (sc.nextInt() % 2 == 0 ? false : true);
		return new User(uname, tel, age, gen);
	}
}
