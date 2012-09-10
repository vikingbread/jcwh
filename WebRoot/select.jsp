<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'select.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <s:form action="viewResult" target="frame">爱好：<hr>
    	<s:checkbox label="篮球" name="sports" fieldValue="basketball" labelposition="left"></s:checkbox>
  		<s:checkbox label="足球" name="sports" fieldValue="football" labelposition="left"></s:checkbox>
  		<s:checkbox label="羽毛球" name="sports" fieldValue="badminton" labelposition="left"></s:checkbox>
  		<s:checkbox label="橄榄球" name="sports" fieldValue="rugby" labelposition="left"></s:checkbox>
  		 
  		 <%--  		 
  		 <s:checkboxlist list="#{'basketball':'篮球','football':'足球' ,'rugby':'橄榄球'}" name="sport"></s:checkboxlist>
    --%>
    	<s:submit value="提交"></s:submit>
    </s:form>
    <iframe name="frame" width="400px" height="500px" frameborder="0" src="viewResult">
    </iframe>
  </body>
</html>
