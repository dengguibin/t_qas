<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 16:08:21
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
    	   <th width="120">序号：</th>
           <td>${bean.id}</td>
        </tr> --%>
       <tr>
    	   <th width="120">专业方向：</th>
           <td>${bean.directionid}</td>
        </tr>
       <tr>
    	   <th width="120">应届毕业生顶岗实习<-->顶岗实习毕业生总数（人）：</th>
           <td>${bean.gradpracticenum}</td>
        </tr>
       <tr>
    	   <th width="120">应届毕业生顶岗实习<-->企业录用顶岗实习毕业生数（人）：</th>
           <td>${bean.recruitednum}</td>
        </tr>
       <tr>
    	   <th width="120">应届毕业生顶岗实习<-->顶岗实习对口毕业生数（人）：</th>
           <td>${bean.samepfsnum}</td>
        </tr>
       <tr>
    	   <th width="120">顶岗实习与保险情况<-->顶岗实习单位总数（个）：</th>
           <td>${bean.companynum}</td>
        </tr>
       <tr>
    	   <th width="120">顶岗实习与保险情况<-->参加保险学生数（人）：</th>
           <td>${bean.joinednum}</td>
        </tr>
       <tr>
    	   <th width="120">顶岗实习与保险情况<-->保险险种名称(全称)（保险费出资方）：</th>
           <td>${bean.insurancename}</td>
        </tr>
       <tr>
    	   <th width="120">顶岗实习情况<-->主要实习岗位：</th>
           <td>${bean.practice_posts}</td>
        </tr>
       <tr>
    	   <th width="120">顶岗实习情况<-->主要实习单位：</th>
           <td>${bean.practice_compy}</td>
        </tr>
       <tr>
    	   <th width="120">顶岗实习情况<-->实习人数（人）：</th>
           <td>${bean.practicenum}</td>
        </tr>
       <tr>
    	   <th width="120">顶岗实习情况<-->实习时间（月）：</th>
           <td>${bean.practicetime}</td>
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
