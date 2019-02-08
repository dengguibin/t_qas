<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 16:09:27
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/major/cooperate/save.action" method="post">
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
       	   <th width="120">序号：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写序号"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">专业方向：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="directionid" name="bean.directionid"  value="${bean.directionid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">产学合作企业总数（个)：</th>
          <td>
           <input type="text" class="inputText" id="companies"  maxlength="9"  name="bean.companies"  value="${bean.companies}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">订单培养数（人）：</th>
          <td>
           <input type="text" class="inputText" id="ordercount"  maxlength="9"  name="bean.ordercount"  value="${bean.ordercount}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">共同开发课程数（门）：</th>
          <td>
           <input type="text" class="inputText" id="teachcourse"  maxlength="9"  name="bean.teachcourse"  value="${bean.teachcourse}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">共同开发教材数（种）：</th>
          <td>
           <input type="text" class="inputText" id="teachmaterial"  maxlength="9"  name="bean.teachmaterial"  value="${bean.teachmaterial}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">支持学校兼职教师数（人）：</th>
          <td>
           <input type="text" class="inputText" id="parttimetch"  maxlength="9"  name="bean.parttimetch"  value="${bean.parttimetch}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">接受顶岗实习学生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="practicestud"  maxlength="9"  name="bean.practicestud"  value="${bean.practicestud}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">对学校捐赠设备总值（万元）：</th>
          <td>
           <input type="text" class="inputText" id="donatedevval"  maxlength="9"  name="bean.donatedevval"  value="${bean.donatedevval}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">对学校准捐赠设备总值（万元）：</th>
          <td>
           <input type="text" class="inputText" id="readydonateval"  maxlength="9"  name="bean.readydonateval"  value="${bean.readydonateval}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">接受毕业生就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="accesswork"  maxlength="9"  name="bean.accesswork"  value="${bean.accesswork}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">学校为企业技术服务年收入（万元）：</th>
          <td>
           <input type="text" class="inputText" id="servicevalue"  maxlength="9"  name="bean.servicevalue"  value="${bean.servicevalue}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">学校为企业年培训员工数（人天）：</th>
          <td>
           <input type="text" class="inputText" id="traincount"  maxlength="9"  name="bean.traincount"  value="${bean.traincount}"  />
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
