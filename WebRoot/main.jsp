<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>欢迎使用数控机床维护系统!</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/main.css" rel="stylesheet" type="text/css" />
        <link href="css/base.css" rel="stylesheet" type="text/css" />
	</head>
  <body>
    <div id="header">
             <h2><img src="images/logo_school.png"/></h2>
             <h3><img src="images/logo_jw.png"/></h3>
		</div>
  <div id="left"></div>
  <div id="right"> 
  </div>
  <div id="footer">
      <span>数控机床远程维护系统--自动化092班</span>
  </div>
  </body>
</html>