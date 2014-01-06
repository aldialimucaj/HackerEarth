import al.aldi.libjaldi.calc.MathUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/**
 * User: Aldi Alimucaj
 * Date: 23.12.13
 * Time: 22:15
 * <p/>
 * [Add Description]
 * <p/>
 * http://www.hackerearth.com/problem/algorithm/special-sum-3/
 */
public class SpecialSumMain {

    public static long calcSum(long n) {
        long result = 0;

        TreeSet<Long> divisors = MathUtils.divisors(n);
        for (long d : divisors) {
            //

            //
            result += foo(d);
        }

        return result;
    }

    public static long foo(long n) {
        long result = 0;
        for (int i = 1; i <= n; i++) {
            if (MathUtils.gcd(n, i) == 1) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(".\\SpecialSum\\test.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            try {
                String str = br.readLine();
                System.out.println(calcSum(Long.valueOf(str)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
