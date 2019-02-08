<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-24 10:18:01
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/data/student/skillTraining/";
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
<form action="${ctx}/data/student/skillTraining/queryList.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.id" id="id" />
		<div class="filter" style="width: 100%;">
		
 		<table>
            <tbody >
             <tr>
             	<th>专业方向：</th>
                <td><s:textfield name="bean.directionid" cssClass="inputText"></s:textfield></td>
             
             <th>毕业生数：</th>
				<td>
					<select class="select2" name="bean.gradnumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.gradnumScope}">
								<option value='${bean.gradnumScope}'  selected="selected">${bean.gradnumScope}</option>
							</c:if>
							<c:if test="${bean.gradnumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.gradnumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.gradnumScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.gradnumScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.gradnumScope!='4000-5000'}">
								<option value="4000-5000">4000-5000</option>
							</c:if>
							<c:if test="${bean.gradnumScope!='5000以上'}">
								<option value="5000以上">5000以上</option>
							</c:if>
					</select>
				</td>	
				
				<th>获得证书的毕业生初级人数：</th>
				<td>
					<select class="select2" name="bean.juniornumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.juniornumScope}">
								<option value='${bean.juniornumScope}'  selected="selected">${bean.juniornumScope}</option>
							</c:if>
							<c:if test="${bean.juniornumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.juniornumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.juniornumScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.juniornumScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.juniornumScope!='4000-5000'}">
								<option value="4000-5000">4000-5000</option>
							</c:if>
							<c:if test="${bean.juniornumScope!='5000以上'}">
								<option value="5000以上">5000以上</option>
							</c:if>
					</select>
				</td>
				</tr>
				
				<tr>
				<th>获得证书的毕业生中级人数：</th>
				<td>
					<select class="select2" name="bean.midnumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.midnumScope}">
								<option value='${bean.midnumScope}'  selected="selected">${bean.midnumScope}</option>
							</c:if>
							<c:if test="${bean.midnumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.midnumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.midnumScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.midnumScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.midnumScope!='4000-5000'}">
								<option value="4000-5000">4000-5000</option>
							</c:if>
							<c:if test="${bean.midnumScope!='5000以上'}">
								<option value="5000以上">5000以上</option>
							</c:if>
					</select>
				</td>	
				
				<th>获得证书的毕业生高级人数：</th>
				<td>
					<select class="select2" name="bean.highnumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.highnumScope}">
								<option value='${bean.highnumScope}'  selected="selected">${bean.highnumScope}</option>
							</c:if>
							<c:if test="${bean.highnumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.highnumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.highnumScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.highnumScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.highnumScope!='4000-5000'}">
								<option value="4000-5000">4000-5000</option>
							</c:if>
							<c:if test="${bean.highnumScope!='5000以上'}">
								<option value="5000以上">5000以上</option>
							</c:if>
					</select>
				</td>	
				
				<th>获得证书的毕业生无等级人数：</th>
				<td>
					<select class="select2" name="bean.nogradenumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.nogradenumScope}">
								<option value='${bean.nogradenumScope}'  selected="selected">${bean.nogradenumScope}</option>
							</c:if>
							<c:if test="${bean.nogradenumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.nogradenumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.nogradenumScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.nogradenumScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.nogradenumScope!='4000-5000'}">
								<option value="4000-5000">4000-5000</option>
							</c:if>
							<c:if test="${bean.nogradenumScope!='5000以上'}">
								<option value="5000以上">5000以上</option>
							</c:if>
					</select>
				</td>
				</tr>
				
				<tr>
				<th>与专业相关的社会技术培训总数：</th>
				<td>
					<select class="select2" name="bean.trainingnumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.trainingnumScope}">
								<option value='${bean.trainingnumScope}'  selected="selected">${bean.trainingnumScope}</option>
							</c:if>
							<c:if test="${bean.trainingnumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.trainingnumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.trainingnumScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.trainingnumScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.trainingnumScope!='4000-5000'}">
								<option value="4000-5000">4000-5000</option>
							</c:if>
							<c:if test="${bean.trainingnumScope!='5000以上'}">
								<option value="5000以上">5000以上</option>
							</c:if>
					</select>
				</td>
             
             <!--
                <td>
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
                <th>毕业生数（人）</th>
                <th>初级证书人数（人）</th>
                <th>中级证书人数（人）</th>
                <th>高级证书人数（人）</th>
                <th>无等级证书人数（人）</th>
                <th>与专业相关的社会技术培训总数</th>
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
                   	<td>&nbsp;${item.DIRECTIONID}</td>
                   	<td>&nbsp;${item.GRADNUM}</td>
                   	<td>&nbsp;${item.JUNIORNUM}</td>
                   	<td>&nbsp;${item.MIDNUM}</td>
                   	<td>&nbsp;${item.HIGHNUM}</td>
                   	<td>&nbsp;${item.NOGRADENUM}</td>
                   	<td>&nbsp;${item.TRAININGNUM}</td>
                   	<td>&nbsp;${item.STATUS}</td>
                   	<%-- <td>&nbsp;${item.CREATEDBY}</td>
                   	<td>&nbsp;${item.CREATEDTIME}</td>
                   	<td>&nbsp;${item.UPDATEDBY}</td>
                   	<td>&nbsp;${item.UPDATEDTIME}</td>
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
