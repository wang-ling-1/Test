package com.wl.www.dubboservice.impl;

import com.wl.www.dbtools.GetsqlSession;
import com.wl.www.dubboservice.ShowSeller;
import com.wl.www.dubboservice.dto.Order;
import com.wl.www.sqlmapping.OrderMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class ShowSellerImpl implements ShowSeller {
    @Override
    public List<Order> showSeller(Order order,int currentPage,int pageSize) {
        SqlSession session = null;
        List<Order> orderList = null;
        try {
            session = GetsqlSession.getSqlSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            int currentpage=(currentPage-1)*pageSize;
            orderList = mapper.showSeller(order,currentpage, pageSize);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
