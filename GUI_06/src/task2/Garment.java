package task2;

public class Garment implements Comparable<Garment> {
    private double price;
    private Size size;
    private String color;
    private String pattern;
    private String material;

    public Garment(double price, Size size, String color, String pattern, String material) {
        this.price = price;
        this.size = size;
        this.color = color;
        this.pattern = pattern;
        this.material = material;
    }

    @Override
    public String toString() {
        return "Garment{" +
                "price=" + price +
                ", size=" + size +
                ", color='" + color + '\'' +
                ", pattern='" + pattern + '\'' +
                ", material='" + material + '\'' +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public Size getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getPattern() {
        return pattern;
    }

    public String getMaterial() {
        return material;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Garment o) {
        return this.size.ordinal() - o.size.ordinal();
    }
}
