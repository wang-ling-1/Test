package com.wl.www.controller;

import com.alibaba.fastjson.JSONObject;
import com.wl.www.dto.PageEntity;
import com.wl.www.dto.ResponseContent;
import com.wl.www.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "GetOrderPage")
public class GetOrderPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseContent rc = new ResponseContent();
        OrderService service = new OrderService();
        String jsonString = null;
        try {
            String ordernumber = request.getParameter("ordernumber");
            String orderalipaynumber = request.getParameter("orderalipaynumber");
            String ordertimeParam = request.getParameter("ordertime");
            String orderbuyername = request.getParameter("orderbuyername");
            String ordersellername = request.getParameter("ordersellername");
            String ordercommodity = request.getParameter("ordercommodity");
            String hiddenInt = request.getParameter("hidden");

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date ordertime = null;
            if (ordertimeParam != null && !"".equals(ordertimeParam)) {
                ordertime = format.parse(ordertimeParam);
            }
            Integer hidden = 1;
            if (hiddenInt != null && !"".equals(hiddenInt)) {
                hidden = Integer.parseInt(hiddenInt);
            }

            PageEntity pageEntity = service.getAllOrder(ordernumber, orderalipaynumber, ordertime, orderbuyername,
                    ordersellername, ordercommodity, hidden);
            rc.setCode("0");
            rc.setReturnValue(pageEntity);
        } catch (Exception e) {
            e.printStackTrace();
            rc.setCode("1");
            rc.getMessageList().add(e.getMessage());
        } finally {
            jsonString = JSONObject.toJSONStringWithDateFormat(rc, "yyyy-MM-dd");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print(jsonString);
            out.flush();
            out.close();
        }


    }

}
