package org.ashlarbox.pojomatic.mappings;

import com.google.common.base.Predicate;

import java.lang.reflect.Field;

import static java.lang.reflect.Modifier.isFinal;
import static java.lang.reflect.Modifier.isStatic;

public class NotStaticOrFinalPredicate implements Predicate<Field> {

    @Override
    public boolean apply(Field field) {
        return !(isStatic(field.getModifiers()))
            && !(isFinal(field.getModifiers()));
    }

}
