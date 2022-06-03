package webservice3;

import java.util.Scanner;

public class Oracle implements DataBase{

	Scanner sc = new Scanner(System.in);
	Member[] member;
	
	public Oracle() {
		this.member = new Member[10];
		
		for (int i = 0; i < member.length; i++) {
			Member user = new Member();
			user.reset();
			member[i] = user;
		}
	}

	public Member[] getMember() {
		return member;
	}

	public void setMember(Member[] member) {
		this.member = member;
	}

	private boolean searchMember(String email) {
		boolean search = false;
		for (int i = 0; i < member.length; i++) {
			if (member[i].getEmail().equals(email)) {
				search = true;
				break;
			}
		}
		return search;
	}
	
	private int searchMemberIdx(String email) {
		int memberIdx = 0;
		for (int i = 0; i < member.length; i++) {
			if (member[i].getEmail().equals(email)) {
				memberIdx = i;
				break;
			}
		}
		return memberIdx;
	}
	
	private int searchEmptyIdx() {
		int emptyIdx = 10;
		for (int i = 0; i < member.length; i++) {
			if (member[i].getEmail() == "") {
				emptyIdx = i;
				break;
			}
		}
		return emptyIdx;
	}
	
	private boolean where(String email, String pwd) {
		int from = searchMemberIdx(email);
		if (member[from].getPwd().equals(pwd)) {
			return true;
		}
		return false;
	}
	
	private void runSelect(String email) {
		int from = searchMemberIdx(email);
		String nick = member[from].getNickname();
		int grade = member[from].getGrade();
		System.out.println("===== SQL 실행 결과 ======");
		System.out.println("PK: " + from);
		System.out.println("email: " + member[from].getEmail());
		System.out.print("비밀번호: ");
		for (int i = 0; i < member[from].getPwd().length(); i++) {
			System.out.print("*");
		}
		System.out.println("\n닉네임: " + (nick == "" ? "미입력" : nick));
		System.out.println("등급: " + (grade == 0 ? "미입력" : grade));
		System.out.println("========================");
	}
	
	@Override
	public boolean insert(String email) {
		System.out.println("Oracle > 회원 정보 입력 시도");
		if (email.length() > 2) {
			if (!searchMember(email)) {
				int from = searchEmptyIdx();
				if (from > 9) {
					System.out.println("Oracle > 회원 정보 입력 실패");
					System.out.println("저장소 한도 초과");
					return false;
				}
				member[from].setEmail(email);
				System.out.println("비밀번호를 입력해주세요 > ");
				String pwd = sc.next();
				member[from].setPwd(pwd);
			} else {
				System.out.println("Oracle > 회원 정보 입력 실패");
				System.out.println("이미 사용중인 이메일입니다.");
				return false;
			}
		} else {
			System.out.println("Oracle > 회원 정보 입력 실패");
			System.out.println("3글자 이상이어야 합니다.");
			return false;
		}
		System.out.println("Oracle > 회원 정보 입력 성공");
		return true;
	}

	@Override
	public boolean select(String email) {
		System.out.println("Oracle > 회원 정보 조회 시도");
		if (searchMember(email)) {
			int from = searchMemberIdx(email);
			System.out.println("비밀번호를 입력해주세요. > ");
			String pwd = sc.next();
			if (member[from].getPwd().equals(pwd)) {
				System.out.println("Oracle > 회원 정보 조회 성공");
			} else {
				System.out.println("Oracle > 회원 정보 조회 실패");
				System.out.println("비밀번호가 틀립니다.");
				return false;
			}
			
		} else {
			System.out.println("Oracle > 회원 정보 조회 실패");
			System.out.println("계정을 찾을 수 없습니다.");
			return false;
		}
		return true;
	}
	
	
	@Override
	public boolean select(String email, String pwd) {
		System.out.println("Oracle > 회원 정보 조회 시도");
		if (where(email, pwd)) {
			runSelect(email);
		} else {
			System.out.println("비밀번호가 다릅니다");
			return false;
		}
		return true;
	}

	@Override
	public void selectWhereId(String email) {
		runSelect(email);
	}
	
	@Override
	public boolean update(String email, int update, String set) {
		System.out.println("Oracle > 회원 정보 수정 시도");
		int from = searchMemberIdx(email);
		switch (update) {
		case 1:
			member[from].setPwd(set);
			break;
		case 2:
			member[from].setNickname(set);;
			break;
		case 3:
			int grade = 0;
			try {
				grade = Integer.parseInt(set);
			} catch (Exception e) {
				System.out.println("Oracle > 회원 정보 수정 실패");
				System.out.println("오류발생: 숫자를 입력해주세요.");
				return false;
			}
			member[from].setGrade(grade);
			break;
		}
		return true;
	}

	@Override
	public boolean delete(String email, String pwd) {
		System.out.println("Oracle > 회원 정보 조회 시도");
		if (where(email, pwd)) {
			int from = searchMemberIdx(email);
			System.out.println("Oracle > 회원 정보 조회 성공");
			member[from].reset();
		} else {
			System.out.println("Oracle > 회원 정보 조회 실패");
			System.out.println("비밀번호가 다릅니다");
			return false;
		}
		System.out.println("Oracle > 회원 정보 삭제 완료");
		return true;
	}

}
