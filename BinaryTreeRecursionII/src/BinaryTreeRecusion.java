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
     * Returns the {@code String} prefix representation of the given
     * {@code BinaryTree<T>}.
     *
     * @param <T>
     *            the type of the {@code BinaryTree} node labels
     * @param t
     *            the {@code BinaryTree} to convert to a {@code String}
     * @return the prefix representation of {@code t}
     * @ensures treeToString = [the String prefix representation of t]
     */
    public static <T> String treeToString(BinaryTree<T> t) {
        String Result = "";
        String temp = "";

        T root;
        BinaryTree<T> left = new BinaryTree1<>();
        BinaryTree<T> right = new BinaryTree1<>();

        if (t.height() > 0) {
            root = t.disassemble(left, right);
            temp = (String) root;
            Result = Result + "(" + temp + treeToString(left) + ")"
                    + treeToString(right);

            t.assemble(root, left, right);
        } else {
            Result = "()";
        }

        return Result;
    }

    /**
     * Returns a copy of the the given {@code BinaryTree}.
     *
     * @param t
     *            the {@code BinaryTree} to copy
     * @return a copy of the given {@code BinaryTree}
     * @ensures copy = t
     */
    public static BinaryTree<Integer> copy(BinaryTree<Integer> t) {
        BinaryTree<Integer> result = new BinaryTree1<>();

        int root;
        BinaryTree<Integer> left = new BinaryTree1<>();
        BinaryTree<Integer> right = new BinaryTree1<>();

        if (t.height() > 0) {
            root = t.disassemble(left, right);
            result.assemble(root, copy(left), copy(right));
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

        System.out.println(copy(bT));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
