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
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/major/directionStatistics/save.action" method="post">
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
      <%--  <tr>
       	   <th width="120">唯一标示：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写唯一标示"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">专业方向：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="directionid" name="bean.directionid"  value="${bean.directionid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">在校生数（人）<-->总人数：</th>
          <td>
           <input type="text" class="inputText" id="numofstudent"  maxlength="9"  name="bean.numofstudent"  value="${bean.numofstudent}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">在校生数（人）<-->一年级：</th>
          <td>
           <input type="text" class="inputText" id="numofgradeone"  maxlength="9"  name="bean.numofgradeone"  value="${bean.numofgradeone}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">在校生数（人）<-->二年级：</th>
          <td>
           <input type="text" class="inputText" id="numofgradetwo"  maxlength="9"  name="bean.numofgradetwo"  value="${bean.numofgradetwo}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">在校生数（人）<-->三年级：</th>
          <td>
           <input type="text" class="inputText" id="numofgradethree"  maxlength="9"  name="bean.numofgradethree"  value="${bean.numofgradethree}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">生源类型（人）<-->普通高中起点：</th>
          <td>
           <input type="text" class="inputText" id="hightpfsstunum"  maxlength="9"  name="bean.hightpfsstunum"  value="${bean.hightpfsstunum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">生源类型（人）<-->中职起点<-->合计：</th>
          <td>
           <input type="text" class="inputText" id="middlepfsstunum"  maxlength="9"  name="bean.middlepfsstunum"  value="${bean.middlepfsstunum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">生源类型（人）<-->五年制后二年：</th>
          <td>
           <input type="text" class="inputText" id="middleschtwoyearbehandnum"  maxlength="9"  name="bean.middleschtwoyearbehandnum"  value="${bean.middleschtwoyearbehandnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">生源类型（人）<-->其他：</th>
          <td>
           <input type="text" class="inputText" id="othernum"  maxlength="9"  name="bean.othernum"  value="${bean.othernum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">重点专业：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="coremajor" name="bean.coremajor"  value="${bean.coremajor}"  /></td>
        </tr>
       <tr>
       	   <th width="120">特色专业：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="characteristicmajor" name="bean.characteristicmajor"  value="${bean.characteristicmajor}"  /></td>
        </tr>
       <tr>
       	   <th width="120">是否国际合作专业：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="isinternationalmajor" name="bean.isinternationalmajor"  value="${bean.isinternationalmajor}"  /></td>
        </tr>
       <tr>
       	   <th width="120">班级总数（个）：</th>
          <td>
           <input type="text" class="inputText" id="gradecount"  maxlength="9"  name="bean.gradecount"  value="${bean.gradecount}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">订单(定向)培养：</th>
          <td>
           <input type="text" class="inputText" id="ordertrain"  maxlength="9"  name="bean.ordertrain"  value="${bean.ordertrain}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">是否有上届毕业生：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="isgradutionbefore" name="bean.isgradutionbefore"  value="${bean.isgradutionbefore}"  /></td>
        </tr>
       <tr>
       	   <th width="120">当年是否招生（含方向）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="iscurrentenroll" name="bean.iscurrentenroll"  value="${bean.iscurrentenroll}"  /></td>
        </tr>
       <tr>
       	   <th width="120">全日制在校生中去境外交流学生人数：</th>
          <td>
           <input type="text" class="inputText" id="exchangeabroad"  maxlength="9"  name="bean.exchangeabroad"  value="${bean.exchangeabroad}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">接收境外交流学生数量	：</th>
          <td>
           <input type="text" class="inputText" id="receivingoverseas"  maxlength="9"  name="bean.receivingoverseas"  value="${bean.receivingoverseas}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">去其他学校交流学生人数：</th>
          <td>
           <input type="text" class="inputText" id="exchangestudents"  maxlength="9"  name="bean.exchangestudents"  value="${bean.exchangestudents}"  />
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
