package lab2;
import java.util.Scanner;
// 1 3 5 7 8 10 12 ,  2 4 6 9 11 
public class CountDays {
	
	static String[] month = new String[] {
		"Jan", "Feb", "Mar", "Apr",
		"May", "Jun", "Jul", "Aug",
		"Sep", "Oct", "Nov", "Dec"
	};
	
	static int[] monthDays = new int[] {
			31, 28, 31, 30,
			31, 30, 31, 31,
			30, 30, 30, 31,
		};
	
	public static boolean isLeapYear(int year) {
		return (year %  4 == 0 && year % 100 != 0) || year % 400 == 0;
	}
	
	public static void main (String[] args) {
		int syntaxError = 1;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter a year");
		int year = scanner.nextInt();
		
		System.out.print("Enter a Month");
		String mon = scanner.next();
		
		boolean isLeap = isLeapYear(year);
		
		if ( isLeap ) { monthDays[1] = 29; }  
		
		for( int i = 0 ; i < month.length ; i ++ ) {
			if( month[i].equals(mon) ) {
				syntaxError = 0;
				System.out.printf("%s %d has %d days.",month[i], year, monthDays[i]);
				return ;
			}
		}
		
		if( syntaxError == 1) {
			System.out.printf("%s is not a correct month", mon);
		}
		
	}
}
