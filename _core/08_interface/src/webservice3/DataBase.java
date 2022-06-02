package webservice3;

public interface DataBase {
	boolean insert(String email);
	boolean select(String email);
	boolean select(String email, String pwd);
	void selectWhereId(String email);
	boolean update(String email, int update, String set);
	boolean delete(String email, String pwd);
	Member[] getMember();
}
