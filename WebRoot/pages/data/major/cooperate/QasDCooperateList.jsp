<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-23 16:09:27
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/data/major/cooperate/";
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
<form action="${ctx}/data/major/cooperate/queryList.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.id" id="id" />
		<div class="filter">
 		<table>
            <tbody >
             <tr>
                <th>专业方向：</th>
                <td><s:textfield name="bean.directionid" cssClass="inputText"></s:textfield></td>
                <td>
                <th>修改时间选择：</th>
                <td>
                	<input name="bean.updatedtime" class="inputDate" onClick="new WdatePicker()" value="<fmt:formatDate value='${bean.updatedtime }' pattern='yyyy-MM-dd'/>">
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
                <!-- <th>序号</th> -->
                <th>专业方向</th>
                <th>产学合作企业总数（个）</th>
                <th>订单培养数（人）</th>
              <!--   <th>共同开发课程数（门）</th>
                <th>共同开发教材数（种）</th>
                <th>支持学校兼职教师数（人）</th>
                <th>接受顶岗实习学生数（人）</th>
                <th>对学校捐赠设备总值（万元）</th>
                <th>对学校准捐赠设备总值（万元）</th> -->
                <th>接受毕业生就业数（人）</th>
                <th>学校为企业技术服务年收入（万元）</th>
                <th>学校为企业年培训员工数（人）</th>
                <!-- <th>状态</th> -->
             <!--    <th>创建人</th>
                <th>创建时间</th>
                <th>修改人</th> -->
                <!-- <th>修改时间</th> -->
               <!--  <th>租户</th>
                <th>入库时间（接口传输，导入）</th> -->
                 <c:if test="${qx.update or qx.delete }">
                  <th>操作</th>
                  </c:if>
              </tr>
            </thead>
            <tbody class="tableHover">
            <c:forEach items="${datas}" var="item"  varStatus="stat">
	            <tr>
	           		<td><input name="test" type="checkbox" class="chk" value="${item.ID }"  checkNode="Selector" /></td>
	                <td>&nbsp;${stat.count }</td>
                   <%-- 	<td>&nbsp;${item.ID}</td> --%>
                   	<td>&nbsp;${item.DIRECTIONID}</td>
                   	<td>&nbsp;${item.COMPANIES}</td>
                   	<td>&nbsp;${item.ORDERCOUNT}</td>
                  <%--  	<td>&nbsp;${item.TEACHCOURSE}</td>
                   	<td>&nbsp;${item.TEACHMATERIAL}</td>
                   	<td>&nbsp;${item.PARTTIMETCH}</td>
                   	<td>&nbsp;${item.PRACTICESTUD}</td>
                   	<td>&nbsp;${item.DONATEDEVVAL}</td>
                   	<td>&nbsp;${item.READYDONATEVAL}</td> --%>
                   	<td>&nbsp;${item.ACCESSWORK}</td>
                   	<td>&nbsp;${item.SERVICEVALUE}</td>
                   	<td>&nbsp;${item.TRAINCOUNT}</td>
                   	<%-- <td>&nbsp;${item.STATUS}</td> --%>
              <%--      	<td>&nbsp;${item.CREATEDBY}</td>
                   	<td>&nbsp;<fmt:formatDate value="${item.CREATEDTIME}" pattern="yyyy-MM-dd"/></td>
                   	<td>&nbsp;${item.UPDATEDBY}</td> --%>
                   	<%-- <td>&nbsp;<fmt:formatDate value="${item.UPDATEDTIME}" pattern="yyyy-MM-dd"/> </td> --%>
                   <%-- 	<td>&nbsp;${item.TENANTID}</td>
                   	<td>&nbsp;${item.STORAGETIME}</td> --%>
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
