package com.gly.redis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.data.redis.cache.RedisCache;

public class RedisUtil {

    private static final BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),10000,0.01);

    /**
     * 缓存穿透问题
     * 在数据库中未查询到数据，未存入缓存，则下次查询同样的数据时，还会查库
     * @param id
     * @return
     */
    public Object getObjectById(Integer id){
        Object cacheValue = cache.get(id);
        if(null != cacheValue){
            return cacheValue;
        }
        Object storageValue = storage.get(id);
        if(null != storageValue){
            cache.set(id,storageValue);
        }
        return storageValue;
    }

    /**
     * 缓存空对象
     * 此方法存在漏洞，不经判断就直接将null存入缓存中，如果恶意制造不存在的id，那么缓存中的键值就会很多，
     * 恶意攻击时很可能被打爆，因此需要设置较短的过期时间
     * @param id
     * @return
     */
    public Object getObjectById(Integer id){
        Object cacheValue = cache.get(id);
        if(null != cacheValue){
            return cacheValue;
        }
        Object storageValue = storage.get(id);
        cache.set(id,storageValue);
        //若数据为空，则必须设置过期时间，否则有被攻击的风险
        if(null == storageValue){
            cache.expire(id,60*5);
        }
        return storageValue;
    }

    /**
     * 防止缓存穿透：布隆过滤器
     * @param id
     * @return
     */
    public Object getObjectByBoolean(Integer id){
        //布隆过滤器校验非法ID
        if(!bloomFilter.mightContain(id)){
            return null;
        }
        Object cacheValue = cache.get(id);
        if(null != cacheValue){
            return cacheValue;
        }else{
            Object storageValue = storage.get(id);
            cache.set(id,storageValue);
            return storageValue;
        }
    }
}
