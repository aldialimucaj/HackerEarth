import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by Aldi on 24.12.13.
 */
public class RoyAndLEDsMain {
    public static final byte BALCK = 0;
    public static final byte BLUE = 1;
    public static final byte GREEN = 2;
    public static final byte CYAN = 3;
    public static final byte RED = 4;
    public static final byte MAGENTA = 5;
    public static final byte YELLOW = 6;
    public static final byte WHITE = 7;

    private static String checkLeds(int t, int r, int g, int b) {
        String result = "%d %d %d %d %d %d %d %d";
        byte[] states = new byte[t];
        int[] resultArray = new int[8];
        boolean redFlag = false;
        boolean greenFlag = false;
        boolean blueFlag = false;
        for (int i = 0; i < states.length; i++) {
            if (i == 0) {
                resultArray[BALCK]++;
                continue;
            }
            if (i % r == 0) redFlag = !redFlag;
            if (i % g == 0) greenFlag = !greenFlag;
            if (i % b == 0) blueFlag = !blueFlag;
            if (redFlag) states[i] |= RED;
            if (greenFlag) states[i] |= GREEN;
            if (blueFlag) states[i] |= BLUE;

            System.out.println(i + " -> " + states[i]);
            switch (states[i]) {
                case BALCK:
                    resultArray[BALCK]++;
                    break;
                case BLUE:
                    resultArray[BLUE]++;
                    break;
                case GREEN:
                    resultArray[GREEN]++;
                    break;
                case CYAN:
                    resultArray[CYAN]++;
                    break;
                case RED:
                    resultArray[RED]++;
                    break;
                case MAGENTA:
                    resultArray[MAGENTA]++;
                    break;
                case YELLOW:
                    resultArray[YELLOW]++;
                    break;
                case WHITE:
                    resultArray[WHITE]++;
                    break;

            }
        }


        return String.format(result,
                resultArray[RED],
                resultArray[GREEN],
                resultArray[BLUE],
                resultArray[YELLOW],
                resultArray[CYAN],
                resultArray[MAGENTA],
                resultArray[WHITE],
                resultArray[BALCK]
        );
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(".\\RoyAndLEDs\\test.txt")));
        String line = br.readLine();
        String[] times = line.split(" ");
        int t = Integer.valueOf(times[0]);
        int r = Integer.valueOf(times[1]);
        int g = Integer.valueOf(times[2]);
        int b = Integer.valueOf(times[3]);

        System.out.printf(checkLeds(t, r, g, b));
    }


}
