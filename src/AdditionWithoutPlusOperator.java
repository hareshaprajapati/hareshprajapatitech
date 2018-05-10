import java.io.*;

/*


 */

class AdditionWithoutPlusOperator {
    static int Add(int x, int y) {


        // Iterate till there is no carry
        while (y != 0) {
            // carry now contains common
            // set bits of x and y

            int carry = x & y; // + operation
//            int carry = ~x & y; // - operation
// below 3 steps are alternative of &
//            int or = x | y;
//            int xor = ~x ^ y;
//            int carry = or ^ xor;


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

    // Driver code
    public static void main(String arg[]) {
        System.out.println(Add(6, 4));
    }
}