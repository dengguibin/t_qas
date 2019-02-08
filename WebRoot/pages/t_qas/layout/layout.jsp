<%@page import="com.upath.plat.common.util.RequestHelper"%>
<%@page import="com.upath.plat.common.util.VTree"%>
<%@page import="java.util.List"%>
<%@page import="com.upath.plat.auth.facade.IUser"%>
<%@page import="com.upath.plat.common.util.SystemConfig"%>
<%@page pageEncoding="UTF-8" language="java"
	contentType="text/html;charset=UTF-8"%>
<%
	request.setAttribute("importStyle", false);
%>
<%
	request.setAttribute("importScript", false);
%>
<%@include file="/pages/plat/frame/header.jsp"%>
<link href="${ctx}/skins/uimaker/css/style.css" rel="stylesheet"
	type="text/css" />
<link
	href="${ctx}/scripts/plugins/select2-master/dist/css/select2.min.css"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/scripts/css/public.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/scripts/css/icon.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/skins/uimaker/css/top.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/skins/uimaker/css/analy.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet"
	href="${ctx}/scripts/plugins/layer-v3.1.0/layer/theme/default/layer.css" />
<script type="text/javascript" src="${ctx}/scripts/jquery-latest.js"></script>
<script type="text/javascript"
	src="${ctx}/scripts/jquery.layout-latest.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery-jtemplates.js"></script>
<script type="text/javascript"
	src="${ctx}/scripts/plugins/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript"
	src="${ctx}/scripts/plugins/select2-master/dist/js/select2.full.min.js"></script>
<script type="text/javascript"
	src="${ctx}/scripts/plugins/layer-v3.1.0/layer/layer.js"></script>
<!--兼容h5-->
<!--[if lt IE 9]
	<script type="text/javascript" src="${ctx}/scripts/js/common/html5shiv.min.js" ></script>
	<script type="text/javascript" src="${ctx}/scripts/js/common/respond.min.js" ></script>
<![endif]-->
<!-- 进行可以进行关闭的效果处理 -->
<style>
.ui-layout-toggler-west-closed {
	background: url(${ctx}/skins/uimaker/images/add.png) no-repeat center;
}

.ui-layout-resizer-west-closed {
	background: #D1E6FC url(${ctx}/skins/default/images/layout/resizer.png)
		0 0 repeat;
	border-right: 1px solid black;
}

.resizer-east-closed:hover {
	background: #f0f9fd;
}

.row.box {
	background: #f5f8f9;
}
</style>
<%
	IUser user = RequestHelper.getInstance().getLoginUser();
	List menus = user.getMenus();
	if (menus != null) {
		VTree vTree = VTree.buildVTree(menus, "menuId", "pcdid", null);
		List roots = vTree.getSons();//获取所有菜单模块的集合
		if (roots != null) {
			request.setAttribute("vRoots", roots);
			//打开 指定的模块
			//String moduleId = request.getParameter("moduleId");
			String moduleId = request.getParameter("menuId");
			VTree aRoot = null;//用于封装当前显示那个模块的树形结构
			if (moduleId != null && "".equals(moduleId) == false) {
				for (int i = 0; i < roots.size(); i++) {
					VTree cur = (VTree) roots.get(i);
					if (moduleId.equals(cur.getTid()) == true) {
						if (SystemConfig.ANALY_MENUID.equals(moduleId)) {
							List menuAnaly = user.getMenuAnaly();
							cur = new VTree().getCur(menuAnaly);
						}
						aRoot = cur;
						break;
					}
				}
			}
			if (aRoot == null) {//第一次来显示系统首页
				aRoot = (VTree) roots.get(0);
			}
			request.setAttribute("openRoot", aRoot);//当前显示那个模块的树形结构
			request.setAttribute("moduleId", aRoot.getTid());//当前显示那个模块的moduleId
		}
		request.setAttribute("roots", roots);//所有菜单模块的集合
		request.setAttribute("ANALY_MENUID", SystemConfig.ANALY_MENUID);//诊断分析模块的menuId

	}
