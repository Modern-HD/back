package basic;

public class SortArray {
	
	public static void main(String[] args) {
		int[] intArr = new int[12];
		// intArr에 랜덤 정수를 넣고 순차정렬과 역정렬을 구현해 보세요
		
		// ----- 랜덤 정수 입력 및 출력 ---------
		System.out.println("랜덤 정수 입력 및 출력");
		System.out.print("[");
		for(int i=0; i<intArr.length; i++) {
			intArr[i] = (int)Math.floor(Math.random()*100);
			System.out.printf("%2d", intArr[i]);
			System.out.print(i == (intArr.length-1) ? "" : ",");
		}
		System.out.println("]");
		
		// ----------- 순차 정렬 -------------
			int count = 0;
			boolean result = true;
			while(result) {
				result = false;
				for (int i=0; i<intArr.length-1; i++) {
					if (intArr[i]>intArr[i+1]) {
						int temp = intArr[i];
						intArr[i] = intArr[i+1];
						intArr[i+1] = temp;
						result = true;
					}
				}
				count++;
			}
	
			
		// ----------- 재출력 --------------
		System.out.println("\n순차정렬");
		System.out.print("[");
		for(int i=0; i<intArr.length; i++) {
			System.out.printf("%2d", intArr[i]);
			System.out.print(i == (intArr.length-1) ? "" : ",");
		}
		System.out.println("]");
		System.out.println(count + "회 실행!");
		
		// ----------- 역정렬 -------------
		boolean result2 = true;
		while(result2) {
			result2 = false;
			for (int i=0; i<intArr.length-1; i++) {
				if (intArr[i]<intArr[i+1]) {
					int temp = intArr[i];
					intArr[i] = intArr[i+1];
					intArr[i+1] = temp;
					result2 = true;
				}
			}
		}
		
		// ----------- 재출력 --------------
		System.out.println("\n역정렬");
		System.out.print("[");
		for(int i=0; i<intArr.length; i++) {
			System.out.printf("%2d", intArr[i]);
			System.out.print(i == (intArr.length-1) ? "" : ",");
		}
		System.out.println("]");
		
	}
	
}
