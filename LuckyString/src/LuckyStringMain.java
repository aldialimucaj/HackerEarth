import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

/**
 * User: Aldi Alimucaj
 * Date: 25.12.13
 * Time: 18:34
 * <p/>
 * [Add Description]
 * <p/>
 * http://www.hackerearth.com/problem/algorithm/lucky-string-1/
 */
public class LuckyStringMain {

    static boolean setUpLuckyString(long k) {
        if (k == 1) return false;
        if (k == 2) return true;
        LSHelper helper = bitSizeNumber(k);
        k = helper.getK();
        long i = helper.getI();
        long number = (long) (k / i);

        // because the counting in this exercise starts from 1 and arrays from 0
        if (k % i == 0) { // the last digit of the number
            System.out.println(Arrays.toString(toBinary(number - 1, (int) i)));
            return toBinary(number - 1, (int) i)[((int) (i - 1))];
        } else {
            System.out.println(Arrays.toString(toBinary(number, (int) i)));
            return toBinary(number, (int) i)[((int) ((k % i) - 1))];
        }
    }

    static LSHelper bitSizeNumber(long n) {
        long prev_k = 0;
        long k = 0;
        long i = 1;
        for (; n > k; i++) {
            k += (long) Math.pow(2, i) * i;
            if (n > k) {
                prev_k = k;
            }
        }
        LSHelper helper = new LSHelper(i - 1, n - prev_k);
        return helper;
    }

    /**
     * Build an array of bits representing the number
     *
     * @param number number to be converted
     * @param base - how many bits
     * @return
     */
    public static boolean[] toBinary(long number, int base) {
        final boolean[] ret = new boolean[base];
        for (long i = 0; i < base; i++) {
            ret[((int) (base - 1 - i))] = (1 << i & number) != 0;
        }
        return ret;
    }

    /**
     * Helper class for return values
     */
    static class LSHelper {
        long k;
        long  i;

        LSHelper(long i, long k) {
            this.i = i;
            this.k = k;
        }

        public long getK() {
            return k;
        }

        public void setK(long k) {
            this.k = k;
        }

        public long getI() {
            return i;
        }

        public void setI(long i) {
            this.i = i;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(".\\LuckyString\\test.txt")));
        long t = Integer.parseInt(br.readLine());

        boolean b = setUpLuckyString(8);
        if (b) System.out.println("Earth");
        else System.out.println("Hacker");

//        for (long i = 0; i < t; i++) {
//            String line = br.readLine();
//            BigInteger bi = new BigInteger(line);
//            boolean b = setUpLuckyString(bi.longValue());
//            if (b) System.out.println("Earth");
//            else System.out.println("Hacker");
//        }
    }




}
