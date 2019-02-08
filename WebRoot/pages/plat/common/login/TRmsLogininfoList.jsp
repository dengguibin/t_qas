<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-10-28 17:12:16
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/common/tRmsLogininfo";
			var query = "?bean.code="+args+"&menuId="+$("#menuId").val();;
			if('update' === opCode){
				baseUrl += "!select.action"+query;
				window.location.href = baseUrl;
			}else if('delete' === opCode){
				baseUrl += "!delete.action"+query;
				$.post(baseUrl,{},function(data){
				});
			}else if('add' === opCode){
				baseUrl += "!select.action?menuId="+$("#menuId").val();;
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}
		}
//-->
</script>
<body>
<x:query stmt="用户登陆日志" var="datas" mode="1"></x:query>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<div class="dataGrid">
<s:form action="tRmsLogininfo!list" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${menuId}" id="menuId">
	 <div class="itab tabson">
		  	<ul> 
		    <li><a href="${ctx }/plat/common/tRmsLogininfo!list.action?menuId=${menuId}"  class="selected">登陆日志</a></li> 
		    <li><a href="${ctx }/plat/common/tRmsAlllogs!list.action?menuId=${menuId}"   >操作日志</a></li> 
		  	</ul>
	</div>

<div class="filter">
 		<table>
            <tbody>
              <tr>
                <th>用户账号：</th>
                <td>
                	<s:textfield name="bean.account" cssClass="inputText"></s:textfield>
                </td>
                <th>登录结果：</th>
                <td>
                	<select name="bean.opresult" id="opresult" class="select2" style="width: 135px;">
		          	<option value="">--请选择登录结果--</option>
		          	<x:cache subject="OPRESULT"  option="true" selected="${bean.opresult}"/>
		          	</select>
                </td>
                   <th>登录时间：</th>
                <td>
               <input class="inputDate" id="startTime" name ="bean.startTime" value="${bean.startTime}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\',{d:0});}'})"/>
                </td>
                <td>-</td>
                <td><input class="inputDate" id="endTime" name ="bean.endTime" value="${bean.endTime}"   onClick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startTime\',{d:0});}'})"/></td>
                <td>
                <td>
                <input name="button" onclick="opreate('','query');" type="button" class="inputButton" value=" 查 询 " />
                </td>
              </tr>
            </tbody>
          </table>
          </div>
		
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th>用户账号</th>
                <th>IP地址</th>
                <th>登录结果</th>
                <th>登录时间</th>
                <th>登出时间</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas.rows}" var="item"  varStatus="stat">
	            <tr>
	                <td>${stat.count }</td>
                   	<td>${item.ACCOUNT}</td>
                   	<td>${item.ADDR}</td>
                   	<td>${item.CONTENTS}</td>
                   	<td>	<fmt:formatDate value="${item.LOGTIME}" pattern="yyyy-MM-dd kk:mm:ss"/></td>
                   	<td>	<fmt:formatDate value="${item.OUTTIME}" pattern="yyyy-MM-dd kk:mm:ss"/></td>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
           <%@include file="/pages/t_qas/layout/page.jsp" %>
  		
  		</s:form>
</div><!-- dataGrid end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
