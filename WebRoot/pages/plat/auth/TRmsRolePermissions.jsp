<%@page import="com.upath.plat.common.util.VTree"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<link rel="stylesheet" href="${ctx}/scripts/plugins/zTreeStyle/zTreeStyle.css" />
<link href="${ctx }/scripts/plugins/treetable/css/jquery.treetable.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/scripts/plugins/treetable/css/jquery.treetable.theme.default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/scripts/jquery.ztree.all-3.4.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/plugins/treetable/jquery.treetable.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/auth/tRmsDeptment";
			var query = "?bean.bmid="+args+"&menuId="+$("#menuId").val();
			if('save' === opCode){
				baseUrl += "!select.action"+query;
				window.location.href = baseUrl;
			}
		}
		
		
		function selectNodes(obj,type){
			$("input[att='"+type+"']").attr("checked",obj.checked);
		}
		
		
		//CHECKBOX 进行初始化是否选中
		$(document).ready(function(){
			$(".ctrBox").each(function(){
				var value = $(this).val();
				//移位操作
				value =  1 << value;
				var type = $(this).attr("id");
				$("input[att='"+type+"']").each(function(){
					var opV = $(this).val();
					if((value & opV) > 0){
						$(this).attr("checked","checked");
					}
				});
								
			
			});
		});
		
		
		
	function saveAtt(){
		//字典，加快JS的运算效果
			var dic = {};
			$(".ctrBox").each(function(){
				var value = $(this).val();
				//移位操作
				value =  1 << value;
				var type = $(this).attr("id");
				dic[type] = value;
			});
		
		var nIds = "";
		var nVds = "";
		
		$(".menuCtr").each(function(){
			var type = $(this).attr("mid");
			var style = 0;
			$(".menu"+type).each(function(){
				if(this.checked){
					var loc = $(this).attr("att");
					style |= dic[loc];
				}
					
			});
			$(this).val(style);
			nIds += type+",";
			nVds += style+",";
		});
		
		
		var url = "${ctx}/plat/auth/tRmsRole!savePermissions.action";
					var datas = {};
						datas['menuIds'] = nIds;
						datas['userIds'] = nVds;
					$.getJSON(url,datas,function(data){
						if(data.result === 1){
							alert("权限分配菜单成功");
						}else{
							alert("权限分配菜单失败");
						}
							
					});
		
		}
	
	
	$(function(){
		$("#dataTable").treetable({ expandable: true , column : 1});
		$("#dataTable").treetable('expandAll');
	});
//-->
</script>
<body>
<c:catch>
<x:query stmt="系统菜单配置功能查询" var="funcDatas" paged="false"></x:query>
</c:catch>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<div class="tabBlock">	
<s:form action="tRmsDeptment!list" namespace="/plat/auth" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
	<div class="editBlock">
 		<table>
            <tbody>
              <tr>
              	<td class="toolbar"><font color="red">菜单树结构的重新调整会对此显示有影响</font> </td>
                <td colspan="4" class="toolbar" style="text-align: right;">
                <input name="button" onclick="saveAtt();" type="button" class="inputButton" value=" 保 存 " />
                 <input type="button"  class="cancel" value=" 返 回 " id="returnButton"/>
                </td>
              </tr>
            </tbody>
          </table>
		</div>
		<div class="dataGrid">
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th>菜单名称</th>
               	<c:forEach items="${perms}" var="per">
               		 <th>${per.name }<input type="checkbox" id="${per.id }" class="ctrBox" value="${per.stat }" name="${per.name }" onclick="selectNodes(this,'${per.id }')">   </th>
               	</c:forEach>
              </tr>
            </thead>
            
            <tbody class="tableHover">
             <c:set value="${datas}" var="rrows" scope="request"></c:set>
            <%
            	List list = (List)request.getAttribute("rrows");
          		List sorts = VTree.buildMapVTree(list, "CDID", "PCDID", null).asDataList();
            	request.setAttribute("sorts", sorts);
            %>
            <c:forEach items="${sorts}" var="item"  varStatus="stat">
	            <tr data-tt-id="${item.CDID }" data-tt-parent-id="${item.PCDID }">
	                <td>&nbsp;${stat.count }
	                	<input type="hidden" class="menuCtr" value="${item.STAT }" mid="${item.RID }">
	                </td>
                   	<td style="text-align: left;"> ${item.CDMC} </td>
                   	<c:forEach items="${perms}" var="per">
               		 <td>
               		 <input class="menu${item.RID }" type="checkbox" value="${item.STAT }" att="${per.id }">
              			<c:forEach items="${funcDatas.rows }" var="funcItem">
               		  	<c:if test="${item.CDID eq funcItem.CDID }">
               		  		<c:if test="${funcItem.CODE eq per.id }">
               		  			<a style="display: block;">${funcItem.NAME }</a>
               		  		</c:if>
               		  	</c:if>
               		  	</c:forEach>
               		  </td>
               		</c:forEach>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
          </div><!-- dataGrid end -->
</s:form>
</div><!-- editBlock end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
