package com.gly.test;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class MedContext {
    private ThreadLocal<Map<MedKey, String>> contextMap = new ThreadLocal();
    private static MedContext INSTANCE = new MedContext();

    public static final MedContext newInstance() {
        return INSTANCE;
    }

    private MedContext() {
    }

    public void setValue(MedContext.MedKey key, Object val) {
        Map<MedContext.MedKey, String> map = (Map)this.contextMap.get();
        if (map == null) {
            map = new HashMap();
        }

        if (null != val) {
            String valStr = null;
            if (String.class.isAssignableFrom(val.getClass())) {
                valStr = (String)val;
            } else {
                valStr = JSON.toJSONString(val);
            }

            ((Map)map).put(key, valStr);
        }

        this.contextMap.set(map);
    }

    public String getValue(MedContext.MedKey key) {
        Map<MedContext.MedKey, String> map = (Map)this.contextMap.get();
        return null == map ? null : (String)map.get(key);
    }

    public <T> T getValue(MedContext.MedKey key, Class<T> clazz) {
        Map<MedContext.MedKey, String> map = (Map)this.contextMap.get();
        if (null == map) {
            return null;
        } else {
            String valStr = (String)map.get(key);
            return StringUtils.isEmpty(valStr) ? null : JSON.parseObject(valStr, clazz);
        }
    }

    public void clearValue(MedContext.MedKey key) {
        Map<MedContext.MedKey, String> map = (Map)this.contextMap.get();
        if (null != map) {
            String valStr = (String)map.get(key);
            if (!StringUtils.isEmpty(valStr)) {
                map.put(key, null);
            }
        }

    }

    public static enum MedKey {
        USER_INFO,
        UDB_TOKEN_INFO;

        private MedKey() {
        }

        public static MedContext.MedKey getKey(String key) {
            MedContext.MedKey[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                MedContext.MedKey medKey = var1[var3];
                if (medKey.toString().equals(key)) {
                    return medKey;
                }
            }

            return null;
        }
    }
}
