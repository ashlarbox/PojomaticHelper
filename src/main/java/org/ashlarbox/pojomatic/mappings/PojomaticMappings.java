package org.ashlarbox.pojomatic.mappings;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

public class PojomaticMappings {

    private final Set<String> equalsFields = newHashSet();
    private final Set<String> hashCodeFields = newHashSet();
    private final Set<String> toStringFields = newHashSet();

    public void addEqualsField(String field) {
        equalsFields.add(field);
    }

    public Set<String> getEqualsFields() {
        return equalsFields;
    }

    public void addHashCodeField(String field) {
        hashCodeFields.add(field);
    }

    public Set<String> getHashCodeFields() {
        return hashCodeFields;
    }

    public void addToStringField(String field) {
        toStringFields.add(field);
    }

    public Set<String> getToStringFields() {
        return toStringFields;
    }

}
