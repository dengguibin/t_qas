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
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/school/collegeInSchoolStudent/save.action" method="post">
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
    <%--    <tr>
       	   <th width="120">记录标识：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="18"  id="id" name="bean.id"  value="${bean.id}"  datatype="*" nullmsg="请填写记录标识"/></td>
        </tr> --%>
       <tr>
       	   <th width="120">折合在校生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="offnum"  maxlength="9"  name="bean.offnum"  value="${bean.offnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">全日制学历教育在校生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="edustunum"  maxlength="9"  name="bean.edustunum"  value="${bean.edustunum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">全日制普通高职学历教育在校生总数（人）：</th>
          <td>
           <input type="text" class="inputText" id="senioredustunum"  maxlength="9"  name="bean.senioredustunum"  value="${bean.senioredustunum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->高中起点：</th>
          <td>
           <input type="text" class="inputText" id="hightpfsstunum"  maxlength="9"  name="bean.hightpfsstunum"  value="${bean.hightpfsstunum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->中职起点<-->合计：</th>
          <td>
           <input type="text" class="inputText" id="middlepfsstunum"  maxlength="9"  name="bean.middlepfsstunum"  value="${bean.middlepfsstunum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->中职起点<-->五年制后二年：</th>
          <td>
           <input type="text" class="inputText" id="middleschtwoyearbehandnum"  maxlength="9"  name="bean.middleschtwoyearbehandnum"  value="${bean.middleschtwoyearbehandnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">其中<-->其他：</th>
          <td>
           <input type="text" class="inputText" id="othernum"  maxlength="9"  name="bean.othernum"  value="${bean.othernum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">全日制普通中职学历教育在校生（人)<-->合计：</th>
          <td>
           <input type="text" class="inputText" id="fulltimestunum"  maxlength="9"  name="bean.fulltimestunum"  value="${bean.fulltimestunum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">全日制普通中职学历教育在校生（人)<-->五年制前三年：</th>
          <td>
           <input type="text" class="inputText" id="fulltimestuthreeyearbeforenum"  maxlength="9"  name="bean.fulltimestuthreeyearbeforenum"  value="${bean.fulltimestuthreeyearbeforenum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">全日制普通中职学历教育在校生（人)<-->新型职业农民：</th>
          <td>
           <input type="text" class="inputText" id="fulltimestufarmernum"  maxlength="9"  name="bean.fulltimestufarmernum"  value="${bean.fulltimestufarmernum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">全日制成人高职在校生（人）：</th>
          <td>
           <input type="text" class="inputText" id="adultcollegestunum"  maxlength="9"  name="bean.adultcollegestunum"  value="${bean.adultcollegestunum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">全日制成人中职在校生（人）：</th>
          <td>
           <input type="text" class="inputText" id="adultmiddlestunum"  maxlength="9"  name="bean.adultmiddlestunum"  value="${bean.adultmiddlestunum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">非全日制专科学历教育注册生（人）：</th>
          <td>
           <input type="text" class="inputText" id="parttimepfseduregnum"  maxlength="9"  name="bean.parttimepfseduregnum"  value="${bean.parttimepfseduregnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">非全日制本科学历教育注册生（人）：</th>
          <td>
           <input type="text" class="inputText" id="parttimesenioreduregnum"  maxlength="9"  name="bean.parttimesenioreduregnum"  value="${bean.parttimesenioreduregnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">培训(人天)<-->社会：</th>
          <td>
           <input type="text" class="inputText" id="trainsocietynum"  maxlength="9"  name="bean.trainsocietynum"  value="${bean.trainsocietynum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">培训(人天)<-->在校生：</th>
          <td>
           <input type="text" class="inputText" id="trainstunum"  maxlength="9"  name="bean.trainstunum"  value="${bean.trainstunum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">培训对象（人次）<-->特定群体：</th>
          <td>
           <input type="text" class="inputText" id="trainspecificgroup"  maxlength="9"  name="bean.trainspecificgroup"  value="${bean.trainspecificgroup}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">培训对象（人次）<-->小微企业：</th>
          <td>
           <input type="text" class="inputText" id="trainsmallcompany"  maxlength="9"  name="bean.trainsmallcompany"  value="${bean.trainsmallcompany}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">留学生数<-->境外：</th>
          <td>
           <input type="text" class="inputText" id="oversea"  maxlength="9"  name="bean.oversea"  value="${bean.oversea}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">留学生数<-->国外：</th>
          <td>
           <input type="text" class="inputText" id="abroad"  maxlength="9"  name="bean.abroad"  value="${bean.abroad}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">预科生、进修生、成人脱产班学生数合计：</th>
          <td>
           <input type="text" class="inputText" id="adultstudent"  maxlength="9"  name="bean.adultstudent"  value="${bean.adultstudent}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">夜大（业余）学生数：</th>
          <td>
           <input type="text" class="inputText" id="eveninguniversitystudent"  maxlength="9"  name="bean.eveninguniversitystudent"  value="${bean.eveninguniversitystudent}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">函授生数：</th>
          <td>
           <input type="text" class="inputText" id="correspondencestudent"  maxlength="9"  name="bean.correspondencestudent"  value="${bean.correspondencestudent}"  />
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
