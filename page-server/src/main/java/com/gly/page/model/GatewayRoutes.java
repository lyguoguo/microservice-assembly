package com.gly.page.model;

import java.io.Serializable;
import java.util.Date;

/**
 * gateway_routes
 * @author 
 */
public class GatewayRoutes implements Serializable {
    private Long id;

    /**
     * 路由id
     */
    private String routeId;

    /**
     * 转发目标uri
     */
    private String routeUri;

    /**
     * 路由执行顺序
     */
    private Integer routeOrder;

    /**
     * 断言字符串集合，字符串结构：[{
                "name":"Path",
                "args":{
                   "pattern" : "/zy/**"
                }
              }]
     */
    private String predicates;

    /**
     * 过滤器字符串集合，字符串结构：{
              	"name":"StripPrefix",
              	 "args":{
              	 	"_genkey_0":"1"
              	 }
              }
     */
    private String filters;

    /**
     * 自定义路由
     */
    private String autoRoute;

    /**
     * 健康检查路径
     */
    private String healthPath;

    /**
     * 是否启用
     */
    private Boolean isEbl;

    /**
     * 是否删除
     */
    private Boolean isDel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getRouteUri() {
        return routeUri;
    }

    public void setRouteUri(String routeUri) {
        this.routeUri = routeUri;
    }

    public Integer getRouteOrder() {
        return routeOrder;
    }

    public void setRouteOrder(Integer routeOrder) {
        this.routeOrder = routeOrder;
    }

    public String getPredicates() {
        return predicates;
    }

    public void setPredicates(String predicates) {
        this.predicates = predicates;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getAutoRoute() {
        return autoRoute;
    }

    public void setAutoRoute(String autoRoute) {
        this.autoRoute = autoRoute;
    }

    public String getHealthPath() {
        return healthPath;
    }

    public void setHealthPath(String healthPath) {
        this.healthPath = healthPath;
    }

    public Boolean getEbl() {
        return isEbl;
    }

    public void setEbl(Boolean ebl) {
        isEbl = ebl;
    }

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "GatewayRoutes{" +
                "id=" + id +
                ", routeId='" + routeId + '\'' +
                ", routeUri='" + routeUri + '\'' +
                ", routeOrder=" + routeOrder +
                ", predicates='" + predicates + '\'' +
                ", filters='" + filters + '\'' +
                ", autoRoute='" + autoRoute + '\'' +
                ", healthPath='" + healthPath + '\'' +
                ", isEbl=" + isEbl +
                ", isDel=" + isDel +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}