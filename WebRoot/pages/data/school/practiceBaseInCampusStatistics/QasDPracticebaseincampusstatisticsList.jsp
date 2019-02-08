<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:52:24
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/data/school/practiceBaseInCampusStatistics/";
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
<form action="${ctx}/data/school/practiceBaseInCampusStatistics/queryList.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.id" id="id" />
		<div class="filter" style="width: 100%;">
 		<table>
            <tbody >
             <tr>
                <th>校内实践基地：</th>
                <td><s:textfield name="bean.practicebaseincampusid" cssClass="inputText"></s:textfield></td>
                
                 <th>面向专业：</th>
                <td><s:textfield name="bean.majorid" cssClass="inputText"></s:textfield></td>
                
                <th>学年内基地使用时间：</th>
					<td>
					<select class="select2" name="bean.averagetimeperyearScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.averagetimeperyearScope}">
								<option value='${bean.averagetimeperyearScope}'  selected="selected">${bean.averagetimeperyearScope}</option>
							</c:if>
							<c:if test="${bean.averagetimeperyearScope!='0-5'}">
								<option value="0-5">0-5</option>
							</c:if>
							<c:if test="${bean.averagetimeperyearScope!='5-10'}">
								<option value="5-10">5-10</option>
							</c:if>
							<c:if test="${bean.averagetimeperyearScope!='10-15'}">
								<option value="10-15">10-15</option>
							</c:if>
							<c:if test="${bean.averagetimeperyearScope!='15-20'}">
								<option value="15-20">15-20</option>
							</c:if>
							<c:if test="${bean.averagetimeperyearScope!='20以上'}">
								<option value="20以上">20以上</option>
							</c:if>
					</select>
				</td>	
				</tr>
				
				<tr>
                <th>项目个数：</th>
				<td>
					<select class="select2" name="bean.numoftrainingprojectScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.numoftrainingprojectScope}">
								<option value='${bean.numoftrainingprojectScope}'  selected="selected">${bean.numoftrainingprojectScope}</option>
							</c:if>
							<c:if test="${bean.numoftrainingprojectScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.numoftrainingprojectScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.numoftrainingprojectScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.numoftrainingprojectScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.numoftrainingprojectScope!='4000-5000'}">
								<option value="4000-5000">4000-5000</option>
							</c:if>
							<c:if test="${bean.numoftrainingprojectScope!='5000以上'}">
								<option value="5000以上">5000以上</option>
							</c:if>
					</select>
				</td>	
				
				       
                <th>实训项目名称：</th>
				<td>
					<select class="select2" name="bean.numofprojectnameScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.numofprojectnameScope}">
								<option value='${bean.numofprojectnameScope}'  selected="selected">${bean.numofprojectnameScope}</option>
							</c:if>
							<c:if test="${bean.numofprojectnameScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.numofprojectnameScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.numofprojectnameScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.numofprojectnameScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.numofprojectnameScope!='4000-5000'}">
								<option value="4000-5000">4000-5000</option>
							</c:if>
							<c:if test="${bean.numofprojectnameScope!='5000以上'}">
								<option value="5000以上">5000以上</option>
							</c:if>
					</select>
				</td>	
				
				       
                <th>工位数(个)：</th>
				<td>
					<select class="select2" name="bean.numofworkerScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.numofworkerScope}">
								<option value='${bean.numofworkerScope}'  selected="selected">${bean.numofworkerScope}</option>
							</c:if>
							<c:if test="${bean.numofworkerScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.numofworkerScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.numofworkerScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.numofworkerScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.numofworkerScope!='4000-5000'}">
								<option value="4000-5000">4000-5000</option>
							</c:if>
							<c:if test="${bean.numofworkerScope!='5000以上'}">
								<option value="5000以上">5000以上</option>
							</c:if>
					</select>
				</td>	
				
                
				</tr>
				
				<tr>
					<th>原材料(耗材)费用（万元）：</th>
				<td>
					<select class="select2" name="bean.costofconsumptiveScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.costofconsumptiveScope}">
								<option value='${bean.costofconsumptiveScope}'  selected="selected">${bean.costofconsumptiveScope}</option>
							</c:if>
							<c:if test="${bean.costofconsumptiveScope!='0-50'}">
								<option value="0-50">0-50</option>
							</c:if>
							<c:if test="${bean.costofconsumptiveScope!='50-100'}">
								<option value="50-100">50-100</option>
							</c:if>
							<c:if test="${bean.costofconsumptiveScope!='100-200'}">
								<option value="100-200">100-200</option>
							</c:if>
							<c:if test="${bean.costofconsumptiveScope!='200-300'}">
								<option value="200-300">200-300</option>
							</c:if>
							<c:if test="${bean.costofconsumptiveScope!='300以上'}">
								<option value="300以上">300以上</option>
							</c:if>
					</select>
				</td>	
                <th>设备维护费用（万元）：</th>
				<td>
					<select class="select2" name="bean.costofmaterialsScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.costofmaterialsScope}">
								<option value='${bean.costofmaterialsScope}'  selected="selected">${bean.costofmaterialsScope}</option>
							</c:if>
							<c:if test="${bean.costofmaterialsScope!='0-50'}">
								<option value="0-50">0-50</option>
							</c:if>
							<c:if test="${bean.costofmaterialsScope!='50-100'}">
								<option value="50-100">50-100</option>
							</c:if>
							<c:if test="${bean.costofmaterialsScope!='100-200'}">
								<option value="100-200">100-200</option>
							</c:if>
							<c:if test="${bean.costofmaterialsScope!='200-300'}">
								<option value="200-300">200-300</option>
							</c:if>
							<c:if test="${bean.costofmaterialsScope!='300以上'}">
								<option value="300以上">300以上</option>
							</c:if>
					</select>
				</td>	
				       
                <th>专职管理人员（名）：</th>
				<td>
					<select class="select2" name="bean.fulltimemanagementScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.fulltimemanagementScope}">
								<option value='${bean.fulltimemanagementScope}'  selected="selected">${bean.fulltimemanagementScope}</option>
							</c:if>
							<c:if test="${bean.fulltimemanagementScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.fulltimemanagementScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.fulltimemanagementScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.fulltimemanagementScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.fulltimemanagementScope!='4000-5000'}">
								<option value="4000-5000">4000-5000</option>
							</c:if>
							<c:if test="${bean.fulltimemanagementScope!='5000以上'}">
								<option value="5000以上">5000以上</option>
							</c:if>
					</select>
				</td>	
				</tr>
				<tr>
                <th>兼职管理人员（名）：</th>
				<td>
					<select class="select2" name="bean.parttimemanagementScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.parttimemanagementScope}">
								<option value='${bean.parttimemanagementScope}'  selected="selected">${bean.parttimemanagementScope}</option>
							</c:if>
							<c:if test="${bean.parttimemanagementScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.parttimemanagementScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.parttimemanagementScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.parttimemanagementScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.parttimemanagementScope!='4000-5000'}">
								<option value="4000-5000">4000-5000</option>
							</c:if>
							<c:if test="${bean.parttimemanagementScope!='5000以上'}">
								<option value="5000以上">5000以上</option>
							</c:if>
					</select>
				</td>	
                
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
               <!--  <th>记录标识</th> -->
                <th>校内实践基地</th>
                <th>面向专业</th>
                <th>学年内基地使用时间</th>
              <!--   <th>设备值（万元）--设备总值</th>
                <th>设备值（万元）--当年新增设备值</th>
                <th>当年设备来源(万元）--自主研制设备值</th>
                <th>当年设备来源(万元）--社会捐赠设备值</th>
                <th>当年设备来源(万元）--社会准捐赠设备值</th>
                <th>设备数（台套）--设备总数</th>
                <th>设备数（台套）--大型设备数</th> -->
                <th>项目个数</th>
                <th>实训项目名称</th>
               <!--  <th>学年使用频率（人时）--校内</th>
                <th>学年使用频率（人时）--社会</th> -->
                <th>工位数(个)</th>
                <th>原材料(耗材)费用（万元）</th>
                <th>设备维护费用（万元）</th>
                <th>专职管理人员（名）</th>
                <th>兼职管理人员（名）</th>
                <th>状态</th>
               <!--  <th>创建人</th>
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
                   	<td>&nbsp;${item.AVERAGETIMEPERYEAR}</td>
                   <%-- 	<td>&nbsp;${item.EQUIPMENTVALUE}</td>
                   	<td>&nbsp;${item.NEWEQUIPMENTVALUE}</td>
                   	<td>&nbsp;${item.SELFDEVELOPEDEQUVALUE}</td>
                   	<td>&nbsp;${item.SOCIETYDEVELOPEDEQUVALUE}</td>
                   	<td>&nbsp;${item.SOCIALDONATIONEQUVALUE}</td>
                   	<td>&nbsp;${item.EQUIMENTCOUNT}</td>
                   	<td>&nbsp;${item.LARGEEQUIMENTCOUNT}</td> --%>
                   	<td>&nbsp;${item.NUMOFTRAININGPROJECT}</td>
                   	<td>&nbsp;${item.NUMOFPROJECTNAME}</td>
                   	<%-- <td>&nbsp;${item.FREQUENCYOFCAMPUS}</td>
                   	<td>&nbsp;${item.FREQUENCYOFSOCIOLOGY}</td> --%>
                   	<td>&nbsp;${item.NUMOFWORKER}</td>
                   	<td>&nbsp;${item.COSTOFCONSUMPTIVE}</td>
                   	<td>&nbsp;${item.COSTOFMATERIALS}</td>
                   	<td>&nbsp;${item.FULLTIMEMANAGEMENT}</td>
                   	<td>&nbsp;${item.PARTTIMEMANAGEMENT}</td>
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
