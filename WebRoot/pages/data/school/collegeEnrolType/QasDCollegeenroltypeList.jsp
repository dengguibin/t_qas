<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:41:43
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/data/school/collegeEnrolType/";
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
<form action="${ctx}/data/school/collegeEnrolType/queryList.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.id" id="id" />
		<div class="filter" style="width: 100%;">
 		<table>
            <tbody >
             <tr>
             
             <!--
                <th>菜单名称：</th>
                <td><s:textfield name="bean.cdmc" cssClass="inputText"></s:textfield></td>
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
                	<th>全日制高职招生数 ：</th>
					<td>
					<select class="select2" name="bean.collegenumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.collegenumScope}">
								<option value='${bean.collegenumScope}'  selected="selected">${bean.collegenumScope}</option>
							</c:if>
							<c:if test="${bean.collegenumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.collegenumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.collegenumScope!='2000-4000'}">
								<option value="2000-4000">2000-4000</option>
							</c:if>
							<c:if test="${bean.collegenumScope!='4000-6000'}">
								<option value="4000-6000">4000-6000</option>
							</c:if>
							<c:if test="${bean.collegenumScope!='6000-10000'}">
								<option value="6000-10000">6000-10000</option>
							</c:if>
							<c:if test="${bean.collegenumScope!='10000以上'}">
								<option value="10000以上">10000以上</option>
							</c:if>
					</select>
				</td>	
					
					<th>基于高考的“知识+技能”招生数 ：</th>
					<td>
					<select class="select2" name="bean.seniorexamnumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.seniorexamnumScope}">
								<option value='${bean.seniorexamnumScope}'  selected="selected">${bean.seniorexamnumScope}</option>
							</c:if>
							<c:if test="${bean.seniorexamnumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.seniorexamnumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.seniorexamnumScope!='2000-4000'}">
								<option value="2000-4000">2000-4000</option>
							</c:if>
							<c:if test="${bean.seniorexamnumScope!='4000-6000'}">
								<option value="4000-6000">4000-6000</option>
							</c:if>
							<c:if test="${bean.seniorexamnumScope!='6000-10000'}">
								<option value="6000-10000">6000-10000</option>
							</c:if>
							<c:if test="${bean.seniorexamnumScope!='10000以上'}">
								<option value="10000以上">10000以上</option>
							</c:if>
					</select>
				</td>	
					
					<th>对口招生招生数 ：</th>
					<td>
					<select class="select2" name="bean.samepfsnumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.samepfsnumScope}">
								<option value='${bean.samepfsnumScope}'  selected="selected">${bean.samepfsnumScope}</option>
							</c:if>
							<c:if test="${bean.samepfsnumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.samepfsnumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.samepfsnumScope!='2000-4000'}">
								<option value="2000-4000">2000-4000</option>
							</c:if>
							<c:if test="${bean.samepfsnumScope!='4000-6000'}">
								<option value="4000-6000">4000-6000</option>
							</c:if>
							<c:if test="${bean.samepfsnumScope!='6000-10000'}">
								<option value="6000-10000">6000-10000</option>
							</c:if>
							<c:if test="${bean.samepfsnumScope!='10000以上'}">
								<option value="10000以上">10000以上</option>
							</c:if>
					</select>
				</td>	
					</tr>
					
					<tr>
					<th>单独考试招生招生数：</th>
					<td>
					<select class="select2" name="bean.singleexamnumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.singleexamnumScope}">
								<option value='${bean.singleexamnumScope}'  selected="selected">${bean.singleexamnumScope}</option>
							</c:if>
							<c:if test="${bean.singleexamnumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.singleexamnumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.singleexamnumScope!='2000-4000'}">
								<option value="2000-4000">2000-4000</option>
							</c:if>
							<c:if test="${bean.singleexamnumScope!='4000-6000'}">
								<option value="4000-6000">4000-6000</option>
							</c:if>
							<c:if test="${bean.singleexamnumScope!='6000-10000'}">
								<option value="6000-10000">6000-10000</option>
							</c:if>
							<c:if test="${bean.singleexamnumScope!='10000以上'}">
								<option value="10000以上">10000以上</option>
							</c:if>
					</select>
				</td>	
				
					<th>综合评价招生招生数：</th>
					<td>
					<select class="select2" name="bean.mulestimatenumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.mulestimatenumScope}">
								<option value='${bean.mulestimatenumScope}'  selected="selected">${bean.mulestimatenumScope}</option>
							</c:if>
							<c:if test="${bean.mulestimatenumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.mulestimatenumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.mulestimatenumScope!='2000-4000'}">
								<option value="2000-4000">2000-4000</option>
							</c:if>
							<c:if test="${bean.mulestimatenumScope!='4000-6000'}">
								<option value="4000-6000">4000-6000</option>
							</c:if>
							<c:if test="${bean.mulestimatenumScope!='6000-10000'}">
								<option value="6000-10000">6000-10000</option>
							</c:if>
							<c:if test="${bean.mulestimatenumScope!='10000以上'}">
								<option value="10000以上">10000以上</option>
							</c:if>
					</select>
				</td>	
					
					<th>中高职贯通的招生生数：</th>
					<td>
					<select class="select2" name="bean.midhigconnumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.midhigconnumScope}">
								<option value='${bean.midhigconnumScope}'  selected="selected">${bean.midhigconnumScope}</option>
							</c:if>
							<c:if test="${bean.midhigconnumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.midhigconnumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.midhigconnumScope!='2000-4000'}">
								<option value="2000-4000">2000-4000</option>
							</c:if>
							<c:if test="${bean.midhigconnumScope!='4000-6000'}">
								<option value="4000-6000">4000-6000</option>
							</c:if>
							<c:if test="${bean.midhigconnumScope!='6000-10000'}">
								<option value="6000-10000">6000-10000</option>
							</c:if>
							<c:if test="${bean.midhigconnumScope!='10000以上'}">
								<option value="10000以上">10000以上</option>
							</c:if>
					</select>
				</td>	
					</tr>
					
					<tr>
					<th>技能拔尖人才免试招生招生数 ：</th>
					<td>
					<select class="select2" name="bean.noexamnumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.noexamnumScope}">
								<option value='${bean.noexamnumScope}'  selected="selected">${bean.noexamnumScope}</option>
							</c:if>
							<c:if test="${bean.noexamnumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.noexamnumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.noexamnumScope!='2000-4000'}">
								<option value="2000-4000">2000-4000</option>
							</c:if>
							<c:if test="${bean.noexamnumScope!='4000-6000'}">
								<option value="4000-6000">4000-6000</option>
							</c:if>
							<c:if test="${bean.noexamnumScope!='6000-10000'}">
								<option value="6000-10000">6000-10000</option>
							</c:if>
							<c:if test="${bean.noexamnumScope!='10000以上'}">
								<option value="10000以上">10000以上</option>
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
               <!--  <th>记录标识</th> -->
                <th>全日制高职招生数</th>
                <th>基于高考的“知识+技能”招生数（人）</th>
                <th>对口招生<-->招生数（人）</th> 
                <th>单独考试招生<-->招生数（人）</th>
                <th>综合评价招生<-->招生数（人）</th>
                <th>中高职贯通的招生<-->招生数（人）</th>
                <th>技能拔尖人才免试招生<-->招生数（人）</th>
                <th>其他 <-->招生数（人）</th>
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
                   	<td>&nbsp;${item.COLLEGENUM}</td>
                   	<td>&nbsp;${item.SENIOREXAMNUM}</td>
                   	<td>&nbsp;${item.SAMEPFSNUM}</td>
                   	<td>&nbsp;${item.SINGLEEXAMNUM}</td>
                   	<td>&nbsp;${item.MULESTIMATENUM}</td>
                   	<td>&nbsp;${item.MIDHIGCONNUM}</td>
                   	<td>&nbsp;${item.NOEXAMNUM}</td>
                   	<td>&nbsp;${item.OTHERNUM}</td>
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
