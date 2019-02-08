<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-10-21 21:39:38
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
var dlg;
function  opreate(args,opCode){
	var baseUrl = "${ctx}/pages/plat/auth/selectMenu.jsp";
	if('select' === opCode){
		if(dlg && dlg.closed == false){
			dlg.show();
		}else{
			dlg = 	$.dialog({
				lock : true,
				max : false,
				min : false,
				title : '选择菜单',
				width : '360px',
				height : '460px',
				content : 'url:' + baseUrl
			}
			);
		}
		
		
	}else if('delete' === opCode){
		
	}else if('clear' === opCode){
				$("#pcdid").val('');
				$("#pcdmc").val('');
	}
}






var imgDlg;
function  opreateIcon(args,opCode){
	var baseUrl = "${ctx}/pages/t_qas/layout/list_icon.jsp";
	if('select' === opCode){
		if(imgDlg && imgDlg.closed == false){
			imgDlg.show();
		}else{
			imgDlg = 	$.dialog({
				lock : true,
				max : false,
				min : false,
				title : '选择图标',
				width : '640px',
				height : '460px',
				content : 'url:' + baseUrl
			}
			);
		}
		
		
	}else if('clear' === opCode){
				$("#cdcs").val('');
				$("#imgDiv").empty();
	}
}


	window.initUserNode = function(args) {
		$("#pcdid").val(args.cdid);
		$("#pcdmc").val(args.cdmc);
	}
	
	window.initIcon = function(args) {
		$("#cdcs").val(args);
		var html = "<img src='${ctx}"+args+"' style='text-align:center;'>";
		$("#imgDiv").html(html);
	}
	
//-->
</script>
<body>
<s:form action="tRmsMenuinfo!save" namespace="/plat/auth" method="post" 
id="opForm" name="opForm">
<s:token></s:token>
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
<s:hidden name="bean.cdid" id="cdid"></s:hidden>
  <div class="editBlock" style="width: 100%;margin: 0;padding: 0;">
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >基本信息</td>
      </tr>
       <tbody>
       <tr>
       	   <th width="120"><span class="warning">*</span>所属系统：</th>
           <td>
           <select name="bean.xtid" id="xtid" class="select2">
          	<option value="">--请选择所属系统--</option>
          	<x:cache subject="SYSTEMS" option="true" selected="${bean.xtid}"/>
          	</select>
           <em class="valid" title="所属系统无能为空。" lang="n"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120">父级菜单：</th>
           <td>
           <s:hidden name="bean.pcdid" id="pcdid"></s:hidden>
           <input name="pcdmc" id="pcdmc" value="${pmenu.cdmc }" readonly="readonly" class="inputText">
           <input type="button" class="ibtn" value=" 选 择 " onclick="opreate('','select')" name="" id="">
           <input type="button" class="ibtn" value=" 清 空 " onclick="opreate('','clear')" name="" id="">
           </td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>菜单名称：</th>
           <td><s:textfield  name="bean.cdmc" cssClass="inputText" id="cdmc" maxlength="10" nullmsg="菜单名称不能为空" errormsg="菜单名称为控制在10以内个字符"/></td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>排序号：</th>
           <td>
           <s:textfield  name="bean.pxh" cssClass="inputText" id="pxh"/>
           <em  class="valid" title="排序号输入必须是数字类型。" lang="n"></em>
           </td>
        </tr>
       <tr>
          <th width="120">链接地址：</th>
          <td>
          <textarea class="textinput2" name="bean.ljdz" id="ljdz" maxlength="200"><x:escape value="${bean.ljdz }" escape="false"/></textarea>
           </td>
        </tr>
         <tr>
       	   <th width="120"><span class="warning">*</span>链接方式：</th>
           <td>
           <select name="bean.ljlx" id="ljlx" class="select2" style="width: 135px;">
          	<option value="">--请选择链接方式--</option>
          	<x:cache subject="LINKS"  option="true" selected="${bean.ljlx}"/>
          	</select>
           <em  class="valid" title="链接方式输入必须是数字类型。" lang="n"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>是否有效：</th>
           <td>
           	<select name="bean.sfyx" id="sfyx" class="select2" style="width: 135px;">
          	<option value="">--请选择是否有效--</option>
          	<x:cache subject="OPTION01"  option="true" selected="${bean.sfyx}"/>
          	</select>
           	<em  class="valid" title="是否有效是必须录入项" lang="n"></em>
           </td>
        </tr>
        <tr>
       	   <th width="120">关联角色：</th>
           <td>
           	<c:forEach var="map" items="${roleInfo }" varStatus="stat">
           		<c:set var="role" value="${map.key }"/>
           		<c:if test="${map.value eq '1' }">
           				<c:set value="checked" var="checked"/>
           		</c:if>
           		<input type="checkbox" name="bean.roleIds" ${checked } value="${role.roleId }">${role.roleName }
           		<c:set value="" var="checked"/>
           	</c:forEach>
           </td>
        </tr>
        
        </tbody>
       
        <tr>
        <td colspan="2" class="subtitle" >选填信息</td>
      	</tr>
      	 <tbody>
       <tr>
          <th width="120">图标：</th>
          <td>
          	<s:hidden name="bean.cdcs" id="cdcs"></s:hidden>
          	<div id="imgDiv" style="display: inline-block;width:65px; height:65px; background:#fafbfb; border-right:solid 1px #dbdbdb;border-bottom:solid 1px #dbdbdb;text-align: center;vertical-align: middle; ">
          		<c:if test="${not empty bean.cdcs }">
          			<img alt="" style="text-align:center;" src="${ctx }${bean.cdcs}">
          		</c:if>
          	</div>
            <input type="button" class="ibtn" value=" 选 择 " onclick="opreateIcon('','select')" name="" id="">
           <input type="button" class="ibtn" value=" 清 空 " onclick="opreateIcon('','clear')" name="" id="">
           </td>
        </tr>
      
        <tr>
          <th width="120">备注：</th>
          <td>
          <s:textarea name="bean.cdms" cssClass="textinput2"  id="cdms" maxlength="200"></s:textarea>
           </td>
        </tr>
       </tbody>
      <tr>
        <td colspan="2" class="toolbar">
          <input type="button" class="inputButton" onclick="$('#opForm').submit();" value=" 确 定 " />
          <input type="button"  class="cancel" value=" 返 回 " id="returnButton"/>
          &nbsp;&nbsp;</td>
      </tr>
    </table>
      </div>
</s:form>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
