<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="jcwh" uri="http://edu.njit.jcwh" %>
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
	<jcwh:queryOneRecord/>
  	<div id="container">
  	<h3>更新记录记录：</h3>
    <form action="AlarmRecord!update.action" method="post">
    	<input type="hidden" value="${record.id }" name="record.id" />
    	<input type="hidden" value="${record.check }" name="record.check" /> 
    	<input type="hidden" value="${record.comeFrom }" name="record.comeFrom" />
    	<input type="hidden" value="${record.deleted }" name="record.deleted" />
    	<input type="hidden" value="${record.solved }" name="record.solved" />
    	<input type="hidden" value="${record.solved }" name="record.solved" />
    	<input type="hidden" value="${record.date }" name="record.date" />
    	<table>
    		<tr>
    			<td class="label"><div>机床编号:</div></td>
    			<td class="content"><div><input type="text" value="${record.machine.id}" name="record.machine.id"/></div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>异常编号:</div></td>
    			<td class="content"><div><input type="text" value="${record.solution.id}" name="record.solution.id"/></div></td>
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
