package com.filmstock.entity.time;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.spi.JdbcRecommendedSqlTypeMappingContext;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

import java.sql.Types;

public class TimeTypeDescriptor extends AbstractTypeDescriptor<Time> {
    public static final TimeTypeDescriptor INSTANCE =
            new TimeTypeDescriptor();

    public TimeTypeDescriptor() { //todo private
        super(Time.class);
    }

    @Override
    public String toString(Time value) {
        return value.toString();
    }

    @Override
    public Time fromString(String string) {
        return new Time(string);
    }

    @Override
    public <X> X unwrap(Time value, Class<X> type, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (Time.class.isAssignableFrom(type)) {
            return (X) value;
        }
        if (String.class.isAssignableFrom(type)) {
            return (X) toString(value);
        }
        throw unknownUnwrap(type);
    }

    @Override
    public <X> Time wrap(X value, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (String.class.isInstance(value)) {
            return fromString((String) value);
        }
        if (Time.class.isInstance(value)) {
            return (Time) value;
        }
        throw unknownWrap(value.getClass());
    }

    @Override
    public SqlTypeDescriptor getJdbcRecommendedSqlType(JdbcRecommendedSqlTypeMappingContext context) {
        return context.getTypeConfiguration().getSqlTypeDescriptorRegistry().getDescriptor( Types.VARCHAR );
    }
}
