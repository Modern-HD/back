package quiz;

public class Quiz3 {

	public static void main(String[] args) {
		// Q3. 아래와 같은 출력문을 만들어보세요
		// ABCDEFHIJKLMNOPQRSTUVWXYZ
		// ABCDEFHIJKLMNOPQRSTUVWXY
		// ABCDEFHIJKLMNOPQRSTUVWX
		// ...
		// ..
		// AB
		// A
		int startNum = 65;
		int endNum = 90;
		for(int j = endNum; j>=startNum; j--) {
			String str = "";
			for(int i=startNum; i<=j; i++) {
				str += (char)i;
			}
			System.out.println(str);
		}
	}
}
