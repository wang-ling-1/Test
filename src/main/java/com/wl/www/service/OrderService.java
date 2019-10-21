package com.wl.www.service;

import com.wl.www.dao.OrderDAO;
import com.wl.www.dto.PageEntity;

import java.io.IOException;
import java.util.Date;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();

    public PageEntity getAllOrder(String ordernumber, String orderalipaynumber, Date ordertime, String orderbuyername,
                                     String ordersellername, String ordercommodity, Integer hidden) throws ClassNotFoundException, IOException {

        PageEntity pageref = orderDAO.getAllOrder(ordernumber, orderalipaynumber, ordertime, orderbuyername,
                ordersellername, ordercommodity, hidden);
        return pageref;
    }
}
