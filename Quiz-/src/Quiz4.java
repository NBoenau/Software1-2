import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Quiz4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Quiz4() {
    }

    private static boolean findDigit(NaturalNumber n, int i) {
        boolean b = false;
        int r = n.divideBy10();
        System.out.println(n);

        if (n.isZero()) {
            if (r == i) {

                b = true;
                System.out.println("WORKS");
            }
        } else {
            findDigit(n, i);
        }
        n.multiplyBy10(r);
        System.out.println(b);

        return b;
    }

    private static NaturalNumber attributeSum(XMLTree xml) {
        NaturalNumber sum = new NaturalNumber1L();

        if (xml.numberOfChildren() == 0) {
            Iterable<String> atr = xml.attributeNames();
            for (String s : atr) {
                NaturalNumber temp = new NaturalNumber1L(xml.attributeValue(s));
                sum.add(temp);
            }
        } else {
            for (int i = 0; i < xml.numberOfChildren(); i++) {
                sum.add(attributeSum(xml.child(i)));
            }
        }
        return sum;
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

        NaturalNumber x = new NaturalNumber1L(123);
        out.print(findDigit(x, 3));

        in.close();
        out.close();
    }

}
