package com.lxd.enums;

import lombok.Getter;

/**
 * ResultCode
 *
 * @author lxd
 * @date 2020/5/10
 **/
@Getter
public enum ResultCode {
	

	SUCCESS(1000, "操作成功"),

    FAILED(1001, "响应失败"),
    
    BY_ZERO(1002, "被除数不能为0错误"),
    
    NULL_POINTER(1003, "空指针错误"),
    
    VALIDATE_FAILED(1004, "参数校验失败"),

    ERROR(5000, "未知错误");
	
	private int code;
	private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
	
}
