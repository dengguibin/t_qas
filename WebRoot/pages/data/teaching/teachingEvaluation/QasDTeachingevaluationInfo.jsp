<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-24 12:17:59
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
    	   <th width="120">序号：</th>
           <td>${bean.id}</td>
        </tr>
       <tr>
    	   <th width="120">评教起始日期（年月）：</th>
           <td>${bean.teachingevaluationstarttime}</td>
        </tr>
       <tr>
    	   <th width="120">评教终止日期（年月）：</th>
           <td>${bean.teachingevaluationendtime}</td>
        </tr>
       <tr>
    	   <th width="120">评教客体（教师）<-->评教客体（教师）<-->参与数（人）：</th>
           <td>${bean.numofparticipantteacher}</td>
        </tr>
       <tr>
    	   <th width="120">评教客体（教师）<-->评教客体（教师）<-->总数（人）：</th>
           <td>${bean.totalnumofteacher}</td>
        </tr>
       <tr>
    	   <th width="120">评教主体参与度<-->学生<-->参与数（人）：</th>
           <td>${bean.numofstudent}</td>
        </tr>
       <tr>
    	   <th width="120">评教主体参与度<-->学生<-->总数（人）：</th>
           <td>${bean.totalnumofstudent}</td>
        </tr>
       <tr>
    	   <th width="120">评教主体参与度<-->同行<-->参与数（人）：</th>
           <td>${bean.numofparticipantschoolmate}</td>
        </tr>
       <tr>
    	   <th width="120">评教主体参与度<-->同行<-->总数（人）：</th>
           <td>${bean.totalnumofschoolmate}</td>
        </tr>
       <tr>
    	   <th width="120">评教主体参与度<-->校领导<-->参与数（人）：</th>
           <td>${bean.numofparticipantleader}</td>
        </tr>
       <tr>
    	   <th width="120">评教主体参与度<-->校领导<-->总数（人）：</th>
           <td>${bean.totalnumofleader}</td>
        </tr>
       <tr>
    	   <th width="120">评教主体参与度<-->社会<-->参与数（人）：</th>
           <td>${bean.numofparticipantsociety}</td>
        </tr>
       <tr>
    	   <th width="120">评教主体参与度<-->社会<-->总数（人）：</th>
           <td>${bean.totalnumofsociety}</td>
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
