package org.ashlarbox.pojomatic;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.pojomatic.NoPojomaticPropertiesException;
import org.pojomatic.Pojomatic;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static org.apache.commons.collections.CollectionUtils.isEmpty;
import static org.apache.commons.collections.CollectionUtils.isNotEmpty;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.apache.commons.lang3.StringUtils.join;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Pojomatic.class)
public abstract class PojomaticTester implements PojomaticTest {

    private final PojomaticObjectTester pojomaticObjectTester = new PojomaticObjectTester();

    private Object pojomaticObject;

    private List<String> errors;

    private final int expectedHashCode = nextInt(1, 12);
    private final String expectedToString = randomAlphanumeric(14);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void mockStatic() {
        PowerMockito.mockStatic(Pojomatic.class);
        when(Pojomatic.equals(any(), any())).thenReturn(true);
        when(Pojomatic.hashCode(any())).thenReturn(expectedHashCode);
        when(Pojomatic.toString(any())).thenReturn(expectedToString);
    }

    @Before
    public void initializeObject() throws IllegalAccessException, InstantiationException {
        Class clazz = getTestClass();
        pojomaticObject = clazz.newInstance();
    }

    @Before
    public void initializeErrors() {
        errors = newArrayList();
    }

    @Test
    @Override
    public final void runPojomaticTests() {
        if (usePojomatic()) {
            pojomaticObjectTester.runTests(this, errors);
            checkErrorsForFailure(errors);
        }
    }

    @Test
    public final void testerShouldNotBeAbleToBuildPojomatic() {
        if (!usePojomatic()) {
            expectedException.expect(NoPojomaticPropertiesException.class);
            pojomaticObjectTester.runTests(this, errors);
        }
    }

    @Test
    public void equalsShouldCallPojomaticEqualsWhenDefined() {
        if (isNotEmpty(getEqualsFields())) {
            when(Pojomatic.equals(any(), any())).thenReturn(true);
            boolean pojomaticCalled = pojomaticObject.equals(this);
            assertThat(pojomaticCalled, is(true));
        }
    }

    @Test
    public void equalsShouldNotCallPojomaticEqualsWhenNotDefined() {
        if (isEmpty(getEqualsFields())) {
            boolean pojomaticCalled = pojomaticObject.equals(this);
            assertThat(pojomaticCalled, is(false));
        }
    }

    @Test
    public void hashCodeShouldCallPojomaticHashCodeWhenDefined() {
        if (isNotEmpty(getHashCodeFields())) {
            int hashCode = pojomaticObject.hashCode();
            assertThat(hashCode, is(expectedHashCode));
        }
    }

    @Test
    public void hashCodeShouldNotCallPojomaticHashCodeWhenNotDefined() {
        if (isEmpty(getHashCodeFields())) {
            int hashCode = pojomaticObject.hashCode();
            assertThat(hashCode, is(not(expectedHashCode)));
        }
    }

    @Test
    public void toStringShouldCallPojomaticToStringWhenDefined() {
        if (isNotEmpty(getToStringFields())) {
            String string = pojomaticObject.toString();
            assertThat(string, is(expectedToString));
        }
    }

    @Test
    public void toStringShouldNotCallPojomaticToStringWhenNotDefined() {
        if (isEmpty(getToStringFields())) {
            String string = pojomaticObject.toString();
            assertThat(string, is(not(expectedToString)));
        }
    }

    private void checkErrorsForFailure(List<String> errors) {
        if (isNotEmpty(errors)) {
            fail(join(errors, "\n"));
        }
    }

    public boolean usePojomatic() {
        return true;
    }

    @Override
    public Set<String> getEqualsFields() {
        return newHashSet();
    }

    @Override
    public Set<String> getHashCodeFields() {
        return newHashSet();
    }

    @Override
    public Set<String> getToStringFields() {
        return newHashSet();
    }

}
