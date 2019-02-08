<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:18:45
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
    	   <th width="120">学校标识码：</th>
           <td>${bean.code}</td>
        </tr>
       <tr>
    	   <th width="120">学校名称(全称)	：</th>
           <td>${bean.name}</td>
        </tr>
       <tr>
    	   <th width="120">所在地区（省、自治区、直辖市)：</th>
           <td>${bean.location}</td>
        </tr>
       <tr>
    	   <th width="120">当前校名启用日期（年月）：</th>
           <td>${bean.nameuseddate}</td>
        </tr>
       <tr>
    	   <th width="120">建校日期（年月）：</th>
           <td>${bean.buildeddate}</td>
        </tr>
       <tr>
    	   <th width="120">建校基础	：</th>
           <td>${bean.buildedbase}</td>
        </tr>
       <tr>
    	   <th width="120">学校举办者<-->名称(全称)  ：</th>
           <td>${bean.creatername}</td>
        </tr>
       <tr>
    	   <th width="120">学校举办者<-->性质：</th>
           <td>${bean.creaternature}</td>
        </tr>
       <tr>
    	   <th width="120">学校举办者<-->级别	：</th>
           <td>${bean.creatergrade}</td>
        </tr>
       <tr>
    	   <th width="120">学校性质类别：</th>
           <td>${bean.grade}</td>
        </tr>
       <tr>
    	   <th width="120">校训	：</th>
           <td>${bean.motto}</td>
        </tr>
       <tr>
    	   <th width="120">通信地址	：</th>
           <td>${bean.address}</td>
        </tr>
       <tr>
    	   <th width="120">邮政编码：</th>
           <td>${bean.postcode}</td>
        </tr>
       <tr>
    	   <th width="120">学校网址：</th>
           <td>${bean.web}</td>
        </tr>
       <tr>
    	   <th width="120">社区教育示范校：</th>
           <td>${bean.iscommunityedudemonstration}</td>
        </tr>
       <tr>
    	   <th width="120">示范性高等职业院校<-->性质：</th>
           <td>${bean.exampnature}</td>
        </tr>
       <tr>
    	   <th width="120">示范性高等职业院校<-->级别：</th>
           <td>${bean.exampgrade}</td>
        </tr>
       <tr>
    	   <th width="120">示范性高等职业院校<-->立项部门：</th>
           <td>${bean.exampdepartment}</td>
        </tr>
       <tr>
    	   <th width="120">示范性高等职业院校<-->立项日期（年）：</th>
           <td>${bean.exampbuildedtime}</td>
        </tr>
       <tr>
    	   <th width="120">评估状态<-->第一轮<-->评估日期（年月)：</th>
           <td>${bean.estimatefirsttime}</td>
        </tr>
       <tr>
    	   <th width="120">评估状态<-->第二轮<-->评估结论：</th>
           <td>${bean.estimatesecondresult}</td>
        </tr>
       <tr>
    	   <th width="120">评估状态<-->未接受评估：</th>
           <td>${bean.estimatenorun}</td>
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
