<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 16:13:42
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
      <%--  <tr>
    	   <th width="120">序号：</th>
           <td>${bean.id}</td>
        </tr> --%>
       <tr>
    	   <th width="120">专业方向：</th>
           <td>${bean.directionid}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生就业情况<-->就业数（人）：</th>
           <td>${bean.empnum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生就业情况<-->本地市<-->就业数（人）：</th>
           <td>${bean.cityempnum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生就业情况<-->本省市<-->就业数（人）：</th>
           <td>${bean.privincenum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生就业情况<-->本区域<-->就业数（人）：</th>
           <td>${bean.column_13areanum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生就业情况<-->其他<-->就业数（人）：</th>
           <td>${bean.othernum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生就业情况<-->起薪线：</th>
           <td>${bean.empsalary}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生就业情况<-->对口就业<-->就业数（人）：</th>
           <td>${bean.samepfsnum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生普通高中生<-->毕业生数（人）：</th>
           <td>${bean.hightschgradnum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生普通高中生<-->就业数（人）：</th>
           <td>${bean.hightschnum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生“三校生”<-->毕业生数（人）：</th>
           <td>${bean.trischgradnum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生“三校生”<-->就业数（人）：</th>
           <td>${bean.trischnum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生“3＋2”<-->毕业生数（人）：</th>
           <td>${bean.threeaddtowgradnum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生“3＋2”<-->就业数（人）：</th>
           <td>${bean.threeaddtownum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生五年制高职<-->毕业生数（人）：</th>
           <td>${bean.collegegradnum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生五年制高职<-->就业数（人）：</th>
           <td>${bean.collegenum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->基于高考的“知识+技能”招生<-->毕业生数（人）：</th>
           <td>${bean.difsknowskgrad}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->基于高考的“知识+技能”招生<-->就业数（人）：</th>
           <td>${bean.difsknowsknum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->对口招生<-->毕业生数（人）：</th>
           <td>${bean.difssamepfsgrad}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->对口招生<-->就业数（人）：</th>
           <td>${bean.difssamepfsnum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->单独考试招生<-->毕业生数（人）	：</th>
           <td>${bean.difssglexamgrad}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->单独考试招生<-->就业数（人）：</th>
           <td>${bean.difssglexamnum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->综合评价招生<-->毕业生数（人）：</th>
           <td>${bean.difsmulestgrad}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->综合评价招生<-->就业数（人）：</th>
           <td>${bean.difsmulestnum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->中高职贯通的招生<-->毕业生数（人）：</th>
           <td>${bean.difsmidhiggrad}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->中高职贯通的招生<-->就业数（人）：</th>
           <td>${bean.difsmidhignum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->技能拨尖人才免试招生<-->毕业生数（人）：</th>
           <td>${bean.difsnoexamgrad}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->技能拨尖人才免试招生<-->就业数（人）：</th>
           <td>${bean.difsnoexamnum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->其他<-->毕业生数（人）：</th>
           <td>${bean.difsothergrad}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->其他<-->就业数（人）：</th>
           <td>${bean.difsothernum}</td>
        </tr>
       <tr>
    	   <th width="120">毕业生数：</th>
           <td>${bean.gradnum}</td>
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
