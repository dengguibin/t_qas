<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-10-28 17:12:16
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/common/tCommonMessage";
			var query = "?bean.code="+args+"&menuId="+$("#menuId").val();;
			if('update' === opCode){
				var ids = '';
				//单条更新操作
				if(args && $.trim(args) != ''){
					ids = args;
				}else{
					//选择批量更新操作
					if($(".chk:checked").size() > 0){
						$(".chk:checked").each(function(){
							ids += ","+$(this).val();
						});
					}
					//删除第一个","号
					ids = ids.substring(1);
				}
				if($.trim(ids) != ''){
					baseUrl += "!updateMsgStatus.action?message.tid="+ids 
			    	$.post(baseUrl,{},function(data){
						$("#opForm").submit();
					});
				}else{
					alert('请选中需要更新的行数据!');
				}
			}else if('query' === opCode){
				$("#opForm").submit();
			}else if('config' === opCode){
				$.registerForm('opForm');
				baseUrl = "${ctx}/plat/common/tCommonConfig!list.action?bean.code=MSG_SMS&menuId=${menuId}"
			    window.location.href = baseUrl;
			}
		}
//-->
</script>
<style>
<!--
tr.unread td{font-weight: bold;}
-->
</style>
<body>
<div class="dataGrid">
<s:form action="tCommonMessage!listUserSysMsgs" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${menuId}" id="menuId">
		<div class="tools">
		<ul class="toolbar">
        <li  class="click" onclick="opreate('','update');"><span><img src="${ctx }/skins/uimaker/images/time.png" style="width: 24px;height: 24px;"/></span>标识已读</li>
        </ul>
		 </div>
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50"><input name="" type="checkbox" value="" checkSelector="Selector"/></th>
                <th width="50">序号</th>
                <th>消息标题</th>
                <th>消息内容</th>
                <th>已阅读</th>
                <th>发送时间</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr class="${item.STAT eq 0 ? 'unread' : '' }">
	                <td><input name="msgId" type="checkbox" class="chk" value="${item.TID }"  checkNode="Selector" /></td>
	                <td>&nbsp;${stat.count }</td>
                   	<td>&nbsp;${item.TITLE}</td>
                   	<td>&nbsp;${item.CONTENTS}</td>
                   	<td>&nbsp;
                   		<c:choose>
                   			<c:when test="${item.STAT eq 0 }">未读</c:when>
                   			<c:when test="${item.STAT eq 1 }">已读</c:when>
                   			<c:otherwise><font class="warning">异常</font> </c:otherwise>
                   		</c:choose>
                   	</td>
                   	<td>&nbsp;
                   	<fmt:formatDate value="${item.CJSJ}" pattern="yyyy-MM-dd kk:mm:ss"/>
                   	</td>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
           <%@include file="/pages/t_qas/layout/page.jsp" %>
  		
  		</s:form>
</div><!-- dataGrid end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
