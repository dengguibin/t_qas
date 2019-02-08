<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-11 21:51:54
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/plat/frame/header.jsp" %>
<link rel="stylesheet" href="${ctx}/scripts/plugins/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="${ctx}/scripts/jquery.ztree.all-3.4.min.js"></script>
<script type="text/javascript">
 		var setting = {
		 		check: {
						enable: true
					},
					data: {
					key: {
						name: "CDMC",
						checked: "CHECKED"
					},
					simpleData: {
						enable: true,
						idKey: "CDID",
						pIdKey: "PCDID"
						}
					},
			callback: {
				onClick: onClick
			}
		};
		function onClick(event, treeId, treeNode, clickFlag) {
			//window.returnValue  = treeNode;
			//window.close();
		}
		
		var tree;
		$(document).ready(function(){
			var zNodes = eval($("#json").val());
			tree =$.fn.zTree.init($("#menuTree"), setting, zNodes);
		});

		function saveTree(){
			var nodes = tree.getCheckedNodes(true);
				if(nodes){
					var nIds = "";
					for(var i = 0 ; i < nodes.length ; i++){
						var node = nodes[i];
						nIds += node.CDID+",";
					}
					
					var url = "${ctx}/plat/auth/tRmsRole!saveTree.action";
					var datas = {};
						datas['menuIds'] = nIds;
						datas['bean.jsid'] = $("#jsid").val();
					
					$.getJSON(url,datas,function(data){
						
						if(data.result === 1){
							alert("角色分配菜单成功");
						}else{
							alert("角色分配菜单失败");
						}
							
					});
					
				}
				
		}

</script>
<body style="overflow-x:hidden;padding-right: 1em;height: 100%;">
<div class="tabBlock">	
	<div class="editBlock">
	<table style="width: 100%;">
	<tbody>
			 <tr>
			 	<td class="toolbar" width="50%">
			 		<span class="tip">勾选项为已拥有菜单</span>
			 	</td>
                <td class="toolbar" style="text-align: right;" width="50%">
                <input name="button" type="button" onclick="saveTree();" class="inputButton" value=" 保 存 " />
                </td>
              </tr>
	
	</tbody>
	</table>
	<s:form action="tRmsRole!save" namespace="/plat/auth" method="post" 
		id="opForm" name="opForm">
		<s:hidden name="bean.jsid" id="jsid"></s:hidden>
		<textarea id="json" style="display: none;">${json }</textarea>
	</s:form>
 	<div class="content" style="padding: 0;">
		<ul id="menuTree" class="ztree"></ul>
	</div>
	</div>
</div><!-- editBlock end -->
</body>
<%@include file="/pages/plat/frame/footer.jsp" %>