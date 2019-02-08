<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2012-10-28 17:12:16
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<link rel="stylesheet" href="${ctx}/scripts/plugins/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery.ztree.all-3.4.min.js"></script>
<body>
<div class="dataGrid">
<form method="post" id="opForm" name="opForm"  action ="${ctx}/alarm/event/queryAllAsset.action">
	<input type="hidden" name="menuId" value="${menuId}" id="menuId">
	<input type="hidden" name="proId" value="${proId}" id="proId">
	<input type="hidden" name="columnId" value="${columnId}" id="columnId">
		
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
              	<th width="40" style="text-align: center"><input name="" type="checkbox" value="" checkSelector="Selector"/>&nbsp;</th>
              	<th width="50">序号</th>
                <th width="">名称</th>
                <th width="10%">可移动</th>
                <th width="10%">可查看</th>
                <th width="10%">可关闭</th>
              </tr>
            </thead>
            <tbody class="tableHover" >
            <c:set var="e_num" value="0" />
            <c:forEach items="${resultList}" var="item"  varStatus="stat">
            		<tr id="moduleTr">
            			<td style="text-align: center">
            			 <c:choose>
		                	<c:when test="${item.isCheck == 'true'  }">
		                		<font   title="已选择的模块不能重复选">X</font>
		                	</c:when>
		                	<c:otherwise>
            					<input style="margin-left:0" type="checkbox" class="chk" checkNode="Selector" value='${ item["ref"]}' name ="moduleId" id="moduleId"/>  
		                	</c:otherwise>
	                	</c:choose>&nbsp;
            			</td>
            			<td>&nbsp;${stat.count }</td>
	            		<td>&nbsp;<a class="link" href='${item["url"]}'>${item["title"]}</a></td>
	            		<td>
	            		${item["movable"]=="true"?"是":"否" }
	            		</td>
	            		<td>
	            		${item["show"]=="true"?"是":"否"  }
	            		</td>
	            		<td>
	            		${item["closed"]=="true"?"是":"否"  }
	            		</td>
            		</tr>
            </c:forEach>
            </tbody>
          </table>
       <%--  <%@include file="/pages/t_qas/layout/page.jsp" %> --%>
  		
 </form>
</div><!-- dataGrid end -->
  <div id="menuContent" class="editBlock" style="display:none; position: absolute;padding: 0;margin: 0;">
		<ul id="menuTree"    class="ztree" style="border: 1px solid #e2e2e2;border-radius: 4px;border-top-left-radius:0px; max-height: 240px;overflow-y:scroll;overflow-x:hidden;"></ul>
   </div>
   <script type="text/javascript">
   function checkObjs(){
	  var chackObj= $("body").find("[id='moduleId']:checked");
	  var data="";
	   chackObj.each(function(i,v){
			var rowVal = $(v).val();
			data+=","+rowVal;
			
		});
	   return data;
   }
   function getColumnId(){
	   return "${columnId}";
   }
   
</script>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
