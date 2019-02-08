<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 16:14:22
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/major/lastYearEmployment/save.action" method="post">
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
    <%--    <tr>
       	   <th width="120">序号：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写序号"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">专业方向：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="directionid" name="bean.directionid"  value="${bean.directionid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">毕业生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="gradnum"  maxlength="9"  name="bean.gradnum"  value="${bean.gradnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生就业情况<-->就业数(人)：</th>
          <td>
           <input type="text" class="inputText" id="empnum"  maxlength="9"  name="bean.empnum"  value="${bean.empnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生就业情况<-->升迁数（人）：</th>
          <td>
           <input type="text" class="inputText" id="promotion"  maxlength="9"  name="bean.promotion"  value="${bean.promotion}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生就业情况<-->转岗数（人）：</th>
          <td>
           <input type="text" class="inputText" id="tranwork"  maxlength="9"  name="bean.tranwork"  value="${bean.tranwork}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生用人单位满意情况<-->满意或基本满意人数：</th>
          <td>
           <input type="text" class="inputText" id="satisfied"  maxlength="9"  name="bean.satisfied"  value="${bean.satisfied}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生用人单位满意情况<-->一般满意人数：</th>
          <td>
           <input type="text" class="inputText" id="nomal"  maxlength="9"  name="bean.nomal"  value="${bean.nomal}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生用人单位满意情况<-->不满意人数：</th>
          <td>
           <input type="text" class="inputText" id="dissatisfied"  maxlength="9"  name="bean.dissatisfied"  value="${bean.dissatisfied}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生的教学满意人数：</th>
          <td>
           <input type="text" class="inputText" id="satisfiedwithteaching"  maxlength="9"  name="bean.satisfiedwithteaching"  value="${bean.satisfiedwithteaching}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生对母校的满意人数：</th>
          <td>
           <input type="text" class="inputText" id="satisfiedwithcollege"  maxlength="9"  name="bean.satisfiedwithcollege"  value="${bean.satisfiedwithcollege}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生工作与职业期待吻合人数：</th>
          <td>
           <input type="text" class="inputText" id="workandcareerexpectationsmatch"  maxlength="9"  name="bean.workandcareerexpectationsmatch"  value="${bean.workandcareerexpectationsmatch}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生对基本工作能力总体满足人数：</th>
          <td>
           <input type="text" class="inputText" id="satisfiedwithworkability"  maxlength="9"  name="bean.satisfiedwithworkability"  value="${bean.satisfiedwithworkability}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生对核心知识的总体满足人数：</th>
          <td>
           <input type="text" class="inputText" id="satisfiedwithcoreknowledge"  maxlength="9"  name="bean.satisfiedwithcoreknowledge"  value="${bean.satisfiedwithcoreknowledge}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生的就业现状满意人数 ：</th>
          <td>
           <input type="text" class="inputText" id="satisfiedwithemployment"  maxlength="9"  name="bean.satisfiedwithemployment"  value="${bean.satisfiedwithemployment}"  />
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
