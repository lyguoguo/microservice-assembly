package com.gly.redis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BooleanFilterTest {
    private static final BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),10000,0.01);

    /**
     * 初始化10000个合法ID并加入到过滤器
     */
    private static void initLegalIdsBloomFilter(){
        for(int legalId=0;legalId<10000;legalId++){
            bloomFilter.put(legalId);
        }
    }

    /**
     * ID是否合法有效，即校验ID是否在过滤器中
     * @param id
     * @return
     */
    private static boolean validateIdInBloomFilter(Integer id){
        return bloomFilter.mightContain(id);
    }
}
