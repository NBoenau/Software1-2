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
public final class BinaryTreeRecusion {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private BinaryTreeRecusion() {
    }

    /**
     * Returns the size of the given {@code BinaryTree<T>}.
     *
     * @param <T>
     *            the type of the {@code BinaryTree} node labels
     * @param t
     *            the {@code BinaryTree} whose size to return
     * @return the size of the given {@code BinaryTree}
     * @ensures size = |t|
     */
    public static <T> int sizeR(BinaryTree<T> t) {
        int size = 0;

        T root;
        BinaryTree<T> left = new BinaryTree1<>();
        BinaryTree<T> right = new BinaryTree1<>();

        if (t.height() > 0) {
            root = t.disassemble(left, right);
            size++;
            size += sizeR(left);
            size += sizeR(right);
            t.assemble(root, left, right);
        }

        return size;
    }

    /**
     * Returns the size of the given {@code BinaryTree<T>}.
     *
     * @param <T>
     *            the type of the {@code BinaryTree} node labels
     * @param t
     *            the {@code BinaryTree} whose size to return
     * @return the size of the given {@code BinaryTree}
     * @ensures size = |t|
     */
    public static <T> int sizeI(BinaryTree<T> t) {
        int size = 0;

        T root;
        BinaryTree<T> left = new BinaryTree1<>();
        BinaryTree<T> right = new BinaryTree1<>();

        int h = t.height();
        while (h > 0) {
            root = t.disassemble(left, right);
            size += 3;
            h = t.height();
            t.assemble(root, left, right);
        }

        return size;
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

        BinaryTree<String> bT = new BinaryTree1<>();
        String root = "First";

        BinaryTree<String> bTL = new BinaryTree1<>();
        BinaryTree<String> bTR = new BinaryTree1<>();

        String rootL = "Second";
        String rootR = "Third";

        BinaryTree<String> leftL = new BinaryTree1<>();
        BinaryTree<String> rightL = new BinaryTree1<>();
        BinaryTree<String> leftR = new BinaryTree1<>();
        BinaryTree<String> rightR = new BinaryTree1<>();

        BinaryTree<String> bTLL = new BinaryTree1<>();
        BinaryTree<String> bTRL = new BinaryTree1<>();

        String rootLL = "Fourth";
        String rootRL = "Fifth";

        BinaryTree<String> leftLL = new BinaryTree1<>();
        BinaryTree<String> rightLL = new BinaryTree1<>();
        BinaryTree<String> leftRL = new BinaryTree1<>();
        BinaryTree<String> rightRL = new BinaryTree1<>();

        leftL.assemble(rootLL, leftLL, rightLL);
        rightL.assemble(rootRL, leftRL, rightRL);

        bTL.assemble(rootL, leftL, rightL);
        bTR.assemble(rootR, leftR, rightR);

        bT.assemble(root, bTL, bTR);

        System.out.println(bT); // Print Tree
        System.out.println(bT.size()); // Print Tree Size Kernel
        System.out.println(sizeI(bT)); // Print Tree Size Iterative
        System.out.println(sizeR(bT)); // Print Tree Size Recursive

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
