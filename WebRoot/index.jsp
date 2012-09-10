<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="jcwh" uri="http://edu.njit.jcwh" %>
<%	String path = request.getContextPath(); 
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>欢迎使用数控机床维护系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/base.css" rel="stylesheet" type="text/css" />
		<link href="css/index/frame.css" rel="stylesheet" type="text/css" />
		<link href="css/index/usercard.css" rel="stylesheet" type="text/css" />
		<script src="js/ui/jquery-1.6.2.js" type="text/javascript"></script>
		<script src="js/index.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function(){
				$(function() {
					setInterval(function(){
						$.getJSON("QueryUncheckRecords", null, function(data) {
							$("#count").html(data['count']);
							if(data['count']!=0){
								$("#newExp").show();
							}else{
								$("#newExp").hide();
							}
						//	test();
						});
					//	alert("五秒");
					},5000);
				});
			});
		</script>
	</head>
	<body onload="adjustPage()" onresize="adjustPage()" >
    <div id="container">
         <div id="header">
             <div id="logo">
               <h2><img src="images/logo_school.png"/></h2>
               <h3 ><img src="images/logo_jw.png" /></h3>
               <div id="rightMenu">
                 <div class="left" style="float:left"><img src="images/main_05.gif"/></div>
                 <div class="right">
                     <ul>
                         <li><a title="修改密码" href="bg/user/updatePW.jsp"><img src="images/pass.gif"/></a> </li>
                         <li><a title="用户信息" href="bg/user/userDetail.jsp"><img src="images/user.gif"/></a> </li>
                         <li><a title="退出系统" href="UserAction!quit.action"><img src="images/quit.gif"/></a> </li>
                     </ul>
                 </div>
               </div>
             </div>
             <div id="menu"> 
                <div id="l"><ul>
                    <li><a href="index.jsp" title="主页"><img src="images/main_13.gif"/></a></li>
                    <li><a href="javascript:history.go(-1);" title="后退"><img src="images/main_15.gif"/></a></li>
                    <li><a href="javascript:history.go(1);" title="前进"><img src="images/main_17.gif"/></a></li>
                    <li><a href="javascript:window.parent.location.reload();" title="刷新"><img src="images/main_19.gif"/></a></li>
                    <li><a href="#" title="帮助"><img src="images/main_21.gif"/></a></li>
                </ul></div>
                <div id="info">
                	<a id="author">By VikingBread</a>
                </div>
             </div>
             <div id="menufoot">
                <div style="background:url(images/main_28.gif);width:8px"></div>
                <div style="background:url(images/main_29.gif);width:147px">
                    <p class="style1">管理菜单</p>
                </div>
                <div><img src="images/main_30.gif"/></div>
                <jcwh:queryUncheckRecords/>
                <input type="hidden" id="uncheckRecord" value="${uncheckRecord }" />
                <div><p class="style1" style="cursor:default">当前登录用户:<a id="userInfo">${ sessionScope.user.name }</a>
                 &nbsp;&nbsp;&nbsp;			<a target="rightFrame" href="AlarmRecord!queryAllUncheckRecords.action"><span id="newExp" style="display:none" title="单击查看"><img id="mail" height="13px" src="images/mail.gif"/>&nbsp;检测到(<span id="count">${uncheckRecord}</span>)条新异常!</span></a></p></div>
                <div id="rightFoot"></div>
             </div>
         </div>
         <div id="main">
             <div id="left">
                <div><iframe src="left.jsp" frameborder="0" id="leftFrame" name="leftFrame"></iframe></div>
             </div>
              <div id="right"> 
              	<iframe src="right.jsp" frameborder="0" id="rightFrame" name="rightFrame"></iframe>
              </div>
              <div id="mainFoot">
              	<div class="leftBottom"><img src="images/main_71.gif"/></div>
              	<div class="rightBottom"></div>
              	<div class="centerBottom"></div>
              </div>
                         
         </div>
    </div>
    <div id="authorPanel" style="display:none">Author:Breadviking <br/> Email:breadviking@gmail.com</div>
    <div id="usercard" style="display:none">
    	<div class="uc-l">
    		<div class="pic"><img width="84px" height="84px" src="images/pic/user-priority-girl.gif" /></div>
    		<div class="username"><a href="#">${sessionScope.user.name}</a></div>
    		<div class="user-level"></div>
    	</div>
    	<div class="uc-r">
    		<div class="uc-items">
    			<div class="item">本次次登录ip:${ sessionScope.user.thisIp }</div>
    			<div class="item">上次登录ip:${ sessionScope.user.lastIp }</div>
    			<div class="item">真实姓名:${ sessionScope.user.truename }</div>
    			<div class="item">手机:${ sessionScope.user.phone }</div>
    			<div class="item">邮箱:${ sessionScope.user.email }</div>
    		</div>
    	</div>
    </div>
    <div id="rtlogo"><img height="40px" width="293px" src="images/skjc.png"/></div>
  </body>
</html>