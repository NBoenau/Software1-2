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
     * Simple class representing a 7-digit phone number in the form "XXX-XXXX"
     * for a phone in the immediate OSU area.
     */
    public class PhoneNumber {

        /**
         * The phone number representation.
         */
        private String rep;

        /**
         * Constructor. {@code pNum} must be in the form "XXX-XXXX" where each
         * "X" is a digit '0'-'9'.
         */
        public PhoneNumber(String pNum) {
            this.rep = pNum;
        }

        @Override
        public int hashCode() {
            int result = 0;
            char dash = '-';
            int length = this.rep.length();

            for (int i = 0; i < length; i++) {
                char j = this.rep.charAt(i);
                if (j != dash) {
                    result = +result + Character.digit(j, 10);
                }
            }
            return result;
        }

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

        System.out.println("123-4567".hashCode());

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
