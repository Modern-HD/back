package webservice;

import java.util.Scanner;

public class WebApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Service svc = new WebService(sc);
//		svc.register();
//		svc.login();
		// 이 곳에 웹서비스에 사용할 데이터베이스를 선택하는 메뉴를 만들고
		// 데이터베이스의 선택에 따라 MySQL, Oracle이 연결되어 작동하는 구조를
		// DataBase의 인터페이스에서 정의된 register 메서드의 return type을 boolean으로 변경 후
		// register("아이디값[3자이상]")로 전달되면 정상작동 후 true 리턴, false 리턴을 하여
		// 웹애플리케이션이 작동하도록 만들기
		
		boolean flag = svc.register(sc);
		if (flag) {
			while (flag) {
				System.out.println("1. 로그인, 2. 회원 정보 수정, 3. 회원 탈퇴 요청, etc. 종료");
				System.out.println("서비스를 선택해주세요 > ");
				int menu = sc.nextInt();
				switch (menu) {
				case 1:
					svc.login();
					break;
				case 2:
					svc.edit();
					break;
				case 3:
					svc.resign();
					break;
				default:
					flag = false;
					break;
				}
			}
		} else {
			System.out.println("아이디가 3자 미만입니다.");
			System.out.println("서비스를 이용하실 수 없습니다.");
		}
		System.out.println("프로그램을 종료합니다.");
	}
	
}
