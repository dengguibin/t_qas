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
			var baseUrl = "${ctx}/quartz/logs/";
			//加上随机请求参数，防止浏览器缓存显示数据不正确
			var query = "?bean.logid="+args+"&v="+Math.random();
			if('queryInfo' === opCode){
				baseUrl += "queryInfo.action";
				$("#logid").val(args);
				$.registerForm('opForm');
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
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
   		<li><a href="${ctx}/quartz/scheduling/queryList.action?menuId=${param.menuId}" >调度设置</a>
        <li><a href="${ctx}/quartz/logs/queryList.action" class="selected" >调度日志</a>
  	</ul>
</div> 	
<form action="${ctx}/quartz/logs/queryList.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.logid" id="logid" />
		<div class="filter" style="padding-top: 10px;">
 		<table>
            <tbody >
             <tr>
                <th>任务名称：</th>
                 <td><s:textfield name="bean.taskname" cssClass="inputText"></s:textfield></td>
                 <th>运行状态：</th>
                 <td>
                   <select class="select2" name="bean.states">
                 	 <option value=''>--请选择--</option>
				   	 <x:cache subject="RUN_STATE" option="true" selected="${bean.states}"></x:cache>
				   </select>
                 </td>
                 <td>
                 </td>
                 <td>
	                <input name="button" onclick="opreate('','query');" type="button" class="inputButton" value=" 查 询 " />
                 </td>
              </tr>
            </tbody>
          </table>
		</div><!--filter end-->
		
	<%-- 	<div class="tools">
			<ul class="toolbar">
			<c:if test="${qx.add }"><li class="click"  onclick="opreate('','add');"><span><img src="${ctx }/skins/uimaker/images/t01.png" /></span>添加</li></c:if>
	        <c:if test="${qx.delete }"><li  class="click"  onclick="opreate('','remove');"><span><img src="${ctx }/skins/uimaker/images/t03.png" /></span>删除</li></c:if>
	        </ul>
		</div> --%><!--tools end-->
		
		
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
              	<th><input name="" type="checkbox" value="" checkSelector="Selector"/></th>
                <th width="50">序号</th>
                <th>任务名称</th>
                <th  width="70">运行状态</th>
                <th>工作计算机</th>
                <th>计算机IP</th>
                <th>计算机MAC</th>
                <th>备注说明</th>
                <th width="170px;">运行时间</th>
                 <c:if test="${qx.update or qx.delete }">
                  <th>操作</th>
                  </c:if>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	           		<td><input name="test" type="checkbox" class="chk" value="${item.LOGID }"  checkNode="Selector" /></td>
	                <td>${stat.count }</td>
                   	<td>${item.TASKNAME}</td>
                   	<td>
                   		<x:cache subject="RUN_STATE" option="false" key="${item.STATES}"></x:cache>
                   	</td>
                   	<td>${item.WORKER}</td>
                   	<td>${item.WORKIP}</td>
                   	<td>${item.MAC}</td>
                   	<td>${item.DES}</td>
                   	<td>${item.RUNDATE}</td>
                 	 <c:if test="${qx.update or qx.delete  or qx.view}">
                 	 <td style='width:50px;'>
                 	 	<c:if test="${qx.view}"><a href="javascript:void(0);" class="tablelink" title="查看" onclick="opreate('${item.LOGID }','queryInfo');">查看</a></c:if>
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
