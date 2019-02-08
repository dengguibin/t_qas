<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-30 17:54:20
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/system/organization/save.action" method="post">
			<s:hidden name="menuId" id="menuId"/>
			<s:hidden name="bean.id" id="id" />
			<s:hidden name="bean.createdby" id="createdby" />
			<s:hidden name="bean.createdtime" id="createdtime" />
			<!-- 令牌环，防止重复提交 -->
			<s:token></s:token>
			
		<div class="formtitle"><span>表头信息控制</span></div>	
		<table>
		  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
     	 </tr>
       <tbody>
      <%--  <tr>
       	   <th width="120">：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">父机构ID：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="parentid" name="bean.parentid"  value="${bean.parentid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">类型ID,来自数据库：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="typeid" name="bean.typeid"  value="${bean.typeid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">机构号：</th>
           <td><input type="text" class="inputText"  maxlength="10"  id="orgcode" name="bean.orgcode"  value="${bean.orgcode}"  /></td>
        </tr>
       <tr>
       	   <th width="120">机构名称：</th>
           <td><input type="text" class="inputText"  maxlength="25"  id="orgname" name="bean.orgname"  value="${bean.orgname}"  /></td>
        </tr>
       <tr>
       	   <th width="120">简称：</th>
           <td><input type="text" class="inputText"  maxlength="25"  id="abbreviation" name="bean.abbreviation"  value="${bean.abbreviation}"  /></td>
        </tr>
       <tr>
       	   <th width="120">简拼：</th>
           <td><input type="text" class="inputText"  maxlength="25"  id="jianpin" name="bean.jianpin"  value="${bean.jianpin}"  /></td>
        </tr>
       <tr>
       	   <th width="120">机构地址：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="address" name="bean.address"  value="${bean.address}"  /></td>
        </tr>
       <tr>
       	   <th width="120">排序：</th>
          <td>
           <input type="text" class="inputText" id="sort"  maxlength="9"  name="bean.sort"  value="${bean.sort}"  />
           </td>
        </tr>
       <tr>
       	 <th width="120">是否是实体：</th>
         <td><input type="text" class="inputText" id="isphysical" name="bean.isphysical"  value="${bean.isphysical}" /></td>
        </tr>
       <tr>
       	   <th width="120">层级：</th>
          <td>
           <input type="text" class="inputText" id="layer"  maxlength="9"  name="bean.layer"  value="${bean.layer}"  />
           </td>
        </tr>
       <tr>
          <th width="120">备注：</th>
          <td>
                <textarea id="remark"  maxlength="150" name="bean.remark" class="textinput2" >${bean.remark}</textarea>
           </td>
        </tr>
       <tr>
       	   <th width="120">组织状态: 0有效 1:无效：</th>
          <td>
           <input type="text" class="inputText" id="status"  maxlength="9"  name="bean.status"  value="${bean.status}"  />
           </td>
        </tr>
       <%-- <tr>
       	   <th width="120">：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="createdby" name="bean.createdby"  value="${bean.createdby}"  /></td>
        </tr>
       <tr>
       	   <th width="120">：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="createdtime" name="bean.createdtime"  value="${createdtime}" />
          </td>
        </tr>
       <tr>
       	   <th width="120">：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="updatedby" name="bean.updatedby"  value="${bean.updatedby}"  /></td>
        </tr>
       <tr>
       	   <th width="120">：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="updatedtime" name="bean.updatedtime"  value="${updatedtime}" />
          </td>
        </tr> --%>
       <tr>
       	   <th width="120">租户：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="tenantid" name="bean.tenantid"  value="${bean.tenantid}"  /></td>
        </tr>
	   
	    <tr>
        <td colspan="2" class="toolbar">
        <input type="button" class="inputButton" onclick="$('#opForm').submit();" value=" 确 定 " />
         <input type="button"  class="cancel" value=" 返 回 " id="returnButton"/>
          &nbsp;&nbsp;</td>
      	</tr>
	   
       </tbody>
    </table>
         </form>
  </div><!--editblock end-->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
