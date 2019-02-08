<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:42:22
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
    	   <th width="120">折合在校生数（人）：</th>
           <td>${bean.offnum}</td>
        </tr>
       <tr>
    	   <th width="120">全日制学历教育在校生数（人）：</th>
           <td>${bean.edustunum}</td>
        </tr>
       <tr>
    	   <th width="120">全日制普通高职学历教育在校生总数（人）：</th>
           <td>${bean.senioredustunum}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->高中起点：</th>
           <td>${bean.hightpfsstunum}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->中职起点<-->合计：</th>
           <td>${bean.middlepfsstunum}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->中职起点<-->五年制后二年：</th>
           <td>${bean.middleschtwoyearbehandnum}</td>
        </tr>
       <tr>
    	   <th width="120">其中<-->其他：</th>
           <td>${bean.othernum}</td>
        </tr>
       <tr>
    	   <th width="120">全日制普通中职学历教育在校生（人)<-->合计：</th>
           <td>${bean.fulltimestunum}</td>
        </tr>
       <tr>
    	   <th width="120">全日制普通中职学历教育在校生（人)<-->五年制前三年：</th>
           <td>${bean.fulltimestuthreeyearbeforenum}</td>
        </tr>
       <tr>
    	   <th width="120">全日制普通中职学历教育在校生（人)<-->新型职业农民：</th>
           <td>${bean.fulltimestufarmernum}</td>
        </tr>
       <tr>
    	   <th width="120">全日制成人高职在校生（人）：</th>
           <td>${bean.adultcollegestunum}</td>
        </tr>
       <tr>
    	   <th width="120">全日制成人中职在校生（人）：</th>
           <td>${bean.adultmiddlestunum}</td>
        </tr>
       <tr>
    	   <th width="120">非全日制专科学历教育注册生（人）：</th>
           <td>${bean.parttimepfseduregnum}</td>
        </tr>
       <tr>
    	   <th width="120">非全日制本科学历教育注册生（人）：</th>
           <td>${bean.parttimesenioreduregnum}</td>
        </tr>
       <tr>
    	   <th width="120">培训(人天)<-->社会：</th>
           <td>${bean.trainsocietynum}</td>
        </tr>
       <tr>
    	   <th width="120">培训(人天)<-->在校生：</th>
           <td>${bean.trainstunum}</td>
        </tr>
       <tr>
    	   <th width="120">培训对象（人次）<-->特定群体：</th>
           <td>${bean.trainspecificgroup}</td>
        </tr>
       <tr>
    	   <th width="120">培训对象（人次）<-->小微企业：</th>
           <td>${bean.trainsmallcompany}</td>
        </tr>
       <tr>
    	   <th width="120">留学生数<-->境外：</th>
           <td>${bean.oversea}</td>
        </tr>
       <tr>
    	   <th width="120">留学生数<-->国外：</th>
           <td>${bean.abroad}</td>
        </tr>
       <tr>
    	   <th width="120">预科生、进修生、成人脱产班学生数合计：</th>
           <td>${bean.adultstudent}</td>
        </tr>
       <tr>
    	   <th width="120">夜大（业余）学生数：</th>
           <td>${bean.eveninguniversitystudent}</td>
        </tr>
       <tr>
    	   <th width="120">函授生数：</th>
           <td>${bean.correspondencestudent}</td>
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
