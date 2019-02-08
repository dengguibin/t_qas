<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 16:15:03
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/major/majorQualitativeIndicator/save.action" method="post">
			<s:hidden name="menuId" id="menuId"/>
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
       	   <th width="120">专业：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="majorid" name="bean.majorid"  value="${bean.majorid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">专业建设规划是否及时跟踪市场需求变化和产业结构调整的需要，进行SWOT分析
            ：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="ismajorswotanalysis" name="bean.ismajorswotanalysis"  value="${bean.ismajorswotanalysis}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否明确专业核心岗位和能力要求（职业能力分析）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="isoccupationalanalysis" name="bean.isoccupationalanalysis"  value="${bean.isoccupationalanalysis}"  /></td>
        </tr>
       <tr>
       	   <th width="120">人才培养方案是否建立三级的论证审核制度(专业、二级学院、学校)：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="ishavethreelevelauditsystem" name="bean.ishavethreelevelauditsystem"  value="${bean.ishavethreelevelauditsystem}"  /></td>
        </tr>
       <tr>
       	   <th width="120">人才培养方案是否邀请三位以上行业专家和学生代表进行评审：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="isinviterepresentativestoreview" name="bean.isinviterepresentativestoreview"  value="${bean.isinviterepresentativestoreview}"  /></td>
        </tr>
       <tr>
       	   <th width="120">课程体系的实施是否能实现专业能力的培养（课程体系与能力对照表），全部课程标准是否齐备：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="iscurriculumsystemavailable" name="bean.iscurriculumsystemavailable"  value="${bean.iscurriculumsystemavailable}"  /></td>
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
