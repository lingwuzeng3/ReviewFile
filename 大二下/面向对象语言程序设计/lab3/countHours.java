
public class countHours {
    static int[][] workingHours = new int[8][];
    public static void init() {
        workingHours[0] = new int[] {2,4,3,4,5,8,8,0,0};
        workingHours[1] = new int[] {7,3,4,3,3,4,4,0,1};
        workingHours[2] = new int[] {2,4,3,4,5,8,8,0,2};
        workingHours[3] = new int[] {3,3,4,3,3,2,2,0,3};
        workingHours[4] = new int[] {3,5,4,3,6,3,8,0,4};
        workingHours[5] = new int[] {3,4,4,6,3,4,4,0,5};
        workingHours[6] = new int[] {3,7,4,8,3,8,4,0,6};
        workingHours[7] = new int[] {6,3,5,9,2,7,9,0,7};
    }

    public static void main(String[] args) {
        init();
        for (int i = 0 ; i < 8 ; i ++) {
            int sum = 0;
            for (int j = 0 ; j < 7 ; j ++) {
                sum += workingHours[i][j];
            }
            workingHours[i][7] = sum;
        }
        for (int i = 0 ; i < 7 ; i ++) {
            for (int j = i + 1 ; j < 8 ; j ++) {
                int max = i;
                if (workingHours[i][7] < workingHours[j][7]) {
                    max = j;
                }
                int[] t = workingHours[i];
                workingHours[i] = workingHours[max];
                workingHours[max] = t;
            }
        }

        for (int i = 0 ; i < 8 ; i ++) {
            System.out.printf("Employee %d Total working Hours: %d\n",workingHours[i][8], workingHours[i][7]);
        }
    }
}