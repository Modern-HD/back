package creation;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		// 숫자 야구 게임
		int[] comNums = new int[3];
		int[] myNums = new int[3];
		int[] results = new int[3];
		int[] setResults = new int[3];
		int count = 0;
		boolean result = true;
		
		do {
			comNums = makeComNums();
			printComNums(comNums);
			System.out.println();
			myNums = inputMyNums();
			setResults = gameStart(comNums, myNums);
			
			results[0] += setResults[0];
			results[1] += setResults[1];
			results[2] += setResults[2];
			count++;
			System.out.printf("현재 상황 S: %d, B: %d, O: %d, 시도횟수: %d\n", results[0], results[1], results[2], count);
			
			if(results[0]>=3) {
				System.out.println("게임종료");
				result = false;
			}
			
		} while(result);
		
	}

	private static int[] gameStart(int[] comNums, int[] myNums) {
		boolean isOut = true;
		int[] setResults = new int[3];
		
		for (int i = 0; i < setResults.length; i++) {
			setResults[i] = 0;
		}
		
		for(int i = 0; i < comNums.length; i++) {
			for(int j = 0; j < myNums.length; j++) {
				if (comNums[i] == myNums[j]) {
					isOut = false;
					if(i == j) {
						setResults[0]++; 
					} else {
						setResults[1]++; 
					}
				}
			}
		}
		if(isOut) {
			System.out.println("아웃입니다!");
			setResults[2]++;
		} else {
			System.out.print("스트라이크: ");
			System.out.print(setResults[0] == 0 ? "X" : "");
			for(int i = 0; i < setResults[0]; i++) {
				System.out.print("⦿");
			}
			System.out.print(", 볼: ");
			System.out.print(setResults[1] == 0 ? "X" : "");
			for(int i = 0; i < setResults[1]; i++) {
				System.out.print("◯");
			}
			System.out.println();
		}
		return setResults;
	}

	private static void printComNums(int[] comNums) {
		for (int i : comNums) {
			System.out.printf("%d,", i);
		}
	}

	private static int[] inputMyNums() {
		Scanner sc = new Scanner(System.in);
		
		int[] intArr = new int[3];
			for(int i = 0; i < intArr.length; i++) {
				System.out.println(i+1 + "번째 번호를 입력해주세요");
				intArr[i] = sc.nextInt();
			}
		return intArr;
	}

	private static int[] makeComNums() {
		int[] intArr = new int[3];
		for(int i = 0; i<intArr.length; i++) {
			int ranNum = (int)Math.floor(Math.random()*9)+1;
			for(int j = 0; j<i; j++) {
				if(ranNum == intArr[j]) {
					j--;
					ranNum = (int)Math.floor(Math.random()*9)+1;
				}
			}
			intArr[i] = ranNum;
		}
		return intArr;
	}
	
	
}
	
