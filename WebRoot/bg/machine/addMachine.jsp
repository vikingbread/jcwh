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
  	<h3>添加新机床：</h3>
    <form action="MachineAction!addMachine.action" method="post">
    	<table>
    		<tr>
    			<td class="label"><div>机床编号:</div></td>
    			<td class="content"><div><input type="text"/ name="machine.id"></div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>指导工程师:</div></td>
    			<jcwh:engineerList/>
    			<td class="content"><div>
    									<select name="machine.engineer.id">
										 <option  value="1">请选择.</option>
											<c:forEach items="${engineer}" var="one" varStatus="vs">
												<option value="${one.id }">
													${one.name}
												</option>
											</c:forEach>
										</select>
									</div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>操作员:</div></td>
    			<jcwh:operatorList/>
    			<td class="content"><div>
    									<select name="machine.operator.id">
										 <option  value="1">请选择.</option>
											<c:forEach items="${operator}" var="one" varStatus="vs">
												<option value="${one.id }">
													${one.name}
												</option>
											</c:forEach>
										</select>
    								</div></td>
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
