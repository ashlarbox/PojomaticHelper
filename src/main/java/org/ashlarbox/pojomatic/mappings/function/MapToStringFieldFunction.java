package org.ashlarbox.pojomatic.mappings.function;

import org.ashlarbox.pojomatic.mappings.PojomaticMappings;

public class MapToStringFieldFunction implements PojomaticMappingFunction{

    @Override
    public void mapField(String name, PojomaticMappings pojomaticMappings) {
        pojomaticMappings.addToStringField(name);
    }

}
