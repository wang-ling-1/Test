package com.wl.www.controller;

import com.wl.www.dubboTools.DubboTools;
import com.wl.www.dubboservice.*;
import com.wl.www.dubboservice.impl.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "InitDubboServlet")
public class InitDubboServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {

        PayService payServiceImpl=new PayServiceImpl();
        InsertOrder insertOrderImpl=new InsertOrderImpl();
        UpdateOrder updateOrderImpl=new UpdateOrderImpl();
        ShowSeller showSellerImpl=new ShowSellerImpl();
        ShowOrderBuyer showOrderBuyerImpl=new ShowOrderBuyerImpl();

        DubboTools.exportService(PayService.class,payServiceImpl);
        System.out.println("支付宝支付发布");
        DubboTools.exportService(InsertOrder.class,insertOrderImpl);
        System.out.println("添加数据库数据发布");
        DubboTools.exportService(UpdateOrder.class,updateOrderImpl);
        System.out.println("更新数据库数据发布");
        DubboTools.exportService(ShowSeller.class,showSellerImpl);
        System.out.println("查询卖家数据发布");
        DubboTools.exportService(ShowOrderBuyer.class,showOrderBuyerImpl);
        System.out.println("查询买家数据发布");

    }
}
