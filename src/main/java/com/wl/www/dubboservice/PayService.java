package com.wl.www.dubboservice;

import com.wl.www.dubboservice.dto.Order;

public interface PayService {
    public String payProcess(Order orderParameter);
}
