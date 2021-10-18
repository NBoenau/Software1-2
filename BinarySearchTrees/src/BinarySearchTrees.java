import components.binarytree.BinaryTree;
import components.binarytree.BinaryTree1;
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
public final class BinarySearchTrees {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private BinarySearchTrees() {
    }

    /**
     * @mathdefinitions <pre>
     * IS_BST(
     *   tree: binary tree of T
     *  ): boolean satisfies
     *  [tree satisfies the binary search tree properties as described in the
     *   slides with the ordering reported by compareTo for T, including that
     *   it has no duplicate labels]
     * </pre>
     */

    /**
     * Returns whether {@code x} is in {@code t}.
     *
     * @param <T>
     *            type of {@code BinaryTree} labels
     * @param t
     *            the {@code BinaryTree} to be searched
     * @param x
     *            the label to be searched for
     * @return true if t contains x, false otherwise
     * @requires IS_BST(t)
     * @ensures isInTree = (x is in labels(t))
     */
    public static <T extends Comparable<T>> boolean isInTree(BinaryTree<T> t,
            T x) {
        boolean isInTree = false;
        BinaryTree<T> left = new BinaryTree1<>();
        BinaryTree<T> right = new BinaryTree1<>();
        T root;
        if (t.root() == x) {
            isInTree = true;
        } else if (x.compareTo(t.root()) < 0) {
            root = t.root();
            t.disassemble(left, right);
            isInTree = isInTree(left, x);
            if (isInTree) {
                isInTree = true;
            }
            t.assemble(root, left, right);
        } else if (x.compareTo(t.root()) >= 0) {
            root = t.root();
            t.disassemble(left, right);
            isInTree = isInTree(right, x);
            if (isInTree) {
                isInTree = true;
            }
            t.assemble(root, left, right);
        } else if (t.size() == 0) {
            isInTree = false;
        }

        return isInTree;
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

        BinaryTree<Integer> bT = new BinaryTree1<>();
        Integer root = 1;

        BinaryTree<Integer> bTL = new BinaryTree1<>();
        BinaryTree<Integer> bTR = new BinaryTree1<>();

        Integer rootL = 2;
        Integer rootR = 3;

        BinaryTree<Integer> leftL = new BinaryTree1<>();
        BinaryTree<Integer> rightL = new BinaryTree1<>();
        BinaryTree<Integer> leftR = new BinaryTree1<>();
        BinaryTree<Integer> rightR = new BinaryTree1<>();

        BinaryTree<Integer> bTLL = new BinaryTree1<>();
        BinaryTree<Integer> bTRL = new BinaryTree1<>();

        Integer rootLL = 4;
        Integer rootRL = 5;

        BinaryTree<Integer> leftLL = new BinaryTree1<>();
        BinaryTree<Integer> rightLL = new BinaryTree1<>();
        BinaryTree<Integer> leftRL = new BinaryTree1<>();
        BinaryTree<Integer> rightRL = new BinaryTree1<>();

        leftL.assemble(rootLL, leftLL, rightLL);
        rightL.assemble(rootRL, leftRL, rightRL);

        bTL.assemble(rootL, leftL, rightL);
        bTR.assemble(rootR, leftR, rightR);

        bT.assemble(root, bTL, bTR);

        // System.out.println(treeToString(bT)); // Print Tree

        System.out.println(isInTree(bT, 2));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
