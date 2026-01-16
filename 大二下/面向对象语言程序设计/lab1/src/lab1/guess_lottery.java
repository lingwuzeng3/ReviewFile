package lab1;

import java.util.Scanner;

public class guess_lottery {
	
	public static int judge(int lottery, int input) {
		if( input > 0 ) {
			int t_digit = lottery % 10, s_digit =  lottery / 10 % 10, f_digit = lottery / 100;
			int compare = input % 10;
			if( compare == t_digit || compare == s_digit || compare == f_digit) {
				return 1 + judge(lottery, input / 10);
			}
			else
				return 0 + judge(lottery, input / 10);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int lottery = (int)(Math.random() * 100);
		System.out.print("Enter your lottery pick (three digits): ");
		int lottery_n = input.nextInt();
		
		if( lottery == lottery_n )  {
			System.out.print("Exact match: you win $10,000");
		}
		else if(judge(lottery, lottery_n) == 0) {
			System.out.print("Sorry, no match");
		}
		else if(judge(lottery, lottery_n) == 3) {
			System.out.print("Match all digits but with wrong order: you win $3,000");
		}
		else {
			System.out.print("Match one digit you win $1,000");
		}
	
	}
	
}
