/*
 multiply 12 by 2 24
 divide 12 by 2 6
add 5 by 4 without + and -  9

 */

public class BitwiseOperations {

    public static void main(String[] args) {
        System.out.println( " multiply 12 by 2 " + ( 12 << 1));
        System.out.println( " divide 12 by 2 " + ( 12 >> 1));
        System.out.println("add 5 by 4 without + and -  " + add(5, 4));
    }

    static int add(int x, int y)
    {
        while (y != 0)
        {
            // carry now contains common
            // set bits of x and y
            int carry = x & y;

            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;

            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry << 1;
        }
        return x;
    }
}
