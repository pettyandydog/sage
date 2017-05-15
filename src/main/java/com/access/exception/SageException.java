package com.access.exception;

/**
 * @author andy
 * @create 2017-05-15 10:40
 */
public class SageException extends RuntimeException {

    public SageException(String message){
        super(message);
    }

    public SageException(String message,  Throwable cause){
        super(message, cause);
    }

    public SageException(Throwable cause){
        super(cause);
    }

}
