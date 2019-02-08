<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx}/scripts/plugins/fusioncharts/fusioncharts.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/fusioncharts/themes/fusioncharts.theme.fint.js"></script>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/portlets/jquery-ui.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/portlets/portlets-ext.js"></script>
<link href="${ctx }/scripts/plugins/treetable/css/jquery.treetable.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/scripts/plugins/portlets/jquery-ui.theme.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/scripts/plugins/portlets/jquery-ui.structure.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/scripts/plugins/treetable/css/jquery.treetable.theme.default.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/scripts/plugins/portlets/portlets.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/scripts/plugins/treetable/jquery.treetable.js"></script>
<style>
td{}
.test{height: 290px;border: solid 1px #d3dbde;}
li{
 overflow:hidden;
 text-overflow:ellipsis;
 white-space:nowrap
}
.ui-menu { width: 150px; }
ul.toolbar {margin-top: 3px;}
ul.toolbar li{margin-right: 6px;}
ul.toolbar span{margin-right: 0px;}
.dataGrid{
	padding: 8px;
}
</style>
<body>
	<div class="title" style="width:100%">
    <span>当前位置：</span><x:menu menuId="${param.menuId}"/> 
    <ul class="toolbar">
        <li class="click"><span><img title="所有模块"  onclick='openWin("${ctx}/auth/rolePortlets/findUserRowList.action?proId=${proId}&columnId=${columnId}")' style="width:24px;height:24px" src="${ctx }/skins/uimaker/images/t01.png" /></span></li>
        <li><span><img title="保存"   onclick="saverow()" style="width:24px;height:24px" src="${ctx }/skins/uimaker/images/ico04.png" /></span></li>
        <li class="click"><span><img title="恢复默认"   onclick="toDefault()" style="width:24px;height:24px" src="${ctx }/skins/uimaker/images/t05.png" /></span></li>
     </ul>
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
			<td  class="columns" style="${columnStyle}" id='${columnId }' >
					<c:forEach items='${rowMapList[columnId] }' var="rowMap">
						<c:set var="rowMapRef" value='${rowMap["ref"]}' />
						<c:set var="rowcount" value='${rowMap["rowcount"] }' />
						<c:set var="colcount" value='${rowMap["colcount"] }' />
						<c:set var="sfyx" value='${rowMap["sfyx"]}' />
						<c:set var="movable" value='${rowMap["movable"]}' />
						<c:set var="closed" value='${rowMap["closed"]}' />
						<c:set var="show" value='${rowMap["show"]}' />
						<c:set var="resultVal" value='${resultMap[rowMapRef]}' />
						<c:set var="divStyle" value='${resultVal["style"]}' />
						<c:choose>
							<c:when  test="${sfyx==1&&true==show}">
								<div rowcount='${rowcount}' style="${divStyle}" colcount='${colcount}' class='${false==movable?"portlet2 portlet2-state-disabled":"portlet"  }' id='${rowMapRef }' >
									 <div class="listtitle"  >
									 <span class="more1">
									 <c:if test="${true==closed  }">
									 	<a   onclick="removeRow('${rowMapRef }')"  >[隐藏]</a>
									 </c:if>
									 </span>
											${resultVal["title"]}
									 </div>
							    	 <div id='mslineContainer_${rowMapRef}'>
							    	 	<c:choose>
							    	 		<c:when test='${resultVal["method"] eq "AJAX"}'>
							    	 			<script type="text/javascript">
									    	 		$(document).ready(function(){
									    	 			var url = '${ctx}${resultVal["url"]}';
									    	 			$.get(url,{},function(html){
									    	 				$("#mslineContainer_${rowMapRef}").html(html);
									    	 			});
									    	 		});
									    	 	</script>
							    	 		</c:when>
							    	 		<c:when test='${resultVal["method"] eq "INCLUDE"}'>
							    	 			<jsp:include page='${resultVal["url"]  }'></jsp:include> 
							    	 		</c:when>
							    	 	</c:choose>
							    	 
							    	 </div> 
								</div>
							</c:when>
							<c:otherwise>
						<%-- 		<c:if test="${fn:contains(rowMapRef, '_showKK_')}">
									<c:set var="rowMapPid" value="${fn:split(rowMapRef, '_')[0]}"></c:set>
									<div followid="${rowMapPid }" id="${rowMapRef }"  style="height:100px;margin-bottom: 8px;" class="portlet2-state-disabled"  >
									</div>
								</c:if> --%>
							</c:otherwise>
						</c:choose>

					</c:forEach>
			</td>
		</c:forEach>	
	</tr>

	</table><!-- /#columns -->
	</div>
	<table style="width:100%" >
		<tr  >
		<td colspan="${fn:length(columnList)}" style="text-align:center" >
		
	<!-- 	<input type="button"  class="cancel" value=" 返 回 " id="returnButton" /> -->
		</td>
		</tr>
	</table>

	
<script type="text/javascript">
//统一进行门户拖动效果
$(document).ready(function(){
	$( "#menuid" ).menu();
	$(".columns").sortable({
		connectWith: ".columns",
		handle: ".listtitle",
		cancel: ".portlet2-state-disabled",
		placeholder: "portlet-placeholder ui-corner-all",
		start:function(event,ui){
			startMove(event,ui);
		},
		stop:function(event,ui){
			stopMove(event,ui);
		}
	});
	$(".portlet,.portlet2").resizable({
		autoHide:  false,
		handles: "e",
		grid: [50, 0] ,
		distance:50,
		stop:function(event,ui){
			stopresize(event,ui);
		},
		resize:function(event,ui){
			divresize(event,ui);
		}
	});
	$(".portlet,.portlet2").each(function(i,v){
		var colcount=$(v).attr("colcount");
		var rowcount=$(v).attr("rowcount");
		if(1 < colcount || 1 < rowcount ){
			loadDiv($(v),colcount,rowcount);
		}
	});
});
function saverow(){
	var data="";
	$("#columns").children().children().children().each(function(i,v){
		var id = $(v).attr("id");
		var row="";
		$(v).children().each(function(j,k){
			var rowVal = $(k).attr("id");
			var colcount = $(k).attr("colcount");
			if(!colcount){
				colcount = 1;
			}
			var rowcount = $(k).attr("rowcount");
			if(!rowcount){
				rowcount = 1;
			}
			row+=rowVal+"@"+colcount+"@"+rowcount+"@1#";
		});
		data+=",{'column':'"+id+"','row':'"+row+"'}";
	});
	var colData="["+data.substring(1)+"]";
	$("#columnData").val(colData);
	$("#opForm").submit();
}
function showInfo(obj){
	 $.dialog.alert(obj);
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
function removeRow(obj){
	var row=$("#"+obj);
	$("#columnData").val(row.attr("id"));
	$.post("${ctx}/auth/rolePortlets/hiddenUserPortlets.action",$("#opForm").serialize(),function(result){
		if(result.MSG=="TRUE"){
			row.remove();
			$("div[id^='"+obj+"_showKK_']").each(function(i,v){
				$(v).remove();
			});
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
			var columnId=$(this.iframe)[0].contentWindow.getColumnId();
			var data=$(this.iframe)[0].contentWindow.checkObjs();
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

 		
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>