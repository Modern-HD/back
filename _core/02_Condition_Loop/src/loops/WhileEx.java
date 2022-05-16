package loops;

public class WhileEx {

	public static void main(String[] args) {
		// 1부터 20까지의 합 구하기 while 이용하기
		int i, sum;
		i = 0;
		sum = 0;
		while(i<20) {
			i++;
			sum += i;
		}
		System.out.println("1부터 20까지의 합: "+ sum);
		
		// 1부터 100까지의 홀수의 합 구하기 do while 이용하기
		i = 0;
		sum = 0;
		do {
			i++;
			sum += i % 2 == 1 ? i : 0;
		} while (i<100);
		System.out.println("1부터 100까지의 홀수의 합: "+ sum);
	}
	
}
