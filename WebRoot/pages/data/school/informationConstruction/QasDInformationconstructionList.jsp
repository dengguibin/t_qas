<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:45:56
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/data/school/informationConstruction/";
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
<form action="${ctx}/data/school/informationConstruction/queryList.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.id" id="id" />
		<div class="filter" style="width: 100%;">
 		<table>
            <tbody >
             <tr>
                <!--<th>菜单名称：</th>
                <td><s:textfield name="bean.cdmc" cssClass="inputText"></s:textfield></td>
                <td>
                -->
                <th>出口总带宽：</th>
				<td>
					<select class="select2" name="bean.exportbandwidthScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.exportbandwidthScope}">
								<option value='${bean.exportbandwidthScope}'  selected="selected">${bean.exportbandwidthScope}</option>
							</c:if>
							<c:if test="${bean.exportbandwidthScope!='0-50'}">
								<option value="0-50">0-50</option>
							</c:if>
							<c:if test="${bean.exportbandwidthScope!='50-100'}">
								<option value="50-100">50-100</option>
							</c:if>
							<c:if test="${bean.exportbandwidthScope!='100-200'}">
								<option value="100-200">100-200</option>
							</c:if>
							<c:if test="${bean.exportbandwidthScope!='200-300'}">
								<option value="200-300">200-300</option>
							</c:if>
							<c:if test="${bean.exportbandwidthScope!='300以上'}">
								<option value="300以上">300以上</option>
							</c:if>
					</select>
				</td>	
				
				<th>校园网主干最大带宽：</th>
				<td>
					<select class="select2" name="bean.campusnetworkScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.campusnetworkScope}">
								<option value='${bean.campusnetworkScope}'  selected="selected">${bean.campusnetworkScope}</option>
							</c:if>
							<c:if test="${bean.campusnetworkScope!='0-50'}">
								<option value="0-50">0-50</option>
							</c:if>
							<c:if test="${bean.campusnetworkScope!='50-100'}">
								<option value="50-100">50-100</option>
							</c:if>
							<c:if test="${bean.campusnetworkScope!='100-200'}">
								<option value="100-200">100-200</option>
							</c:if>
							<c:if test="${bean.campusnetworkScope!='200-300'}">
								<option value="200-300">200-300</option>
							</c:if>
							<c:if test="${bean.campusnetworkScope!='300以上'}">
								<option value="300以上">300以上</option>
							</c:if>
					</select>
				</td>	
				
				<th>网络信息点数：</th>
				<td>
					<select class="select2" name="bean.networkinformationpointScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.networkinformationpointScope}">
								<option value='${bean.networkinformationpointScope}'  selected="selected">${bean.networkinformationpointScope}</option>
							</c:if>
							<c:if test="${bean.networkinformationpointScope!='0-50'}">
								<option value="0-50">0-50</option>
							</c:if>
							<c:if test="${bean.networkinformationpointScope!='50-100'}">
								<option value="50-100">50-100</option>
							</c:if>
							<c:if test="${bean.networkinformationpointScope!='100-200'}">
								<option value="100-200">100-200</option>
							</c:if>
							<c:if test="${bean.networkinformationpointScope!='200-300'}">
								<option value="200-300">200-300</option>
							</c:if>
							<c:if test="${bean.networkinformationpointScope!='300以上'}">
								<option value="300以上">300以上</option>
							</c:if>
					</select>
				</td>	
				</tr>
				
				<tr>
				<th>管理信息系统数据总量：</th>
				<td>
					<select class="select2" name="bean.accountofmisScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.accountofmisScope}">
								<option value='${bean.accountofmisScope}'  selected="selected">${bean.accountofmisScope}</option>
							</c:if>
							<c:if test="${bean.accountofmisScope!='0-50'}">
								<option value="0-50">0-50</option>
							</c:if>
							<c:if test="${bean.accountofmisScope!='50-100'}">
								<option value="50-100">50-100</option>
							</c:if>
							<c:if test="${bean.accountofmisScope!='100-200'}">
								<option value="100-200">100-200</option>
							</c:if>
							<c:if test="${bean.accountofmisScope!='200-300'}">
								<option value="200-300">200-300</option>
							</c:if>
							<c:if test="${bean.accountofmisScope!='300以上'}">
								<option value="300以上">300以上</option>
							</c:if>
					</select>
				</td>	
				
				<th>电子邮件系统用户数：</th>
				<td>
					<select class="select2" name="bean.emailusercountScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.emailusercountScope}">
								<option value='${bean.emailusercountScope}'  selected="selected">${bean.emailusercountScope}</option>
							</c:if>
							<c:if test="${bean.emailusercountScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.emailusercountScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.emailusercountScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.emailusercountScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.emailusercountScope!='4000-5000'}">
								<option value="4000-5000">4000-5000</option>
							</c:if>
							<c:if test="${bean.emailusercountScope!='5000以上'}">
								<option value="5000以上">5000以上</option>
							</c:if>
					</select>
				</td>	
				
				<th>上网课程数：</th>
				<td>
					<select class="select2" name="bean.onlinecoursecountScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.onlinecoursecountScope}">
								<option value='${bean.onlinecoursecountScope}'  selected="selected">${bean.onlinecoursecountScope}</option>
							</c:if>
							<c:if test="${bean.onlinecoursecountScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.onlinecoursecountScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.onlinecoursecountScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.onlinecoursecountScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.onlinecoursecountScope!='4000-5000'}">
								<option value="4000-5000">4000-5000</option>
							</c:if>
							<c:if test="${bean.onlinecoursecountScope!='5000以上'}">
								<option value="5000以上">5000以上</option>
							</c:if>
					</select>
				</td>	
				</tr>
				
				<tr>
				<th>数字资源量合计：</th>
				<td>
					<select class="select2" name="bean.totaldigitalresourceScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.totaldigitalresourceScope}">
								<option value='${bean.totaldigitalresourceScope}'  selected="selected">${bean.totaldigitalresourceScope}</option>
							</c:if>
							<c:if test="${bean.totaldigitalresourceScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.totaldigitalresourceScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.totaldigitalresourceScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.totaldigitalresourceScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.totaldigitalresourceScope!='4000-5000'}">
								<option value="4000-5000">4000-5000</option>
							</c:if>
							<c:if test="${bean.totaldigitalresourceScope!='5000以上'}">
								<option value="5000以上">5000以上</option>
							</c:if>
					</select>
				</td>
                
                
                <!--<th>EQ选择：</th>
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
                <!-- <th>序号</th> -->
                <th>出口总带宽（Mbps）</th>
                <th>校园网主干最大带宽（Mbps）</th>
                <th>网络信息点数（个）</th>
                <th>管理信息系统数据总量（GB）</th>
                <th>电子邮件系统用户数（个）</th>
                <th>上网课程数（门）</th>
                <th>数字资源量合计(GB)</th>
                <!-- <th>数字资源量(GB)--电子图书</th>
                <th>多媒体教学资源库总容量（TB）</th> -->
                <!-- <th>国家级职业教育专业教学资源库数量</th>
                <th>省级职业教育专业教学资源库数量</th>
                <th>一卡通使用	</th>
                <th>无线覆盖情况	</th> -->
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
                   	<td>&nbsp;${item.EXPORTBANDWIDTH}</td>
                   	<td>&nbsp;${item.CAMPUSNETWORK}</td>
                   	<td>&nbsp;${item.NETWORKINFORMATIONPOINT}</td>
                   	<td>&nbsp;${item.ACCOUNTOFMIS}</td>
                   	<td>&nbsp;${item.EMAILUSERCOUNT}</td>
                   	<td>&nbsp;${item.ONLINECOURSECOUNT}</td>
                    <td>&nbsp;${item.TOTALDIGITALRESOURCE}</td>
                   	<%--	<td>&nbsp;${item.ELECTRONICBOOK}</td>
                   	<td>&nbsp;${item.MULTIMEDIACAPACITY}</td> --%>
                   	<%-- <td>&nbsp;${item.NATIONALLEVELRESOURCE}</td>
                   	<td>&nbsp;${item.PROVINCIALRESOURCE}</td>
                   	<td>&nbsp;${item.ALLINONECARDUSAGE}</td>
                   	<td>&nbsp;${item.WIRELESSCOVERAGE}</td> --%>
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
