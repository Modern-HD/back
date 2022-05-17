package basic;

import java.util.Arrays;
import java.util.Collections;

public class SortMethod {

	public static void main(String[] args) {
		Integer[] intArr = new Integer[12];
//		int[] intArr = new int[12];
		// ----- 랜덤 정수 입력 및 출력 ---------
		System.out.println("랜덤 정수 입력 및 출력");
		System.out.print("[");
		for(int i=0; i<intArr.length; i++) {
			intArr[i] = new Integer((int)Math.floor(Math.random()*100));
//			intArr[i] = (int)Math.floor(Math.random()*100);
			System.out.printf("%2d", intArr[i]);
			System.out.print(i == (intArr.length-1) ? "" : ",");
		}
		System.out.println("]");
		
		// 순차정렬
		// 기존의 배열 자체를 바꾼다
		Arrays.sort(intArr);
		
		for (Integer i : intArr) {
			System.out.println("i: " + i);
		}
		System.out.println("----------");
		// 역정렬
		// 배열의 요소 데이터 타입이 object 여야함
		Arrays.sort(intArr, Collections.reverseOrder());
		
		for (Integer i : intArr) {
			System.out.println("i: " + i);
		}
	}
	
}
