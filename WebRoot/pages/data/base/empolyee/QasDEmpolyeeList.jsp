<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%
/**
*@date 2017-11-22 11:09:27
*@author upaths@gmail.com
*/
%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript" src="${ctx }/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript">
<!--
		function  opreate(args,opCode){
			var baseUrl = "${ctx}/data/base/empolyee/";
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
<form action="${ctx}/data/base/empolyee/queryList.action"   method="post" 
id="opForm" name="opForm">
	<s:hidden name="menuId" id="menuId" />
	<s:hidden name="bean.id" id="id" />
		<div class="filter">
 		<table>
            <tbody >
             <tr>
                <th>姓名名称：</th>
                <td><s:textfield name="bean.name" cssClass="inputText"></s:textfield></td>
                <td>
                <th>选择性别：</th>
                <td>
                   <select name="bean.sex" class="select2">
                 	<option value=''>--请选择--</option>
				    	<x:cache subject="10001" option="true" selected="${bean.sex }"></x:cache>
				   </select>
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
                <th width="40">序号</th>
               <!--  <th>教工唯一标识</th> -->
                <th>教工号</th>
                <th width="50">姓名</th>
                <th>性别</th>
                <th>所属系部</th>
                <th>所属专业</th>
                <!-- <th>民族</th>-- -->
                <th>职务</th>
                <!-- <th>职称</th>-- -->
                <th>学历</th>
             	<!--    <th>学位</th>-- -->
               <!--  <th>出生日期</th> -->
                <!-- <th>区号-电话号码</th> -->
               <!--  <th>电子邮箱</th>-->
              <!--   <th>工作经历简介</th> -->
           	<%--     <th>专业技术职务<-->等级</th>
                <th>专业技术职务<-->名称（全称）</th>
                <th>专业技术职务<-->发证单位</th>
                <th>专业技术职务<-->获取日期(年月)</th>
               <!--  <th>是否在编</th>
                <th>岗位职能</th>
                <th>科研成果</th>
                <th>分管工作</th>
                <th>教师类型</th>
                <th>专业领域</th>
                <th>专业特长</th>
                <th>有无高校教师资格证</th> -->
                <th>行业、企业一线工作时间<-->历年（年）</th>
                <th>行业、企业一线工作时间<-->本学年（天）</th>
                <th>职业资格证书<-->等级</th>
                <th>职业资格证书<-->名称(全称)</th>
                <th>职业资格证书<-->发证单位</th>
                <th>职业资格证书<-->获取日期（年月）</th>
                <th>高校教师资格证书<-->发证单位	</th>
                <th>高校教师资格证书<-->获取日期（年月）</th> --%>
              <!--   <th>是否专业教师</th>
                <th>是否为骨干教师</th>
                <th>是否为双师素质教师</th>
                <th>教学名师</th>
                <th>是否校企双导师</th>
                <th>是否企业导师</th>
                <th>互聘公培导师</th>
                <th>"千百十"人才培养等级</th>
                <th>珠江学者</th> -->
           <%--     <th>校外教师<-->参加工作日期（年月）</th>
                <th>校外教师<-->签约情况</th>
                <th>校外教师<-->当前专职工作背景<-->单位名称</th>
                <th>校外教师<-->当前专职工作背景<-->职务</th>
                <th>校外教师<-->当前专职工作背景<-->任职日期（年月）</th>--%>
               <!--  <th>状态</th>
                <th>创建人</th>
                <th>创建时间</th>
                <th>修改人</th>
                <th>修改时间</th>
                <th>租户</th> -->
                <!-- <th>入库时间（接口传输，导入）</th>  -->
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
                   	<%-- <td>&nbsp;${item.ID}</td> --%>
                   	<td>&nbsp;${item.EMPLOYEECODE}</td>
                    <td>&nbsp;${item.NAME}</td>
                    <c:if test="${item.SEX=='1'||item.SEX=='男'}">
						<td>&nbsp;男</td>
					</c:if>
                    <c:if test="${item.SEX=='2'||item.SEX=='女'}">
						<td>&nbsp;女</td>
					</c:if>
					<c:if test="${empty item.SEX}">
						<td>&nbsp;${item.SEX}</td>
					</c:if>
                   	<td>&nbsp;${item.DEPARTMENTID}</td>
                   	<td>&nbsp;${item.MAJORID}</td>
                   	
                   	
                   	<%-- <td>&nbsp;${item.NATION}</td> --%>
                   	<td>&nbsp;${item.DUTY}</td>
                   <%-- 	<td>&nbsp;${item.TITLE}</td> --%>
                   	<td>&nbsp;${item.QUALIFICATION}</td>
                   	<%-- <td>&nbsp;${item.ACADEMICDEGREE}</td> --%>
                   	
                   <%-- 	<td>&nbsp;${item.BIRTHDAY}</td> --%>
                   	<%-- <td>&nbsp;${item.PHONE}</td> --%>
               <%--     	<td>&nbsp;${item.EMAIL}</td>
                   	<td>&nbsp;${item.WORKEXPERIENCE}</td>
                   	<td>&nbsp;${item.MAJORDEEP}</td>
                   	<td>&nbsp;${item.HIGHMAJORNAME}</td>
                   	<td>&nbsp;${item.GRANTCOMPANY}</td>
                   	<td>&nbsp;${item.RECEIVEDDATE}</td>
                   	<td>&nbsp;${item.ISINPLAN}</td>
                   	<td>&nbsp;${item.POSTDUTY}</td>
                   	<td>&nbsp;${item.ACHIEVEMENT}</td>
                   	<td>&nbsp;${item.MANAGEWORK}</td>
                   	<td>&nbsp;${item.TEACHERTYPE}</td>
                   	<td>&nbsp;${item.SPECIALAREA}</td>
                   	<td>&nbsp;${item.SPECIALTY}</td>
                   	<td>&nbsp;${item.ISTEACHERDEGREE}</td>
                   	<td>&nbsp;${item.WORKYEAR}</td>
                   	<td>&nbsp;${item.WORKINCURRENTYEAR}</td>
                   	<td>&nbsp;${item.QUALIFICATIONLEVEL}</td>
                   	<td>&nbsp;${item.QUALIFICATIONNAME}</td>
                   	<td>&nbsp;${item.QUALIFICATIONUNIT}</td>
                   	<td>&nbsp;${item.QUALIFICATIONRECEIVEDATE}</td>
                   	<td>&nbsp;${item.TEACHERQUALIFICATIONUNIT}</td>
                   	<td>&nbsp;${item.TEACHERQUALIFICATIONRECEIVEDATE}</td>
                   	<td>&nbsp;${item.ISPROFESSIONALTEACHER}</td>
                   	<td>&nbsp;${item.ISCORETEACHER}</td>
                   	<td>&nbsp;${item.DOUBLEQUALIFIEDTEACHER}</td>
                   	<td>&nbsp;${item.FAMOUSTEACHER}</td>
                   	<td>&nbsp;${item.DUALMENTOR}</td>
                   	<td>&nbsp;${item.COMPANYMENTOR}</td>
                   	<td>&nbsp;${item.PUBLICTRAININGSUPERVISOR}</td>
                   	<td>&nbsp;${item.TRAININGLEVEL}</td>
                   	<td>&nbsp;${item.ISZHUJIANGSCHOLAR}</td>
                   	<td>&nbsp;${item.DATEOFWORK}</td>
                   	<td>&nbsp;${item.SIGNEDSTATUS}</td>
                   	<td>&nbsp;${item.BACKGROUNDUNIT}</td>
                   	<td>&nbsp;${item.BACKGROUNDDUTY}</td>
                   	<td>&nbsp;${item.BACKGROUNDAPPOINTMENTDATE}</td> --%>
                   	<%-- <td>&nbsp;${item.STATUS}</td> --%>
                   <%-- 	<td>&nbsp;${item.CREATEDBY}</td>
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
