<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-24 10:29:01
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
       <tr>
    	   <th width="120">社团唯一标识：</th>
           <td>${bean.id}</td>
        </tr>
       <tr>
    	   <th width="120">社团代码：</th>
           <td>${bean.communitycode}</td>
        </tr>
       <tr>
    	   <th width="120">社团名称(全称)	：</th>
           <td>${bean.communityname}</td>
        </tr>
       <tr>
    	   <th width="120">社团类别：</th>
           <td>${bean.communitytype}</td>
        </tr>
       <tr>
    	   <th width="120">登记情况<-->登记日期（年月）：</th>
           <td>${bean.registrationdate}</td>
        </tr>
       <tr>
    	   <th width="120">登记情况<-->批准单位（部门）：</th>
           <td>${bean.approvalunit}</td>
        </tr>
       <tr>
    	   <th width="120">注册单位：</th>
           <td>${bean.registrationunit}</td>
        </tr>
       <tr>
    	   <th width="120">现有成员（人）：</th>
           <td>${bean.membercount}</td>
        </tr>
       <tr>
    	   <th width="120">负责人情况<-->姓名：</th>
           <td>${bean.headname}</td>
        </tr>
       <tr>
    	   <th width="120">负责人情况<-->所在年级：</th>
           <td>${bean.headingrade}</td>
        </tr>
       <tr>
    	   <th width="120">负责人情况<-->单位职务：</th>
           <td>${bean.headduty}</td>
        </tr>
       <tr>
    	   <th width="120">是否设有学分（学时）：</th>
           <td>${bean.iscredit}</td>
        </tr>
       <tr>
    	   <th width="120">学校指导部门	：</th>
           <td>${bean.guidancedepartment}</td>
        </tr>
       <tr>
    	   <th width="120">指导教师名单	：</th>
           <td>${bean.guidanceteacher}</td>
        </tr>
       <tr>
    	   <th width="120">主要活动内容：</th>
           <td>${bean.activitycontent}</td>
        </tr>
       <tr>
    	   <th width="120">学校分管部门：</th>
           <td>${bean.management}</td>
        </tr>
       <tr>
    	   <th width="120">活动经费（元）：</th>
           <td>${bean.activityfund}</td>
        </tr>
       <tr>
    	   <th width="120">是否有获奖项目：</th>
           <td>${bean.isaward}</td>
        </tr>
       <tr>
    	   <th width="120">来源	：</th>
           <td>${bean.source}</td>
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
