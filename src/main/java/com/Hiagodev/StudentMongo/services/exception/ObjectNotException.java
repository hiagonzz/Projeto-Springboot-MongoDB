package com.Hiagodev.StudentMongo.services.exception;

public class ObjectNotException extends RuntimeException {
    private  static final long serialVersionUID =1l;

    public ObjectNotException(String msg){
        super(msg);
    }
}
