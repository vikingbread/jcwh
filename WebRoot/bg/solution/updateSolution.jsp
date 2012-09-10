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
  	<h3>更新解决方案：</h3>
    <form action="SolutionAction!update.action" method="post">
 		<input type="hidden" name="solution.alarmmodel" value="NC"/>
 		<input type="hidden" name="solution.id" value="${solution.id }"/>
 		<input type="hidden" name="solution.faultType" value="${solution.faultType }"/>
    	<table>
    		<tr>
    			<td class="label"><div>异常介绍:</div></td>
    			<td class="content"><div><textarea name="solution.alarmNumberExplanation">${solution.alarmNumberExplanation }</textarea> </div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>产生原因:</div></td>
    			<td class="content"><div><textarea name="solution.explanation">${solution.explanation} </textarea></div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>采样措施:</div></td>
    			<td class="content"><div><textarea name="solution.reaction">${solution.reaction }</textarea> </div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>解决方案:</div></td>
    			<td class="content"><div><textarea name="solution.solution">${solution.solution}</textarea> </div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>继续操作:</div></td>
    			<td class="content"><div><textarea name="solution.restart">${solution.restart }</textarea></div></td>
    		</tr>
    		<tr>
    			<td class="label"><div>故障等级:</div></td>
    			<td class="content"><div>
    									<select name="solution.grade">
    										<option value="${solution.grade}">${solution.grade}</option>
    										<option value="1">1</option>
    										<option value="2">2</option>
    										<option value="3">3</option>
    										<option value="4">4</option>
    										<option value="5">5</option>
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
