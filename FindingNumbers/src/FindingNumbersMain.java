import al.aldi.libjaldi.string.AldiStringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/**
 * User: Aldi Alimucaj
 * Date: 18.12.13
 * Time: 23:03
 * <p/>
 * <p/>
 * http://www.hackerearth.com/problem/algorithm/finding-numbers/
 */
public class FindingNumbersMain {


    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(".\\FindingNumbers\\test.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long N = Integer.parseInt(line);
        boolean randomize = false;
        for (long i = 0; i < N; i++) {
            try {
                if (!randomize) {
                    String str = br.readLine();
                    String[] values = str.split(" ");
                    long z = Long.valueOf(values[0]);
                    long m = Long.valueOf(values[1]);
                    long n = Long.valueOf(values[2]);
                    System.out.println(checkDivisors(z, m, n));
                } else {
                    // randomizing the numbers
                    long z = AldiStringUtils.randomLong((long) Math.pow(10.0, 11.0), (long) Math.pow(10.0, 12.0));
                    long m = AldiStringUtils.randomLong((long) Math.pow(10.0, 11.0), (long) Math.pow(10.0, 12.0));
                    long n = AldiStringUtils.randomLong((long) Math.pow(10.0, 11.0), (long) Math.pow(10.0, 12.0));
                    System.out.println(checkDivisors(z, m, n));
                }

                System.out.println("------------------------------------");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static long checkDivisors(long z, long m, long n) {
        TreeSet<Long> storage = new TreeSet<Long>();
        System.out.println(z + " " + m + " " + n);
        if (m == 1 || n == 1) return 1;
        boolean isPrime = isPrime(z);
        if (isPrime && m >= z && n < z) return 1;
        if (isPrime && m < z && n >= z) return 1;
        if (isPrime && m >= z && n >= z) return 2;

        // starting with the biggest parameter to calculate divisors
        long maxMn = Math.max(m, n);
        long minMn = maxMn == m ? n : m;
        // bottomDivisor is the bottom divisor
        long bottomDivisor = 0;
        // topDivisor is the top divisor
        long topDivisor = z;
        // topDivisor is the next biggest divisor -bottomDivisor is the next smallest divisor
        while (topDivisor >= bottomDivisor++ && bottomDivisor <= minMn) {
            if (z % bottomDivisor == 0) {
                topDivisor = z / bottomDivisor;
                // always add the top divisor
                storage.add(new Long(topDivisor));
                // bottom divisor only if fits the range
                if ((double)bottomDivisor * (double)maxMn >= (double)z) {
                    storage.add(new Long(bottomDivisor));
                }
                // if its a prime then we wont find any other divisors
                if (isPrime(topDivisor)) {
                    break;
                }
            }
        }

        // Adding the results
        int result = 0;
        for (Long key : storage) {
            long currentKey = key.longValue();
            // if they fit the boundaries add them
            if (currentKey <= maxMn && (currentKey <= minMn))
                result++;
        }

        for (Long key : storage) {
            System.out.println(z + " = " + key);
        }

        return result;
    }

    static boolean isPrime(long num) {
        if (num <= 1)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false;
        long sRoot = (long) Math.sqrt(num * 1.0);
        for (int i = 3; i <= sRoot; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
