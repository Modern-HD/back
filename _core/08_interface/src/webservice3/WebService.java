package webservice3;

public class WebService implements Service {
	
	DataBase dbms;
	
	public WebService() {}

	public WebService(int db) {
		dbms = db > 1 ? new Oracle() : new MySQL();
	}

	public DataBase getDbms() {
		return dbms;
	}

	public void setDbms(DataBase dbms) {
		this.dbms = dbms;
	}

	@Override
	public void register(String email) {
		System.out.println("회원가입 서비스 요청");
		System.out.println("회원가입" + (dbms.insert(email) ? "완료" : "실패"));
	}

	@Override
	public boolean login(String email) {
		System.out.println("회원로그인 서비스 요청");
		boolean isSelect = dbms.select(email);
		System.out.println("로그인 " + (isSelect ? "성공" : "실패"));
		return isSelect;
	}
	
	@Override
	public boolean view(String email, String pwd) {
		System.out.println("정보 조회 서비스 요청");
		boolean isSelect = dbms.select(email, pwd);
		System.out.println("조회 " + (isSelect ? "성공" : "실패"));
		return isSelect;
	}

	@Override
	public void view(String email) {
		System.out.println("정보 조회 서비스 요청");
		dbms.selectWhereId(email);
		System.out.println("조회 성공");
	}
	
	@Override
	public void edit(String email, int update, String set) {
		System.out.println("회원 정보 수정 서비스 요청");
		boolean isUpdate = dbms.update(email, update, set);
		System.out.println("수정 " + (isUpdate ? "성공" : "실패"));
	}

	@Override
	public boolean resign(String email, String pwd) {
		System.out.println("회원 탈퇴 서비스");
		boolean isDelete = dbms.delete(email, pwd);
		System.out.println("탈퇴 " + (isDelete ? "성공" : "실패"));
		return isDelete;
	}



}
