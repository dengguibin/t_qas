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
<div class="title"><span>当前位置：</span><x:menu menuId="${param.menuId}"/></div>
<div class="dataGrid">	
<form action="${ctx}/data/base/course/queryList.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.id" id="id" />
	<div class="clear tool-bar">
		<div class="filter">
 		<table>
            <tbody>
             <tr>
                <th>课程名称：</th>
                <td><s:textfield name="bean.coursename" cssClass="inputText"></s:textfield></td>
                <td>
                <th>课程类型选择：</th>
                <td>
                 <select name="bean.coursetype" class="select2">
                 	<option value=''>--请选择--</option>
				    	<x:cache subject="10027" option="true" selected="${bean.coursetype }"></x:cache>
				   </select>
                </td>
                <%-- <th>输入创新创业教育专门课程等级：</th>
                 <td><s:textfield name="bean.innovation" cssClass="inputText"></s:textfield></td>
                </td> --%>
                <%-- <th>EQ选择：</th>
                <td>
                 <select  id="select9" name="select9" style="width:160px;">
                 	<option value="">--请选择--</option>
                 	<!--调用字典的效果-->
				   	 <x:cache subject="ORGS" option="true" selected="${param.select9 }"></x:cache>
				   </select>
                </td> --%>
                
                <!-- <th>时间选择：</th>
                <td>
                	<input class="inputDate" onClick="new WdatePicker()">
                </td> -->
                <td>
                <input name="button" onclick="opreate('','query');" type="button" class="inputButton" value=" 查 询 " />
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
	        <ul class="toolbar">
	        	<c:if test="${qx.add}"><li class="click add"  onclick="opreate('','add');">添加</li></c:if>
	        	<c:if test="${qx.delete}"><li  class="click remove"  onclick="opreate('','remove');">删除</li></c:if>
	        </ul>
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
							<td width="50px">
								<input name="" type="checkbox" value="" checkSelector="Selector" />
							</td>
							<td width="50px">序号</td>
							<!--  <td>序号</td> -->
							<td width="120px">课程代码</td>
							<td width="170px">课程名称</td>
							<td width="120px">课程类型</td>
				              <!--     <td>课程属性</td> -->
							<!-- <td width="120px">是否专业核心课程</td> -->
							<!-- <td width="120px">是否校企合作开发课程</td> -->
							<!-- <td width="120px">精品课程</td> -->
							<td width="120px">学分</td>
							<td width="200px">创新创业教育专门课程等级</td>
							<td width="120px">是否资格证书课程</td>
							<!-- <td width="200px">是否学院课程改革立项项目</td> -->
							<!-- <td width="200px">状态</td> -->
							<!-- <td>创建人</td>
				                <td>创建时间</td>
				                <td>修改人</td>
				                <td>修改时间</td> -->
							<!-- <td width="200px">租户</td> -->
							<%--  <td>入库时间（接口传输，导入）</td>--%>
							<c:if test="${qx.update or qx.delete }">
								<td width="130px">操作</td>
							</c:if>
						</tr>
					</thead>
				<!--</table>
			</div>
			<div class="table-box-td">
				<table class="list_table">-->
					<tbody class="tableHover">
						
						<c:forEach items="${datas}" var="item" varStatus="stat">
							<tr>
								<td  width="50PX"><input name="test" type="checkbox" class="chk" value="${item.ID }" checkNode="Selector" /></td>
								<td width="50PX">${stat.count }</td>
								<%-- <td>${item.ID}</td> --%>
								<td width="120px">${item.COURSECODE}</td>
								<td width="170px">${item.COURSENAME}</td>
								<%-- <td>${item.COURSETYPE}</td> --%>
								<%--<c:if test="${item.COURSETYPE=='1'}">
									<td width="119px">A类</td>
								</c:if>
								<c:if test="${item.COURSETYPE=='2'}">
									<td width="119px">B类</td>
								</c:if>
								<c:if test="${item.COURSETYPE=='3'}">
									<td width="119px">C类</td>
								</c:if>
								<c:if test="${empty item.COURSETYPE}">
								</c:if>
									--%><td width="120px">${item.COURSETYPE}</td>
				                 <%--   	<td>${item.COURSEPROPERTY}</td> --%>
								<%-- <td>${item.ISIMPORTANT}</td> --%>
								<%-- <td>${item.ISCOOPRATE}</td> --%>
								<%-- <td>${item.PERFECT}</td> --%>
								<td width="120px">${item.SCORE}</td>
								<td width="200px">${item.INNOVATION}</td>
								<td width="120px">${item.ISQUALIFICATIONCERTCOURSE}</td>
								<%-- <td>${item.ISCOLLEGEREFORMPROJ}</td> --%>
								<%-- <td>${item.STATUS}</td> --%>
								<%--  	<td>${item.CREATEDBY}</td>
				                   	<td>${item.CREATEDTIME}</td>
				                   	<td>${item.UPDATEDBY}</td>
				                   	<td>${item.UPDATEDTIME}</td> --%>
								<%-- <td>${item.TENANTID}</td> --%>
								<%-- 	<td>${item.STORAGETIME}</td> --%>
								<c:if test="${qx.update or qx.delete  or qx.view}">
									<td style='width:130px;'>
										<c:if test="${qx.view}">
											<a href="javascript:void(0);" class="tablelink" title="查 看" onclick="opreate('${item.ID }','queryInfo');">查看</a>
										</c:if>
										<c:if test="${qx.update}">
											<a href="javascript:void(0);" class="tablelink" title="修 改" onclick="opreate('${item.ID }','update');">修改</a>
										</c:if>
										<c:if test="${qx.delete}">
											<a href="javascript:void(0);" class="tablelink" title="删 除" onclick="opreate('${item.ID }','remove');">删除</a>
										</c:if>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
	        </div>
        </div>
        
        <%@include file="/pages/t_qas/layout/page.jsp" %>
</form>
</div><!-- dataGrid end -->
<script>
	
</script>

</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>

