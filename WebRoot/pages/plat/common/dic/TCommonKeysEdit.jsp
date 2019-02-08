<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-10-28 12:51:07
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">
<!--
	function opreate(args,opCode){
		if(opCode == 'newSub'){
			var url = "${ctx}/plat/common/tCommonSubkeys!select.action";
			var querys = "?bean.code="+args;
			$("#mainFrame").attr("src",url+querys);
		}else if(opCode === 'reload'){
			var url = "${ctx}/plat/common/tCommonKeys!reload.action";
			var querys = "?bean.code="+args;
			$.post(url+querys,{},function(data){
				if($.trim(data) === '1'){
					alert('系统缓存加载成功');
				}else{
					alert('系统缓存加载失败');
				}
			});
		}
	}
//-->
</script>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<s:form action="tCommonKeys!save" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<s:token name="keys_token"></s:token>
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
<div class="tabBlock" id="tabBlock" >
  <div class="editBlock">
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >字典信息</td>
      </tr>
       <tbody>
       <tr>
       	   <th width="120"><span class="warning">*</span>字典键值：</th>
           <td>
           <c:choose>
           		<c:when test="${not empty bean.code}"><s:textfield  name="bean.code" readonly="true" cssClass="inputText" id="code"/></c:when>
           		<c:otherwise><s:textfield  name="bean.code"  cssClass="inputText" id="code"/></c:otherwise>
           </c:choose>
           <em  class="valid" title="字典键值是必须录入项。" lang="*"></em>
           </td>
        </tr>
        <tr>
       	   <th width="120"><span class="warning">*</span>字典名称：</th>
           <td><s:textfield  name="bean.cname" cssClass="inputText" id="cname"/>
          		 <em  class="valid" title="字典名称是必须录入项。" lang="*"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120">父字典键：</th>
           <td><s:textfield  name="bean.pcode" cssClass="inputText" id="pcode"/></td>
        </tr>
       
       <tr>
       	   <th width="120"><span class="warning">*</span>是否有效：</th>
           <td>
          	<select name="bean.valid" id="valid" class="select2" style="width: 135px;">
          	<option value="">--请选择是否有效--</option>
          	<x:cache subject="OPTION01"  option="true" selected="${bean.valid}"/>
          	</select>
            <em  class="valid" title="是否有效是必须录入项。" lang="*"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120">参数1名称：</th>
           <td><s:textfield  name="bean.pname1" cssClass="inputText" id="pname1"/></td>
        </tr>
       <tr>
       	   <th width="120">参数2名称：</th>
           <td><s:textfield  name="bean.pname2" cssClass="inputText" id="pname2"/></td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>排序号：</th>
           <td>
           <s:textfield  name="bean.seq" cssClass="inputText" id="seq" cssStyle="width:90px;"/>
           <em  class="valid" title="排序号输入必须是数字类型。" lang="n"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120">备注说明：</th>
       	   <td>
          <s:textarea name="bean.des" cssClass="textinput2"  id="cdms"></s:textarea>
           </td>
        </tr>
       </tbody>
      <tr>
        <td colspan="2" class="toolbar" style="text-align: right;">
        <input type="button"  class="inputButton" onclick="$('#opForm').submit();" value=" 保 存 " />
        <c:if test="${not empty bean.code}">
        <input type="button"  class="inputButton" onclick="opreate('${bean.code }','newSub');" value="增加子键" />
        <input type="button"  class="inputButton" onclick="opreate('${bean.code }','reload');" value=" 重 载 " />
        </c:if>
        <input type="button"  class="cancel" value=" 返 回 " id="returnButton"/>
        &nbsp;&nbsp;
        </td>
      </tr>
    </table>
    <c:if test="${not empty bean.code}">
    <iframe  frameborder="0" id="mainFrame"  src="${ctx}/plat/common/tCommonSubkeys!list.action?bean.code=${bean.code}" scrolling="no" style="width:100%;height:100%;" onload="autoHeight(this);"></iframe>
    </c:if>
      </div>
</div>
</s:form>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
