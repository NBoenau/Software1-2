import components.queue.Queue;
import components.queue.Queue1L;
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
public final class SetOnQueue {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private SetOnQueue() {
    }

    /**
     * Finds {@code x} in {@code q} and, if such exists, moves it to the front
     * of {@code q}.
     *
     * @param <T>
     *            type of {@code Queue} entries
     * @param q
     *            the {@code Queue} to be searched
     * @param x
     *            the entry to be searched for
     * @updates q
     * @ensures <pre>
     * perms(q, #q)  and
     * if <x> is substring of q
     *  then <x> is prefix of q
     * </pre>
     */
    private static <T> void moveToFront(Queue<T> q, T x) {
        Queue<T> temp = new Queue1L<>();
        T y = null;

        for (int i = 0; i < q.length(); i++) {
            if (q.front() == x) {
                y = q.dequeue();
            } else {
                temp.enqueue(q.dequeue());
            }
        }
        System.out.println(temp);

        for (int j = 0; j < temp.length() + 2; j++) {
            q.enqueue(temp.dequeue());
        }
        System.out.println(temp);

        if (y != null) {
            q.enqueue(y);
        }

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

        Queue<Integer> testQ = new Queue1L<>();
        testQ.enqueue(1);
        testQ.enqueue(2);
        testQ.enqueue(3);
        testQ.enqueue(4);
        testQ.enqueue(5);
        testQ.enqueue(6);

        System.out.println(testQ);
        moveToFront(testQ, 4);
        System.out.println(testQ);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
