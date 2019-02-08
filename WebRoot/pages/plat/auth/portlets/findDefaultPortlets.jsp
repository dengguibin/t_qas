<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2015-5-21 13:54:09
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>

<style type="text/css">
<!--
	.overul i{
		width: 33%;
	    display: block;
	    float: left;
	    font-style: normal;
	    text-indent:11px;
	    line-height:20px;
	}
	.overul2 i{
		width: 50%;
	    display: block;
	    float: left;
	    font-style: normal;
	    text-indent:11px;
	    line-height:20px;
	}
-->
</style>
<script type="text/javascript">
<%
Object obj=request.getAttribute("code");
if(obj!=null){
	String code=(String)obj;
	if(code.equals("200")){
		%>$.dialog.alert("保存成功！");<%
	}
	if(code.equals("400")){
		%>$.dialog.alert("保存失败！");<%
	}
}
%>
<!--
	//下拉输入的效果	
	$(function(){
	  $('#select9').select2({
	  	 /* tags: "true" 如果要输入*/
	  });
	  $('.receivers').select2({
		  tags: false
	});
	})
	
	function enable(obj){
		var imgtype="";
		var flag_input=$(obj).prev();//前面隐藏的判断是否启用的input
		var flag_input_value=$(flag_input).val();
		if(flag_input_value==0){//当前等于0，说明要启用
			imgtype="ok";
			$(obj).attr("title","停用");
			$(obj).text("停用");
			$(flag_input).val(1);
		}
		if(flag_input_value==1){//当前等于1，说明要停用
			imgtype="no";
			$(obj).attr("title","启用");
			$(obj).text("启用");
			$(flag_input).val(0);
		}
		$(obj).parent().prev().html("<span><img src='${ctx }/skins/uimaker/images/"+imgtype+".png' style='width:18px;height:18px'/></span>");
	}
	function show(){
		$.registerForm('opForm');
		$("#opForm").attr("action","${ctx}/auth/rolePortlets/showDefaultPortlets.action");
		$("#opForm").submit();
	}
	
//-->
</script>
<body>
<!-- 权限查询 -->
 <x:qx var="qx" menuId="${param.menuId}"></x:qx>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<div class="dataGrid">	
<div class="itab tabson">
  	<ul> 
 	<c:set var="selected">class="selected"</c:set> 
 	<c:forEach items="${ projectAttrList}" var="project">
    	<li><a href='${ctx}/auth/rolePortlets/findDefaultPortlets.action?menuId=${param.menuId}&proId=${project["id"]}'  ${proId eq project["id"] ?  selected : '' }>${project["name"] }</a>
 	</c:forEach>
  	</ul>
</div> 
<form action="${ctx}/auth/rolePortlets/findDefaultPortlets.action"   enctype="multipart/form-data"  method="post" id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<input type="hidden" id="proId" name="proId" value="${proId }" />
	<input type="hidden" id="roleData" name="roleData"  />
	<!-- 令牌环，防止重复提交 -->
	<s:token></s:token>
		<div class="tools">
			<ul class="toolbar" style="margin-top: 8px;">
				<c:if test="${qx.update }">
					<input onclick="save()" type="button" name="button" class="inputButton" value="保 存">
					<li class="click" onclick="show();"><span><img
							src="${ctx }/skins/uimaker/images/ico06.png"  style="width:24px;height:24px"/></span>预 览</li>
				</c:if>
	        </ul>
		</div><!--tools end-->
		<!-- 
		<div style="margin-bottom:10px;"><font style="font-size:13px;font-weight:900;">安全事件告警策略配置</font></div>
		 -->
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
              	<th width="50">序号</th>
                <th width="25%">名称</th>
                <th width="10%">可移动</th>
                <th width="10%">可查看</th>
                <th width="10%">可关闭</th>
                <th width="15%">加载方式</th>
                <th width="35%">选择角色</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:set var="e_num" value="0" />
            <c:forEach items="${rowList}" var="item"  varStatus="stat">
            		<tr id="moduleTr">
            			
            			<td>&nbsp;${stat.count }<input type="hidden" value='${ item["ref"]}' name ="moduleId" id="moduleId"/>  </td>
	            		<td>&nbsp;<a class="link" href='${resultMap[item["ref"]]["url"]}'>${resultMap[item["ref"]]["title"]}</a></td>
	            		<td>
	            		${item["movable"]=="true"?"是":"否" }
	            		</td>
	            		<td>
	            		${item["show"]=="true"?"是":"否"  }
	            		</td>
	            		<td>
	            		${item["closed"]=="true"?"是":"否"  }
	            		</td>
	            		<td>
	            		${resultMap[item["ref"]]["method"]}
	            		</td>
	            		<td>
	            			<select class="receivers"  id="role" style="width:90%;" multiple="multiple" >
	            			<c:set var ="roleIds" value='${roleModuleMap[item["ref"]]}'></c:set>
				           		<option value="">--请选择--</option>
				           		<c:forEach items="${roles }" var="role">
				           			<option value="${role.roleId }" ${fn:contains(roleIds,role.roleId)? 'selected' : '' }>${role.roleName }</option>
				           		</c:forEach>
				           </select>
	            		</td>
            		</tr>
            </c:forEach>
            </tbody>
          </table>
</form>
</div><!-- dataGrid end -->
<script type="text/javascript">
function save(){
	var data="";
	$("[id='moduleTr']").each(function(i,v){
		var roles =$(v).find("#role").val();
		if(roles!=null){
			var roleStr="";
			$(roles).each(function(i,v){
				roleStr+=$.trim(v)+"#";
			});
		   var moduleId =$(v).find("#moduleId").val();
		   data+=",{\"roles\":\""+roleStr+"\",\"moduleId\":\""+moduleId+"\"}";
		}
	});
	data="["+data.substring(1)+"]";
	$("#roleData").val(data);
	$("#opForm").attr("action","${ctx}/auth/rolePortlets/saveRolePortlets.action");
	$("#opForm").submit();
}
</script>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
