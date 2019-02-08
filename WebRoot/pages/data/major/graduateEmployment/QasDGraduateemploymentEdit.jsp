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
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/major/graduateEmployment/save.action" method="post">
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
       	   <th width="120">序号：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写序号"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">专业方向：</th>
           <td><input type="text" class="inputText"  maxlength="18"  id="directionid" name="bean.directionid"  value="${bean.directionid}"  /></td>
        </tr>
       <tr>
       	   <th width="120">毕业生就业情况<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="empnum"  maxlength="9"  name="bean.empnum"  value="${bean.empnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生就业情况<-->本地市<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="cityempnum"  maxlength="9"  name="bean.cityempnum"  value="${bean.cityempnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生就业情况<-->本省市<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="privincenum"  maxlength="9"  name="bean.privincenum"  value="${bean.privincenum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生就业情况<-->本区域<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="column_13areanum"  maxlength="9"  name="bean.column_13areanum"  value="${bean.column_13areanum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生就业情况<-->其他<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="othernum"  maxlength="9"  name="bean.othernum"  value="${bean.othernum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生就业情况<-->起薪线：</th>
          <td>
           <input type="text" class="inputText" id="empsalary"  maxlength="9"  name="bean.empsalary"  value="${bean.empsalary}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生就业情况<-->对口就业<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="samepfsnum"  maxlength="9"  name="bean.samepfsnum"  value="${bean.samepfsnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生普通高中生<-->毕业生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="hightschgradnum"  maxlength="9"  name="bean.hightschgradnum"  value="${bean.hightschgradnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生普通高中生<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="hightschnum"  maxlength="9"  name="bean.hightschnum"  value="${bean.hightschnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生“三校生”<-->毕业生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="trischgradnum"  maxlength="9"  name="bean.trischgradnum"  value="${bean.trischgradnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生“三校生”<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="trischnum"  maxlength="9"  name="bean.trischnum"  value="${bean.trischnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生“3＋2”<-->毕业生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="threeaddtowgradnum"  maxlength="9"  name="bean.threeaddtowgradnum"  value="${bean.threeaddtowgradnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生“3＋2”<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="threeaddtownum"  maxlength="9"  name="bean.threeaddtownum"  value="${bean.threeaddtownum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生五年制高职<-->毕业生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="collegegradnum"  maxlength="9"  name="bean.collegegradnum"  value="${bean.collegegradnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生五年制高职<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="collegenum"  maxlength="9"  name="bean.collegenum"  value="${bean.collegenum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->基于高考的“知识+技能”招生<-->毕业生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="difsknowskgrad"  maxlength="9"  name="bean.difsknowskgrad"  value="${bean.difsknowskgrad}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->基于高考的“知识+技能”招生<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="difsknowsknum"  maxlength="9"  name="bean.difsknowsknum"  value="${bean.difsknowsknum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->对口招生<-->毕业生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="difssamepfsgrad"  maxlength="9"  name="bean.difssamepfsgrad"  value="${bean.difssamepfsgrad}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->对口招生<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="difssamepfsnum"  maxlength="9"  name="bean.difssamepfsnum"  value="${bean.difssamepfsnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->单独考试招生<-->毕业生数（人）	：</th>
          <td>
           <input type="text" class="inputText" id="difssglexamgrad"  maxlength="9"  name="bean.difssglexamgrad"  value="${bean.difssglexamgrad}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->单独考试招生<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="difssglexamnum"  maxlength="9"  name="bean.difssglexamnum"  value="${bean.difssglexamnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->综合评价招生<-->毕业生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="difsmulestgrad"  maxlength="9"  name="bean.difsmulestgrad"  value="${bean.difsmulestgrad}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->综合评价招生<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="difsmulestnum"  maxlength="9"  name="bean.difsmulestnum"  value="${bean.difsmulestnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->中高职贯通的招生<-->毕业生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="difsmidhiggrad"  maxlength="9"  name="bean.difsmidhiggrad"  value="${bean.difsmidhiggrad}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->中高职贯通的招生<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="difsmidhignum"  maxlength="9"  name="bean.difsmidhignum"  value="${bean.difsmidhignum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->技能拨尖人才免试招生<-->毕业生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="difsnoexamgrad"  maxlength="9"  name="bean.difsnoexamgrad"  value="${bean.difsnoexamgrad}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->技能拨尖人才免试招生<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="difsnoexamnum"  maxlength="9"  name="bean.difsnoexamnum"  value="${bean.difsnoexamnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->其他<-->毕业生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="difsothergrad"  maxlength="9"  name="bean.difsothergrad"  value="${bean.difsothergrad}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生基于不同招生方式生源的就业情况<-->其他<-->就业数（人）：</th>
          <td>
           <input type="text" class="inputText" id="difsothernum"  maxlength="9"  name="bean.difsothernum"  value="${bean.difsothernum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">毕业生数：</th>
          <td>
           <input type="text" class="inputText" id="gradnum"  maxlength="9"  name="bean.gradnum"  value="${bean.gradnum}"  />
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
