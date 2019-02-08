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
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/major/recruit/save.action" method="post">
			<s:hidden name="menuId" id="menuId"/>
			<s:hidden name="bean.id" id="id"/>
			<s:hidden name="bean.status" id="status"/>
			<s:hidden name="bean.createdby" id="createdby"/>
			<s:hidden name="bean.createdtime" id="createdtime"/>
			<s:hidden name="bean.updatedby" id="updatedby"/>
			<s:hidden name="bean.updatedtime" id="updatedtime"/>
			<s:hidden name="bean.tenantid" id="tenantid"/>
			<s:hidden name="bean.storagetime" id="storagetime"/>
			<!-- 令牌环，防止重复提交 -->
			<s:token></s:token>
			
		<div class="formtitle"><span>表头信息控制</span></div>	
		<table>
		  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
     	 </tr>
       <tbody>
       <%-- <tr>
       	   <th width="120">序号：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写序号"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">专业方向：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="directionid" name="bean.directionid"  value="${bean.directionid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">计划招生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="planenrolnum"  maxlength="9"  name="bean.planenrolnum"  value="${bean.planenrolnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">实际录取<-->录取数（人）：</th>
          <td>
           <input type="text" class="inputText" id="enrolednum"  maxlength="9"  name="bean.enrolednum"  value="${bean.enrolednum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">实际报到情况报到数（人）：</th>
          <td>
           <input type="text" class="inputText" id="regnum"  maxlength="9"  name="bean.regnum"  value="${bean.regnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">区域生源报到本地市报到数：</th>
          <td>
           <input type="text" class="inputText" id="localregnum"  maxlength="9"  name="bean.localregnum"  value="${bean.localregnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">区域生源报到本省市报到数：</th>
          <td>
           <input type="text" class="inputText" id="provregnum"  maxlength="9"  name="bean.provregnum"  value="${bean.provregnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">区域生源报到本区域报到数：</th>
          <td>
           <input type="text" class="inputText" id="arearegnum"  maxlength="9"  name="bean.arearegnum"  value="${bean.arearegnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">报考本校原因<-->学校品牌报考数	：</th>
          <td>
           <input type="text" class="inputText" id="brandrsnnum"  maxlength="9"  name="bean.brandrsnnum"  value="${bean.brandrsnnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">报考本校原因<-->专业爱好报考数：</th>
          <td>
           <input type="text" class="inputText" id="hobbiesrsnnum"  maxlength="9"  name="bean.hobbiesrsnnum"  value="${bean.hobbiesrsnnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">报考本校原因<-->就业优势报考数：</th>
          <td>
           <input type="text" class="inputText" id="emprsnnum"  maxlength="9"  name="bean.emprsnnum"  value="${bean.emprsnnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">报考本校原因<-->技能培养报考数：</th>
          <td>
           <input type="text" class="inputText" id="trainrsnnum"  maxlength="9"  name="bean.trainrsnnum"  value="${bean.trainrsnnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">报考本校原因<-->地理位置报考数：</th>
          <td>
           <input type="text" class="inputText" id="sitersnnum"  maxlength="9"  name="bean.sitersnnum"  value="${bean.sitersnnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">报考本校原因<-->他人推荐报考数：</th>
          <td>
           <input type="text" class="inputText" id="recommendrsnnum"  maxlength="9"  name="bean.recommendrsnnum"  value="${bean.recommendrsnnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">报考本校原因<-->其他报考数：</th>
          <td>
           <input type="text" class="inputText" id="otherrsnnum"  maxlength="9"  name="bean.otherrsnnum"  value="${bean.otherrsnnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">投档线超过上年分数：</th>
          <td>
           <input type="text" class="inputText" id="overlastyearscore"  maxlength="9"  name="bean.overlastyearscore"  value="${bean.overlastyearscore}"  />
           </td>
        </tr>
      <%--  <tr>
       	   <th width="120">状态：</th>
          <td>
           <input type="text" class="inputText" id="status"  maxlength="9"  name="bean.status"  value="${bean.status}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">创建人：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="createdby" name="bean.createdby"  value="${bean.createdby}"  /></td>
        </tr>
       <tr>
       	   <th width="120">创建时间：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="createdtime" name="bean.createdtime"  value="${createdtime}" />
          </td>
        </tr>
       <tr>
       	   <th width="120">修改人：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="updatedby" name="bean.updatedby"  value="${bean.updatedby}"  /></td>
        </tr>
       <tr>
       	   <th width="120">修改时间：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="updatedtime" name="bean.updatedtime"  value="${updatedtime}" />
          </td>
        </tr>
       <tr>
       	   <th width="120">租户：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="tenantid" name="bean.tenantid"  value="${bean.tenantid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">入库时间（接口传输，导入）：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="storagetime" name="bean.storagetime"  value="${storagetime}" />
          </td>
        </tr> --%>
	   
	    <tr>
        <td colspan="2" class="toolbar">
        <input type="button" class="inputButton" onclick="$('#opForm').submit();" value=" 确 定 " />
         <input type="button"  class="cancel" value=" 返 回 " id="returnButton"/>
          &nbsp;&nbsp;</td>
      	</tr>
	   
       </tbody>
    </table>
         </form>
  </div><!--editblock end-->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
