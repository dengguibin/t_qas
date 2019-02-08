<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:45:25
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/school/rooms/save.action" method="post">
			<s:hidden name="menuId" id="menuId"/>
			<s:hidden name="bean.id" id="id"/>
			<s:hidden name="bean.status" id="status"/>
			<s:hidden name="bean.createdby" id="createdby"/>
			<s:hidden name="bean.createdtime" id="createdtime"/>
			<s:hidden name="bean.updatedby" id="updatedby"/>
			<s:hidden name="bean.updatedtime" id="updatedtime"/>
			<s:hidden name="bean.tenantid" id="tenantid"/>
			<s:hidden name="bean.storagetime" id="storagetime"/>
			<!-- 令牌环，防止重复提交 -->
			<s:token></s:token>
			
		<div class="formtitle"><span>表头信息控制</span></div>	
		<table>
		  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
     	 </tr>
       <tbody>
       <%-- <tr>
       	   <th width="120">序号：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写序号"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">阅览室座位数（个)：</th>
          <td>
           <input type="text" class="inputText" id="numofreadingroomseat"  maxlength="9"  name="bean.numofreadingroomseat"  value="${bean.numofreadingroomseat}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">计算机数（台）<-->合计：</th>
          <td>
           <input type="text" class="inputText" id="numofcomputer"  maxlength="9"  name="bean.numofcomputer"  value="${bean.numofcomputer}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">计算机数（台）<-->教学用计算机<-->合计	：</th>
          <td>
           <input type="text" class="inputText" id="numofteachingcomputer"  maxlength="9"  name="bean.numofteachingcomputer"  value="${bean.numofteachingcomputer}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">计算机数（台）<-->教学用计算机<-->平板电脑：</th>
          <td>
           <input type="text" class="inputText" id="numofteachingpad"  maxlength="9"  name="bean.numofteachingpad"  value="${bean.numofteachingpad}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">计算机数（台）<-->机房用计算机<-->公共机房：</th>
          <td>
           <input type="text" class="inputText" id="numofpubliccomputerroom"  maxlength="9"  name="bean.numofpubliccomputerroom"  value="${bean.numofpubliccomputerroom}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">计算机数（台）<-->机房用计算机<-->专业机房：</th>
          <td>
           <input type="text" class="inputText" id="numofspecialcomputerroom"  maxlength="9"  name="bean.numofspecialcomputerroom"  value="${bean.numofspecialcomputerroom}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">教室（间）<-->合计：</th>
          <td>
           <input type="text" class="inputText" id="numofclassroom"  maxlength="9"  name="bean.numofclassroom"  value="${bean.numofclassroom}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">教室（间）<-->网络多媒体教室：</th>
          <td>
           <input type="text" class="inputText" id="numofmediaroom"  maxlength="9"  name="bean.numofmediaroom"  value="${bean.numofmediaroom}"  />
           </td>
        </tr>
      <%--  <tr>
       	   <th width="120">状态：</th>
          <td>
           <input type="text" class="inputText" id="status"  maxlength="9"  name="bean.status"  value="${bean.status}"  />
           </td>
        </tr>
       <tr>
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
        </tr>
       <tr>
       	   <th width="120">租户：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="tenantid" name="bean.tenantid"  value="${bean.tenantid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">入库时间（接口传输，导入）：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="storagetime" name="bean.storagetime"  value="${storagetime}" />
          </td>
        </tr> --%>
	   
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
