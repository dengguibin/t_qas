<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-3 22:10:24
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx}/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">

		var dlg;
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/auth/tRmsDeptment!listTree.action";
			if('select' === opCode){
			if(dlg && dlg.closed == false){
					dlg.show();
				}else{
				dlg =	$.dialog({
				id : 'depart',
				lock: true, 
				max: false, 
    			min: false ,
				title:'选择部门',
				width:'360px',
				height:'460px',
				content: 'url:'+baseUrl});
				}		
			}else if('delete' === opCode){
				
			}else if('clear' === opCode){
						$("#bmid").val('');
						$("#pbmmc").val('');
			}
			
		}
 		window.initNode = function(args){
			$("#bmid").val(args.BMID);
			$("#pbmmc").val(args.BMMC);
			getMajor();
		}	
		
			function getMajor(){
				var bmid = $("#bmid").val();
				$.get('${ctx}/org/auth/getMajor.action',{"majorBean.organizationid":bmid},function(result){
					var list = result.obj;
					console.log(list);
					console.log("${major.majorname }")
					var option = "<option value=''>可视所有专业</option>";
					for(var i in list){
							if(list[i].MAJORNAME == "${major.majorname }"){
								option +="<option  selected='selected' value='"+list[i].ID+" '>"+list[i].MAJORNAME+"</option>"
							}else{
								option +="<option value='"+list[i].ID+" '>"+list[i].MAJORNAME+"</option>"
							}
							
					};
					$("#d_t_m_type").empty();
					
					$("#d_t_m_type").append(option);
					//诊断方案 下拉框
					$("#d_t_m_type").select2({
						width:'resolve',
					});
				});
				
				 	var all = "";
			        $("select option").each(function() {
			            all += $(this).attr("value")+" ";
			        });
			        var sel = $("select").val();
			       /*  alert("多选列表所有的value值:"+all+"，其中被选中的是:"+sel+"。"); */
		};

</script>