%>
<body class="ui-layout-container" style="min-width:980px;">

	<c:if test="${not empty openRoot.sons[0]}">
		<c:set var="data" value="${openRoot.sons[0].sons[0].datas}" />
		<c:if test="${empty data}">
			<c:set var="data" value="${openRoot.sons[0].datas}" />
		</c:if>
		<c:set var="activeId" value="${data.menuId}" />
		<c:if test="${menuId == ANALY_MENUID}">
			<c:set var="activeId" value="${openRoot.sons[0].datas.menuId}" />
		</c:if>
		<c:if test="${not empty data.url}">
			<c:choose>
				<c:when test="${fn:indexOf(data.url,'?') gt -1}">
					<c:set var="openUrl" value="${data.url}&menuId=${activeId}" />
				</c:when>
				<c:when test="${menuId == ANALY_MENUID}">
					<c:set var="openUrl" value="${openRoot.sons[0].datas.url}" />
				</c:when>
				<c:otherwise>
					<c:set var="openUrl" value="${data.url}?menuId=${activeId}" />
				</c:otherwise>
			</c:choose>
		</c:if>
	</c:if>

	<input type="hidden" name="prevForm" id="prevForm">
	<!-- 
	${param.menuId }  通过指定的 菜单 ID 在系统加载的时候
