package object;

class BankAccount {
	String owner;
	int accNum;
	int deposit;
	
	void makeAccount(String name, int num, int money) {
		owner = name;
		accNum = num;
		deposit = money;
	}
	
	void getAccInfo() {
		System.out.println("예금주: " + owner);
		System.out.println("계좌번호: " + accNum);
		System.out.println("계좌잔액: " + deposit);
	}
	
	int saving(int money) {
		deposit += money;
		return deposit;
	}
	
	int withdraw(int money) {
		if(money > deposit) {
			System.out.println("잔액부족");
			return 0;
		} else {
			deposit -= money;
			return deposit;
		}

	}
	
}

public class BankingService {	
	
	public static void main(String[] args) {
		// BankAccount 클래스를 정의한다
		// BankAccount에는 예금주(owner), 계좌번호(accNum), 계좌잔액(deposit)
		// 계좌현황조회, 입금, 출금을 할 수 있다(메서드)
		
		BankAccount myAccount = new BankAccount();
		myAccount.makeAccount("홍길동", 1010, 100000);
		myAccount.getAccInfo();
		myAccount.saving(100000);
		myAccount.getAccInfo();
		myAccount.withdraw(50000);
		myAccount.getAccInfo();
		myAccount.withdraw(250000);
		myAccount.getAccInfo();
	}
	
}
