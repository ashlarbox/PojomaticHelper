package org.ashlarbox.pojomatic.mappings.function;

import org.ashlarbox.pojomatic.mappings.PojomaticMappings;

public class MapEqualsFieldFunction implements PojomaticMappingFunction{

    @Override
    public void mapField(String name, PojomaticMappings pojomaticMappings) {
        pojomaticMappings.addEqualsField(name);
    }

}
