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
    
    <title>更新机床信息</title>
    
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
    <form action="MachineAction!update.action" method="post">
    	<input type="hidden" name="machine.id" value="${machine.id }" />
    	<input type="hidden" name="machine.errorCount" value="${machine.errorCount }" />
    	<input type="hidden" name="machine.deleted" value="${machine.deleted }" />
    	<table>
    		<tr>
    			<td class="label"><div>操作员:</div></td>
    			<jcwh:operatorList/>
    			<td class="content"><div>
    									<select name="machine.operator.id">
										 <option  value="${machine.operator.id}">${machine.operator.name }</option>
											<c:forEach items="${operator}" var="one" varStatus="vs">
												<c:if test="${machine.operator.id !=one.id}">
												<option value="${one.id }">
													${one.name}
												</option>
												</c:if>
											</c:forEach>
										</select>
    								</div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>指导工程师:</div></td>
    			<jcwh:engineerList/>
    			<td class="content"><div>
    									<select name="machine.engineer.id">
										 <option  value="${machine.engineer.id}">${machine.engineer.name }</option>
											<c:forEach items="${engineer}" var="one" varStatus="vs">
												<c:if test="${machine.engineer.id !=one.id}">
												<option value="${one.id }">
													${one.name}
												</option>
												</c:if>
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
