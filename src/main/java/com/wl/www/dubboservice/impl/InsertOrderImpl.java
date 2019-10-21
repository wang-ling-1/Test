package com.wl.www.dubboservice.impl;

import com.wl.www.dbtools.GetsqlSession;
import com.wl.www.dto.OrderAlipayNumberCreate;
import com.wl.www.dto.OrderNumberCreate;
import com.wl.www.dubboservice.InsertOrder;
import com.wl.www.dubboservice.dto.Commodity;
import com.wl.www.dubboservice.dto.Order;
import com.wl.www.sqlmapping.OrderMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class InsertOrderImpl implements InsertOrder {
    @Override
    public void insertOrder(Order order) {
        try {
            SqlSession session = GetsqlSession.getSqlSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);

            Integer orderIdParam=mapper.getAutoNetId();

            order.setOrderNumber(OrderNumberCreate.nextId());
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date orderTime=format.parse(date);
            order.setOrderTime(orderTime);
            mapper.insertOrder(order);

            List<Commodity> commodityListParam=order.getCommodityList();
            for (int i = 0; i < commodityListParam.size(); i++) {
                Commodity commodity=commodityListParam.get(i);
                commodity.setOrderId(orderIdParam);
            }
            mapper.insertCommodity(commodityListParam);

            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
