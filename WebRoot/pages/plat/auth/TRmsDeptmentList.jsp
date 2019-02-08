<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-3 22:10:24
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/auth/tRmsDeptment";
			var query = "?bean.bmid="+args+"&menuId="+$("#menuId").val();
			 if('update' === opCode){
				baseUrl += "!select.action"+query;
				$.registerForm('opForm');
				window.location.href = baseUrl;
			}else if('delete' === opCode){
				var result = window.confirm("确定要永久删除选中数据？");
					if(result){
					baseUrl += "!delete.action"+query;
					$.post(baseUrl,{},function(data){
						if(data.status!=1){
							alert(data.message);
						}else{
							$("#opForm").submit();
						}
					},"json");
					}
				
			}else if('add' === opCode){
				baseUrl += "!select.action";
				$.registerForm('opForm');
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}else if('downTemp' === opCode){
				$("#downloadFrame").attr("src","${ctx}/plat/auth/tRmsDeptment!downTemplate.action");
			}else if('toTemp' === opCode){
				window.location.href = baseUrl+"!toEditExcel.action"+query;
			}
		}
		

$(function(){
	 $('.select8').select2({
		  tags: true
	  });
});
//-->
</script>
<body>
<iframe id="downloadFrame" style="display: none;"></iframe>
<x:query stmt="部门管理查询" var="datas"></x:query>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<x:qx var="qx" menuId="${menuId }"></x:qx>
<div class="dataGrid">


<s:form action="tRmsDeptment!list" namespace="/plat/auth" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
	<div class="filter">
 		<table>
            <tbody>
              <tr>
                <th>所属机构：</th>
                <td>
                 <select  class="select8" name="bean.fbmid" id="fbmid" style="width:160px;">
                 		<option value="">--请选择--</option>
				   	 <x:cache subject="ORGS" var="options"></x:cache>
				   	 <c:set var="matched" value="false"/>
				   	 <c:forEach var="item" items="${options }">
				   	 	<c:set var="state" value=""/>
				   	 		<c:if test="${item.cname eq bean.fbmid }">
				   	 			<c:set var="state" value="selected='selected'"/>
				   	 			 <c:set var="matched" value="true"/>
				   	 		</c:if>
				   		 <option value="${item.cname }" ${state }>${item.cname }</option>
				   	 </c:forEach>
				   	 <!-- 当用户输入条件进行查询时，保证查询后可以再展示出来 -->
				   	 <c:if test="${matched eq false and not empty bean.fbmid  }">
				   	 	<option value="${bean.fbmid }" selected="selected">${bean.fbmid }</option>
				   	 </c:if>
				   </select>
				   </td>
                <th>机构名称：</th>
                <td>
                 <select  class="select8" name="bean.bmmc" style="width:160px;">
                 		<option value="">--请选择--</option>
				   	 <x:cache subject="ORGS" var="options"></x:cache>
				   	 <c:set var="matched" value="false"/>
				   	 <c:forEach var="item" items="${options }">
				   	 	<c:set var="state" value=""/>
				   	 		<c:if test="${item.cname eq bean.bmmc }">
				   	 			<c:set var="state" value="selected='selected'"/>
				   	 			 <c:set var="matched" value="true"/>
				   	 		</c:if>
				   		 <option value="${item.cname }" ${state }>${item.cname }</option>
				   	 </c:forEach>
				   	 <!-- 当用户输入条件进行查询时，保证查询后可以再展示出来 -->
				   	 <c:if test="${matched eq false and not empty bean.bmmc  }">
				   	 	<option value="${bean.bmmc }" selected="selected">${bean.bmmc }</option>
				   	 </c:if>
				   </select>
                </td>
                <td>
                <input name="button" onclick="opreate('','query');" type="button" class="inputButton" value="查 询 " />
                </td>
                </tr>
            </tbody>
          </table>
		</div>
		
		<c:if test="${qx.add }">
			<div class="tools">
				<ul class="toolbar">
				<li class="click setting" onclick="opreate('','toTemp');">导入数据</li>
				<li class="click setting" onclick="opreate('','downTemp');">下载模板</li>
				<li class="click add" onclick="opreate('','add');">添加</li>
		        <%--<li class="click"  onclick="opreate('','toTemp');"><span><img src="${ctx }/skins/uimaker/images/ico04.png" style="width:24px;height:24px" /></span>导入数据</li>
		        <li class="click"  onclick="opreate('','downTemp');"><span><img src="${ctx }/skins/uimaker/images/lc04.png" style="width:24px;height:24px" /></span>下载模板</li>
		        <li class="click"  onclick="opreate('','add');"><span><img src="${ctx }/skins/uimaker/images/t01.png" /></span>添加</li>--%>
		        </ul>
			</div>
		</c:if>
		
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th>机构名称</th>
                <th>机构负责人</th>
                <th>所属机构</th>
                <th>机构编号</th>
                <th>排序号</th>
                <th>层级</th>
                 <th>操作</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas.rows}" var="item"  varStatus="stat">
	            <tr>
	                <td>${stat.count }</td>
                   	<td style="text-align: left;">&nbsp;
                   	<c:forEach begin="2" end="${item.CJ }">
                   	&nbsp;&nbsp;&nbsp;&nbsp;
                   	</c:forEach>
                   	${item.BMMC}</td>
                   	<td><x:cache subject="USERS" key="${item.BMHJR}"></x:cache></td>
                   	<td>${item.FBMMC}</td>
                   	 <td>${item.BMBH}</td>
                   	<td style="width: 60px;text-align: center;">&nbsp;${item.PXH}</td>
                   	<td style="width: 60px;text-align: center;">&nbsp;${item.CJ}</td>
                 	 <td style="width: 90px;">&nbsp;
                 	 <c:if test="${qx.update }"><a href="javascript:void(0);" class="tablelink" title="更 新" onclick="opreate('${item.BMID }','update');">修改</a></c:if>
                 	 <c:if test="${qx.delete }"><a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.BMID }','delete');">删除</a></c:if>
                 	 <c:if test="${(qx.update or qx.delete) eq false }">
                 	 	<span class="note">无权限</span>
                 	 </c:if>
                 	 </td>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
          <%@include file="/pages/t_qas/layout/page.jsp" %>
</s:form>
</div><!-- editBlock end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