<body onload="javascript:getMajor()">
<c:if test="${not empty bean.yhid }">
<c:set var="yhids" value=",${bean.yhid}," scope="request"/>
<x:query stmt="用户角色查询" var="queryRoles" paged="false"></x:query>
</c:if>
<div class="title" style="display: none;"><span>当前位置：</span><x:menu menuId="${menuId}"/></div>
<s:form action="tRmsUser!save" namespace="/plat/auth" method="post" 
id="opForm" name="opForm">
<s:token></s:token>
<s:hidden name="bean.uid" id="uid"/>
<input type="hidden" name="menuId" value="${menuId}" id="menuId">
  <div class="editBlock" style="width: 100%;margin: 0;padding: 0;">
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >基本信息</td>
      </tr>
       <tbody>
       <tr>
       	   <th width="120"><span class="warning">*</span>用户帐号：</th>
	           <td>
		           <c:choose>
			           	<c:when test="${not empty bean.yhid}"><s:textfield  name="bean.yhid" cssClass="inputText" readonly="true" id="yhid"/></c:when>
			           	<c:otherwise><s:textfield  name="bean.yhid" cssClass="inputText" id="yhid"/></c:otherwise>
		           </c:choose>
	           	   <em  class="valid" title="用户帐号是必须录入项，长度控制在4-20字符" lang="s4-20"></em>
	           </td>
       </tr>
       
       <tr>
       	   <th width="120"><span class="warning">*</span>用户密码：</th>
           <td>
           <s:password  name="bean.yhmm" cssClass="inputText" id="yhmm"/>
            <em  class="valid" title="用户密码是必须录入项，长度控制在1-20字符" lang="s1-20"></em>
           </td>
       </tr>
       
       <tr>
       	   <th width="120"><span class="warning">*</span>用户名称：</th>
           <td>
           <s:textfield  name="bean.yhmc" cssClass="inputText" id="yhmc"/>
            <em  class="valid" title="用户名称是必须录入项，长度控制在2-20字符" lang="s2-20"></em>
           </td>
       </tr>
        <c:if test="${empty bean.yhid}">
          <tr>
       	   <th width="120"><span class="warning">*</span>用户密码：</th>
           <td>
           <s:textfield  name="bean.yhmm" cssClass="inputText" id="yhmm"/>
            <em  class="valid" title="密码是必须录入项，长度控制在1-20字符" lang="s1-20"></em>
           </td>
        </tr>
        </c:if>
       <tr>
       	   <th width="120"><span class="warning">*</span>单位部门：</th>
       	   <td>
          	 <s:hidden name="bean.bmid" id="bmid"></s:hidden>
            <input name="pbmmc" id="pbmmc" value="${dept.bmmc }" readonly="readonly" class="inputText">
            <em  class="valid" title="必须选择用户所在的部门。" lang="*"></em>
           <input type="button" class="ibtn" value=" 选 择 " onclick="opreate('','select')" name="" id="">
           <input type="button" class="ibtn" value=" 清 空 " onclick="opreate('','clear')" name="" id="">
           </td>
        </tr>
         <tr>
       	   <th width="120"><span class="warning">*</span>所属专业：</th>
       	   <td>
           	<select class="select" id="d_t_m_type"  style="width: 152px;height: 34px" multiple="multiple" name="bean.zyid">
			</select>
            <em  class="valid" title="必须选择用户所在的部门。" lang="*"></em>
           </td>
        </tr>
        
      <!-- 
       <tr>
       	   <th width="120">用户简称：</th>
           <td><s:textfield  name="bean.yhjc" cssClass="inputText" id="yhjc" maxlength="10"/></td>
        </tr>
      
       <tr>
       	   <th width="120">用户称谓：</th>
           <td><s:textfield  name="bean.yhcw" cssClass="inputText" id="yhcw" maxlength="10"/></td>
        </tr>
         -->  
        <tr>
       	   <th width="120"><span class="warning">*</span>是否有效：</th>
           <td>
           <x:cache subject="OPTION01" var="list" scope="requestScope"/>
           <s:radio list="#request.list" name="bean.sfyx" id="sfyx" listKey="subcode" listValue="cname" ></s:radio>
           	 <em  class="valid" title="是否有效是必须录入项" lang="*" for="sfyx1"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>排序号：</th>
           <td>
           <s:textfield  name="bean.pxh" cssClass="inputText" id="pxh"/>
           <em  class="valid" title="排序号是必须输入项，而且为数字类型" lang="n"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120">分配角色：</th>
           <td>
           	<c:forEach var="role" items="${roles }" varStatus="stat">
           		<c:if test="${not empty queryRoles }">
           			<c:forEach var="sRole" items="${queryRoles.rows }">
           				<c:if test="${sRole.JSID eq role.roleId}">
           					<c:set value="checked" var="checked"/>
           				</c:if>
           			</c:forEach>
           		</c:if>
           		<c:if test="${role.admin ne true }">
           		<input type="checkbox" name="bean.roleIds" ${checked } value="${role.roleId }">${role.roleName }
           		</c:if>
           		<c:set value="" var="checked"/>
           	</c:forEach>
           </td>
        </tr>
       </tbody>
        <tr>
        <td colspan="2" class="subtitle" >选填信息</td>
      	</tr> 
       <tbody> 
       <tr>
       	   <th width="120">手机号码：</th>
           <td><s:textfield  name="bean.sjhm" cssClass="inputText" id="sjhm" datatype="m" ignore="ignore" errormsg="请填写正确的手机格式"/></td>
        </tr>
       <tr>
       	   <th width="120">电子邮箱：</th>
           <td><s:textfield  name="bean.dzyj" cssClass="inputText" id="dzyj" datatype="e" ignore="ignore" errormsg="请填写正确的电子邮箱格式"/></td>
        </tr>
        
          <tr>
       	   <th width="120">联系电话：</th>
           <td><s:textfield  name="bean.gzdh" cssClass="inputText" id="gzdh"  maxlength="30"/></td>
        </tr>
     
       <!-- 
       <tr>
       	   <th width="120">家庭电话：</th>
           <td><s:textfield  name="bean.jtdh" cssClass="inputText" id="jtdh"  maxlength="30"/></td>
        </tr>
        --> 
          <tr>
       	   <th width="120">个人主页：</th>
           <td><s:textfield  name="bean.grzy" cssClass="inputText" id="grzy"  maxlength="30"/></td>
        </tr>
       </tbody>
      <tr>
        <td colspan="2" class="toolbar"><input type="button" class="inputButton" onclick="$('#opForm').submit();" value=" 确 定 " />
          <input type="button"  class="cancel" value=" 返 回 " id="returnButton"/>
          &nbsp;&nbsp;</td>
      </tr>
    </table>
      </div>
</s:form>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
