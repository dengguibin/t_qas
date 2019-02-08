<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-10-31 21:20:06
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title" style="display: none;"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<s:form action="tCommonSeqvalue!save" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<s:token></s:token>
<s:hidden name="bean.seqid" id="seqid"></s:hidden>
<s:hidden name="bean.tid" id="tid"></s:hidden>
<div class="tabBlock" id="tabBlock" >
  <div class="editBlock" style="width: 100%;margin: 0;padding: 0;">
  <br>
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
      </tr>
       <tbody>
       <tr>
       	   <th width="120"><span class="warning">*</span>序列类型：</th>
           <td>
           	<c:if test="${not empty bean.tid}"><s:textfield readonly="true"  name="bean.seqtype" cssClass="inputText" id="seqtype"/></c:if>
           	<c:if test="${empty bean.tid}"><s:textfield  name="bean.seqtype" cssClass="inputText" id="seqtype"/></c:if>
           <em  class="valid" title="序列类型必须是4到8个字符组成。" lang="s4-20"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120">序列当前值：</th>
           <td>
           <s:textfield  name="bean.cvalue" cssClass="inputText" id="cvalue"/>
           <em  class="valid" title="序列当前值输入必须是数字类型。" lang="n"></em>
           &nbsp;<span class="tip">
          	<a class="notice">修改将会影响到此序列号的生成！请注意。</a> 
           </span>
           </td>
        </tr>
       </tbody>
      <tr>
        <td colspan="2" class="toolbar"><input type="button" class="inputButton" onclick="$('#opForm').submit();" value=" 确 定 " />
          &nbsp;&nbsp;</td>
      </tr>
    </table>
      </div>
</div>
</s:form>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
