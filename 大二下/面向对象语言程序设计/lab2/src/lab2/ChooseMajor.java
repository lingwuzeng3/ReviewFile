package lab2;

import java.util.Scanner;
public class ChooseMajor {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Enter two characters");
		
		String input = scanner.next();
		char[] code = input.toCharArray();
		
			if( code[0] == 'M' ) {
				System.out.print("Mathematics ");
			} else if( code[0] == 'C' ) {
				System.out.print("Computer Science ");
			} else if( code[0] == 'I') {
				System.out.print("Information Technology ");
			} else {
				System.out.print("Invaild Input");
				return;
			}
			if( code[1] == '1' ) {
				System.out.print("Freshman ");
			} else if( code[1] == '2' ) {
				System.out.print("senior");
			} else if( code[1] == '3') {
				System.out.print("Junior");
			} else if( code[1] == '4') {
				System.out.print("´óËÄ");
			}else {
				System.out.print("Invaild Input");
				return;
			}
	}
}
