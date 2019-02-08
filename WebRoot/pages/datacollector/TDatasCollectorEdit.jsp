<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2015-7-2 15:51:46
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<body>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
  <div class="editBlock">	
		<form id="opForm" name="opForm" onsubmit="return true;" enctype="multipart/form-data" action="${ctx}/collector/save.action" method="post">
			<s:hidden name="menuId" id="menuId"/>
			<!-- 令牌环，防止重复提交 -->
			<s:token></s:token>
 <iframe id="downloadFrame" style="display: none;"></iframe>				
		<div class="formtitle"><span>基本信息填写</span></div>	
		 <input type="hidden"    name="bean.tid"  value="${bean.tid}" />	
		 <input type="hidden"    name="bean.source"  value="${bean.source}" />	
		<table>
		  <tr>
        <td colspan="2" class="subtitle" >填写信息</td>
     	 </tr>
       <tbody>
     
       <tr>
       	   <th width="120">配置名称：<span class="warning">*</span></th>
           <td><input type="text" class="inputText"  maxlength="100"  id="name" name="bean.name"  value="${bean.name}"  datatype="*" nullmsg="请填写配置名称"/></td>
        </tr>
       <tr>
          <th width="120">配置参数：</th>
          <td>
                <textarea id="params"  maxlength="1000" name="bean.params" class="textinput2"   >${bean.params}</textarea>
           </td>
        </tr>
<%--      
       <tr>
       	   <th width="120">配置类型[扩展使用]：</th>
           <td><input type="text" class="inputText"  maxlength="32"  id="type" name="bean.type"  value="${bean.type}"  /></td>
        </tr>
     

       <tr>
          <th width="120">设计附件源：</th>
          <td>
                <textarea id="source"  maxlength="8388607.5" name="bean.source" class="textinput2"   >${bean.source}</textarea>
           </td>
        </tr>      --%>
            <tr>
          <th width="120">附件：</th>
          <td colspan="3">
               		<c:if test="${not empty bean.source }">
               				<table id="adFileListTable" bordercolor="#FFFFFF">
							<tr id="adFile_${item.FILEID}">
								<td>
								<a  href="javascript:void(0)"  class="tablelink"  onclick="downloadFile('${bean.tid}')">${bean.name}.ktr</a>&nbsp;&nbsp;
									<br/>
								</td>
							</tr>
							</table>
               		</c:if>
							<table id="itemtb" bordercolor="#FFFFFF">
								<tr>
									<td><span id="scan_file_0"><s:file name="doc"
												cssClass="inputText" theme="simple" id="file_0"
												title="文件后缀必须以以下结尾：ktr"
												onchange="checkFileSize(this.value,this.id)" /></span></td>
								</tr>
							</table> 
           </td>
        </tr>
       <tr>
          <th width="120">配置描述：<span class="warning">*</span></th>
          <td>
                <textarea id="remark" nullmsg="请填写配置描述"  maxlength="1000" name="bean.remark" class="textinput2"   >${bean.remark}</textarea>
           </td>
        </tr>
     
       <tr>
          <th width="120">备注：</th>
          <td>
                <textarea id="marks"  maxlength="1000" name="bean.marks" class="textinput2"   >${bean.marks}</textarea>
           </td>
        </tr>
     
       <tr>
       	   <th width="120">是否有效：<span class="warning">*</span></th>
          	<td>
          	 	<select  class="select2" name="bean.valid" style="width:160px;" nullmsg="请填写是否有效" > 
                 	<option value="">--请选择--</option>
                 	<!--调用字典的效果-->
				   	 <x:cache subject="VALID" option="true" selected="${bean.valid}"></x:cache>
				   </select>
           </td>
        </tr>
     
<%--        <tr>
       	   <th width="120">最后一次运行时间：</th>
          <td>
             <input type="text" class="inputDate" onclick="new WdatePicker()" id="rdate" name="bean.rdate"  value="${rdate}   " />
          </td>
        </tr>
     
       <tr>
       	   <th width="120">运行状态结果：</th>
          <td>
           <input type="text" class="inputText" id="state"  maxlength="9"  name="bean.state"  value="${bean.state}"  />
           </td>
        </tr>
     
       <tr>
       	   <th width="120">运行耗时秒为单位：</th>
          <td>
           <input type="text" class="inputText" id="costs"  maxlength="9"  name="bean.costs"  value="${bean.costs}"  />
           </td>
        </tr> 
     
       <tr>
          <th width="120">运行日志：</th>
          <td>
                <textarea id="logs" readonly="readonly" maxlength="32767" name="bean.logs" class="textinput2"   >${bean.logs}</textarea>
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
  <script type="text/javascript">
	$(function(){
		  $('#select9').select2({
		  	 /* tags: "true" 如果要输入*/
		  });
		})
  	var fileIdSerialNo = 1; // 页面上传附件表单ID的后缀系列号
	/* 获取页面上传附件表单ID的后缀系列号 */
	function getFileIdSerialNo() {
		return fileIdSerialNo++;
	}

	function downloadFile(id) {
		var baseUrl = "${ctx}/collector/download.action?bean.tid=" + id;
		$("#downloadFrame").attr("src", baseUrl);
	}

	function checkLast(str) {
		var flag = false;
		var ext = str.split('.')[str.split('.').length - 1];
		if (ext == 'ktr') {
			flag = true;
		}
		return flag;
	}
	function checkFileSize(value, id) {
		if (!checkLast(value.toLowerCase())) {
			$.dialog.alert("上传文件格式错误！");
			$("#scan_" + id)
					.html(
							'<s:file name="doc" theme="simple" cssClass="inputText"  id="'
									+ id
									+ '" title="文件后缀必须以以下结尾：doc,docx,pdf,xls,xlsx,xml,pptx,ppt" onchange="checkFileSize(this.value,this.id);"></s:file>');
		}
	}
  </script>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
