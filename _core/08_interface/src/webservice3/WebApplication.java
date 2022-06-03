package webservice3;

import java.util.Scanner;

public class WebApplication {
	
	WebService svc;
	
	Scanner sc = new Scanner(System.in);
	
	public WebApplication() {}
		// 이 곳에 웹서비스에 사용할 데이터베이스를 선택하는 메뉴를 만들고
		// 데이터베이스의 선택에 따라 MySQL, Oracle이 연결되어 작동하는 구조		
		// DataBase의 인터페이스에 정의된 insert 메서드의 return type을
		// boolean으로 변경 후 register("아이디값[3자이상]")로 전달되면 정상작동 후
		// true 리턴, 아니면 false 리턴을 하여 웹애플리케이션이 작동하도록 만들기
	
	public void webApp() {
		choiceDB();
		boolean flag = true;
		while(flag) {
			flag = choiceMenu();
		}
	}

	private void choiceDB() {
		System.out.println("1. MySQL, 2. Oracle");
		System.out.println("데이터베이스를 선택하세요 > ");
		int menu = sc.nextInt();
		svc = new WebService(menu);
	}
	
	private boolean choiceMenu() {
		System.out.println("1. 회원가입 2. 로그인 3. DB현황 etc. 프로그램 종료");
		System.out.println("메뉴를 선택해주세요 > ");
		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			register(); break;
		case 2:
			login(); break;
		case 3:
			viewDB(); break;
		default:
			return false;
		}
		return true;
	}
	
	private boolean choiceMenuAfterLogin(String email) {
		System.out.println("1. 회원정보 조회 및 수정 2. 회원 탈퇴 etc. 로그아웃");
		System.out.println("메뉴를 선택해주세요 > ");
		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			view(email); break;
		case 2:
			return resign(email);
		default:
			return false;
		}
		return true;
	}
	
	private boolean choiceMenuAfterView(String email) {
		System.out.println("1. 정보 재조회 2. 정보 수정 etc. 돌아가기");
		System.out.println("메뉴를 선택해주세요 > ");
		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			svc.view(email); break;
		case 2:
			update(email); break;
		default:
			return false;
		}
		return true;
	}
	
	private void register() {
		System.out.println("사용할 이메일을 입력해주세요 > ");
		String email = sc.next();
		svc.register(email);
	}
	
	private void login() {
		System.out.println("이메일을 입력해주세요");
		String email = sc.next();
		boolean isLogin = svc.login(email);
		while(isLogin) {
			isLogin = choiceMenuAfterLogin(email);
		}
	}
	
	private void view(String email) {
		String pwd = "";
		System.out.println("비밀번호를 입력해주세요 > ");
		pwd = sc.next();
		boolean flag = svc.view(email, pwd);
		while(flag) {
			flag = choiceMenuAfterView(email);
		}
	}
	
	private void update(String email) {
		int update = 0;
		String set = "";
		boolean isBack = false;
		System.out.println("1. 비밀번호, 2. 닉네임, 3. 등급, etc. 돌아가기");
		update = sc.nextInt();
		switch (update) {
		case 1:
			System.out.println("변경할 비밀번호를 입력해주세요 > ");
			break;
		case 2:
			System.out.println("변경할 닉네임을 입력해주세요 > ");
			break;
		case 3:
			System.out.println("변경할 등급을 입력해주세요(0: 기본값) > ");
			break;
		default:
			isBack = true;
			break;
		}
		if (!isBack) {
			set = sc.next();
			svc.edit(email, update, set);
		}
	}
	
	private boolean resign(String email) {
		String pwd = "";
		System.out.println("비밀번호를 입력해주세요 > ");
		pwd = sc.next();
		return !svc.resign(email, pwd);
	}
	
	private void viewDB() {
		System.out.println("======= DB현황 =======");
		for (int i = 0; i < svc.getDbms().getMember().length; i++) {
			String email = svc.getDbms().getMember()[i].getEmail();
			System.out.println("저장소 " + (i+1) + ". " + (email == "" ? "비었음" : email));
		}
		System.out.println("=====================");
	}
	
}
