<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:18:45
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/school/school/save.action" method="post">
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
      <%--  <tr>
       	   <th width="120">记录标识：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写记录标识"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">学校标识码：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="code" name="bean.code"  value="${bean.code}"  /></td>
        </tr>
       <tr>
       	   <th width="120">学校名称(全称)	：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="name" name="bean.name"  value="${bean.name}"  /></td>
        </tr>
       <tr>
       	   <th width="120">所在地区（省、自治区、直辖市)：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="location" name="bean.location"  value="${bean.location}"  /></td>
        </tr>
       <tr>
       	   <th width="120">当前校名启用日期（年月）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="nameuseddate" name="bean.nameuseddate"  value="${bean.nameuseddate}"  /></td>
        </tr>
       <tr>
       	   <th width="120">建校日期（年月）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="buildeddate" name="bean.buildeddate"  value="${bean.buildeddate}"  /></td>
        </tr>
       <tr>
          <th width="120">建校基础	：</th>
          <td>
                <textarea id="buildedbase"  maxlength="2,000" name="bean.buildedbase" class="textinput2" >${bean.buildedbase}</textarea>
           </td>
        </tr>
       <tr>
       	   <th width="120">学校举办者<-->名称(全称)  ：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="creatername" name="bean.creatername"  value="${bean.creatername}"  /></td>
        </tr>
       <tr>
       	   <th width="120">学校举办者<-->性质：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="creaternature" name="bean.creaternature"  value="${bean.creaternature}"  /></td>
        </tr>
       <tr>
       	   <th width="120">学校举办者<-->级别	：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="creatergrade" name="bean.creatergrade"  value="${bean.creatergrade}"  /></td>
        </tr>
       <tr>
          <th width="120">学校性质类别：</th>
          <td>
                <textarea id="grade"  maxlength="127.5" name="bean.grade" class="textinput2" >${bean.grade}</textarea>
           </td>
        </tr>
       <tr>
          <th width="120">校训	：</th>
          <td>
                <textarea id="motto"  maxlength="2,000" name="bean.motto" class="textinput2" >${bean.motto}</textarea>
           </td>
        </tr>
       <tr>
          <th width="120">通信地址	：</th>
          <td>
                <textarea id="address"  maxlength="127.5" name="bean.address" class="textinput2" >${bean.address}</textarea>
           </td>
        </tr>
       <tr>
       	   <th width="120">邮政编码：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="postcode" name="bean.postcode"  value="${bean.postcode}"  /></td>
        </tr>
       <tr>
          <th width="120">学校网址：</th>
          <td>
                <textarea id="web"  maxlength="127.5" name="bean.web" class="textinput2" >${bean.web}</textarea>
           </td>
        </tr>
       <tr>
       	   <th width="120">社区教育示范校：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="iscommunityedudemonstration" name="bean.iscommunityedudemonstration"  value="${bean.iscommunityedudemonstration}"  /></td>
        </tr>
       <tr>
       	   <th width="120">示范性高等职业院校<-->性质：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="exampnature" name="bean.exampnature"  value="${bean.exampnature}"  /></td>
        </tr>
       <tr>
       	   <th width="120">示范性高等职业院校<-->级别：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="exampgrade" name="bean.exampgrade"  value="${bean.exampgrade}"  /></td>
        </tr>
       <tr>
       	   <th width="120">示范性高等职业院校<-->立项部门：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="exampdepartment" name="bean.exampdepartment"  value="${bean.exampdepartment}"  /></td>
        </tr>
       <tr>
       	   <th width="120">示范性高等职业院校<-->立项日期（年）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="exampbuildedtime" name="bean.exampbuildedtime"  value="${bean.exampbuildedtime}"  /></td>
        </tr>
       <tr>
       	   <th width="120">评估状态<-->第一轮<-->评估日期（年月)：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="estimatefirsttime" name="bean.estimatefirsttime"  value="${bean.estimatefirsttime}"  /></td>
        </tr>
       <tr>
       	   <th width="120">评估状态<-->第二轮<-->评估结论：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="estimatesecondresult" name="bean.estimatesecondresult"  value="${bean.estimatesecondresult}"  /></td>
        </tr>
       <tr>
       	   <th width="120">评估状态<-->未接受评估：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="estimatenorun" name="bean.estimatenorun"  value="${bean.estimatenorun}"  /></td>
        </tr>
     <%--   <tr>
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
