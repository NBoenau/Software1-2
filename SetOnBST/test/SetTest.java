import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Put your name here
 *
 */
public abstract class SetTest {

    /**
     * Invokes the appropriate {@code Set} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new set
     * @ensures constructorRef = {}
     */
    protected abstract Set<String> constructorRef();

    /**
     * Creates and returns a {@code Set<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private Set<String> createFromArgsTest(String... args) {
        Set<String> set = this.constructorTest();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    /**
     * Creates and returns a {@code Set<String>} of the reference implementation
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsRef = [entries in args]
     */
    private Set<String> createFromArgsRef(String... args) {
        Set<String> set = this.constructorRef();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    // TODO - add test cases for constructor, remove, contains

    /*
     * Kernel method test cases
     */

    @Test
    public final void testAddEmpty() {
        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef("One");

        s.add("One");
        /*
         * Assures inputed values match expected
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testAddNonEmpty() {

        Set<String> s = this.createFromArgsTest("One", "Two", "Three");
        Set<String> sExpected = this.createFromArgsRef("One", "Two", "Three",
                "Four");

        s.add("Four");
        /*
         * Assures inputed values match expected
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testRemoveAnyOneEntry() {
        Set<String> s = this.createFromArgsTest("One");
        Set<String> sExpected = this.createFromArgsRef("One");

        String sRA = s.removeAny();
        /*
         * Assures inputed values match expected
         */
        assertEquals(true, sExpected.contains(sRA));
        sExpected.remove(sRA);
        assertEquals(sExpected, s);
    }

    @Test
    public final void testRemoveAnyTwoEntry() {
        Set<String> s = this.createFromArgsTest("One", "Two");
        Set<String> sExpected = this.createFromArgsRef("One", "Two");

        String sRA = s.removeAny();
        /*
         * Assures inputed values match expected
         */
        assertEquals(true, sExpected.contains(sRA));
        sExpected.remove(sRA);
        assertEquals(sExpected, s);
    }

    @Test
    public final void testRemoveAnyThreeEntry() {
        Set<String> s = this.createFromArgsTest("One", "Two", "Three");
        Set<String> sExpected = this.createFromArgsRef("One", "Two", "Three");

        String sRA = s.removeAny();
        /*
         * Assures inputed values match expected
         */
        assertEquals(true, sExpected.contains(sRA));
        sExpected.remove(sRA);
        assertEquals(sExpected, s);
    }

    @Test
    public final void testRemoveAnyMultiEntry() {
        Set<String> s = this.createFromArgsTest("One", "Two", "Three", "Four",
                "Five", "Six");
        Set<String> sExpected = this.createFromArgsRef("One", "Two", "Three",
                "Four", "Five", "Six");

        String sRA = s.removeAny();
        /*
         * Assures inputed values match expected
         */
        assertEquals(true, sExpected.contains(sRA));
        sExpected.remove(sRA);
        assertEquals(sExpected, s);
    }

    @Test
    public final void testSizeEmpty() {
        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef();

        int sS = s.size();
        /*
         * Assures inputed values match expected
         */
        assertEquals(sExpected, s);
        assertEquals(sS, 0);

    }

    @Test
    public final void testSizeOne() {
        Set<String> s = this.createFromArgsTest("One");
        Set<String> sExpected = this.createFromArgsRef("One");

        int sS = s.size();
        /*
         * Assures inputed values match expected
         */
        assertEquals(sExpected, s);
        assertEquals(sS, 1);

    }

    @Test
    public final void testSizeTwo() {
        Set<String> s = this.createFromArgsTest("One", "Two");
        Set<String> sExpected = this.createFromArgsRef("One", "Two");

        int sS = s.size();
        /*
         * Assures inputed values match expected
         */
        assertEquals(sExpected, s);
        assertEquals(sS, 2);

    }

    @Test
    public final void testSizeThree() {
        Set<String> s = this.createFromArgsTest("One", "Two", "Three");
        Set<String> sExpected = this.createFromArgsRef("One", "Two", "Three");

        int sS = s.size();
        /*
         * Assures inputed values match expected
         */
        assertEquals(sExpected, s);
        assertEquals(sS, 3);

    }

    @Test
    public final void testSizeMulti() {
        Set<String> s = this.createFromArgsTest("One", "Two", "Three", "Four",
                "Five", "Six");
        Set<String> sExpected = this.createFromArgsRef("One", "Two", "Three",
                "Four", "Five", "Six");

        int sS = s.size();
        /*
         * Assures inputed values match expected
         */
        assertEquals(sExpected, s);
        assertEquals(sS, 6);

    }

}
