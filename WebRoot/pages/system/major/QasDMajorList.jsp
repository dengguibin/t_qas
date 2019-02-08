<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-30 10:54:53
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/system/major/";
			//加上随机请求参数，防止浏览器缓存显示数据不正确
			var query = "?bean.id="+args+"&v="+Math.random();
			if('update' === opCode){
				baseUrl += "toEdit.action";
				args = args.split(',');
				$("#id").val(args[0]);
				//借用查询条件传值
				$("#majorname").val(args[1]);
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
					    query = "?bean.id="+ids.join(',');
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
				$("#id").val(args);
				$("#opForm").attr("action",baseUrl).submit();
			}else if('queryInfo' === opCode){
				baseUrl += "queryInfo.action";
				$("#id").val(args);
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}
		}
		
	//下拉输入的效果	
	$(function(){
	  $('#select9').select2({
	  	  tags: "true" 
	  });
	});
//-->
</script>
<body>
<!-- 权限查询 -->
 <x:qx var="qx" menuId="${param.menuId}"></x:qx>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<div class="dataGrid">	
<form action="${ctx}/system/major/queryList.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.id" id="id" />
		<div class="filter">
 		<table>
            <tbody >
             <tr>
                <th>专业名称：</th>
                <td><s:textfield name="bean.majorname" id = "majorname" cssClass="inputText"></s:textfield></td>
                <td>
                <th>所属学院：</th>
                <td>
                  <select id="select9" name="bean.organizationid" style="width:160px;">
                 	<option value="">--请选择--</option>
                 	<!--调用字典的效果-->
				   	 <x:cache subject="ORGS" option="true" selected="${bean.organizationid }"></x:cache>
				   </select>
                </td>
                <th>专业类别：</th>
                <td>
                	<select class="select2" name="bean.divisiontype" style="width:160px;">
                 	<option value="">--请选择--</option>
                 	<!--调用字典的效果-->
				   	 <x:cache subject="10020" option="true" selected="${bean.divisiontype }"></x:cache>
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
			<c:if test="${qx.add }"><li class="click add"  onclick="opreate('','add');">添加</li></c:if>
	        <c:if test="${qx.delete }"><li  class="click remove"  onclick="opreate('','remove');">删除</li></c:if>
	        </ul>
		</div><!--tools end-->
		
		
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
              	<th><input name="" type="checkbox" value="" checkSelector="Selector"/></th>
                <th width="50">序号</th>
                <th>所属学院</th>
                <th>专业代码</th>
                <th>专业名称</th>
                <th>专业文理类别</th>
                <th>是否招生</th>
                <th>状态</th>
                 <c:if test="${qx.update or qx.delete }">
                  <th>操作</th>
                  </c:if>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	           		<td><input name="test" type="checkbox" class="chk" value="${item.ID }"  checkNode="Selector" /></td>
	                <td>${stat.count }</td>
                   	<td>${item.BMMC}</td>
                   	<td>${item.MAJORCODE}</td>
                   	<td>${item.MAJORNAME}</td>
                   	<td><x:cache subject="10020" key="${item.DIVISIONTYPE}"/></td>
                   	<td><x:cache subject="OPTION01" key="${item.ISENROLL}"/></td>
                   	<td>
                   		<c:choose>
                   		<c:when test="${item.STATUS eq '1'}">有效</c:when>
                   		<c:otherwise>无效</c:otherwise>
                   		</c:choose>
                   	</td>
                 	 <c:if test="${qx.update or qx.delete  or qx.view}">
                 	 <td style='width:120px;'>
                 	 	<%-- <c:if test="${qx.view}"><a href="javascript:void(0);" class="tablelink" title="查 看" onclick="opreate('${item.ID }','queryInfo');">查看</a></c:if> --%>
                 	 	<c:if test="${qx.update}"><a href="javascript:void(0);" class="tablelink" title="修 改" onclick="opreate('${item.ID},${item.BMMC}','update');">修改</a></c:if>
                 	 	<c:if test="${qx.delete}"><a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.ID }','remove');">删除</a></c:if>
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
