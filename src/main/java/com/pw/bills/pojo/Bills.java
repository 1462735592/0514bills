package com.pw.bills.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Bills {
    private Integer id;

    private Integer typeId;

    private Integer userId;

    private String title;

    private Integer price;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String remark;
    private String typeName;
    

    public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    
	public Bills() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bills(Integer id, String title, Integer price, Date createTime, String remark) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.createTime = createTime;
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "Bills [id=" + id + ", typeId=" + typeId + ", userId=" + userId + ", title=" + title + ", price=" + price
				+ ", createTime=" + createTime + ", remark=" + remark + ", typeName=" + typeName + "]";
	}
    
}