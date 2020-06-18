package com.gly.order.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ProjectName: knife4j-cloud-assembly
 * @Package: com.gly.order.domain
 * @ClassName: OrderInfo
 * @Author: lvye.guo
 * @Description:
 * @Date: 2020/6/5 16:05
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
public class OrderInfo {
    private String orderNo;
    private String orderName;
    private String orderType;
}
