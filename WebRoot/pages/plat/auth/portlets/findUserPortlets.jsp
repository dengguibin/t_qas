<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx}/scripts/plugins/fusioncharts/fusioncharts.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/fusioncharts/themes/fusioncharts.theme.fint.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/portlets/jquery-ui.js"></script>
<link href="${ctx}/scripts/plugins/portlets/portlets.css" rel="stylesheet" type="text/css" />



<style>
td{}
.test{height: 290px;border: solid 1px #d3dbde;}
</style>
<body>
	<div class="title">
    <span>当前位置：</span><x:menu menuId="${param.menuId}"/>
    </div>
 <div class="dataGrid">
 <div class="itab tabson">
  	<ul> 
 	<c:set var="selected">class="selected"</c:set> 
 	<c:forEach items="${ projectAttrList}" var="project">
    	<li><a href='${ctx}/auth/rolePortlets/findUserPortlets.action?menuId=${param.menuId}&proId=${project["id"]}'  ${proId eq project["id"] ?  selected : '' }>${project["name"] }</a>
 	</c:forEach>
  	</ul>
</div> 
</div>
 <div class="dataGrid">
 <form action="${ctx}/auth/rolePortlets/findUserPortlets.action"   enctype="multipart/form-data"  method="post" id="opForm" name="opForm">
    <s:hidden name="menuId" id="menuId" />
    <input type="hidden" name="proId" id="proId" value="${proId}" />
</form>
<table cellspacing="0" id="columns" style="width: 100%;table-layout: fixed;" >
	<tr >
		<c:forEach items="${columnList }" var ="columnMap">
			<c:set var="columnId" value='${columnMap["id"]}' />
			<c:set var="columnStyle" value='${columnMap["style"]}' />
			<td  class="columns" style="${columnStyle}" id='${columnId }' >
					<c:forEach items='${rowMapList[columnId] }' var="rowMap">
						<c:set var="rowMapRef" value='${rowMap["ref"]}' />
						<c:set var="resultVal" value='${resultMap[rowMapRef]}' />
						<div class="portlet" id='${rowMapRef }'>
							 <div class="listtitle"><a href='${resultVal["url"]}' class="more1">更多</a>${resultVal["title"]}</div>
					    	 <div id='mslineContainer_${rowMapRef}'>
					    	 	<c:choose>
					    	 		<c:when test='${resultVal["method"] eq "AJAX"}'>
					    	 			<script type="text/javascript">
							    	 		$(document).ready(function(){
							    	 			var url = "${ctx}/pages/plat/auth/portlets/NewFile.jsp";
							    	 			$.get(url,{},function(html){
							    	 				$("#mslineContainer"+"${rowMapRef}").html(html);
							    	 			});
							    	 		});
							    	 	</script>
					    	 		</c:when>
					    	 		<c:when test='${resultVal["method"] eq "INCLUDE"}'>
					    	 			<jsp:include page="/pages/plat/auth/portlets/NewFile.jsp"></jsp:include>
					    	 		</c:when>
					    	 	</c:choose>
					    	 
					    	 </div> 
						</div>
					</c:forEach>
			</td>
		</c:forEach>	
	</tr>

	</table><!-- /#columns -->
	</div>
	<table style="width:100%" >
		<tr  >
		<td colspan="${fn:length(columnList)}" style="text-align:center" >
		<input type="button" onclick="toDev()"  class="inputButton" value="个性化配置" id="inputButton" />
		<!-- 
		<input type="button"  class="cancel" value=" 返 回 " id="returnButton" />
		 -->
		</td>
		</tr>
	</table>

<script type="text/javascript">
//统一进行门户拖动效果
$(function(){
	$(".columns").sortable({
		connectWith: ".columns",
		handle: ".listtitle",
		cancel: ".portlet-toggle",
		placeholder: "portlet-placeholder ui-corner-all"
	});
});

function toDev(){
	$.registerForm('opForm');
	$("#opForm").attr("action","${ctx}/auth/rolePortlets/findUserDevPortlets.action");
	$("#opForm").submit();
}
</script>
 		
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>