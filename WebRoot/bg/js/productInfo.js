
//operatorPanel
var operators , engineers;
$(function(){
	operators = $(".operator");
	operators.mouseover(function(event) {
       var operatorNode = $(this);
       var operatorName = operatorNode.children("span").text();
       var operator = operators[operatorName];
       if(operator == null){
       $.getJSON("OperatorInfo", { "name": encodeURI(operatorName,"utf-8")},
				 function(data){
    			   operators[operatorName] = data;
    			   updateInfoPanel(data);
				 });
		}else{
			updateInfoPanel(operators[operatorName]);
		}
       operatorNode.css("text-decoration","underline");
       var myEvent = event||window.event;
       //控制位置
      // $("#operaterPanel").css("left",myEvent.clientX+"px").css("top",myEvent.clientY+"px");
       //显示
       var infoPanel=$("#infoPanel");
       infoPanel.css("margin-left",operatorNode.width()/2+'px').appendTo($(this)).show();
       operatorNode.mouseout(function() {
			operatorNode.css("text-decoration","none");
			infoPanel.hide();
		});
    });
});	
function updateInfoPanel(info){
	var nameNode = $("#infoname").children("span");	
	var noNode = $("#No").children("span");	
	var phoneNode = $("#phone").children("span");	
	var addrNode = $("#address").children("span");	
	var emailNode = $("#email").children("span");	
	nameNode.html(info['name']);
	noNode.html(info['id']);
	phoneNode.html(info['phone']);
	addrNode.html(info['address']);
	emailNode.html(info['email']);
}
//engineerPanel
$(function(){
	engineers = $(".engineer");
	engineers.mouseover(function(event) {
       var engineerNode = $(this);
       var engineerName = engineerNode.children("span").text();
       var engineer = engineers[engineerName];
       if(engineer == null){
       $.getJSON("EngineerInfo", { "name": encodeURI(engineerName,"utf-8")},
				 function(data){
    	   			engineers[engineerName] = data;
				    updateInfoPanel(data);
				 });
		}else{
			updateInfoPanel(engineers[engineerName]);
		}
       engineerNode.css("text-decoration","underline");
       var myEvent = event||window.event;
       //控制位置
      // $("#operaterPanel").css("left",myEvent.clientX+"px").css("top",myEvent.clientY+"px");
       //显示
       var infoPanel=$("#infoPanel");
       infoPanel.css("margin-left",engineerNode.width()/2+'px').appendTo($(this)).show();
       engineerNode.mouseout(function() {
    	   engineerNode.css("text-decoration","none");
			infoPanel.hide();
		});
    });
});	
