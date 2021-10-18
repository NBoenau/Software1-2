import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Nick Boenau
 *
 */
public final class Recursion1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Recursion1() {
    }

    /**
     * Returns the number of digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to count
     * @return the number of digits of {@code n}
     * @ensures numberOfDigits = [number of digits of n]
     */
    private static int numberOfDigits(NaturalNumber n) {
        int numDigits = 0;
        NaturalNumber x = new NaturalNumber2(n);

        while (!x.isZero()) {
            numDigits++;
            x.divideBy10();
        }

        return numDigits;
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static int sumOfDigits(NaturalNumber n) {
        int sumDigits = 0;
        NaturalNumber x = new NaturalNumber2(n);
        NaturalNumber temp = new NaturalNumber2(n);

        while (!x.isZero()) {
            sumDigits = sumDigits + x.divideBy10();
        }
        return sumDigits;
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static NaturalNumber sumOfDigitsA(NaturalNumber n) {
        NaturalNumber sumDigits = new NaturalNumber2(0);
        NaturalNumber x = new NaturalNumber2(n);

        while (!x.isZero()) {
            x.divideBy10();
            sumDigits.add(x);
            sumDigits.add(sumDigits.toInt());

        }
        return sumDigits;
    }

    /**
     * Divides {@code n} by 2.
     *
     * @param n
     *            {@code NaturalNumber} to be divided
     * @updates n
     * @ensures 2 * n <= #n < 2 * (n + 1)
     */
    private static void divideBy2(NaturalNumber n) {
        NaturalNumber x = new NaturalNumber2(n);
        int xIHStatic = x.toInt() / 2;
        int val = 0;
        int tempT = 0;

        x.divideBy10();
        val = x.toInt();
        while (tempT != xIHStatic) {
            tempT += val;

        }
        NaturalNumber temp = new NaturalNumber2(tempT);
        x = temp;

    }

    /**
     * Checks whether a {@code String} is a palindrome.
     *
     * @param s
     *            {@code String} to be checked
     * @return true if {@code s} is a palindrome, false otherwise
     * @ensures isPalindrome = (s = rev(s))
     */
    private static boolean isPalindrome(String s) {
        boolean b;

        int x = s.length() - 1;
        int y = 0;

        while (x >= y) {
            if (s.charAt(x) != s.charAt(y)) {
                b = false;
            }
            x--;
            y++;
        }
        b = true;

        return b;
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

        String testN = "civil";
        String testY = "civic";

        out.print(isPalindrome(testN));
        out.print(isPalindrome(testY));

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
