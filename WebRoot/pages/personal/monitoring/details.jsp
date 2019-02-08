<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 16:32:04
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<%-- <script type="text/javascript" src="${ctx}/scripts/js/common/table.js"></script> --%>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">

		function  opreate(args,opCode){
			var baseUrl = "${ctx}/data/base/course/";
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
<div class="dataGrid">

<form action="${ctx}/personal/monitoring/detailsVs.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.id" id="id" />
	<div class="clear tool-bar">
		<div class="filter">
		<%-- <div>
	  	ID:<input type="text"  value="${sessionScope.detailsId }" id="detailsId"/>
	    </div> --%>
		
 		<table>
            <tbody>
             <tr>
                <th>指标名称：</th>
                <%-- <td><s:textfield name="bean.coursename" cssClass="inputText"></s:textfield></td> --%>
                 <td>
                <input type="text"  value="${sessionScope.name }" title='${sessionScope.name }' id="zhibiaoName" disabled="disabled" size="15" style="width:110%; height: 
					25px"/></td>
                <td>
                <td>
                <th>类型对比：</th>
                <td>
                 <select  class="select2">
                 	<option value='school'>--学院对比--</option>
                 	<option value='major'>--专业对比--</option>
                 	<option value='class'>--班级对比--</option>
				    	
				   </select>
                </td>
                <th>排序：</th>
                <td>
                 <select  class="select2">
				    	<option value='score'>-数值-</option>
                 		<option value='date'>-日期-</option>
				   </select>
                </td>
                <td>
                <input name="button" onclick="opreate('','query');" type="button" class="inputButton" value=" 对 比 " />
                </td>
              </tr>
            </tbody>
          </table>
		</div><!--filter end-->
		
		<div class="tools" style="/* padding-top: 8px; */">
			<!--<ul class="toolbar">
			<c:if test="${qx.add}"><li class="click"  onclick="opreate('','add');"><span><img src="${ctx }/skins/uimaker/images/t01.png" /></span>添加</li></c:if>
	        <c:if test="${qx.delete}"><li  class="click"  onclick="opreate('','remove');"><span><img src="${ctx }/skins/uimaker/images/t03.png" /></span>删除</li></c:if>
	        </ul>-->
	        <%-- <ul class="toolbar">
	        	<c:if test="${qx.add}"><li class="click add"  onclick="opreate('','add');">添加</li></c:if>
	        	<c:if test="${qx.delete}"><li  class="click remove"  onclick="opreate('','remove');">删除</li></c:if>
	        </ul> --%>
		</div><!--tools end-->
	</div>
		<!--
			给table的外部添加了一个div，
			当没有数据的时候，显示“没有查询到合适的数据”有问题，没有选中table
			解决方法：/t_qas/WebRoot/pages/es_gov/layout/page.jsp  table的选择器修改（即注释的那一行：84）
		-->
		<div class="table-box">
			<div class="table-box-th">
				<!--必须给th,td设置宽度，超出一行隐藏，给td设置title属性可以有tooltip效果-->
				<table id="dataTable" class="list_table">
					
					<thead>
						<tr>
							 <!-- <td width="50px">
								<input name="" type="checkbox" value="" checkSelector="Selector" />
							</td> -->
							<td width="50px">序号</td>
							<!--  <td>序号</td> -->
							<td width="185px">类型代码</td>
							<td width="260px">类型名称</td>
							<td width="165px">类型数值</td>
							<td width="205px">创建日期</td>
							<td width="185px">类型操作</td>
							
							
						</tr>
					</thead>
				<!--</table>
			</div>
			<div class="table-box-td">
				<table class="list_table">-->
					<tbody class="tableHover">
						
						<c:forEach items="${datas}" var="item" varStatus="stat">
							<tr>
								<td width="50PX">${stat.count }</td>
								<%-- <td>${item.ID}</td> --%>
								<td width="120px">${item.COURSECODE}</td>
								<td width="170px">${item.COURSENAME}</td>
								<td width="120px">${item.SCORE}</td>
								<td width="200px">${item.CREATEDTIME}</td>
								
									<td style='width:130px;'>
										<a href="javascript:void(0);" class="tablelink" title="查 看" onclick="opreate('${item.ID }','queryInfo');">查看详情</a>
										<%-- <c:if test="${qx.view}">
											<a href="javascript:void(0);" class="tablelink" title="查 看" onclick="opreate('${item.ID }','queryInfo');">查看详情</a>
										</c:if> --%>
										<%-- <c:if test="${qx.update}">
											<a href="javascript:void(0);" class="tablelink" title="修 改" onclick="opreate('${item.ID }','update');">修改</a>
										</c:if>
										<c:if test="${qx.delete}">
											<a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.ID }','remove');">删除</a>
										</c:if> --%>
									</td>
									<!--以下：权限控制显示  -->
								<%-- <c:if test="${qx.update or qx.delete  or qx.view}">
									<td style='width:130px;'>
										<a href="javascript:void(0);" class="tablelink" title="查 看" onclick="opreate('${item.ID }','queryInfo');">查看详情</a>
									
										<c:if test="${qx.view}">
											<a href="javascript:void(0);" class="tablelink" title="查 看" onclick="opreate('${item.ID }','queryInfo');">查看详情</a>
										</c:if>
										<c:if test="${qx.update}">
											<a href="javascript:void(0);" class="tablelink" title="修 改" onclick="opreate('${item.ID }','update');">修改</a>
										</c:if>
										<c:if test="${qx.delete}">
											<a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.ID }','remove');">删除</a>
										</c:if>
									</td>
								</c:if> --%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
	        </div>
        </div>
        
        <%@include file="/pages/t_qas/layout/page.jsp" %>
</form>
</div><!-- dataGrid end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>

