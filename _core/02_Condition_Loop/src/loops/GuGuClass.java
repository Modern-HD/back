package loops;

public class GuGuClass {
	
	public static void main(String[] args) {
		// 구구단을 찍어보자 => 중첩반복문으로!
		// \t 탭효과
		// ???: 한 줄로 짤코드를 누가 열줄로 만들어놨어요? 에러 찾기 힘들게
		System.out.printf("\t\t\t <gugu>\n\n\n");
		for(int i=1; i<10; i++) {
			for(int j=2; j<6; j++) {
				System.out.printf("%d × %d = %2d\t", j, i, j*i);
			}
			System.out.println();
		}
		System.out.println();
		for(int i=1; i<10; i++) {
			for(int j=6; j<10; j++) {
				System.out.printf("%d × %d = %2d\t", j, i, j*i);
			}
			System.out.println();
		}
	}
}
