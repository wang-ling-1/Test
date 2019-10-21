package com.wl.www.dubboservice.dto;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer orderId;//订单id
    private String orderNumber;//商家订单号
    private Date orderTime;//下单时间
    private Integer orderActualPayment;//实际付款
    private Integer orderPayMethod;//付款方式(1:支付宝；2:银行卡 )
    private String orderBuyerName;//付款方:买家用户名
    private String orderSellerName;//收款方:卖家用户名
    private Integer orderState;//订单状态（0:待支付；1:直接下订单支付；2:申请退款；3:已退款；4:下订单再支付)
    private List<Commodity> commodityList;

    public Order() {
    }

    public Order(Integer orderId, String orderNumber, Date orderTime, Integer orderActualPayment, Integer orderPayMethod, String orderBuyerName, String orderSellerName, Integer orderState, List<Commodity> commodityList) {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.orderTime = orderTime;
        this.orderActualPayment = orderActualPayment;
        this.orderPayMethod = orderPayMethod;
        this.orderBuyerName = orderBuyerName;
        this.orderSellerName = orderSellerName;
        this.orderState = orderState;
        this.commodityList = commodityList;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void SetOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getOrderActualPayment() {
        return orderActualPayment;
    }

    public void setOrderActualPayment(Integer orderActualPayment) {
        this.orderActualPayment = orderActualPayment;
    }

    public Integer getOrderPayMethod() {
        return orderPayMethod;
    }

    public void setOrderPayMethod(Integer orderPayMethod) {
        this.orderPayMethod = orderPayMethod;
    }

    public String getOrderBuyerName() {
        return orderBuyerName;
    }

    public void setOrderBuyerName(String orderBuyerName) {
        this.orderBuyerName = orderBuyerName;
    }

    public String getOrderSellerName() {
        return orderSellerName;
    }

    public void setOrderSellerName(String orderSellerName) {
        this.orderSellerName = orderSellerName;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public List<Commodity> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<Commodity> commodityList) {
        this.commodityList = commodityList;
    }
}
