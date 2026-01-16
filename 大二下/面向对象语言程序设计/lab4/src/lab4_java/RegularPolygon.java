package lab4_java;

public class RegularPolygon {
    private int n ;
    private double side ;
    private double x ;
    private double y ;

    public RegularPolygon() {
        n = 3;
        side = 1;
        x = y = 0;
    }

    public RegularPolygon(int n, double s) {
        this.n = n;
        side = s;
        x = y = 0;
    }

    public RegularPolygon(int n, double s, double x, double y) {
        this.n = n;
        this.side = s;
        this.x = x;
        this.y = y;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPerimeter() {
        return n*side;
    }

    public double getArea() {
        return n*side*side / 4*Math.tan(Math.PI / n);
    }

    @Override
    public String toString() {
        return "RegularPolygon{" +
                "n=" + n +
                ", side=" + side +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main (String[] args) {
        RegularPolygon rp1 = new RegularPolygon(6,4);
        RegularPolygon rp2 = new RegularPolygon(10,4,5.6,7.8);
        RegularPolygon rp0 = new RegularPolygon();

        System.out.println(rp0 + "的周长为 " + rp0.getPerimeter()
            + " 面积为 " + rp0.getArea());
        System.out.println(rp1 + "的周长为 " + rp1.getPerimeter()
                + " 面积为 " + rp1.getArea());
        System.out.println(rp2 + "的周长为 " + rp2.getPerimeter()
                + " 面积为 " + rp2.getArea());

    }
}
