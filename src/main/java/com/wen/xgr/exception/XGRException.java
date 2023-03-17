package com.wen.xgr.exception;

public class XGRException extends RuntimeException {

    private String msg;

    public XGRException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
