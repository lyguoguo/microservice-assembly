package com.example.msdb.datasource;

import com.example.msdb.enums.DBTypeEnum;

public class DBContextHolder {
 
    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();
 
    public static void setDb(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }
 
    public static DBTypeEnum getDb() {
        return contextHolder.get();
    }
 
    public static void remove() {
        System.out.println("移除线程="+contextHolder.get());
        System.out.println("移除线程");
        contextHolder.remove();
    }
 
}