<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-24 10:39:24
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/student/studentNormal/save.action" method="post">
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
       	   <th width="120">记录标识 ：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写记录标识 "/></td>
        </tr> --%>
       <tr>
       	   <th width="120">学生名称：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="studentid" name="bean.studentid"  value="${bean.studentid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">缺课次数：</th>
          <td>
           <input type="text" class="inputText" id="absence"  maxlength="9"  name="bean.absence"  value="${bean.absence}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">迟到次数：</th>
          <td>
           <input type="text" class="inputText" id="tardiness"  maxlength="9"  name="bean.tardiness"  value="${bean.tardiness}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">早退次数：</th>
          <td>
           <input type="text" class="inputText" id="prematureleave"  maxlength="9"  name="bean.prematureleave"  value="${bean.prematureleave}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">早退次数：</th>
          <td>
           <input type="text" class="inputText" id="leaves"  maxlength="9"  name="bean.leaves"  value="${bean.leaves}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">学生综合测评积分：</th>
          <td>
           <input type="text" class="inputText" id="evaluationpoint"  maxlength="9"  name="bean.evaluationpoint"  value="${bean.evaluationpoint}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">学期内违纪次数：</th>
          <td>
           <input type="text" class="inputText" id="discipline"  maxlength="9"  name="bean.discipline"  value="${bean.discipline}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">学期内犯罪次数：</th>
          <td>
           <input type="text" class="inputText" id="crime"  maxlength="9"  name="bean.crime"  value="${bean.crime}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">学期内群体事件次数：</th>
          <td>
           <input type="text" class="inputText" id="groupevent"  maxlength="9"  name="bean.groupevent"  value="${bean.groupevent}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">学期内责任性伤亡：</th>
          <td>
           <input type="text" class="inputText" id="casualties"  maxlength="9"  name="bean.casualties"  value="${bean.casualties}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">处分次数：</th>
          <td>
           <input type="text" class="inputText" id="punishmenttime"  maxlength="9"  name="bean.punishmenttime"  value="${bean.punishmenttime}"  />
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
        </tr>
	    --%>
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
