package q1;
// starting code

public class Circle {

    private double x = 0;
    private double y = 0;
    private double radius = 1;

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle() {
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

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean contains(double px, double py) {
        return Math.abs(px - x) <= radius && Math.abs(py - y) <= radius;
    }

    public boolean contains(Circle c) {
        return Math.abs(c.x + c.radius - x) <= radius && Math.abs(c.y + c.radius - y) <= radius;
    }

    public boolean overlaps(Circle c) {
        return Math.abs(c.x - x) <= c.radius + radius && Math.abs(c.y - y) <= c.radius + radius;
    }
}
