// BGP-Point/Point.java
 
public class Point {
    private int x, y;

    public Point(int x, int yy) {
        System.out.println("Point(int,int) with " +
                            x + " and " + y);
        this.x =  x;
        y      = yy;
    }

    public Point(int x) {
        this(x,0);
        System.out.println("Point(int) with " + x);
    }

    public Point() {
        this(0);
        System.out.println("Point()");
    }

    public Point translate(int dx,int dy) {
        x += dx;
        y += dy;
        return this;
    }

    public Point scale(int sx,int sy) {
        x *= sx;
        y *= sy;
        return this;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    /**/
    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
    /**/

    public static void main(String[] args) {
        System.out.println("\n*** Creating point p1 (1,2)");
        Point p1 = new Point(1,2);

        System.out.println("\n*** Creating point p2 (1)");
        Point p2 = new Point(1);

        System.out.println("\n*** Creating point p3 ()");
        Point p3 = new Point();

        p3.translate(4,4).scale(2,3).translate(-1,-5);

        System.out.println("\np1: [" + p1.getX() + "," +
                                       p1.getY() + "]");

        System.out.println("\np1: " + p1 + "  p2: " +
                              p2 + "  p3: " + p3);
    }
}
