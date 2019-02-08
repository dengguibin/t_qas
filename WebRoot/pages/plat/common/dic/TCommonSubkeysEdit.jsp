<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-10-28 12:51:07
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<s:form action="tCommonSubkeys!save" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<s:token></s:token>
	<s:hidden name="bean.code"/>
<div class="editBlock" id="editBlock" style="margin: 0px;padding: 0px;">
<br>
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >字典信息</td>
      </tr>
       <tbody>
       
       <tr>
       	   <th width="120"><span class="warning">*</span>代码子键：</th>
           <td>
           <c:choose>
           		<c:when test="${not empty bean.subcode}"><s:textfield  name="bean.subcode" readonly="true" cssClass="inputText" id="subcode"/></c:when>
           		<c:otherwise><s:textfield  name="bean.subcode" cssClass="inputText" id="subcode"/></c:otherwise>
           </c:choose>
           
           </td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>代码名称：</th>
           <td><s:textfield  name="bean.cname" cssClass="inputText" id="cname"/></td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>是否有效：</th>
           <td>
           	<select name="bean.valid" id="valid" class="select2" style="width: 135px;">
          	<option value="">--请选择是否有效--</option>
          	<x:cache subject="OPTION01"  option="true" selected="${bean.valid}"/>
          	</select>
           <em  class="valid" title="是否有效有效输入必须是数字类型。" lang="n"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>排序号：</th>
           <td>
           <s:textfield  name="bean.seq" cssClass="inputText" id="seq" cssStyle="width:90px;"/>
           <em  class="valid" title="排序号输入必须是数字类型。" lang="n" ></em>
           </td>
        </tr>
       <tr>
       	   <th width="120">参数1：</th>
           <td><s:textfield  name="bean.params1" cssClass="dfinput" id="params1"/></td>
        </tr>
       <tr>
       	   <th width="120">参数2：</th>
           <td><s:textfield  name="bean.params2" cssClass="dfinput" id="params2"/></td>
        </tr>
       <tr>
       	   <th width="120">备注说明：</th>
       	   <td>
          <s:textarea name="bean.des" cssClass="textinput2" id="cdms"></s:textarea>
           </td>
        </tr>
       </tbody>
      <tr>
        <td colspan="2" class="toolbar" style="text-align: right;">
        <input type="button" class="inputButton" onclick="$('#opForm').submit();" value=" 保 存 " />
          &nbsp;&nbsp;</td>
      </tr>
    </table>
</div>
</s:form>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
