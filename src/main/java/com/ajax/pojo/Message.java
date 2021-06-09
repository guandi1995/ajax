package com.ajax.pojo;

/**
 * @author Di Guan on 6/5/2021 11:25 PM
 */

public class Message {
    private String message;
    private boolean status;
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Message() {
    }

    public Message(String message, boolean status, Object obj) {
        this.message = message;
        this.status = status;
        this.obj = obj;
    }

    public Message(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
