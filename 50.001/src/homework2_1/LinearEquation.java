package homework2_1;

public class LinearEquation {

    private double a = 0.0;
    private double b = 0.0;
    private double c = 0.0;
    private double d = 0.0;
    private double e = 0.0;
    private double f = 0.0;

    private double denominator = 0.0;

    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public boolean isSolvable() {
        denominator = a * d - b * c;
        return denominator != 0.0;
    }

    public double getX() {
        if (isSolvable()) {
            return (e * d - b * f) / denominator;
        }
        return 0.0;
    }

    public double getY() {
        if (isSolvable()) {
            return (a * f - c * e) / denominator;
        }
        return 0.0;
    }
}
