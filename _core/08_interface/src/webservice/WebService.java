package webservice;

import java.util.Scanner;

public class WebService implements Service {
	
	private String id;
	DataBase myDB;
	
	public WebService(Scanner sc) {
		System.out.println("1. mySQL, 2. Oracle");
		System.out.println("데이터베이스를 선택해주세요 > ");
		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			myDB = new MySQL();
			break;
		case 2:
			myDB = new Oracle();
			break;
		default:
			break;
		}
	}

	@Override
	public boolean register(Scanner sc) {
		System.out.println("아이디를 입력해주세요(3자 이상) > ");
		this.id = sc.next();
		if (this.id.length() < 3) {
			return false;
		} else {
			System.out.println("회원 가입 서비스 요청");
			myDB.insert();
			System.out.println("회원 가입 완료");
		}
		return true;
	}

	@Override
	public void login() {
		System.out.println("회원 로그인 서비스 요청");
		myDB.select();
		System.out.println("회원 로그인 완료");
	}

	@Override
	public void edit() {
		System.out.println("회원 정보 수정 서비스 요청");
		myDB.update();
		System.out.println("회원 수정 완료");
	}

	@Override
	public void resign() {
		System.out.println("회원 탈퇴 서비스 요청");
		myDB.delete();
		System.out.println("탈퇴 완료");
	}

}
