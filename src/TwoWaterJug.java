import java.util.LinkedList;

/**
 * Created by EZDI\haresh.p on 9/8/17.
 *
 *
 * You are at the side of a river. You are given a m litre jug and a n litre jug where 0 < m < n. Both the jugs are initially empty. The jugs don’t have markings to allow measuring smaller quantities. You have to use the jugs to measure d litres of water where d < n. Determine the minimum no of operations to be performed to obtain d litres of water in one of jug.
 The operations you can perform are:

 Empty a Jug
 Fill a Jug
 Pour water from one jug to the other until one of the jugs is either empty or full.

 Minimum number of steps required to major 4 litter using jug with litter 3 and jug with litter 5 is 6
 */
public class TwoWaterJug {

    private LinkedList<Integer> adj[];

    public static void main(String[] args) {
        int n = 3, m = 5, d = 4;

        System.out.println("Minimum number of steps required to major " + d + " litter using jug with litter " + n + " and jug with litter " + m + " is " + minSteps(m, n, d));

    }

    private static int minSteps(int m, int n, int d) {
        // To make sure that m is smaller than n
        if (m > n) {
            int t = m;
            m = n;
            n = t;
        }


        // For d > n we cant measure the water
        // using the jugs
        if (d > n)
            return -1;

        // If gcd of n and m does not divide d
        // then solution is not possible
        if ((d % gcd(n, m)) != 0)
            return -1;

        // Return minimum two cases:
        // a) Water of n litre jug is poured into
        //    m litre jug
        // b) Vice versa of "a"
        return min(pour(n, m, d),   // n to m
                pour(m, n, d));  // m to n
    }

    private static int min(int n, int m) {
        return n <= m ? n : m;
    }

    private static int pour(int fromCap, int toCap, int d) {
        int from = fromCap;
        int step = 1;

        int to = 0;
        while (true) {

            int temp = min(from, toCap - to);
            to += temp;
            from -= temp;
            step++;

            if (from == d || to == d) {
                break;
            }
            if (from == 0) {
                from = fromCap;
                step++;
            }
            if (to == toCap) {
                to = 0;
                step++;
            }
        }


        return step;

    }

    private static int gcd(int n, int m) {
        if (m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }


}