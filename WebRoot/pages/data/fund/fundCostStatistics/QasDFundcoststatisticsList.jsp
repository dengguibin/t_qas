<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 12:16:28
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/data/fund/fundCostStatistics/";
			//加上随机请求参数，防止浏览器缓存显示数据不正确
			var query = "?bean.id="+args+"&v="+Math.random();
			if('update' === opCode){
				baseUrl += "toEdit.action";
				$("#id").val(args);
				$("#opForm").attr("action",baseUrl).submit();
			}else if('remove' === opCode){
				var ids = [];
				//单条删除操作
				if(args && $.trim(args) != ''){
					ids.push(args);
				}else{
					//选择批量删除操作
					if($(".chk:checked").size() > 0){
						$(".chk:checked").each(function(){
							ids.push($(this).val());
						});
					}
				}
				if( $.trim(ids) != ''){
					$.dialog.confirm('你确定要删除选中的数据吗?', function(){
					    query = "?bean.id="+ids.join(',');
						baseUrl += "remove.action"+query;
						$.getJSON(baseUrl,{},function(data){
							if(data && data.status == '1'){
								opreate('','query');
							}else if(data && data.status == '2'){
							     alert(data.message);
							}else{
								alert('删除数据失败!');
							}
						});
					}, function(){
					    $.dialog.tips('执行取消操作');
					});
				}else{
					$.dialog.alert('请选中需要删除的行数据!');
				}
			}else if('add' === opCode){
				baseUrl += "toEdit.action";
				$("#id").val(args);
				$("#opForm").attr("action",baseUrl).submit();
			}else if('queryInfo' === opCode){
				baseUrl += "queryInfo.action";
				$("#id").val(args);
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}
		}
		
	//下拉输入的效果	
	$(function(){
	  $('#select9').select2({
	  	 /* tags: "true" 如果要输入*/
	  });
	})
