<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2015-7-9 19:13:31
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">
<!--
function submitForm(){
 	query = "?bean.cron="+$("#cron").val();
 	var baseUrl = "${ctx}/quartz/scheduling/validateCron.action"+query;
	$.getJSON(baseUrl,{},function(data){
		if(data && data.status == '1'){
			$('#opForm').submit();
		}else{
			alert('cron表达式错误!');
		}
	});
	
	
}
//-->
</script>

<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/quartz/scheduling/save.action" method="post">
			<s:hidden name="menuId" id="menuId"/>
			<s:hidden name="bean.taskid" id="bean.taskid"/>
			<!-- 令牌环，防止重复提交 -->
			<s:token></s:token>
			
		<div class="formtitle"><span>调度设置信息编辑</span></div>	
		<table>
		  <tr>
        <td colspan="2" class="subtitle" >调度设置信息</td>
     	 </tr>
       <tbody>
       <tr>
          <th width="120">任务名称：<span class="warning">*</span></th>
          <td>
                <input type="text" style="width: 300px;" class="inputText" id="taskname"  maxlength="125"  name="bean.taskname"  value="${bean.taskname}" datatype="*" nullmsg="请填写任务名称"  />
           </td>
        </tr>
        <tr>
       	   <th width="120">实例方式：<span class="warning">*</span></th>
          <td>
       		 <select width="302"  class="select2" id="istmed"  name="bean.istmed" datatype="*" nullmsg="请选择实例方式" >
                 <option value=''>--请选择--</option>
			   	 <x:cache subject="ISTMED_TYPE" option="true" selected="${bean.istmed}"></x:cache>
			  </select>
           </td>
        </tr> 
       <tr>
          <th width="120">任务实现类：<span class="warning">*</span></th>
          <td>
                <input style="width: 300px;" type="text" class="inputText" id="jobclass"  maxlength="125"  name="bean.jobclass"  value="${bean.jobclass}" datatype="*" nullmsg="请填写任务实现类" />
           </td>
        </tr>
       <tr>
       	   <th width="120">是否有效：<span class="warning">*</span></th>
          <td>
          		  <select class="select2" name="bean.states" datatype="*" nullmsg="请选择是否有效" >
                 	 <option value=''>--请选择--</option>
				   	 <x:cache subject="ENABLE_STATUS" option="true" selected="${bean.states}"></x:cache>
				  </select>
           </td>
        </tr>
       <tr>
       	   <th width="120">任务类型：<span class="warning">*</span></th>
          <td>
          	
        	 <select class="select2" name="bean.type" datatype="*" nullmsg="请选择任务类型" >
                 <option value=''>--请选择--</option>
				 <x:cache subject="SCHEDULING_TYPE" option="true" selected="${bean.type}"></x:cache>
			 </select>
           </td>
        </tr>
       <tr>
       	   <th width="120">cron表达式：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="25"  id="cron" name="bean.cron"  value="${bean.cron}"  datatype="*" nullmsg="请填写cron表达式" />&nbsp;&nbsp;<a href="${ctx}/pages/plat/quartz/cronModel.jsp" target="_blank" style="text-decoration: underline;" class="tablelink">参照</a> </td>
        </tr>
       <tr>
          <th width="120">任务参数JSON数据：</th>
          <td>
                <textarea id="params"  maxlength="1000" name="bean.params" class="textinput2" >${bean.params}</textarea>
           </td>
        </tr>
       <tr>
       	   <th width="120">排序号：</th>
          <td>
           <input type="text" class="inputText" id="seq"  maxlength="9"  name="bean.seq"  value="${bean.seq}"  />
           </td>
        </tr>
       <tr>
          <th width="120">备注说明：</th>
          <td>
                <textarea id="des"  maxlength="1000" name="bean.des" class="textinput2" >${bean.des}</textarea>
           </td>
        </tr>
	   
	    <tr>
        <td colspan="2" class="toolbar">
        <input type="button" class="inputButton" onclick="submitForm()" value=" 确 定 " />
         <input type="button"  class="cancel" value=" 返 回 " id="returnButton"/>
          &nbsp;&nbsp;</td>
      	</tr>
	   
       </tbody>
    </table>
         </form>
  </div><!--editblock end-->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
