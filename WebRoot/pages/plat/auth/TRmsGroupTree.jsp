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
					data: {
					key: {
						name: "YHZMC"
					},
					simpleData: {
						enable: true,
						idKey: "YHZID",
						pIdKey: "FYHZID"
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
		}
		var tree;
		$(document).ready(function(){
			if($("#json").val()){
				var zNodes = eval($("#json").val());
				tree =$.fn.zTree.init($("#menuTree"), setting, zNodes);
			}
		});
</script>
<body style="overflow-x:hidden;padding-right: 1em;height: 100%;">
<div class="tabBlock">	
	<div class="editBlock">
	<s:form action="tRmsGroups!save" namespace="/plat/auth" method="post" 
		id="opForm" name="opForm">
		<s:hidden name="bean.bmid" id="bmid"></s:hidden>
		<textarea id="json" style="display: none;">${json }</textarea>
	</s:form>
 	<div class="content" style="padding: 0;">
		<ul id="menuTree" class="ztree"></ul>
	</div>
	</div>
</div><!-- editBlock end -->
</body>
<%@include file="/pages/plat/frame/footer.jsp" %>
