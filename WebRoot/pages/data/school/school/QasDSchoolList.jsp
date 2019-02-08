<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:18:45
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/data/school/school/";
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
<form action="${ctx}/data/school/school/queryList.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.id" id="id" />
		<div class="filter" style="width: 100%;">
 		<table>
            <tbody >
             <tr>
                <th>学校标识码 ：</th>
                <td><s:textfield name="bean.code" cssClass="inputText"></s:textfield></td>
                
                <th>学校名称(全称)：</th>
                <td><s:textfield name="bean.name" cssClass="inputText"></s:textfield></td>
                
                <th>所在地区：</th>
                <td><s:textfield name="bean.location" cssClass="inputText"></s:textfield></td>
                
                <th>当前校名启用日期：</th>
                <td><s:textfield name="bean.nameuseddate" cssClass="inputText"></s:textfield></td>
                </tr>
                <tr>
                <th>建校日期：</th>
                <td><s:textfield name="bean.buildeddate" cssClass="inputText"></s:textfield></td>
                
                <th>建校基础：</th>
                <td><s:textfield name="bean.buildedbase" cssClass="inputText"></s:textfield></td>
                
                <th>学校性质类别 ：</th>
                <td><s:textfield name="bean.grade" cssClass="inputText"></s:textfield></td>
                </tr>
                <tr>
                <th>通信地址：</th>
                <td><s:textfield name="bean.address" cssClass="inputText"></s:textfield></td>
                
                <th>邮政编码 ：</th>
                <td><s:textfield name="bean.postcode" cssClass="inputText"></s:textfield></td>
                
                <th>学校网址 ：</th>
                <td><s:textfield name="bean.web" cssClass="inputText"></s:textfield></td>
                
                <!--<td>
                <th>选择菜单：</th>
                <td>
                 <select class="select2">
                 	<option value=''>--请选择--</option>
				    <option>3000-5000</option>
				    <option>5000-8000</option>
				    <option>8000-10000</option>
				    <option>10000-15000</option>
				   </select>
                </td>
                <th>EQ选择：</th>
                <td>
                 <select  id="select9" name="select9" style="width:160px;">
                 	<option value="">--请选择--</option>
                 	调用字典的效果
				   	 <x:cache subject="ORGS" option="true" selected="${param.select9 }"></x:cache>
				   </select>
                </td>
                
                <th>时间选择：</th>
                <td>
                	<input class="inputDate" onClick="new WdatePicker()">
                </td>
                -->
                <td>
                <input name="button" onclick="opreate('','query');" type="button" class="inputButton" value=" 查 询 " />
                </td>
              </tr>
            </tbody>
          </table>
		</div><!--filter end-->
		
		<div class="tools" style="padding-top: 0;">
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
                <!-- <th>记录标识</th> -->
                <th>学校标识码</th>
                <th>学校名称</th>
                <th>所在地区</th>
                <th>当前校名启用日期（年月）</th>
                <th>建校日期（年月）</th>
                <th>建校基础</th>
              <!--   <th>学校举办者--名称(全称)</th>
                <th>学校举办者--性质</th>
                <th>学校举办者--级别	</th> -->
                <th>学校性质类别</th>
                <!-- <th>校训</th> -->
                <th>通信地址</th>
                <th>邮政编码</th>
                <th>学校网址</th>
                <!-- <th>社区教育示范校</th> -->
              <!--   <th>示范性高等职业院校--性质</th>
                <th>示范性高等职业院校--级别</th>
                <th>示范性高等职业院校--立项部门</th>
                <th>示范性高等职业院校--立项日期（年）</th>
                <th>评估状态--第一轮--评估日期（年月)</th>
                <th>评估状态--第二轮--评估结论</th>
                <th>评估状态--未接受评估</th> -->
                <th>状态</th>
              <!--   <th>创建人</th>
                <th>创建时间</th>
                <th>修改人</th>
                <th>修改时间</th>
                <th>租户</th>
                <th>入库时间（接口传输，导入）</th> -->
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
                   	<td>&nbsp;${item.CODE}</td>
                   	<td>&nbsp;${item.NAME}</td>
                   	<td>&nbsp;${item.LOCATION}</td>
                   	<td>&nbsp;${item.NAMEUSEDDATE}</td>
                   	<td>&nbsp;${item.BUILDEDDATE}</td>
                   	<td>&nbsp;${item.BUILDEDBASE}</td>
                   	<%-- <td>&nbsp;${item.CREATERNAME}</td>
                   	<td>&nbsp;${item.CREATERNATURE}</td>
                   	<td>&nbsp;${item.CREATERGRADE}</td> --%>
                   	<td>&nbsp;${item.GRADE}</td>
                   <%-- 	<td>&nbsp;${item.MOTTO}</td> --%>
                   	<td>&nbsp;${item.ADDRESS}</td>
                   	<td>&nbsp;${item.POSTCODE}</td>
                   	<!--  --><td>&nbsp;${item.WEB}</td>
                   	<td>&nbsp;${item.ISCOMMUNITYEDUDEMONSTRATION}</td>
                   <%-- 	<td>&nbsp;${item.EXAMPNATURE}</td>
                   	<td>&nbsp;${item.EXAMPGRADE}</td>
                   	<td>&nbsp;${item.EXAMPDEPARTMENT}</td>
                   	<td>&nbsp;${item.EXAMPBUILDEDTIME}</td>
                   	<td>&nbsp;${item.ESTIMATEFIRSTTIME}</td>
                   	<td>&nbsp;${item.ESTIMATESECONDRESULT}</td>
                   	<td>&nbsp;${item.ESTIMATENORUN}</td> --%>
                   	<td>&nbsp;${item.STATUS}</td>
                   	<%-- <td>&nbsp;${item.CREATEDBY}</td>
                   	<td>&nbsp;<fmt:formatDate value="${item.CREATEDTIME}" pattern="yyyy-MM-dd"/></td>
                   	<td>&nbsp;${item.UPDATEDBY}</td>
                   	<td>&nbsp;<fmt:formatDate value="${item.UPDATEDTIME}" pattern="yyyy-MM-dd"/></td>
                   	<td>&nbsp;${item.TENANTID}</td>
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
