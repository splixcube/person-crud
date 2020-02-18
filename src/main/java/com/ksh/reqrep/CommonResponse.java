package com.ksh.reqrep;

public class CommonResponse {

	private int code;
	private String message;
	private Object data;
	private String description;
	
	public CommonResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public CommonResponse(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public CommonResponse(int code, String message, String description) {
		this.code = code;
		this.message = message;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
}
