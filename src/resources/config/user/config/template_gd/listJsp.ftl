<#list tables as table>
	<#if table.name == path.id>
		<#assign  columns=table.columns>
		<#assign  tname=table.name>
		<#assign className=''>
		<#list tname?split('_') as fiex>
			<#assign className>${className}${fiex?capitalize}</#assign>
			<#assign subfix>${fiex?lower_case}</#assign>
		</#list>
<#assign sindex = path.target?last_index_of('/')>		
<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date ${.now?datetime}
*@author upaths@gmail.com
*/
%>
<#list columns as column>
	<#if column.primary>
		<#assign pk='${column.name?lower_case}'>
	</#if>
</#list>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${"$"}{ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${"$"}{ctx}/请配置路径/${subfix}/";
			//加上随机请求参数，防止浏览器缓存显示数据不正确
			var query = "?bean.${pk!'tid'}="+args+"&v="+Math.random();
			if('update' === opCode){
				baseUrl += "toEdit.action";
				$("#${pk!'tid'}").val(args);
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
					    query = "?bean.${pk!'tid'}="+ids.join(',');
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
				$("#${pk!'tid'}").val(args);
				$("#opForm").attr("action",baseUrl).submit();
			}else if('queryInfo' === opCode){
				baseUrl += "queryInfo.action";
				$("#${pk!'tid'}").val(args);
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
 <x:qx var="qx" menuId="${"$"}{param.menuId}"></x:qx>
<div class="title"><span>当前位置：</span><x:menu menuId="${"$"}{param.menuId}"/></div>
<div class="dataGrid">	
<form action="${"$"}{ctx}/请配置路径/${subfix}/queryList.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.${pk!'tid'}" id="${pk!'tid'}" />
		<div class="filter">
 		<table>
            <tbody >
             <tr>
                <th>菜单名称：</th>
                <td><s:textfield name="bean.cdmc" cssClass="inputText"></s:textfield></td>
                <td>
                <th>选择菜单：</th>
                <td>
                 <select class="select2">
                 	<option value=''>--请选择--</option>
				    <option>3000-5000</option>
				    <option>5000-8000</option>
				    <option>8000-10000</option>
				    <option>10000-15000</option>
				   </select>
                </td>
                <th>EQ选择：</th>
                <td>
                 <select  id="select9" name="select9" style="width:160px;">
                 	<option value="">--请选择--</option>
                 	<!--调用字典的效果-->
				   	 <x:cache subject="ORGS" option="true" selected="${"$"}{param.select9 }"></x:cache>
				   </select>
                </td>
                
                <th>时间选择：</th>
                <td>
                	<input class="inputDate" onClick="new WdatePicker()">
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
			<c:if test="${"$"}{qx.add }"><li class="click"  onclick="opreate('','add');"><span><img src="${"$"}{ctx }/skins/uimaker/images/t01.png" /></span>添加</li></c:if>
	        <c:if test="${"$"}{qx.delete }"><li  class="click"  onclick="opreate('','remove');"><span><img src="${"$"}{ctx }/skins/uimaker/images/t03.png" /></span>删除</li></c:if>
	        </ul>
		</div><!--tools end-->
		
		
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
              	<th><input name="" type="checkbox" value="" checkSelector="Selector"/></th>
                <th width="50">序号</th>
                 <#list columns as column>
                <th>${column.comments!'未备注列'}</th>
                 </#list>
                 <c:if test="${"$"}{qx.update or qx.delete }">
                  <th>操作</th>
                  </c:if>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${"$"}{datas}" var="item"  varStatus="stat">
	            <tr>
	           		<td><input name="test" type="checkbox" class="chk" value="${"$"}{item.${(pk!'')?upper_case} }"  checkNode="Selector" /></td>
	                <td>&nbsp;${"$"}{stat.count }</td>
	                 <#list columns as column>
                   	<td>&nbsp;${"$"}{item.${column.name?upper_case}}</td>
                 	 </#list>
                 	 <c:if test="${"$"}{qx.update or qx.delete  or qx.view}">
                 	 <td style='width:120px;'>&nbsp;
                 	 	<c:if test="${"$"}{qx.view}"><a href="javascript:void(0);" class="tablelink" title="查 看" onclick="opreate('${"$"}{item.${(pk!'')?upper_case} }','queryInfo');">查看</a></c:if>
                 	 	<c:if test="${"$"}{qx.update}"><a href="javascript:void(0);" class="tablelink" title="修 改" onclick="opreate('${"$"}{item.${(pk!'')?upper_case} }','update');">修改</a></c:if>
                 	 	<c:if test="${"$"}{qx.delete}"><a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${"$"}{item.${(pk!'')?upper_case} }','remove');">删除</a></c:if>
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
	</#if>
</#list>