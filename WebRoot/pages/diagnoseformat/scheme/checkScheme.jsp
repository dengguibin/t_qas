<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp"%>
<link rel="stylesheet" href="${ctx}/scripts/css/icon.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/diagnosis.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/checkScheme.css" />
<body>
	<form action="${ctx}/diagnose/diagnosescheme/checkScheme.action"   method="post" 
	id="opForm" name="opForm">
	<div class="wrapper in-temp">
		<div class="top">
			<div class="search-box">
				<input type="hidden" name="diagnose.id" id="diagnoseid">
				<input type="hidden" name="diagnose.rangetype" id="rangetype">
				<input type="text" placeholder="指标名称/关键字搜索" name="diagnose.schemename" value="${ diagnose.schemename}" class="search-input" />
				<span class="search-icon icon" onclick="opreate('','query');"></span>
			</div>
		</div>
		<div class="list">
			<!--这里是分类排序-->
			<div class="row clear" id="model_list">
				<!-- 两栏栏布局，顺序row-l row-r -->
				<s:hidden id="id"></s:hidden>
				<s:iterator value="datas" id="d">
					<input type="hidden" value="${d.rangetype}" id="range">
					<div class="row-l" onclick="check('${d.id }',this)">
						<div class="in-list-box">
							<div 
						<c:choose>
							<c:when test="${d.rangetype =='1'}">
								class="in-list-item country-i"
							</c:when>
							<c:when test="${d.rangetype =='2'}">
								class="in-list-item province-i"
							</c:when>
							<c:when test="${d.rangetype =='3'}">
								class="in-list-item city-i"
							</c:when>
							<c:when test="${d.rangetype =='4'}">
								class="in-list-item school-i"
							</c:when>
							<c:when test="${d.rangetype =='5'}">
								class="in-list-item college-i"
							</c:when>
							<c:when test="${d.rangetype =='6'}">
								class="in-list-item specialty-i"
							</c:when>
							<c:when test="${d.rangetype =='7'}">
								class="in-list-item curriculum-i"
							</c:when>
							<c:when test="${d.rangetype =='8'}">
								class="in-list-item teacher-i"
							</c:when>
							<c:when test="${d.rangetype =='9'}">
								class="in-list-item student-i"
							</c:when>
							<c:otherwise>
								class="in-list-item default-i"
							</c:otherwise>
						</c:choose>
								>
							<!--  <div class="in-list-item country-i"> -->
								<div class="content">
									<h5 class="title">${d.schemename }</h5>
									<p class="time">创建时间：<s:property value="#d.createdtime"/>&nbsp;&nbsp;&nbsp;
									<c:if test="${d.status =='1'}"><span style="color:#7FFF00">已发布</span></c:if>
									<c:if test="${d.status =='0'}"><span style="color:#ff0000">未发布</span></c:if></p>
								</div>
							</div>
						</div>
					</div>
				</s:iterator>
			</div>
		</div>
	</div>
	</form>
	<script>
		$(document).ready(function(){
			var _w = $(".search-box").innerWidth() - 34;
			$(".in-temp .search-box>input").css({
				"width":_w + "px",
				"background":"#fff"
			})
			
			 
		})
		function check(id,obj){
			//onclick函数本身this指向的是window，而不是节点本身，需要传入一个this的参数
			$("#id").val(id);
			$(".in-list-box").removeClass("select");
			$(obj).find(".in-list-box").addClass("select");
		}
		
		//回车搜索
			$(document).keydown(function(e) {
			if(e.keyCode == 13) {
				opreate('','query');
			}
		});

		function  opreate(args,opCode){
			var diagnoseid = $('#diagnoseid',window.parent.document).val();
			var rangetype = $("#range").val();
			$("#rangetype").val(rangetype);
			$("#diagnoseid").val(diagnoseid);
			var baseUrl = "${ctx}/diagnose/diagnosescheme/";
			//加上随机请求参数，防止浏览器缓存显示数据不正确
			var query = "?bean.id="+args+"&v="+Math.random();
			if('queryList' === opCode){
				baseUrl += "checkScheme.action";
				$("#id").val(args);
				$("#opForm").attr("action",baseUrl).submit();
			}else if('query' === opCode){
				$("#opForm").submit();
			}
		}
			
		function saveScheme(schemeid){
			var id = $("#id").val();
			//获取模板的id进行对比
			$.post('${ctx }/diagnose/diagnosescheme/queryInfo.action',{'diagnose.id':schemeid},function(diagnose){
				if(id == diagnose.sourceschemeid){
					alert("已经选择过这个模板不能重复选择");
				}else{
					$.post('$(ctx)/diagnose/diagnosescheme/addScheme.action',{'id':id,'schemeId':schemeid},function(result){
				    	if(result.success){
				    		alert(result.msg);
				    		var boo = result.data.boo;
				    		if (!(null != boo && boo == false)) {
							   	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							   	window.parent.loadTreeData('$(ctx)/diagnose/diagnosescheme/getTree.action');
							   	parent.layer.close(index); //再执行关闭
							}
				    	}
				    });
				}
	 		});
			
		}
	</script>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>