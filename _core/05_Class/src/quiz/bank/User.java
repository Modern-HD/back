package quiz.bank;

public class User {
	private String name;
	private int cashAmount;
	private BankAccount account;
	
	// 생성자가 오버로딩 되면 디폴트 생성자는 사용할 수 없으므로 같이 선언해야한다.
	public User() {
		this.account = new BankAccount();
	}
	
	public User(String name) {
		this.name = name;
	}
	
	
	public User(String name, int cashAmount, BankAccount account) {
		this(name); // 위의 생성자와 겹치는 부분이므로 this(para) 형태로 축약할 수 있다.
		this.cashAmount = cashAmount;
		this.account = account;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(int cashAmount) {
		this.cashAmount = cashAmount;
	}
	public BankAccount getAccount() {
		return account;
	}
	public void setAccount(BankAccount account) {
		this.account = account;
	}
	
	public int inCome(int money) {
		if(cashAmount < money) {
			System.out.println("현금이 부족합니다. 입금 불가");
			return cashAmount;
		}
		cashAmount -= money;
		account.setBalance(account.getBalance()+money);
		return cashAmount;
	}
	
	public int outPut(int money) {
		if (account.getBalance()<money) {
			System.out.println("잔액이 부족합니다. 출금 불가");
			return account.getBalance();
		}
		account.setBalance(account.getBalance()-money);
		cashAmount += money;
		return cashAmount;
	}
	
	public int inCome(int money, BankAccount yourAccount) {
		if (account.getBalance()<money) {
			System.out.println("잔액이 부족합니다. 출금 불가");
			return account.getBalance();
		}
		account.setBalance(account.getBalance()-money);
		yourAccount.setBalance(yourAccount.getBalance()+money);
		return account.getBalance();
	}
}
