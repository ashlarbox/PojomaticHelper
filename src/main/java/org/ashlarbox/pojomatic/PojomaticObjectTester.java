package org.ashlarbox.pojomatic;

import org.ashlarbox.pojomatic.checks.FieldCollectionComparer;
import org.ashlarbox.pojomatic.mappings.PojomaticMappings;
import org.ashlarbox.pojomatic.mappings.PojomaticMappingsBuilder;

import java.util.List;

public class PojomaticObjectTester {

    private PojomaticMappingsBuilder pojomaticMappingsBuilder = new PojomaticMappingsBuilder();
    private FieldCollectionComparer fieldCollectionComparer = new FieldCollectionComparer();

    private PojomaticMappings pojomaticMappings;

    public void runTests(PojomaticTest pojomaticTest, List<String> errors) {
        if (pojomaticTest.getPojomaticObject() != null) {
            performTests(pojomaticTest, errors);
        } else {
            errors.add("PojomaticObject not defined to test");
        }
    }

    private void performTests(PojomaticTest pojomaticTest, List<String> errors) {
        pojomaticMappings = pojomaticMappingsBuilder.build(pojomaticTest.getPojomaticObject());
        fieldCollectionComparer.compare(pojomaticTest.getEqualsFields(), pojomaticMappings.getEqualsFields(), "equals", errors);
        fieldCollectionComparer.compare(pojomaticTest.getHashCodeFields(), pojomaticMappings.getHashCodeFields(), "hashCode", errors);
        fieldCollectionComparer.compare(pojomaticTest.getToStringFields(), pojomaticMappings.getToStringFields(), "toString", errors);
    }

}
