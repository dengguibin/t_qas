<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2015-5-20 15:03:19
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">
<!--
	$(function(){
		if($("#changeState").val() == '1'){
			if(frameElement && frameElement.api){
				var api = frameElement.api, W = api.opener; 
				api.hide();
				W.opreate('','query');
			}
		}
	});
	
	function changeBox(obj){
		if(obj.value != ''){
			var text  = $(obj).find("option:selected").text();
			var arr  = text.split('-');
			$("#name").val(arr[0]);
		}
		
	}
//-->
</script>
<body>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/plat/auth/tRmsMenufunc!save.action" method="post">
			<s:hidden name="menuId" id="menuId"/>
			<s:hidden name="bean.funcid" id="funcid"/>
			<s:hidden name="bean.cdid" id="cdid"/>
			<input type="hidden" id="changeState" value="${changeState }">
			<!-- 令牌环，防止重复提交 -->
			<s:token></s:token>
		<div class="formtitle"><span>${menu.menuName }功能信息</span></div>	
		<table>
       <tbody>
        <th width="120">权限代码：<span class="warning">*</span></th>
           <td>
            <select class="select2" name="bean.code" onchange="changeBox(this);"  datatype="*" nullmsg="请选择权限代码" >
                 	<option value=''>--请选择--</option>
				    <c:forEach var="item" items="${perms }">
				    	<option value="${item.id }" ${ item.id eq bean.code ? 'selected' : ''  } >${item.name }-[${item.id }]</option>
				    </c:forEach>
			</select>
        </tr>
       
        <tr>
       	   <th width="120">功能名称：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="25"  id="name" name="bean.name"  value="${bean.name}" datatype="s2-20" errormsg="功能名称长度在2到20个字符长度" nullmsg="请填写功能名称"  maxlength="20" /></td>
        </tr>
       <tr>
       	  
       <tr>
          <th width="120">功能连接地址：<span class="warning">*</span></th>
          <td>
                <textarea id="url"  maxlength="250" name="bean.url" class="textinput2" 
                datatype="*2-200" errormsg="功能连接地址长度在2到200个字符长度" nullmsg="请写功能连接地址"  maxlength="200"
                >${bean.url}</textarea>
           </td>
        </tr>
       <tr>
       	   <th width="120">功能描述：</th>
           <td><input type="text" class="inputText"  maxlength="200"  id="descrip" name="bean.descrip"  value="${bean.descrip}"  /></td>
        </tr>
	    <tr>
        <td colspan="2" class="toolbar">
        <input type="button" class="inputButton" onclick="$('#opForm').submit();" value=" 确 定 " />
        </td>
      	</tr>
	   
       </tbody>
    </table>
         </form>
  </div><!--editblock end-->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
