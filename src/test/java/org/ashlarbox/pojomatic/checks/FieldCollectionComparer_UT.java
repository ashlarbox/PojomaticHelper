package org.ashlarbox.pojomatic.checks;

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
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FieldCollectionComparer_UT {

    @Mock
    private FieldCollectionCheck fieldCollectionCheck;

    @InjectMocks
    private final FieldCollectionComparer fieldCollectionComparer = new FieldCollectionComparer();

    @Test
    public void comparerShouldRunExpectedChecks() {
        Set<String> expectedFields = newHashSet(randomAlphabetic(6));
        Set<String> actualFields = newHashSet(randomAlphabetic(7));
        String type = randomAlphabetic(8);
        List<String> errors = newArrayList();

        fieldCollectionComparer.compare(expectedFields, actualFields, type, errors);

        verify(fieldCollectionCheck).check(expectedFields, actualFields, "Missing expected " + type + " field definition: ", errors);
        verify(fieldCollectionCheck).check(actualFields, expectedFields, "Unexpected " + type + " field definition found: ", errors);
    }
}
