package lab4_java;

import java.util.Scanner;
public class inter {

    private static class Line {
        double x1, y1, x2, y2;

        public Line(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public double getA() {
            return y2- y1;
        }

        public double getB() {
            return x1 - x2;
        }
        public double getC() {
            return - y1*x2 + y2*x1;
        }
    }

    public static void main (String ... args) {
        Scanner scanner = new Scanner(System.in);
        double x1, x2, y1, y2;
        double x3, x4, y3, y4;
        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
        x1 = scanner.nextDouble();
        y1 = scanner.nextDouble();
        x2 = scanner.nextDouble();
        y2 = scanner.nextDouble();
        x3 = scanner.nextDouble();
        y3 = scanner.nextDouble();
        x4 = scanner.nextDouble();
        y4 = scanner.nextDouble();

        Line l1 = new Line(x1, y1, x2, y2);
        Line l2 = new Line(x3, y3, x4, y4);

        LinerEquation solve = new LinerEquation(
                l1.getA(), l1.getB(),
                l2.getA(), l2.getB(),
                l1.getC(), l2.getC()
        );
        if (solve.isSovable()) {
            System.out.printf("两条直线的交点是(%f, %f)\n",solve.getX(), solve.getY());
        } else {
            System.out.println("这两条直线没有交点");
        }
    }
}
