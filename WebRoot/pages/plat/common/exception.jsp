<%@page import="com.upath.plat.common.exception.PlatformException"%>
<%@page import="org.springframework.transaction.CannotCreateTransactionException"%>
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
 <c:set var="e" value="${exception}"></c:set>
 <%
 	Object e = pageContext.getAttribute("e");
	if(e != null){
		if(e instanceof CannotCreateTransactionException){
			Exception exception = (Exception)e;
			exception.printStackTrace();
			request.setAttribute("errorMsg", "无法连接数据库");
		}else if(e instanceof PlatformException){
			Exception exception = (Exception)e;
			exception.printStackTrace();
			request.setAttribute("errorMsg", exception.getMessage());
		}else if(e instanceof Exception){
			Exception exception = (Exception)e;
			exception.printStackTrace();
		} else{
			System.out.println(e);
		}
		
		String msg = e.toString();
		if(msg.indexOf("invalid.token") > -1){
			request.setAttribute("errorMsg", "系统不允许重复提交");
		}else{
			
		}
	}
	
	
 %>
 
 
 <div class="safe_cont">
    <div class="create_notice">
    		<table border="0" align="center" cellpadding="5" cellspacing="5" height="280">
              <tr>
                <td align="center" style=" padding:20px;"><img src="${ctx }/skins/common/msgFalse1.gif" width="60" height="60" /></td>
                <td align="center"><p>&nbsp;</p>
                <table border="0" cellspacing="5" cellpadding="5" width="100%">
                  <tr>
                    <td align="center" style="font-size:16px; "><p style="color:#093; font-size:20px; font-weight:bold; margin-bottom:20px;">操作出现异常</p>
                    <p>服务器处理时，出现了错误${errorMsg } </p></td>
                  </tr>
                </table>
                <table border="0" cellspacing="0" cellpadding="0" style="margin-top:20px;">
                  <tr>
                    <td align="center" class="page-back-now" ><a href="javascript:void(0);" class="tablelink"  onClick="goback('${menuId}')"> 返回 </a></td>
                  </tr>
                </table></td>
              </tr>
      </table>
  </div>
</div>
<div style="display: none;">
<s:property value="exception.message"/>
<s:property value="exceptionStack"/>
</div>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>