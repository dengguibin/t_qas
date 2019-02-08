<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/plat/frame/header.jsp" %>
<link rel="stylesheet" href="${ctx}/scripts/plugins/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="${ctx}/scripts/jquery.ztree.all-3.4.min.js"></script>
<script type="text/javascript">
 		var setting = {
					data: {
					key: {
						name: "NAME"
					},
					simpleData: {
						enable: true,
						idKey: "TID",
						pIdKey: "PTID"
						}
					},
			callback: {
				onClick: onClick
			}
		};
		function onClick(event, treeId, treeNode, clickFlag) {
					var url = baseUrl +"&bean.ptid="+treeNode.TID;
					$("#menuContent").attr("src",url);	
		}
		var tree;
		var baseUrl = "${ctx}/plat/common/tCommonSql!list.action?menuId=${param.menuId}";
		$(document).ready(function(){
			$("#menuContent").attr("src",baseUrl);
			var	zNodes = eval( $("#json").val());;
		 	tree = $.fn.zTree.init($("#menuTree"), setting, zNodes);
			var root = tree.getNodeByParam('TID','1011',null);
				if(root){
					tree.expandNode(root);
				}
		});

</script>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<x:query stmt="SQL目录树查询" var="datas" asJson="true" paged="false"></x:query>
<textarea rows="" cols="" id="json" style="display: none;">
${datas }
</textarea>
<div class="tabBlock">
  <table width="100%">
    <tr>
      <td valign="top" width="150px">
     <div id="tree" class="editBlock" style="height: 560px;overflow-x:scroll; width: 210px;">
       <ul id="menuTree" class="ztree"></ul>
      </div>
      </td>
      <td>&nbsp;</td>
       <td valign="top"><iframe id="menuContent" src="#" frameborder="0" width="100%" height="450" scrolling="auto" onload="autoHeight(this);"></iframe></td>
    </tr>
  </table>
</div>
<%@include file="/pages/plat/frame/footer.jsp" %>
