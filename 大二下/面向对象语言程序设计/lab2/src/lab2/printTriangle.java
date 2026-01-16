package lab2;

import java.util.Scanner;
public class printTriangle {
	
	public static void printSpace( int n ) {
		if( n > 0 ) {
			System.out.print("  ");
			printSpace(n-1);
		}
	}
	
	public static void printNum( int n) {
		if( n > 1 ) {
			System.out.print(n+" ");
			printNum(n-1);
			System.out.print(n+ " ");
		} else {
			System.out.print(1+" ");
		}
	}
	
	public static void printTriangl(int n, int start) {
		if( start <= n ) {
			printSpace(n-start);
			printNum(start);
			System.out.println();
			printTriangl(n, start + 1);
		}
	}
	
	public static void main ( String[] args ) {
		Scanner input = new Scanner(System.in);		
		System.out.print("Enter the number of lines");
		
		int n = input.nextInt();
		printTriangl(n, 1);
	}
}
