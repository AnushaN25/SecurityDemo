package com.library.exception;

import java.time.LocalDateTime;

public class ErrorInformation 
{
	LocalDateTime timeStamp;
	String msg;
	String url;
	String validationMsg;
	public ErrorInformation() {
		super();
	}
	public ErrorInformation(LocalDateTime timeStamp, String msg, String url) {
		super();
		this.timeStamp = timeStamp;
		this.msg = msg;
		this.url = url;

	}
	
	public ErrorInformation(String url, String msg, LocalDateTime timeStamp, String validationMsg) {
		super();
		this.timeStamp = timeStamp;
		this.msg = msg;
		this.url = url;
		this.validationMsg = validationMsg;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getValidationMsg() {
		return validationMsg;
	}
	public void setValidationMsg(String validationMsg) {
		this.validationMsg = validationMsg;
	}
}
