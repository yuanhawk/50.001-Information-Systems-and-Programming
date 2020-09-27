package homework1_2;

public class Main {

    public static void main(String[] args) {
        MyRectangle2D rect1 = new MyRectangle2D(0, 0, 15, 8);
        MyRectangle2D rect2 = new MyRectangle2D(10, 5, 10, 8);
        System.out.println(rect1.overlaps(rect2));
    }
}
