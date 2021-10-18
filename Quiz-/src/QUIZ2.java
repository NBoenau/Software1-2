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
public final class QUIZ2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private QUIZ2() {
    }

    private static NaturalNumber hailSum(NaturalNumber x, NaturalNumber n) {
        NaturalNumber temp = new NaturalNumber2(n);
        NaturalNumber zero = new NaturalNumber2(0);
        NaturalNumber two = new NaturalNumber2(2);
        int thrEEE = 3;
        NaturalNumber three = new NaturalNumber2(thrEEE);

        NaturalNumber hailSum = new NaturalNumber2(0);

        while (temp.compareTo(zero) > 0) {

            if (x.divide(two) == zero) {
                hailSum.add(x.divide(two));
            } else {

                x.multiply(three);
                x.increment();
                hailSum.add(x);

            }
            temp.decrement();

        }
        return hailSum;

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

        NaturalNumber one = new NaturalNumber2(3);
        NaturalNumber two = new NaturalNumber2(3);

        out.print(hailSum(one, two));

        in.close();
        out.close();
    }

}
