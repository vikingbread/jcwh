<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>错误记录详细</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{
			margin:0;
			padding:0;
		}
		.info-card{
			margin:20px 0 0 20px; 
			overflow:hideen;
		}
		.pic{
			margin:5px 0 5px 10px;
			width:80px;
			height:80px;
			border:#CDD7D9 1px solid;
		}
		p{
			line-height:26px;
			margin:0;
			padding:0;
		}
		.info-label{
			float:left;
			width:75px;
			text-align:right;
			padding-right:16px;
		}
		.info-content{
   			padding-left: 0;
   			word-wrap: break-word;
   			display:block;
		}
		.info-list{
			color:#686868;
			list-style:none;
		}
		.info-list li{
			border-left:1px solid #CDD7D9;
			margin-top:30px 0 0 10px;
			float:left;
			width:310px;
			margin
		}
		.info-list h3{
			padding-left:5px;
			border-bottom: 1px solid #CDD7D9;
  			color: #000000;
  			font-size: 14px;
  			font-weight: 700;
  			line-height: 18px;
   			argin-bottom: 6px;
   			padding-bottom: 6px;
		}
	</style>
  </head>
  
  <body>
   	<div class="info-card">
   	<ul class="info-list">
   		<li>
   			<h3>基本信息</h3>
   			<div class="pic"><img height="80px" width="80px" src="images/machine/1.jpg"/></div>
	   		<p>
	   			<span class="info-label">错误编号:</span><span class="info-content">${record.id }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">机床编号:</span><span class="info-content">${record.machine.id }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">解决方案:</span><span class="info-content">${record.solution.id }</span>
	   		</p>
	   		
	   		<p>
	   			<span class="info-label">故障时间:</span><span class="info-content">${record.date }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">状态:</span><span class="info-content"><c:choose>
											<c:when test="${one.solved ==true}">以解决</c:when>
											<c:otherwise>未解决</c:otherwise>
										</c:choose></span>
	   		</p>
	   		<p>
	   			<span class="info-label">来自:</span><span class="info-content">${record.comeFrom }</span>
	   		</p>
   		</li>
   		<li>
   			<h3>操作人员信息</h3>
   			<div class="pic"><img height="80px" width="80px" src="images/pic/picw.jpg"/></div>
	   		<p>
	   			<span class="info-label">姓名:</span><span class="info-content">${record.machine.operator.name }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">性别:</span><span class="info-content">${record.machine.operator.sex }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">电话:</span><span class="info-content">${record.machine.operator.phone }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">居住地:</span><span class="info-content">${record.machine.operator.address }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">邮箱:</span><span class="info-content">${record.machine.operator.email }</span>
	   		</p>
   		</li>
   		<li>
   			<h3>工程师信息</h3>
   			<div class="pic"><img height="80px" width="80px" src="images/pic/MJ23.jpg"/></div>
	   		<p>
	   			<span class="info-label">姓名:</span><span class="info-content">${record.machine.engineer.name }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">性别:</span><span class="info-content">${record.machine.engineer.sex }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">电话:</span><span class="info-content">${record.machine.engineer.phone } </span>
	   		</p>
	   		<p>
	   			<span class="info-label">居住地:</span><span class="info-content">${record.machine.engineer.address }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">邮箱:</span><span class="info-content">${record.machine.engineer.email }</span>
	   		</p>
   		</li>
   	</ul>
	   		<p style="clear:both;margin:20px 0 0 20px;">
	   			<button style="display:block" onclick="javascript:history.go(-1);">返回</button>
	   		</p>
   	</div>
  </body>
</html>