-->
	<input type="hidden" name="menuId" id="openId" value="${param.menuId }">


	<c:forEach var="item" items="${roots}" varStatus="st">
		<c:set var="menu" value="${item.datas}" />
		<c:if test="${menu.menuId eq moduleId || empty menu.menuId}">
			<c:if test="${menu.ljlx != 2}">
				<!-- 顶部导航 -->
				<!-- 功能模块的默认图标 -->
				<c:set var="rootIcon" value="/skins/uimaker/images/icon17.png" />
				<div class="ui-layout-north"
					style="height: 88px;position: fixed !important;">
					<!-- 左上角 -->
					<div class="topleft clear">
						<span class="logo"> <a href="${ctx }" target="_parent"><img
								src="${ctx }/skins/uimaker/img/header/logo.png" title="系统首页" />
						</a> </span> <span class="logo-title czjz">${systemInfo.cname }</span>
						<!--<span class="logo-title czjz">高等职业院校内部质量保障信息化管理平台</span>-->
					</div>

					<!-- 功能模块 -->
					<ul class="nav">
						<c:forEach var="item" items="${roots}" varStatus="st">
							<c:set var="menu" value="${item.datas}" />
							<li>
								<%--<a href="${ctx}/main.action?moduleId=${menu.menuId}" ${menu.menuId eq moduleId ? 'class="selected"' : ''}> --%>
								<a href="${ctx}/main.action?menuId=${menu.menuId}" ${menu.menuId
								eq moduleId ? 'class="selected" ' : ''} ${menu.ljlx
								eq 2 ? 'target="_blank"' : ''}> <img width="48" height="48"
									src="${ctx}${empty menu.params ? rootIcon : menu.params}"
									title="${menu.menuName}" />
									<h2>${menu.menuName }</h2> </a></li>
						</c:forEach>
					</ul>

					<!-- 右上角 -->
					<div class="topright">
						<ul class="right-list clear">
							<!--<li class="warn-item">
							<i class="icon warn-icon">
								<b class="warn">1</b>
							</i>
						</li>-->
							<li class="msg-item" id="userMsg"><i class="icon msg-icon">
									<b class="msg">0</b> </i></li>
							<li class="user"><span> <img
									src="${ctx }/skins/uimaker/img/header/touxiang.png"
									title="${user.userName }" class="photo" /> <span
									class="username-b"> <span class="username">${user.userName
											}</span> <span class="arrow-down"></span> </span> </span>


								<ul class="user-opt clear">
									<li>
										<!--<span><img src="${ctx }/skins/uimaker/images/help.png" title="帮助"  class="helpimg"/></span>-->
										<a href="${ctx}/pages/help/index.html" target="_black">帮助</a>
									</li>
									<li><a href="javascript:openAbout();">关于</a>
									</li>
									<li><a href="javascript:void(0);" onclick="logout();">退出</a>
									</li>
								</ul></li>
						</ul>
					</div>

				</div>
			</c:if>
		</c:if>
	</c:forEach>

	<!-- 左侧导航 -->
	<!-- 当是系统首页类型的菜单不显示左侧的菜单,打开的URL以根URL指定为准 -->
	<c:choose>
		<c:when test="${openRoot.datas.type ne '9' }">
			<!-- 左侧菜单 显示 -->
			<div class="ui-layout-west" id="ui-west"
				style="background:#f0f9fd; width:187px;">
				<div class="lefttop" id="pinInfo">
					<a href="javascript:void();"><span id="west-closer"></span>
					</a>${openRoot.datas.menuName}
				</div>
				<div class="west-box">
					<dl class="leftmenu">
						<!-- 二级菜单 -->
						<c:forEach var="item" items="${openRoot.sons}" varStatus="stat">
							<c:set var="sMenu" value="${item.datas}" />
							<dd ${activeId eq sMenu.menuId ? 'class="active"
								' : ''} onclick="onMenuClick('${sMenu.menuId}')">
								<!--<div class="title">-->
								<!-- 二级菜单图标 -->
								<div ${activeId eq sMenu.menuId ? 'class="active title"
									' : 'class="title"'}>
									<c:set var="secIcon"
										value="/skins/uimaker/images/leftico01.png" />
									<!-- 菜单组默认图标 -->
									<c:set var="params"
										value="${ctx}${empty sMenu.params ? secIcon : sMenu.params}" />
									<input type="hidden" class="imag" value="${params}"> <span
										class="img"><img src="${params}" name="${params}" />
									</span> <span class="t-con">${sMenu.menuName}</span> <input
										type="hidden" id="info${sMenu.menuId}" cdid="${sMenu.menuId}"
										ljdz="${sMenu.url}" ljlx="${sMenu.ljlx}">
								</div>
								<c:if test="${not empty item.sons}">
									<ul class="menuson">
										<!-- 三级菜单 -->
										<c:forEach var="menuTree" items="${item.sons}"
											varStatus="vStat">
											<c:set var="menu" value="${menuTree.datas}" />
											<li ${activeId eq menu.menuId ? 'class="active"
												' : ''} onclick="onMenuClick('${menu.menuId}')">
												<%-- <!-- <cite></cite> 三级菜单图标 -->
		  				<a href="javascript:void(0);" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${menu.menuName}</a> --%>
												<!--<cite></cite>-->
												<!-- 三级菜单图标 --> <a href="javascript:void(0);">${menu.menuName}</a>
												<input type="hidden" id="info${menu.menuId}"
												cdid="${menu.menuId}" ljdz="${menu.url}" ljlx="${menu.ljlx}">
												<i></i></li>
										</c:forEach>
									</ul>
								</c:if>
							</dd>
						</c:forEach>
					</dl>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<c:if test="${not empty openRoot.datas.url}">
				<c:choose>
					<c:when test="${fn:indexOf(openRoot.datas.url,'?') gt -1}">
						<c:set var="openUrl"
							value="${openRoot.datas.url}&menuId=${moduleId}" />
					</c:when>
					<c:otherwise>
						<c:set var="openUrl"
							value="${openRoot.datas.url}?menuId=${moduleId}" />
					</c:otherwise>
				</c:choose>
			</c:if>
		</c:otherwise>
	</c:choose>





	<!-- 主要内容 -->
	<div class="ui-layout-center">
		<c:if test="${menuId == ANALY_MENUID}">
			<!-- 加上form表单只是为了方便回显 -->
			<!-- <form action="" method="post" id="opForm" name="opForm"> -->
			<!--最上面的搜索、手动诊断、导出-->
			<div class="search-box box row clear">
				<div class="col-lg-12">
					<div class="left content-l">
						<select class="in-select" id="in_case" name="${taskName}">
						</select> <select class="in-select" id="in_case2" style="width: 190px;"
							name="${datetime}">
						</select> <span class="sys-class" id="diagnoseobj"> <span
							class="sys-txt" id="objName">请选择诊断对象</span> <input type="hidden"
							id="diagnoseObjId" /> <span class="right menu-more"
							aria-hidden="更多"></span>
							<div class="sys-more" id="diagnoseObjChild"></div> </span>
					</div>
					<div class="right">
						<button class="analy-btn" onclick="excuteAnaly()">诊断分析</button>
						<button type="button" id="report" class="at-btn export-btn">
						<i class="icon export-icon"></i>
							<%-- <a href="###" id="report_a"><span class="col-3">导出报告</span></a>--%>
							<span class="col-3">导出报告</span>
						</button> 
	<%-- <a href="${ctx}/doc/诊断与改进报告-20180416643644.docx"><span class="col-3">导出报告</span></a> --%>
					</div>
				</div>
			</div>
			<!-- </form>	 -->
		</c:if>

		<iframe id='mainContent'
			style="padding: 0; margin: 0; position:relative;" name='mainFrame'
			height=${menuId eq ANALY_MENUID ? '93%' : '100%'} scrolling="yes"
			frameborder=0 width=100%> </iframe>
	</div>
	<c:if test="${menuId != ANALY_MENUID}">
		<c:set var="xmm" value="${ctx}" />
	</c:if>
	<c:if test="${menuId == ANALY_MENUID}">
		<c:set var="xmm" value="/analy" />
	</c:if>
	<!-- 首次展示的内容 -->
	<c:if test="${not empty openUrl}">
		<script type="text/javascript">
		$(document).ready(function(){
			$("#mainContent").attr("src","${xmm}${openUrl}");
		});
	</script>
	</c:if>

	<!-- 底部说明 -->
	<c:set var="emptyLink">javascript:void(0);</c:set>
	<div class="ui-layout-south">
		<div class="footer" style="text-align: center;">
			<!-- <span>${user.departMent.deptName }</span> -->
			<%-- <i>
	   		建设单位:
	   		<span style="display: inline-block;float: none;">
		   		<a target="_blank" href="${empty configs['SYSTEM_BUILD_UNIT_SITEINFO'] ? emptyLink : configs['SYSTEM_BUILD_UNIT_SITEINFO']}">
		   			${configs['SYSTEM_BUILD_UNIT']}
		   		</a>
	   		</span>
	   	</i>  --%>
			<i> 技术支持: <span style="display: inline-block;float: none;">
					<a target="_blank"
					href="${empty configs['SYSTEM_TECHNICAL_SUPPORT_SITEINFO'] ? emptyLink : configs['SYSTEM_TECHNICAL_SUPPORT_SITEINFO']}">
						${configs['SYSTEM_TECHNICAL_SUPPORT']} </a> </span> </i>
		</div>
	</div>

	<!-- loading 遮罩层 -->
	<div class="load-wrapper" id="loadingWrap">
		<div class="load-box">
			<span class="load-msg">搜索中</span> <img
				src="${ctx}/scripts/img/login/loading.gif" title="搜索中……" />
		</div>
	</div>

</body>

<script type="text/javascript">


var myLayout;
$(document).ready(function(){

	// CREATE THE LAYOUT
	myLayout = $('body').layout({
		resizeWhileDragging: 			true
	,	sizable:						false
	,	animatePaneSizing:				true
	,	fxSpeed:						'slow'
	,	west__size:						187
	,	spacing_open:					0
	,	spacing_closed:					0
	,	west__spacing_closed:			0
	,	west__spacing_open:				0
	,west: {
		size:					187
	,	spacing_closed:			21			// wider space when closed
	,	togglerLength_closed:	21			// make toggler 'square' - 21x21
	,	togglerAlign_closed:	"top"		// align to top of resizer
	,	togglerTip_open:		"隐藏导航菜单"
	,	togglerTip_closed:		"展开导航菜单"
	,	fxSettings_open:		{ easing: "easeOutBounce" }
	}
	});
	myLayout.addCloseBtn("#west-closer", "west");
});
var $imageobject;
$(function(){
	
	//校园名称的字体大小
	var len = $(".logo-title").html().length;
	var topH = $(".topleft").innerHeight();
	if(len <= 8){
		$(".topleft .logo-title").css("fontSize","18px");
	}else if(len == 12){
		$(".topleft .logo-title").css("fontSize","21px");
	}else if(len > 8 && len <= 18){
		$(".topleft .logo-title").css("fontSize","16px");
	}else if(len > 18 && len <= 30){
		$(".topleft .logo-title").css("fontSize","14px")
	}else{
		$(".topleft .logo-title").css("fontSize","12px")
	};
	var titleH = $(".topleft .logo-title").innerHeight();
	var marginTop = (topH - titleH) / 2;
	marginTop = marginTop > 0 ? marginTop : 0;
	$(".topleft .logo-title").css("marginTop",marginTop + "px");

	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active");
		$(this).addClass("active");
		$(this).parent().siblings(".title.active").removeClass("active");
	});
	$('.menuson').click(function(){
		if($imageobject){
			var subimage = $imageobject.children("span").children("img").attr("name");
			$imageobject.children("span").children("img").attr("src",subimage);
		}
	});
	$('.title').click(function(){
		//选中效果
		$(".leftmenu .title.active").removeClass('active');
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active")
		//二级图标切换
			var im=$(this).children("input.imag").val();//获取地址
			var ima=im.substring(35,37);//获取数字
			var imas=im.substring(37,41);//获取后缀
			var	imags=im.substring(0,35);//获取数字前的地址
			var image=ima*1+1//数字加1
		if($imageobject){
			var subimage = $imageobject.children("span").children("img").attr("name");
			$imageobject.children("span").children("img").attr("src",subimage);
		}
		if(image<10){
			var	imagee="0"+image
			var imagess=imags+imagee+imas;//拼接
		}else{ 
			var imagess=imags+image+imas;//拼接
		}
	    $(this).children("span").children("img").attr("src",imagess);//赋值
	    $imageobject = $(this);
		//下级菜单的slide
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
	trace();//系统消息处理
	window.setInterval("trace()", 1000 * 60);

	//最右边的三角形
	$(".topright .arrow-down").click(function() {
		if($(this).hasClass("arrow-up")) {
			$(this).removeClass("arrow-up");
			$(".topright .user-opt").hide();
		} else {
			$(this).addClass("arrow-up");
			$(".topright .user-opt").show();
		}
	});
	//下拉框
	$("#in_case,#in_case2").select2({
		width:'resolve',
		placeholder:'请选择',
		
	});
	
	if (${menuId == ANALY_MENUID}) {
		//下拉框==========  start  ==========
		var resultList;
		$.post("${ctx}/diagnose/diagnoseTask/toList.action", "", function(data) {
			resultList = data.obj;
			for (var i = 0; i < resultList.length; i++) {
				//回显
				if(resultList[i].id=="${taskId}"){
	   		 		$("#in_case").append("<option selected value='"+ resultList[i].id +"'>"+ resultList[i].taskname +"</option>"); 
	   		 	}else{
	   		 		$("#in_case").append("<option value='"+ resultList[i].id +"'>"+ resultList[i].taskname +"</option>"); 
	    	   }
	    	}
	    		diagnosetime();
	    		initDiagnoseObj();
		});
		//下拉框===========  end  ============ 
	}
	 $("#in_case").change(function(){
	    	 	diagnosetime();
	    	 	initDiagnoseObj();
	});
	
	//给诊断对象的选择绑定点击事件
	var boo = true;
	$("#diagnoseobj").click(function(e){
		if (boo) {
			$(".content-l .sys-class .sys-more").css({
				"display": "block"
			});
			$(".sys-class .menu-more").removeClass("down");
			$(".sys-class .menu-more").addClass("up");
			boo = false;
		} else {
			$(".content-l .sys-class .sys-more").css({
				"display": "none"
			});
			$(".sys-class .menu-more").removeClass("up");
			$(".sys-class .menu-more").addClass("dowm");
			boo = true;
		};
		//防止事件冒泡
		if(window.event){       //这是IE浏览器
            e.cancelBubble=true;//阻止冒泡事件
            e.returnValue=false;//阻止默认事件
            if(e.stopPropagation){
            	e.stopPropagation();//阻止冒泡事件
            	e.preventDefault();//阻止默认事件
            }
        }else if(e && e.stopPropagation){     //这是其他浏览器
            e.stopPropagation();//阻止冒泡事件
            e.preventDefault();//阻止默认事件
        }else{
        	e.stopPropagation();//阻止冒泡事件
            e.preventDefault();//阻止默认事件
        }
        
	});
	
	$(".sys-more").on("click",".sys-list>li",function(e){
		var txt = $(this).text();
		$(".sys-txt").text(txt);
		$(".content-l .sys-class .sys-more").css({
			"display": "none"
		});
		$(".sys-class .menu-more").removeClass("up");
		$(".sys-class .menu-more").addClass("dowm");
		boo = true;
		//防止事件冒泡
		if(window.event){       //这是IE浏览器
            e.cancelBubble=true;//阻止冒泡事件
            e.returnValue=false;//阻止默认事件
            if(e.stopPropagation){
            	e.stopPropagation();//阻止冒泡事件
            	e.preventDefault();//阻止默认事件
            }
        }else if(e && e.stopPropagation){     //这是其他浏览器
            e.stopPropagation();//阻止冒泡事件
            e.preventDefault();//阻止默认事件
        }else{
        	e.stopPropagation();//阻止冒泡事件
            e.preventDefault();//阻止默认事件
        };
	});
	
	//导出报告
	/* $.post("${ctx}/diagnose/analy/getDiagnoseReport.action", {"taskId":$("#in_case").val(),"datetime":$("#in_case2").find("option:selected").text(),"objName":$("#objName").text()}, function(data) {
		var idx = data.obj.indexOf("analy");
		var url = data.obj.slice(idx);
		url  = "../" + url;
		$("#report_a").attr("href",url);
			//E:/Analys/analy/pages/2018/06/12/task-B8387A3E66654FCC8B9200F9C366DE22/obj-12312323431231/15-14-20/20180612152104诊断报告.doc
		
	}); */
	
	$("#report").click(function(e){
		//防止事件冒泡
		if(window.event){       //这是IE浏览器
            e.cancelBubble=true;//阻止冒泡事件
            e.returnValue=false;//阻止默认事件
            if(e.stopPropagation){
            	e.stopPropagation();//阻止冒泡事件
            	e.preventDefault();//阻止默认事件
            }
        }else if(e && e.stopPropagation){     //这是其他浏览器
            e.stopPropagation();//阻止冒泡事件
            e.preventDefault();//阻止默认事件
        }else{
        	e.stopPropagation();//阻止冒泡事件
            e.preventDefault();//阻止默认事件
        };
       
        var objName = $("#objName").text();
       
        if(objName == "请选择诊断对象"){
        	alert("请选择诊断对象");
        	return;
        }
        
        $.post("${ctx}/diagnose/analy/getDiagnoseReport.action", {"taskId":$("#in_case").val(),"datetime":$("#in_case2").find("option:selected").text(),"objName":$("#objName").text()}, function(data) {
			
			
			if(url == null){
				alert("未诊断,请先诊断分析");
				return;
			}
			
			//var idx = data.obj.indexOf("analy");
			//var url = data.obj.slice(idx);
			var url = data.obj;
			url  = "../" + url;
			console.log(url)
			window.location = url;
			//var url = "../analy/pages/2018/06/14/task-B8387A3E66654FCC8B9200F9C366DE22/obj-12312312312444/14-07-19/20180614140724诊断报告.doc"
			//window.open(url);
			//console.log(window.location.href)
			//$("#report_a").attr("href",url);
				//E:/Analys/analy/pages/2018/06/12/task-B8387A3E66654FCC8B9200F9C366DE22/obj-12312323431231/15-14-20/20180612152104诊断报告.doc
			
		});
	})
	
	
});

//诊断时间
 function diagnosetime(){
	  	$("#in_case2").empty();
		$.post("${ctx}/diagnose/analy/queryInfo.action", {"diagnosetaskid":$("#in_case").val()}, function(data) {
			results = data.obj;
			for (var i = 0; i < results.length; i++) {
			//回显
			if(results[i].id=="${datetimeId}"){
	   		 	$("#in_case2").append("<option selected value='"+ results[i].id +"'>"+ results[i].diagnosedatatime +"</option>");
	   		  }else{
	   		 	$("#in_case2").append("<option value='"+ results[i].id +"'>"+ results[i].diagnosedatatime +"</option>");
	   		  }/*$("#in_case2").append("<option value='"+ results[i].diagnosedatatime+ "'>"+ results[i].diagnosedatatime +"</option>");  */
	    	}
		});
} 


//诊断对象初始化	
function initDiagnoseObj(){
	$.get("${ctx}/diagnose/analy/getDiagnoseObj.action",{"diagnosetaskid":$("#in_case").val()},function(result){
		var nodes = result.data;
		var html = $("#diagnoseObjChild");
		$(".sys-txt").text('请选择诊断对象');
		var str = "";
		for(var i in nodes){
			var node_i = nodes[i];//每个诊断对象
			str +="<div class='sys-m-list'>";
			if(node_i.parentName=='无父级'){//对象是顶级对象(比如学校或者省份)
				str +="<h5 class='sys-m-t' onclick='checkObj(\""+node_i.id+"\")' >"+node_i.diagnoseobjname;
			}else{
				str +="<h5 class='sys-m-t'>"+node_i.parentName;
			}
			str +=	"<i class='glyphicon glyphicon-menu-right'></i>";
			str +="</h5>";
			str +="<ul class='sys-list clear'>";
			
			if(node_i.parentName!='无父级'){
				str +="<li  onclick='checkObj(\""+node_i.diagnoseobjid+"\")'>"+node_i.diagnoseobjname+"</li>";
				if(node_i.diagnoseobjid=="${objId}" && "${taskId}"==$("#in_case").val()){
							$("#objName").text(node_i.diagnoseobjname);
						}
					delete nodes[i];
					for(var j in nodes){
						var node_j = nodes[j];
						if(node_i.parentName==node_j.parentName){
							str +="<li  onclick='checkObj(\""+node_j.diagnoseobjid+"\")'>"+node_j.diagnoseobjname+"</li>";
							//回显
							/* if(node_j.diagnoseobjid=="${objId}"){ */
							if(node_j.diagnoseobjid=="${objId}" && "${taskId}"==$("#in_case").val()){
								//$("#diagnoseObjChild").innerHTML(node_j.diagnoseobjname);
								$("#objName").text(node_j.diagnoseobjname);
							}
							delete nodes[j];
						};
					}
				}
				str +="</ul>";
				str +="</div>";
		}
		html.empty();
		if(str != ""){
			html.append(str);
		}else{
			html.append("没有关联对象");
		}
		//默认选中第一个对象，动态触发点击事件
		//$(".sys-m-list").eq(0).find("li").eq(0).trigger("click");
	});
}


//查询诊断分析左侧栏的列表信息
function checkObj(objId){
	var id = objId;
	var baseUrl = "${ctx}/main.action?menuId=${ANALY_MENUID}&objId="+objId+"&v=" + Math.random();
	var taskId = $("#in_case").val();
	var taskName = $("#in_case").find("option:selected").text();
	var datetimeId = $("#in_case2").val();
	var datetime = $("#in_case2").find("option:selected").text();
	//var objName=$("#diagnoseObjId").val();
	$("#diagnoseObjId").val(id);
	
	if(taskId==null || taskId==""){
		layer.msg("请先选择诊断任务！", {
					icon: 2,
					time:2500//2.5s后关闭
				});
		$("#in_case").focus(function(){
		  $("#in_case").css("background-color","#FFFFCC");
		});
		return;
	}
	if(datetime==null || datetime==""){
		layer.msg("请先对该象进行诊断分析！", {
					icon: 2,
					time:2500//2.5s后关闭
				});
		$("#in_case2").focus(function(){
		  $("#in_case2").css("background-color","#FFFFCC");
		});
		return;
	}
	if(objId==null || objId==""){
		return; 
	}
	//baseUrl+="&taskId="+taskId+"&datetimeId="+datetimeId;
	//$("#opForm").attr("action", baseUrl).submit();
	//baseUrl+="&taskId="+taskId+"&taskName="+taskName+"&datetimeId="+datetimeId+"&datetime="+datetime+"&objName="+objName;
	baseUrl+="&taskId="+taskId+"&taskName="+taskName+"&datetimeId="+datetimeId+"&datetime="+datetime;
	window.location.href=baseUrl;
}



//显示右上角的相关按钮
function showUserOpt() {
	if(!$(".topright .arrow-down").hasClass("arrow-up")) {
		$(this).addClass("arrow-up");
		$(".topright .user-opt").show();
	}
}

//隐藏右上角的相关按钮
function hideUserOpt() {
	if($(".topright .arrow-down").hasClass("arrow-up")) {
		$(this).removeClass("arrow-up");
		$(".topright .user-opt").hide();
	}
}

function onMenuClick(mId) {

	var treeNode = {};
	var queryId = "#info"+mId;
	treeNode['ljdz'] = $(queryId).attr("ljdz");
	treeNode['cdid'] = $(queryId).attr("cdid");
	treeNode['ljlx'] = $(queryId).attr("ljlx");
	
	if(treeNode.ljdz){
	
		var baseUrl = '${xmm}'+treeNode.ljdz;
		var queryStr = "menuId="+treeNode.cdid;
		var index = baseUrl.indexOf("?");
		
		if(index < 0){
			baseUrl += "?"+queryStr;
		}else{
			baseUrl += "&"+queryStr;
		}
		//系统内部打开		
		if(treeNode.ljlx == '1'){
			$("#mainContent").attr("src",baseUrl);	
		}else if(treeNode.ljlx == '3'){
			var newWin = window.open(baseUrl,treeNode.cdmc);
			if(newWin){
			 	newWin.moveTo(-4,-4);
				newWin.resizeTo(screen.availWidth+9,screen.availHeight+9);
			 	newWin.attachEvent("onbeforeunload",function(){
			 		/*callback handle*/
			 	});
			 	newWin.focus();
			}
		}else if(treeNode.ljlx == '4'){
			baseUrl = treeNode.ljdz;
			var queryStr = "menuId="+treeNode.cdid+"&userId=${user.userId }";
			var index = baseUrl.indexOf("?");
			if(index < 0){
				baseUrl += "?"+queryStr;
			}else{
				baseUrl += "&"+queryStr;
			}
			$("#mainContent").attr("src",baseUrl);			
		}
		//清空原来的注册表单信息，避免因为把上次操作的信息带入到下次操作	
		$("#prevForm").val('');	
	}
}
		
function logout(){
	var result = window.confirm("确定要退出系统吗？");
	var url = "${ctx}/auth/logout.action?v="+Math.random();
	if(result){
		window.location.href = url;
	}
}	

function openMessage(){
	var baseUrl ="${ctx}/plat/common/tCommonMessage!listUserSysMsgs.action";
	$.dialog({
		lock: true, 
		max: false, 
		min: false ,
		title:"系统消息查看",
		width:'620px',
		height:'420px',
		content: 'url:'+baseUrl,
		close :	function(){
			//更新下消息数据
			trace();
		}
	});
}

function openAbout(){
	var baseUrl ="${ctx}/pages/help/about.html";
	$.dialog({
		lock: true, 
		max: false, 
		min: false ,
		title:"关于",
		width:'420px',
		height:'300px',
		content: 'url:'+baseUrl
	});
}

//系统消息处理
function trace(){
	var url = "${ctx}/plat/common/tCommonMessage!queryUserMsgInfos.action?type=sign&v="+Math.random();
//	var html = "<span>${user.userName }</span><i>消息</i>";
	var html = "";
	$.ajax({
		type:"GET",
		dataType:'json',
		url:url,
		data:{},
		success:function(json){
			if(json){
				if(json.SYSTEM_UNREAD && json.SYSTEM_UNREAD > 0){
//					html += "<b id='msgNums' class='unread' onclick = 'openMessage()'>"+json.SYSTEM_UNREAD+"</b>";
					html += "<i class='icon msg-icon' onclick='openMessage()'><b id='msgNums' class='msg' >" + json.SYSTEM_UNREAD + "</b></i>"
				}else{
					html += "<i class='icon msg-icon' onclick='openMessage()'><b id='msgNums' class='msg' >0</b></i>"
				}
				$("#userMsg").html(html);
				 $("#msgNums").fadeOut(500).fadeIn(500); 
			}
		},
		error:function(req,text,error){
		
		}
	});
}
</script>
<script>
	$(document).ready(function(){
		//左边菜单栏的高度
		var _h = $(".west-box").parent(".ui-layout-west").innerHeight() - $(".lefttop").innerHeight();
		$(".west-box").css("height",_h + "px");
	});
	
	//打开loading
	function openLoad(title){
		$("#loadingWrap").find("span").text(title);
		$("#loadingWrap").find("img").attr("title",title+"……")
		$("#loadingWrap").show();
	}
	
	function closeLoad(){
		$("#loadingWrap").hide();
	}
//手动触发诊断分析
	function excuteAnaly(){
		layer.open({
		  content: '是否确定进行手动诊断？本次诊断需要3分钟左右！'
		  ,btn: ['确认', '取消']
		  ,yes: function(index, layero){
			  layer.close(index);
			  var taskId = $("#in_case").val();
				var objId = $("#diagnoseObjId").val();
				if(taskId==null || taskId==""){
					alert("请选择诊断任务！");
					return;
				}
				//var data = {"taskId":taskId,"objId":objId};
				var data = {"taskId":taskId};
				//调用最顶层页面的方法
				window.top.openLoad("诊断中，请稍后");
				$.post("${ctx}/diagnose/analy/excuteAnaly.action",data,function(result){
					if(result.success){
						//TODO 诊断之后的操作
						layer.msg(result.msg, {
							icon: 1,
							time:2500//1.5s后关闭
						});
						//window.location.href="${ctx}/main.action?menuId=${ANALY_MENUID}&v=" + Math.random();
					}else{
						layer.msg(result.msg, {
							icon: 2,
							time:2500//1.5s后关闭
						});
					}
					window.location.reload();
				});
		   
		  }
		});
	
	}
</script>
<%@include file="/pages/t_qas/layout/footer.jsp"%>
