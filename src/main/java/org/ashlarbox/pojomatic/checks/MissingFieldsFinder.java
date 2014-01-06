package org.ashlarbox.pojomatic.checks;

import com.google.common.base.Predicate;

import java.util.List;
import java.util.Set;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;

public class MissingFieldsFinder {

    public List<String> find(Set<String> checkFields, Set<String> verifySet) {
        return newArrayList(filter(checkFields, checkPredicate(verifySet)));
    }

    private Predicate<String> checkPredicate(final Set<String> verifySet) {
        return new Predicate<String>() {
            @Override
            public boolean apply(String s) {
                return (verifySet.contains(s) == false);
            }
        };
    }
}
