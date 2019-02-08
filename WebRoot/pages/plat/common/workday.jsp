<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%

%>
<%@include file="/pages/plat/frame/header.jsp" %>
		<script type="text/javascript">
	<!--	
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/plat/common/tCommonWorkday";
			if('save' === opCode){
				var arr = new Array(12);
				for(var i = 0 ; i < arr.length ; i++){
					arr[i] = 0;
				}
				$(".item").each(function(){
					if($(this).attr("checked")){
						var  day = $(this).attr("day");
						var  month = $(this).attr("month");
						arr[month] |=  ( 1 << (day - 1));
					}
				});
				$("#lists").val(arr);
				baseUrl += '!save.action';
				$("#opForm").attr("action",baseUrl);
				$("#opForm").submit();
			}else if('query' === opCode){
				$("#tid").val('');
				$("#opForm").submit();
			}
		}
		
		function selectItem(month,col){
			$(".item[month='"+month+"'][col='"+col+"']").each(function(){
				this.click();
			});
		}
		

		$(document).ready(function(){
			$(".item").bind("click",function(){
				if($(this).attr("checked") == 'checked'){
					$(this).removeAttr("checked")
					$(this).removeClass("checked");
				}else{
					$(this).addClass("checked");
					$(this).attr("checked","true")
					
				}
				
				
			});
			
				var lists = $("#lists").val();
				if( lists != ''){
					var arr = lists.split(",");
					$(".item").each(function(){
						var  day = $(this).attr("day");
						var  month = $(this).attr("month");
						var rend = arr[month]& ( 1 << (day - 1));
						if(rend > 0 ){
							this.click();
						}
					});
				}
		})
//-->
</script>
		<style type="text/css">
			td.checked{
				//background-color: red;
				background: url("${ctx}/skins/default/images/sign_mob_have.gif") no-repeat;
				background-position: center;
			}
			td.item ,th{
				cursor :hand ;
			}
			.tt{
				width: 100%;
			}
			table.tt tr td{
				vertical-align: top;
			}
		</style>
  <body>
  <%
   Calendar  date = Calendar.getInstance();
   	int year =  date.get(Calendar.YEAR);
   %>
   <x:qx var="qx" menuId="${menuId }"></x:qx>
  <div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
   <div class="tabBlock"> 
  <c:if test="${qx.add }">
   <div class="toolbar">
      <input name="button" onclick="opreate('','save');" type="button" class="inputButton" value=" 保 存 " />
  	</div>
  </c:if>
  	
<s:form action="tCommonWorkday!select" namespace="/plat/common" method="post" 
id="opForm" name="opForm">
	<s:hidden name="bean.lists" id="lists"></s:hidden>
	<s:hidden name="bean.tid"   id="tid"></s:hidden>
	<input type="hidden" name="menuId" value="${param.menuId}" id="menuId">
	<s:token></s:token>
<div class="filter">
 		<table>
            <tbody>
              <tr>
                <th>年份：</th>
                <td>
                	<select name="bean.year" id="year" onchange="opreate('','query');" >
                	<%
                			String temp = request.getAttribute("year")+"";
                			for(int i = year - 5 ; i < year + 5 ;i++){
                				if((i+"").equals(temp)){
                					out.print("<option value=\""+i+"\" selected=\"selected\">"+i+"年</option>");
                				}else{
                					out.print("<option value=\""+i+"\">"+i+"年</option>");
                				}
                			}
                	 %>
                	</select>
               </td>
                <td>&nbsp;<input name="button" onclick="opreate('','query');" type="button" class="inputButton" value=" 查 询 " /></td>
              </tr>
            </tbody>
          </table>
		</div>
    <%
      			 
      			  SimpleDateFormat fmt = new SimpleDateFormat("yyyy年MM月");
      			   SimpleDateFormat fmt2 = new SimpleDateFormat("yyyyMMdd");
      			   if(temp != null){
      			    date.set(Calendar.YEAR,Integer.valueOf(temp));
      			   }
      			  
      			  date.set(Calendar.DAY_OF_YEAR,1);
      			  year = date.get(Calendar.YEAR);
      			  int month =  date.get(Calendar.MONTH);
      			  out.print("<table class=\"tt\">");
      			  	while( year == date.get(Calendar.YEAR)){
      			  		int tm = date.get(Calendar.MONTH);
      			  		if(tm % 4 == 0){
      			  						if(tm != 0){
      			  								out.print("</tr>");
      			  							}
      			  					 out.print("<tr>");
      			  						}
      			  					int day = date.get(Calendar.DAY_OF_MONTH);
      			  					if(day == 1){
      			  					%>
      			  					
      			  					<td>
      			  					<div class="dataGrid">
      			  					<table class="list_table">
      			  					
						      		<thead>
						      			<tr><td colspan="7" valign="middle">
						      				<a href="javascript:void(0);"><%=fmt.format(date.getTime()) %></a>
						      			</td></tr>
						                <tr>
						                <th onclick="selectItem('<%=tm %>','1');">日</th>
						                <th onclick="selectItem('<%=tm %>','2');">一</th>
						                <th onclick="selectItem('<%=tm %>','3');">二</th>
						                <th onclick="selectItem('<%=tm %>','4');">三</th>
						                <th onclick="selectItem('<%=tm %>','5');">四</th>
						                <th onclick="selectItem('<%=tm %>','6');">五</th>
						                <th onclick="selectItem('<%=tm %>','7');">六</th>
						              </tr>
						            </thead>
      			  					<%
      			  					out.print("<tbody class=\"tableHover\">");
      			  				    int hd = date.get(Calendar.DAY_OF_WEEK);
      			  				    int i = 0 ;
      			  				    out.print("<tr>");
      			  				    for(i = 0 ; i < hd - 1;i++){
      			  				    	out.print("<td>&nbsp;</td>");
      			  				    }
      			  					while(tm == date.get(Calendar.MONTH) ){
      			  						if(i % 7 == 0){
      			  							if(i != 0){
      			  								out.print("</tr>");
      			  							}
      			  							 out.print("<tr>");
      			  						}
      			  						int col = (i % 7) + 1;
      			  						int myday = date.get(Calendar.DAY_OF_MONTH);
      			  					    out.println("<td class=\"item\" col='"+col+"' month='"+tm+"' day='"+myday+"'>"+myday+"</td>");
      			  						date.add(Calendar.DAY_OF_YEAR,1);
      			  						i++;
      			  					}
      			  						while(i < 42){
      			  						if(i % 7 == 0){
      			  							if(i != 0){
      			  								out.print("</tr>");
      			  							}
      			  							 out.print("<tr>");
      			  						}
      			  					    out.println("<td >&nbsp;</td>");
      			  						//date.add(Calendar.DAY_OF_YEAR,1);
      			  						i++;
      			  						}
      			  					 out.print("</tr>");
      			  					out.print(" </tbody>");
      			  					out.print("</table>");
      			  					out.print("</div>");
      			  				out.print("</td>");
      			  			} // month end
      			  			 	}/// year end
      			  		%>
     </table>
 </s:form>
</div><!-- editBlock end -->
  </body>
<%@include file="/pages/plat/frame/footer.jsp" %>
