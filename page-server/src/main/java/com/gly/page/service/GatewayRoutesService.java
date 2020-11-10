package com.gly.page.service;

import com.github.pagehelper.PageInfo;
import com.gly.page.model.GatewayRoutes;

import java.util.List;

public interface GatewayRoutesService {
    PageInfo<GatewayRoutes> pageList(int page,int size);
}
