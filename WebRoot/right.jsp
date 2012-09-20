<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<link href="css/rightFrame.css"  rel="stylesheet"/>
		<script src="js/jquery.js" type="text/javascript"></script>
		<script src="js/rightFrame.js" type="text/javascript"></script>
	</head>
	<body>
		<div id="container">
			<iframe width="600px" height="500px" frameborder="0"
				src="RecordChart!viewRecent3M.action"></iframe>
		</div>
		<div id="infoPanel">
			现在是:<span id='now'>loading...</span><br />
		<p style="clear: both;white-space:nowrap">
			本月共发生
			<span class="number" id="thisM">0</span> 起异常，前三个月共计
			<span class="number" id="recent3M">0</span> 起，历史统计共
			<span class="number" id="history">0</span> 起。
		</p>
		</div>
	</body>
</html>
