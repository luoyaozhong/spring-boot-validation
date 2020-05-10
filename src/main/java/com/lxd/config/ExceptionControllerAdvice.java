package com.lxd.config;

import com.lxd.entity.ResultVO;
import com.lxd.enums.ResultCode;
import com.lxd.exception.APIException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * ExceptionControllerAdvice
 *
 *		@ControllerAdvice或 @RestControllerAdvice注解，这个类就配置成全局处理类了
 *		这个根据你的Controller层用的是@Controller还是@RestController来决定
 *
 * @author lxd
 * @date 2020/5/10
 **/
@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	// @ExceptionHandler注解并指定你想处理的异常类型
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
    	// 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
     // 注意哦，这里传递的响应码枚举
        return new ResultVO<String>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }
	
	
	@ExceptionHandler(NullPointerException.class)
    public ResultVO<String> NullPointerExceptionHandler(NullPointerException e) {
		// 注意哦，这里传递的响应码枚举
	    return new ResultVO<String>(ResultCode.NULL_POINTER, e.getMessage());
    }
	
	@ExceptionHandler(ArithmeticException.class)
    public ResultVO<String> ArithmeticExceptionHandler(ArithmeticException e) {
		// 注意哦，这里传递的响应码枚举
	    return new ResultVO<String>(ResultCode.BY_ZERO, e.getMessage());
    }
	
	@ExceptionHandler(APIException.class)
	public ResultVO<String> APIExceptionHandler(APIException e) {
		// 注意哦，这里传递的响应码枚举
	    return new ResultVO<String>(ResultCode.FAILED, e.getMsg());
	}
	
}
