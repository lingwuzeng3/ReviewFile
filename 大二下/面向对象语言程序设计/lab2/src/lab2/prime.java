package lab2;
import java.util.*;

public class prime {

    public static boolean isprime( int i ) {
        for ( int j = 2 ; j * j <= i ; j ++) {
            if( i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void findPrime(int [] prime, int n, int m) {
        int idx = 0;
        for( int i = n; i >= 2; i-- ) {
            if( isprime(i) ) {
                prime[idx] = i;
                if(idx >= 10 ) {
                    return;
                }
            }
        }
    }

    public static void printPrime(int[] prime) {
        for( int i = 0 ; i < prime.length ; i++ ) {
            if( i != 0 && i % 10 == 0 ) {
                System.out.println();
            } else {
                System.out.print(prime[i] + ' ');
            }
        }
    }

    public static void main(String[] args) {
   
        int m, n;
        Scanner scanner = new Scanner(System.in);
        // input
        System.out.println("请输入整数范围n和素数个数m");
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] prime = new int[n];

        findPrime(prime, n, m);
        printPrime(prime);

    }
}

