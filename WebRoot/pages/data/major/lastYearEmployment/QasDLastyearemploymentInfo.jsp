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
    	   <th width="120">专业方向：</th>
           <td>${bean.directionid}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生数（人）：</th>
           <td>${bean.gradnum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生就业情况<-->就业数(人)：</th>
           <td>${bean.empnum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生就业情况<-->升迁数（人）：</th>
           <td>${bean.promotion}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生就业情况<-->转岗数（人）：</th>
           <td>${bean.tranwork}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生用人单位满意情况<-->满意或基本满意人数：</th>
           <td>${bean.satisfied}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生用人单位满意情况<-->一般满意人数：</th>
           <td>${bean.nomal}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生用人单位满意情况<-->不满意人数：</th>
           <td>${bean.dissatisfied}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生的教学满意人数：</th>
           <td>${bean.satisfiedwithteaching}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生对母校的满意人数：</th>
           <td>${bean.satisfiedwithcollege}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生工作与职业期待吻合人数：</th>
           <td>${bean.workandcareerexpectationsmatch}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生对基本工作能力总体满足人数：</th>
           <td>${bean.satisfiedwithworkability}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生对核心知识的总体满足人数：</th>
           <td>${bean.satisfiedwithcoreknowledge}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生的就业现状满意人数 ：</th>
           <td>${bean.satisfiedwithemployment}</td>
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
