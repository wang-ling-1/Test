package com.wl.www.dao;

import com.wl.www.dbtools.GetsqlSession;
import com.wl.www.dto.PageEntity;
import com.wl.www.dubboservice.dto.Order;
import com.wl.www.sqlmapping.OrderMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OrderDAO {
    public PageEntity getAllOrder(String ordernumber, String orderalipaynumber, Date ordertime, String orderbuyername,
                                     String ordersellername, String ordercommodity, Integer hidden) throws ClassNotFoundException, IOException {
        PageEntity pageEntity = new PageEntity();
        long pageSize = 9;
        long pageNo = ((hidden - 1) * pageSize);
        SqlSession session = GetsqlSession.getSqlSession();
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Map map = new HashMap();
        map.put("ordernumber", ordernumber);
        map.put("orderalipaynumber", orderalipaynumber);
        map.put("ordertime", ordertime);
        map.put("orderbuyername", orderbuyername);
        map.put("ordersellername", ordersellername);
        map.put("ordercommodity", ordercommodity);
        map.put("pageNo",pageNo);
        map.put("pageSize",pageSize);
        List<Order> dataList = mapper.getOrder(map);
        int queryDataCount = mapper.getOrderCount(map);
        pageEntity.setPageData(dataList);
        int pageCount = 1;
        if (queryDataCount % pageSize != 0) {
            pageCount = (int) (queryDataCount / pageSize + 1);
        } else {
            pageCount = (int) (queryDataCount / pageSize);
        }
        Map gotoPageMap = pageEntity.getGotoPage();

        gotoPageMap.put("first", 1);
        gotoPageMap.put("last", pageCount);
        if (hidden <= 1) {
            gotoPageMap.put("prev", 1);
        } else {
            gotoPageMap.put("prev", hidden - 1);
        }
        if (hidden >= pageCount) {
            gotoPageMap.put("next", pageCount);
        } else {
            gotoPageMap.put("next", hidden + 1);
        }

        gotoPageMap.put("getAllPageCount", queryDataCount);
        gotoPageMap.put("getCurrentPageCount", dataList.size());

        return pageEntity;
    }
}
