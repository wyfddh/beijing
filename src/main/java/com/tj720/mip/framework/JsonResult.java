package com.tj720.mip.framework;

import java.io.Serializable; 

import com.tj720.mip.utils.Page;

public class JsonResult implements Serializable {
	private static final long serialVersionUID = 7553249056983455065L;
	private Page page;
	private Integer success;
	private Object data;
	private  ErrorMessage error;
	
	private Integer code;
	private String msg;
	private Integer count;
	
	//传递至前端的其他参数
	private Object others;

	public JsonResult(Integer success,Object data,String errorCode,String errorMessage){
		this.data = data;
		this.success = success;
		if(success == 0){
			this.error = new ErrorMessage(errorCode,errorMessage);
		}
	}
	public JsonResult(Integer success,Object data,Page page,Object others){
		this( success, data, page);
		this.others = others;
		
	}
	public JsonResult(Integer success,Object data,Page page){
		this.data = data;
		this.success = success;
		this.page = page;
	}
	public JsonResult(Integer success,Object data){
		this.data = data;
		this.success = success;
	}
	public JsonResult(Integer success){
		this.success = success;
	}
	
	public JsonResult(Integer code,String msg,Integer count,Object data) {
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}
	public JsonResult(Integer code,String msg,Integer count,Object data,Page page) {
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
		this.page = page;
	}

	public JsonResult(MyException exception){
		this.data = null;
		this.success = 0;
		String errorCode = exception.getMessage();
		String errorMsg =  ErrorInfos.getMessage(errorCode);
		this.setError( new ErrorMessage(errorCode,errorMsg+(exception.getMsgExtention()==null?"":exception.getMsgExtention())));
	}
	
	public JsonResult(String errorCode){
		this.data = null;
		this.success = 0;
		String errorMsg =  ErrorInfos.getMessage(errorCode);
		this.setError( new ErrorMessage(errorCode,errorMsg) );
	}
	
	
	public Integer getSuccess() {
		return success;
	}

	public void setSuccess(Integer success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ErrorMessage getError() {
		return error;
	}

	public void setError(ErrorMessage error) {
		this.error = error;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	public Object getOthers() {
		return others;
	}
	public void setOthers(Object others) {
		this.others = others;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	
	
}

class ErrorMessage{
	private String code;
	private String message;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ErrorMessage(String code,String message){
		this.setCode(code);
		this.setMessage(message);
	}
}
