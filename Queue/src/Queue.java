import java.util.Arrays;

import components.queue.Queue1L;
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
public final class Queue {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Queue() {
    }

    /**
     * Reports the smallest integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return the smallest integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * min is in entries(q) and
     * for all x: integer
     *     where (x is in entries(q))
     *   (min <= x)
     * </pre>
     */
    private static int min(Queue1L<Integer> q) {
        int size = q.length();
        int min = 99999999;
        int[] stored = new int[size];

        for (int i = 0; i < size; i++) {
            stored[i] = q.dequeue();
            if (stored[i] < min) {
                min = stored[i];
            }
        }
        return min;
    }

    /**
     * Reports an array of two {@code int}s with the smallest and the largest
     * integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return an array of two {@code int}s with the smallest and the largest
     *         integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * { minAndMax[0], minAndMax[1] } is subset of entries(q) and
     * for all x: integer
     *     where (x in in entries(q))
     *   (minAndMax[0] <= x <= minAndMax[1])
     * </pre>
     */
    private static int[] minAndMax(Queue1L<Integer> q) {
        int[] minMax = new int[2];
        int size = q.length();
        int[] stored = new int[size];

        for (int i = 0; i < size; i++) {
            stored[i] = q.dequeue();
            if (stored[i] < minMax[0]) {
                minMax[0] = stored[i];
            }
            if (stored[i] > minMax[1]) {
                minMax[1] = stored[i];
            }
        }
        return minMax;
    }

    /**
     * Reports an array of two {@code int}s with the smallest and the largest
     * integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return an array of two {@code int}s with the smallest and the largest
     *         integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * { minAndMax[0], minAndMax[1] } is subset of entries(q) and
     * for all x: integer
     *     where (x in in entries(q))
     *   (minAndMax[0] <= x <= minAndMax[1])
     * </pre>
     */
    private static int[] noahArk(Queue1L<Integer> q) {
        int size = q.length();
        int[] fixed = new int[size];
        int[] stored = new int[size];

        for (int i = 0; i < size / 2; i++) {
            stored[i] = q.dequeue();
            if (stored[i] < fixed[0]) {
                fixed[i] = fixed[0];
                fixed[0] = stored[i];
            }
            if (stored[i] > fixed[size - 1]) {
                fixed[i] = fixed[size - 1];
                fixed[size - 1] = stored[i];
            }
        }
        return fixed;
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

        Queue1L<Integer> test = new Queue1L<Integer>();

        test.enqueue(5);
        test.enqueue(3);
        test.enqueue(15);
        test.enqueue(2);
        test.enqueue(1);
        test.enqueue(18);
        test.enqueue(20);
        test.enqueue(14);

        System.out.print(Arrays.toString(noahArk(test)));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
