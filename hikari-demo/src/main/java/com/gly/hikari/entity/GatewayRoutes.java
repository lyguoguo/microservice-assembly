package com.gly.hikari.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * (GatewayRoutes)实体类
 *
 * @author lvye.guo
 * @since 2020-05-28 09:43:30
 */
public class GatewayRoutes implements Serializable {
    private static final long serialVersionUID = -42723133506961289L;
    
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

    /** 每页大小.  */
    private Integer pageSize;

    /** 当前页. */
    private Integer pageNum;

    /** 自定义路由*/
    private String autoRoute;

    /**健康检查路径*/
    private String healthPath;

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

    public Boolean getIsEbl() {
        return isEbl;
    }

    public void setIsEbl(Boolean isEbl) {
        this.isEbl = isEbl;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
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


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
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

}