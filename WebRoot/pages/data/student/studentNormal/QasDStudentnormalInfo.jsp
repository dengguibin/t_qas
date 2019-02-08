<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-24 10:39:24
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
    	   <th width="120">记录标识 ：</th>
           <td>${bean.id}</td>
        </tr>
       <tr>
    	   <th width="120">学生名称：</th>
           <td>${bean.studentid}</td>
        </tr>
       <tr>
    	   <th width="120">缺课次数：</th>
           <td>${bean.absence}</td>
        </tr>
       <tr>
    	   <th width="120">迟到次数：</th>
           <td>${bean.tardiness}</td>
        </tr>
       <tr>
    	   <th width="120">早退次数：</th>
           <td>${bean.prematureleave}</td>
        </tr>
       <tr>
    	   <th width="120">早退次数：</th>
           <td>${bean.leaves}</td>
        </tr>
       <tr>
    	   <th width="120">学生综合测评积分：</th>
           <td>${bean.evaluationpoint}</td>
        </tr>
       <tr>
    	   <th width="120">学期内违纪次数：</th>
           <td>${bean.discipline}</td>
        </tr>
       <tr>
    	   <th width="120">学期内犯罪次数：</th>
           <td>${bean.crime}</td>
        </tr>
       <tr>
    	   <th width="120">学期内群体事件次数：</th>
           <td>${bean.groupevent}</td>
        </tr>
       <tr>
    	   <th width="120">学期内责任性伤亡：</th>
           <td>${bean.casualties}</td>
        </tr>
       <tr>
    	   <th width="120">处分次数：</th>
           <td>${bean.punishmenttime}</td>
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
