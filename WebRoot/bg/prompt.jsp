<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<SCRIPT language="JavaScript">
    function alertPrompt(){
        var flag = '${prompt}';
        if(flag == 1){
            alert('操作成功！');
            flag = 0;
        }else if(flag == 2){
            alert('操作失败！');
            flag = 0;
        }else{
        }
    }
    
    alertPrompt();
</SCRIPT>
