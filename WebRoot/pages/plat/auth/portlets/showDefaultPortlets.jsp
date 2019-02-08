<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx}/scripts/plugins/fusioncharts/fusioncharts.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/fusioncharts/themes/fusioncharts.theme.fint.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/portlets/jquery-ui.js"></script>
<link href="${ctx}/scripts/plugins/portlets/portlets.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
<!--
//统一进行门户拖动效果
$(function(){
	$(".columns").sortable({
		connectWith: ".columns",
		handle: ".listtitle",
		cancel: ".portlet-toggle",
		placeholder: "portlet-placeholder ui-corner-all"
	});
});

$(document).queue("stats",function(){
	FusionCharts.ready(function(){
	    var revenueChart = new FusionCharts({
	        "type": "column2d",
	        "renderAt": "column2dContainer",
	        "width": "100%",
	        "height": "250"
	  });
	    var datas1 = $("#column2dDatas").val();
		revenueChart.setChartData(datas1.replace("<!--","").replace("-->",""),'xml');  
		revenueChart.render();
	    $(document).dequeue("stats")
	});

});

$(document).queue("stats",function(){
	FusionCharts.ready(function(){
	    var revenueChart = new FusionCharts({
	        "type": "column2d",
	        "renderAt": "column2dContainer2",
	        "width": "99%",
	        "height": "200"
	  });
	    var datas1 = $("#column2dDatas2").val();
		revenueChart.setChartData(datas1.replace("<!--","").replace("-->",""),'xml');  
		revenueChart.render();
		$(document).dequeue("stats")
	});
	
});

$(document).queue("stats",function(){
	FusionCharts.ready(function(){
	    var revenueChart = new FusionCharts({
	        "type": "pie2d",
	        "renderAt": "pie2dContainer",
	        "width": "100%",
	        "height": "200"
	  });
	    var datas1 = $("#pie2dDatas").val();
		revenueChart.setChartData(datas1.replace("<!--","").replace("-->",""),'xml');  
		revenueChart.render();
		$(document).dequeue("stats");
	});
	
});

$(document).queue("stats",function(){
	FusionCharts.ready(function(){
	    var revenueChart = new FusionCharts({
	        "type": "pie3d",
	        "renderAt": "pie3dContainer",
	        "width": "100%",
	        "height": "200"
	  });
	    var datas1 = $("#pie2dDatas").val();
		revenueChart.setChartData(datas1.replace("<!--","").replace("-->",""),'xml');  
		revenueChart.render();
		$(document).dequeue("stats");
	});

});

$(document).queue("stats",function(){
	FusionCharts.ready(function(){
	    var revenueChart = new FusionCharts({
	        "type": "msline",
	        "renderAt": "mslineContainer",
	        "width": "100%",
	        "height": "200"
	  });
	    var datas1 = $("#mslineDatas").val();
		revenueChart.setChartData(datas1.replace("<!--","").replace("-->",""),'xml');  
		revenueChart.render();
		$(document).dequeue("stats");
	});
	
});

//执行函数

$(document).ready(function(){
	setTimeout("$(document).dequeue('stats');",500);
});
//-->
</script>

<style>
td{}
.test{height: 290px;border: solid 1px #d3dbde;}
</style>
<body>
	<div class="title">
    <span>当前位置：</span><x:menu menuId="${param.menuId}"/>
    </div>
    <s:hidden name="menuId" id="menuId" />
   <div class="dataGrid">  
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
							 <div class="listtitle"><%--<a href='${resultVal["url"]}' class="more1">更多</a> --%>${resultVal["title"]}</div>
					    	 <div id='mslineContainer${rowMapRef}'>
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
	<table style="width:100%">
		<tr  ><td colspan="${fn:length(columnList)}" style="text-align:center" ><input type="button"  class="cancel" value=" 返 回 " id="returnButton" /></td></tr>
	</table>


 		
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>