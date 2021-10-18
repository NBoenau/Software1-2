import components.binarytree.BinaryTree;
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
public final class Heapsort {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Heapsort() {
    }

    /**
     * Checks if the given {@code BinaryTree<Integer>} satisfies the heap
     * ordering property according to the <= relation.
     *
     * @param t
     *            the binary tree
     * @return true if the given tree satisfies the heap ordering property;
     *         false otherwise
     * @ensures <pre>
     * satisfiesHeapOrdering = [t satisfies the heap ordering property]
     * </pre>
     */
    private static boolean satisfiesHeapOrdering(BinaryTree<Integer> t) {
        boolean result = false;
        int root = 0;
        BinaryTree<Integer> left = t.newInstance();
        BinaryTree<Integer> right = t.newInstance();

        while (t.size() != 0) {
            root = t.disassemble(left, right);
            if (root <= left.root() && root <= right.root()) {
                result = satisfiesHeapOrdering(left)
                        && satisfiesHeapOrdering(right);
            }
            t.assemble(root, left, right);
        }

        return result;
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
         * Put your main program code here
         */

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
