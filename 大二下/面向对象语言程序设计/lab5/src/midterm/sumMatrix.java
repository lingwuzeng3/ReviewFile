package midterm;
import java.util.Random;
import java.util.Scanner;

public class sumMatrix {
    public static final int seed = 50;
    public static final Random RANDOM = new Random(seed);

    public static double sumM(double[][] arr) {
        int row = arr.length;
        int column = arr[0].length;
        double sum = 0;
        for (int i = 0 ; i < row ; i++) {
            sum += arr[i][i];
            sum += arr[i][column-i-1];
        }
        return sum;
    }

    public static void init(double[][] arr) {
        int row = arr.length;
        int column = arr[0].length;
        for (int i = 0 ; i < row ; i ++) {
            for (int j = 0 ; j < column ; j ++) {
                arr[i][j] = RANDOM.nextInt(100);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter an integar");
        int n = scanner.nextInt();
        double[][] arr = new double[n][n];
        init(arr);
        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                System.out.printf("%.2f ", arr[i][j] );
            }
            System.out.println();
        }
        double sum = sumM(arr);
        System.out.print("两条对角线之和为: ");
        System.out.println(sum);
    }
}
