package org.ashlarbox.pojomatic.mappings;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NotStaticOrFinalPredicate_UT {

    private final NotStaticOrFinalPredicate notStaticOrFinalPredicate = new NotStaticOrFinalPredicate();

    private static String STATIC = "STATIC";
    private final String finalString = "finalString";
    private static final String STATIC_FINAL = "STATIC_FINAL";
    private String fieldString = "fieldString";

    @Test
    public void staticShouldNotApplyPredicate() throws NoSuchFieldException {
        assertThat(notStaticOrFinalPredicate.apply(this.getClass().getDeclaredField(STATIC)), is(false));
    }

    @Test
    public void finalShouldNotApplyPredicate() throws NoSuchFieldException {
        assertThat(notStaticOrFinalPredicate.apply(this.getClass().getDeclaredField(finalString)), is(false));
    }


    @Test
    public void staticFinalShouldNotApplyPredicate() throws NoSuchFieldException {
        assertThat(notStaticOrFinalPredicate.apply(this.getClass().getDeclaredField(STATIC_FINAL)), is(false));
    }

    @Test
    public void unmodifiedFieldShouldApplyPredicate() throws NoSuchFieldException {
        assertThat(notStaticOrFinalPredicate.apply(this.getClass().getDeclaredField(fieldString)), is(true));
    }

}
