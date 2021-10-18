import java.util.Iterator;

import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.tree.Tree;

/**
 * Put a short phrase describing the program here.
 *
 * @author Nick BOenau
 *
 */
public final class TreeREcursion {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private TreeREcursion() {
    }

    /**
     * Returns the size of the given {@code Tree<T>}.
     *
     * @param <T>
     *            the type of the {@code Tree} node labels
     * @param t
     *            the {@code Tree} whose size to return
     * @return the size of the given {@code Tree}
     * @ensures size = |t|
     */
    public static <T> int sizeR(Tree<T> t) {
        int size = 0;
        Sequence<Tree<T>> subT = t.newSequenceOfTree();
        if (t.height() != 0) {
            T root = t.disassemble(subT);
            int len = subT.length();
            for (int i = 0; i < len; i++) {
                size++;
                sizeR(subT.entry(i));
            }

            t.assemble(root, subT);
            size++;
        }

        return size;
    }

    /**
     * Returns the size of the given {@code Tree<T>}.
     *
     * @param <T>
     *            the type of the {@code Tree} node labels
     * @param t
     *            the {@code Tree} whose size to return
     * @return the size of the given {@code Tree}
     * @ensures size = |t|
     */
    public static <T> int sizeI(Tree<T> t) {
        int size = 0;
        Sequence<Tree<T>> subT = t.newSequenceOfTree();
        Iterator<T> iterator = t.iterator();

        for (int i = 0; i < subT.length(); i++) {
            if (iterator.hasNext()) {
                size++;
            }
        }
        return size;
    }

    /**
     * Returns the height of the given {@code Tree<T>}.
     *
     * @param <T>
     *            the type of the {@code Tree} node labels
     * @param t
     *            the {@code Tree} whose height to return
     * @return the height of the given {@code Tree}
     * @ensures height = ht(t)
     */
    public static <T> int height(Tree<T> t) {
        int height = 0;
        int temp = 0;

        Sequence<Tree<T>> branch = new Sequence1L<Tree<T>>();

        if (t.size() != 0) {
            T root = t.disassemble(branch);

            for (int i = 0; i < branch.length(); i++) {
                if (height(branch.entry(i)) > temp) {
                    temp = height(branch.entry(i));
                }
            }

            t.assemble(root, branch);
            height = temp;
        }
        height++;
        return height;
    }

    /**
     * Returns the largest integer in the given {@code Tree<Integer>}.
     *
     * @param t
     *            the {@code Tree<Integer>} whose largest integer to return
     * @return the largest integer in the given {@code Tree<Integer>}
     * @requires |t| > 0
     * @ensures <pre>
     * max is in labels(t)  and
     * for all i: integer where (i is in labels(t)) (i <= max)
     * </pre>
     */
    public static int max(Tree<Integer> t) {
        int max = 0;
        Sequence<Tree<Integer>> branch = new Sequence1L<Tree<T>>();

        while (t.height() != 0) {
            int count = 0;
            int root = t.disassemble(branch);
            max = max(branch.entry(count));
            if (root > max) {
                max = root;
            }
            t.assemble(root, branch);
            count++;
        }
        return max;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        /*
         * Put your main program code here
         */
    }

}
