<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2015-7-2 15:51:46
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/collector/";
			//加上随机请求参数，防止浏览器缓存显示数据不正确
			var query = "?bean.tid="+args+"&v="+Math.random();
			if('update' === opCode){
				baseUrl += "toEdit.action";
				$("#tid").val(args);
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
					    query = "?bean.tid="+ids.join(',');
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
				$.registerForm('opForm');
				baseUrl += "toEdit.action";
				$("#tid").val(args);
				$("#opForm").attr("action",baseUrl).submit();
			}else if('queryInfo' === opCode){
				$.registerForm('opForm');
				baseUrl += "queryInfo.action";
				$("#tid").val(args);
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}else if('runTran' === opCode){
				$.registerForm('opForm');
				baseUrl += "queryRunTranInfo.action";
				$("#tid").val(args);
				$("#opForm").attr("action",baseUrl).submit();
			/* 	$.post(baseUrl,{"bean.tid":args},function(data){
					$.dialog.alert(data.msg);
				},"JSON"); */
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
<form action="${ctx}/collector/queryList.action"   method="post"  id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.tid" id="tid" />
		<div class="filter">
 		<table>
            <tbody >
             <tr>
				  <th>配置名称：</th>
				   <td><s:textfield name="bean.name" cssClass="inputText"></s:textfield></td>
				  <th>是否有效：</th>
				   <td>
				   <select  class="select2"  name="bean.valid" class="inputText"> 
                 	<option value="">--请选择--</option>
                 	<!--调用字典的效果-->
				   	 <x:cache subject="VALID" option="true" selected="${bean.valid}"></x:cache>
				   </select>
				   
				   </td>
				<th>最后一次运行时间：</th>
				<td>
					<input class="inputDate" name="bean.rdateStart" onClick="new WdatePicker()">
					<input class="inputDate" name="bean.rdateEnd" onClick="new WdatePicker()">
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
			<c:if test="${qx.add }"><li class="click"  onclick="opreate('','add');"><span><img src="${ctx }/skins/uimaker/images/t01.png" /></span>添加</li></c:if>
	        </ul>
		</div><!--tools end-->
		
		
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
              	<!-- <th><input name="" type="checkbox" value="" checkSelector="Selector"/></th> -->
                <th width="50">序号</th>
                <th>配置名称</th>
                <th>唯一标识</th>
                <th>配置描述</th>
                <th style="width:150px">最后一次运行时间</th>
                <th style="width:100px">运行状态结果</th>
                <th style="width:100px">运行耗时(秒)</th>
                 <c:if test="${qx.update or qx.delete or qx.view }">
                  <th style="width:100px">操作</th>
                 </c:if>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	           <%-- 		<td><input name="test" type="checkbox" class="chk" value="${item.TID }"  checkNode="Selector" /></td> --%>
	                <td>&nbsp;${stat.count }</td>
                   	<td>&nbsp;${item.NAME}</td>
                   	<td>&nbsp;${item.TID}</td>
                   	<td>&nbsp;${item.REMARK}</td>
                   	<td>&nbsp;<fmt:formatDate value="${item.RDATE}" pattern="yyyy-MM-dd HH:mm"/></td>
                   	<td>&nbsp;<x:cache subject="TRAN_STATUS" option="false"  key="${item.STATE}"></x:cache></td>
                   	<td>&nbsp;${item.COSTS}</td>
                 	 <c:if test="${qx.update or qx.delete  or qx.view}">
                 	 <td style='width:120px;'>&nbsp;
                 	 	<c:if test="${qx.view}"><a href="javascript:void(0);" class="tablelink" title="查看" onclick="opreate('${item.TID }','queryInfo');">查看</a></c:if>
                 	 	<c:if test="${qx.update}"><a href="javascript:void(0);" class="tablelink" title="修 改" onclick="opreate('${item.TID }','update');">修改</a></c:if>
                 	 	<c:if test="${qx.update}"><a href="javascript:void(0);" class="tablelink" title="手动执行" onclick="opreate('${item.TID }','runTran');">手动执行</a></c:if>
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
