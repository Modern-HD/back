package quiz;

public class Quiz0501 {
	
	public static void main(String[] args) {
		// 아래의 조건을 참고 및 추리하여 코드를 작성해보세요
		// a. 한 줄에 # 10개 출력
		// b. output(10, '#') 메서드를 호출
		// c. 출력문에서 for문을 이용
		
		output(10,'#');
	}

	private static void output(int num, char chr) {
		for(int i = 0; i < num; i++) {
			System.out.print(chr);
		}
	}
	
}
