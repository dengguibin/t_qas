<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:58:43
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
    	   <th width="120">校外实践基地：</th>
           <td>${bean.practicebaseincampusid}</td>
        </tr>
       <tr>
    	   <th width="120">面向专业 ：</th>
           <td>${bean.majorid}</td>
        </tr>
       <tr>
    	   <th width="120">项目数：</th>
           <td>${bean.numoftrainingproject}</td>
        </tr>
       <tr>
    	   <th width="120">实习实训项目<-->项目：</th>
           <td>${bean.numofprojectname}</td>
        </tr>
       <tr>
    	   <th width="120">接待学生量(人次)	：</th>
           <td>${bean.numofstureceived}</td>
        </tr>
       <tr>
    	   <th width="120">基地使用时间（天）：</th>
           <td>${bean.baseusetime}</td>
        </tr>
       <tr>
    	   <th width="120">接受半年顶岗实习学生数：</th>
           <td>${bean.halfyearinternshipstudent}</td>
        </tr>
       <tr>
    	   <th width="120">是否有住宿条件	：</th>
           <td>${bean.isaccommodationconditions}</td>
        </tr>
       <tr>
    	   <th width="120">基地是否发放学生实习补贴：</th>
           <td>${bean.studentinternshipallowance}</td>
        </tr>
       <tr>
    	   <th width="120">向基地支付专项实习经费（元/生）：</th>
           <td>${bean.specialpracticefund}</td>
        </tr>
       <tr>
    	   <th width="120">派指导教师/学生管理人员（人次）：</th>
           <td>${bean.schooltutorcount}</td>
        </tr>
       <tr>
    	   <th width="120">接收应届毕业生就业数	：</th>
           <td>${bean.numofgraduateemployed}</td>
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
