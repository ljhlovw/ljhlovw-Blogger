package com.jingdianjichi.entity;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    FAIL(500, "失败");


    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResultCodeEnum getByCode(int code){
        for(ResultCodeEnum resultCodeEnum:ResultCodeEnum.values()){
            if (resultCodeEnum.code==code){
                return resultCodeEnum;
            }
        }
        return null;
    }
}
