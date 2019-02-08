<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script type="text/javascript">
	$(function() {
		$(".toollist").find("a").bind("click", function() {
			var path = $(this).find("img").first().attr("src");
			var ctx = "${ctx}";
			var value = path.substr(ctx.length);
			if (frameElement && frameElement.api) {
				var api = frameElement.api, W = api.opener;
				W.initIcon(value);
				api.hide();
			} else {
				window.returnValue = value;
				window.close();
			}
		});
	});
</script>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="javascript:void(0);">首页</a></li>
			<li><a href="javascript:void(0);">工具箱</a></li>
		</ul>
	</div>
	<div class="dataGrid">

		<div class="formtitle">
			<span>一级菜单图标</span>
		</div>
		<div class="toolsli">
			<ul class="toollist">
				<c:forEach begin="1" end="26" var="item" varStatus="stat">
					<c:set var="img" value="${item}" />
					<c:if test="${item lt 10}">
						<c:set var="img" value="0${item}" />
					</c:if>
					<li>
						<a href="javascript:void(0);"><img src="${ctx }/skins/uimaker/images/icon${img}.png" /></a>
						<h2>icon${img}.png</h2>
					</li>
				</c:forEach>
			</ul>
		</div>

		<div class="formtitle">
			<span>二级菜单图标</span>
		</div>
		<div class="toolsli">
			<ul class="toollist">
				<c:forEach begin="1" end="56" var="item" varStatus="stat">
					<c:set var="img" value="${item}" />
					<c:if test="${item lt 10}">
						<c:set var="img" value="0${item}" />
					</c:if>
					<li>
						<a href="javascript:void(0);" style="width: 20px;height: 20px;">
							<img src="${ctx}/skins/uimaker/images/leftico${img}.png" />
						</a>
						<h2>leftico${img}.png</h2>
					</li>
				</c:forEach>
			</ul>
		</div>

	</div>
	<!-- dataGrid end -->
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>