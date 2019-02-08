<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:45:56
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/school/informationConstruction/informationconstruction/save.action" method="post">
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
       	   <th width="120">出口总带宽（Mbps）：</th>
          <td>
           <input type="text" class="inputText" id="exportbandwidth"  maxlength="9"  name="bean.exportbandwidth"  value="${bean.exportbandwidth}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">校园网主干最大带宽（Mbps）：</th>
          <td>
           <input type="text" class="inputText" id="campusnetwork"  maxlength="9"  name="bean.campusnetwork"  value="${bean.campusnetwork}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">网络信息点数（个）：</th>
          <td>
           <input type="text" class="inputText" id="networkinformationpoint"  maxlength="9"  name="bean.networkinformationpoint"  value="${bean.networkinformationpoint}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">管理信息系统数据总量（GB）：</th>
          <td>
           <input type="text" class="inputText" id="accountofmis"  maxlength="9"  name="bean.accountofmis"  value="${bean.accountofmis}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">电子邮件系统用户数（个）：</th>
          <td>
           <input type="text" class="inputText" id="emailusercount"  maxlength="9"  name="bean.emailusercount"  value="${bean.emailusercount}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">上网课程数（门）：</th>
          <td>
           <input type="text" class="inputText" id="onlinecoursecount"  maxlength="9"  name="bean.onlinecoursecount"  value="${bean.onlinecoursecount}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">数字资源量(GB)<-->合计：</th>
          <td>
           <input type="text" class="inputText" id="totaldigitalresource"  maxlength="9"  name="bean.totaldigitalresource"  value="${bean.totaldigitalresource}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">数字资源量(GB)<-->电子图书：</th>
          <td>
           <input type="text" class="inputText" id="electronicbook"  maxlength="9"  name="bean.electronicbook"  value="${bean.electronicbook}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">多媒体教学资源库总容量（TB）：</th>
          <td>
           <input type="text" class="inputText" id="multimediacapacity"  maxlength="9"  name="bean.multimediacapacity"  value="${bean.multimediacapacity}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">国家级职业教育专业教学资源库数量：</th>
          <td>
           <input type="text" class="inputText" id="nationallevelresource"  maxlength="9"  name="bean.nationallevelresource"  value="${bean.nationallevelresource}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">省级职业教育专业教学资源库数量：</th>
          <td>
           <input type="text" class="inputText" id="provincialresource"  maxlength="9"  name="bean.provincialresource"  value="${bean.provincialresource}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">一卡通使用	：</th>
          <td>
           <input type="text" class="inputText" id="allinonecardusage"  maxlength="9"  name="bean.allinonecardusage"  value="${bean.allinonecardusage}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">无线覆盖情况	：</th>
          <td>
           <input type="text" class="inputText" id="wirelesscoverage"  maxlength="9"  name="bean.wirelesscoverage"  value="${bean.wirelesscoverage}"  />
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
