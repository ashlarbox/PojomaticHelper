package org.ashlarbox.pojomatic.mappings;

import org.ashlarbox.pojomatic.PojomaticObject;
import org.ashlarbox.pojomatic.mappings.mapper.PojomaticMapper;

import java.lang.reflect.Field;

public class PojomaticMappingsBuilder {

    private PojomaticMapper pojomaticMapper = new PojomaticMapper();
    private PojomaticMappingFieldsFinder pojomaticMappingFieldsFinder = new PojomaticMappingFieldsFinder();

    public PojomaticMappings build(PojomaticObject pojomaticObject) {
        PojomaticMappings pojomaticMappings = new PojomaticMappings();

        pojomaticMapper.setDefaultPolicy(pojomaticObject);

        for (Field field : pojomaticMappingFieldsFinder.find(pojomaticObject)) {
            pojomaticMapper.mapField(field, pojomaticMappings);
        }

        return pojomaticMappings;
    }

}
