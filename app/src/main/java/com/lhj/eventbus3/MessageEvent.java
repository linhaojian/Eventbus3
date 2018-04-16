package com.lhj.eventbus3;

/**
 * Created by Administrator on 2018/4/10.
 */

public class MessageEvent {
    private String message;
    public MessageEvent(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
