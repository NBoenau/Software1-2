import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.stack.Stack;

/**
 * JUnit test fixture for {@code Stack<String>}'s constructor and kernel
 * methods.
 *
 * @author NickBoenau
 *
 */
public abstract class StackTest {

    /**
     * Invokes the appropriate {@code Stack} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new stack
     * @ensures constructorTest = <>
     */
    protected abstract Stack<String> constructorTest();

    /**
     * Invokes the appropriate {@code Stack} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new stack
     * @ensures constructorRef = <>
     */
    protected abstract Stack<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Stack<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the stack
     * @return the constructed stack
     * @ensures createFromArgsTest = [entries in args]
     */
    private Stack<String> createFromArgsTest(String... args) {
        Stack<String> stack = this.constructorTest();
        for (String s : args) {
            stack.push(s);
        }
        stack.flip();
        return stack;
    }

    /**
     *
     * Creates and returns a {@code Stack<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the stack
     * @return the constructed stack
     * @ensures createFromArgsRef = [entries in args]
     */
    private Stack<String> createFromArgsRef(String... args) {
        Stack<String> stack = this.constructorRef();
        for (String s : args) {
            stack.push(s);
        }
        stack.flip();
        return stack;
    }

    /*
     * Test cases for constructors
     */
    @Test
    public final void testNoArgConstructor() {

        Stack<String> s = this.constructorTest();
        Stack<String> sExpected = this.constructorRef();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    /*
     * Test cases for kernel methods
     */

    @Test
    public final void testNoArgPush() {

        Stack<String> s = this.createFromArgsTest();
        Stack<String> sExpected = this.createFromArgsRef("One");

        s.push("One");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testOneArgPush() {

        Stack<String> s = this.createFromArgsTest("One");
        Stack<String> sExpected = this.createFromArgsRef("One", "Two");

        s.push("Two");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testNoArgPop() {

        Stack<String> s = this.createFromArgsTest("One");
        Stack<String> sExpected = this.createFromArgsRef();

        String sX = s.pop();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals("One", sX);
    }

    @Test
    public final void testOneArgPop() {

        Stack<String> s = this.createFromArgsTest("One", "Two");
        Stack<String> sExpected = this.createFromArgsRef("Two");

        String sX = s.pop();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals("One", sX);
    }

    @Test
    public final void testMutliArgPop() {

        Stack<String> s = this.createFromArgsTest("One", "Two", "Three");
        Stack<String> sExpected = this.createFromArgsRef("Two", "Three");

        String sX = s.pop();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals("One", sX);
    }

    @Test
    public final void testNoArgLength() {

        Stack<String> s = this.createFromArgsTest();
        Stack<String> sExpected = this.createFromArgsRef();

        int sX = s.length();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(0, sX);
    }

    @Test
    public final void testOneArgLength() {

        Stack<String> s = this.createFromArgsTest("One");
        Stack<String> sExpected = this.createFromArgsRef("One");

        int sX = s.length();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(1, sX);
    }

    @Test
    public final void testMutliArgLength() {

        Stack<String> s = this.createFromArgsTest("One", "Two", "Three");
        Stack<String> sExpected = this.createFromArgsRef("One", "Two", "Three");

        int sX = s.length();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(3, sX);
    }

}