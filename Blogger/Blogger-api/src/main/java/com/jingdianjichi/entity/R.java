package com.jingdianjichi.entity;


import lombok.Data;

@Data
public class R<T> {
    private Boolean success;
    private Integer code;
    private String message;
    private T data;

    public static  R ok() {
        R R = new R();
        R.setSuccess(true);
        R.setCode(ResultCodeEnum.SUCCESS.getCode());
        R.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return R;
    }
    public static <T> R ok(T data) {
        R R = new R();
        R.setSuccess(true);
        R.setCode(ResultCodeEnum.SUCCESS.getCode());
        R.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        R.setData(data);
        return R;
    }
    public static R fail(){
        R R=new R();
        R.setSuccess(false);
        R.setCode(ResultCodeEnum.FAIL.getCode());
        R.setMessage(ResultCodeEnum.FAIL.getMessage());
        return R;
    }
    public static <T> R fail(T data){
        R R=new R();
        R.setSuccess(false);
        R.setCode(ResultCodeEnum.FAIL.getCode());
        R.setMessage(ResultCodeEnum.FAIL.getMessage());
        R.setData(data);
        return R;
    }
}