<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx}/scripts/plugins/fusioncharts/fusioncharts.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/fusioncharts/themes/fusioncharts.theme.fint.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/portlets/interface.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/portlets/config.js"></script>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<link href="${ctx}/scripts/plugins/portlets/portlets.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
function save(){
	var data="";
	$("#columns").children().children().children().each(function(i,v){
		var id = $(v).attr("id");
		var row="";
		$(v).children().each(function(j,k){
			var rowVal = $(k).attr("id");
			row+=rowVal+"@1#";
		});
		data+=",{'column':'"+id+"','row':'"+row+"'}";
	});
	var colData="["+data.substring(1)+"]";
	$("#columnData").val(colData);
	$("#opForm").submit();
}

function toDefault(){
	$("#opForm").attr("action","${ctx}/auth/rolePortlets/todefaultUserPortlets.action");
	$("#opForm").submit();
}
function switchToNext(obj){
	$(obj).css("display","none");
	$(obj).next().css("display","");
	$(obj).parent().parent().attr("ishow","1");
}
function switchToPrv(obj){
	$(obj).css("display","none");
	$(obj).parent().parent().attr("ishow","0");
	$(obj).prev().css("display","");
}
function remove(obj){
	var row=$(obj).parent().parent().parent();
	$("#columnData").val(row.attr("id"));
	$.post("${ctx}/auth/rolePortlets/hiddenUserPortlets.action",$("#opForm").serialize(),function(result){
		if(result.MSG=="TRUE"){
			row.remove();
		}else{
			$.dialog.alert('操作失败!');
		}
	},"json");
	
}



function openWin(urls){
	var baseUrl =urls;
	var api=$.dialog({
		lock: true, 
		max: false, 
		min: false ,
		title:"模块列表",
		width:'700px',
		height:'420px',
		content: 'url:'+baseUrl,
		ok:function(){
			var chackObj=$(this.iframe).contents().find("body").find("[id='moduleId']:checked");
			var columnId=$(this.iframe).contents().find("body").find("#columnId").val();
			var data="";
			chackObj.each(function(i,v){
				var rowVal = $(v).val();
				data+=","+rowVal;
				
			});
			if(data!=""){
				$("#columnData").val(data.substring(1));
				$("#columnId").val(columnId);
				$("#opForm").attr("action","${ctx}/auth/rolePortlets/updateUserPortlets.action");
				$("#opForm").submit();
			}
	    },
		okVal:"确定",
		close :	function(){
			//更新下消息数据
		}
	});

}


</script>

<style>
td{}
.test{height: 290px;border: solid 1px #d3dbde;}
</style>
<body>
	<div class="title">
    <span>当前位置：</span><x:menu menuId="${param.menuId}"/>
    </div>
 <div class="dataGrid">
 <form action="${ctx}/auth/rolePortlets/saveUserDevPortlets.action" enctype="multipart/form-data"  method="post" id="opForm" name="opForm">
    <s:hidden name="menuId" id="menuId" />
    <input type="hidden" name="proId" id="proId" value="${proId}" />
    <input type="hidden" name="columnId" id="columnId" value="${columnId}" />
    <input type="hidden" name="columnData" id="columnData"  />
    <!-- 令牌环，防止重复提交 -->
	<s:token></s:token>
</form>
<table cellspacing="0" id="columns" style="width: 100%;table-layout: fixed;" >
	<tr >
		<c:forEach items="${columnList }" var ="columnMap">
			<c:set var="columnId" value='${columnMap["id"]}' />
			<c:set var="columnStyle" value='${columnMap["style"]}' />
			<td style="${columnStyle}" id='${columnId }' >
					<c:forEach items='${rowMapList[columnId] }' var="rowMap">
						<c:set var="rowMapRef" value='${rowMap["ref"]}' />
						<c:set var="sfyx" value='${rowMap["sfyx"]}' />
						<c:set var="resultVal" value='${resultMap[rowMapRef]}' />
						<c:if test="${sfyx==1}">
							<div class="portlet" id='${rowMapRef }'>
								 <div class="listtitle"  >
								 <span class="more1">
								 <a  class="tablelink" onclick="remove(this)"  >更多>></a>
								 </span>
										 ${resultVal["title"]}
								 </div>
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
						</c:if>
					</c:forEach>
			</td>
		</c:forEach>	
	</tr>

	</table><!-- /#columns -->
	</div>


 		
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>