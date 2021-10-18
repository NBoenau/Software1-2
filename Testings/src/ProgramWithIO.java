import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ProgramWithIO {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */

    /**
     *
     * @param s1
     * @param s2
     *
     */
    private ProgramWithIO() {
    }

    public static boolean hasSameChar(String s1, String s2) {

        boolean hasSameCharB = false;

        char[] stringOne = new char[s1.length()];
        char[] stringTwo = new char[s2.length()];

        int oneLength = s1.length();
        int twoLength = s2.length();

        for (int i = 0; i <= s1.length(); i++) {
            stringOne[i] = s1.charAt(i);
        }

        for (int i = 0; i < s2.length(); i++) {
            stringTwo[i] = s2.charAt(i);
        }

        for (int i = 0; i < oneLength; i++) {
            for (int j = 0; j < twoLength; j++) {
                if (stringOne[i] == stringTwo[j]) {
                    hasSameCharB = true;
                }
            }

        }
        if (hasSameCharB == true) {
            System.out.println("Strings share a characters");
        } else {
            System.out.println("Strings no share");
        }

        return hasSameCharB;

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.println("Please input a series of characters for string one: ");
        String userStringOne = in.nextLine();

        out.println("Please input a series of characters for string two: ");
        String userStringTwo = in.nextLine();

        hasSameChar(userStringOne, userStringTwo);

        in.close();
        out.close();
    }

}
