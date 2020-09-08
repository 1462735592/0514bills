package com.pw.bills.service;

import com.pw.bills.pojo.User;
import com.pw.bills.utils.Result;

public interface UserService {
	public User queryUserById(Integer id);

	public User queryUserByLoginname(String loginname);

	public int addUser(User user);

	public Result updateUser(User user);
}
