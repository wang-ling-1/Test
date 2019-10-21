package com.wl.www.dubboservice;

import com.wl.www.dubboservice.dto.Order;

public interface UpdateOrder {
    public void updateByOrderNumber(Order order);
}
