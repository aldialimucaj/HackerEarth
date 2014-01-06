import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * User: Aldi Alimucaj
 * Date: 18.12.13
 * Time: 21:06
 * <p/>
 * <p/>
 * A string is said to be complete if it contains all the characters from a to z. Given a string, check if it complete or not.
 * <p/>
 * Input
 * First line of the input contains the number of strings N. It is followed by N lines each contains a single string.
 * <p/>
 * Output
 * For each test case print "YES" if the string is complete, else print "NO"
 * <p/>
 * Constraints
 * 1 <= N <= 10
 * The length of the string is at max 100 and the string contains only the characters a to z
 */
public class CompleteStringMain {
    public final static String YES             = "YES";
    public final static String NO              = "NO";
    static              char[] vocabulary      = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static              byte[] vocabularyIndex = new byte[26 + 'a'];


    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(".\\CompleteString\\test.txt"));
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
                if (checkString(str))
                    System.out.println(YES);
                else
                    System.out.println(NO);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static boolean checkString(String str) {
        // cleaning up the index
        for (int i = 0; i < vocabulary.length; i++) {
            vocabularyIndex[vocabulary[i]] = 0;
        }
        // setting the new index values
        char[] strChar = str.toCharArray();
        for (int i = 0; i < strChar.length; i++) {
            vocabularyIndex[strChar[i]] += 1;
        }
        // checking if there is an empty index
        for (int i = 0; i < vocabulary.length; i++) {
            if (vocabularyIndex[vocabulary[i]] == 0)
                return false;
        }
        return true;
    }
}
