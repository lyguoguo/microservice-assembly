package com.example.msdb.aspect;

import com.example.msdb.enums.DBTypeEnum;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {
    DBTypeEnum value() default DBTypeEnum.MASTER;
}