package lab4_java;

import java.util.Scanner;

public class LinerEquation {
    private double a, b, c, d, e, f;

    public LinerEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }

    public boolean isSovable () {
        return a*d - b*c != 0;
    }

    public double getX() {
        return (e*d - b*f) / (a*d - b*c);
    }

    public double getY() {
        return (a*f - e*c) / (a*d - b*c);
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a, b, c, d, e, f: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        double e = scanner.nextDouble();
        double f = scanner.nextDouble();

        LinerEquation le = new LinerEquation(a, b, c, d, e, f);
        if (le.isSovable()) {
            System.out.printf("x is %.1f, y is %.1f", le.getX(), le.getY());
        } else {
            System.out.println("The equation has no solution.");
        }

    }
}
