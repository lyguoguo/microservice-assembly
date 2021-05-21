package com.example.msdb.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * 通常用spring boot时都是使用它的默认配置，只需要在配置文件中定义好连接属性就行了，但是现在我们需要自己来配置了。
 * spring 是支持多数据源的，多个datasource放在一个HashMap TargerDataSource 中，通过 dertermineCurrentLookupKey 获取key
 * 来决定要使用哪个数据源。
 * 因此我们的目标就很明确了，建立多个datasource放到 TargetDataSource 中，同时重写 dertermineCurrentLookupKey 方法来决定
 * 使用哪个key。
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DSContextHolder.get();
    }

}