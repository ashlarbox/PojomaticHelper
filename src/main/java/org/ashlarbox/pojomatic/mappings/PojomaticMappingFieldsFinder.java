package org.ashlarbox.pojomatic.mappings;

import org.ashlarbox.pojomatic.PojomaticObject;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.collect.Iterables.filter;
import static java.util.Arrays.asList;

public class PojomaticMappingFieldsFinder {

    private NotStaticOrFinalPredicate notStaticOrFinalPredicate = new NotStaticOrFinalPredicate();

    public Iterable<Field> find(PojomaticObject pojomaticObject) {
        List<Field> fields = asList(pojomaticObject.getClass().getDeclaredFields());
        return filter(fields, notStaticOrFinalPredicate);

    }
}
