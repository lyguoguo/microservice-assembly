package com.example.msdb.datasource;

import com.example.msdb.datasource.enums.DSNames;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class DSContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger(0);

    private static List<String> slaves;

    public static void setSlaves(List<String> slaves) {
        DSContextHolder.slaves = slaves;
    }

    public static void set(String dsName) {
        contextHolder.set(dsName);
    }

    public static String get() {
        return contextHolder.get();
    }

    public static void master() {
        set(DSNames.MASTER.name());
    }

    public static void slave() {
        if(slaves.size()>0){
            int index = counter.getAndIncrement() % slaves.size();
            if (counter.get() > 9999) {
                counter.set(-1);
            }
            set(slaves.get(index));
        } else {
            master();
        }
    }

}