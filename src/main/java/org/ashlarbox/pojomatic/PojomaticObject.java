package org.ashlarbox.pojomatic;

import org.pojomatic.Pojomatic;

public class PojomaticObject {

    @Override
    public final boolean equals(Object o) {
        return Pojomatic.equals(this, o);
    }

    @Override
    public final int hashCode() {
        return Pojomatic.hashCode(this);
    }

    @Override
    public final String toString() {
        return Pojomatic.toString(this);
    }

}
