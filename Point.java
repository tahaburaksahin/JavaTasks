// Taha Burak Sahin PJATK

public class Point {

        int x, y;

    private Point( int x, int y){
            this.x = x;
            this.y = y;
        }

        public static Point getPoint ( int x, int y){
            return new Point(x, y);
        }
    }
    class Rect {
        Point ul;
        Point br;

        private Rect(Point ul, Point br) {
            this.ul = ul;
            this.br = br;
        }

        public static Rect getRect(Point ul, int w, int h) {
            Point br = Point.getPoint(ul.x + w, ul.y - h);
            return new Rect(ul, br);
        }

        public static Rect getContainingRect(Point[] arr) {
            if (arr.length == 0) {
                return null; // or throw an exception
            }

            int minX = arr[0].x;
            int minY = arr[0].y;
            int maxX = arr[0].x;
            int maxY = arr[0].y;

            for (Point point : arr) {
                minX = Math.min(minX, point.x);
                minY = Math.min(minY, point.y);
                maxX = Math.max(maxX, point.x);
                maxY = Math.max(maxY, point.y);
            }

            return new Rect(Point.getPoint(minX, maxY), Point.getPoint(maxX, minY));
        }

        public void showInfo() {
            System.out.println("UL=(" + ul.x + ", " + ul.y + ") BR=(" + br.x + ", " + br.y + ")");
        }
    }
class PointsAndRects {
    public static void main(String[] args) {
        Rect rec = Rect.getRect(Point.getPoint(2, 6), 6, 4);
        rec.showInfo();

        Point[] points = {
                Point.getPoint(3, 4), Point.getPoint(5, 6),
                Point.getPoint(1, 3), Point.getPoint(5, 3),
                Point.getPoint(4, 1), Point.getPoint(3, 7)
        };

        Rect cont = Rect.getContainingRect(points);
        cont.showInfo();
    }
}
