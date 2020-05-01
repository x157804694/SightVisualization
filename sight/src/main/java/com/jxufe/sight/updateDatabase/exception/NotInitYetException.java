package com.jxufe.sight.updateDatabase.exception;

public class NotInitYetException extends Exception{
    private String message;

    public NotInitYetException() {
        super();
    }

    public NotInitYetException(String message) {
        super(message);
    }
}
