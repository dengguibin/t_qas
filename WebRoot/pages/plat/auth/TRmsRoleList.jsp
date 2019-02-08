<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-11 21:51:54
*@author upaths@gmail.com
*/

%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx}/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/auth/tRmsRole";
			var query = "?bean.jsid="+args;
			if('update' === opCode){
				baseUrl += "!select.action"+query+"&menuId="+$("#menuId").val();
				window.location.href = baseUrl+"&menuId="+$("#menuId").val();
			}else if('delete' === opCode){
				if(window.confirm("确认要删除数据?")){
					baseUrl += "!delete.action"+query;
					$.post(baseUrl,{},function(data){
						if(data && data.status == '2'){
							alert('角色已经存在关联数据[用户，菜单信]，删除失败');
						}else{
							$("#opForm").submit();
						}
						
					});
				}
			}else if('add' === opCode){
				baseUrl += "!select.action";
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}else if('treeList' === opCode){
				baseUrl += "!treeList.action"+query;
				$.dialog({
				lock: true, 
				max: false, 
    			min: false ,
				title:'分配菜单',
				width:'360px',
				height:'460px',
				content: 'url:'+baseUrl});
			}else if('listUser' === opCode){
				baseUrl += "!listUser.action"+query;
				//var args = popUpModal(baseUrl);
				$.dialog({
				lock: true, 
				max: false, 
    			min: false ,
				title:'分配用户',
				width:'360px',
				height:'460px',
				content: 'url:'+baseUrl,
				 buttons: {
	                    "返回值": function () {
							var test = $("#test").val();
							alert(test);
	                    	return "abc";
	                        $(this).dialog("close");
	                    },
	                    Cancel: function () {
	                        $(this).dialog("close");
	                    }
	                }
				});
			}else if('reload' === opCode){
				baseUrl += "!reload.action?req="+Math.random();
				$.getJSON(baseUrl,{},function(json){
					if(json.status === '1'){
						alert('系统权限已经下发成功');
					}else{
						alert('系统权限已经下发失败');
					}
				});
			}else if('listPerm' === opCode){
				baseUrl += "!listPermissions.action"+query;
				baseUrl += "&menuId="+$("#menuId").val();
				window.location.href = baseUrl;
			}
		}
//-->
</script>
<body>
<x:query stmt="角色管理查询" var="datas"></x:query>
<x:qx var="qx" menuId="${menuId }"></x:qx>
<div class="title"><span>当前位置：</span><x:menu menuId="${menuId}"/></div>
<div class="dataGrid">	
<s:form action="tRmsRole!list" namespace="/plat/auth" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${menuId}" id="menuId">
	<div class="editBlock" style="padding-right:0px;padding-left:0px">
 		<table>
 			<tr>
              <td colspan="4" class="subtitle"  title="点击可展开或关闭">查询条件</td>
            </tr>
            <tbody>
              <tr>
                <th width="120">角色ID：</th>
                <td><s:textfield name="bean.jsid" cssClass="inputText"/></td>
                <th width="120">角色名称：</th>
                <td><s:textfield name="bean.jsmc" cssClass="inputText"/></td>
              </tr>
               <tr>
                <th width="120">关联用户信息： </th>
                <td><s:textfield name="userInfo" cssClass="inputText"  value="%{#parameters.userInfo}"/></td>
                <th width="120">关联菜单信息：</th>
                <td><s:textfield name="menuInfo" cssClass="inputText" value="%{#parameters.menuInfo}"/></td>
              </tr>
              <tr>
                <td colspan="4" class="toolbar" style="text-align: right;">
                <input name="button" onclick="opreate('','query');"  type="button" class="inputButton" value=" 查 询 " />
                <c:if test="${qx.add }">
		        	<li class="click add" onclick="opreate('','add');">添加</li>
				</c:if>
				<c:if test="${user.admin }">
					<li class="click setting" onclick="opreate('','reload');">权限下发</li>
               	</c:if>
                </td>
              </tr>
            </tbody>
          </table>
		</div>
			<%--<div class="tools">
				<ul class="toolbar">
					<c:if test="${qx.add }">
		        		<li class="click"  onclick="opreate('','add');"><span><img src="${ctx }/skins/uimaker/images/t01.png" /></span>添加</li>
					</c:if>
					  <c:if test="${user.admin }">
              			  <li class="click"  onclick="opreate('','reload');"><span><img src="${ctx }/skins/uimaker/images/lc04.png" style="width:24px;height:24px" /></span>权限下发</li>
                	</c:if>
		        </ul>
			</div>
		  --%><table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th>角色ID</th>
                <th>角色名称</th>
                <th>角色描述</th>
                <th>排序号</th>
                <th>是否有效</th>
                <th>分配菜单</th>
                <th>分配用户</th>
                <th>分配权限</th>
                 <th>操作</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas.rows}" var="item"  varStatus="stat">
	            <tr>
	                <td>${stat.count }</td>
                   	<td>${item.JSID}</td>
                   	<td nowrap="nowrap">${item.JSMC}</td>
                   	<td>${item.JSMS}</td>
                   	<td>${item.PXH}</td>
                   	<td><x:cache subject="OPTION01" key="${item.SFYX}"/></td>
                   	<td nowrap="nowrap">
                   	<c:if test="${qx.update }"><a href="javascript:void(0);"  title="分配菜单" onclick="opreate('${item.JSID }','treeList');">分配菜单</a></c:if>
                   	<c:if test="${qx.update ne true }"><span class="note">无权限</span></c:if>
                   	</td>
                   	<td nowrap="nowrap">
                   		<c:if test="${qx.update }"><a href="javascript:void(0);"  title="分配用户" onclick="opreate('${item.JSID }','listUser');">分配用户</a></c:if>
                   	    <c:if test="${qx.update ne true }"><span class="note">无权限</span></c:if>
                   	</td>
                   	<td nowrap="nowrap">
                   	<c:if test="${qx.update }"><a href="javascript:void(0);"  title="分配权限" onclick="opreate('${item.JSID }','listPerm');">分配权限</a></c:if>
                   	    <c:if test="${qx.update ne true }"><span class="note">无权限</span></c:if>
                   	</td>
                 	 <td nowrap="nowrap">
                 	 <c:if test="${qx.update }"><a href="javascript:void(0);" class="tablelink" title="修改" onclick="opreate('${item.JSID }','update');">修改</a></c:if>
                 	 <c:if test="${qx.delete }"><a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.JSID }','delete');">删除</a></c:if>
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
</div><!-- dataGrid end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
