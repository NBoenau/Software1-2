import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Takes users inputted name and greets them
 *
 * @NickBoenau
 *
 */
public final class HelloJack {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HelloJack() {
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

        output.print("Number: ");
        int n = input.nextInteger();
        int count = 1;
        while (count < n) {
            if (Math.sqrt(count) % 2 == 1 || Math.sqrt(count) % 2 == 0) {
                output.print(count + "\n");
            }
            count++;

        }

    }

}
