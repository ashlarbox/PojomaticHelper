package org.ashlarbox.pojomatic.checks;

import java.util.List;
import java.util.Set;

public class FieldCollectionComparer {

    private FieldCollectionCheck fieldCollectionCheck = new FieldCollectionCheck();

    public void compare(Set<String> expectedFields, Set<String> actualFields, String type, List<String> errors) {
        fieldCollectionCheck.check(expectedFields, actualFields, "Missing expected " + type + " field definition: ", errors);
        fieldCollectionCheck.check(actualFields, expectedFields, "Unexpected " + type + " field definition found: ", errors);
    }

}
