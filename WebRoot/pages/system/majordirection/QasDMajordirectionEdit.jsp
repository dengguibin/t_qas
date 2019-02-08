<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-30 10:31:54
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/system/majordirection/save.action" method="post">
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
       <%-- <tr>
       	   <th width="120">专业方向唯一标识：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写专业方向唯一标识"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">专业编号：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="majorid" name="bean.majorid"  value="${bean.majorid}"  /></td>
        </tr>
       <tr>
          <th width="120">专业方向代码：</th>
          <td>
                <textarea id="directioncode"  maxlength="127.5" name="bean.directioncode" class="textinput2" >${bean.directioncode}</textarea>
           </td>
        </tr>
       <tr>
          <th width="120">专业方向名称：</th>
          <td>
                <textarea id="directionname"  maxlength="127.5" name="bean.directionname" class="textinput2" >${bean.directionname}</textarea>
           </td>
        </tr>
       <tr>
       	   <th width="120">批准设置日期：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="setupdate" name="bean.setupdate"  value="${setupdate}" />
          </td>
        </tr>
       <tr>
       	   <th width="120">首次招生日期：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="firstrecruitdate" name="bean.firstrecruitdate"  value="${firstrecruitdate}" />
          </td>
        </tr>
       <tr>
       	   <th width="120">修业年限（年）：</th>
          <td>
           <input type="text" class="inputText" id="studyduration"  maxlength="9"  name="bean.studyduration"  value="${bean.studyduration}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">状态：</th>
          <td>
           <input type="text" class="inputText" id="status"  maxlength="9"  name="bean.status"  value="${bean.status}"  />
           </td>
        </tr>
      <%--  <tr>
       	   <th width="120">创建人：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="createdby" name="bean.createdby"  value="${bean.createdby}"  /></td>
        </tr>
       <tr>
       	   <th width="120">创建时间：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="createdtime" name="bean.createdtime"  value="${createdtime}" />
          </td>
        </tr>
       <tr>
       	   <th width="120">修改人：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="updatedby" name="bean.updatedby"  value="${bean.updatedby}"  /></td>
        </tr>
       <tr>
       	   <th width="120">修改时间：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="updatedtime" name="bean.updatedtime"  value="${updatedtime}" />
          </td>
        </tr> --%>
       <tr>
       	   <th width="120">租户：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="tenantid" name="bean.tenantid"  value="${bean.tenantid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">入库时间（接口传输，导入）：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="storagetime" name="bean.storagetime"  value="${storagetime}" />
          </td>
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
