package com.wl.www.config;


public class AlipayConfig {
    int a = 1000;
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016100100637960";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCf1Khyu6dfvSJJHCbM5Z4PbhNZ/e/M9ZhWnPdj3yEs/bY96SI6S+YbDSBmUgR3QQorryiE3f+wNYGsHjEvp+9Ry7aIdf0lEe0caHJ6gf7YuIKEmflldLErXfSIov1FK/X0ZILEIILUEUJ+hmwx0mdRLpqifY+Umxagcj9G9RXcBLnBjs/iCKBUQovIOdOIGBwy5h2aMzzF2fnBukq3ZunG2vcz8VsLatF+6XCHpQ6HL0X7mhHYRqyeXudI5LOCkMKTQdIqmQmP+o/fQdGRxqWoQhAhchlf8UX02rzvUFWiF5TYxgfT3olPkHoFkBF+ek9LXKw8xZvthsJNZtvFM7jHAgMBAAECggEBAI4yIlNBBF225QPqWdK9Dmxn4CuWMnxEm+2i5K4j214tsq9N9LeswuGaQhMGMRbv9F59DS14XHymfeFlUxk07UP2W0T4w+jxE+TMP90iPlsNfIEAg9NxiBYvFtlhOLcLr1xo97YJvptxZ5kteqCwsl6VednKn6z0daL1QbqdXX9KAk/dBFlFZu80wiJYDs4I7H3ZaRkhFOY5Ffmhoq8vy9mie90mZcW2B3bAQeK/p6eQIMDjnxsMLei6kxYwrUiJNFE0tGz1uJ6NG9wenKCMadiqchww5TOWxlXGGzMrKSqCQuDgLGcDrdoGYf3A9aQjIHnTRVUtXSs89ly/4AOjcmECgYEA5PcwwXRwe/EJDgliekFyW/2vd44lKq5ZdO+ee5pbzedALyPx93cXGi89UWIroQi8gXCy5webdDMAgQPt6yhQUJGrw/DgFC7tm74ywFcvOWtD0yxM7E7qucBSTCkAuh9spuHvyyga69ewF9oZIzqmaxB121+Kj/ONBGz2aL9LuG8CgYEAsrPEdCPgcjRVgZz4luuESrqTKe4waf7IaP1iZnIvMf72BV216YK68YBN3qBGAL3S15Ntjj4K41M1mkKGGpVtLp31UzZnDH18ShVeclOxSmh6A+uoNC+cXXON2rKGdCd+kb9KcUq0W7crt8KV+aHB56IOYQ8qppFfZTIxFJUxQSkCgYBmCyTXkyVul4YJk3UoN3LYPL+u8NLvqrSDwSdIvwqbQa0BVWvJdnH9YYBafP4kztf0eF3DSUinCPP4i9/FJjplLgb3VKsJU8Dh4GqN/k01sfCQdPXze1hxYJ1NBBkm2kp6NcfBKyaUZZQ9jR4W7VSt8rAUDQicD1eR2V4YYOlGUQKBgQCiaPMAwqJ36MxVcf4T25Rt/kdFcm6Zxq8JjE/j3565B4k8s0BjKycP2ZXr4Sn9/oci2aBWCFkI5VTwD8mlW2zRU0nlCKp7FYjiI62kph+ZCn7qFUDXvPWVkTG5M0szQbmsaHgVotlsCXs4FScMq1B5XjVHTOtsWu6iIA2vMTCEkQKBgQC5J0QnV1FGKC9RjzleVTH3D9fc/4sB4P6qJY0DWvLTJbOF8ABaTqQH0dAXmspFz4rwynlDyze6Mkvm9VEHxkGGFegYSu33DBD6Qr8Cifx7xS1BlMEgcmFW7oCyXbqcq3w3qOvot7YhzlF8STL7uQMr+jsy112CWJYIUEfkrf+TWA==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0Uegenx5htS259sr7FD01omJUx4331a5OHAyGZYQKUgXHzLiIStaZcroMt8iXZXhm8jTp5iE8U2sEucCUfveJMgNzQ7t7YKg4jcTu6jKWIGDSpeO2qRPixlqkMVxap1n8zvrliicdAAJWGvGs1/W/XBoP7A965mdPz/i/ECvS2ZEDGD+SBiOP7ZTSeYZgYqB0jeFg9YDrNuUo70ESQtMOW1dD7wFZDftobkXNHlWl5tSSG0EzAtWV8v6s8wTozZ6bycw8LJ+xRmeWAVMKk/Yq91O/OXk8HULyUM4CgHV9enBS2MVLa+KZCvS7oklDQRKTmS1YZYwf5O4IKfK5ijdeQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://www.wl.com";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "localhost:8080/AliPayController";
    // 签名方式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 支付宝网关
    public static String log_path;

    public static String paySuccessUrl;
    public static String payFailUrl;

    public static String getApp_id() {
        return app_id;
    }

    public static void setApp_id(String app_id) {
        AlipayConfig.app_id = app_id;
    }

    public static String getMerchant_private_key() {
        return merchant_private_key;
    }

    public static void setMerchant_private_key(String merchant_private_key) {
        AlipayConfig.merchant_private_key = merchant_private_key;
    }

    public static String getAlipay_public_key() {
        return alipay_public_key;
    }

    public static void setAlipay_public_key(String alipay_public_key) {
        AlipayConfig.alipay_public_key = alipay_public_key;
    }

    public static String getNotify_url() {
        return notify_url;
    }

    public static void setNotify_url(String notify_url) {
        AlipayConfig.notify_url = notify_url;
    }

    public static String getSign_type() {
        return sign_type;
    }

    public static void setSign_type(String sign_type) {
        AlipayConfig.sign_type = sign_type;
    }

    public static String getCharset() {
        return charset;
    }

    public static void setCharset(String charset) {
        AlipayConfig.charset = charset;
    }

    public static String getGatewayUrl() {
        return gatewayUrl;
    }

    public static void setGatewayUrl(String gatewayUrl) {
        AlipayConfig.gatewayUrl = gatewayUrl;
    }

    public static String getLog_path() {
        return log_path;
    }

    public static void setLog_path(String log_path) {
        AlipayConfig.log_path = log_path;
    }

    public static String getPaySuccessUrl() {
        return paySuccessUrl;
    }

    public static void setPaySuccessUrl(String paySuccessUrl) {
        AlipayConfig.paySuccessUrl = paySuccessUrl;
    }

    public static String getPayFailUrl() {
        return payFailUrl;
    }

    public static void setPayFailUrl(String payFailUrl) {
        AlipayConfig.payFailUrl = payFailUrl;
    }

    public static String getReturn_url() {
        return return_url;
    }

    public static void setReturn_url(String return_url) {
        AlipayConfig.return_url = return_url;
    }

}