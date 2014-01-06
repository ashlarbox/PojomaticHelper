package org.ashlarbox.pojomatic.mappings;

import org.ashlarbox.pojomatic.PojomaticObject;
import org.ashlarbox.pojomatic.mappings.mapper.PojomaticMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Field;

import static com.google.common.collect.Lists.newArrayList;
import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PojomaticMappingsBuilder_UT {

    @Mock
    private PojomaticMapper pojomaticMapper;

    @Mock
    private PojomaticMappingFieldsFinder pojomaticMappingFieldsFinder;

    @InjectMocks
    private final PojomaticMappingsBuilder pojomaticMappingsBuilder = new PojomaticMappingsBuilder();

    private String testField = randomAlphanumeric(12);

    private final PojomaticObject pojomaticObject = mock(PojomaticObject.class);
    private Field expectedField;

    @Before
    public void initialize() throws NoSuchFieldException {
        expectedField = this.getClass().getDeclaredField("testField");
        when(pojomaticMappingFieldsFinder.find(pojomaticObject)).thenReturn(newArrayList(expectedField));
    }

    @Test
    public void builderShouldSetDefaultPolicyInMapper() {
        pojomaticMappingsBuilder.build(pojomaticObject);

        verify(pojomaticMapper).setDefaultPolicy(pojomaticObject);
    }

    @Test
    public void buildShouldMapExpectedField() {
        PojomaticMappings pojomaticMappings = pojomaticMappingsBuilder.build(pojomaticObject);

        verify(pojomaticMapper).mapField(expectedField, pojomaticMappings);

    }
}
