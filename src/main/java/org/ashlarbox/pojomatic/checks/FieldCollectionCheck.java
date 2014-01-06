package org.ashlarbox.pojomatic.checks;

import java.util.List;
import java.util.Set;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;
import static org.apache.commons.lang.StringUtils.join;

public class FieldCollectionCheck {

    private MissingFieldsFinder missingFieldsFinder = new MissingFieldsFinder();

    public void check(Set<String> checkFields, Set<String> verifySet, String message, List<String> errors) {
        List<String> errorFields = missingFieldsFinder.find(checkFields, verifySet);
        if (isNotEmpty(errorFields)) {
            errors.add(message + join(errorFields, ","));
        }
    }
}
