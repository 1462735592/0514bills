package com.pw.bills.controller;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pw.bills.pojo.User;
import com.pw.bills.service.UserService;
import com.pw.bills.utils.OnlineCounter;
import com.pw.bills.utils.Result;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public String showLogin(Model model) {
		model.addAttribute("msg","");
		return "login";
	}
	//加载验证码
	@RequestMapping("loadCode")
	public void lodaCode(HttpServletResponse response,HttpSession session) throws IOException {
		// 1 普通验证码
		LineCaptcha captcha = CaptchaUtil.createLineCaptcha(300, 38);
		
		// 2 ShearCaptcha 扭曲干扰验证码   宽，高，字符数，干扰线宽度
		//ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(300, 38, 4, 4);
		
		// 3 CircleCaptcha 圆圈干扰验证码  最后一个参数为 圆圈的个数
		//CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(300, 38, 4, 20);
		//获取验证码并将其写入session
		session.setAttribute("code", captcha.getCode());
		ServletOutputStream outputStream = response.getOutputStream();
		ImageIO.write(captcha.getImage(), "JPEG", outputStream);
		
		outputStream.close();
		
	}
	
	//跳转到index界面
	@RequestMapping("index")
	public String showIndex(){
		return "index";
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String userLogin(User user,Model model,HttpSession session,String code,HttpServletRequest requset) {
		
		User user2 = userService.queryUserByLoginname(user.getLoginname());
		String sessionCode = (String) session.getAttribute("code");
		if(!code.equals(sessionCode)) {
			model.addAttribute("msg","验证码错误！");
			return "login";
		}
		if(user2!=null) {
			if(user2.getPwd().equals(user.getPwd())) {
				
				session.setAttribute("user", user2);
				return "redirect:index";
			}
			
		}
		model.addAttribute("msg","账号或密码错误！");
		return "login";
	}
	@RequestMapping(value="logout")
	public String logout(HttpSession session){
		session.invalidate();
		
		return "redirect:login";
	}
}
