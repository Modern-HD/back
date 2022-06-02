package webservice;

public class Oracle implements DataBase {

	@Override
	public void insert() {
		System.out.print("Oracle: ");
		System.out.println("데이터베이스에 회원 정보를 입력하였습니다.");
	}

	@Override
	public void select() {
		System.out.print("Oracle: ");
		System.out.println("데이터베이스에서 회원 정보를 조회하였습니다.");
	}

	@Override
	public void update() {
		System.out.print("Oracle: ");
		System.out.println("데이터베이스에서 회원 정보를 수정하였습니다.");
	}

	@Override
	public void delete() {
		System.out.print("Oracle: ");
		System.out.println("데이터베이스에서 회원 정보를 삭제하였습니다.");
	}

}
