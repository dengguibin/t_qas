<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 16:06:36
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/major/majorLeader/save.action" method="post">
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
      <%--  <tr>
       	   <th width="120">序号：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写序号"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">专业：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="majorid" name="bean.majorid"  value="${bean.majorid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">教工名称：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="employeeid" name="bean.employeeid"  value="${bean.employeeid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">担任专业负责人工作年限（年）：</th>
          <td>
           <input type="text" class="inputText" id="headyear"  maxlength="9"  name="bean.headyear"  value="${bean.headyear}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">担任专业带头人工作年限（年）：</th>
          <td>
           <input type="text" class="inputText" id="leaderyear"  maxlength="9"  name="bean.leaderyear"  value="${bean.leaderyear}"  />
           </td>
        </tr>
       <tr>
          <th width="120">代表性科研成果<-->项目名称：</th>
          <td>
                <textarea id="projectname"  maxlength="127.5" name="bean.projectname" class="textinput2" >${bean.projectname}</textarea>
           </td>
        </tr>
       <tr>
          <th width="120">代表性科研成果<-->项目简介：</th>
          <td>
                <textarea id="projectsummary"  maxlength="127.5" name="bean.projectsummary" class="textinput2" >${bean.projectsummary}</textarea>
           </td>
        </tr>
       <tr>
       	   <th width="120">代表性科研成果<-->获奖等级	：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="projectaward" name="bean.projectaward"  value="${bean.projectaward}"  /></td>
        </tr>
       <tr>
       	   <th width="120">代表性科研成果<-->获取日期(年月)：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="awarddate" name="bean.awarddate"  value="${bean.awarddate}"  /></td>
        </tr>
       <tr>
          <th width="120">代表性科研成果<-->合作情况：</th>
          <td>
                <textarea id="coopration"  maxlength="127.5" name="bean.coopration" class="textinput2" >${bean.coopration}</textarea>
           </td>
        </tr>
       <tr>
       	   <th width="120">专业领军人才：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="ismajorleading" name="bean.ismajorleading"  value="${bean.ismajorleading}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否专业带头人：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="ismajorleader" name="bean.ismajorleader"  value="${bean.ismajorleader}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否专业负责人：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="ismajorhead" name="bean.ismajorhead"  value="${bean.ismajorhead}"  /></td>
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
