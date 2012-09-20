//显示未查看异常
$(function(){
	var uncheckRecord = $("#uncheckRecord").val();
	if(uncheckRecord!=0){
		$("#newExp").show();
	}
});
//自动调整页面
function adjustPage(){ 
    // var c_width = document.body.clientWidth;
     var c_height = document.body.clientHeight;
     var c_width = document.body.clientWidth;                   
     var main_height = c_height-160+"px";
     var left_frame = document.getElementById("left");
    // alert(c_width+":"+left_frame.style.width);
     left_frame.style.height = main_height;
     document.getElementById("right").style.width= c_width - 188 +"px";
     document.getElementById("right").style.height=  main_height;
  //   alert(main.clientHeight);
}
$(function(){
	var authorInfo = $("#info"); 
	var authorPanel = $("#authorPanel");
	authorInfo.mouseover(function(event){
		var myEvent = event||window.event;
		var width = document.body.clientWidth;
		var x = myEvent.clientX;
		if(x+authorPanel.width()>width){
			x = width - authorPanel.width()-20; 
		}
		authorPanel.css("left",x+"px").css("top",myEvent.clientY+"px").appendTo($(this)).show();					
	//	authorPanel.show();					
	});
	authorInfo.mouseout(function() {
		authorPanel.hide();
    });
});
$(function(){
	var userInfo = $("#userInfo"); 
	var usercard = $("#usercard");
	userInfo.mouseover(function(event){
		var myEvent = event||window.event;
		var width = document.body.clientWidth;
		var x = myEvent.clientX;
		if(x+usercard.width()>width){
			x = width - usercard.width()-20; 
		}
		usercard.css("left",x+"px").css("top",myEvent.clientY+"px").show();					
		//usercard.show();					
	});
	userInfo.mouseout(function() {
			usercard.hide();
	// alert(document.activeElement.id);
    });
});
//闪烁邮标
var flag;
var mail;
$(function(){
	flag = true;
	mail = $("#mail");
	setInterval(function(){
		if(flag){
			mail.css("visibility","hidden");
		}else{
			mail.css("visibility","visible");
		}
		flag=!flag;
	},500);
});

// correctly handle PNG transparency in Win IE 5.5 & 6.
function correctPNG()
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