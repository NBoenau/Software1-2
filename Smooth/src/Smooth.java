import components.sequence.Sequence;
import components.sequence.Sequence1L;
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
public final class Smooth {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Smooth() {
    }

    /**
     * Smooths a given in an iterative fashion {@code Sequence<Integer>}.
     *
     * @param s1
     *            the sequence to smooth
     * @param s2
     *            the resulting sequence
     * @replaces s2
     * @requires |s1| >= 1
     * @ensures <pre>
     * |s2| = |s1| - 1  and
     *  for all i, j: integer, a, b: string of integer
     *      where (s1 = a * <i> * <j> * b)
     *    (there exists c, d: string of integer
     *       (|c| = |a|  and
     *        s2 = c * <(i+j)/2> * d))
     * </pre>
     */
    public static void smoothI(Sequence<Integer> s1, Sequence<Integer> s2) {
        s2.clear();
        int x = 0;
        int y = 1;

        for (int s1Len = 0; s1Len < s1.length() - 1; s1Len++) {
            int i = s1.remove(x);
            s1.add(x, i);
            int j = s1.remove(y);
            s1.add(y, j);

            int avg = ((i + j) / 2);
            s2.add(x, avg);
            x++;
            y++;

        }
    }

    /**
     * Smooths a given in a recursive fashion {@code Sequence<Integer>}.
     *
     * @param s1
     *            the sequence to smooth
     * @param s2
     *            the resulting sequence
     * @replaces s2
     * @requires |s1| >= 1
     * @ensures <pre>
     * |s2| = |s1| - 1  and
     *  for all i, j: integer, a, b: string of integer
     *      where (s1 = a * <i> * <j> * b)
     *    (there exists c, d: string of integer
     *       (|c| = |a|  and
     *        s2 = c * <(i+j)/2> * d))
     * </pre>
     */
    public static void smoothR(Sequence<Integer> s1, Sequence<Integer> s2) {
        s2.clear();
        int x = 0;

        if (s1.length() > 1) {
            int i = s1.remove(x);
            int j = s1.remove(x);
            s1.add(x, j);

            int avg = ((i + j) / 2);
            smoothR(s1, s2);
            s1.add(x, i);
            s2.add(x, avg);
        }
    }

    /**
     * Returns the average of two ints
     *
     * @param j
     *            the first integer of the average
     * @param k
     *            the second integer of the average
     * @returns the average of j and k
     * @ensures <pre> avg = (j+k)/2
     *
     */
    public static int avg(int j, int k) {
        return (int) ((j) + (long) (k) / 2);
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

        Sequence<Integer> s1T = new Sequence1L<>();
        Sequence<Integer> s2T = new Sequence1L<>();

        s1T.add(0, 0);
        s1T.add(1, 10);
        s1T.add(2, 12);
        s1T.add(3, 16);
        s2T.add(0, 1);
        smoothR(s1T, s2T);
        System.out.println(s1T);
        System.out.println(s2T);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
