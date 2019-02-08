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
						name: "YHMC",
						checked: "CHECKED"
					},
					simpleData: {
						enable: true,
						idKey: "YHID",
						pIdKey: "BMID"
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
			/* 
			$(zNodes).each(function(){
				//this['TYPES'] = 'ORG';
				if(this['BMID'] && this['BMID'] != ''){
					
				}else{
					this['BMID'] = this['UNIT_TYPE'];
				}
			});
			
			if($("#jsonTypes").val() != ''){
				var typeJson = eval($("#jsonTypes").val());
				$(typeJson).each(function(){
					this['TYPES'] = 'TYPES';
					this['YHID'] = this['subcode'];
					this['YHMC'] = this['cname'];
					zNodes.push(this);
				});
				
			} */
			tree =$.fn.zTree.init($("#menuTree"), setting, zNodes);	
			
	 		var root = tree.getNodeByTId('1');
				if(root){
					tree.expandNode(root);
				} 
		});

		
	function saveUser() {
		var nodes = tree.getCheckedNodes(true);
		if (nodes) {
			var nIds = "";
			for ( var i = 0; i < nodes.length; i++) {
				var node = nodes[i];
				if (node.TYPE == 'U') {
					nIds += node.YHID + ",";
				}
			}

			var url = "${ctx}/plat/auth/tRmsRole!saveUser.action?V="
					+ Math.random();
			var datas = {};
			datas['userIds'] = nIds;
			datas['bean.jsid'] = $("#jsid").val();

			$.getJSON(url, datas, function(data) {

				if (data.result === 1) {
					alert("角色授权用户成功");
				} else {
					alert("角色授权用户失败");
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
			 	<td class="toolbar" width="70%">
			 		<span class="tip">勾选项为已拥有权限用户</span>
			 	</td>
                <td class="toolbar" style="text-align: right;" width="50%">
                <input name="button" type="button" onclick="saveUser();" class="inputButton" value=" 保 存 " />
                </td>
              </tr>
	
	</tbody>
	</table>
	<s:form action="tRmsRole!save" namespace="/plat/auth" method="post" 
		id="opForm" name="opForm">
		<s:hidden name="bean.jsid" id="jsid"></s:hidden>
		<textarea id="json" style="display: none;">${json }</textarea>
		<textarea id="jsonTypes" style="display: none;">${jsonTypes }</textarea>
	</s:form>
 	<div class="content" style="padding: 0;">
		<ul id="menuTree" class="ztree"></ul>
	</div>
	</div>
</div><!-- editBlock end -->
</body>
<%@include file="/pages/plat/frame/footer.jsp" %>
