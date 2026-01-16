package lab2;

import java.util.Scanner;

public class SplitFloat {
    public static void main( String[] args ) {
    	
    	System.out.println("请输入一个浮点数");
    	Scanner scanner = new Scanner(System.in);
    	String input = scanner.next();
    	
    	for( char t : input.toCharArray() ) {
   		if( Character.isAlphabetic(t) ) {
    			System.out.println("输入浮点数格式有误");
    			return;
    		}
   	  }
    	input.toString();
   	    double num = Double.parseDouble(input);
   	    if( num != 0 ) {
    		int inte = (int)num;
  		    double digits = num - inte;
  		    System.out.print("3.14的整数部分为：");
    		System.out.println(inte);
    		System.out.print("3.14的小数部分为：");
    		System.out.printf("%.2f",digits);
 
    	} 
    } 
}
