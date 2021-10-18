import static org.junit.Assert.assertEquals;

import components.map.Map;
import components.map.Map.Pair;

/**
 * JUnit test fixture for {@code Map<String, String>}'s constructor and kernel
 * methods.
 *
 * @author Nick Boenau
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

    /*
     * Constructor test cases
     */
    public final void constructorNoArgsTestCase() {
        Map<String, String> map = this.constructorTest();
        Map<String, String> mapExpected = this.constructorTest();
        /*
         * Assures inputed values match expected
         */
        assertEquals(map, mapExpected);

    }

    public final void constructorOneArgTestCase() {
        Map<String, String> map = this.createFromArgsTest("Red", "One");
        Map<String, String> mapExpected = this.createFromArgsRef("Red", "One");
        /*
         * Assures inputed values match expected
         */
        assertEquals(map, mapExpected);

    }

    /*
     * Kernel method test cases
     */
    public final void addEmptyTestCase() {
        Map<String, String> map = this.createFromArgsTest();
        Map<String, String> mapExpected = this.createFromArgsRef("Red", "One");

        map.add("Red", "One");
        /*
         * Assures inputed values match expected
         */
        assertEquals(map, mapExpected);
    }

    public final void addNonEmptyTestCase() {
        Map<String, String> map = this.createFromArgsTest("Red", "One");
        Map<String, String> mapExpected = this.createFromArgsRef("Red", "One",
                "Green", "Two");

        map.add("Green", "Two");

        /*
         * Assures inputed values match expected
         */
        assertEquals(map, mapExpected);
    }

    public final void removeEmptyTestCase() {
        Map<String, String> map = this.createFromArgsTest("Red", "One");
        Map<String, String> mapExpected = this.createFromArgsRef();

        Pair<String, String> r = map.remove("Red");
        /*
         * Assures inputed values match expected
         */
        assertEquals(map, mapExpected);
        assertEquals(r, "Red");

    }

    public final void removeNonEmptyTestCase() {
        Map<String, String> map = this.createFromArgsTest("Red", "One", "Green",
                "Two");
        Map<String, String> mapExpected = this.createFromArgsRef("Red", "One");

        Pair<String, String> r = map.remove("Red");

        /*
         * Assures inputed values match expected
         */
        assertEquals(map, mapExpected);
        assertEquals(r, "Red");

    }

    public final void removeAnyEmptyTestCase() {
        Map<String, String> map = this.createFromArgsTest("Red", "One");
        Map<String, String> mapExpected = this.createFromArgsRef();

        Pair<String, String> r = map.removeAny();
        /*
         * Assures inputed values match expected
         */
        assertEquals(map, mapExpected);

    }

    public final void removeAnyNonEmptyTestCase() {
        Map<String, String> map = this.createFromArgsTest("Red", "One", "Green",
                "Two");
        Map<String, String> mapExpected = this.createFromArgsRef("Red", "One");

        Pair<String, String> r = map.removeAny();

        /*
         * Assures inputed values match expected
         */
        assertEquals(map, mapExpected);
    }

    public final void valueEmptyTestCase() {
        Map<String, String> map = this.createFromArgsTest();
        Map<String, String> mapExpected = this.createFromArgsRef();

        /*
         * Assures inputed values match expected
         */
        assertEquals(map, mapExpected);
        assertEquals(map.value(null), true);

    }

    public final void valueNonEmptyTestCase() {
        Map<String, String> map = this.createFromArgsTest("Red", "One");
        Map<String, String> mapExpected = this.createFromArgsRef("Red", "One");

        /*
         * Assures inputed values match expected
         */
        assertEquals(map, mapExpected);
        assertEquals(map.value("Red"), true);

    }

    public final void hasKeyEmptyTestCase() {
        Map<String, String> map = this.createFromArgsTest();
        Map<String, String> mapExpected = this.createFromArgsRef();

        map.hasKey(null);
        /*
         * Assures inputed values match expected
         */
        assertEquals(map, mapExpected);
    }

    public final void hasKeyNonEmptyTestCase() {
        Map<String, String> map = this.createFromArgsTest("Red", "One");
        Map<String, String> mapExpected = this.createFromArgsRef("Red", "One");

        map.hasKey("Red");

        /*
         * Assures inputed values match expected
         */
        assertEquals(map, mapExpected);
    }

    public final void sizeEmptyTestCase() {
        Map<String, String> map = this.createFromArgsTest();
        Map<String, String> mapExpected = this.createFromArgsRef();

        int r = map.size();
        /*
         * Assures inputed values match expected
         */
        assertEquals(map, mapExpected);
        assertEquals(r, 0);

    }

    public final void sizeNonEmptyTestCase() {
        Map<String, String> map = this.createFromArgsTest("Red", "One");
        Map<String, String> mapExpected = this.createFromArgsRef("Red", "One");

        int r = map.size();

        /*
         * Assures inputed values match expected
         */
        assertEquals(map, mapExpected);
        assertEquals(r, 1);

    }

}