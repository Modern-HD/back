package set;

import java.util.HashSet;
import java.util.Set;

public class SetEx1 {

	
	public static void main(String[] args) {
		int count = 0;
		Set set = new HashSet();
		
		while (set.size() < 10) {
			set.add(randNum(1, 10));
			count++;
		}

		System.out.println(set);
		System.out.println("총 " + count + "회 실행");
		
	}
	
	private static int randNum(int min, int max) {
		return (int)Math.floor(Math.random()*(max-min+1))+ min;
	}

}
