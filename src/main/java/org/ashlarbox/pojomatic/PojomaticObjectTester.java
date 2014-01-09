package org.ashlarbox.pojomatic;

import org.ashlarbox.pojomatic.checks.FieldCollectionComparer;
import org.ashlarbox.pojomatic.classproperties.ClassPropertiesRetriever;
import org.pojomatic.internal.ClassProperties;
import org.pojomatic.internal.PropertyRole;

import java.util.List;
import java.util.Set;

import static org.pojomatic.internal.ClassProperties.forClass;

public class PojomaticObjectTester<T> {

    private FieldCollectionComparer fieldCollectionComparer = new FieldCollectionComparer();
    private ClassPropertiesRetriever classPropertiesRetriever = new ClassPropertiesRetriever();


    public void runTests(PojomaticTest pojomaticTest, List<String> errors) {
        performTests(pojomaticTest, errors);
    }

    private void performTests(PojomaticTest pojomaticTest, List<String> errors) {
        ClassProperties classProperties = forClass(pojomaticTest.getTestClass());
        Set<String> equalsFields = classPropertiesRetriever.retrieve(classProperties, PropertyRole.EQUALS);
        fieldCollectionComparer.compare(pojomaticTest.getEqualsFields(), equalsFields, "equals", errors);

        Set<String> hashCodeFields = classPropertiesRetriever.retrieve(classProperties, PropertyRole.HASH_CODE);
        fieldCollectionComparer.compare(pojomaticTest.getHashCodeFields(), hashCodeFields, "hashCode", errors);

        Set<String> toStringFields = classPropertiesRetriever.retrieve(classProperties, PropertyRole.TO_STRING);
        fieldCollectionComparer.compare(pojomaticTest.getToStringFields(), toStringFields, "toString", errors);
    }

}
