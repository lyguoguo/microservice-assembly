package com.gly.druid.datasource.entity;


public class GatewayRoutes {

  private long id;
  private String routeId;
  private String routeUri;
  private long routeOrder;
  private String predicates;
  private String filters;
  private String autoRoute;
  private String healthPath;
  private long isEbl;
  private long isDel;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private String remark;


  public long getId() {
    return id;
  }

  public void setId(long id) {
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


  public long getRouteOrder() {
    return routeOrder;
  }

  public void setRouteOrder(long routeOrder) {
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


  public long getIsEbl() {
    return isEbl;
  }

  public void setIsEbl(long isEbl) {
    this.isEbl = isEbl;
  }


  public long getIsDel() {
    return isDel;
  }

  public void setIsDel(long isDel) {
    this.isDel = isDel;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
