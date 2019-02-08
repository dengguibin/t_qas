<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-24 10:37:22
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/student/retiredSoldiers/save.action" method="post">
			<s:hidden name="menuId" id="menuId"/>
			<s:hidden name="bean.id" id="id"/>
			<!-- 令牌环，防止重复提交 -->
			<s:token></s:token>
			
		<div class="formtitle"><span>表头信息控制</span></div>	
		<table>
		  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
     	 </tr>
       <tbody>
       <%-- <tr>
       	   <th width="120">记录标识：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写记录标识"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">当年招生数合计（人）：</th>
          <td>
           <input type="text" class="inputText" id="enrolltotal"  maxlength="9"  name="bean.enrolltotal"  value="${bean.enrolltotal}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">当年招生数复转军人（人）：</th>
          <td>
           <input type="text" class="inputText" id="enrollarmymen"  maxlength="9"  name="bean.enrollarmymen"  value="${bean.enrollarmymen}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">当年招生数退役士兵（人）：</th>
          <td>
           <input type="text" class="inputText" id="enrollretiredsoldier"  maxlength="9"  name="bean.enrollretiredsoldier"  value="${bean.enrollretiredsoldier}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">在校生数合计(人)：</th>
          <td>
           <input type="text" class="inputText" id="inschooltotal"  maxlength="9"  name="bean.inschooltotal"  value="${bean.inschooltotal}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">在校生数复转军人（人次）：</th>
          <td>
           <input type="text" class="inputText" id="inschoolarmymen"  maxlength="9"  name="bean.inschoolarmymen"  value="${bean.inschoolarmymen}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">在校生数退役士兵(人)：</th>
          <td>
           <input type="text" class="inputText" id="inschoolretiredsoldier"  maxlength="9"  name="bean.inschoolretiredsoldier"  value="${bean.inschoolretiredsoldier}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">社会培训合计（人次）：</th>
          <td>
           <input type="text" class="inputText" id="societytrainingtotal"  maxlength="9"  name="bean.societytrainingtotal"  value="${bean.societytrainingtotal}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">社会培训复转军人（人次）：</th>
          <td>
           <input type="text" class="inputText" id="societytrainingarmymen"  maxlength="9"  name="bean.societytrainingarmymen"  value="${bean.societytrainingarmymen}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">社会培训退役士兵（人次）：</th>
          <td>
           <input type="text" class="inputText" id="societytrainingretiredsoldier"  maxlength="9"  name="bean.societytrainingretiredsoldier"  value="${bean.societytrainingretiredsoldier}"  />
           </td>
        </tr>
	   <tr>
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
