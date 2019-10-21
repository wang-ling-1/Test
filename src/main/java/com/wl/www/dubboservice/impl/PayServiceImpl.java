package com.wl.www.dubboservice.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.wl.www.config.AlipayConfig;
import com.wl.www.dubboservice.InsertOrder;
import com.wl.www.dubboservice.PayService;
import com.wl.www.dubboservice.UpdateOrder;
import com.wl.www.dubboservice.dto.Commodity;
import com.wl.www.dubboservice.dto.Order;

import java.util.List;


public class PayServiceImpl implements PayService {

    private Order order = null;
    private List<Commodity> commodityList = null;
    private String getOrderCommodity = null;

    public String payProcess(Order orderParameter) {
        String payPage = null;
        order = orderParameter;
        commodityList = orderParameter.getCommodityList();
        if (commodityList.size() == 1) {
            Commodity commodity = commodityList.get(0);
            getOrderCommodity = commodity.getCommodityName();
        }else if(commodityList.size() > 1){
            Commodity commodity = commodityList.get(0);
            getOrderCommodity = commodity.getCommodityName();
            getOrderCommodity+="等多件";
        }

        if (orderParameter.getOrderState() == 0) {//下订单待支付
            InsertOrder insertOrder = new InsertOrderImpl();
            insertOrder.insertOrder(orderParameter);
        }
        if (orderParameter.getOrderState() == 1) {//直接支付下订单
            try {
                payPage = createAliForm();
                InsertOrder insertOrder = new InsertOrderImpl();
                insertOrder.insertOrder(orderParameter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (orderParameter.getOrderState() == 4) {//下订单再支付
            try {
                payPage = createAliForm();
                UpdateOrder updateOrder = new UpdateOrderImpl();
                updateOrder.updateByOrderNumber(orderParameter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (orderParameter.getOrderState() == 2) {//申请退款
            UpdateOrder updateOrder = new UpdateOrderImpl();
            updateOrder.updateByOrderNumber(orderParameter);
        }

        if (orderParameter.getOrderState() == 3) {//退款
            //退款方法
            UpdateOrder updateOrder = new UpdateOrderImpl();
            updateOrder.updateByOrderNumber(orderParameter);
        }
        return payPage;
    }

    public String createAliForm() throws Exception {
        //获取初始化的AlipayClient对象
        AlipayClient alipayClient = new DefaultAlipayClient(
                AlipayConfig.gatewayUrl,
                AlipayConfig.app_id,
                AlipayConfig.merchant_private_key,
                "json",
                AlipayConfig.charset,
                AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type
        );
        //设置请求参数
        AlipayTradePagePayRequest payRequest = new AlipayTradePagePayRequest();
        payRequest.setReturnUrl(AlipayConfig.return_url);
        payRequest.setNotifyUrl(AlipayConfig.notify_url);

        payRequest.setBizContent("{\"out_trade_no\":\"" + order.getOrderNumber() + "\","
                + "\"total_amount\":\"" + order.getOrderActualPayment() + "\","
                + "\"subject\":\"" + getOrderCommodity + "\","
                + "\"body\":\"" + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //System.out.println(alipayClient.pageExecute(payRequest).getBody());
        return alipayClient.pageExecute(payRequest).getBody();
    }
}
