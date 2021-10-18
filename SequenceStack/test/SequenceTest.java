import static org.junit.Assert.assertEquals;

import components.sequence.Sequence;

/**
 * JUnit test fixture for {@code Sequence<String>}'s constructor and kernel
 * methods.
 *
 * @author Nick Boenau
 *
 */
public abstract class SequenceTest {

    /**
     * Invokes the appropriate {@code Sequence} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new sequence
     * @ensures constructorTest = <>
     */
    protected abstract Sequence<String> constructorTest();

    /**
     * Invokes the appropriate {@code Sequence} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new sequence
     * @ensures constructorRef = <>
     */
    protected abstract Sequence<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsTest = [entries in args]
     */
    private Sequence<String> createFromArgsTest(String... args) {
        Sequence<String> sequence = this.constructorTest();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsRef = [entries in args]
     */
    private Sequence<String> createFromArgsRef(String... args) {
        Sequence<String> sequence = this.constructorRef();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /*
     * Constructor test cases
     */

    public final void constructorNoArgsTestCase() {
        Sequence<String> sequence = this.constructorTest();
        Sequence<String> sequenceExpected = this.constructorTest();
        /*
         * Assures inputed values match expected
         */
        assertEquals(sequence, sequenceExpected);

    }

    public final void constructorOneArgTestCase() {
        Sequence<String> sequence = this.createFromArgsTest("Red");
        Sequence<String> sequenceExpected = this.createFromArgsRef("Red");
        /*
         * Assures inputed values match expected
         */
        assertEquals(sequence, sequenceExpected);

    }

    /*
     * Kernel method test cases
     */
    public final void addEmptyTestCase() {
        Sequence<String> sequence = this.createFromArgsTest();
        Sequence<String> sequenceExpected = this.createFromArgsRef("Red");

        sequence.add(sequence.length(), "Red");
        /*
         * Assures inputed values match expected
         */
        assertEquals(sequence, sequenceExpected);
    }

    public final void addNonEmptyTestCase() {
        Sequence<String> sequence = this.createFromArgsTest("Red");
        Sequence<String> sequenceExpected = this.createFromArgsRef("Red",
                "Green");

        sequence.add(sequence.length(), "Green");

        /*
         * Assures inputed values match expected
         */
        assertEquals(sequence, sequenceExpected);
    }

    public final void removeEmptyTestCase() {
        Sequence<String> sequence = this.createFromArgsTest("Red");
        Sequence<String> sequenceExpected = this.createFromArgsRef();

        String r = sequence.remove(0);
        /*
         * Assures inputed values match expected
         */
        assertEquals(sequence, sequenceExpected);
    }

    public final void removeNonEmptyTestCase() {
        Sequence<String> sequence = this.createFromArgsTest("Red", "Green");
        Sequence<String> sequenceExpected = this.createFromArgsRef("Red");

        String r = sequence.remove(1);

        /*
         * Assures inputed values match expected
         */
        assertEquals(sequence, sequenceExpected);
        assertEquals(r, "Green");

    }

    public final void lengthEmptyTestCase() {
        Sequence<String> sequence = this.createFromArgsTest();
        Sequence<String> sequenceExpected = this.createFromArgsRef();

        int x = sequence.length();

        /*
         * Assures inputed values match expected
         */
        assertEquals(sequence, sequenceExpected);
        assertEquals(x, 0);

    }

    public final void lengthNonEmptyTestCase() {
        Sequence<String> sequence = this.createFromArgsTest("Red", "Green");
        Sequence<String> sequenceExpected = this.createFromArgsRef("Red",
                "Green");

        int x = sequence.length();

        /*
         * Assures inputed values match expected
         */
        assertEquals(sequence, sequenceExpected);
        assertEquals(x, 2);

    }

}