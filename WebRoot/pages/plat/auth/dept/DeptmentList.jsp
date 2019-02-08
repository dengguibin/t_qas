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
			var baseUrl = "${ctx}/org/auth/";
			var query = "?bean.bmid="+args+"&menuId="+$("#menuId").val();
			 if('update' === opCode){
				baseUrl += "toEditDeptInfo.action"+query;
				$.registerForm('opForm');
				window.location.href = baseUrl;
			}else if('delete' === opCode){
				var result = window.confirm("确定要永久删除选中数据？");
					if(result){
					baseUrl += "removeDept.action"+query;
					$.getJSON(baseUrl,{},function(data){
						if(data && data.status == '1'){
							$("#opForm").submit();
						}else{
							alert(data.message);
						}
					});
					}
				
			}else if('add' === opCode){
				baseUrl += "toEditDeptInfo.action"+"?menuId="+$("#menuId").val();
				$.registerForm('opForm');
				window.location.href = baseUrl;
			}else if('query' === opCode){
				$("#opForm").submit();
			}
		}
//-->
</script>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${menuId}"/></div>
<x:qx var="qx" menuId="${menuId }"></x:qx>
<div class="dataGrid">
<c:if test="${not empty bean }">
<s:form action="listDeptInfo" namespace="/org/auth" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${menuId}" id="menuId">
<s:hidden name="bean.bmid" id="bmid"/>
	  <div class="formtitle"><span>单位/部门信息管理</span></div>
		<c:if test="${qx.add and not empty bean }">
			<div class="tools">
				<ul class="toolbar">
		        <li class="click"  onclick="opreate('','add');"><span><img src="${ctx }/skins/uimaker/images/t01.png" /></span>添加</li>
		        </ul>
			</div>
		</c:if>
		
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th>单位/部门名称</th>
                <th>负责人</th>
                <th>单位/部门编号</th>
                <th>上级单位</th>
                <th>排序号</th>
                 <th>操作</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	                <td>&nbsp;${stat.count }</td>
                   	<td>
                   	<c:forEach begin="2" end="${item.CJ }">
                   	&nbsp;&nbsp;&nbsp;&nbsp;
                   	</c:forEach>
                   	${item.BMMC}</td>
                   	<td>&nbsp;<x:cache subject="USERS" key="${item.BMHJR}"></x:cache></td>
                   	 <td>&nbsp;${item.BMBH}</td>
                   	 <td>&nbsp;<x:cache subject="ORGS" key="${item.FBMID}"/></td>
                   	<td>&nbsp;${item.PXH}</td>
                 	 <td style="width: 120px;">&nbsp;
                 	 <c:if test="${qx.update }"><a href="javascript:void(0);" class="tablelink" title="更 新" onclick="opreate('${item.BMID }','update');">修改</a></c:if>
                 	 <c:if test="${qx.delete }">
                 	 	<c:choose>
                 	 		<c:when test="${bean.bmid eq  item.BMID }">禁止</c:when>
                 	 		<c:otherwise><a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.BMID }','delete');">删除</a></c:otherwise>
                 	 	</c:choose>
                 	 </c:if>
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
</c:if>  
<c:if test="${empty bean}">
 <div class="formbody">
    <div class="formtitle"><span>提示信息</span></div>
      <div class="tipinfo">
        <span><img src="${ctx }/skins/uimaker/images/lc06.png" /></span>
        <div class="tipright">
        <p>你的帐号信息没有在任何单位部门信息当中</p>
        <cite>请联系管理，调整你帐号所在的组织机构关系。</cite>
        </div>
        </div>
</div>
</c:if>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
