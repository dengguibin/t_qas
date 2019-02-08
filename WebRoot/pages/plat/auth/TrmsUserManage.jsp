<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
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
					var url = baseUrl +"&bean.bmid="+treeNode.BMID;
					if(treeNode.level == 0){
						url = baseUrl;
					}
					$("#menuContent").attr("src",url);	
		}
		var baseUrl = "${ctx}/plat/auth/tRmsUser!list.action?menuId=${param.menuId}";
		
	$(document).ready(function() {
		$("#menuContent").attr("src", baseUrl);
		if ($("#json").val()) {
			var zNodes = eval($("#json").val());
			/*
			$(zNodes).each(function() {
				this['TYPES'] = 'ORG';
				if (this['FBMID'] && this['FBMID'] != '') {

				} else {
					this['FBMID'] = this['UNIT_TYPE'];
				}
			});

			if ($("#jsonTypes").val() != '') {
				var typeJson = eval($("#jsonTypes").val());
				$(typeJson).each(function() {
					this['TYPES'] = 'TYPES';
					this['BMID'] = this['subcode'];
					this['BMMC'] = this['cname'];
					zNodes.push(this);
				});

			}
			*/

			var tree = $.fn.zTree.init($("#menuTree"), setting, zNodes);
			//默认展开菜单
			var root = tree.getNodeByTId('1');
			if(root){
				tree.expandNode(root);
			}
			 
		}

	});
</script>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">
<s:form action="tRmsUser!list" namespace="/plat/auth" method="post" 
		id="opForm" name="opForm">
		<s:hidden name="bean.bmid" id="bmid"></s:hidden>
		<s:action name="tRmsDeptment!listTree" namespace="/plat/auth"></s:action>
		<textarea id="json" style="display: none;">${json }</textarea>
		<%-- <textarea id="jsonTypes" style="display: none;">${jsonTypes }</textarea> --%>
	</s:form>
  <table width="100%">
    <tr>
      <td valign="top" style="overflow: hidden;background-color:#f5f8fa;">
      <div id="tree" class="editBlock" style="height: 560px;overflow-x:scroll; width: 210px;background-color:#f5f8fa;">
       <ul id="menuTree"    class="ztree"></ul>
      </div>
      </td>
       <td valign="top" width="85%"><iframe id="menuContent" src="#" frameborder="0" width="100%" height="450" scrolling="auto" onload="autoHeight(this);"></iframe></td>
    </tr>
  </table>
</div>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
