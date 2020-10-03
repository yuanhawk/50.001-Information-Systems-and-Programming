package homework1_2;

public class MyRectangle2D {

    private double x = 0.0;
    private double y = 0.0;
    private double width = 1.0;
    private double height = 1.0;

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public MyRectangle2D() {
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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * width + 2 * height;
    }

    public boolean contains(double x, double y) {
        if (x >= this.x && x <= this.x + width) {
            if (y >= this.y && y <= this.y + height) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(MyRectangle2D r) {
        if (r.getX() >= this.x && r.getX() + r.getWidth() <= this.x + width) {
            if (r.getY() >= this.y && r.getY() + r.getHeight() <= this.y + height) {
                return true;
            }
        }
        return false;
    }

    public boolean overlaps(MyRectangle2D r) {
        if (r.getX() + r.getWidth() < this.x) {
            return false;
        } else if (r.getY() + r.getHeight() < this.y) {
            return false;
        } else if (r.getX() > this.x + width) {
            return false;
        } else if (r.getY() > this.y + height) {
            return false;
        }
        return true;
    }
}
