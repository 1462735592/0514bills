package com.pw.bills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pw.bills.pojo.User;
import com.pw.bills.service.UserService;
import com.pw.bills.utils.Result;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("register")
	public String showRegister() {
		return "register";
	}
	
	//注册
	@RequestMapping(value="registerUser",method=RequestMethod.POST)
	@ResponseBody
	public Result register(User user) {
		int row  = userService.addUser(user);
		if(row>0) {
			return Result.ok();
		}
		return Result.build(402, "注册失败！");
	}
	
	//校验注册表单数据
	@RequestMapping("checkdata/{param}")
	@ResponseBody
	public Result checkData(@PathVariable String param) {
		User user = userService.queryUserByLoginname(param);
		if(user!=null) {
			return Result.build(401, "账号已存在！");
		}
		return Result.ok();
	}
}
