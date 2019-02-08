<%@ page pageEncoding="UTF-8" language="java"
	contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp"%>
<!--<link rel="stylesheet" href="${ctx}/scripts/css/style.css" type="text/css" />-->
<link rel="stylesheet"
	href="${ctx}/scripts/plugins/layer-v3.1.0/layer/theme/default/layer.css" />
<link rel="stylesheet"
	href="${ctx}/scripts/plugins/select2-master/dist/css/select2.min.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/public.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/icon.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/diagnoseScheme.css" />
<script type="text/javascript"
	src="${ctx}/scripts/plugins/layer-v3.1.0/layer/layer.js"></script>
<script type="text/javascript"
	src="${ctx}/scripts/plugins/select2-master/dist/js/select2.full.min.js"></script>
<script type="text/javascript"
	src="${ctx}/scripts/js/diagnose/diagnoseSchemeList.js"></script>
<body>
	<div class="title">
		<span>当前位置：</span>
		<x:menu menuId="${param.menuId}" />
		<s:hidden id="menuId" value="%{#request.menuId}"></s:hidden>
	</div>
	<div class="dataGrid">
		<form action="${ctx}/diagnose/diagnosescheme/queryList.action"
			method="post" id="opForm" name="opForm">
			<s:hidden name="menuId" id="menuId" />
			<s:hidden name="diagnose.id" id="id" />
			<div class="wrapper d-program">
				<div class="top clear">
					<div class="left">
						<span class="add-temp cancel" id="add_program" target="rightFrame">+
							添加模型</span>
					</div>
					<div class="right sort-btn">
						<i class="icon sort-icon"></i>
						<div class="sort-list">
							<ul>
								<li onclick="opreate('time','queryList');">时间排序
									<input id="updatedtime" name="diagnose.updatedtime" class="search-input" />
								</li>
								<li onclick="opreate('type','queryList');">分类排序
									<input id="rangetype" name="diagnose.rangetype" class="search-input" />
								</li>
							</ul>
							<!-- <select name='diagnose.rangetype'>
										<option value ="">分类排序</option>
										<option value ="0">学校</option>
										<option value ="1">学院</option>
										<option value ="2">专业</option>
									</select> -->
							<!-- <span class="search-icon icon"  onclick="opreate('','query');"></span> -->
						</div>
					</div>
					<div class="right">
						<div class="search-box">
							<input type="text" name="diagnose.schemename"
								placeholder="指标名称/关键字搜索" value="${ diagnose.schemename}"
								class="search-input" /> <span class="search-icon icon"
								onclick="opreate('','query');"></span>
						</div>
					</div>
				</div>

					<div class="list"id="in_list">
						<c:forEach var="maps" items="${maps}">

							<div class="year-t" style="width:1040px">
								<i class="tubiao1"></i>
								<c:set var="leixing" value="${maps.key}"/>
								<c:if test="${leixing == '' || leixing == 'null'}">
									<c:set var="leixing" value="其他"/>
								</c:if>
								<h6 class="year-t-1">${leixing}</h6>
								<span style="color:#a9a9a9">点击展开全部</span>
								<input type="hidden" value="0">
							</div>
								<div class="row clear" >
							<c:forEach var="v" items="${maps.value}" varStatus="status">
									<div 
								<c:choose>
									<c:when test="${v.rangetype =='1'}">
										class="row-l in-list-item d-country-i"
									</c:when>
									<c:when test="${v.rangetype =='2'}">
										class="row-l in-list-item d-province-i"
									</c:when>
									<c:when test="${v.rangetype =='3'}">
										class="row-l in-list-item d-city-i"
									</c:when>
									<c:when test="${v.rangetype =='4'}">
										class="row-l in-list-item d-school-i"
									</c:when>
									<c:when test="${v.rangetype =='5'}">
										class="row-l in-list-item d-college-i"
									</c:when>
									<c:when test="${v.rangetype =='6'}">
										class="row-l in-list-item d-specialty-i"
									</c:when>
									<c:when test="${v.rangetype =='7'}">
										class="row-l in-list-item d-curriculum-i"
									</c:when>
									<c:when test="${v.rangetype =='8'}">
										class="row-l in-list-item d-teacher-i"
									</c:when>
									<c:when test="${v.rangetype =='9'}">
										class="row-l in-list-item d-student-i"
									</c:when>
									<c:otherwise>
										class="row-l in-list-item d-default-i"
									</c:otherwise>
								</c:choose>
								<c:if test="${status.count>3 }"> style="display:none"</c:if>
										>
									<!--  <div class="row-l in-list-item d-teacher-i"> -->
										<div class="content">
											<h5 class="title-1">
												<span class="draft"><c:if test="${v.status !=1 }">【草稿】</c:if>
												</span>${v.schemename }
											</h5>
											<p class="time">
												创建时间：
												<fmt:formatDate value="${v.createdtime }" pattern="yyyy-MM-dd HH:mm:ss"/>
											</p>
											<div class="btn-list hide">
													<c:if test="${v.status ==1 }">
														<a class="modify-t" href="toEdit.action?id=${v.id }&menuId=${param.menuId}">查看</a>
													</c:if>
													<c:if test="${v.status ==0 }">
														<a class="modify-t" href="toEdit.action?id=${v.id }&menuId=${param.menuId}">修改</a>
													</c:if>
												<a class="delect-t" href="javascript:;"
													onclick="del(this,'${v.id }')">删除</a>
											</div>
										</div>
									</div>
							</c:forEach>
								</div>
						</c:forEach>
					</div>

					<!--加载更多 暂无更多数据-->
					<%--<div class="list-btn">
						<div class="list-btn-b">
							<i class="icon-more"></i>
							<span>加载更多</span>
						</div>
						<div class="list-btn-b">
							<i class="icon-none"></i>
							<span>暂无更多数据</span>
						</div>
					</div>
					--%>
				</div>
			</div>
		</form>

	</div>
</body>