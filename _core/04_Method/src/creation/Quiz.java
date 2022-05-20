package creation;

public class Quiz {

	public static void main(String[] args) {
		// 랜덤으로 정수 5개를 배열에 담는 메서드
		// 그 배열을 전달 받아 평균 연산하는 메서드
		// 정수 5개와 연산 결과를 출력하는 메서드
		// main 메서드에는 어떠힌 연산식도 있으면 안됨
		// 메서드간 데이터 전달 및 호출만 있어야함
		makeArr();
	}
	
	public static void makeArr() {
		int[] intArr = new int[5];
		for(int i = 0; i < intArr.length; i++) {
			intArr[i] = (int)Math.floor(Math.random()*100);
		}
		arrAvg(intArr);
	}
	
	public static void arrAvg(int[] intArr) {
		int sum = 0;
		double avg = 0;
		for (int i : intArr) {
			sum += i;
		}
		avg = (double)sum/intArr.length;
		printArr(intArr, avg);
	}
	
	public static void printArr(int[] intArr, double avg) {
		System.out.print("[");
		for (int i = 0; i < intArr.length; i++) {
			System.out.print(intArr[i]);
			System.out.print(i == intArr.length - 1 ? "" : ", ");
		}
		System.out.println("]");
		System.out.println("평균: " + avg);
		
	}
}
