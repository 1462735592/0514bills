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
 	
  </style>
</head>
<body class="layui-layout-body">
<div class="layui-container" style="width:100%">
	
	<style type="text/css">
.img{
width:800px;
height:600px;
border: 0;
color: gray;
} 
.footer{
		width:100%;
		height:100px;
		background-color:#C4C4C4;
		margin-top:120px;
	}
	.footer .layui-footer{
		padding-top:30px;
	}
</style>
<div class="layui-container" style="width:100%">
	<!-- 头部导航 -->
	<div class="header">
		<ul class="layui-nav layui-bg-blue" lay-filter="demo">
			  <li class="layui-nav-item"><i class="layui-icon layui-icon-form" style="font-size: 30px; color: blue;"></i><span>账单系统</span></li>
			  <li class="layui-nav-item "><a href="index.action">首页</a></li>
			  <li class="layui-nav-item " ><a href="list.action">账单</a></li>
			   <li class="layui-nav-item layui-this" ><a href="chart.action">统计</a></li>
			  <li class="layui-nav-item"><a href="register.action">注册</a></li>
			  <li class="layui-nav-item"><a href="login.action">登录</a></li>
			  <li class="layui-nav-item"><a href="uploadPage.action">文件</a></li>
			  <li class="layui-nav-item" lay-unselect="" style="float:right">
			    <a href="javascript:;">${user.name }</a>
			    <dl class="layui-nav-child">
			      <dd><a href="updateUser.action">修改信息</a></dd>
			      <dd><a href="logout.action" id="logout">退了</a></dd>
			    </dl>
			  </li>
		</ul> 
	</div>
	<!-- 中间内容区 -->
	<div class="content"  align="center">
		<div class="layui-row">
			 <div>
			 	<img></img>
			 </div>
		</div>
	</div>
	
	<!-- 底部 -->
	<div class="footer" align="center">
		<div class="layui-footer">
		    <!-- 底部固定区域 -->
		    更多内容敬请期待！
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
	 
	//加载饼状图
	$.post('getPieChart.action',function(result){
		$("img").attr("src",result);
	})
	  
	  
	
	 
	
});
</script>
</body>
</html>
      