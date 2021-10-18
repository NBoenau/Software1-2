import components.map.Map;
import components.map.Map.Pair;
import components.map.Map1L;
import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.queue.Queue;
import components.queue.Queue1L;
import components.set.Set;
import components.set.Set1L;
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
public final class ProgramWithIO {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ProgramWithIO() {
    }

    public static NaturalNumber mapSum(Map<String, Set<NaturalNumber>> m,
            Queue<String> q) {
        NaturalNumber mapSum = new NaturalNumber2();

        for (Pair<String, Set<NaturalNumber>> p : m) {
            String temp = p.key();
            for (int i = 0; i < q.length(); i++) {
                String s = q.dequeue();

                if (s.equals(temp)) {
                    Set<NaturalNumber> nums = p.value();

                    while (nums.size() > 0) {
                        NaturalNumber num = nums.removeAny();
                        mapSum.add(num);
                    }
                }
                q.enqueue(s);
            }
        }

        return mapSum;
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

        Map<String, Integer> map = new Map1L<>();
        Queue<NaturalNumber> test = new Queue1L<NaturalNumber>();

        NaturalNumber two = new NaturalNumber2(2);
        Set<Integer> setI = new Set1L<>();

        in.close();
        out.close();
    }

}
