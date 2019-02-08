<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 16:15:03
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
     <%--   <tr>
    	   <th width="120">记录标识：</th>
           <td>${bean.id}</td>
        </tr> --%>
       <tr>
    	   <th width="120">专业：</th>
           <td>${bean.majorid}</td>
        </tr>
       <tr>
    	   <th width="120">专业建设规划是否及时跟踪市场需求变化和产业结构调整的需要，进行SWOT分析
            ：</th>
           <td>${bean.ismajorswotanalysis}</td>
        </tr>
       <tr>
    	   <th width="120">是否明确专业核心岗位和能力要求（职业能力分析）：</th>
           <td>${bean.isoccupationalanalysis}</td>
        </tr>
       <tr>
    	   <th width="120">人才培养方案是否建立三级的论证审核制度(专业、二级学院、学校)：</th>
           <td>${bean.ishavethreelevelauditsystem}</td>
        </tr>
       <tr>
    	   <th width="120">人才培养方案是否邀请三位以上行业专家和学生代表进行评审：</th>
           <td>${bean.isinviterepresentativestoreview}</td>
        </tr>
       <tr>
    	   <th width="120">课程体系的实施是否能实现专业能力的培养（课程体系与能力对照表），全部课程标准是否齐备：</th>
           <td>${bean.iscurriculumsystemavailable}</td>
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
