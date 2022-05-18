package sort;

public class SelectionSort {

	public static void main(String[] args) {
		// 선택정렬
		// 전체 값중에 특정한 목적값을 선택하여 정렬하는 기법
		// 동일한 값일 경우에는 교환하지 않는다.
		
		int[] intArr = new int[10];
		
		// ----- 랜덤 정수 입력 및 출력 ---------
		System.out.println("\n랜덤 정수 입력 및 출력");
		System.out.print("[");
		for(int i=0; i<intArr.length; i++) {
			intArr[i] = (int)Math.floor(Math.random()*100);
			System.out.printf("%2d", intArr[i]);
			System.out.print(i == (intArr.length-1) ? "" : ",");
		}
		System.out.println("]");
		
		for (int i = 0; i < intArr.length; i++) {
			int minIdx = i;
			int minVal = intArr[minIdx];
			for (int j = i; j < intArr.length; j++) {
				if(intArr[j] < minVal) {
					minVal = intArr[j];
					minIdx = j;
				}
			}
			int temp = intArr[i];
			intArr[i] = intArr[minIdx];
			intArr[minIdx] = temp;
		}
		
		// ----------- 재출력 --------------
		System.out.println("\n순차정렬");
		System.out.print("[");
		for(int i=0; i<intArr.length; i++) {
			System.out.printf("%2d", intArr[i]);
			System.out.print(i == (intArr.length-1) ? "" : ",");
		}
		System.out.println("]");
	}
	
}
