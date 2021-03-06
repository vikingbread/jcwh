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
			max-width:500px;
		}
		.info-label{
			float:left;
			width:75px;
			text-align:right;
			padding-right:16px;
			display: block;
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
			margin:0;
			padding-left:5px;
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
	   			<span class="info-label">错误编号:</span><span class="info-content">${solution.id }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">错误类型:</span><span class="info-content">${solution.alarmmodel }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">异常介绍:</span><span class="info-content">${solution.alarmNumberExplanation }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">错误原因:</span><span class="info-content">${solution.explanation }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">采取措施:</span><span class="info-content">${solution.reaction }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">解决方案:</span><span class="info-content">${solution.solution }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">继续操作:</span><span class="info-content">${solution.restart }</span>
	   		</p>
	   		<p>
	   			<span class="info-label">故障等级:</span><span class="info-content">${solution.grade }</span>
	   		</p>
   		</li>
   	</ul>
   	<p style="clear:both;margin:20px 0 0 20px;">
	   			<button style="display:block" onclick="javascript:history.go(-1);">返回</button>
	   		</p>
   	</div>
  </body>
</html>
