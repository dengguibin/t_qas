<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:40:49
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/data/school/collegeEnrolPlan/";
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
<form action="${ctx}/data/school/collegeEnrolPlan/queryList.action"   method="post" 
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
                <!--
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
                	<th>全日制高职专业设置数：</th>
					<td>
					<select class="select2" name="bean.column_9Scope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.column_9Scope}">
								<option value='${bean.column_9Scope}'  selected="selected">${bean.column_9Scope}</option>
							</c:if>
							<c:if test="${bean.column_9Scope!='0-50'}">
								<option value="0-50">0-50</option>
							</c:if>
							<c:if test="${bean.column_9Scope!='50-100'}">
								<option value="50-100">50-100</option>
							</c:if>
							<c:if test="${bean.column_9Scope!='100-200'}">
								<option value="100-200">100-200</option>
							</c:if>
							<c:if test="${bean.column_9Scope!='200-300'}">
								<option value="200-300">200-300</option>
							</c:if>
							<c:if test="${bean.column_9Scope!='300以上'}">
								<option value="300以上">300以上</option>
							</c:if>
					</select>
				</td>	
					
					<th>全日制高职招生专业数：</th>
					<td>
					<select class="select2" name="bean.column_10Scope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.column_10Scope}">
								<option value='${bean.column_10Scope}'  selected="selected">${bean.column_10Scope}</option>
							</c:if>
							<c:if test="${bean.column_10Scope!='0-50'}">
								<option value="0-50">0-50</option>
							</c:if>
							<c:if test="${bean.column_10Scope!='50-100'}">
								<option value="50-100">50-100</option>
							</c:if>
							<c:if test="${bean.column_10Scope!='100-200'}">
								<option value="100-200">100-200</option>
							</c:if>
							<c:if test="${bean.column_10Scope!='200-300'}">
								<option value="200-300">200-300</option>
							</c:if>
							<c:if test="${bean.column_10Scope!='300以上'}">
								<option value="300以上">300以上</option>
							</c:if>
					</select>
				</td>	
							
					<th>全日制高职招生数：</th>
					<td>
					<select class="select2" name="bean.column_11Scope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.column_11Scope}">
								<option value='${bean.column_11Scope}'  selected="selected">${bean.column_11Scope}</option>
							</c:if>
							<c:if test="${bean.column_11Scope!='0-5000'}">
								<option value="0-5000">0-5000</option>
							</c:if>
							<c:if test="${bean.column_11Scope!='5000-10000'}">
								<option value="5000-10000">5000-10000</option>
							</c:if>
							<c:if test="${bean.column_11Scope!='10000-20000'}">
								<option value="10000-20000">10000-20000</option>
							</c:if>
							<c:if test="${bean.column_11Scope!='20000-30000'}">
								<option value="20000-30000">20000-30000</option>
							</c:if>
							<c:if test="${bean.column_11Scope!='30000-40000'}">
								<option value="30000-40000">30000-40000</option>
							</c:if>
							<c:if test="${bean.column_11Scope!='40000以上'}">
								<option value="40000以上">40000以上</option>
							</c:if>
					</select>
				</td>	
					</tr>
					
					<tr>
					<th>普通高中生招生数：</th>
					<td>
					<select class="select2" name="bean.column_12Scope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.column_12Scope}">
								<option value='${bean.column_12Scope}'  selected="selected">${bean.column_12Scope}</option>
							</c:if>
							<c:if test="${bean.column_12Scope!='0-5000'}">
								<option value="0-5000">0-5000</option>
							</c:if>
							<c:if test="${bean.column_12Scope!='5000-10000'}">
								<option value="5000-10000">5000-10000</option>
							</c:if>
							<c:if test="${bean.column_12Scope!='10000-20000'}">
								<option value="10000-20000">10000-20000</option>
							</c:if>
							<c:if test="${bean.column_12Scope!='20000-30000'}">
								<option value="20000-30000">20000-30000</option>
							</c:if>
							<c:if test="${bean.column_12Scope!='30000-40000'}">
								<option value="30000-40000">30000-40000</option>
							</c:if>
							<c:if test="${bean.column_12Scope!='40000以上'}">
								<option value="40000以上">40000以上</option>
							</c:if>
					</select>
				</td>	
					
					
					<th>"三校生"招生数：</th>
					<td>
					<select class="select2" name="bean.column_13Scope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.column_13Scope}">
								<option value='${bean.column_13Scope}'  selected="selected">${bean.column_13Scope}</option>
							</c:if>
							<c:if test="${bean.column_13Scope!='0-5000'}">
								<option value="0-5000">0-5000</option>
							</c:if>
							<c:if test="${bean.column_13Scope!='5000-10000'}">
								<option value="5000-10000">5000-10000</option>
							</c:if>
							<c:if test="${bean.column_13Scope!='10000-20000'}">
								<option value="10000-20000">10000-20000</option>
							</c:if>
							<c:if test="${bean.column_13Scope!='20000-30000'}">
								<option value="20000-30000">20000-30000</option>
							</c:if>
							<c:if test="${bean.column_13Scope!='30000-40000'}">
								<option value="30000-40000">30000-40000</option>
							</c:if>
							<c:if test="${bean.column_13Scope!='40000以上'}">
								<option value="40000以上">40000以上</option>
							</c:if>
					</select>
				</td>	
					
					<th>"3＋2"招生数：</th>
					<td>
					<select class="select2" name="bean.column_14Scope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.column_14Scope}">
								<option value='${bean.column_14Scope}'  selected="selected">${bean.column_14Scope}</option>
							</c:if>
							<c:if test="${bean.column_14Scope!='0-5000'}">
								<option value="0-5000">0-5000</option>
							</c:if>
							<c:if test="${bean.column_14Scope!='5000-10000'}">
								<option value="5000-10000">5000-10000</option>
							</c:if>
							<c:if test="${bean.column_14Scope!='10000-20000'}">
								<option value="10000-20000">10000-20000</option>
							</c:if>
							<c:if test="${bean.column_14Scope!='20000-30000'}">
								<option value="20000-30000">20000-30000</option>
							</c:if>
							<c:if test="${bean.column_14Scope!='30000-40000'}">
								<option value="30000-40000">30000-40000</option>
							</c:if>
							<c:if test="${bean.column_14Scope!='40000以上'}">
								<option value="40000以上">40000以上</option>
							</c:if>
					</select>
				</td>	
					</tr>
					
					<tr>
					<th>五年制高职第4学年招生数：</th>
						<td>
					<select class="select2" name="bean.column_15Scope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.column_15Scope}">
								<option value='${bean.column_15Scope}'  selected="selected">${bean.column_15Scope}</option>
							</c:if>
							<c:if test="${bean.column_15Scope!='0-5000'}">
								<option value="0-5000">0-5000</option>
							</c:if>
							<c:if test="${bean.column_15Scope!='5000-10000'}">
								<option value="5000-10000">5000-10000</option>
							</c:if>
							<c:if test="${bean.column_15Scope!='10000-20000'}">
								<option value="10000-20000">10000-20000</option>
							</c:if>
							<c:if test="${bean.column_15Scope!='20000-30000'}">
								<option value="20000-30000">20000-30000</option>
							</c:if>
							<c:if test="${bean.column_15Scope!='30000-40000'}">
								<option value="30000-40000">30000-40000</option>
							</c:if>
							<c:if test="${bean.column_15Scope!='40000以上'}">
								<option value="40000以上">40000以上</option>
							</c:if>
					</select>
				</td>		
                
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
                <th>全日制高职专业设置数（不含方向） </th>
                <th>全日制高职招生专业数（不含方向）</th>
                <th>全日制高职招生数</th>
                <th>普通高中生招生数（人）</th>
                <th>"三校生"招生数（人）</th>
                <th>"3＋2"招生数（人）</th>
                <th>五年制高职第4学年招生数（人）</th>
                <th>其他招生数（人）</th>
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
                   <%-- 	<td>&nbsp;${item.ID}</td> --%>
                   	<td>&nbsp;${item.COLUMN_9}</td>
                   	<td>&nbsp;${item.COLUMN_10}</td>
                   	<td>&nbsp;${item.COLUMN_11}</td>
                   	<td>&nbsp;${item.COLUMN_12}</td>
                   	<td>&nbsp;${item.COLUMN_13}</td>
                   	<td>&nbsp;${item.COLUMN_14}</td>
                   	<td>&nbsp;${item.COLUMN_15}</td>
                   	<td>&nbsp;${item.COLUMN_16}</td>
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
