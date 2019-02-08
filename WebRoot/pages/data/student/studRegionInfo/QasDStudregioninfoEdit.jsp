<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-24 10:33:04
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/student/studRegionInfo/save.action" method="post">
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
       	   <th width="120">记录标识：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写记录标识"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">在校生总数(人)：</th>
          <td>
           <input type="text" class="inputText" id="studentinschoolnum"  maxlength="9"  name="bean.studentinschoolnum"  value="${bean.studentinschoolnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->外省学生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="otherprivincestudent"  maxlength="9"  name="bean.otherprivincestudent"  value="${bean.otherprivincestudent}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->西部地区学生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="weststudent"  maxlength="9"  name="bean.weststudent"  value="${bean.weststudent}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->常住户口所在地为农村的学生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="countrysidestudent"  maxlength="9"  name="bean.countrysidestudent"  value="${bean.countrysidestudent}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->贫困地区学生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="poorstudent"  maxlength="9"  name="bean.poorstudent"  value="${bean.poorstudent}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->少数民族学生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="minoritystudent"  maxlength="9"  name="bean.minoritystudent"  value="${bean.minoritystudent}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">国际学生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="internationalstudent"  maxlength="9"  name="bean.internationalstudent"  value="${bean.internationalstudent}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">境外学生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="overseastudent"  maxlength="9"  name="bean.overseastudent"  value="${bean.overseastudent}"  />
           </td>
        </tr>
       <%-- <tr>
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
