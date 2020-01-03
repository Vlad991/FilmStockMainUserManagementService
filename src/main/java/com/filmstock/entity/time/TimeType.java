package com.filmstock.entity.time;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

public class TimeType
        extends AbstractSingleColumnStandardBasicType<Time>
        implements DiscriminatorType<Time> {

    public static final TimeType INSTANCE = new TimeType();

    public TimeType() {
        super(VarcharTypeDescriptor.INSTANCE, TimeTypeDescriptor.INSTANCE);
    }

    @Override
    public String getName() {
        return "time";
    }

    @Override
    public Time stringToObject(String string) throws Exception {
        return fromString(string);
    }

    @Override
    public String objectToSQLString(Time value, Dialect dlct) throws Exception {
        return toString(value);
    }
}
