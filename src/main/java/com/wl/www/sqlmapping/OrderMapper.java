package com.wl.www.sqlmapping;

import com.wl.www.dubboservice.dto.Commodity;
import com.wl.www.dubboservice.dto.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {

    public void insertOrder(Order order);

    public void insertCommodity(List<Commodity> commodityList);

    public Integer getAutoNetId();

    public void updateOrderState(Order order);

    public List<Order> showOrderBuyer(Order order, int currentPage, int pageSize);

    public List<Order> showSeller(Order order, int currentPage, int pageSize);

    public List<Order> getOrder(Map map);

    public int getOrderCount(Map map);

}
