package org.ashlarbox.pojomatic;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.apache.commons.collections.CollectionUtils.isNotEmpty;
import static org.apache.commons.lang.StringUtils.join;
import static org.junit.Assert.fail;

public abstract class PojomaticTester implements PojomaticTest {

    private final PojomaticObjectTester pojomaticObjectTester = new PojomaticObjectTester();

    private List<String> errors;

    @Before
    public void initializeErrors() {
        errors = newArrayList();
    }

    @Test
    @Override
    public final void runPojomaticTests() {
        pojomaticObjectTester.runTests(this, errors);
        checkErrorsForFailure(errors);
    }

    private void checkErrorsForFailure(List<String> errors) {
        if (isNotEmpty(errors)) {
            fail(join(errors, "\n"));
        }
    }
}
