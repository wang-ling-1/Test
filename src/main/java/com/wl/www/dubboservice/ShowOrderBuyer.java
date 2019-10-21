package com.wl.www.dubboservice;

import com.wl.www.dubboservice.dto.Order;

import java.util.List;

public interface ShowOrderBuyer {

    public List<Order> showOrderBuyer(Order order,int currentPage,int pageSize);
}
