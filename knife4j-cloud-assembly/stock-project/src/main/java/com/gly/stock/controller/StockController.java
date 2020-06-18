package com.gly.stock.controller;

import com.gly.stock.domain.StockInfo;
import com.gly.stock.response.ResultVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: knife4j-cloud-assembly
 * @Package: com.gly.stock.controller
 * @ClassName: StockController
 * @Author: lvye.guo
 * @Description:
 * @Date: 2020/6/5 16:12
 * @Version: 1.0
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @PostMapping("/getStockByOrderType")
    public ResultVo<StockInfo> getStockByOrderType(String orderType){
        StockInfo stockInfo = new StockInfo().setStock(7).setOrderName("发夹").setOrderType(orderType);
        return new ResultVo<>(stockInfo);
    }
}
