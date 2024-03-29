package creation;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 계산기를 만들어 보자 =====");
		System.out.println("연산자를 입력하세요 > ");
		System.out.println("+, -, *, /, %");
		String op = sc.next();
		
		System.out.println("첫번째 숫자 입력 > ");
		int num1 = sc.nextInt();
		System.out.println("두번째 숫자 입력 > ");
		int num2 = sc.nextInt();
		
		try {
			switch (op) {
			case "+":
				addition(op, num1, num2);
				break;
			case "-":
				substraction(num1, op, num2);
				break;
			case "*":
				int[] nums = {num1, num2};
				mutiplication(nums, op);
				break;
			case "/":
				double result = division(num1, op, num2);
				System.out.println(num1 + " + " + num2 + " = " + result);
				break;
			case "%":
				double[] res = modulus(num1, op, num2);
				System.out.println("/ 의 결과: " + res[0]);
				System.out.println("% 의 결과: " + res[1]);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static double[] modulus(int n1, String op, int n2) {
		double[] results = new double[2];
		results[0] = (double)n1 / n2;
		results[1] = (double)n1 % n2;
		return results;
	}

	private static double division(int n1, String op, int n2) {
		return ((double)n1/n2);
	}


	private static void mutiplication(int[] nums, String op) {
		System.out.println(nums[0] + " + " + nums[1] + " = " + (nums[0]*nums[1]));
	}

	private static void substraction(int n1, String op, int n2) {
		System.out.println(n1 + " + " + n2 + " = " + (n1+n2));
	}

	private static void addition(String op, int n1, int n2) {
		System.out.println(n1 + " + " + n2 + " = " + (n1+n2));
	}
}
