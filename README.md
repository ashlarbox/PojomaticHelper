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

Optionally, you do not need to explicitly use PojomaticObject. However, to use the PojomaticTester, you need to include
following code in your class.

    '    @Override
         public final boolean equals(Object o) {
             return Pojomatic.equals(this, o);
         }

         @Override
         public final int hashCode() {
             return Pojomatic.hashCode(this);
         }

         @Override
         public final String toString() {
             return Pojomatic.toString(this);
         }


PojomaticTester
-------------------------------

PojomaticTester allows you to define in unit tests the exact fields you expect to be used in the Pojomatic calls.

    public class YourClass_UT extends PojomaticTester {

        @Override
        public Class getTestClass() {
            return YourClass.class;
        }

        @Override
        public Set<String> getEqualsFields() {
            return newHashSet("id", "username", "name", "address", "password");
        }

        @Override
        public Set<String> getHashCodeFields() {
            return newHashSet("username");
        }

        @Override
        public Set<String> getToStringFields() {
            return newHashSet("id", "username", "name", "address");
        }

    }

Now that you have the fields mapped in a test, you can add the Pojomatic annotations to make the test pass.

See both `YourPojomaticObject` and `YourObject` for examples.


No Conflicts
-------------------------------

While PojomaticHelper helps implement and test your Pojomatic usage, it only deals with Pojomatic logic and annotations.
You can also implement non-Pojomatic tests annotations and code as needed.


