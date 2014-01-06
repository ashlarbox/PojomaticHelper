package org.ashlarbox.pojomatic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pojomatic.Pojomatic;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang.math.RandomUtils.nextInt;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Pojomatic.class)
public class PojomaticObject_UT {

    private PojomaticObject pojomaticObject;

    @Before
    public void mockStatic() {
        PowerMockito.mockStatic(Pojomatic.class);
        pojomaticObject = new TestObject();
    }

    @Test
    public void equalsShouldCallPojomaticEquals() {
        when(Pojomatic.equals(any(), any())).thenReturn(true);

        boolean pojomaticCalled = pojomaticObject.equals(this);

        assertThat(pojomaticCalled, is(true));
    }

    @Test
    public void hashCodeShouldCallPojomaticHashCode() {
        int expectedHashCode = nextInt();
        when(Pojomatic.hashCode(any())).thenReturn(expectedHashCode);

        int hashCode = pojomaticObject.hashCode();

        assertThat(hashCode, is(expectedHashCode));
    }

    @Test
    public void toStringShouldCallPojomaticToString() {
        String expectedString = randomAlphanumeric(14);
        when(Pojomatic.toString(any())).thenReturn(expectedString);

        String string = pojomaticObject.toString();

        assertThat(string, is(expectedString));
    }

    private class TestObject extends PojomaticObject {   }
}
