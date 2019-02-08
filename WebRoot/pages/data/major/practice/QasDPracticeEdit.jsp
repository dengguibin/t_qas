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
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/data/major/practice/save.action" method="post">
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
          <td>
           <input type="text" class="inputText" id="directionid"  maxlength="9"  name="bean.directionid"  value="${bean.directionid}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">应届毕业生顶岗实习<-->顶岗实习毕业生总数（人）：</th>
          <td>
           <input type="text" class="inputText" id="gradpracticenum"  maxlength="9"  name="bean.gradpracticenum"  value="${bean.gradpracticenum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">应届毕业生顶岗实习<-->企业录用顶岗实习毕业生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="recruitednum"  maxlength="9"  name="bean.recruitednum"  value="${bean.recruitednum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">应届毕业生顶岗实习<-->顶岗实习对口毕业生数（人）：</th>
          <td>
           <input type="text" class="inputText" id="samepfsnum"  maxlength="9"  name="bean.samepfsnum"  value="${bean.samepfsnum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">顶岗实习与保险情况<-->顶岗实习单位总数（个）：</th>
          <td>
           <input type="text" class="inputText" id="companynum"  maxlength="9"  name="bean.companynum"  value="${bean.companynum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">顶岗实习与保险情况<-->参加保险学生数（人）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="joinednum" name="bean.joinednum"  value="${bean.joinednum}"  /></td>
        </tr>
       <tr>
       	   <th width="120">顶岗实习与保险情况<-->保险险种名称(全称)（保险费出资方）：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="insurancename" name="bean.insurancename"  value="${bean.insurancename}"  /></td>
        </tr>
       <tr>
       	   <th width="120">顶岗实习情况<-->主要实习岗位：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="practice_posts" name="bean.practice_posts"  value="${bean.practice_posts}"  /></td>
        </tr>
       <tr>
       	   <th width="120">顶岗实习情况<-->主要实习单位：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="practice_compy" name="bean.practice_compy"  value="${bean.practice_compy}"  /></td>
        </tr>
       <tr>
       	   <th width="120">顶岗实习情况<-->实习人数（人）：</th>
          <td>
           <input type="text" class="inputText" id="practicenum"  maxlength="9"  name="bean.practicenum"  value="${bean.practicenum}"  />
           </td>
        </tr>
       <tr>
       	   <th width="120">顶岗实习情况<-->实习时间（月）：</th>
          <td>
           <input type="text" class="inputText" id="practicetime"  maxlength="9"  name="bean.practicetime"  value="${bean.practicetime}"  />
           </td>
        </tr>
       <%-- <tr>
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
        </tr>
	    --%>
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
