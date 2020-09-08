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
  <title>基于SSM的个人账单系统</title>
  <link rel="stylesheet" href="${APP_PATH}/layui/css/layui.css">
  <link rel="icon" href="${APP_PATH}/images/favicon.ico" type="image/x-icon"/>
  <style type="text/css">
  body{
  	background: url(./images/bg_2.jpg) no-repeat center 0px;
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
		margin-top:60px;
	}
	.footer .layui-footer{
		padding-top:30px;
	}
  </style>
</head>
<body class="layui-layout-body">
<div class="layui-container" style="width:100%">
	<!-- 头部导航 -->
	<div class="header">
		<ul class="layui-nav layui-bg-blue" lay-filter="demo">
			  <li class="layui-nav-item"><i class="layui-icon layui-icon-form" style="font-size: 30px; color: blue;"></i><span>账单系统</span></li>
			  <li class="layui-nav-item layui-this"><a href="index.action">首页</a></li>
			  <li class="layui-nav-item"><a href="list.action">账单</a></li>
			   <li class="layui-nav-item" ><a href="chart.action">统计</a></li>
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
	<div class="content" >
		<!-- 轮播图 -->
		<div class="layui-carousel" id="lunbo"  style="width:100%">
		  <div carousel-item="" align="center">
		    <div class="lb_img"><img src="./images/1.jpg"></div>
		    <div class="lb_img" ><img src="./images/2.jpg" ></div>
		    <div class="lb_img"><img src="./images/3.jpg" ></div>
		    <div class="lb_img" ><img src="./images/4.jpg"></div>
		  </div>
		</div>
		<!-- 文字&图片 -->
		<div  class="layui-row font_img_content" style="width:100%" >
			
			<div class="layui-col-lg6">
				<span>  <font class="font_desc" size="4"><br/>&nbsp;&nbsp;&nbsp;&nbsp;记账简单来说，就是把你每天的所有收入和开支都统统记下来。用本子也
					好，用软件也好，或者你自己做个excel也好，全部统统毫无遗漏地记录下来。
					记账的时候，我们一定要对自己诚实，勇于承认自己冲动消费了，每一笔都要
					认真记录下来，像一个理性的机器一样，事无巨细，最好做到，你账本上的总
					额永远和你账户上的总额对得上。
					</font>
				</span>
				<span>  <font class="font_desc" size="4">
							<br/>&nbsp;&nbsp;&nbsp;&nbsp;这么做一开始很痛苦的，买一罐2块5的红茶记账，交5块钱的停车费
							记账，然后信用卡的刷卡当然也是统统得记账的。随身带着小账本比较不现实，
							最好的办法还是用手机软件来搞定。现在的手机记账软件多如牛毛，方便实用。
							如果你是刷卡消费还有很多软件可以导入信用卡账单，连自己动手都省了。
							这么痛苦的记账到底有什么好处呢？难道还能让你变成高富帅白富美？是
							的，记账的话，是绝大部分人通往高富帅白富美所要踏出的第一步。
					</font>
				</span>
			</div>
			<div class="layui-col-lg6" border="clol">
				
				<image src="${APP_PATH}/images/jsb_2.jpg"></image>
				<image src="${APP_PATH}/images/jsb_3.jpg"></image>
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


<script src="./layui/layui.js"></script>
<script>


layui.use(['carousel', 'form','element','layer'], function(){
	  var carousel = layui.carousel
	  var element = layui.element;
	  var form = layui.form;
	  
	  
	  //图片轮播
	  carousel.render({
	    elem: '#lunbo'
	    ,width: '50%'
	    ,height: '160px'
	    ,interval: 5000
	  });
	  
	  
	 
	  
	
	  
	});
	
	
	
</script>
</body>
</html>
      