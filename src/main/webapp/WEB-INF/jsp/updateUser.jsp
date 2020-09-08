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
  <title>基于SSM的个人账单系统修改用户信息</title>
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
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
	  <legend><i class="layui-icon layui-icon-form" style="font-size: 30px; color: blue;"></i>修改个人信息!</legend>
	</fieldset>
	 
	 <!-- 注册表单 -->
	<div class="layui-row">
		<div class="layui-col-md4 layui-col-md-offset4" id="login_form">
			
			<form class="layui-form" action="" lay-filter="example" id="register_form" method="post">
			  <div class="layui-form-item">
			    <label class="layui-form-label" id="loginname_label">账号</label>
			    <div class="layui-input-block">
			      <input lay-verify="required" type="text" name="loginname" id="loginname" lay-verify="title" autocomplete="off" readonly="true" value="${user.loginname}" class="layui-input">
			      
			    </div>
			  </div>
			  
			  <div class="layui-form-item">
			    <label class="layui-form-label">旧密码</label>
			    <div class="layui-input-block">
			      <input lay-verify="required" type="password" name="oldPwd" id="oldPwd"  placeholder="请输入旧密码" autocomplete="off" class="layui-input" value="${user.pwd }" readonly="true">
			    </div>
			  </div>
			  
			  <div class="layui-form-item">
			    <label class="layui-form-label">新密码</label>
			    <div class="layui-input-block">
			      <input lay-verify="required" type="password" name="pwd" id="pwd"  placeholder="请输入密码" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">确认密码</label>
			    <div class="layui-input-block">
			      <input lay-verify="required" type="password" name="pwd1" id="pwd1" placeholder="请确认密码" autocomplete="off" class="layui-input">
			      
			    </div>
			  </div>
			  
			  
			  <div class="layui-form-item">
			    <label class="layui-form-label">姓名</label>
			    <div class="layui-input-block">
			      <input lay-verify="required" type="text" name="name" id="name" lay-verify="title" autocomplete="off" placeholder="请输入姓名" class="layui-input">
			    </div>
			  </div>
		
		 
		  <div class="layui-form-item">
		    <div class="layui-input-block">
		      <button type="submit"  lay-submit="" lay-filter="submit_btn" id="submit" class="layui-btn" >立即修改</button>
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
	  
	  //点击已有账号跳转到登录界面
	  $("#login").click(function(){
			 window.location.href="login.action"; 
	  });
	
	  
	 
	//校验密码是否一致
	$("#pwd1").blur(function(){
		
		if($("#pwd").val() != $("#pwd1").val()){
			$("#pwd1").attr("style","background-color:#e4e4e4");
			$("#pwd").attr("style","background-color:#e4e4e4");
			layer.msg("密码不一致");
		}else{
			$("#pwd1").removeAttr("style");
			$("#pwd").removeAttr("style");
		}
		
	});
	
	
	 //监听提交
	  form.on('submit(submit_btn)', function(data){
		  $.post('updateUser.action',data.field,function(result){
	    	  if(result.status==200){
	    		  layer.confirm('修改成功请重新登录！', {
					  btn: ['前去登录！'] //按钮
					}, function(index){
					 	window.location.href="login.action";
					 	layer.close(index);
					 	
					}
					);
	    		
	    	  }
	    	  else{
	    		  layer.msg("111");
	    	  }
	      });
	    return false;
	  });
		     
	    
		    
	
	
	  
	
	 
	
});
</script>
</body>
</html>
      