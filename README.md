Pojomatic Helper
================================

This utility serves two purposes

* Provide a consistent implementation of
    - Pojomatic.equals()
    - Pojomatic.hashCode()
    - Pojomatic.toString()

* Provide a clear, defined way to test/assure all fields are implemented in Pojomatic as expected.


PojomaticObject
-------------------------

PojomaticObject is a class that implements final versions of equals(), hashCode() and toString(),
calling the Pojomatic versions. PojomaticObject protects your class from accidental override of the Pojomatic functions.

To implement, simply extend PojomaticObject.

    public class YourClass extends PojomaticObject {
        ...
    }

You still need to define how the fields used by Pojomatic using `@AutoProperty` and `@Property` annotations.



PojomaticTester
-------------------------------

PojomaticTester allows you to define in unit tests the exact fields you expect to be used in the Pojomatic calls.

    public class YourClass_UT extends PojomaticTester {

        private PojomaticObject getPojomaticObject() {
            return new YourClass();

        private Set<String> getEqualsFields() {
            return newHashSet("id", "username", "name", "address", "password");
        }

        private Set<String> getHashCodeFields() {
            return newHashSet("id", "username");
        }

        Set<String> getToStringFields() {
            return newHashSet("id", "username", "name", "address");
        }
    }

Now that you have the fields mapped in a test, you can add the Pojomatic annotations to make the test pass.



No Conflicts
-------------------------------

While PojomaticHelper helps implement and test your Pojomatic usage, it only deals with Pojomatic logic and annotations.
You can also implement non-Pojomatic tests annotations and code as needed.


