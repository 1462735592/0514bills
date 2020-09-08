package com.pw.bills.pojo;

public class User {
    private Integer id;

    private String name;

    private String loginname;

    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", loginname=" + loginname + ", pwd=" + pwd + "]";
	}
    
}