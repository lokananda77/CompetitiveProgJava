package interview_prep;

import java.util.Scanner;

public class Euler165 {
	public static boolean chkIfConDigitSumGrtNine(int i, int start, int len) {
		int partSum = 0;
		int j = 0;
		while(i != 0 && j + start < len) {
			if (j > start) {
				System.out.println(i%10);
				partSum += i%10;
				i = i / 10;
				
				if (partSum > 9)
					return false;
			}
			j = j + 1;
		}
		return true;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int len = String.valueOf(i).length();
		for (int k = 0; k < len - 3; k++) {
			System.out.println(chkIfConDigitSumGrtNine(i, k, 3));
		}
		//System.out.println(partSum);
	}
}
