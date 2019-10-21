package com.wl.www.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseContent {
    private String code;
    private List<String> messageList = new ArrayList<>();
    private Object returnValue = new Object();

    public ResponseContent() {
    }

    public ResponseContent(String code, List<String> messageList, Object returnValue) {
        this.code = code;
        this.messageList = messageList;
        this.returnValue = returnValue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Object returnValue) {
        this.returnValue = returnValue;
    }
}
