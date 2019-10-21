package com.wl.www.dubboservice.dto;

import java.util.Date;

public class Commodity {

    private Integer id;//id
    private Integer commodityId;//商品id
    private String commodityName;//商品名称
    private Integer commodityCount;//商品数量
    private Integer orderId;//订单id
    private Integer commodityState;//商品状态（0:待支付；1:直接下订单支付；2:申请退款；3:已退款；)

    public Commodity() {
    }

    public Commodity(Integer id, Integer commodityId, String commodityName, Integer commodityCount, Integer orderId, Integer commodityState) {
        this.id = id;
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.commodityCount = commodityCount;
        this.orderId = orderId;
        this.commodityState = commodityState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Integer getCommodityCount() {
        return commodityCount;
    }

    public void setCommodityCount(Integer commodityCount) {
        this.commodityCount = commodityCount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCommodityState() {
        return commodityState;
    }

    public void SetCommodityState(Integer commodityState) {
        this.commodityState = commodityState;
    }
}
