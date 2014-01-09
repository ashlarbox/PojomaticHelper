package org.ashlarbox.pojomatic;

import org.ashlarbox.pojomatic.checks.FieldCollectionComparer;
import org.ashlarbox.pojomatic.classproperties.ClassPropertiesRetriever;
import org.ashlarbox.pojomatic.testobject.YourPojomaticObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.pojomatic.internal.ClassProperties;
import org.pojomatic.internal.PropertyRole;

import java.util.List;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.pojomatic.internal.ClassProperties.forClass;

@RunWith(MockitoJUnitRunner.class)
public class PojomaticObjectTester_UT {

    @Mock
    private ClassPropertiesRetriever classPropertiesRetriever;

    @Mock
    private FieldCollectionComparer fieldCollectionComparer;

    @InjectMocks
    private final PojomaticObjectTester tester = new PojomaticObjectTester();

    private final PojomaticTest pojomaticTest = mock(PojomaticTest.class);
    private final ClassProperties classProperties = forClass(YourPojomaticObject.class);

    private final Set<String> testEqualsSet = newHashSet(randomAlphanumeric(5));
    private final Set<String> mappingsEqualsSet = newHashSet(randomAlphanumeric(5));
    private final Set<String> testHashCodeSet = newHashSet(randomAlphanumeric(5));
    private final Set<String> mappingsHashCodeSet = newHashSet(randomAlphanumeric(5));
    private final Set<String> testToStringSet = newHashSet(randomAlphanumeric(5));
    private final Set<String> mappingsToStringSet = newHashSet(randomAlphanumeric(5));


    private List<String> errors;

    @Before
    public void initializeErrors() {
        errors = newArrayList();
    }

    @Before
    public void mockPojomaticTestActions() {
        when(pojomaticTest.getEqualsFields()).thenReturn(testEqualsSet);
        when(pojomaticTest.getHashCodeFields()).thenReturn(testHashCodeSet);
        when(pojomaticTest.getToStringFields()).thenReturn(testToStringSet);
    }

    @Before
    public void mockPojomaticMappingsActions() {
        when(classPropertiesRetriever.retrieve(classProperties, PropertyRole.EQUALS)).thenReturn(mappingsEqualsSet);
        when(classPropertiesRetriever.retrieve(classProperties, PropertyRole.HASH_CODE)).thenReturn(mappingsHashCodeSet);
        when(classPropertiesRetriever.retrieve(classProperties, PropertyRole.TO_STRING)).thenReturn(mappingsToStringSet);
    }

    @Test
    public void testerShouldRunTestsWhenPojomaticObjectIsDefined() {
        when(pojomaticTest.getTestClass()).thenReturn(YourPojomaticObject.class);

        tester.runTests(pojomaticTest, errors);

        assertThat(errors.size(), is(0));

        verify(fieldCollectionComparer).compare(testEqualsSet, mappingsEqualsSet, "equals", errors);
        verify(fieldCollectionComparer).compare(testHashCodeSet, mappingsHashCodeSet, "hashCode", errors);
        verify(fieldCollectionComparer).compare(testToStringSet, mappingsToStringSet, "toString", errors);
    }
}

