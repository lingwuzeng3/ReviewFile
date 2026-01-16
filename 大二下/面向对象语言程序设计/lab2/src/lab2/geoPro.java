package lab2;

import java.util.Scanner;

public class geoPro {
	
	public static void calcArea() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入半径： ");
		double r = scanner.nextDouble();
		System.out.printf("圆的面积是%.2f\n",Math.PI*r*r);
	}
	
	public static void convertDay() {
		 String[] weekDay = new String[] {
				 "null","星期一", "星期二", "星期三",
				"星期四", "星期五", "星期六","星期天"
			};
		 System.out.print("请输入星期(用数字1-7代表)：");
		Scanner scanner = new Scanner(System.in);
		int day = scanner.nextInt();
		System.out.println(weekDay[day]);
	}
	
	public static void testString() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入一个字符串");
		String s1 = scanner.next();
		System.out.print("请输入一个字符串");
		String s2 = scanner.next();
		
		if( s1.contains(s2) ) {
			System.out.printf("%s是%s的子串",s2 , s1);
		} else {
			System.out.printf("%s不是%s的子串",s2 , s1);
		}
	}
	
	public static void oddEven() {
		 System.out.print("请输入一个数：");
			Scanner scanner = new Scanner(System.in);
			int num = scanner.nextInt();
			
			if( num % 2 == 0 ) {
				System.out.printf("%d是偶数\n", num);
			} else {
				System.out.printf("%d是奇数\n", num);
			}
	}
	
	public static void main (String[] args) {
//		calcArea();
//		convertDay();
//		oddEven();
		testString();
	}
 }
