<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script language="javascript">
	$(function(){
    $('.safe_cont').css({'position':'absolute','left':($(window).width()-490)/2});
	$(window).resize(function(){  
    $('.safe_cont').css({'position':'absolute','left':($(window).width()-490)/2});
    })  
	});  
</script> 
<body>
<div class="safe_cont">
    <div class="create_notice">
    		<table border="0" align="center" cellpadding="5" cellspacing="5" height="280">
              <tr>
                <td align="center" style=" padding:20px;"><img src="${ctx }/skins/common/msgSuccess1.gif" width="60" height="60" /></td>
                <td align="center"><p>&nbsp;</p>
                <table border="0" cellspacing="5" cellpadding="5" width="100%">
                  <tr>
                    <td align="center" style="font-size:16px; "><p style="color:#093; font-size:20px; font-weight:bold; margin-bottom:20px;">保存成功</p></td>
                    </tr>
                    <tr>
                    <td nowrap="nowrap">系统将在<span id="span_dt_dt"  style="font-weight:bold;padding:0 4px;color:#ff0000 ;display: inline-block;" ></span>秒后自动返回...</td>
                  </tr>
                </table>
                <table border="0" cellspacing="0" cellpadding="0" style="margin-top:20px;">
                  <tr>
                    <td align="center" class="page-back-now" ><a href="javascript:void(0);" class="tablelink" onclick="goback('${param.menuId}')" > 立即返回 </a>
</td>
                    <td width="20"></td>
                    <td align="center" class="page-back"><a href="javascript:void(0);" onClick="history.back()" > 返回上层 </a>
</td>
                  </tr>
                </table></td>
              </tr>
      </table>
  </div>
</div>
  <SCRIPT language=javascript> 
				<!-- 
				//document.write(""); 
				var mm=6;
				function show_date_time(){ 
				if(mm>0){
				window.setTimeout("show_date_time()", 1000); 
				mm=mm-1;
				}
				span_dt_dt.innerHTML= mm ; 
				} 
				show_date_time(); 
				
				setTimeout("goback(${param.menuId});",5000);
				
				//--> 
		</SCRIPT>
     
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>