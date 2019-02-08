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
		function  opreate(args,sub,opCode){
			var baseUrl = "${ctx}/plat/common/tCommonConfig";
			var query = "?bean.code="+args+"&bean.subcode="+sub+"&menuId="+$("#menuId").val();
			if('update' === opCode){
				var datas = {};
				datas['bean.code'] = args;
				datas['bean.subcode'] = sub;
				datas['bean.params1'] = $("#"+sub).val();
				baseUrl += "!updateParam.action?v="+Math.random();
				$.getJSON(baseUrl,datas,function(data){
					if(data.status == '1'){
						$.dialog.tips('设置邮件参数成功',1,'success.gif');
					}else{
						$.dialog.tips('设置邮件参数失败',1,'error.gif');
					}
				});
				
				
			}else if(opCode == 'send'){
				var code = $("#code").val();
				var title = '';
			 if(code == 'SMS'){
				 title = '短信测试';
				 baseUrl += "!toSendSms.action";
			 }else if(code == 'MAIL'){
				 title = '邮件测试';
				 baseUrl += "!toSend.action";
			 }else if(code == 'MSG_SMS'){
				 title = '系统消息测试';
				 baseUrl += "!toSendSystemMsg.action";
			 }
			 baseUrl += "?bean.code="+code;
				if(title != ''){
					$.dialog({
						lock: true, 
						max: false, 
		    			min: false ,
						title:title,
						width:'540px',
						height:'420px',
						content: 'url:'+baseUrl});
				}
			}
		}
//-->
</script>
<body>
 <x:qx var="qx" menuId="${param.menuId}"></x:qx>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<x:page var="datas" stmt="list" params="${bean}" mapperClass="${mapper}"></x:page>
<div class="dataGrid" >	
<s:form action="tCommonSubkeys!list" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<s:hidden name="menuId" id="menuId"></s:hidden>
<s:hidden name="bean.code" id="code"></s:hidden>
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
      <c:set value="class='selected'" var="active"/>
       <div class="itab tabson">
		  	<ul> 
		    <li><a href="${ctx }/plat/common/tCommonMessage!listMailMessages.action?menuId=${menuId}"  ${bean.code eq 'MAIL' ? active : '' } >邮件消息</a></li> 
		    <li><a href="${ctx }/plat/common/tCommonMessage!listShortMessages.action?menuId=${menuId}" ${bean.code eq 'SMS' ? active : '' }>短信消息</a></li> 
		    <li><a href="${ctx }/plat/common/tCommonMessage!listSystemMessages.action?menuId=${menuId}" ${bean.code eq 'MSG_SMS' ? active : ''}>系统消息</a></li> 
		  	</ul>
	   </div>   
          	<div class="tools" style="padding-top:8px">
				<ul class="toolbar">
				<c:if test="${bean.code eq 'MAIL' }"><li class="click"  onclick="opreate('','','send')"><span><img src="${ctx }/skins/uimaker/images/lc00.png" style="width:24px;height:24px"/></span>测试邮件</li></c:if>
				<c:if test="${bean.code eq 'SMS' }"><li class="click"  onclick="opreate('','','send')"><span><img src="${ctx }/skins/uimaker/images/lc00.png" style="width:24px;height:24px"/></span>测试短信</li></c:if>
				<c:if test="${bean.code eq 'MSG_SMS' }"><li class="click"  onclick="opreate('','','send')"><span><img src="${ctx }/skins/uimaker/images/lc00.png" style="width:24px;height:24px"/></span>测试消息</li></c:if>
        		 <input type="button"  class="cancel" value=" 返 回 " id="returnButton"/>
        		</ul>
		 	</div>
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
                <th width="50">序号</th>
                <th width="70">参数代码</th>
                <th >参数名称</th>
                <th >配置值</th>
                <th >备注说明</th>
                 <th width="70">是否有效</th>
                 <th width="70">操作</th>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	                <td>&nbsp;${stat.count }</td>
	                <td>&nbsp;${item.SUBCODE }</td>
                   	<td>&nbsp;${item.CNAME}</td>
                   	<td style="padding-left: 0px;text-indent: 3px;">
                   	<input type="text" name="params" id="${item.SUBCODE }" code="${item.CODE }" value="${item.PARAMS1}" class="inputText" style="width: 98%;">
                   	</td>
                   	<td>&nbsp;${item.DES}</td>
                   	<td>&nbsp;<x:cache subject="OPTION01" key="${item.VALID}"/></td>
                 	 <td>&nbsp;
                 	 		<a href="javascript:void(0);" class="tablelink"  title="保存" onclick="opreate('${item.CODE }','${item.SUBCODE }','update');">&nbsp;保存</a>
                 	 </td>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
          <%@include file="/pages/t_qas/layout/page.jsp" %>
</s:form>
</div><!-- editBlock end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
