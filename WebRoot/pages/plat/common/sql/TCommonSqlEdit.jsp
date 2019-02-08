<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-11-28 22:24:28
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/plat/frame/header.jsp" %>
<script type="text/javascript" src="${ctx}/scripts/plugins/edit_area/edit_area_full.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/common/tCommonSql";
			if('select' === opCode){
				baseUrl += "!listTree.action";
				var args = popUpModal(baseUrl,'',320,640);
					if(args){
						$("#ptid").val(args.TID);
						$("#pname").val(args.NAME);
					}
			}else if('save' === opCode){
				$("#scripts").val(editAreaLoader.getValue('scripts'));
				$("#opForm").submit();
			}else if('delete' === opCode){
				
			}else if('clear' === opCode){
						$("#ptid").val('');
						$("#pname").val('');
						alert($("#test_select").html());
			}else if('reload' === opCode){
				baseUrl += "!reload.action?v="+Math.random();
				var datas = {};
				datas['bean.tid'] = $("#tid").val();
				$.post(baseUrl,datas,function(data){
					if($.trim(data) === '1'){
						alert('加载模板成功');
					}else{
						alert('加载模板失败');
					}
				});
			}
		}
//-->

	$(document).ready(function(){
		editAreaLoader.init({
			id: "scripts"	// id of the textarea to transform		
			,start_highlight: true	// if start with highlight
			,allow_resize: "both"
			,allow_toggle: false
			,word_wrap: true
			,toolbar: "fullscreen,|,test_select,search, |, undo, redo, highlight, reset_highlight, |"
			,plugins: "test"
			,language: "zh"
			,syntax: "sql"	
		});
	
	});

</script>
<body>
<s:form action="tCommonSql!save" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
<s:token></s:token>
<s:hidden name="bean.tid" id="tid"></s:hidden>
<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
<div class="tabBlock" id="tabBlock" >
  <div class="editBlock">
    <table>
	  <tr>
        <td colspan="2" class="subtitle" >必填信息</td>
      </tr>
      
       <tbody>
        <tr>
       	   <th width="120">所属目录：</th>
           <td>
           <s:hidden name="bean.ptid" id="ptid"></s:hidden>
           <input name="pname" id="pname" value="${parent.name }" readonly="readonly" class="inputText">
           <input type="button" class="inputButton" value=" 选 择 " onclick="opreate('','select')" name="" id="">
           <input type="button" class="inputButton" value=" 清 空 " onclick="opreate('','clear')" name="" id="">
           </td>
        </tr>
       <tr>
       	   <th width="120"><span class="warning">*</span>SQL名称：</th>
           <td>
           	<c:choose>
           		<c:when test="${not empty bean.tid}"><s:textfield readonly="true" name="bean.name" cssClass="inputText" id="name"/></c:when>
           		<c:otherwise><s:textfield  name="bean.name" cssClass="inputText" id="name"/><span><a class="notice"> 为保证名称唯一，保存后将不允许再修改名称!</a></span> </c:otherwise>
           	</c:choose>
           </td>
        </tr>
       <tr>
       	   <th width="120">SQL引用类型：</th>
           <td>
           <select name="bean.rtype" id="rtype" style="width: 135px;">
          	<option value="">--请选择--</option>
          	<x:cache subject="SQLREF"  option="true" selected="${bean.rtype}"/>
          	</select>
            <em  class="valid" title="SQL引用是必须录入项。" lang="*"></em>
           </td>
        </tr>
         <tr>
       	   <th width="120">结果返回类型：</th>
           <td>
           <select name="bean.result" id="result" style="width: 135px;">
          	<option value="">--请选择--</option>
          	<x:cache subject="SQLRESULT"  option="true" selected="${bean.result}"/>
          	</select>
            <em  class="valid" title="结果返回类型是必须录入项。" lang="*"></em>
           </td>
         </tr>
        
       <tr>
       	   <th width="120">SQL类型：</th>
           <td>
            <select name="bean.type" id="type" style="width: 135px;">
          	<option value="">--请选择--</option>
          	<x:cache subject="SQLTYPE"  option="true" selected="${bean.type}"/>
          	</select>
            <em  class="valid" title="SQL类型是必须录入项。" lang="*"></em>
          </td>
        </tr>
         <tr>
          <th width="120">结果返回完整类名：</th>
          <td>
          <s:textfield name="bean.cpath" cssClass="inputText" cssStyle="width:380px; " id="cpath"></s:textfield>
           </td>
        </tr>
         <tr>
          <th width="120">模板描述：</th>
          <td>
          <s:textfield name="bean.des" cssClass="inputText" cssStyle="width:380px;" id="des"></s:textfield>
           </td>
        </tr>
       <tr>
       	  <th width="120">SQL脚本内容：</th>
       	   <td>
          <s:textarea name="bean.scripts" cssClass="" cssStyle="width:100%; height:550px;font-family:Verdana, Arial, Helvetica, sans-serif,'微软雅黑';font-size: 12px;" id="scripts"></s:textarea>
           </td>
        </tr>
       </tbody>
      <tr>
        <td colspan="2" class="toolbar">
        <c:if test="${not empty bean.tid}">
        <input type="button" class="inputButton" onclick="opreate('','reload');" value=" 加 载 " />
        </c:if>
        <input type="button" class="inputButton" onclick="opreate('','save');" value=" 确 定 " />
         <input type="button"  class="inputButton" value=" 返 回 " id="returnButton"/>
          &nbsp;&nbsp;</td>
      </tr>
    </table>
      </div>
</div>
</s:form>
</body>
<%@include file="/pages/plat/frame/footer.jsp" %>
