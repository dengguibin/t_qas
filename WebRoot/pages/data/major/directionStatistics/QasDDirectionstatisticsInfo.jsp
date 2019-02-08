<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 16:05:48
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
    	   <th width="120">唯一标示：</th>
           <td>${bean.id}</td>
        </tr> --%>
       <tr>
    	   <th width="120">专业方向：</th>
           <td>${bean.directionid}</td>
        </tr>
       <tr>
    	   <th width="120">在校生数（人）<-->总人数：</th>
           <td>${bean.numofstudent}</td>
        </tr>
       <tr>
    	   <th width="120">在校生数（人）<-->一年级：</th>
           <td>${bean.numofgradeone}</td>
        </tr>
       <tr>
    	   <th width="120">在校生数（人）<-->二年级：</th>
           <td>${bean.numofgradetwo}</td>
        </tr>
       <tr>
    	   <th width="120">在校生数（人）<-->三年级：</th>
           <td>${bean.numofgradethree}</td>
        </tr>
       <tr>
    	   <th width="120">生源类型（人）<-->普通高中起点：</th>
           <td>${bean.hightpfsstunum}</td>
        </tr>
       <tr>
    	   <th width="120">生源类型（人）<-->中职起点<-->合计：</th>
           <td>${bean.middlepfsstunum}</td>
        </tr>
       <tr>
    	   <th width="120">生源类型（人）<-->五年制后二年：</th>
           <td>${bean.middleschtwoyearbehandnum}</td>
        </tr>
       <tr>
    	   <th width="120">生源类型（人）<-->其他：</th>
           <td>${bean.othernum}</td>
        </tr>
       <tr>
    	   <th width="120">重点专业：</th>
           <td>${bean.coremajor}</td>
        </tr>
       <tr>
    	   <th width="120">特色专业：</th>
           <td>${bean.characteristicmajor}</td>
        </tr>
       <tr>
    	   <th width="120">是否国际合作专业：</th>
           <td>${bean.isinternationalmajor}</td>
        </tr>
       <tr>
    	   <th width="120">班级总数（个）：</th>
           <td>${bean.gradecount}</td>
        </tr>
       <tr>
    	   <th width="120">订单(定向)培养：</th>
           <td>${bean.ordertrain}</td>
        </tr>
       <tr>
    	   <th width="120">是否有上届毕业生：</th>
           <td>${bean.isgradutionbefore}</td>
        </tr>
       <tr>
    	   <th width="120">当年是否招生（含方向）：</th>
           <td>${bean.iscurrentenroll}</td>
        </tr>
       <tr>
    	   <th width="120">全日制在校生中去境外交流学生人数：</th>
           <td>${bean.exchangeabroad}</td>
        </tr>
       <tr>
    	   <th width="120">接收境外交流学生数量	：</th>
           <td>${bean.receivingoverseas}</td>
        </tr>
       <tr>
    	   <th width="120">去其他学校交流学生人数：</th>
           <td>${bean.exchangestudents}</td>
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
