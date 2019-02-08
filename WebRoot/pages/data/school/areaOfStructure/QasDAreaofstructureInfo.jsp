<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:44:17
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
    	   <th width="120">占地面积：</th>
           <td>${bean.areacovered}</td>
        </tr>
       <tr>
    	   <th width="120">总建筑面积：</th>
           <td>${bean.constructionarea}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->学校产权校舍建筑面积<-->合计：</th>
           <td>${bean.schoolbuildingarea}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->学校产权校舍建筑面积<-->当年新增校舍：</th>
           <td>${bean.schooladdbuilding}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->非学校产权校舍建筑面积：</th>
           <td>${bean.nonschoolpropertyarea}</td>
        </tr>
       <tr>
    	   <th width="120">教学科研及辅助用房：</th>
           <td>${bean.researchandauxiliary}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->教室：</th>
           <td>${bean.classroom}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->图书馆：</th>
           <td>${bean.library}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->实验室、实习场所：</th>
           <td>${bean.laboratoryandpractice}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->专用科研用房：</th>
           <td>${bean.specialresearch}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->体育馆：</th>
           <td>${bean.stadium}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->会堂：</th>
           <td>${bean.hall}</td>
        </tr>
       <tr>
    	   <th width="120">行政办公用房：</th>
           <td>${bean.office}</td>
        </tr>
       <tr>
    	   <th width="120">生活用房：</th>
           <td>${bean.livingroom}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->学生宿舍（公寓）：</th>
           <td>${bean.studentdormitory}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->学生食堂：</th>
           <td>${bean.studentcanteen}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->教工宿舍（公寓）：</th>
           <td>${bean.employeedormitory}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->教工食堂：</th>
           <td>${bean.employeecanteen}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->生活福利及附属用房：</th>
           <td>${bean.welfarehouse}</td>
        </tr>
       <tr>
    	   <th width="120">教工住宅：</th>
           <td>${bean.facultyresidence}</td>
        </tr>
       <tr>
    	   <th width="120">其他用房：</th>
           <td>${bean.otherresidence}</td>
        </tr>
       <tr>
    	   <th width="120">一体化教室：</th>
           <td>${bean.integratedclassroom}</td>
        </tr>
       <tr>
    	   <th width="120">占地面积<-->绿化用：</th>
           <td>${bean.acreage}</td>
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
