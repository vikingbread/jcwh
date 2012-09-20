	//统计表
	$(function() {
		$.getJSON("AlarmRecordServlet", null, function(data) {
			$("#thisM").html(data['thisM']);
			$("#recent3M").html(data['recent3M']);
			$("#history").html(data['history']);
		});
	});
	get=function (id){return document.getElementById(id)}
	 if(document.all){
	     window.XMLHttpRequest=function(){
	         var get=['Microsoft.XMLHTTP','Msxml2.XMLHTTP'];
	   for(var i=0;i<get.length;i++){try{return new ActiveXObject(get[i])}catch(e){}};
	     };
	 }
	 //时间显示
	 webDate=function(fn){
	  var Htime=new XMLHttpRequest();
	  Htime.onreadystatechange=function(){Htime.readyState==4&&(fn(new Date(Htime.getResponseHeader('Date'))))};
	  Htime.open('HEAD', '/?_='+(-new Date));
	  Htime.send(null);
	 // alert(Htime);
	 }
	 var nowTime ;
	 webDate(function (webTime){
		  // get('now').innerHTML=time2String(time=webTime);
		   nowTime =  Date.parse(webTime)
		   updateTime();	
		  })
	 setInterval(function (){
		 	nowTime +=1000;
		 	updateTime();
		 },1000)
	  
	  function updateTime(){
		 get('now').innerHTML = new Date(nowTime).toLocaleString();
	 }