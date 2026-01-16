package lab4_java;

public class Circle2D {
    private double x, y;
    private double radius;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public Circle2D () {
        x = y = 0;
        radius = 1;
    }

    public Circle2D (double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public double getArea () {
        return Math.PI*radius*radius;
    }

    public double getPerimeter () {
        return 2*Math.PI*radius;
    }

    public boolean contains ( double x, double y ) {
        double dx = this.x - x;
        double dy = this.y - y;
        return Math.sqrt(dx*dx + dy*dy) - radius <= 0;
    }

    public boolean contains (Circle2D c) {
        double dx = this.x - c.getX();
        double dy = this.y - c.getY();
        return Math.sqrt(dx*dx + dy*dy) <= this.getRadius() - c.getRadius();
    }

    public boolean overlaps(Circle2D c) {
        double dx = this.x - c.getX();
        double dy = this.y - c.getY();
        return Math.sqrt(dx*dx + dy*dy) <= this.getRadius() + c.getRadius();
    }

    public static void main (String[] args) {
        Circle2D c1 = new Circle2D(2,2,5.5);
        System.out.println(c1.contains(3,3));
        System.out.println(c1.contains(new Circle2D(4,5,10.5)));
        System.out.println(c1.overlaps(new Circle2D(3,5,2.3)));
    }
}
