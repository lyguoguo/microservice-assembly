package com.example.msdb.datasource.aspect;

import com.example.msdb.datasource.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 默认情况下，所有的查询都走从库，插入/修改/删除走主库。我们通过方法名来区分操作类型（CRUD）
 *
 * ****匹配多个切面的话 设计时候解决好了！！！！！*****
 * @author x3626
 *
 */
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("@annotation(com.example.msdb.datasource.annotation.Slave)" +
            "|| execution(* com.example.msdb.db.service.*.select*(..)) " +
            "|| execution(* com.example.msdb.db.service..*.find*(..))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.example.msdb.datasource.annotation.Master) " +
            "|| execution(* com.example.msdb.db.service..*.save*(..)) " +
            "|| execution(* com.example.msdb.db.service..*.insert*(..)) " +
            "|| execution(* com.example.msdb.db.service..*.add*(..)) " +
            "|| execution(* com.example.msdb.db.service..*.update*(..)) " +
            "|| execution(* com.example.msdb.db.service..*.edit*(..)) " +
            "|| execution(* com.example.msdb.db.service..*.delete*(..)) " +
            "|| execution(* com.example.msdb.db.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        try{
            DBContextHolder.slave();
        }finally {
            //清楚DbType一方面为了避免内存泄漏，更重要的是避免对后续在本线程上执行的操作产生影响
            DBContextHolder.clearDbType();
            System.out.println("清除threadLocal");
        }
    }

    @Before("writePointcut()")
    public void write() {
        try{
            DBContextHolder.master();
        }finally {
            //清楚DbType一方面为了避免内存泄漏，更重要的是避免对后续在本线程上执行的操作产生影响
            DBContextHolder.clearDbType();
            System.out.println("清除threadLocal");
        }
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.cjs.example.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}
