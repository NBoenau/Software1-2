import static org.junit.Assert.assertEquals;

import components.set.Set;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Nick BOenau
 *
 */
public abstract class SetOnQueueTest {

    /**
     * Invokes the appropriate {@code Set} constructor and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor and returns the result.
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

    /*
     * Constructor test cases
     */
    public final void constructorNoArgsTestCase() {
        Set<String> Set = this.constructorTest();
        Set<String> SetExpected = this.constructorTest();
        /*
         * Assures inputed values match expected
         */
        assertEquals(Set, SetExpected);

    }

    public final void constructorOneArgTestCase() {
        Set<String> Set = this.createFromArgsTest("Red");
        Set<String> SetExpected = this.createFromArgsRef("Red");
        /*
         * Assures inputed values match expected
         */
        assertEquals(Set, SetExpected);


    /*
     * Kernel method test cases
     */
    public final void addEmptyTestCase() {
        Set<String> Set = this.createFromArgsTest();
        Set<String> SetExpected = this.createFromArgsRef("Red");

        Set.add("Red");
        /*
         * Assures inputed values match expected
         */
        assertEquals(Set, SetExpected);
    }

    public final void addNonEmptyTestCase() {
        Set<String> Set = this.createFromArgsTest("Red");
        Set<String> SetExpected = this.createFromArgsRef("Red", "Green");

        Set.add("Green");

        /*
         * Assures inputed values match expected
         */
        assertEquals(Set, SetExpected);
    }

    public final void removeEmptyTestCase() {
        Set<String> Set = this.createFromArgsTest("Red");
        Set<String> SetExpected = this.createFromArgsRef();

        String r = Set.remove("Red");
        /*
         * Assures inputed values match expected
         */
        assertEquals(Set, SetExpected);
    }

    public final void removeNonEmptyTestCase() {
        Set<String> Set = this.createFromArgsTest("Red", "Green");
        Set<String> SetExpected = this.createFromArgsRef("Red");

        String r = Set.remove("Green");

        /*
         * Assures inputed values match expected
         */
        assertEquals(Set, SetExpected);
        assertEquals(r, "Green");

    }

    public final void removeAnyEmptyTestCase() {
        Set<String> Set = this.createFromArgsTest("Red");
        Set<String> SetExpected = this.createFromArgsRef();

        String r = Set.removeAny();
        /*
         * Assures inputed values match expected
         */
        assertEquals(Set, SetExpected);
    }

    public final void removeAnyNonEmptyTestCase() {
        Set<String> Set = this.createFromArgsTest("Red", "Green");
        Set<String> SetExpected = this.createFromArgsRef("Red");

        String r = Set.removeAny();

        /*
         * Assures inputed values match expected
         */
        assertEquals(Set, SetExpected);
        assertEquals(r, "Green");
    }

    public final void containsEmptyTestCase() {
        Set<String> Set = this.createFromArgsTest();
        Set<String> SetExpected = this.createFromArgsRef();

        Set.contains(null);
        /*
         * Assures inputed values match expected
         */
        assertEquals(Set, SetExpected);
    }

    public final void containsNonEmptyTestCase() {
        Set<String> Set = this.createFromArgsTest("Red");
        Set<String> SetExpected = this.createFromArgsRef("Red");

        Set.contains("Red");

        /*
         * Assures inputed values match expected
         */
        assertEquals(Set, SetExpected);
    }

    public final void sizeEmptyTestCase() {
        Set<String> Set = this.createFromArgsTest();
        Set<String> SetExpected = this.createFromArgsRef();

        int r = Set.size();
        /*
         * Assures inputed values match expected
         */
        assertEquals(Set, SetExpected);
        assertEquals(r, 0);

    }

    public final void sizeNonEmptyTestCase() {
        Set<String> Set = this.createFromArgsTest("Red");
        Set<String> SetExpected = this.createFromArgsRef("Red");

        int r = Set.size();

        /*
         * Assures inputed values match expected
         */
        assertEquals(Set, SetExpected);
        assertEquals(r, 1);

    }

}