<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:44:17
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/school/areaOfStructure/save.action" method="post">
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
     <%--   <tr>
       	   <th width="120">序号：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写序号"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">占地面积：</th>
          <td>
           <input type="text" class="inputText" id="areacovered"  maxlength="9"  name="bean.areacovered"  value="${bean.areacovered}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">总建筑面积：</th>
          <td>
           <input type="text" class="inputText" id="constructionarea"  maxlength="9"  name="bean.constructionarea"  value="${bean.constructionarea}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->学校产权校舍建筑面积<-->合计：</th>
          <td>
           <input type="text" class="inputText" id="schoolbuildingarea"  maxlength="9"  name="bean.schoolbuildingarea"  value="${bean.schoolbuildingarea}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->学校产权校舍建筑面积<-->当年新增校舍：</th>
          <td>
           <input type="text" class="inputText" id="schooladdbuilding"  maxlength="9"  name="bean.schooladdbuilding"  value="${bean.schooladdbuilding}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->非学校产权校舍建筑面积：</th>
          <td>
           <input type="text" class="inputText" id="nonschoolpropertyarea"  maxlength="9"  name="bean.nonschoolpropertyarea"  value="${bean.nonschoolpropertyarea}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">教学科研及辅助用房：</th>
          <td>
           <input type="text" class="inputText" id="researchandauxiliary"  maxlength="9"  name="bean.researchandauxiliary"  value="${bean.researchandauxiliary}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->教室：</th>
          <td>
           <input type="text" class="inputText" id="classroom"  maxlength="9"  name="bean.classroom"  value="${bean.classroom}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->图书馆：</th>
          <td>
           <input type="text" class="inputText" id="library"  maxlength="9"  name="bean.library"  value="${bean.library}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->实验室、实习场所：</th>
          <td>
           <input type="text" class="inputText" id="laboratoryandpractice"  maxlength="9"  name="bean.laboratoryandpractice"  value="${bean.laboratoryandpractice}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->专用科研用房：</th>
          <td>
           <input type="text" class="inputText" id="specialresearch"  maxlength="9"  name="bean.specialresearch"  value="${bean.specialresearch}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->体育馆：</th>
          <td>
           <input type="text" class="inputText" id="stadium"  maxlength="9"  name="bean.stadium"  value="${bean.stadium}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->会堂：</th>
          <td>
           <input type="text" class="inputText" id="hall"  maxlength="9"  name="bean.hall"  value="${bean.hall}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">行政办公用房：</th>
          <td>
           <input type="text" class="inputText" id="office"  maxlength="9"  name="bean.office"  value="${bean.office}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">生活用房：</th>
          <td>
           <input type="text" class="inputText" id="livingroom"  maxlength="9"  name="bean.livingroom"  value="${bean.livingroom}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->学生宿舍（公寓）：</th>
          <td>
           <input type="text" class="inputText" id="studentdormitory"  maxlength="9"  name="bean.studentdormitory"  value="${bean.studentdormitory}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->学生食堂：</th>
          <td>
           <input type="text" class="inputText" id="studentcanteen"  maxlength="9"  name="bean.studentcanteen"  value="${bean.studentcanteen}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->教工宿舍（公寓）：</th>
          <td>
           <input type="text" class="inputText" id="employeedormitory"  maxlength="9"  name="bean.employeedormitory"  value="${bean.employeedormitory}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->教工食堂：</th>
          <td>
           <input type="text" class="inputText" id="employeecanteen"  maxlength="9"  name="bean.employeecanteen"  value="${bean.employeecanteen}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->生活福利及附属用房：</th>
          <td>
           <input type="text" class="inputText" id="welfarehouse"  maxlength="9"  name="bean.welfarehouse"  value="${bean.welfarehouse}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">教工住宅：</th>
          <td>
           <input type="text" class="inputText" id="facultyresidence"  maxlength="9"  name="bean.facultyresidence"  value="${bean.facultyresidence}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其他用房：</th>
          <td>
           <input type="text" class="inputText" id="otherresidence"  maxlength="9"  name="bean.otherresidence"  value="${bean.otherresidence}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">一体化教室：</th>
          <td>
           <input type="text" class="inputText" id="integratedclassroom"  maxlength="9"  name="bean.integratedclassroom"  value="${bean.integratedclassroom}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">占地面积<-->绿化用：</th>
          <td>
           <input type="text" class="inputText" id="acreage"  maxlength="9"  name="bean.acreage"  value="${bean.acreage}"  />
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
