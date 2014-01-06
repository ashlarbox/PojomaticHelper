package org.ashlarbox.pojomatic;

import org.pojomatic.Pojomatic;

public abstract class PojomaticObject {

    @Override
    public boolean equals(Object o) {
        return Pojomatic.equals(this, o);
    }

    @Override
    public int hashCode() {
        return Pojomatic.hashCode(this);
    }

    @Override
    public String toString() {
        return Pojomatic.toString(this);
    }

}
