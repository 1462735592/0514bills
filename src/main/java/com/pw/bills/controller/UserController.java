package com.pw.bills.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pw.bills.pojo.User;
import com.pw.bills.service.UserService;
import com.pw.bills.utils.Result;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/updateUser")
	public String updateUser() {
		return "updateUser";
	}
	//更新user表
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	@ResponseBody
	public Result updateUser(User user,String oldPwd
			,HttpSession session) {
		User userSession = (User) session.getAttribute("user");
		if(!userSession.getPwd().equals(oldPwd)) {
			return Result.build(408, "旧密码输入错误!");
		}
		Result  result  = userService.updateUser(user);
		return result;
	}
	
}
