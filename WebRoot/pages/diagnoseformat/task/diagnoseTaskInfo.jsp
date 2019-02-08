<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp"%>
<link rel="stylesheet" href="${ctx}/scripts/css/public.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/icon.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/dTasks.css" />
<body>
	<div class="title clear">
	<span>当前位置：</span>
	<x:menu menuId="${param.menuId}" />&gt;查看
	<span class="right return-box" onclick="self.location=document.referrer;">
		<i class="return-icon icon"></i>
		<a class="return" href="javascript:">返回</a> 
	</span>
</div>
	<div class="wrapper d-tasks-m d-tasks-d">
		<!--<div class="top">
			<div class="configure clear">
				<div class="left return" onclick="self.location=document.referrer;">
					<i class="return-icon icon"></i>
					<a class="return" href="javascript:">返回</a> 
				</div>
			</div>
		</div>-->

		<div class="d-t-m-con">
			<div class="row clear">
				<div class="row-l">
					
					<label>任务名称：</label>
				</div>
				<div class="row-r">
					<span class="label">${diagnosetask.taskname }</span>
				</div>
			</div>
			<div class="row clear">
				<div class="row-l">
					
					<label>模型类型：</label>
				</div>
				<div class="row-r">
					<s:hidden id="type" value="%{#request.type}"></s:hidden>
					<c:if test='${type eq 1 }'><span class="label">国家</span></c:if>
					<c:if test='${type eq 2 }'><span class="label">省级</span></c:if>
					<c:if test='${type eq 3 }'><span class="label">市级</span></c:if>
					<c:if test='${type eq 4 }'><span class="label">学校</span></c:if>
					<c:if test='${type eq 5 }'><span class="label">学院</span></c:if>
					<c:if test='${type eq 6 }'><span class="label">专业</span></c:if>
					<c:if test='${type eq 7 }'><span class="label">教师</span></c:if>
					<c:if test='${type eq 8 }'><span class="label">学生</span></c:if>
				</div>
			</div>
			
				<div>
				<div class="row clear">
					<div class="row-l">
						
						<label>可视角色：</label>
					</div>
					<div class="row-r">
						<s:hidden id="jsmc" value="%{#request.jsmc}"></s:hidden>
						<span class="label" id="jsmc">${request.jsmc }</span>
					</div>
				</div
			</div>
			
			<div class="row clear">
				<div class="row-l">
					
					<label>诊断模型：</label>
				</div>
				<div class="row-r">
					<s:hidden id="schemeid" value="%{#request.diagnosetask.schemeid}"></s:hidden>
					<span class="label" id="schemename">${diagnosescheme.schemename }</span>
				</div>
			</div>
			
			<div class="row clear">
				<div class="row-l">
					
					<label>诊断对象：</label>
				</div>
				<div class="row-r">
					<span class="label">${diagnosetaskobj.diagnoseobjname }</span>
					<!-- <span class="label col-3"> （2个） </span> -->
				</div>
			</div>
			
			<div class="row clear">
				<div class="row-l">
					
					<label>等级设置：</label>
				</div>
				<div class="row-r">
					<table style="table-layout: fixed;width: 50%;" class="d-t-m-table">
						<thead>
							<tr>
								<th width="50%">
									等级名称
								</th>
								<th width="50%">
									等级范围
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${diagnosetasklevels}" var="item"  varStatus="stat">
								<c:choose>
									<c:when test="${stat.index==0}">
										<tr>
											<td width="50%">
												<span class="qualified">${item.tasklevel }</span>
											</td>
											<td width="50%">
												<span>${item.leftvalue }</span>
												<span>≤x≤</span>
												<span>${item.rightvalue }</span>
											</td>
										</tr>
									</c:when>
									<c:when test="${stat.index< fn:length(diagnosetasklevels)-1&&stat.index>0}">
										<tr>
											<td width="50%">
											<c:if test="${stat.index==1 }">
												<span class="warn-txt2">${item.tasklevel }</span>
											</c:if>
											<c:if test="${stat.index==2 }">
												<span class="warn-txt3">${item.tasklevel }</span>
											</c:if>
											<c:if test="${stat.index==3 }">
												<span class="warn-txt4">${item.tasklevel }</span>
											</c:if>
											</td>
											<td width="50%">
												<span>${item.leftvalue }</span>
												<span>≤x<</span>
												<span>${item.rightvalue }</span>
											</td>
										</tr>
									</c:when>
									<c:when test="${stat.index== fn:length(diagnosetasklevels)-1}">
										<tr>
											<td width="50%">
												<span class="unqualified">${item.tasklevel }</span>
											</td>
											<td width="50%">
												<span>${item.leftvalue }</span>
												<span>≤x<</span>
												<span>${item.rightvalue }</span>
											</td>
										</tr>
									</c:when>
								</c:choose>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row clear">
				<div class="row-l">
					<label>自动诊断频率：</label>
				</div>
				<div class="row-r">
					<!--<select class="select" id="d_t_m_diagnosis" style="width: 230px;" disabled="disabled" class="disabled">
						<option>按月诊断</option>
						<option>按年诊断</option>
					</select>-->
					<span class="label">
						<c:if test='${diagnosetask.frequency eq 0}'>按月诊断</c:if>
						<c:if test='${diagnosetask.frequency eq 1}'>按学期诊断</c:if>
						<c:if test='${diagnosetask.frequency eq 2}'>按周诊断</c:if>
						<c:if test='${diagnosetask.frequency eq 3}'>按学年诊断</c:if>
					</span>
				</div>
			</div>

			<div class="row clear">
				<div class="row-l">
					
					<label>执行时段：</label>
				</div>
				<div class="row-r">
					<span><fmt:formatDate  value="${diagnosetask.starttime }" type="date" pattern="yyyy-MM-dd" /></span>
					<span class="date-pad">至</span>
					<span><fmt:formatDate  value="${diagnosetask.endtime }" type="date" pattern="yyyy-MM-dd" /></span>
				</div>
			</div>
		</div>

	</div>
	<script type="text/javascript">
	$(function(){
		$.get('${ctx}/diagnose/diagnosescheme/getSelectType.action',{"diagnose.rangetype":$("#type").val()},function(result){
			var list = result.obj;
			var option = "";
			var schemeid = $("#schemeid").val().trim();
			for(var i in list){
				if(schemeid == list[i].id){
					$("#schemename").text(list[i].schemename);
				}
			}
			$("#d_t_m_type").empty();
			$("#d_t_m_type").append(option);
		});	
	});
	</script>

</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>