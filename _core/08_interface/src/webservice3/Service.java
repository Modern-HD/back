package webservice3;

public interface Service {
	void register(String email);
	boolean login(String email);
	void edit(String email, int update, String set);
	boolean view(String email, String pwd);
	void view(String email);
	boolean resign(String email, String pwd);
}
