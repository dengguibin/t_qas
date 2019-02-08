<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-30 10:54:53
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx}/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
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
						$("#organizationid").val('');
						$("#pbmmc").val('');
			}
		}
 		window.initNode = function(args){
			$("#organizationid").val(args.BMID);
			$("#pbmmc").val(args.BMMC);
		};	
//-->
</script>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;"
			action="${ctx}/system/major/save.action" method="post">
			<s:hidden name="menuId" id="menuId"/>
			<s:hidden name="bean.id" id="id" />
			<s:hidden name="bean.createdby" id="createdby" />
			<s:hidden name="bean.createdtime" id="createdtime" />
			<!-- 令牌环，防止重复提交 -->
			<s:token></s:token>
			
		<div class="formtitle"><span>表头信息控制</span></div>	
		<table>
		  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
     	 </tr>
       <tbody>
       <%-- <tr>
       	   <th width="120">所属系部编号：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="organizationid" name="bean.organizationid"  value="${bean.organizationid}"  /></td>
        </tr> --%>
       <tr>
       	   <th width="120"><span class="warning">*</span>专业代码：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="majorcode" name="bean.majorcode"  value="${bean.majorcode}"  /></td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>专业名称：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="majorname" name="bean.majorname"  value="${bean.majorname}"  /></td>
        </tr>
        <tr>
       	   <th width="120"><span class="warning">*</span>所属学院：</th>
       	   <td>
          	 <s:hidden name="bean.organizationid" id="organizationid"></s:hidden>
           <input name="pbmmc" id="pbmmc" value="${BMMC}" readonly="readonly" class="inputText">
            <em  class="valid" title="必须选择专业所在学院。" lang="*"></em>
           <input type="button" class="ibtn" value=" 选 择 " onclick="opreate('','select')" name="" id="">
           <input type="button" class="ibtn" value=" 清 空 " onclick="opreate('','clear')" name="" id="">
           </td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>专业文理类别：</th>
           <td>
				<select  name="bean.divisiontype" class="select2" datatype="*" nullmsg="专业文理类别必须填写">
					 <option value="">--所有--</option>
					 <x:cache subject="10020"  option="true" selected="${bean.divisiontype}"/>
				</select> 	
		   </td>
        </tr>
       <tr>
       	   <th width="120">是否招生：</th>
           <td>
           <x:cache subject="OPTION01" var="list" scope="requestScope"/>
           <s:radio list="#request.list" name="bean.isenroll" id="isenroll" listKey="subcode" listValue="cname" ></s:radio>
           	 <em  class="valid" title="是否招生是必须录入项" lang="*" for="sfyx1"></em>
           </td>
        </tr>
       <tr>
       	   <th width="120">新增年月：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="enrolldate" name="bean.enrolldate"  value="${bean.enrolldate}"  /></td>
        </tr>
       <tr>
       	   <th width="120">停招年月：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="notenrolldate" name="bean.notenrolldate"  value="${bean.notenrolldate}"  /></td>
        </tr>
       <tr>
       	   <th width="120">撤销年月：</th>
           <td><input type="text" class="inputText"  maxlength="50"  id="revokemajorcount" name="bean.revokemajorcount"  value="${bean.revokemajorcount}"  /></td>
        </tr>
       <tr>
       	   <th width="120">状态：</th>
           <td>
           <x:cache subject="OPTION01" var="list" scope="requestScope"/>
           <s:radio list="#request.list" name="bean.status" id="status" listKey="subcode" listValue="cname" ></s:radio>
           	 <em  class="valid" title="是否有效是必须录入项" lang="*" for="sfyx1"></em>
           </td>
        </tr>
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
