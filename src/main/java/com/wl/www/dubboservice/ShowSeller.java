package com.wl.www.dubboservice;

import com.wl.www.dubboservice.dto.Order;

import java.util.List;

public interface ShowSeller {
    public List<Order> showSeller(Order order,int currentPage,int pageSize);
}
