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
public final class Hashing {

    /**
     * Computes {@code a} mod {@code b} as % should have been defined to work.
     *
     * @param a
     *            the number being reduced
     * @param b
     *            the modulus
     * @return the result of a mod b, which satisfies 0 <= {@code mod} < b
     * @requires b > 0
     * @ensures <pre>
     * 0 <= mod  and  mod < b  and
     * there exists k: integer (a = k * b + mod)
     * </pre>
     */
    public static int mod(int a, int b) {
        int result = 0;
        int aC = a;
        int bC = b;

        if (a >= 0) {
            while (aC > b) {
                aC -= b;
            }
            result = aC;
        } else if (a <= 0) {
            while (Math.abs(aC) > b) {
                aC += b;
            }
            aC = Math.abs(b + aC);
            result = aC;
        } else {
            result = 0;
        }

        return result;
    }

    public static int hashCodeS(String s) {
        return s.length() + s.charAt(s.length() - 1);
    }

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hashing() {
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
        String s = "90";

        System.out.println(hashCodeS(s) % 10);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
