<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加机床</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="bg/css/form.css">

  </head>
  
  <body>
  	<div id="container">
  	<h3>手动添加一条记录：</h3>
    <form action="AlarmRecord!addRecord.action" method="post">
 		<input type="hidden" name="record.comeFrom" value="web页面"/>
    	<table>
    		<tr>
    			<td class="label"><div>机床编号:</div></td>
    			<td class="content"><div><input type="text"/ name="record.machine.id"></div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>异常编号:</div></td>
    			<td class="content"><div><input type="text"/ name="record.solution.id"></div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>发生时间:</div></td>
    			<td class="content"><div><input type="text"/ name="record.date"></div></td>
    			<td>格式如:2011-12-18 11:30:00</td>
    		</tr>
    		<tr>
    			<td><div class="label"></div><input id="submit" type="submit" value="确定"/></td>
    			<td><div class="content"></div><input type="reset" value="重置"/></td>
    		</tr>
    	</table>
    </form>
    </div>
  </body>
</html>
