import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.stack.Stack;
import components.stack.Stack1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Nick Boenau
 *
 */
public final class SequenceStack {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private SequenceStack() {
    }

    /**
     * Shifts entries between {@code leftStack} and {@code rightStack}, keeping
     * reverse of the former concatenated with the latter fixed, and resulting
     * in length of the former equal to {@code newLeftLength}.
     *
     * @param <T>
     *            type of {@code Stack} entries
     * @param leftStack
     *            the left {@code Stack}
     * @param rightStack
     *            the right {@code Stack}
     * @param newLeftLength
     *            desired new length of {@code leftStack}
     * @updates leftStack, rightStack
     * @requires <pre>
     * 0 <= newLeftLength  and
     * newLeftLength <= |leftStack| + |rightStack|
     * </pre>
     * @ensures <pre>
     * rev(leftStack) * rightStack = rev(#leftStack) * #rightStack  and
     * |leftStack| = newLeftLength}
     * </pre>
     */
    private static <T> void setLengthOfLeftStack(Stack<T> leftStack,
            Stack<T> rightStack, int newLeftLength) {
        if (leftStack.length() < newLeftLength) {
            leftStack.flip();
            while (leftStack.length() < newLeftLength) {
                T temp = rightStack.pop();
                leftStack.push(temp);
            }
            leftStack.flip();
        }
        if (leftStack.length() > newLeftLength) {
            rightStack.flip();
            while (leftStack.length() > newLeftLength) {
                T temp = leftStack.pop();
                rightStack.push(temp);
            }
            rightStack.flip();
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

        Stack<Integer> left = new Stack1L<>();
        left.push(3);
        left.push(2);
        left.push(1);

        Stack<Integer> right = new Stack1L<>();
        right.push(6);
        right.push(5);
        right.push(4);

        int length = 5;

        System.out.println(left + " " + right);
        setLengthOfLeftStack(left, right, length);
        System.out.println(left + " " + right);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
