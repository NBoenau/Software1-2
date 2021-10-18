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
public final class ProgramSkeleton {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ProgramSkeleton() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */

    public static boolean testEye(int i) {

        if (i % 2 == 0) {
            System.out.print("WORKS");
        }
        return i % 2 == 0;

    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        testEye(4);

        in.close();
        out.close();
    }

}
