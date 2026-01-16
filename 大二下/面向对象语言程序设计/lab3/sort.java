import java.util.Scanner;

import org.junit.Test;
import static org.junit.Assert.*;

public class sort {
    public static boolean isSorted(int [] list) {
        for (int i = 1 ; i < list.length ; i ++) {
            if (list[i] < list[i-1]) {
                return false;
            }
        }
        return true;
    }
    @Test
    public void test () {
        int[] t1 = new int[] {1,2,3,4,4};
        int[] t2 = new int[] {1};
        int[] t3 = new int[] {12,1,353};

        assertTrue(isSorted(t1));
        assertTrue(isSorted(t2));
        assertFalse(isSorted(t3));

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.print("Enter the contents of the array: ");
        for ( int i = 0 ; i < size ; i ++) {
            arr[i] = scanner.nextInt();
        }
        if (isSorted(arr)) {
            System.out.println("The list is sorted.");
        } else {
            System.out.println("The list is not sorted.");
        }
     }
}