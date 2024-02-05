package com.Hiagodev.StudentMongo.resources.exception;

import java.io.Serializable;

public class StandartError implements Serializable {
    public static final long serialVersionUID = 1L;
    private Long timestamp;
    private Integer status;
    private  String error;
    private  String message;
    private  String path;

    public  StandartError(){

    }

    public StandartError(Long timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
