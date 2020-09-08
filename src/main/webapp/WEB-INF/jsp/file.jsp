<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
table.imagetable {
    font-family: verdana,arial,sans-serif;
    font-size:11px;
    color:#333333;
    border-width: 1px;
    border-color: #999999;
    border-collapse: collapse;
}
table.imagetable th {
    background:#b5cfd2 ;
    border-width: 1px;
    padding: 8px;
    border-style: solid;
    border-color: #999999;
}
table.imagetable td {
    background:#dcddc0 ;
    border-width: 1px;
    padding: 8px;
    border-style: solid;
    border-color: #999999;
}
</style>
<div class="layui-container" style="width:100%">
	<!-- 头部导航 -->
	<div class="header">
		<ul class="layui-nav layui-bg-blue" lay-filter="demo">
			  <li class="layui-nav-item"><i class="layui-icon layui-icon-form" style="font-size: 30px; color: blue;"></i><span>账单系统</span></li>
			  <li class="layui-nav-item "><a href="index.action">首页</a></li>
			  <li class="layui-nav-item " ><a href="list.action">账单</a></li>
			   <li class="layui-nav-item " ><a href="chart.action">统计</a></li>
			  <li class="layui-nav-item"><a href="register.action">注册</a></li>
			  <li class="layui-nav-item"><a href="login.action">登录</a></li>
			  <li class="layui-nav-item layui-this"><a href="uploadPage.action">文件</a></li>
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
		<div class="data_list">
			<div class="data_info">
				<p>上传下载资料</p>
			</div>
			<div class="data_content">
				
				<form action="upload.action"
			        method="post" enctype="multipart/form-data">
			        选择文件:<input type="file" name="file" width="120px"> <input
			            type="submit" value="上传">
			    </form>
			    <hr>
			    
			        <table class="imagetable">
					 <tr>
						<th>序号</th>
						<th>文件ID</th>
						<th>文件名</th>
						<th>操作</th>
					</tr>
					<c:forEach var="fileA" items="${filename}" varStatus="status" >
						<tr>
							<td>${status.index+1 }</td>
							<td>${fileA.id }</td>
							<td>${fileA.name}</td>
							<td><button class="btn-mini btn-info" type="button" onclick="javascript:window.location='down?filename=${fileA.name }'">下载</button></td>
						</tr>
					</c:forEach>
					
			  </table>
			       
			    
				
			</div>
		</div>
	</div>
	


</div>



<script src="${APP_PATH}/layui/layui.js"></script>
<script>



</script>
</body>
</html>
      