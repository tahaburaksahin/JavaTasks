// BAA-Bits/Bits.java
 
public class Bits {
    public static void main (String[] args) {
        int a = 0b11111111;   // 255 or 0xFF
        System.out.println("a = " + a);
        int b = 0x7F;         // 127
        System.out.println("b = " + b);

        a = 3; // 00...011
        System.out.println(a + " " + (a << 1) + " " +
                          (a << 2) + " " + (a << 3));
        a = -1;
        int firstByte  = a & 255;
        int secondByte = (a >> 8) & 0xFF;
        System.out.println("-1: " + secondByte + " " +
                                    firstByte);
        a = 0b1001;
        b = 0b0101;
        System.out.println("AND: " + (a & b) + "; " +
                            "OR: " + (a | b) + "; " +
                           "XOR: " + (a ^ b) + "; " +
                           " ~a: " + (~a)    + "; " +
                           " ~b: " + (~b));
    }
}
