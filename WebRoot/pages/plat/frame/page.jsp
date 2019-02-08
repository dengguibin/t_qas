<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%> 
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%> 
<table class="page" id="tabpages">
	<c:if test="${not empty pdata and pdata.rows gt 0}">
	<c:set var="pInfo" value="${pdata}"/> 
        <tr>
          <td id="pleft">&nbsp;</td>
          <c:if test="${pInfo.rows gt 0 }">
          <td id="pright">共${pInfo.rows }条&nbsp;第${pInfo.current + 1}/${pInfo.pages }页
          <c:if test="${pInfo.first}">
          <a href="javascript:void(0);"><img src="${ctx}/skins/common/page_first_b.gif" alt="第一页" /></a>
          <a href="javascript:void(0);"><img src="${ctx}/skins/common/page_pre_b.gif" alt="上一页"/></a>
          </c:if>
          <c:if test="${pInfo.first eq false}">
           <a href="javascript:gotoPage(0,this);"><img src="${ctx}/skins/common/page_first_a.gif" alt="第一页" /></a>
          <a href="javascript:gotoPage(${pInfo.current-1 },this);"><img src="${ctx}/skins/common/page_pre_a.gif" alt="上一页"/></a>
          </c:if>
          <c:if test="${pInfo.last}">
          <a href="javascript:void(0);"><img src="${ctx}/skins/common/page_next_b.gif" alt="下一页" /></a>
          <a href="javascript:void(0);"><img src="${ctx}/skins/common/page_last_b.gif" alt="最后一页" /></a>
          </c:if>
          <c:if test="${pInfo.last eq false}">
          <a href="javascript:gotoPage(${pInfo.current+1 },this);"><img src="${ctx}/skins/common/page_next_a.gif" alt="下一页" /></a>
          <a href="javascript:gotoPage(${pInfo.pages -1 },this);"><img src="${ctx}/skins/common/page_last_a.gif" alt="最后一页" /></a>
          </c:if>
          <c:set var="options" value="${fn:split('10,15,20,50',',')}"></c:set>
          	每页
            <select name="select3" onchange="gotoPage('${pInfo.current}',this);" id="pageSize">
             	<c:forEach items="${options}" var="option">
             		<c:choose>
             			<c:when test="${option eq pInfo.pageSize}">
             			<option value="${option }" selected="selected">${option }</option>
             			</c:when>
             			<c:otherwise><option value="${option }" >${option }</option></c:otherwise>
             		</c:choose>
             	</c:forEach>
            </select>条
            <textarea name="pagination" id="pagination" style="display: none;">${pInfo }</textarea>
            </td>
          </c:if>
        </tr>
        </c:if>
      </table>
       	<c:if test="${empty pInfo}">
         	 <script type="text/javascript">
    						 	//没有数据，自动提示没有数据项
    						 	$(function(){
    						 		var table =	$("#tabpages").prev("table");
    						 			if(table){
    						 				var cols = table.find('tbody tr').size();
    						 				if(cols == 0){
    						 				cols = table.find('thead tr th').size();
    						 				var html = "<tr><td style='text-align:center;' colspan='"+cols+"'>"+'没有查询到合适的数据'+"</td></tr>"	
    						 				table.find('tbody').append(html);
    						 				}
    						 			}
    						 	});
    						 </script>
         </c:if>
      <script type="text/javascript">
      	function gotoPage(page,obj){
      		var form = null;
      		var innerForm = false;
      		if(obj){
      			form = $(obj).parent("form");
      			var size = form.size();
      				if(size == 0){
      					form = null;
      				}else{
      					innerForm = true;
      				}
      		}
      		if(!form){
      			form = document.forms[0];
      		}
      		if(!form){
      			alert('无法找到绑定数据的表单，请检测 ！');
      			return;
      		}
      		
      		var  datas = $("#pagination").val();
      		//转换成json对象
      		var    json = JSON.parse(datas);
      			   json.current = page;
      			   json.pageSize = $("#pageSize").val();
      			   datas = JSON.stringify(json);
      		$("#pagination").val(datas); 
      		if(innerForm == false){
      			$("#pagination").prependTo($(form));
      		}
      		form.submit();
      	}
      </script>
