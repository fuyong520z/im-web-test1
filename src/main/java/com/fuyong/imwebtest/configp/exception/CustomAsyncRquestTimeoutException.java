package com.fuyong.imwebtest.configp.exception;

public class CustomAsyncRquestTimeoutException extends RuntimeException {
    private static final long serialVersionUID = 1398993993238109797L;
    public CustomAsyncRquestTimeoutException(String url){
        super(url);
    }
}
