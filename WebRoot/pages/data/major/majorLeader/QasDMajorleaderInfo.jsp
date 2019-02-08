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
<form action="" id="opForm">
<s:hidden name="menuId" id="menuId"/>
	<div class="formtitle"><span>放在这里提示</span></div>
		<table>
			<tr>
				<td colspan="2" class="subtitle">必填选填放在TBODY前面信息 </td>
			</tr>
       <tbody>
       <%-- <tr>
    	   <th width="120">序号：</th>
           <td>${bean.id}</td>
        </tr> --%>
       <tr>
    	   <th width="120">专业：</th>
           <td>${bean.majorid}</td>
        </tr>
       <tr>
    	   <th width="120">教工名称：</th>
           <td>${bean.employeeid}</td>
        </tr>
       <tr>
    	   <th width="120">担任专业负责人工作年限（年）：</th>
           <td>${bean.headyear}</td>
        </tr>
       <tr>
    	   <th width="120">担任专业带头人工作年限（年）：</th>
           <td>${bean.leaderyear}</td>
        </tr>
       <tr>
    	   <th width="120">代表性科研成果<-->项目名称：</th>
           <td>${bean.projectname}</td>
        </tr>
       <tr>
    	   <th width="120">代表性科研成果<-->项目简介：</th>
           <td>${bean.projectsummary}</td>
        </tr>
       <tr>
    	   <th width="120">代表性科研成果<-->获奖等级	：</th>
           <td>${bean.projectaward}</td>
        </tr>
       <tr>
    	   <th width="120">代表性科研成果<-->获取日期(年月)：</th>
           <td>${bean.awarddate}</td>
        </tr>
       <tr>
    	   <th width="120">代表性科研成果<-->合作情况：</th>
           <td>${bean.coopration}</td>
        </tr>
       <tr>
    	   <th width="120">专业领军人才：</th>
           <td>${bean.ismajorleading}</td>
        </tr>
       <tr>
    	   <th width="120">是否专业带头人：</th>
           <td>${bean.ismajorleader}</td>
        </tr>
       <tr>
    	   <th width="120">是否专业负责人：</th>
           <td>${bean.ismajorhead}</td>
        </tr>
       <tr>
    	   <th width="120">状态：</th>
           <td>${bean.status}</td>
        </tr>
       <tr>
    	   <th width="120">创建人：</th>
           <td>${bean.createdby}</td>
        </tr>
       <tr>
       	   <th width="120">创建时间：</th>
           <td ><fmt:formatDate value="${bean.createdtime}" pattern="yyyy-MM-dd"/></td>
        </tr>
       <tr>
    	   <th width="120">修改人：</th>
           <td>${bean.updatedby}</td>
        </tr>
       <tr>
       	   <th width="120">修改时间：</th>
           <td ><fmt:formatDate value="${bean.updatedtime}" pattern="yyyy-MM-dd"/></td>
        </tr>
       <tr>
    	   <th width="120">租户：</th>
           <td>${bean.tenantid}</td>
        </tr>
       <tr>
       	   <th width="120">入库时间（接口传输，导入）：</th>
           <td ><fmt:formatDate value="${bean.storagetime}" pattern="yyyy-MM-dd"/></td>
        </tr>
	   
	  			 <tr>
					<td colspan="2" class="toolbar">
						<input type="button" id="returnButton" class="cancel" value=" 返 回 " /></td>
				</tr>
       </tbody>
    </table>
 </div>   <!--editBlock END-->
  </form>
</body> 
<%@include file="/pages/t_qas/layout/footer.jsp" %>
