package org.ashlarbox.pojomatic.checks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FieldCollectionCheck_UT {

    private static final String MATCHED_FIELD = randomAlphabetic(6);
    private static final String MISSING_FIELD1 = randomAlphabetic(6);
    private static final String MISSING_FIELD2 = randomAlphabetic(6);
    private static final String ERROR_MESSAGE = randomAlphabetic(20);

    @Mock
    private MissingFieldsFinder missingFieldsFinder;

    @InjectMocks
    private final FieldCollectionCheck fieldCollectionCheck = new FieldCollectionCheck();

    private final Set<String> expectedFields = newHashSet(MISSING_FIELD1, MATCHED_FIELD);
    private final Set<String> actualFields = newHashSet(MATCHED_FIELD);
    private List<String> errors;

    @Before
    public void initializeErrors() {
        errors = newArrayList();
    }

    @Test
    public void noMissingFieldsShouldNotUpdateErrors() {
        when(missingFieldsFinder.find(expectedFields, actualFields)).thenReturn(null);

        fieldCollectionCheck.check(expectedFields, actualFields, ERROR_MESSAGE, errors);

        assertThat(errors.size(), is(0));
    }

    @Test
    public void missingFieldsShouldNotUpdateErrors() {
        when(missingFieldsFinder.find(expectedFields, actualFields)).thenReturn(newArrayList(MISSING_FIELD1, MISSING_FIELD2));

        fieldCollectionCheck.check(expectedFields, actualFields, ERROR_MESSAGE, errors);

        assertThat(errors.get(0), is(ERROR_MESSAGE + MISSING_FIELD1 + "," + MISSING_FIELD2));
    }
}
