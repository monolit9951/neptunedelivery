package com.gmail.merikbest2015.ecommerce.configuration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.InstantType;


public class UtcInstantType extends InstantType {

    public static final String CANONICAL_NAME = "com.gmail.merikbest2015.ecommerce.configuration.UtcInstantType";


    @Override
    public Object get( ResultSet rs, String name, SharedSessionContractImplementor session )
            throws HibernateException, SQLException {
        return rs.getTimestamp( name ).toInstant().atZone( ZoneId.of( "UTC" ) );
    }
}