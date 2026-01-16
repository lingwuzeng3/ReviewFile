package lab1;

import java.util.Scanner;

public class sum_check_code {
	
	public static int check_code(int num, int weight) {
		if(num != 0) { 
			int last = num % 10, all_but_last = num / 10;
			return last*weight + check_code(all_but_last, weight-1);
		}
		return 0;
		
	}
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.print("Enter the first 9 digits of an ISBN as interger: ");
		int num = input.nextInt();
		
		int sum_digit = check_code(num, 9) % 11;
		if (sum_digit != 10)
			System.out.printf("The ISBN-10 number is %d%d",num, sum_digit);
		else
			System.out.printf("The ISBN-10 number is %d%c",num, 'X');
	}
}
