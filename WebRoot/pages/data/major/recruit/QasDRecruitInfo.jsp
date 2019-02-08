<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 16:10:01
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
    	   <th width="120">计划招生数（人）：</th>
           <td>${bean.planenrolnum}</td>
        </tr>
       <tr>
    	   <th width="120">实际录取<-->录取数（人）：</th>
           <td>${bean.enrolednum}</td>
        </tr>
       <tr>
    	   <th width="120">实际报到情况报到数（人）：</th>
           <td>${bean.regnum}</td>
        </tr>
       <tr>
    	   <th width="120">区域生源报到本地市报到数：</th>
           <td>${bean.localregnum}</td>
        </tr>
       <tr>
    	   <th width="120">区域生源报到本省市报到数：</th>
           <td>${bean.provregnum}</td>
        </tr>
       <tr>
    	   <th width="120">区域生源报到本区域报到数：</th>
           <td>${bean.arearegnum}</td>
        </tr>
       <tr>
    	   <th width="120">报考本校原因<-->学校品牌报考数	：</th>
           <td>${bean.brandrsnnum}</td>
        </tr>
       <tr>
    	   <th width="120">报考本校原因<-->专业爱好报考数：</th>
           <td>${bean.hobbiesrsnnum}</td>
        </tr>
       <tr>
    	   <th width="120">报考本校原因<-->就业优势报考数：</th>
           <td>${bean.emprsnnum}</td>
        </tr>
       <tr>
    	   <th width="120">报考本校原因<-->技能培养报考数：</th>
           <td>${bean.trainrsnnum}</td>
        </tr>
       <tr>
    	   <th width="120">报考本校原因<-->地理位置报考数：</th>
           <td>${bean.sitersnnum}</td>
        </tr>
       <tr>
    	   <th width="120">报考本校原因<-->他人推荐报考数：</th>
           <td>${bean.recommendrsnnum}</td>
        </tr>
       <tr>
    	   <th width="120">报考本校原因<-->其他报考数：</th>
           <td>${bean.otherrsnnum}</td>
        </tr>
       <tr>
    	   <th width="120">投档线超过上年分数：</th>
           <td>${bean.overlastyearscore}</td>
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
