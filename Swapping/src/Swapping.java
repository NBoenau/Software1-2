import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Swaps two different natural numbers with copy and transfer from, then squares
 * the value of a natural number.
 *
 * @author Nick Boenau
 *
 */
public final class Swapping {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Swapping() {
    }

    /**
     * Swaps the two given {@code NaturalNumber}s.
     *
     * @param n1
     *            the first {@code NaturalNumber}
     * @param n2
     *            the second {@code NaturalNumber}
     * @updates n1
     * @updates n2
     * @ensures n1 = #n2 and n2 = #n1
     */
    private static void swapNNC(NaturalNumber n1, NaturalNumber n2) {
        System.out.println(
                "Before Swap (Copy From): \n N1: " + n1 + " N2: " + n2);
        NaturalNumber temp = new NaturalNumber2();
        temp.copyFrom(n1);
        n1.copyFrom(n2);
        n2.copyFrom(temp);
        System.out.println("AFTER: N1: " + n1 + " N2: " + n2 + " \n");

    }

    /**
     * Swaps the two given {@code NaturalNumber}s.
     *
     * @param n1
     *            the first {@code NaturalNumber}
     * @param n2
     *            the second {@code NaturalNumber}
     * @updates n1
     * @updates n2
     * @ensures n1 = #n2 and n2 = #n1
     */
    private static void swapNNT(NaturalNumber n1, NaturalNumber n2) {
        System.out.println(
                "Before Swap (Transfer From):\n N1: " + n1 + " N2: " + n2);
        NaturalNumber temp = new NaturalNumber2();
        temp.transferFrom(n1);
        n1.transferFrom(n2);
        n2.transferFrom(temp);
        System.out.println("AFTER: N1: " + n1 + " N2: " + n2 + " \n");

    }

    /**
     * Squares a given {@code NaturalNumber}.
     *
     * @param n
     *            the number to square
     * @updates n
     * @ensures n = #n * #n
     */
    private static void square(NaturalNumber n) {
        NaturalNumber temp = new NaturalNumber2();
        temp.copyFrom(n);
        n.power(2);
        System.out.println(
                "\nBefore Square N: " + temp + " \nAfter Square N^2: " + n);
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
         * Put your main program code here; it may call myMethod as shown
         */
        int four = 4;
        int twelve = 12;

        NaturalNumber fourNN = new NaturalNumber2(four);
        NaturalNumber twelveNN = new NaturalNumber2(twelve);

        swapNNC(fourNN, twelveNN);
        swapNNT(fourNN, twelveNN);
        square(twelveNN);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
