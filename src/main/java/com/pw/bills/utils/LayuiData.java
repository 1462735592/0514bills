package com.pw.bills.utils;

public class LayuiData {
	private int code=0;
	private String msg;
	private long count;
	private Object data;
	public LayuiData(long total, Object data) {
		super();
		this.count = total;
		this.data = data;
	}
	public LayuiData() {
		
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
