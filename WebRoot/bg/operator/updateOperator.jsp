<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
  	<h3>更新操作员信息：</h3>
    <form action="OperatorAction!update.action" method="post">
    	<input type="hidden" name="operator.id" value="${operator.id}"/>
    	<table>
    		<tr>
    			<td class="label"><div>姓名:</div></td>
    			<td class="content"><div><input type="text" name="operator.name" value="${operator.name}"/></div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>性别:</div></td>
    			<td class="content"><div>
										<select name="operator.sex">
											<option value="${operator.sex}">${operator.sex}</option>
											<option value="女">女</option>
											<option value="男">男</option>
										</select>
									</div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>电话</div></td>
    			<td class="content"><div><input type="text" name="operator.phone" value="${operator.phone}"/></div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>E-mail:</div></td>
    			<td class="content"><div><input type="text" name="operator.email" value="${operator.email}"/></div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>住址:</div></td>
    			<td class="content"><div><textarea name="operator.address" >${operator.address }</textarea></div></td>
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
