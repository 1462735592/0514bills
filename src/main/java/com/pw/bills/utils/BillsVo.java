package com.pw.bills.utils;




import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.pw.bills.pojo.Bills;



public class BillsVo  extends Bills{
	private Long Toatl; 
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date start;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date end;
	private Integer page;
	private Integer limit;
	
	

	public Long getToatl() {
		return Toatl;
	}
	public void setToatl(Long toatl) {
		Toatl = toatl;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
}
