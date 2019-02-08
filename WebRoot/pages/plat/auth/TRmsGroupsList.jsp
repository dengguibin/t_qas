<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-17 23:51:48
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx}/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/auth/tRmsGroups";
			var query = "?bean.yhzid="+args;
			if('update' === opCode){
				$.registerForm('opForm');
				baseUrl += "!select.action"+query;
				window.location.href = baseUrl;
			}else if('delete' === opCode){
				var result = window.confirm("确定要永久删除选中数据？");
					if(result){
					baseUrl += "!delete.action"+query;
					$.post(baseUrl,{},function(data){
						$("#opForm").submit();
					});
					}
			}else if('add' === opCode){
				$("#yhzid").val('');
				baseUrl += "!select.action";
				$.registerForm('opForm');
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}else if('manage' === opCode){
				baseUrl += "!listUser.action"+query;
				$.dialog({
				lock: true, 
				max: false, 
    			min: false ,
				title:'分配菜单',
				width:'360px',
				height:'460px',
				content: 'url:'+baseUrl});
				//$("#opForm").submit();
			}
		}
		
		$(document).ready(function(){
			if($("#yhzid").val() == ''){
				$("#toolkit>input").attr("disabled",true);
			}
			
		
		});
//-->
</script>
<body >
<x:query stmt="用户组与用户管理查询" var="datas"></x:query>

<s:form action="tRmsGroups!list" namespace="/plat/auth" method="post" 
id="opForm" name="opForm">
<div class="dataGrid" style="padding: 0;">
<s:hidden name="bean.yhzid" id="yhzid"></s:hidden>
<s:hidden name="bean.fyhzid" id="fyhzid"></s:hidden>
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
	<div class="editBlock" style="padding-right:0px;padding-left:0px;padding-top: 0px;">
 		<table>
 			<tr>
              <td colspan="4" class="subtitle"  title="点击可展开或关闭">查询条件</td>
            </tr>
            <tbody>
              <tr>
                <th width="120">用户组名称：</th>
                <td><s:textfield name="bean.yhzmc" cssClass="inputText"></s:textfield></td>
                <th width="120">用户名称：</th>
                <td>
                <s:textfield name="bean.yhzms" cssClass="inputText"></s:textfield>
                </td>
              </tr>
              <tr>
                <td colspan="4" class="toolbar" style="text-align: right;">
                <input name="button" type="button" class="inputButton" onclick="opreate('','query');" value=" 查 询 " />
                </td>
              </tr>
            </tbody>
          </table>
		</div>
		
		<div class="tools">
			<ul class="toolbar">
        		<li class="click"  onclick="opreate('${bean.yhzid }','manage');"><span><img src="${ctx }/skins/uimaker/images/icon06.png" style="width:24px;height:24px" /></span>管理用户</li>
       			<li class="click"  onclick="opreate('','add');"><span><img src="${ctx }/skins/uimaker/images/t01.png" /></span>增 加 组</li>
       			<li class="click"  onclick="opreate('${bean.yhzid }','update');"><span><img src="${ctx }/skins/uimaker/images/t02.png" /></span>修改 组</li>
        		<li  class="click"  onclick="opreate('${bean.yhzid }','delete');"><span><img src="${ctx }/skins/uimaker/images/t03.png" /></span>删 除 组</li>
        	</ul>
		</div>
		
		
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th>用户组名称</th>
                <th>用户名称</th>
                <th>排序号</th>
                <th>是否有效</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas.rows}" var="item"  varStatus="stat">
	            <tr>
	                <td>&nbsp;${stat.count }</td>
                   	<td>&nbsp;${item.YHZMC}</td>
                   	<td>&nbsp;${item.YHMC}</td>
                   	<td>&nbsp;${item.SEQ}</td>
                   	<td>&nbsp;
                   		<x:cache subject="OPTION01" key="${item.SFYX}"></x:cache>
                   	</td>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
			<%@include file="/pages/t_qas/layout/page.jsp" %>
          </div><!-- dataGrid end -->
</s:form>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
