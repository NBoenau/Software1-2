import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.queue.Queue;
import components.queue.Queue1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.stack.Stack;
import components.stack.Stack1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ProgramWithIO {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ProgramWithIO() {
    }

    public static Set<NaturalNumber> squareSet(Queue<NaturalNumber> q) {
        Set<NaturalNumber> squared = new Set1L<NaturalNumber>();
        int length = q.length();

        for (int i = 0; i < length; i++) {
            NaturalNumber x = q.dequeue();
            x.power(2);
            squared.add(x);
        }

        return squared;
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

        NaturalNumber two = new NaturalNumber2(2);
        NaturalNumber four = new NaturalNumber2(4);
        NaturalNumber five = new NaturalNumber2(5);

        Queue<NaturalNumber> test = new Queue1L<NaturalNumber>();
        test.enqueue(two);
        test.enqueue(five);
        test.enqueue(four);

        out.print(test);

        out.println(squareSet(test));

        Sequence<Integer> seI = new Sequence1L<>();
        Stack<Integer> stI = new Stack1L<>();
        Set<Integer> setI = new Set1L<>();
        System.out.println("");

        in.close();
        out.close();
    }

}
