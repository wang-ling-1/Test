package com.wl.www.dubboservice.impl;

import com.wl.www.dbtools.GetsqlSession;
import com.wl.www.dubboservice.UpdateOrder;
import com.wl.www.dubboservice.dto.Order;
import com.wl.www.sqlmapping.OrderMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class UpdateOrderImpl implements UpdateOrder {
    public void updateByOrderNumber(Order order) {
        try {
            SqlSession session = GetsqlSession.getSqlSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            if (order.getOrderState()==4){
                order.setOrderState(1);
            }
            mapper.updateOrderState(order);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
