<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 17:42:22
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/data/school/collegeInSchoolStudent/";
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
<form action="${ctx}/data/school/collegeInSchoolStudent/queryList.action"   method="post" 
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
                <th>折合在校生数：</th>
				<td>
					<select class="select2" name="bean.offnumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.offnumScope}">
								<option value='${bean.offnumScope}'  selected="selected">${bean.offnumScope}</option>
							</c:if>
							<c:if test="${bean.offnumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.offnumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.offnumScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.offnumScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.offnumScope!='4000以上'}">
								<option value="4000以上">4000以上</option>
							</c:if>
					</select>
				</td>	
				
				 <th>全日制学历教育在校生数：</th>
				<td>
					<select class="select2" name="bean.edustunumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.edustunumScope}">
								<option value='${bean.edustunumScope}'  selected="selected">${bean.edustunumScope}</option>
							</c:if>
							<c:if test="${bean.edustunumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.edustunumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.edustunumScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.edustunumScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.edustunumScope!='4000以上'}">
								<option value="4000以上">4000以上</option>
							</c:if>
					</select>
				</td>	
				
				 <th>全日制普通高职学历教育在校生总数：</th>
				<td>
					<select class="select2" name="bean.senioredustunumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.senioredustunumScope}">
								<option value='${bean.senioredustunumScope}'  selected="selected">${bean.senioredustunumScope}</option>
							</c:if>
							<c:if test="${bean.senioredustunumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.senioredustunumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.senioredustunumScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.senioredustunumScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.senioredustunumScope!='4000以上'}">
								<option value="4000以上">4000以上</option>
							</c:if>
					</select>
				</td>	
				</tr>
				
				<tr>
				 <th>全日制成人高职在校生：</th>
				<td>
					<select class="select2" name="bean.fulltimestufarmernumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.fulltimestufarmernumScope}">
								<option value='${bean.fulltimestufarmernumScope}'  selected="selected">${bean.fulltimestufarmernumScope}</option>
							</c:if>
							<c:if test="${bean.fulltimestufarmernumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.fulltimestufarmernumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.fulltimestufarmernumScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.fulltimestufarmernumScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.fulltimestufarmernumScope!='4000以上'}">
								<option value="4000以上">4000以上</option>
							</c:if>
					</select>
				</td>	
				
				 <th>全日制成人中职在校生：</th>
				<td>
					<select class="select2" name="bean.adultcollegestunumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.adultcollegestunumScope}">
								<option value='${bean.adultcollegestunumScope}'  selected="selected">${bean.adultcollegestunumScope}</option>
							</c:if>
							<c:if test="${bean.adultcollegestunumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.adultcollegestunumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.adultcollegestunumScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.adultcollegestunumScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.adultcollegestunumScope!='4000以上'}">
								<option value="4000以上">4000以上</option>
							</c:if>
					</select>
				</td>	
				
				 <th>非全日制专科学历教育注册生：</th>
				<td>
					<select class="select2" name="bean.parttimepfseduregnumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.parttimepfseduregnumScope}">
								<option value='${bean.parttimepfseduregnumScope}'  selected="selected">${bean.parttimepfseduregnumScope}</option>
							</c:if>
							<c:if test="${bean.parttimepfseduregnumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.parttimepfseduregnumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.parttimepfseduregnumScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.parttimepfseduregnumScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.parttimepfseduregnumScope!='4000以上'}">
								<option value="4000以上">4000以上</option>
							</c:if>
					</select>
				</td>	
				</tr>
				
				<tr>
				 <th>非全日制本科学历教育注册生：</th>
				<td>
					<select class="select2" name="bean.parttimesenioreduregnumScope">
							<option value='--请选择--'>--请选择--</option>
							<c:if test="${!empty bean.parttimesenioreduregnumScope}">
								<option value='${bean.parttimesenioreduregnumScope}'  selected="selected">${bean.parttimesenioreduregnumScope}</option>
							</c:if>
							<c:if test="${bean.parttimesenioreduregnumScope!='0-1000'}">
								<option value="0-1000">0-1000</option>
							</c:if>
							<c:if test="${bean.parttimesenioreduregnumScope!='1000-2000'}">
								<option value="1000-2000">1000-2000</option>
							</c:if>
							<c:if test="${bean.parttimesenioreduregnumScope!='2000-3000'}">
								<option value="2000-3000">2000-3000</option>
							</c:if>
							<c:if test="${bean.parttimesenioreduregnumScope!='3000-4000'}">
								<option value="3000-4000">3000-4000</option>
							</c:if>
							<c:if test="${bean.parttimesenioreduregnumScope!='4000以上'}">
								<option value="4000以上">4000以上</option>
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
                <th>折合在校生数（人）</th>
                <th>全日制学历教育在校生数（人）</th>
                <th>全日制普通高职学历教育在校生总数（人）</th>
                <!-- <th>其中--高中起点</th>
                <th>其中--中职起点--合计</th>
                <th>其中--中职起点--五年制后二年</th>
                <th>其中--其他</th>
                <th>全日制普通中职学历教育在校生（人)--合计</th>
                <th>全日制普通中职学历教育在校生（人)--五年制前三年</th>
                <th>全日制普通中职学历教育在校生（人)--新型职业农民</th> -->
                <th>全日制成人高职在校生（人）</th>
                <th>全日制成人中职在校生（人）</th>
                <th>非全日制专科学历教育注册生（人）</th>
                <th>非全日制本科学历教育注册生（人）</th>
                <!-- <th>培训(人天)--社会</th>
                <th>培训(人天)--在校生</th>
                <th>培训对象（人次）--特定群体</th>
                <th>培训对象（人次）--小微企业</th>
                <th>留学生数--境外</th>
                <th>留学生数--国外</th> -->
                <!-- <th>预科生、进修生、成人脱产班学生数合计</th> -->
                <!-- <th>夜大（业余）学生数</th>
                <th>函授生数</th> -->
                <th>状态</th>
             <!--    <th>创建人</th>
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
                   	<!--<td>&nbsp;${item.ID}</td>
                   	-->
                   	<td>&nbsp;${item.OFFNUM}</td>
                   	<td>&nbsp;${item.EDUSTUNUM}</td>
                   	<td>&nbsp;${item.SENIOREDUSTUNUM}</td>
                   	<!--<td>&nbsp;${item.HIGHTPFSSTUNUM}</td>
                   	<td>&nbsp;${item.MIDDLEPFSSTUNUM}</td>
                   	<td>&nbsp;${item.MIDDLESCHTWOYEARBEHANDNUM}</td>
                   	<td>&nbsp;${item.OTHERNUM}</td>
                   	<td>&nbsp;${item.FULLTIMESTUNUM}</td>
                   	<td>&nbsp;${item.FULLTIMESTUTHREEYEARBEFORENUM}</td>
                   	<td>&nbsp;${item.FULLTIMESTUFARMERNUM}</td>
                   	-->
                   	<td>&nbsp;${item.ADULTCOLLEGESTUNUM}</td>
                   	<td>&nbsp;${item.ADULTMIDDLESTUNUM}</td>
                   	<td>&nbsp;${item.PARTTIMEPFSEDUREGNUM}</td>
                   	<td>&nbsp;${item.PARTTIMESENIOREDUREGNUM}</td>
                   	<!--<td>&nbsp;${item.TRAINSOCIETYNUM}</td>
                   	<td>&nbsp;${item.TRAINSTUNUM}</td>
                   	<td>&nbsp;${item.TRAINSPECIFICGROUP}</td>
                   	<td>&nbsp;${item.TRAINSMALLCOMPANY}</td>
                   	<td>&nbsp;${item.OVERSEA}</td>
                   	<td>&nbsp;${item.ABROAD}</td>
                   	<td>&nbsp;${item.ADULTSTUDENT}</td>
                   	<td>&nbsp;${item.EVENINGUNIVERSITYSTUDENT}</td>
                   	<td>&nbsp;${item.CORRESPONDENCESTUDENT}</td>
                   	-->
                   	<td>&nbsp;${item.STATUS}</td>
                   	<!--<td>&nbsp;${item.CREATEDBY}</td>
                   	<td>&nbsp;<fmt:formatDate value="${item.CREATEDTIME}" pattern="yyyy-MM-dd"/> </td>
                   	<td>&nbsp;${item.UPDATEDBY}</td>
                   	<td>&nbsp;<fmt:formatDate value="${item.UPDATEDTIME}" pattern="yyyy-MM-dd"/></td>
                   	<td>&nbsp;${item.TENANTID}</td>
                   	<td>&nbsp;${item.STORAGETIME}</td>
                 	 -->
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
