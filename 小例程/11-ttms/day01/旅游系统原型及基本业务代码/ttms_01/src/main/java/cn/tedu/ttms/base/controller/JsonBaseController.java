package cn.tedu.ttms.base.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.base.entity.JsonResult;

public class JsonBaseController  extends BaseController{
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult<String> handleException(Exception e){
		e.printStackTrace();
		return new JsonResult<String>(e);
	}
	
}
