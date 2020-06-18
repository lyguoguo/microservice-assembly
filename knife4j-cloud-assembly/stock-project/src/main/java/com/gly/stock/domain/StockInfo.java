package com.gly.stock.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ProjectName: knife4j-cloud-assembly
 * @Package: com.gly.stock.domain
 * @ClassName: StockInfo
 * @Author: lvye.guo
 * @Description:
 * @Date: 2020/6/5 16:14
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
public class StockInfo {
    private String orderName;
    private String orderType;
    private Integer stock;
}
