package com.wl.www.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderAlipayNumberCreate {

    //订单号/平台交易号
    public static String nextAlipay() {
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String seconds = new SimpleDateFormat("HHmmss").format(new Date());
        date = date + "00001000" + getTwo() + "00" + seconds + getTwo();
        return date;
    }

    public static String getTwo() {
        Random rad = new Random();
        String result = rad.nextInt(100) + "";
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            String date=nextAlipay();
            System.out.println(date);
        }
    }

}
