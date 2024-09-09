package com.hohuuan.web;

public class Package {
    private int code;
    private String message;
    private Object data;

    public Package(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public Package(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Package error(int code, String message){
        return new Package(code, message, null);
    }

    public static Package success(String message){
        return new Package(0, message, null);
    }

    public static Package success(String message, Object data){
        return new Package(0, message, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Package{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
