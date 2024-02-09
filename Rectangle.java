// EPZ-AbsFig/Rectangle.java
 
public class Rectangle extends Figure {
    private double a, b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        return a*b;
    }

    @Override
    public double getPerimeter() {
        return 2*(a+b);
    }

    @Override
    public String toString() {
        return "Rectangle (a=" + a + " b=" + b + ")"
              + super.toString();
    }
}
