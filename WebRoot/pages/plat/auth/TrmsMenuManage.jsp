<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<link rel="stylesheet" href="${ctx}/scripts/plugins/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="${ctx}/scripts/jquery.ztree.all-3.4.min.js"></script>
<script type="text/javascript">
 		var setting = {
					data: {
					key: {
						name: "SHOWNAME"
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
					var url = baseUrl +"&bean.pcdid="+treeNode.CDID;
					$("#menuContent").attr("src",url);	
		}
		var baseUrl = "${ctx}/plat/auth/tRmsMenuinfo!list.action?menuId=${param.menuId}";
		$(document).ready(function(){
			$("#menuContent").attr("src",baseUrl);
			var zNodes = eval( $("#json").val());
			$(zNodes).each(function(){
				var pxh = 0;
				if(this['PXH']){
					pxh = this['PXH'];
				}
				this['SHOWNAME'] = pxh+"."+this['CDMC']
				
			});
			$.fn.zTree.init($("#menuTree"), setting, zNodes);
		});

</script>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<x:query stmt="菜单管理查询" var="datas" asJson="true" paged="false"></x:query>
<textarea rows="" cols="" id="json" style="display: none;">
${datas }
</textarea>
  <div class="editBlock">
  <table width="100%">
    <tr>
      <td valign="top" width="150" style="background-color:#f5f8fa; " >
      <div id="tree" class="editBlock" style="height: 560px;overflow-x:scroll; width: 210px;background-color:#f5f8fa;">
       <ul id="menuTree" class="ztree"></ul>
      </div>
      </td>
       <td valign="top"><iframe id="menuContent" src="#" frameborder="0" width="100%" height="450" scrolling="auto" onload="autoHeight(this);"></iframe></td>
    </tr>
  </table>
</div>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
