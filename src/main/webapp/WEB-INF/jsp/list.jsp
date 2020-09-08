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
  	background: url(../images/bg_2.jpg) no-repeat center 0px;
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
			  <li class="layui-nav-item layui-this" ><a href="list.action">账单</a></li>
			   <li class="layui-nav-item" ><a href="chart.action">统计</a></li>
			  <li class="layui-nav-item"><a href="register.action">注册</a></li>
			  <li class="layui-nav-item"><a href="login.action">登录</a></li>
			  <li class="layui-nav-item"><a href="uploadPage.action">文件</a></li>
			  <li class="layui-nav-item" ><a href="excel.action">导出</a></li>
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
			
			<form class="layui-form" action="" method="post">
				  
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
					      <button type="submit" class="layui-btn" lay-submit="" lay-filter="submit_btn">立即查询</button>
					      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
					    </div>
					</div>
				  
				 
			</form>
			
		</div>
		<!-- 账单展示列表 -->
		<div id="bill_table">
			<table class="layui-hide" id="test" lay-filter="test"></table>
 

		</div>
	</div>
	
	<div class="layui-row " id="update_bills">
		<div class="layui-col-md4" align="center">
			<button class="addBillBtn layui-btn" id="addBillBtn">增加账单</button>
		</div>
		
		<div class="layui-col-md4" align="center">
			<button class="updateBillBtn layui-btn" id="updateBillBtn">修改账单</button>
		</div>
	</div>
	

</div>

<div id="addBillDiv" style="display: none;margin: 10px">
	<form id="dataFrm" method="post" lay-filter="dataFrm" class="layui-form  layui-form-pane">
		  <div class="layui-form-item">
		      <label class="layui-form-label">帐单类型</label>
		      <div class="layui-input-block" id="billTypeDiv">
		      	<select id="search_typeid" lay-verify="required" name="typeId"></select>
		      </div>
		  </div>
		 <div class="layui-form-item">
		    <div class="layui-inline">
		      <label class="layui-form-label">帐单标题</label>
		      <div class="layui-input-inline">
		        <input type="text" name="title" id="title" placeholder="请输入账单标题" lay-verify="required"  autocomplete="off" class="layui-input">
		      </div>
		    </div>
		    <div class="layui-inline">
		      <label class="layui-form-label">账单时间</label>
		      <div class="layui-input-inline">
		        <input type="text" name="createTime"  lay-verify="required" id="createTime" readonly="readonly" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
		      </div>
		    </div>
		  </div>
		   <div class="layui-form-item">
		    <div class="layui-inline">
		      <label class="layui-form-label">金额/元</label>
		      <div class="layui-input-inline">
		        <input type="text" name="price1" id="price1"  lay-verify="number|required" placeholder="请输入账单金额"  autocomplete="off" class="layui-input">
		      </div>
		    </div>
		  </div>
		   <div class="layui-form-item">
		      <label class="layui-form-label">帐单备注</label>
		      <div class="layui-input-block">
		       <textarea placeholder="请输入帐单备注" lay-verify="required" name="remark" id="remark" class="layui-textarea"></textarea>
		      </div>
		  </div>
		   <div class="layui-form-item" style="text-align: center;">
		       		<button type="button" class="layui-btn" lay-submit="" lay-filter="doSubmit">提交</button>
     				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		  </div>
	</form>	
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
	  
	 
	 
	
	  
	  var tableIns = table.render({
		    elem: '#test'
		   
		    ,url: '${APP_PATH}/list/getAllBills.action' //数据接口
		    ,toolbar: true
		    ,width: 1366
		    ,page: true //开启分页 
		    ,limit: 5
		    ,limits: [5,10]
		    ,cols: [[ //表头
		      {field: 'id', title: 'ID'}
		      ,{field:'typeId',title:"类型id"}
		      ,{field: 'typeName', title: '类型' ,width: '10%'}
		      ,{field: 'userId', title: '用户id',width: '10%'}
		      ,{field: 'title', title: '标题',width: '20%'} 
		      ,{field: 'price', title: '金额（ 单位：元）',width: '10%', templet: function(d){return d.price/100}}
		      ,{field: 'createTime', title: '时间',width: '10%'}
		      ,{field: 'remark', title: '说明',width: '20%'}
		    ]]
	  		
		  });
	  
	 	
	  
	  
	  
	  
	  //监听模糊查询表单的提交
	  form.on('submit(submit_btn)',function(data){
		  tableIns.reload({
			  url:'${APP_PATH}/list/getAllBills.action',
			  where: data.field,
			  page:{
				  curr:1 //从第一页开始
			  }
		  })
		  return false;
	  });
	  
	  //下拉框复制
	  $.get('./loadAllBillType',function(result){
		  
		  var search_typeid=$("#search_typeid");
		  $.each(result,function(index,item){
			  search_typeid.append($("<option></option>").append(item.name).attr("value",item.id));
			 // search_typeid.append("<option value="+item.id+">"+item.name+"</option>");
		  });
		 form.render("select");
	  })
	  
	  var mainIndex;
	  
	  //添加弹出层的弹出
	  $("#addBillBtn").click(function(){
			$("#dataFrm input").val("");
			$("#dataFrm textarea").val("");
			layerOpen();
		  
	  });
	  
	  //打开弹出层的函数
	  function layerOpen(){
		  mainIndex=layer.open({
			    type: 1
			    ,content: $('#addBillDiv') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
			  	,area:['800px','600px']
			  });
	  }
	  
	  
	  //添加bills表单的提交
	  form.on("submit(doSubmit)",function(data){
			$.post("addBill.action",data.field,function(res){
				layer.msg(res.msg);
				if(res.status==200){
					layer.confirm('是否继续录入？', {
						  btn: ['继续','取消'] //按钮
						}, function(index){
						 	$("#dataFrm")[0].reset();
						 	layer.close(index);
						 	
						}, function(){
						   layer.close(mainIndex);
						});
				}
				tableIns.reload();
			});
	  });
	  
	  
	  $("#updateBillBtn").click(function(){
			layer.msg("双击指定行可进行修改操作！");
		});
	  
	  //监听数据表格 行
	  table.on('rowDouble(test)', function(obj){
		  console.log(obj.tr); //得到当前行元素对象
		  console.log(obj.data); //得到当前行数据
		  //obj.del(); //删除当前行
		  //obj.update(fields) //修改当前行数据
		  //layer.msg(obj.data.id);
		  layer.confirm('你可以对此行数据进行的操作？', {
			  btn: ['修改','删除','取消'] //按钮
			}, function(index){
			 	//$("#dataFrm")[0].reset();
			 	//打开弹出层
			 	layerOpen();
				//给弹出层form表单回显数据
				$("select").val(obj.data.typeId);
			 	$("#dataFrm #title").val(obj.data.title);
				$("#dataFrm #createTime").val(obj.data.createTime);
				$("#dataFrm #price1").val(obj.data.price/100);
				$("#dataFrm #remark").val(obj.data.remark);
				$("#dataFrm").append($("<input></input>").attr("name","id").attr("type","hidden").val(obj.data.id));
				//刷新select
				form.render("select");
			 	//关闭提示框
			 	layer.close(index);
			 	
			}, function(){
				$.post('deleteBill.action',obj.data,function(result){
					if(result.status==200){
						layer.msg("删除改行成功！");
						tableIns.reload();
					}else{
						layer.msg(result.msg);
					}
				});
				//关闭弹出层
			   layer.close(mainIndex);
			}
			,function(index){
				layer.close(index);
			}
		  );
		 
		});
	  
	  
	});
	
	
	
	
</script>
</body>
</html>
      