package com.example.msdb.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DbDataSource extends AbstractRoutingDataSource {
 
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("DBContextHolder.getDb()=="+DBContextHolder.getDb());
        return DBContextHolder.getDb();
    }
 
}