<%@ page language="java" pageEncoding="UTF-8"%>
<% 	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/"; %>
<html lang="cn">
<head>
    <base href="<%=basePath%>"/>
	<title>jQuery UI Dialog - Modal form</title>
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
    <link rel="stylesheet" href="css/demos.css">
    <link rel="stylesheet" href="css/themes/jquery.ui.all.css">
	<style type="text/css">
		input.text { margin-bottom:12px; width:95%; padding: .4em; }
		fieldset { padding:0; border:0; margin-top:25px; }
		h1 { font-size: 1.2em; margin: .6em 0; }
		div#users-contain { width: 350px; margin: 20px 0; }
		div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
		div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
		.ui-dialog .ui-state-error { padding: .3em; }
		.validateTips { border: 1px solid transparent; padding: 0.3em; }
        #dialog-form{
            font-size:14px; 
        }
	</style>
	<script type="text/javascript" >
	$(function() {
		// a workaround for a flaw in the demo system (http://dev.jqueryui.com/ticket/4375), ignore!
		$( "#dialog:ui-dialog" ).dialog( "destroy" );

		var name = $( "#name" ),
            truename = $("#truename"),
			password = $( "#password" ),
            repassword = $("#repassword"),
            email = $( "#email" ),
			phone = $("#phone"),
			allFields = $( [] ).add( name ).add(truename).add(password)
                    .add( repassword ).add( email ).add(phone),
			tips = $( ".validateTips" );

		function updateTips( t ) {
			tips.text( t )
				.addClass( "ui-state-highlight" );
			setTimeout(function() {
				tips.removeClass( "ui-state-highlight", 1500 );
			}, 500 );
		}

        function checkEquals(obj,target){
            if(obj.val()!=target.val()){
                obj.addClass("ui-state-error");
                target.addClass("ui-state-error");
                updateTips( "密码不匹配，请检查！！！" );
				return false;
            }else{
                return true;
            }
        }

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

		$( "#dialog-form" ).dialog({
			autoOpen: false,
			height: 552,
			width: 347,
			modal: true,
			buttons: {
				"创建": function() {
					var bValid = true;
					allFields.removeClass( "ui-state-error" );

					bValid = bValid && checkLength( name, "用户名", 3, 16 );
					bValid = bValid && checkLength( password, "密码", 5, 16 );
                    bValid = bValid && checkLength( phone, "联系电话", 7, 14 );
					bValid = bValid && checkLength( email, "邮箱", 6, 80 );

					bValid = bValid && checkRegexp( name, /^[a-z]([0-9a-z_])+$/i, "用户名必须由 ‘a-z, 0-9, _’ 组成" );

					// From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
					bValid = bValid && checkRegexp( email, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "例如. ui@jquery.com" );

					bValid = bValid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "密码只允许使用 : a-z 0-9" );
                    bValid = bValid && checkRegexp(phone,/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/, "联系号码不能包含特殊字符" );

                    bValid = bValid && checkEquals( password ,repassword );

					if ( bValid ) {
//						$( "#users tbody" ).append( "<tr>" +
//							"<td>" + name.val() + "</td>" +
//							"<td>" + email.val() + "</td>" +
//							"<td>" + password.val() + "</td>" +
//						"</tr>" );
						$( this ).dialog( "close" );
					}
				},
				"取消": function() {
					$( this ).dialog( "close" );
				}
			},
			close: function() {
				allFields.val( "" ).removeClass( "ui-state-error" );
			}
		});

		$( "#create-user" )
			.button()
			.click(function() {
				$( "#dialog-form" ).dialog( "open" );
			});
	});
	</script>
</head>
<body>

<div class="demo">

<div id="dialog-form" title="注册用户" >
	<p class="validateTips">带'*'的栏目为必填项</p>

	<form>
	<fieldset>
		<label for="name">用户名*</label>
		<input type="text" name="name" id="name" class="text ui-widget-content ui-corner-all" />
		<label for="email">真实姓名</label>
		<input type="text" name="email" id="truename" value="" class="text ui-widget-content ui-corner-all" />
		<label for="password">密码*</label>
		<input type="password" name="password" id="password" value="" class="text ui-widget-content ui-corner-all" />
		<label for="password">确认密码*</label>
		<input type="password" name="password" id="repassword" value="" class="text ui-widget-content ui-corner-all" />
		<label for="password">联系电话*</label>
		<input type="text" name="password" id="phone" value="" class="text ui-widget-content ui-corner-all" />
		<label for="email">电子邮箱*</label>
		<input type="text" name="email" id="email" value="" class="text ui-widget-content ui-corner-all" />
	</fieldset>
	</form>
</div>


<div id="users-contain" class="ui-widget" style="diplay:none">
	<h1>用户：</h1>
	<table id="users" class="ui-widget ui-widget-content">
		<thead>
			<tr class="ui-widget-header ">
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>John Doe</td>
				<td>john.doe@example.com</td>
				<td>johndoe1</td>
			</tr>
		</tbody>
	</table>
</div>
<button id="create-user" >创建新用户</button>

</div><!-- End demo -->



<div class="demo-description">
<p>Use a modal dialog to require that the user enter data during a multi-step process.  Embed form markup in the content area, set the <code>modal</code> option to true, and specify primary and secondary user actions with the <code>buttons</code> option.</p>
</div><!-- End demo-description -->

</body>
</html>
