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
		<base href="<%=basePath%>">

		<title>欢迎使用数控机床维护系统！请先登录</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="css/demos.css">
   		<link rel="stylesheet" href="css/themes/jquery.ui.all.css">
		<link href="css/login.css" rel="stylesheet" type="text/css" />
		<link href="css/base.css" rel="stylesheet" type="text/css" />
		<script src="js/ui/jquery-1.6.2.js" type="text/javascript"></script>
		<script src="js/ui/jquery.bgiframe-2.1.2.js" type="text/javascript"></script>
		<script src="js/ui/jquery.ui.core.js" type="text/javascript" ></script>
		<script src="js/ui/jquery.ui.widget.js" type="text/javascript"></script>
		<script src="js/ui/jquery.ui.mouse.js" type="text/javascript"></script>
		<script src="js/ui/jquery.ui.button.js" type="text/javascript"></script>
		<script src="js/ui/jquery.ui.draggable.js" type="text/javascript"></script>
		<script src="js/ui/jquery.ui.position.js" type="text/javascript"></script>
		<script src="js/ui/jquery.ui.resizable.js" type="text/javascript"></script>
		<script src="js/ui/jquery.ui.dialog.js" type="text/javascript"></script>
		<script src="js/ui/jquery.effects.core.js" type="text/javascript"></script>
		
		<script language="javascript">
			function correctPNG() // correctly handle PNG transparency in Win IE 5.5 & 6.
			{
			    var arVersion = navigator.appVersion.split("MSIE")
			    var version = parseFloat(arVersion[1])
			    if ((version >= 5.5) && (document.body.filters))
			    {
			       for(var j=0; j<document.images.length; j++)
			       {
			          var img = document.images[j]
			          var imgName = img.src.toUpperCase()
			          if (imgName.substring(imgName.length-3, imgName.length) == "PNG")
			          {
			             var imgID = (img.id) ? "id='" + img.id + "' " : ""
			             var imgClass = (img.className) ? "class='" + img.className + "' " : ""
			             var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' "
			             var imgStyle = "display:inline-block;" + img.style.cssText
			             if (img.align == "left") imgStyle = "float:left;" + imgStyle
			             if (img.align == "right") imgStyle = "float:right;" + imgStyle
			             if (img.parentElement.href) imgStyle = "cursor:hand;" + imgStyle
			             var strNewHTML = "<span " + imgID + imgClass + imgTitle
			             + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";"
			             + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader"
			             + "(src=\'" + img.src + "\', sizingMethod='scale');\"></span>"
			             img.outerHTML = strNewHTML
			             j = j-1
			          }
			       }
			    }
			}
			window.attachEvent("onload", correctPNG);
		</script>
		<script language="javascript">
			var name,password,allFields,tips;
			window.onload = function (){				
				document.getElementById("name").focus();
			};
			
			function checkLength( o, n, min, max ) {
				if ( o.val().length > max || o.val().length < min ) {
					o.addClass( "ui-state-error" );
					updateTips( n + "的长度必须在" +
						min + "和 " + max + "之间." );
					return false;
				} else {
					return true;
				}
			}
	
			function checkRegexp( o, regexp, n ) {
				if ( !( regexp.test( o.val() ) ) ) {
					o.addClass( "ui-state-error" );
					updateTips( n );
					return false;
				} else {
					return true;
				}
			}
			
			function updateTips( t ) {				
				tips.text( t )
					.addClass( "ui-state-highlight" );
				setTimeout(function() {
					tips.removeClass( "ui-state-highlight", 1500 );
				}, 500 );
			}
			function val_form(){
				var bValid = true;
				$("#waitImg").css("visibility","visible");
				updateTips("稍等处理中!");
				$("body").css("cursor","wait!important");
				allFields.removeClass( "ui-state-error" );

				bValid = bValid && checkLength( name, "用户名", 3, 16 );
				bValid = bValid && checkLength( password, "密码", 4, 16 );

				bValid = bValid && checkRegexp( name, /^[a-z]([0-9a-z_])+$/i, "用户名必须由 ‘a-z, 0-9, _’ 组成" );
				bValid = bValid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "密码只必须由‘a-z, 0-9’  组成");
				if(bValid){
					$.ajaxSettings.async = false;
					var ret;
					$.getJSON("Login", { "name": name.val(), "password": password.val() },
						 function(data){
						   ret = data['ret'];
						   });
					$.ajaxSettings.async = true;
					 if(ret==true){
							updateTips( "登陆成功正在跳转!" );
							return true;
					   }else{
					    	updateTips("用户名或密码错误,请重试!");
					    	allFields.addClass( "ui-state-error" );
					    	$("#waitImg").css("visibility","hidden");
					    }
				}
				$("#waitImg").css("visibility","hidden");
				$("body").css("cursor","default");
				return false;
			}
		</script>
	<script type="text/javascript" >
		//var name,password,tips;
		$(function() {
	    	name = $( "#name" );
			password = $( "#pwd" );
			allFields = $( [] ).add( name ).add( pwd );
			tips = $( ".validateTips" );	
		});		
	</script>
	<script type="text/javascript">
		if(self!=top){
		top.location=self.location; //判断是否是最顶层，不是则将当前页设置为最顶层
		}
	</script>
		<%--
    <script type="text/javascript" src="https://getfirebug.com/firebug-lite-debug.js"></script> 
	--%>
	</head>
	<body>
			
			<div id="header">
				<h2>
					<img src="images/logo_school.png" />
				</h2>
				<h3>
					<img src="images/logo_jw.png" />
				</h3>
			</div>
			<div id="main">
				<div id="left">
					<img src="">
				</div>
				<div id="right">
				<form action="UserAction!login.action" method="post" id="login_form" onsubmit="return val_form()">
					<dl>
					<dd id="valtip"><div class="validateTips"></div><img id="waitImg" src="images/wait.gif" /></dd>
						<dt class="user">
							<label id="uname">
								用户名:
							</label>
						</dt>
						<dd>
							<input type="text" id="name" name="user.name" tabindex="1" />
						</dd>
						<dt></dt>
						<dt class="passw">
							<label id="upwd">
								密&nbsp;&nbsp;&nbsp;码:
							</label>
						</dt>
						<dd>
							<input type="password" id="pwd" name="user.password" tabindex="2" />
						</dd> 
						<dd>
							<input type="submit" id="sub" value="" tabindex="3" />							
							<input type="reset" id="res" value="" tabindex="4" />
						</dd> 						 
					</dl>
				</form>
				</div>
			</div>
			<div id="copyright"></div>
	</body>
</html>
