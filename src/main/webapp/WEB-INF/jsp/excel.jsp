<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.pw.bills.utils.OnlineCounter"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>账单列表</title>
  <link rel="stylesheet" href="${APP_PATH}/layui/css/layui.css">
  <link rel="icon" href="${APP_PATH}/images/favicon.ico" type="image/x-icon"/>
  <style type="text/css">
  body{
  	//background: url(../images/bg_2.jpg) no-repeat center 0px;
  	background-position: center 0;
	background-size: cover; 

  }
	.content #lunbo .lb_img{
		align: center;
	}
	.content #lunbo:first-child {
	background:rgba(0,0,0,0.5);
	
	}
	.font_desc{
		
		color:black;
		line-height: 1.3
	}
	.font_img_content{
	margin: 10px 0px 0px 10px;
	}
	.footer{
		width:100%;
		height:100px;
		background-color:#C4C4C4;
		margin-top:100px;
	}
	.footer .layui-footer{
		padding-top:15px;
	}
	#search_form{
		margin-top:20px;
	}
	#update_bills{
	margin-top:20px;
	}
  </style>
</head>
<body class="layui-layout-body">
<div class="layui-container" style="width:100%">
	<!-- 头部导航 -->
	<div class="header">
		<ul class="layui-nav layui-bg-blue" lay-filter="demo">
			  <li class="layui-nav-item"><i class="layui-icon layui-icon-form" style="font-size: 30px; color: blue;"></i><span>账单系统</span></li>
			  <li class="layui-nav-item "><a href="index.action">首页</a></li>
			  <li class="layui-nav-item" ><a href="list.action">账单</a></li>
			   <li class="layui-nav-item" ><a href="chart.action">统计</a></li>
			  <li class="layui-nav-item"><a href="register.action">注册</a></li>
			  <li class="layui-nav-item"><a href="login.action">登录</a></li>
			  <li class="layui-nav-item"><a href="uploadPage.action">文件</a></li>
			  <li class="layui-nav-item layui-this" ><a href="excel.action">导出</a></li>
			  <li class="layui-nav-item">在线人数：<%=OnlineCounter.getCount() %></li>
			 <%--  <li class="layui-nav-item">在线人数：${count}</li> --%>
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
	<div class="content" >
		<!-- 搜索表单 -->
		<div id="search_form">
			
			<form class="layui-form" action="excel2.action" method="post">
				  
				  <div class="layui-form-item" align="center">
				    <div class="layui-inline">
				      <label class="layui-form-label">内容搜索</label>
				      <div class="layui-input-inline">
				        <input type="text" name="title" id="title"  autocomplete="off" class="layui-input">
				      </div>
				    </div>
				    <div class="layui-inline">
				      <label class="layui-form-label">开始日期</label>
				      <div class="layui-input-inline">
				        <input type="text" name="start" id="start"  placeholder="yyyy-MM-dd HH:mm:ss" autocomplete="off" class="layui-input">
				      </div>
				    </div>
				   <div class="layui-inline">
				      <label class="layui-form-label">结束日期</label>
				      <div class="layui-input-inline">
				        <input type="text" name="end" id="end"  placeholder="yyyy-MM-dd HH:mm:ss" autocomplete="off" class="layui-input">
				      </div>
				    </div>
				  </div>
				  
				   <div class="layui-form-item" align="center">
					    <div class="layui-input-block">
					      <button type="submit" class="layui-btn" lay-submit="" lay-filter="submit_btn">立即导出</button>
					      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
					    </div>
					</div>
				  
				 
			</form>
			
		</div>

	</div>

 

<script src="./layui/layui.js"></script>
<script>


layui.use(['carousel','jquery','form','element','layer','layedit', 'laydate','table'], function(){
	  var carousel = layui.carousel;
	  var $ = layui.jquery;
	  var element = layui.element;
	  var form = layui.form;
	  var layer = layui.layer;
	  var layedit = layui.layeidt;
	  var laydate = layui.laydate;
	  var table = layui.table;
	  
	  
	  //日期
	  laydate.render({
	    elem: '#start'
	    ,type: 'datetime'
	  });
	  //日期
	  laydate.render({
	    elem: '#end'
	    ,type: 'datetime'
	  });
	  
	  laydate.render({
		    elem: '#createTime'
		    ,type: 'datetime'
	  });
	  
	  
	/*   //监听模糊查询表单的提交
	  form.on('submit(submit_btn)',function(data){
		 $.post('excel.action',function(){})
		 
		  return false;
	  }); */
	  

	
});	
</script>
</body>
</html>
      