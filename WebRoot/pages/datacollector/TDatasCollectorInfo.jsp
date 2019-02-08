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
<form action="" id="opForm">
<s:hidden name="menuId" id="menuId"/>
	<div class="formtitle"><span>基本信息查看</span></div>
		<table>
			<tr>
				<td colspan="2" class="subtitle">信息查看 </td>
			</tr>
       <tbody>
       <tr>
    	   <th width="120">唯一标识：</th>
           <td>${bean.tid}</td>
        </tr>
       <tr>
    	   <th width="120">配置名称：</th>
           <td>${bean.name}</td>
        </tr>
       <tr>
    	   <th width="120">配置参数：</th>
           <td>${bean.params}</td>
        </tr>
       <tr>
    	   <th width="120">附件：</th>
           <td>	<a  href="javascript:void(0)"  class="tablelink"  onclick="downloadFile('${bean.tid}')">${bean.name}.ktr</a>&nbsp;&nbsp;</td>
        </tr>
       <tr>
    	   <th width="120">配置描述：</th>
           <td>${bean.remark}</td>
        </tr>
       <tr>
    	   <th width="120">备注：</th>
           <td>${bean.marks}</td>
        </tr>
       <tr>
    	   <th width="120">是否有效：</th>
           <td> <x:cache subject="VALID" option="false" key="${bean.valid}"></x:cache></td>
        </tr>
 <%--       <tr>
       	   <th width="120">最后一次运行时间：</th>
           <td ><fmt:formatDate value="${bean.rdate}" pattern="yyyy-MM-dd"/></td>
        </tr>
       <tr>
    	   <th width="120">运行状态结果：</th>
           <td>${bean.state}</td>
        </tr>
       <tr>
    	   <th width="120">运行耗时秒为单位：</th>
           <td>${bean.costs}</td>
        </tr> --%>
       <tr>
    	   <th width="120">运行日志：</th>
           <td>
            <textarea  class="textinput2" readonly="readonly" > ${bean.logs}</textarea>
           
           </td>
        </tr>

	  			 <tr>
					<td colspan="2" class="toolbar">
						<input type="button" id="returnButton" class="cancel" value=" 返 回 " /></td>
				</tr>
       </tbody>
    </table>
  </form>
   <iframe id="downloadFrame" style="display: none;"></iframe>	
 </div>   <!--editBlock END-->
 <script type="text/javascript">
	function downloadFile(id) {
		var baseUrl = "${ctx}/collector/download.action?bean.tid=" + id;
		$("#downloadFrame").attr("src", baseUrl);
	}
 </script>
</body> 
<%@include file="/pages/t_qas/layout/footer.jsp" %>
