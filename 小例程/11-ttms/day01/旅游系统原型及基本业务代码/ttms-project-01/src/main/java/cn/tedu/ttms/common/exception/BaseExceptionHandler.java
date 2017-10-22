package cn.tedu.ttms.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.util.JsonResult;

@ControllerAdvice
public class BaseExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult handleRuntimeException(Exception e){
		System.err.println(e.getMessage());
		return new JsonResult(e);		
	}
	
}
