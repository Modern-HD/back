package quiz.bank;

public class Banker {

	public static void main(String[] args) {
		// 은행계좌 개설하기 2개 (myBA, urBA)
		
		// 잔액 조회 기능 구현
		
		// 입금, 출금 기능 구현

		BankAccount myBA = new BankAccount(); // 길동의 계좌 개설
		User itsMe = new User("홍길동", 1000000, myBA); // 길동의 User 객체 생성
		BankAccount urBA = new BankAccount(); // 철수의 계좌 개설
		User itsU = new User("김철수", 500000, urBA); // 철수의 User 객체 생성
		
		System.out.println("홍길동 현금: " + itsMe.getCashAmount()); // 길동의 현금 확인
		System.out.println("홍길동 계좌 잔액: " + itsMe.getAccount().getBalance()); // 길동의 계좌 잔액 확인
		System.out.println("김철수 현금: " + itsU.getCashAmount()); // 철수의 현금 확인
		System.out.println("김철수 계좌 잔액: " + itsU.getAccount().getBalance()); // 철수의 계좌 잔액 확인
		itsMe.inCome(500000);
		itsU.inCome(125000);
		System.out.println("====길동 50만원 입금, 철수의 12만5천원 입금======");
		System.out.println("홍길동 현금: " + itsMe.getCashAmount()); // 길동의 현금 확인
		System.out.println("홍길동 계좌 잔액: " + itsMe.getAccount().getBalance()); // 길동의 계좌 잔액 확인
		System.out.println("김철수 현금: " + itsU.getCashAmount()); // 철수의 현금 확인
		System.out.println("김철수 계좌 잔액: " + itsU.getAccount().getBalance()); // 철수의 계좌 잔액 확인
		itsMe.inCome(250000, urBA);
		System.out.println("====길동이 철수에게 25만원 계좌이체======");
		System.out.println("홍길동 계좌 잔액: " + itsMe.getAccount().getBalance()); // 길동의 계좌 잔액 확인
		System.out.println("김철수 계좌 잔액: " + itsU.getAccount().getBalance()); // 철수의 계좌 잔액 확인
		
		
	}

}
