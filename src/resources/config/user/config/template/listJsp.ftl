<#list tables as table>
	<#if table.name == path.id>
		<#assign  columns=table.columns>
		<#assign  tname=table.name>
		<#assign className=''>
		<#list tname?split('_') as fiex>
			<#assign className>${className}${fiex?capitalize}</#assign>
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
<%@include file="/pages/plat/frame/header.jsp" %>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${"$"}{ctx}/${wizard.pack?replace(".", "/")}/${className?uncap_first}";
			//加上随机请求参数，防止浏览器缓存显示数据不正确
			var query = "?bean.${pk!'tid'}="+args+"&v="+Math.random();
			if('update' === opCode){
				baseUrl += "!select.action"+query;
				window.location.href = baseUrl;
			}else if('delete' === opCode){
				baseUrl += "!delete.action"+query;
				$.post(baseUrl,{},function(data){
				});
			}else if('add' === opCode){
				baseUrl += "!select.action";
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}
		}
//-->
</script>
<body>
<x:page var="datas" stmt="list" params="${"$"}{bean}" mapperClass="${"$"}{mapper}"></x:page>
<div class="title"><span>当前位置：</span><x:menu menuId="${"$"}{param.menuId}"/></div>
<div class="tabBlock">	

<s:form action="${className?uncap_first}!list" namespace="/${wizard.pack?replace(".", "/")}" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${"$"}{param.menuId}" id="menuId">
	<div class="editBlock">
 		<table>
 			<tr>
              <td colspan="4" class="subtitle"  title="点击可展开或关闭">查询条件</td>
            </tr>
            <tbody>
              <tr>
                <th width="120">地区分公司：</th>
                <td><select name="city" id="city">
                  <option>----请选择分公司----</option>
				  <option>广东省公司</option>
				  <option>广州分公司</option>
                </select></td>
                <th width="120">集团名称：</th>
                <td><input type="text" class="inputText" name="textfield22" /></td>
              </tr>
              <tr>
                <td colspan="4" class="toolbar" style="text-align: right;">
                <input name="button" type="button" class="inputButton" value=" 查 询 " />
                <input name="button" onclick="opreate('','add');" type="button" class="inputButton" value=" 新 增 " />
                </td>
              </tr>
            </tbody>
          </table>
		</div>
		<div class="dataGrid">
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                 <#list columns as column>
                <th>${column.comments!''}</th>
                 </#list>
                 <th>操作</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${"$"}{datas}" var="item"  varStatus="stat">
	            <tr>
	                <td>&nbsp;${"$"}{stat.count }</td>
	                 <#list columns as column>
                   	<td>&nbsp;${"$"}{item.${column.name?upper_case}}</td>
                 	 </#list>
                 	 <td>&nbsp;
                 	 	<a href="#" class="iconMod" title="更 新" onclick="opreate('${"$"}{item.${(pk!'')?upper_case} }','update');">&nbsp;</a>
                 	 	<a href="#" class="iconDel" title="删 除" onclick="opreate('${"$"}{item.${(pk!'')?upper_case} }','delete');">&nbsp;</a>
                 	 </td>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
          <%@include file="/pages/plat/frame/page.jsp" %>
          </div><!-- dataGrid end -->
</s:form>
</div><!-- editBlock end -->
</body>
<%@include file="/pages/plat/frame/footer.jsp" %>
	</#if>
</#list>