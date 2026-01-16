package midterm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class presudoRandom {
    public static final int seed = 50;
    public static final Random RANDOM = new Random(seed);

    // 选择排序
    public static void Sort(int[] arr) {
        int len = arr.length;
        for (int i = 0 ; i < len - 1; i ++) {
            for (int j = i + 1 ; j < len ; j ++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void genRandom(int n) {
        int[]arr = new int[n];
        for (int i = 0 ; i < n ; i ++) {
            arr[i] = RANDOM.nextInt(100);
        }
        Sort(arr);
        System.out.print("输出后的数组为: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter an integar");
        int n = scanner.nextInt();
        genRandom(n);
    }
}
