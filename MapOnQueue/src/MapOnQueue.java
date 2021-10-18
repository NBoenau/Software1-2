import components.map.Map;
import components.map.Map.Pair;
import components.map.Map1L;
import components.queue.Queue;
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
public final class MapOnQueue {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private MapOnQueue() {
    }

    /**
     * Finds pair with first component {@code key} and, if such exists, moves it
     * to the front of {@code q}.
     *
     * @param <K>
     *            type of {@code Pair} key
     * @param <V>
     *            type of {@code Pair} value
     * @param q
     *            the {@code Queue} to be searched
     * @param key
     *            the key to be searched for
     * @updates q
     * @ensures <pre>
     * perms(q, #q)  and
     * if there exists value: V (<(key, value)> is substring of q)
     *  then there exists value: V (<(key, value)> is prefix of q)
     * </pre>
     */
    private static <K, V> void moveToFront(Queue<Pair<K, V>> q, K key) {
        Queue<Pair<K, V>> temp = q.newInstance();
        int length = q.length();

        for (int i = 0; i < length; i++) {
            if (q.front() != key) {
                temp.enqueue(q.dequeue());
            }
        }
        for (int i = 0; i < length - 1; i++) {
            q.enqueue(temp.dequeue());
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

        Map<String, Integer> m = new Map1L<>();
        System.out.print(m);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
