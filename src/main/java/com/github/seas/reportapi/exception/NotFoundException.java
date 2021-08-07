package com.github.seas.reportapi.exception;

public class NotFoundException extends Exception {

    private static final long serialVersionUID = 1149241039409861914L;

    public NotFoundException(String msg){
        super(msg);
    }

    public NotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }

}