//-->
</script>
<body>
<!-- 权限查询 -->
 <x:qx var="qx" menuId="${param.menuId}"></x:qx>
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<div class="dataGrid">	
<form action="${ctx}/data/fund/fundCostStatistics/queryList.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.id" id="id" />
		<div class="filter">
 		<table>
            <tbody >
             <tr>
                <%-- <th>学校支出范围：</th>
				<td>
					<select class="select2" name="bean.schoolexpenditureScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.schoolexpenditureScope}">
								<option value='${bean.schoolexpenditureScope}'  selected="selected">${bean.schoolexpenditureScope}</option>
							</c:if>
							<c:if test="${bean.schoolexpenditureScope!='0-50000'}">
								 <option value="0-50000">0-50000</option>
							</c:if>
							<c:if test="${bean.schoolexpenditureScope!='50000-80000'}">
								 <option value="50000-80000">50000-80000</option>
							</c:if>
							<c:if test="${bean.schoolexpenditureScope!='80000-100000'}">
								 <option value="80000-100000">80000-100000</option>
							</c:if>
							<c:if test="${bean.schoolexpenditureScope!='100000-1500000'}">
								 <option value="100000-1500000">100000-1500000</option>
							</c:if>
							<c:if test="${bean.schoolexpenditureScope!='1500000以上'}">
								 <option value="1500000以上">1500000以上</option>
							</c:if>
					</select>
				</td>	 --%>
				
				<th>租户：</th>
                <td><s:textfield name="bean.tenantid" cssClass="inputText"></s:textfield></td>
                
                <!--<th>EQ选择：</th>
                <td>
                 <select  id="select9" name="select9" style="width:160px;">
                 	<option value="">--请选择--</option>
                 	调用字典的效果
				   	 <x:cache subject="ORGS" option="true" selected="${param.select9 }"></x:cache>
				   </select>
                </td>
                -->
                <th>修改时间：</th>
                <td>
                	<!--<input class="inputDate" onClick="new WdatePicker()">
                	-->
                	<s:textfield name="bean.updatedtime" cssClass="inputDate" onClick="new WdatePicker()"></s:textfield>
                </td>
                <td>
                <input name="button" onclick="opreate('','query');" type="button" class="inputButton" value=" 查 询 " />
                </td>
              </tr>
            </tbody>
          </table>
		</div><!--filter end-->
		
		<div class="tools">
			<ul class="toolbar">
			<c:if test="${qx.add }"><li class="click add"  onclick="opreate('','add');">添加</li></c:if>
	        <c:if test="${qx.delete }"><li  class="click remove"  onclick="opreate('','remove');">删除</li></c:if>
	        </ul>
		</div><!--tools end-->
		
		
		  <table id="dataTable" class="list_table">
            <thead>
              <tr>
              	<th><input name="" type="checkbox" value="" checkSelector="Selector"/></th>
                <th width="50">序号</th>
               <!--  <th>序号</th> -->
                <th>学校总支出（万元）</th>
                <th>其中<-->征地（万元）</th>
                <th>其中<-->基础设施建设（万元）</th>
                <th>其中<-->设备采购（万元）<-->合计</th>
                <th>其中<-->日常教学经费（万元）<-->合计</th>
             <!--<%--   <th>其中<-->日常教学经费（万元）<-->实(验)训耗材</th>
                <th>其中<-->日常教学经费（万元）<-->实习专项</th>
                <th>其中<-->日常教学经费（万元）<-->聘请兼职教师经费</th>
                <th>其中<-->日常教学经费（万元）<-->体育维持费</th>
                <th>其中<-->日常教学经费（万元）<-->其他</th>--%>
                -->
                <th>其中<-->教学改革及研究<-->合计（万元）</th> 
                <th>其中<-->师资建设<-->合计（万元）</th>
             <%--   <th>其中<-->师资建设<-->教师培训专项经费</th>--%>
                <th>其中<-->图书购置费（万元）</th>
                <th>其中<-->其他支出总额（万元）</th>
               <!--  <th>还贷金额（万元）</th> -->
                <th>状态</th>
               <!--  <th>创建人</th>
                <th>创建时间</th>
                <th>修改人</th> -->
                <th>修改时间</th>
                <th>租户</th>
                <!-- <th>入库时间（接口传输，导入）</th> -->
                 <c:if test="${qx.update or qx.delete }">
                  <th>操作</th>
                  </c:if>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	             <tr align="center">
	           		<td><input name="test" type="checkbox" class="chk" value="${item.ID }"  checkNode="Selector" /></td>
	                <td>&nbsp;${stat.count }</td>
                   	<%-- <td>&nbsp;${item.ID}</td> --%>
                   	<td>&nbsp;${item.SCHOOLEXPENDITURE}</td>
                   	<td>&nbsp;${item.LANDREQUISITION}</td>
                   	<td>&nbsp;${item.INFRASTRUCTURECONSTRUCTION}</td>
                   	<td>&nbsp;${item.EQUIPMENTPROCUREMENTTOTAL}</td>
                   	<td>&nbsp;${item.TEACHINGFUNDTOTAL}</td>
                 <%--   	<td>&nbsp;${item.TRAININGEQUIPMENT}</td>
                   	<td>&nbsp;${item.PACTICEFEE}</td>
                   	<td>&nbsp;${item.HIRETEACHERFEE}</td>
                   	<td>&nbsp;${item.SPORTSFEE}</td>
                   	<td>&nbsp;${item.OTHERSFEE}</td>
                   	--%>
                   	<td>&nbsp;${item.TEACHINGRESEARCHTOTAL}</td> 
                   	<td>&nbsp;${item.TEACHERCONSTRUCTIONTOTAL}</td>
                   <%-- 	<td>&nbsp;${item.TEACHERTRAININGFEE}</td> --%>
                   	<td>&nbsp;${item.BOOKACQUISITIONFEE}</td>
                   	<td>&nbsp;${item.OTHERS}</td>
                   	<%-- <td>&nbsp;${item.AMOUNTOFREPAYMENT}</td> --%>
                   	<td>&nbsp;${item.STATUS}</td>
                  <%--  	<td>&nbsp;${item.CREATEDBY}</td>
                   	<td>&nbsp;<fmt:formatDate value="${item.CREATEDTIME}" pattern="yyyy-MM-dd"/></td>
                   	<td>&nbsp;${item.UPDATEDBY}</td> --%>
                   	<td>&nbsp;<fmt:formatDate value="${item.UPDATEDTIME}" pattern="yyyy-MM-dd"/> </td>
                   	<td>&nbsp;${item.TENANTID}</td>
                   <%-- 	<td>&nbsp;${item.STORAGETIME}</td> --%>
                 	 <c:if test="${qx.update or qx.delete  or qx.view}">
                 	 <td style='width:120px;'>&nbsp;
                 	 	<c:if test="${qx.view}"><a href="javascript:void(0);" class="tablelink" title="查 看" onclick="opreate('${item.ID }','queryInfo');">查看</a></c:if>
                 	 	<c:if test="${qx.update}"><a href="javascript:void(0);" class="tablelink" title="修 改" onclick="opreate('${item.ID }','update');">修改</a></c:if>
                 	 	<c:if test="${qx.delete}"><a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.ID }','remove');">删除</a></c:if>
                 	 </td>
                 	 </c:if>
	              </tr>
            </c:forEach>
            </tbody>
          </table>
           <%@include file="/pages/t_qas/layout/page.jsp" %>
</form>
</div><!-- dataGrid end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>
