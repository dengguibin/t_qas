<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-24 10:30:46
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
    	   <th width="120">记录标识：</th>
           <td>${bean.id}</td>
        </tr>
       <tr>
    	   <th width="120">社团：</th>
           <td>${bean.communityid}</td>
        </tr>
       <tr>
    	   <th width="120">举办活动次数：</th>
           <td>${bean.activitycount}</td>
        </tr>
       <tr>
    	   <th width="120">参与活动总人数：</th>
           <td>${bean.participantinactivity}</td>
        </tr>
       <tr>
    	   <th width="120">会员数量（人）<-->总数	：</th>
           <td>${bean.membertotal}</td>
        </tr>
       <tr>
    	   <th width="120">会员数量（人）<-->教工数：</th>
           <td>${bean.employeemembernum}</td>
        </tr>
       <tr>
    	   <th width="120">会员数量（人）<-->学生数：</th>
           <td>${bean.studentmembernum}</td>
        </tr>
       <tr>
    	   <th width="120">会费情况（元）<-->总数：</th>
           <td>${bean.duenum}</td>
        </tr>
       <tr>
    	   <th width="120">会费情况（元）<-->总数：</th>
           <td>${bean.handinnum}</td>
        </tr>
       <tr>
    	   <th width="120">会费情况（元）<-->留存自用：</th>
           <td>${bean.remainnum}</td>
        </tr>
       <tr>
    	   <th width="120">活动经费来源（元）<-->总数：</th>
           <td>${bean.activityfund}</td>
        </tr>
       <tr>
    	   <th width="120">活动经费来源（元）<-->会费：</th>
           <td>${bean.activitydue}</td>
        </tr>
       <tr>
    	   <th width="120">活动经费来源（元）<-->学校拨款：</th>
           <td>${bean.activityfundfromschool}</td>
        </tr>
       <tr>
    	   <th width="120">活动经费来源（元）<-->留存自用的捐款：</th>
           <td>${bean.activityremain}</td>
        </tr>
       <tr>
    	   <th width="120">活动经费来源（元）<-->其他：</th>
           <td>${bean.activityothers}</td>
        </tr>
       <tr>
    	   <th width="120">捐赠情况（元）<-->总数：</th>
           <td>${bean.donationtotal}</td>
        </tr>
       <tr>
    	   <th width="120">捐赠情况（元）<-->上交业务主管单位	：</th>
           <td>${bean.donationhandin}</td>
        </tr>
       <tr>
    	   <th width="120">捐赠情况（元）<-->留存自用主要活动内容：</th>
           <td>${bean.donationremain}</td>
        </tr>
       <tr>
    	   <th width="120">培训情况<-->总数（人次）：</th>
           <td>${bean.trainingtotal}</td>
        </tr>
       <tr>
    	   <th width="120">培训情况<-->获得证书数（本）：</th>
           <td>${bean.trainingcertcount}</td>
        </tr>
       <tr>
    	   <th width="120">造血干细胞（人次）<-->采集数：</th>
           <td>${bean.hematopoieticstemcellcount}</td>
        </tr>
       <tr>
    	   <th width="120">造血干细胞（人次）<-->配对数	：</th>
           <td>${bean.hematopoieticstemcellpair}</td>
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
