<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-10-31 21:20:06
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<s:form action="tCommonSeq!save" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<s:token/>
<s:hidden name="bean.seqid"/>
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
<div class="tabBlock" id="tabBlock" >
  <div class="editBlock">
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
      </tr>
       <tbody>
       <tr>
       	   <th width="120"><span class="warning">*</span>序列名称：</th>
           <td>
           <c:choose>
           	<c:when test="${not empty bean.seqid}"><s:textfield  name="bean.name" cssClass="inputText" readonly="true" id="name"/></c:when>
           	<c:otherwise><s:textfield  name="bean.name" cssClass="inputText" id="name"/></c:otherwise>
           </c:choose>
           <em  class="valid" title="序列名称必须是4到8个字符组成。" lang="s4-8"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>最小值：</th>
           <td>
           <s:textfield  name="bean.minval" cssClass="inputText" id="minval" cssStyle="width:90px;"/>
           <em  class="valid" title="最小值输入必须是数字类型。" lang="n"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>最大值：</th>
           <td>
           <s:textfield  name="bean.maxval" cssClass="inputText" id="maxval" cssStyle="width:90px;"/>
           <em  class="valid" title="最大值输入必须是数字类型。" lang="n"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>开始位置：</th>
           <td>
           <s:textfield  name="bean.spos" cssClass="inputText" id="spos" cssStyle="width:90px;"/>
           <em  class="valid" title="开始位置输入必须是数字类型。" lang="n"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>步长：</th>
           <td>
           <s:textfield  name="bean.steps" cssClass="inputText" id="steps" cssStyle="width:90px;"/>
           <em  class="valid" title="步长输入必须是数字类型。" lang="n"></em>
           </td>
        </tr>
       	<tr>
       	   <th width="120">备注说明：</th>
       	   <td><div class="smsEdit" style="width:380px;"></div>
          <s:textarea name="bean.des" cssClass="textinput2" id="cdms"></s:textarea>
           </td>
        </tr>
       </tbody>
        <tr>
        <td colspan="2" class="toolbar" >
        <input type="button"  class="inputButton" onclick="$('#opForm').submit();" value=" 保 存 " />
        <c:if test="${not empty bean.seqid}">
        <input type="button"  class="inputButton" onclick="opreate('${bean.seqid }','newSub');" value="增加序列" />
        </c:if>
        <input type="button"  class="cancel" value=" 返 回 " id="returnButton"/>
        &nbsp;&nbsp;
        </td>
      </tr>
    </table>
      <c:if test="${not empty bean.seqid}">
    <iframe  frameborder="0" id="mainFrame"  src="${ctx}/plat/common/tCommonSeqvalue!list.action?bean.seqid=${bean.seqid}" scrolling="no" style="width:100%;height:100%;" onload="autoHeight(this);"></iframe>
   	 </c:if>
      </div>
</div>
</s:form>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
