<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="jcwh" uri="http://edu.njit.jcwh" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="bg/css/form.css">

  </head>
  
  <body>
  	<div id="container">
  	<h3>修改用户密码：</h3>
    <form action="UserAction!updatePW.action" method="post">
    	<table>
    		<tr>
    			<td class="label"><div>旧密码:</div></td>
    			<td class="content"><div><input type="text"/ name="oldPassword"></div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>新密码:</div></td>
    			<td class="content"><div><input type="text"/ name="newPassword"></div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>确认密码:</div></td>
    			<td class="content"><div><input type="text"/ name="rePassword"></div></td>
    		</tr>
    		<tr>
    			<td><div class="label"></div><input id="submit" type="submit" value="确定"/></td>
    			<td><div class="content"></div><input type="reset" value="重置"/></td>
    		</tr>
    	</table>
    </form>
    	<p style="clear:both;margin:20px 0 0 20px;">
	   			<button style="display:block" onclick="javascript:history.go(-1);">返回</button>
	   		</p>
    </div>
  </body>
</html>
