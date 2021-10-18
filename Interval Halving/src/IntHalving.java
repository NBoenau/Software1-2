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
public final class IntHalving {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private IntHalving() {
    }

    /**
     * Returns the {@code r}-th root of {@code n}.
     *
     * @param n
     *            the number to which we want to apply the root
     * @param r
     *            the root
     * @return the root of the number
     * @requires n >= 0 and r > 0
     * @ensures root ^ (r) <= n < (root + 1) ^ (r)
     */
    private static int root(int n, int r) {
        int secretNum = (int) Math.round(Math.pow(n, (1 / r)));
        int lowBound = 0;
        int highBound = 1000;
        int guess = 0;
        boolean dNE = true;

        if (n < 0 || r < 0) {
            System.out.println(
                    "Invalid input. Base and Root must be greater than 0");
        } else {
            while (dNE) {
                guess = (lowBound + highBound) / 2;
                if (guess > secretNum) {
                    highBound = guess;
                } else if (guess < secretNum) {
                    lowBound = guess;
                } else if (guess == secretNum) {
                    guess = (int) guess;
                    return guess;
                }
            }

        }
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

        out.print("Enter a base number: ");
        int base = in.nextInteger();

        out.print("Enter a value for the root: ");
        int root = in.nextInteger();

        root(base, root);

        in.close();
        out.close();
    }

}
