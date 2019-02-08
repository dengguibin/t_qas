<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp"%>
<link rel="stylesheet" href="${ctx}/scripts/plugins/layer-v3.1.0/layer/theme/default/layer.css" />
<link rel="stylesheet" href="${ctx}/scripts/plugins/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/public.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/icon.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/dTasks.css" />
<script type="text/javascript" src="${ctx}/scripts/plugins/layer-v3.1.0/layer/layer.js" ></script>
<body>
<!-- 权限查询 -->
 <x:qx var="qx" menuId="${param.menuId}"></x:qx>
	<div class="title">
		<span>当前位置：</span>
		<x:menu menuId="${param.menuId}" />
	</div>
	<div class="wrapper d-tasks">
		<form id="opForm" name="opForm" action="${ctx }/diagnose/diagnoseTask/queryList.action" method="post">
			<s:hidden name="menuId" id="menuId" />
			<s:hidden name="diagnosetask.id" id="id" />
			<div class="top clear">
				<div class="left">
					<a href="toEdit.action?menuId=${param.menuId}" class="add-temp cancel" id="add_task">+ 新建任务</a>
				</div>
				<div class="right">
					<div class="search-box" style="height:33px;">
						<input type="text" name="diagnosetask.taskname" placeholder="诊断任务/关键字搜索" value="${diagnosetask.taskname}" class="search-input" />
						<span class="search-icon icon" onclick="opreate('','query');"></span>
					</div>
				</div>
				
			</div>
			
			<div class="table-responsive list">
				<!--
					表格单行选中：tr.select
				-->
				<div class="table-box">
			  	<table class="table table-bordered data-list">
			  		<thead>
			  			<tr>
			  				<th style="text-align:center" width="5%">序号</th>
			  				<th style="text-align:center" width="15%">任务名称</th>
			  				<th style="text-align:center" width="14%">模型名称</th>
			  				<th style="text-align:center" width="18%">执行时段</th>
			  				<th style="text-align:center" width="10%">执行频率</th>
			  				<th style="text-align:center" width="9%">发布日期</th>
			  				<th style="text-align:center" width="7%">发布状态</th>
			  				<th style="text-align:center" width="7%">操作人</th>
			  				<th style="text-align:center" class="opt" width="15%">操作</th>
			  			</tr>
			  		</thead>
			    	<tbody>
			    		<c:forEach items="${datas}" var="item"  varStatus="stat">
				    		<tr>
				    			<td style="text-align:center">&nbsp;${stat.count }</td>
				    			<input type="hidden" value="${item.ID }" id="taskId"/>
				    			<td style="text-align:center">${item.TASKNAME }</td>
				    			<td style="text-align:center">${item.SCHEMENAME }</td>
				    			<td style="text-align:center">
				    				<fmt:formatDate  value="${item.STARTTIME }" type="date" pattern="yyyy-MM-dd" />--
				    				<fmt:formatDate  value="${item.ENDTIME }" type="date" pattern="yyyy-MM-dd" />
				    			</td>
				    			<td style="text-align:center">
					    			<c:if test='${item.FREQUENCY eq 0}'>按月诊断</c:if>
					    			<c:if test='${item.FREQUENCY eq 1}'>按学期诊断</c:if>
					    			<c:if test='${item.FREQUENCY eq 2}'>按周诊断</c:if>
					    			<c:if test='${item.FREQUENCY eq 3}'>按学年诊断</c:if>
					    		</td>
				    			<td style="text-align:center"><fmt:formatDate value="${item.PUBLISHTIME}" type="date" pattern="yyyy-MM-dd" /></td>
				    			<td style="text-align:center">
				    				<c:if test='${item.PUBLISHSTATUS eq 0}'><span class="col-1" style="color: brown">未发布</span></c:if>
					    			<c:if test='${item.PUBLISHSTATUS eq 1}'><span class="col-2" style="color: green">已发布</span></c:if>
					    			<c:if test='${item.PUBLISHSTATUS eq 2}'><span class="col-1" style="color: red">已停止</span></c:if>
					    			<c:if test='${item.PUBLISHSTATUS eq 3}'><span class="col-1" style="color: black">已结束</span></c:if>
				    			</td>
				    			<td style="text-align:center">${item.YHMC}</td>
				    			<td class="opt" style="text-align:center">
				    				<c:if test="${qx.view}">
				    					<span class="td-opt-btn td-opt-detail" onclick="opreate('${item.ID }','queryInfo');">查看</span>
				    					
				    				</c:if>
			                 	 	<c:if test="${qx.update}">
			                 	 		<c:if test="${item.PUBLISHSTATUS eq 0}">
			                 	 		<span class="td-opt-btn td-opt-modify" onclick="opreate('${item.ID }','update');">修改</span>
			                 	 		<span class="td-opt-btn td-opt-release" onclick="opreate('${item.ID }','updateState');">发布</span>
			                 	 		<span class="td-opt-btn td-opt-delect" onclick="opreate('${item.ID }','remove');">删除</span>
			                 	 		</c:if>
			                 	 		<c:if test="${item.PUBLISHSTATUS eq 1 }">
			                 	 		<span class="td-opt-btn td-opt-detail" onclick="opreate('${item.ID }','stop');">停止</span>
			                 	 		<span class="td-opt-btn td-opt-detail" onclick="opreate('${item.ID }','end');">结束</span>
			                 	 		<span class="td-opt-btn td-opt-detail" onclick="excuteAnaly('${item.ID }')">诊断</span>
			                 	 		</c:if>
			                 	 		
			                 	 		<c:if test="${item.PUBLISHSTATUS eq 2 }">
			                 	 		<span class="td-opt-btn td-opt-detail" onclick="opreate('${item.ID }','continue');">继续</span>
			                 	 		<span class="td-opt-btn td-opt-detail" onclick="opreate('${item.ID }','end');">结束</span>
			                 	 		</c:if>
			                 	 		<c:if test="${item.PUBLISHSTATUS eq 3 }">
			                 	 		<span class="td-opt-btn td-opt-detail" onclick="opreate('${item.ID }','remove');">删除</span>
			                 	 		</c:if>
			                 	 	</c:if>
			                 	 	
				    			</td>
				    		</tr>
			    		</c:forEach>
			    	</tbody>
			 	</table>
			 	</div>
			 	<%@include file="/pages/t_qas/layout/page.jsp" %>
			</div>
		</form>
	</div>
	<script>
		$(document).ready(function(){
			//获取父窗口frame的高度
			var _hMax = window.parent.document.getElementById("mainContent").offsetHeight;
			var _hPagin = $("#tabpages").innerHeight();
			if(_hMax && _hPagin){
				var _h = _hMax - $(".top").innerHeight() - $(".page").innerHeight() - _hPagin - 16 * 3 - 40;
				$(".list>.table-box").css({
					"height":_h + "px",
				});
			}
		})
		//回车搜索
		$(document).keydown(function(e) {
			if(e.keyCode == 13) {
				opreate('','query');
			}
		});
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/diagnose/diagnoseTask/";
			if('update' === opCode){
				baseUrl += "toEdit.action";
				$("#id").val(args);
				$("#opForm").attr("action",baseUrl).submit();
			}if('updateState' === opCode){
				//发布
				layer.confirm('您确定要发布该任务吗？', {
					title:'提示',
					icon: 3,//4是锁的图标
					btn: ['确定', '取消'] //按钮
				}, function() {
					//layer.msg('已发布', {
					//	icon: 1,
					//	time: 1500 //1.5s后关闭
					//});
					baseUrl += "toPublish.action";
					$("#id").val(args);
					$("#opForm").attr("action",baseUrl).submit();
				}, function() {
					layer.msg('已取消该操作', {
						icon: 2,
						time: 1500 //1.5s后关闭
					});
				});
			}else if('remove' === opCode){
				//删除
				layer.confirm('您确定要删除该任务吗？', {
					title:'提示',
					icon: 7,//4是锁的图标
					btn: ['确定', '取消'] //按钮
				}, function() {
					query = "?diagnosetask.id="+args;
					baseUrl += "remove.action"+query;
					$.getJSON(baseUrl,{},function(data){
						if(data && data.success == '1'){
							opreate('','query');
						}else{
							layer.msg('已删除', {
								icon: 1,
								time: 1500 //1.5s后关闭
							});
						}
					});
				}, function() {
					layer.msg('已取消该操作', {
						icon: 2,
						time: 1500 //1.5s后关闭
					});
				});
			}
			
			else if('stop' === opCode){
				//停止
				layer.confirm('您确定要停止该任务吗？', {
					title:'提示',
					icon: 7,//4是锁的图标
					btn: ['确定', '取消'] //按钮
				}, function() {
					query = "?diagnosetask.id="+args+"&status=2";
					baseUrl += "updateStatus.action"+query;
					$.getJSON(baseUrl,{},function(data){
						if(data && data.success == '1'){
							opreate('','query');
						}else{
							layer.msg('已停止', {
								icon: 1,
								time: 1500 //1.5s后关闭
							});
						}
					});
				}, function() {
					layer.msg('已取消该操作', {
						icon: 2,
						time: 1500 //1.5s后关闭
					});
				});
			}
			
			else if('end' === opCode){
				//结束
				layer.confirm('您确定要结束该任务吗？', {
					title:'提示',
					icon: 7,//4是锁的图标
					btn: ['确定', '取消'] //按钮
				}, function() {
					query = "?diagnosetask.id="+args+"&status=3";
					baseUrl += "updateStatus.action"+query;
					$.getJSON(baseUrl,{},function(data){
						if(data && data.success == '1'){
							opreate('','query');
						}else{
							layer.msg('已结束', {
								icon: 1,
								time: 1500 //1.5s后关闭
							});
						}
					});
				}, function() {
					layer.msg('已取消该操作', {
						icon: 2,
						time: 1500 //1.5s后关闭
					});
				});
			}
			
			else if('continue' === opCode){
				//继续
				layer.confirm('您确定要继续该任务吗？', {
					title:'提示',
					icon: 7,//4是锁的图标
					btn: ['确定', '取消'] //按钮
				}, function() {
					query = "?diagnosetask.id="+args+"&status=1";
					baseUrl += "updateStatus.action"+query;
					$.getJSON(baseUrl,{},function(data){
						if(data && data.success == '1'){
							opreate('','query');
						}else{
							layer.msg('已继续', {
								icon: 1,
								time: 1500 //1.5s后关闭
							});
						}
					});
				}, function() {
					layer.msg('已取消该操作', {
						icon: 2,
						time: 1500 //1.5s后关闭
					});
				});
			}
			
			else if('queryInfo' === opCode){
				baseUrl += "queryInfo.action";
				$("#id").val(args);
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}
		}
	</script>
	<script>
	//手动触发诊断分析
function excuteAnaly(id){
	layer.open({
		  content: '是否确定进行手动诊断？本次诊断需要几分钟！'
		  ,btn: ['确认', '取消']
		  ,yes: function(index, layero){
			  layer.close(index);
			  var taskId = id;
				//var objId = $("#diagnoseObjId").val();
				if(taskId==null || taskId==""){
					alert("请选择诊断任务！");
					return;
				}
				//var data = {"taskId":taskId,"objId":objId};
				var data = {"taskId":taskId};
				//调用最顶层页面的方法
				window.top.openLoad("诊断中，请稍后");
				$.post("${ctx}/diagnose/diagnoseTask/excuteAnaly.action",data,function(result){
					if(result.success){
						window.top.closeLoad();
						//TODO 诊断之后的操作
						layer.msg(result.msg, {
							icon: 1,
							time:2000//1s后关闭
						});
						//window.location.href="${ctx}/main.action?menuId=${ANALY_MENUID}&v=" + Math.random();
					}else{
						window.top.closeLoad();
						layer.msg(result.msg, {
							icon: 2,
							time:2500//1.5s后关闭
						});
					}
				});
		  }
		});
	
	}
	</script>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>