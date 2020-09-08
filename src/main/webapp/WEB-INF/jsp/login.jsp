<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>基于SSM的个人账单系统登录界面</title>
  <link rel="stylesheet" href="${APP_PATH}/layui/css/layui.css">
  <link rel="icon" href="${APP_PATH}/images/favicon.ico" type="image/x-icon"/>
  <style type="text/css">
 	#login_form{
 		
 		padding: 18px 40px 10px 10px;
 	}
 	.layui-row{
 		margin-top: 100px;
 	}
  </style>
</head>
<body class="layui-layout-body">
<div class="layui-container" style="width:100%">
	<!-- 头部文字 -->
	<div>
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
		  <legend><i class="layui-icon layui-icon-form" style="font-size: 30px; color: blue;"></i>欢迎登录！</legend>
		</fieldset>
	</div>
	<!-- 登陆表单 -->
	<div class="layui-row">
		<div class="layui-col-md4 layui-col-md-offset4" id="login_form">
			 <form class="layui-form" action="${APP_PATH}/login.action" id="login_form"  lay-filter="login" method="post">
				  <div class="layui-form-item">
				    <label class="layui-form-label">账号</label>
				    <div class="layui-input-block">
				      <input style="width:300px;height:37.99px"  type="text" name="loginname" id="loginname" lay-verify="required" autocomplete="off" placeholder="请输入账号" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">密码</label>
				    <div class="layui-input-block">
				      <input style="width:300px;height:37.99px" type="password" name="pwd" id="pwd" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  <div class="layui-form-item">
					  <div class="layui-from">
					    <label class="layui-form-label">验证码</label>
					    <div class="layui-input-block">
					      <input style="width:300px;height:37.99px" style="width:100px" type="text" name="code" id="code" lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">
					    </div>
					  </div>
				  </div>
				   <div class="layui-form-item">
					  <div class="layui-from">
					    <div class="layui-input-block">
					      <img alt="加载失败" src="loadCode.action" onClick="this.src=this.src+'?'">
					    </div>
					  </div>
				  </div>
				  
				  <div class="layui-form-item">
				    <div class="layui-input-block">
				    	<font color="red">${msg}</font>
				    </div>
				  </div>
				  
				  
				  <div class="layui-form-item">
				    <div class="layui-input-block">
				      
				      <button type="button" class="layui-btn layui-btn-normal" id="register">没有账号</button>
				      <button  class="layui-btn" lay-submit="" id="submit_btn" lay-filter="submit_btn">立即登录<button>
				    </div>
				  </div>
				</form>
		</div>
	</div>
	
</div>


<script src="${APP_PATH}/layui/layui.js"></script>
<script>


layui.use(['carousel', 'form','element','jquery','layer'], function(){
	  var carousel = layui.carousel
	  var element = layui.element;
	  var form = layui.form;
	  var $ = layui.jquery;
	  var layer = layui.layer;
	  $("#register").click(function(){
		 window.location.href="register.action"; 
	  });
	
	  
	  
	
	 
	
});
</script>
</body>
</html>
      