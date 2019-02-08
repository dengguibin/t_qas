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
			if('delete' === opCode){
				var ids = '';
				//单条删除操作
				if(args && $.trim(args) != ''){
					ids = args;
				}else{
					//选择批量删除操作
					if($(".chk:checked").size() > 0){
						$(".chk:checked").each(function(){
							ids += ","+$(this).val();
						});
					}
					//删除第一个","号
					ids = ids.substring(1);
				}
				if($.trim(ids) != ''){
					$.dialog.confirm('你确定要删除选中的数据吗?', function(){
					    	$.dialog.tips('执行确定操作');
					    	baseUrl += "!remove.action?message.tid="+ids 
					    	$.post(baseUrl,{},function(data){
								$("#opForm").submit();
							});
					}, function(){
					    $.dialog.tips('执行取消操作');
					});
				}else{
					$.dialog.alert('请选中需要删除的行数据!');
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
<body>
<x:qx var="qx" menuId="${menuId }"></x:qx>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<div class="dataGrid">
<s:form action="tCommonMessage!listSystemMessages" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<input type="hidden" name="menuId" value="${menuId}" id="menuId">
	 <div class="itab tabson">
		  	<ul> 
		    <li><a href="${ctx }/plat/common/tCommonMessage!listMailMessages.action?menuId=${menuId}"   >邮件消息</a></li> 
		    <li><a href="${ctx }/plat/common/tCommonMessage!listShortMessages.action?menuId=${menuId}" >短信消息</a></li> 
		    <li><a href="${ctx }/plat/common/tCommonMessage!listSystemMessages.action?menuId=${menuId}" class="selected">系统消息</a></li> 
		  	</ul>
	</div>
<div class="filter" style="padding-top: 10px;">
 		<table>
            <tbody>
              <tr>
                <th>消息标题：</th>
                <td>
                	<s:textfield name="message.title" cssClass="inputText"></s:textfield>
                </td>
                <th>是否已阅读：</th>
                <td>
                	<select name="message.stat" id="opresult" class="select2" style="width: 135px;">
		          	<option value="">--请选择阅读情况--</option>
		          	<option value="1" ${message.stat eq '1' ? 'selected' : '' } >已阅读</option>
		          	<option value="0" ${message.stat eq '0' ? 'selected' : '' } >未阅读</option>
		          	</select>
                </td>
                 <th>发送时间：</th>
                <td>
               	<input class="inputDate" id="startTime" name ="message.startTime" value="${message.startTime}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\',{d:0});}'})"/>
                </td>
                <td><input class="inputDate" id="endTime" name ="message.endTime" value="${message.endTime}"   onClick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startTime\',{d:0});}'})"/></td>
                <td>
                <input name="button" onclick="opreate('','query');" type="button" class="inputButton" value=" 查 询 " />
                </td>
              </tr>
            </tbody>
          </table>
          </div>
		
	<c:if test="${qx.add }">
		<div class="tools">
		<ul class="toolbar">
        <li class="click setting"  onclick="opreate('','config');">消息配置</li>
        <li  class="click remove" onclick="opreate('','delete');">删除</li>
        </ul>
		 </div>
	</c:if>
		
		
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50"><input name="" type="checkbox" value="" checkSelector="Selector"/></th>
                <th width="50">序号</th>
                <th>接收人</th>
                <th>消息标题</th>
                <th>已阅读</th>
                <th>发送时间</th>
                <th>查看时间</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	                <td><input name="msgId" type="checkbox" class="chk" value="${item.TID }"  checkNode="Selector" /></td>
	                <td>&nbsp;${stat.count }</td>
                   	<td>&nbsp;${item.RECIVER}</td>
                   	<td>&nbsp;${item.TITLE}</td>
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
                   	<td>&nbsp;
                   	<fmt:formatDate value="${item.SDATE}" pattern="yyyy-MM-dd kk:mm:ss"/>
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
