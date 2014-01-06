import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

/**
 * User: Aldi Alimucaj
 * Date: 25.12.13
 * Time: 18:34
 * <p/>
 * [Add Description]
 * <p/>
 * http://www.hackerearth.com/problem/algorithm/finding-pairs-4/
 */
public class FindingPairsMain {

    /**
     * Parse the string of integers into an array of hashed sums
     *
     * @param str
     * @return
     */
    public static Object[] parseIntArrayIntoSumOfHash(String str) {
        HashMap<Integer, Integer> resultSet = new HashMap<>();
        char[] arrayString = str.toCharArray();
        int strLength = str.length();
        int i = -1;
        StringBuilder number = new StringBuilder();
        while (i++ < strLength) {
            if ((i < strLength && arrayString[i] == 32) || i >= strLength) {
                int tmpI = Integer.parseInt(number.toString());
                // if it already exists than increment the value. Otherwise add with 1
                if (resultSet.containsKey(tmpI)) resultSet.put(tmpI, resultSet.get(tmpI) + 1);
                else resultSet.put(tmpI, 1);
                number = new StringBuilder();
                continue;
            }
            number.append(arrayString[i]);
        }
        return resultSet.values().toArray();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(".\\FindingPairs\\test.txt")));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int arrayItems = Integer.parseInt(br.readLine());
            String strArray = br.readLine();
            Object[] array = parseIntArrayIntoSumOfHash(strArray);
            int result = 0;
            for (int j = 0; j < array.length; j++) {
                int tmpResult = 0;
                for (int k = 0; k < (Integer) array[j]; k++) {
                    tmpResult += k + 1;
                }
                result += tmpResult;
            }
            System.out.println(result);
        }
        // generating test data
        /* addTestFile(500000); */
    }

    /**
     * Generating test data for the program
     *
     * @param length the number of items
     * @throws Exception
     */
    private static void addTestFile(int length) throws Exception {
        FileWriter fw = new FileWriter(new File(".\\FindingPairs\\test1.txt"), false);
        fw.write("1\n");
        fw.write(String.valueOf(length) + "\n");
        for (int i = 0; i < length; i++) {
            fw.write(String.valueOf(i));
            if (i < length - 1) fw.write(" ");
        }
        fw.flush();
        fw.close();
    }
}
