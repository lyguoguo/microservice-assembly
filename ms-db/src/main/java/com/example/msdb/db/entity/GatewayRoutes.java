package com.example.msdb.db.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table gateway_routes
 */
public class GatewayRoutes implements Serializable {

    private static final long serialVersionUID = 4640197147374652442L;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gateway_routes.id
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   路由id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gateway_routes.route_id
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    private String routeId;

    /**
     * Database Column Remarks:
     *   转发目标uri
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gateway_routes.route_uri
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    private String routeUri;

    /**
     * Database Column Remarks:
     *   路由执行顺序
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gateway_routes.route_order
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    private Integer routeOrder;

    /**
     * Database Column Remarks:
     *   自定义路由
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gateway_routes.auto_route
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    private String autoRoute;

    /**
     * Database Column Remarks:
     *   健康检查路径
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gateway_routes.health_path
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    private String healthPath;

    /**
     * Database Column Remarks:
     *   是否启用
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gateway_routes.is_ebl
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    private Boolean isEbl;

    /**
     * Database Column Remarks:
     *   是否删除
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gateway_routes.is_del
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    private Boolean isDel;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gateway_routes.create_time
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   修改时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gateway_routes.update_time
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   备注
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gateway_routes.remark
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    private String remark;

    /**
     * Database Column Remarks:
     *   断言字符串集合，字符串结构：[{
     *                   "name":"Path",
     *                   "args":{
     *                      "pattern" : "/zy/**"
     *                   }
     *                 }]
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gateway_routes.predicates
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    private String predicates;

    /**
     * Database Column Remarks:
     *   过滤器字符串集合，字符串结构：{
     *                 	"name":"StripPrefix",
     *                 	 "args":{
     *                 	 	"_genkey_0":"1"
     *                 	 }
     *                 }
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gateway_routes.filters
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    private String filters;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gateway_routes.id
     *
     * @return the value of gateway_routes.id
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gateway_routes.id
     *
     * @param id the value for gateway_routes.id
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gateway_routes.route_id
     *
     * @return the value of gateway_routes.route_id
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gateway_routes.route_id
     *
     * @param routeId the value for gateway_routes.route_id
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public void setRouteId(String routeId) {
        this.routeId = routeId == null ? null : routeId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gateway_routes.route_uri
     *
     * @return the value of gateway_routes.route_uri
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public String getRouteUri() {
        return routeUri;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gateway_routes.route_uri
     *
     * @param routeUri the value for gateway_routes.route_uri
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public void setRouteUri(String routeUri) {
        this.routeUri = routeUri == null ? null : routeUri.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gateway_routes.route_order
     *
     * @return the value of gateway_routes.route_order
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public Integer getRouteOrder() {
        return routeOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gateway_routes.route_order
     *
     * @param routeOrder the value for gateway_routes.route_order
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public void setRouteOrder(Integer routeOrder) {
        this.routeOrder = routeOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gateway_routes.auto_route
     *
     * @return the value of gateway_routes.auto_route
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public String getAutoRoute() {
        return autoRoute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gateway_routes.auto_route
     *
     * @param autoRoute the value for gateway_routes.auto_route
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public void setAutoRoute(String autoRoute) {
        this.autoRoute = autoRoute == null ? null : autoRoute.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gateway_routes.health_path
     *
     * @return the value of gateway_routes.health_path
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public String getHealthPath() {
        return healthPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gateway_routes.health_path
     *
     * @param healthPath the value for gateway_routes.health_path
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public void setHealthPath(String healthPath) {
        this.healthPath = healthPath == null ? null : healthPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gateway_routes.is_ebl
     *
     * @return the value of gateway_routes.is_ebl
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public Boolean getIsEbl() {
        return isEbl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gateway_routes.is_ebl
     *
     * @param isEbl the value for gateway_routes.is_ebl
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public void setIsEbl(Boolean isEbl) {
        this.isEbl = isEbl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gateway_routes.is_del
     *
     * @return the value of gateway_routes.is_del
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gateway_routes.is_del
     *
     * @param isDel the value for gateway_routes.is_del
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gateway_routes.create_time
     *
     * @return the value of gateway_routes.create_time
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gateway_routes.create_time
     *
     * @param createTime the value for gateway_routes.create_time
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gateway_routes.update_time
     *
     * @return the value of gateway_routes.update_time
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gateway_routes.update_time
     *
     * @param updateTime the value for gateway_routes.update_time
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gateway_routes.remark
     *
     * @return the value of gateway_routes.remark
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gateway_routes.remark
     *
     * @param remark the value for gateway_routes.remark
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gateway_routes.predicates
     *
     * @return the value of gateway_routes.predicates
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public String getPredicates() {
        return predicates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gateway_routes.predicates
     *
     * @param predicates the value for gateway_routes.predicates
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public void setPredicates(String predicates) {
        this.predicates = predicates == null ? null : predicates.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gateway_routes.filters
     *
     * @return the value of gateway_routes.filters
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public String getFilters() {
        return filters;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gateway_routes.filters
     *
     * @param filters the value for gateway_routes.filters
     *
     * @mbg.generated Thu May 20 17:18:30 CST 2021
     */
    public void setFilters(String filters) {
        this.filters = filters == null ? null : filters.trim();
    }
}