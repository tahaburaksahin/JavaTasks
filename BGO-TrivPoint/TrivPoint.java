// BGO-TrivPoint/TrivPoint.java
 
public class TrivPoint {
    public int x, y;

    public void translate(int dx,int dy) {
        x += dx;
        y += dy;
    }

    public void scale(int sx,int sy) {
        x *= sx;
        y *= sy;
    }

      // setters
    public void setX(int x) {
        this.x = x;     // this required
    }
    public void setY(int yy) {
        y = yy;         // this.y assumed
    }

      // getters
    public int getX() {
        return this.x;
    }
    public int getY() {
        return y;       // this assumed
    }

      // static
    public static void infoStatic(TrivPoint p) {
        System.out.println("[" + p.x + "," + p.y + "]");
    }

      // non-static
    public void info() {
        System.out.println("[" + this.x + "," + y + "]");
    }
}
