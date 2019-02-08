<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:45:56
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
    	   <th width="120">出口总带宽（Mbps）：</th>
           <td>${bean.exportbandwidth}</td>
        </tr>
       <tr>
    	   <th width="120">校园网主干最大带宽（Mbps）：</th>
           <td>${bean.campusnetwork}</td>
        </tr>
       <tr>
    	   <th width="120">网络信息点数（个）：</th>
           <td>${bean.networkinformationpoint}</td>
        </tr>
       <tr>
    	   <th width="120">管理信息系统数据总量（GB）：</th>
           <td>${bean.accountofmis}</td>
        </tr>
       <tr>
    	   <th width="120">电子邮件系统用户数（个）：</th>
           <td>${bean.emailusercount}</td>
        </tr>
       <tr>
    	   <th width="120">上网课程数（门）：</th>
           <td>${bean.onlinecoursecount}</td>
        </tr>
       <tr>
    	   <th width="120">数字资源量(GB)<-->合计：</th>
           <td>${bean.totaldigitalresource}</td>
        </tr>
       <tr>
    	   <th width="120">数字资源量(GB)<-->电子图书：</th>
           <td>${bean.electronicbook}</td>
        </tr>
       <tr>
    	   <th width="120">多媒体教学资源库总容量（TB）：</th>
           <td>${bean.multimediacapacity}</td>
        </tr>
       <tr>
    	   <th width="120">国家级职业教育专业教学资源库数量：</th>
           <td>${bean.nationallevelresource}</td>
        </tr>
       <tr>
    	   <th width="120">省级职业教育专业教学资源库数量：</th>
           <td>${bean.provincialresource}</td>
        </tr>
       <tr>
    	   <th width="120">一卡通使用	：</th>
           <td>${bean.allinonecardusage}</td>
        </tr>
       <tr>
    	   <th width="120">无线覆盖情况	：</th>
           <td>${bean.wirelesscoverage}</td>
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
