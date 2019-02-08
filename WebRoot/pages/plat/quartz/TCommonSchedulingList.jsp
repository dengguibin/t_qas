<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2015-7-9 19:13:31
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/quartz/scheduling/";
			//加上随机请求参数，防止浏览器缓存显示数据不正确
			var query = "?bean.taskid="+args+"&v="+Math.random();
			if('update' === opCode){
				baseUrl += "toEdit.action";
				$("#taskid").val(args);
				$("#opForm").attr("action",baseUrl).submit();
			}else if('remove' === opCode){
				var ids = [];
				//单条删除操作
				if(args && $.trim(args) != ''){
					ids.push(args);
				}else{
					//选择批量删除操作
					if($(".chk:checked").size() > 0){
						$(".chk:checked").each(function(){
							ids.push($(this).val());
						});
					}
				}
				if( $.trim(ids) != ''){
					$.dialog.confirm('你确定要删除选中的数据吗?', function(){
					    query = "?bean.taskid="+ids.join(',');
						baseUrl += "remove.action"+query;
						$.getJSON(baseUrl,{},function(data){
							if(data && data.status == '1'){
								opreate('','query');
							}else if(data && data.status == '2'){
							     alert(data.message);
							}else{
								alert('删除数据失败!');
							}
						});
					}, function(){
					    $.dialog.tips('执行取消操作');
					});
				}else{
					$.dialog.alert('请选中需要删除的行数据!');
				}
			}else if('add' === opCode){
				baseUrl += "toEdit.action";
				$("#taskid").val(args);
				$.registerForm('opForm');
				$("#opForm").attr("action",baseUrl).submit();
			}else if('queryInfo' === opCode){
				baseUrl += "queryInfo.action";
				$("#taskid").val(args);
				$.registerForm('opForm');
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}else if('excuteJob' === opCode){
			    query = "?bean.taskid="+args;
				baseUrl += "excuteJob.action"+query;
				$.getJSON(baseUrl,{},function(data){
				     alert(data.message);
				     opreate('','query');
				});
			}else if('setStatus' === opCode){
				var status = args == 1 ? '启用':args == 0 ? '禁用' : '操作';
				var ids = [];
				if($(".chk:checked").size() > 0){
					$(".chk:checked").each(function(){
						ids.push($(this).val());
					});
				}
				if( $.trim(ids) != ''){
					$.dialog.confirm('你确定要'+status+'选中的数据吗?', function(){
					    query = "?bean.taskid="+ids.join(',')+"&bean.states="+args;
						baseUrl += "setStatus.action"+query;
						$.getJSON(baseUrl,{},function(data){
							if(data && data.status == '1'){
								opreate('','query');
							}else if(data && data.status == '2'){
							     alert(data.message);
							}else{
								alert(status + '失败!');
							}
						});
					}, function(){
					    $.dialog.tips('执行取消操作');
					});
				}else{
					$.dialog.alert('请选中需要'+status+'操作的数据!');
				}
			}
		}
		
	//下拉输入的效果	
	$(function(){
	  $('#select9').select2({
	  	 /* tags: "true" 如果要输入*/
	  });
	})
//-->
</script>
<body>
<!-- 权限查询 -->
 <x:qx var="qx" menuId="${param.menuId}"></x:qx>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<div class="dataGrid">	
<div class="itab tabson">
  	<ul> 
   		<li><a href="${ctx}/quartz/scheduling/queryList.action"  class="selected">调度设置</a>
        <li><a href="${ctx}/quartz/logs/queryList.action?menuId=${param.menuId}" >调度日志</a>
  	</ul>
</div> 
<form action="${ctx}/quartz/scheduling/queryList.action"   method="post" 
id="opForm" name="opForm" style="margin-top: 10px;">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.taskid" id="taskid" />
		<div class="filter">
 		<table>
            <tbody >
             <tr>
                <th>任务名称：</th>
                <td><s:textfield name="bean.taskname" cssClass="inputText"></s:textfield></td>
                <th>任务状态：</th>
                <td>
                   <select class="select2" name="bean.states">
                 	 <option value=''>--请选择--</option>
				   	 <x:cache subject="ENABLE_STATUS" option="true" selected="${bean.states}"></x:cache>
				   </select>
                </td>
                <td>
                <input name="button" onclick="opreate('','query');" type="button" class="inputButton" value=" 查 询 " />
                </td>
              </tr>
            </tbody>
          </table>
		</div><!--filter end-->
		
		<div class="tools">
			<ul class="toolbar">
			<li class="click startup"  onclick="opreate('1','setStatus');">启用</li>
			<li class="click disabled"  onclick="opreate('0','setStatus');">禁用</li>
			<c:if test="${qx.add }"><li class="click add"  onclick="opreate('','add');">添加</li></c:if>
	        <c:if test="${qx.delete }"><li  class="click remove"  onclick="opreate('','remove');">删除</li></c:if>
	        </ul>
		</div><!--tools end-->
		
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
              	<th width="30"><input name="" type="checkbox" value="" checkSelector="Selector"/></th>
                <th width="50">序号</th>
                <th>任务名称</th>
                <th width="100">任务状态</th>
                <th>任务类型</th>
                <th width="200">cron表达式</th>
                <th>备注说明</th>
                <th width="50">已运行次数</th>
                 <c:if test="${qx.update or qx.delete }">
                  <th>操作</th>
                  </c:if>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	           		<td><input name="test" type="checkbox" class="chk" value="${item.TASKID }"  checkNode="Selector" /></td>
	                <td>${stat.count }</td>
                   	<td>${item.TASKNAME}</td>
                   	<td>
                   		<x:cache subject="ENABLE_STATUS" option="false" key="${item.STATES}"></x:cache>
                   	</td>
                   	<td>
                   		<x:cache subject="SCHEDULING_TYPE" option="false" key="${item.TYPE}"></x:cache>
                   	</td>
                   	<td>${item.CRON}</td>
                   	<td>${item.DES}</td>
                   	<td>${item.RUNTIMES}</td>
                 	 <c:if test="${qx.update or qx.delete  or qx.view}">
                 	 <td style='width:130px;'>
                 	 	<c:if test="${qx.view}"><a href="javascript:void(0);" class="tablelink" title="查看" onclick="opreate('${item.TASKID }','queryInfo');">查看</a></c:if>
                 	 	<c:if test="${qx.update}"><a href="javascript:void(0);" class="tablelink" title="修 改" onclick="opreate('${item.TASKID }','update');">修改</a></c:if>
                 	 	<a href="javascript:void(0);" class="tablelink" title="手动触发" onclick="opreate('${item.TASKID }','excuteJob');">手动触发</a>
                 	 </td>
                 	 </c:if>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
           <%@include file="/pages/t_qas/layout/page.jsp" %>
</form>
</div><!-- dataGrid end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
