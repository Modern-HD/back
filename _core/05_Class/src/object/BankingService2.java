package object;

class BankAccount2 {
	String owner;
	int accNum;
	int deposit;
	
	void makeAccount(String name, int num, int money) {
		owner = name;
		accNum = num;
		deposit = money;
	}
	
	void getAccInfo() {
		System.out.println("예금주: " + getOwner());
		System.out.println("계좌번호: " + getAccNum());
		System.out.println("계좌잔액: " + getDeposit());
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
	// setters
	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public String getOwner() {
		return this.owner;
	}
	public int getAccNum() {
		return this.accNum;
	}
	public int getDeposit() {
		return this.deposit;
	}
	
}

public class BankingService2 {	
	
	public static void main(String[] args) {
		// BankAccount 클래스를 정의한다
		// BankAccount에는 예금주(owner), 계좌번호(accNum), 계좌잔액(deposit) 세팅하는 메서드
		// 위의 정보를 조회할 수 있는 메서드
		// 계좌현황조회(변경), 입금, 출금을 할 수 있다(메서드)
		
		BankAccount2 myAccount = new BankAccount2();
		myAccount.makeAccount("홍길동", 1010, 100000);
		myAccount.getAccInfo();
		myAccount.saving(100000);
		myAccount.getAccInfo();
		myAccount.withdraw(50000);
		myAccount.getAccInfo();
		myAccount.withdraw(250000);
		myAccount.getAccInfo();
		
		BankAccount2 myBA = new BankAccount2();
		myBA.setOwner("kim");
		myBA.setAccNum(1234567);
		myBA.setDeposit(0);
		System.out.println(myBA.getOwner());
		System.out.println(myBA.getAccNum());
		System.out.println(myBA.getDeposit());
	}
	
}
