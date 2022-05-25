package quiz;

class makeStar {
	String str = "*";
	
	void print(int num) {
		for(int i = 1; i <= num; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(str);
			}
			System.out.println();
		}
	}
}

public class Quiz0602 {

	public static void main(String[] args) {
		// 아래의 조건을 참고 및 추리하여 코드를 작성해보세요.
		// a. 메서드 이용하여 별찍기
		// b. 별의 갯수 입력
		// c. 출력 예)
		// 4
		// *
		// **
		// ***
		// ****
		
		makeStar star = new makeStar();
		star.print(4);
		makeStar heart = new makeStar();
		heart.str = "♥︎";
		heart.print(5);
	}


	
}
