package lab2;
import java.util.Scanner;

public class calendar {
	static String[] month = new String[] {
			"Jan", "Feb", "Mar", "Apr",
			"May", "Jun", "Jul", "Aug",
			"Sep", "Oct", "Nov", "Dec"
		};
	
	static String[] weekDay = new String[] {
			"Sun", "Mon", "Tus", "Wed",
			"Thu", "Fri", "Sat"
		};
		
	static int[] monthDays = new int[] {
			31, 28, 31, 30,
			31, 30, 31, 31,
			30, 30, 30, 31,
		};
	
	static int[] firstD = new int[12];
	
	public static boolean isLeapYear(int year) {
		return (year %  4 == 0 && year % 100 != 0) || year % 400 == 0;
	}
	
	public static void calcFirstDay(int firstDay, int month) {
		if( month < 12) {
			firstD[month] = firstDay;
			firstDay = (monthDays[month] % 7 + firstDay )%7;
			calcFirstDay(firstDay, month + 1);
		}
		
	}
	
	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter a year");
		int year = scanner.nextInt();
		
		System.out.print("Enter the week to the first day of the year (0-6)");
		int firstDay = scanner.nextInt();
		
		boolean isLeap = isLeapYear(year);
		
		if ( isLeap ) { monthDays[1] = 29; }  
		
		calcFirstDay(firstDay, 0);
		
		for( int i = 0 ; i < month.length ; i ++) {
			/*
			 * 
			 * */
			System.out.printf("\t\t\t%s %d\n",month[i], year);
			System.out.println("____________________________________________________");
			System.out.printf("  %s\t %s\t %s\t %s\t %s\t %s\t %s\t \n",
					weekDay[0], weekDay[1],weekDay[2], weekDay[3],
					weekDay[4], weekDay[5],weekDay[6]);
			
			int day = firstD[i];
			/*
			 * 
			 * */
	
			System.out.printf("  ");
			for( int k = 0 ; k < day ; k++ ) {
				System.out.printf("   \t");
			}
			for( int j = 1 ; j <= monthDays[i] ; j ++ ) {
				System.out.printf("%3d\t",j);
				day = (day + 1) % 7; 
		
				if( day == 0 ) {
					System.out.printf("\n  ");
				} // end if
			} // end for
			System.out.printf("\n\n");
		}
	}
}