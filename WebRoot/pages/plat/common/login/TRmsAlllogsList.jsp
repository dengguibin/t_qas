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
			var baseUrl = "${ctx}/plat/common/tRmsAlllogs";
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
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<div class="dataGrid">
<s:form action="tRmsAlllogs!list" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${menuId}" id="menuId">

	 <div class="itab tabson">
		  	<ul> 
		    <li><a href="${ctx }/plat/common/tRmsLogininfo!list.action?menuId=${menuId}" >登陆日志</a></li> 
		    <li><a href="${ctx }/plat/common/tRmsAlllogs!list.action?menuId=${menuId}"   class="selected" >操作日志</a></li> 
		  	</ul>
	</div>
<div class="filter">
 		<table>
            <tbody>
              <tr>
                <th>账号/IP地址：</th>
                <td>
                	<s:textfield name="bean.account" cssClass="inputText"></s:textfield>
                </td>
                <th>操作结果：</th>
                <td>
                	<select name="bean.opresult" id="opresult" class="select2" style="width: 135px;">
		          	<option value="">--请选择操作结果--</option>
		          	<option value="1" ${bean.opresult eq '1' ? 'selected' : '' } >操作成功</option>
		          	<option value="0" ${bean.opresult eq '0' ? 'selected' : '' } >操作异常</option>
		          	</select>
                </td>
                 <th>操作时间：</th>
                <td>
               <input class="inputDate" id="startTime" name ="bean.startTime" value="${bean.startTime}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\',{d:0});}'})"/>
                </td>
                <td>-</td>
                <td><input class="inputDate" id="endTime" name ="bean.endTime" value="${bean.endTime}"   onClick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startTime\',{d:0});}'})"/></td>
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
                <th>操作结果</th>
                <th>操作时间</th>
                <th>操作类型</th>
                <th>业务路径</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	                <td>&nbsp;${stat.count }</td>
                   	<td>&nbsp;${item.ACCOUNT}</td>
                   	<td>&nbsp;${item.ADDR}</td>
                   	<td>&nbsp;
                   		<c:choose>
                   			<c:when test="${item.OPRESULT eq 1 }">成功</c:when>
                   			<c:otherwise><font class="warning">异常</font> </c:otherwise>
                   		</c:choose>
                   	</td>
                   	<td>&nbsp;
                   	<fmt:formatDate value="${item.LOGTIME}" pattern="yyyy-MM-dd kk:mm:ss"/>
                   	</td>
                   	<td>&nbsp;${item.DESCR}</td>
                   	<td>&nbsp;${item.MENU}</td>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
           <%@include file="/pages/t_qas/layout/page.jsp" %>
  		
  		</s:form>
</div><!-- dataGrid end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
