// EPZ-AbsFig/Figure.java
 
abstract class Figure {

    abstract public double getArea();
    abstract public double getPerimeter();

    static public Figure getFigMaxArea(Figure[] figs) {
        double maxarea = 0;
        Figure maxfig  = null;
        for (Figure f : figs) {
            double area = f.getArea();
            if (area > maxarea) {
                maxarea = area;
                maxfig  = f;
            }
        }
        return maxfig;
    }

    @Override
    public String toString() {
        return " area: "
              + String.format("%6.3f",getArea())
              + "; perimeter: "
              + String.format("%6.3f",getPerimeter());
    }
}
