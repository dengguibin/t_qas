<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-11 21:51:54
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<link rel="stylesheet" href="${ctx}/scripts/plugins/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="${ctx}/scripts/jquery.ztree.all-3.4.min.js"></script>
<script type="text/javascript">
 		var setting = {
					data: {
					key: {
						name: "BMMC"
					},
					simpleData: {
						enable: true,
						idKey: "BMID",
						pIdKey: "FBMID"
						}
					},
			callback: {
				onClick: onClick
			}
		};
		
		function onClick(event, treeId, treeNode, clickFlag) {
		
		var api = frameElement.api, W = api.opener; 
		W.initNode(treeNode);
		api.hide();
	//		frameElement.api.close();
	//		window.returnValue  = treeNode;
	//		window.close();
		}
		var tree;
		$(document).ready(function(){
			if($("#json").val()){
				var zNodes = eval($("#json").val());
				/* 
				$(zNodes).each(function(){
					this['TYPES'] = 'ORG';
					if(this['FBMID'] && this['FBMID'] != ''){
						
					}else{
						this['FBMID'] = this['UNIT_TYPE'];
					}
				});
				
				if($("#jsonTypes").val() != ''){
					var typeJson = eval($("#jsonTypes").val());
					$(typeJson).each(function(){
						this['TYPES'] = 'TYPES';
						this['BMID'] = this['subcode'];
						this['BMMC'] = this['cname'];
						zNodes.push(this);
					});
					
				}
				 */
				
				
				tree =$.fn.zTree.init($("#menuTree"), setting, zNodes);
				//默认展开菜单
				var root = tree.getNodeByTId('1');
				if(root){
					tree.expandNode(root);
				} 
			}
		});
</script>
<body style="overflow-x:hidden;padding-right: 1em;height: 100%;">
<div class="tabBlock">	
	<div class="editBlock">
	<s:form action="tRmsRole!save" namespace="/plat/auth" method="post" 
		id="opForm" name="opForm">
		<s:hidden name="bean.bmid" id="bmid"></s:hidden>
		<textarea id="json" style="display: none;">${json }</textarea>
		<textarea id="jsonTypes" style="display: none;">${jsonTypes }</textarea>
	</s:form>
 	<div class="content" style="padding: 0;">
		<ul id="menuTree" class="ztree"></ul>
	</div>
	</div>
</div><!-- editBlock end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
