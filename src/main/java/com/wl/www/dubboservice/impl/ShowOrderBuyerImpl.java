package com.wl.www.dubboservice.impl;

import com.wl.www.dbtools.GetsqlSession;
import com.wl.www.dubboservice.ShowOrderBuyer;
import com.wl.www.dubboservice.dto.Order;
import com.wl.www.sqlmapping.OrderMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class ShowOrderBuyerImpl implements ShowOrderBuyer {
    @Override
    public List<Order> showOrderBuyer(Order order,int currentPage,int pageSize) {
        SqlSession session = null;
        List<Order> orderList = null;
        try {
            session = GetsqlSession.getSqlSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            int currentpage=(currentPage-1)*pageSize;
            orderList = mapper.showOrderBuyer(order,currentpage, pageSize);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}