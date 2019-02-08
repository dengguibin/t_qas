<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:43:40
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/data/school/leaderAction/";
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
<form action="${ctx}/data/school/leaderAction/queryList.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.id" id="id" />
		<div class="filter" style="width: 100%;">
		
 		<table>
            <tbody >
             <tr>
                <th>教工名称：</th>
                <td><s:textfield name="bean.employeeid" cssClass="inputText"></s:textfield></td>

                <th>听课节数：</th>
                <td>
					<select class="select2" name="bean.lecturecountScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.lecturecountScope}">
								<option value='${bean.lecturecountScope}'  selected="selected">${bean.lecturecountScope}</option>
							</c:if>
							<c:if test="${bean.lecturecountScope!='0-10'}">
								<option value="0-10">0-10</option>
							</c:if>
							<c:if test="${bean.lecturecountScope!='10-20'}">
								<option value="10-20">10-20</option>
							</c:if>
							<c:if test="${bean.lecturecountScope!='20-30'}">
								<option value="20-30">20-30</option>
							</c:if>
							<c:if test="${bean.lecturecountScope!='30-40'}">
								<option value="30-40">30-40</option>
							</c:if>
							<c:if test="${bean.lecturecountScope!='40以上'}">
								<option value="40以上">40以上</option>
							</c:if>
					</select>
				</td>
                
                <th>走访学生寝室次数</th>
                 <td>
					<select class="select2" name="bean.interviewcountScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.interviewcountScope}">
								<option value='${bean.interviewcountScope}'  selected="selected">${bean.interviewcountScope}</option>
							</c:if>
							<c:if test="${bean.interviewcountScope!='0-10'}">
								<option value="0-10">0-10</option>
							</c:if>
							<c:if test="${bean.interviewcountScope!='10-20'}">
								<option value="10-20">10-20</option>
							</c:if>
							<c:if test="${bean.interviewcountScope!='20-30'}">
								<option value="20-30">20-30</option>
							</c:if>
							<c:if test="${bean.interviewcountScope!='30-40'}">
								<option value="30-40">30-40</option>
							</c:if>
							<c:if test="${bean.interviewcountScope!='40以上'}">
								<option value="40以上">40以上</option>
							</c:if>
					</select>
				</td>
                </tr>
                
                <tr>
                <th>走访校外实习点次数：</th>
                <td>
					<select class="select2" name="bean.practicalsessioncountScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.practicalsessioncountScope}">
								<option value='${bean.practicalsessioncountScope}'  selected="selected">${bean.practicalsessioncountScope}</option>
							</c:if>
							<c:if test="${bean.practicalsessioncountScope!='0-10'}">
								<option value="0-10">0-10</option>
							</c:if>
							<c:if test="${bean.practicalsessioncountScope!='10-20'}">
								<option value="10-20">10-20</option>
							</c:if>
							<c:if test="${bean.practicalsessioncountScope!='20-30'}">
								<option value="20-30">20-30</option>
							</c:if>
							<c:if test="${bean.practicalsessioncountScope!='30-40'}">
								<option value="30-40">30-40</option>
							</c:if>
							<c:if test="${bean.practicalsessioncountScope!='40以上'}">
								<option value="40以上">40以上</option>
							</c:if>
					</select>
				</td>
                
                <th>参与学生社团文体活动次数：</th>
                <td>
					<select class="select2" name="bean.studentassociationcountScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.studentassociationcountScope}">
								<option value='${bean.studentassociationcountScope}'  selected="selected">${bean.studentassociationcountScope}</option>
							</c:if>
							<c:if test="${bean.studentassociationcountScope!='0-10'}">
								<option value="0-10">0-10</option>
							</c:if>
							<c:if test="${bean.studentassociationcountScope!='10-20'}">
								<option value="10-20">10-20</option>
							</c:if>
							<c:if test="${bean.studentassociationcountScope!='20-30'}">
								<option value="20-30">20-30</option>
							</c:if>
							<c:if test="${bean.studentassociationcountScope!='30-40'}">
								<option value="30-40">30-40</option>
							</c:if>
							<c:if test="${bean.studentassociationcountScope!='40以上'}">
								<option value="40以上">40以上</option>
							</c:if>
					</select>
				</td>
                
                <th>兼课量学时数：</th>
                <td>
					<select class="select2" name="bean.parttimecountScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.parttimecountScope}">
								<option value='${bean.parttimecountScope}'  selected="selected">${bean.parttimecountScope}</option>
							</c:if>
							<c:if test="${bean.parttimecountScope!='0-5'}">
								<option value="0-5">0-5</option>
							</c:if>
							<c:if test="${bean.parttimecountScope!='5-10'}">
								<option value="5-10">5-10</option>
							</c:if>
							<c:if test="${bean.parttimecountScope!='10-15'}">
								<option value="10-15">10-15</option>
							</c:if>
							<c:if test="${bean.parttimecountScope!='15-20'}">
								<option value="15-20">15-20</option>
							</c:if>
							<c:if test="${bean.parttimecountScope!='20以上'}">
								<option value="20以上">20以上</option>
							</c:if>
					</select>
				</td>
				
                <!--
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
               <!--  <th>记录标识</th> -->
                <th>教工名称</th>
                <th>关注教学和学生情况<-->听课（节）</th>
                <th>关注教学和学生情况<-->走访学生寝室（次）</th>
                <th>关注教学和学生情况<-->走访校外实习点（次）</th>
                <th>关注教学和学生情况<-->参与学生社团文体活动（次）</th>
                <th>兼课量（学时）</th>
                <th>状态</th>
            <!--     <th>创建人</th>
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
                   	<td>&nbsp;${item.EMPLOYEEID}</td>
                   	<td>&nbsp;${item.LECTURECOUNT}</td>
                   	<td>&nbsp;${item.INTERVIEWCOUNT}</td>
                   	<td>&nbsp;${item.PRACTICALSESSIONCOUNT}</td>
                   	<td>&nbsp;${item.STUDENTASSOCIATIONCOUNT}</td>
                   	<td>&nbsp;${item.PARTTIMECOUNT}</td>
                   	<td>&nbsp;${item.STATUS}</td>
                   <%-- 	<td>&nbsp;${item.CREATEDBY}</td>
                   	<td>&nbsp;<fmt:formatDate value="${item.CREATEDTIME}" pattern="yyyy-MM-dd"/></td>
                   	<td>&nbsp;${item.UPDATEDBY}</td>
                   	<td>&nbsp;<fmt:formatDate value="${item.UPDATEDTIME}" pattern="yyyy-MM-dd"/> </td>
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
