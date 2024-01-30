public class Task4 {


    public static void main(String[] args){
        // a)
        System.out.println(true);
        System.out.println(false);

        // 127
        System.out.println(127);
        /*
        127 / 2 = 63 R = 1
        63 / 2 = 31 R = 1
        31 / 2 = 15 R = 1
        15 / 2 = 7 R = 1
        7 / 2 = 3 R = 1
        3 / 2 = 1 R = 1
        1 / 2 = 0 R = 1
        * */


        /*
        27
        27 / 2 = 13 R = 1
        13 / 2 = 6 R = 1
        6 / 2 = 3 R = 0
        3 / 2 = 1 R = 1
        1 / 2 = 0 R = 1
        * */
        System.out.println(0b11011);

        /*
        18
        18 / 2 = 9 R = 0
        9 / 2 = 4 R = 1
        4 / 2 = 2 R = 0
        2 / 2  = 1 R = 0
        1 / 2 = 0 R = 1
        * */
        System.out.println(0b10010);

        /*
        1       1       0       1       0
        1*2^4   1*2^3   0*2^2   1*2^1   0*2^0 = 16 + 8 + 0 + 2 + 0 = 26
        * */
        System.out.println(0b11010);

        System.out.println(127);
        /*
        1 111 111
        177 = 1*8^2 + 7*8^1 + 7*8^0 = 64 + 56 + 7 = 127
        * */
        System.out.println(0177);

        /* hex 0,1,2,3,4,5,6,7,8,9, A (10), B(11), C(12), D(13), E(14), F(15)
        0111 1111
        7F = 7*16^1 + 15*16^0 = 7*16+15 = 70+42+15 = 127
        * */
        System.out.println(0x7F);

        System.out.println(1.23);
        System.out.println(1.23d); // double 2^64 8 bytes max double is 2^64 - 1
        System.out.println(1.23f); // float 2^32 4 bytes

        short s = 32767;

        System.out.println((short)(s + 1));
        System.out.println(s + 1);

        System.out.println('\u005D');











    }

}
