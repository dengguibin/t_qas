<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-3 13:54:18
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
						name: "cdmc"
					},
					simpleData: {
						enable: true,
						idKey: "cdid",
						pIdKey: "pcdid"
						}
					},
			callback: {
				onClick: onClick
			}
		};
		function onClick(event, treeId, treeNode, clickFlag) {
			
			if(frameElement && frameElement.api){
				var api = frameElement.api, W = api.opener; 
				W.initUserNode(treeNode);
				api.hide();
			}else{
				window.returnValue  = treeNode;
				window.close();
			}
		}
		var zNodes;
		$(document).ready(function(){
			var url = "${ctx}/main!listMenus.action?v="+Math.random();
			$.getJSON(url,{},function(json){
				zNodes = json;
				$.fn.zTree.init($("#menuTree"), setting, zNodes);
			});
		});

</script>
<body style="overflow-x:hidden;padding-right: 1em;height: 100%;">
<div class="tabBlock">	
	<div class="editBlock">
 	<div class="content" style="padding: 0;">
		<ul id="menuTree" class="ztree"></ul>
	</div>
	</div>
</div><!-- editBlock end -->
</body>
<%@include file="/pages/plat/frame/footer.jsp" %>
