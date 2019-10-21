/*
package com.wl.www.controller;

import com.alibaba.fastjson.JSONObject;
import com.wl.www.dto.ResponseContent;
import com.wl.www.dubboservice.PayService;
import com.wl.www.dubboservice.impl.PayServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AliPayController extends HttpServlet {

    PayService payService=new PayServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ResponseContent content=new ResponseContent();
        String jsonString = null;
        String showpay=null;
        try {
            showpay=payService.payProcess;
            if (showpay != null) {
                content.setReturnValue(showpay);
            } else {
                content.setReturnValue(null);
            }
            content.setCode("200");
        } catch (Exception e) {
            e.printStackTrace();
            List list = new ArrayList();
            list.add(e.getMessage());
            content.setMessageList(list);
            content.setCode("119");
        }
        jsonString = JSONObject.toJSONString(content);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(jsonString);
        out.flush();
        out.close();
    }
}
*/
