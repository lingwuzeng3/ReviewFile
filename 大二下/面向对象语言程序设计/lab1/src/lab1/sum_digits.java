package lab1;

import java.util.Scanner;

public class sum_digits {
	
	public static int sum_digi(int num) {
		if (num == 0) {
			return 0;
		}
		int last = num % 10, all_but_last = num / 10;
		return last + sum_digi(all_but_last);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.print("Enter a number between 0 and 1000: ");
		int num = input.nextInt();
		
		int sum_digit = sum_digi(num);
		System.out.print("The sum of the digits is ");
		System.out.print(sum_digit);
		
	}
}
