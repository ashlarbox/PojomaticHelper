package org.ashlarbox.pojomatic.testobject;

import org.ashlarbox.pojomatic.PojomaticTester;

public class NonPojomaticObject_UT extends PojomaticTester {

    @Override
    public Class getTestClass() {
        return NonPojomaticObject.class;
    }

    public boolean usePojomatic() {
        return false;
    }


}
