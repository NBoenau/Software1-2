import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;

/**
 * JUnit test fixture for {@code Map<String, String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class MapTest {

    /**
     * Invokes the appropriate {@code Map} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new map
     * @ensures constructorTest = {}
     */
    protected abstract Map<String, String> constructorTest();

    /**
     * Invokes the appropriate {@code Map} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new map
     * @ensures constructorRef = {}
     */
    protected abstract Map<String, String> constructorRef();

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsTest = [pairs in args]
     */
    private Map<String, String> createFromArgsTest(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorTest();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsRef = [pairs in args]
     */
    private Map<String, String> createFromArgsRef(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorRef();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    // TODO - add test cases for constructor, add, removeAny,
    // hasKey

    /*
     * Constructor Test Cases
     */

    /*
     * Kernel Method Test Cases
     */

    @Test
    public final void testRemoveEmpty() {

        Map<String, String> map = this.createFromArgsTest("One", "Red");
        Map<String, String> mapExpected = this.createFromArgsRef();
        String xKeyExpected = "One", xValueExpected = "Red";

        Map.Pair<String, String> x = map.remove("One");

        assertEquals(mapExpected, map);
        assertEquals(xKeyExpected, x.key());
        assertEquals(xValueExpected, x.value());
    }

    @Test
    public final void testRemoveTwoEntry() {

        Map<String, String> map = this.createFromArgsTest("One", "Red", "Two",
                "Green");
        Map<String, String> mapExpected = this.createFromArgsRef("One", "Red");
        String xKeyExpected = "Two", xValueExpected = "Green";

        Map.Pair<String, String> x = map.remove("Two");

        assertEquals(mapExpected, map);
        assertEquals(xKeyExpected, x.key());
        assertEquals(xValueExpected, x.value());
    }

    @Test
    public final void testRemoveMulti() {

        Map<String, String> map = this.createFromArgsTest("One", "Red", "Two",
                "Green", "Three", "Blue");
        Map<String, String> mapExpected = this.createFromArgsRef("One", "Red",
                "Two", "Green");
        String xKeyExpected = "Three", xValueExpected = "Blue";

        Map.Pair<String, String> x = map.remove("Three");

        assertEquals(mapExpected, map);
        assertEquals(xKeyExpected, x.key());
        assertEquals(xValueExpected, x.value());
    }

    @Test
    public final void testValueOneEntry() {

        Map<String, String> m = this.createFromArgsTest("One", "Red");
        Map<String, String> mExpected = this.createFromArgsRef("One", "Red");

        String x = m.value("One");

        assertEquals(mExpected, m);
        assertEquals("Red", x);
    }

    @Test
    public final void testValueMultiEntry() {

        Map<String, String> m = this.createFromArgsTest("One", "Red", "Two",
                "Green", "Three", "Blue");
        Map<String, String> mExpected = this.createFromArgsRef("One", "Red",
                "Two", "Green", "Three", "Blue");

        String x = m.value("Two");

        assertEquals(mExpected, m);
        assertEquals("Green", x);
    }

    @Test
    public final void testSizeEmpty() {

        Map<String, String> m = this.createFromArgsTest();
        Map<String, String> mExpected = this.createFromArgsRef();

        int i = m.size();

        assertEquals(mExpected, m);
        assertEquals(0, i);
    }

    @Test
    public final void testSizeOne() {

        Map<String, String> m = this.createFromArgsTest("One", "Red");
        Map<String, String> mExpected = this.createFromArgsRef("One", "Red");

        int i = m.size();

        assertEquals(mExpected, m);
        assertEquals(1, i);
    }

    @Test
    public final void testSizeMultie() {

        Map<String, String> m = this.createFromArgsTest("One", "Red", "Two",
                "Green", "Three", "Blue");
        Map<String, String> mExpected = this.createFromArgsRef("One", "Red",
                "Two", "Green", "Three", "Blue");

        int i = m.size();

        assertEquals(mExpected, m);
        assertEquals(3, i);
    }

}