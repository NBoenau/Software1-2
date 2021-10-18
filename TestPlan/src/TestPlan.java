import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
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
public final class TestPlan {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private TestPlan() {
    }

    /**
     * Converts the given {@code NaturalNumber} to a {@code String} with commas.
     *
     * @param n
     *            the number
     * @return the {@code String} with commas
     * @ensures toStringWithCommas = [String representation of n with commas]
     */
    public static String toStringWithCommas(NaturalNumber n) {
        NaturalNumber x = new NaturalNumber2(n);
        String num = x.toString();
        char[] nm = num.toCharArray();
        char com = ',';
        StringBuilder sb = new StringBuilder();
        sb.insert(0, nm[0]);

        int count = 2;

        for (int i = 1; i < nm.length; i++) {

            if (count % 4 == 0) {
                sb.insert(count - 1, com);
                i--;
            } else {
                sb.insert(count - 1, nm[i]);
            }
            count++;
        }
        return sb.toString();
    }

    /**
     * Tests toStringWithCommas with 3 digit number
     *
     * Should output "123"
     */
    public void test123() {
        NaturalNumber test = new NaturalNumber2(123);
        toStringWithCommas(test);

    }

    /**
     * Tests toStringWithCommas with 6 digit number
     *
     * Should output "123,456"
     */
    public void test123456() {
        NaturalNumber test = new NaturalNumber2(123456);
        toStringWithCommas(test);

    }

    /**
     * Tests toStringWithCommas with 9 digit number
     *
     * Should output "123,456,789"
     */
    public void test123456789() {
        NaturalNumber test = new NaturalNumber2(123456789);
        toStringWithCommas(test);

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

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
