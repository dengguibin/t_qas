<%@page import="com.upath.plat.common.page.Ipage"%>
<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%> 
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%> 
    <div class="pagin"  id="tabpages">
    	<c:if test="${not empty pdata and pdata.rows gt 0}">
    	<textarea name="pagination" id="pagination" style="display: none;">${pdata }</textarea>
    	<c:set value="${pdata }" var="pInfo"/>
    	  <%
                            	//计算页数
                	Ipage pageInfo = (Ipage)pageContext.getAttribute("pInfo");
                	if(pageInfo != null){
                		int showPages =  pageInfo.getPages();
                		int current = pageInfo.getCurrent();
                			int start = 1;
                			int end = (showPages > 5 ? 5 : showPages);
                			if(current > 3){
                				start = current - 2;
                				end = current +2;
                			}
                		
                			while(end > showPages){
            					//往后退
            						end--;
            					//不允许有 0 以下的页码
            						if(start > 1){
            							start--;
            						}
            				}
                			
                		pageContext.setAttribute("start",start);
                		pageContext.setAttribute("end",end);
                            	}
                            %>
    	
    	
    	 <div class="message">共<i class="blue">${pInfo.rows }</i>条记录，当前显示第&nbsp;<i class="blue">
    	<input type="text" nofocus="nofocus" errormsg="排序号为数字类型" class="inputTextPage" value="${pInfo.current+1}" datatype="n" ignore="ignore" onkeydown="if (event.keyCode && event.keyCode==13 ) 
{toThisPage('${pInfo.pages }',this.value,this);;return false; } " />
    	/${pInfo.pages }&nbsp;</i>页
    	</div>
      
       <c:if test="${pInfo.pages gt 1 }">
        <ul class="paginList">
        <li class="paginItem">
      		 <a  <c:if test="${pInfo.first eq false }">  href="javascript:gotoPage(${pInfo.current-1 },this);" </c:if>>
      		 <span class="pagepre"></span>
      		 </a>
        </li>
        <c:if test="${start ge 3 }">
         <li class="paginItem">
	        <a href="javascript:gotoPage(0,this);">1</a>
	     </li>
	     <li class="paginItem more"><a href="javascript:void(0);">...</a></li>
        </c:if>
        
        <c:forEach begin="${start}" end="${end}" varStatus="stat">
        <li class="paginItem ${ ((stat.index - 1)   eq pInfo.current) ? 'current' : ''  }">
        <a href="javascript:gotoPage(${stat.index - 1  },this);">${stat.index  }</a>
        </li>
         </c:forEach>
        
         <c:if test="${ end lt  pInfo.pages}">
        	<li class="paginItem more"><a href="javascript:void(0);">...</a></li>
        	<li class="paginItem"><a href="javascript:gotoPage(${pInfo.pages -1 },this);">${pInfo.pages }</a></li>
        </c:if>
        
        <li class="paginItem">
	    	 <a  <c:if test="${pInfo.last eq false }">  href="javascript:gotoPage(${pInfo.current+1 },this);" </c:if> >
	      		 <span class="pagenxt"></span>
			</a>
        </li>
        </ul>
        </c:if>
        </c:if>
    </div>
       	<c:if test="${empty pInfo}">
         	<script type="text/javascript">
				//没有数据，自动提示没有数据项
				$(function() {
					var table =	$("#tabpages").prev("table");
//					var table = $("#tabpages").prev(".table-box").find("table.list_table");
					if(table) {
						var cols = table.find('tbody tr').size();
						if(cols == 0) {
							cols = table.find('thead tr th').size();
//							cols = table.find("thead").find("td").not("[colspan]").length;
//							var width = table.find('tbody').innerWidth();
//							var html = "<tr><td style='text-align:center;width:" + width +"px' colspan='" + cols + "'>" + '没有查询到合适的数据' + "</td></tr>"
							var html = "<tr><td style='text-align:center;' colspan='" + cols + "'>" + '没有查询到合适的数据' + "</td></tr>"
							table.find('tbody').append(html);
						}
					}
				});
			</script>
        </c:if>
      <script type="text/javascript">
      	function toThisPage(total,page,obj){
      		if(!isNaN(page)){
	      		if(parseInt(page) > parseInt(total)  ){
	      			alert("只能跳转到1到"+total+"之间！");
	      		}else{
	      			gotoPage(page-1,obj);
	      		}
      		}else{
      			alert("只能填写数字！");
      		}
      	}
      
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
      			   json.pageSize = "${empty pInfo.pageSize ? 10 : pInfo.pageSize }"; //$("#pageSize").val();
      			   datas = JSON.stringify(json);
      		$("#pagination").val(datas); 
      		if(innerForm == false){
      			$("#pagination").prependTo($(form));
      		}
      		form.submit();
      	}
      </script>