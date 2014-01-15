import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * User: Aldi Alimucaj
 * Date: 25.12.13
 * Time: 18:34
 * <p/>
 * [Add Description]
 * <p/>
 * http://www.hackerearth.com/
 */
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(".\\[###]\\test.txt")));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String line = br.readLine();
            System.out.println(line);
        }
    }
}
