<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:58:43
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/data/school/trainingBaseOutOfCampusStatistics/";
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
<form action="${ctx}/data/school/trainingBaseOutOfCampusStatistics/queryList.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.id" id="id" />
		<div class="filter" style="width: 100%;">
 		<table>
            <tbody >
             <tr>
               <th>校外实践基地名称：</th>
                <td><s:textfield name="bean.practicebaseincampusid" cssClass="inputText"></s:textfield></td>
                
                <th>面向专业：</th>
                <td><s:textfield name="bean.majorid" cssClass="inputText"></s:textfield></td>
                
                <th>项目数：</th>
				<td>
					<select class="select2" name="bean.numoftrainingprojectScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.numoftrainingprojectScope}">
								<option value='${bean.numoftrainingprojectScope}'  selected="selected">${bean.numoftrainingprojectScope}</option>
							</c:if>
							<c:if test="${bean.numoftrainingprojectScope!='0-50'}">
								<option value="0-50">0-50</option>
							</c:if>
							<c:if test="${bean.numoftrainingprojectScope!='50-100'}">
								<option value="50-100">50-100</option>
							</c:if>
							<c:if test="${bean.numoftrainingprojectScope!='100-200'}">
								<option value="100-200">100-200</option>
							</c:if>
							<c:if test="${bean.numoftrainingprojectScope!='200-300'}">
								<option value="200-300">200-300</option>
							</c:if>
							<c:if test="${bean.numoftrainingprojectScope!='300以上'}">
								<option value="300以上">300以上</option>
							</c:if>
					</select>
				</td>	
                 </tr>
                
                <tr>
                <th>实习实训项目：</th>
                <td><s:textfield name="bean.numofprojectname" cssClass="inputText"></s:textfield></td>
              
                <th>接待学生量(人次)：</th>
				<td>
					<select class="select2" name="bean.numofstureceivedScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.numofstureceivedScope}">
								<option value='${bean.numofstureceivedScope}'  selected="selected">${bean.numofstureceivedScope}</option>
							</c:if>
							<c:if test="${bean.numofstureceivedScope!='0-50'}">
								<option value="0-50">0-50</option>
							</c:if>
							<c:if test="${bean.numofstureceivedScope!='50-100'}">
								<option value="50-100">50-100</option>
							</c:if>
							<c:if test="${bean.numofstureceivedScope!='100-200'}">
								<option value="100-200">100-200</option>
							</c:if>
							<c:if test="${bean.numofstureceivedScope!='200-300'}">
								<option value="200-300">200-300</option>
							</c:if>
							<c:if test="${bean.numofstureceivedScope!='300以上'}">
								<option value="300以上">300以上</option>
							</c:if>
					</select>
				</td>	
				
				<th>基地使用时间（天）：</th>
				<td>
					<select class="select2" name="bean.baseusetimeScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.baseusetimeScope}">
								<option value='${bean.baseusetimeScope}'  selected="selected">${bean.baseusetimeScope}</option>
							</c:if>
							<c:if test="${bean.baseusetimeScope!='0-50'}">
								<option value="0-50">0-50</option>
							</c:if>
							<c:if test="${bean.baseusetimeScope!='50-100'}">
								<option value="50-100">50-100</option>
							</c:if>
							<c:if test="${bean.baseusetimeScope!='100-200'}">
								<option value="100-200">100-200</option>
							</c:if>
							<c:if test="${bean.baseusetimeScope!='200-300'}">
								<option value="200-300">200-300</option>
							</c:if>
							<c:if test="${bean.baseusetimeScope!='300以上'}">
								<option value="300以上">300以上</option>
							</c:if>
					</select>
				</td>	
				</tr>
                
                <tr>
				<th>接受半年顶岗实习学生数：</th>
				<td>
					<select class="select2" name="bean.halfyearinternshipstudentScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.halfyearinternshipstudentScope}">
								<option value='${bean.halfyearinternshipstudentScope}'  selected="selected">${bean.halfyearinternshipstudentScope}</option>
							</c:if>
							<c:if test="${bean.halfyearinternshipstudentScope!='0-50'}">
								<option value="0-50">0-50</option>
							</c:if>
							<c:if test="${bean.halfyearinternshipstudentScope!='50-100'}">
								<option value="50-100">50-100</option>
							</c:if>
							<c:if test="${bean.halfyearinternshipstudentScope!='100-200'}">
								<option value="100-200">100-200</option>
							</c:if>
							<c:if test="${bean.halfyearinternshipstudentScope!='200-300'}">
								<option value="200-300">200-300</option>
							</c:if>
							<c:if test="${bean.halfyearinternshipstudentScope!='300以上'}">
								<option value="300以上">300以上</option>
							</c:if>
					</select>
				</td>
				
                <th>是否有住宿条件：</th>
                <td><s:textfield name="bean.isaccommodationconditions" cssClass="inputText"></s:textfield></td>
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
                <th>校外实践基地</th>
                <th>面向专业 </th>
                <th>项目数</th>
                <th>实习实训项目</th>
                <th>接待学生量(人次)	</th>
                <th>基地使用时间（天）</th>
                <th>接受半年顶岗实习学生数</th>
                <th>是否有住宿条件</th>
                <!-- <th>基地是否发放学生实习补贴</th>
                <th>向基地支付专项实习经费（元/生）</th>
                <th>派指导教师/学生管理人员（人次）</th>
                <th>接收应届毕业生就业数</th> -->
                <th>状态</th>
                <!-- <th>创建人</th>
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
                   	<td>&nbsp;${item.PRACTICEBASEINCAMPUSID}</td>
                   	<td>&nbsp;${item.MAJORID}</td>
                   	<td>&nbsp;${item.NUMOFTRAININGPROJECT}</td>
                   	<td>&nbsp;${item.NUMOFPROJECTNAME}</td>
                   	<td>&nbsp;${item.NUMOFSTURECEIVED}</td>
                   	<td>&nbsp;${item.BASEUSETIME}</td>
                   	<td>&nbsp;${item.HALFYEARINTERNSHIPSTUDENT}</td>
                   	<td>&nbsp;${item.ISACCOMMODATIONCONDITIONS}</td>
                   	<%-- <td>&nbsp;${item.STUDENTINTERNSHIPALLOWANCE}</td>
                   	<td>&nbsp;${item.SPECIALPRACTICEFUND}</td>
                   	<td>&nbsp;${item.SCHOOLTUTORCOUNT}</td>
                   	<td>&nbsp;${item.NUMOFGRADUATEEMPLOYED}</td> --%>
                   	<td>&nbsp;${item.STATUS}</td>
                   	<%-- <td>&nbsp;${item.CREATEDBY}</td>
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
