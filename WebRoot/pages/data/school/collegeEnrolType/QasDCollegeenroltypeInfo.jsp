<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:41:43
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
    	   <th width="120">全日制高职招生数：</th>
           <td>${bean.collegenum}</td>
        </tr>
       <tr>
    	   <th width="120">基于高考的“知识+技能”招生<-->招生数（人）：</th>
           <td>${bean.seniorexamnum}</td>
        </tr>
       <tr>
    	   <th width="120">对口招生<-->招生数（人）：</th>
           <td>${bean.samepfsnum}</td>
        </tr>
       <tr>
    	   <th width="120">单独考试招生<-->招生数（人）：</th>
           <td>${bean.singleexamnum}</td>
        </tr>
       <tr>
    	   <th width="120">综合评价招生<-->招生数（人）：</th>
           <td>${bean.mulestimatenum}</td>
        </tr>
       <tr>
    	   <th width="120">中高职贯通的招生<-->招生数（人）：</th>
           <td>${bean.midhigconnum}</td>
        </tr>
       <tr>
    	   <th width="120">技能拔尖人才免试招生<-->招生数（人）：</th>
           <td>${bean.noexamnum}</td>
        </tr>
       <tr>
    	   <th width="120">其他 <-->招生数（人）：</th>
           <td>${bean.othernum}</td>
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
