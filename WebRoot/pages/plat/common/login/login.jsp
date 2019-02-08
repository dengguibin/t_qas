<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/tld/x.tld"  prefix="x"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%> 
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%> 
<%@ taglib uri="/WEB-INF/tld/sql.tld" prefix="sql"%> 
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<c:set var="base" value="<%=request.getRequestURI() %>"/>
<%
/**
*@date 2012-10-28 12:51:07
*@author upaths@gmail.com
*/
%>
<x:cache subject="SYSTEMS" var="systemInfos"/>
<c:if test="${not empty  systemInfos}"><c:set var="systemInfo" value="${systemInfos[0] }"/></c:if> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="MSThemeCompatible" content="no" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="description" content="upath" />
<Meta http-equiv="Page-Enter" Content="blendTrans(Duration=0.5)"/> 
<meta http-equiv="keywords" content="系统登陆页" /> 
<meta http-equiv="description" content="upath" />
<title>欢迎登录${systemInfo.cname }</title>
<link rel="stylesheet" href="${ctx}/scripts/css/style.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/public.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/icon.css" />
<link rel="stylesheet" href="${ctx}/scripts/css/login.css" />
<script type="text/javascript" src="${ctx}/scripts/js/jquery.min.js" ></script>
<!--[if lt IE 9]
<script type="text/javascript" src="${ctx}/scripts/js/common/html5shiv.min.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/js/common/respond.min.js" ></script>
<![endif]-->
</head>
	<body>
		<div class="login-box clear">
			<div class="left">
				<div>
					<div class="login-t">
						<span class="logo">
								<img src="${ctx}/scripts/img/login/logo.png" title="首页" />
						</span>
						<span class="logo-title czjz">
							<span class="line"></span>
							${systemInfo.cname }
						</span>
					</div>
					<div class="login-form">
						<span style="align-content: center;color: red;">${msg}</span>
						<form action="${ctx }/login.do" id="opForm" action="auth" name="opForm" method="post">
							<div class="item">
								<span class="user-icon"></span>
								<input name="userId"  type="text" placeholder="请输入用户名" value="${param.userId }"/>
							</div>
							<div class="item">
								<span class="psw-icon"></span>
								<input name="password"  type="password" placeholder="请输入密码"/>
							</div>
							<c:if test="${not empty _OPEN }">
							<div class="item clear">
								<span class="yzm-icon"></span>
							    <span class="yzm-b-1">
								    <input name="code" type="text" value="" maxlength="4" placeholder="请输入验证码"/>
								   	<em  class="valid" title="验证码不能为空，并且长度为必须为4位。" lang="s4-4" ></em>
								</span>
								<span class="yzm-b-2">
									<img onclick="nextCode()" title="点击换一张图片" width="80" id="imgCode" src="${ctx }/login.do?type=code&v" height="32" >
								</span>
						    </div>
						    </c:if>
							<%--<div class="item-c">
								<input type="checkbox" />
								<span>记住密码</span>
							</div>
							--%><div class="item-btn">
								<input type="submit" value="登录" class="login-btn" />
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="right">
				<ul class="banner clear">
					<li class="first">
						<div class="img">
							<img src="${ctx}/scripts/img/login/cloudPlatform.png" />
						</div>
						<div class="comment">
							<h5>教学质量诊断平台</h5>
							<p>丰富的诊断指标模板</p>
							<p>可配置的诊断方案</p>
						</div>
					</li>
					<li>
						<div class="img">
							<img src="${ctx}/scripts/img/login/report.png" />
						</div>
						<div class="comment">
							<h5>教学质量诊断平台</h5>
							<p>可配置多样化报表信息</p>
							<p>可生成丰富的报表</p>
						</div>
					</li>
					<li>
						<div class="img">
							<img src="${ctx}/scripts/img/login/diaPlatform.png" />
						</div>
						<div class="comment">
							<h5>教学质量诊断平台</h5>
							<p>多种数据集成、融合分析</p>
							<p>可进行多层次多角度的诊断分析</p>
						</div>
					</li>
				</ul>
				<ol class="item-tab"></ol>
			</div>
		</div>
		<script>
			$(document).ready(function(){
				var _h = $(".left").innerHeight() - $(".left>div").innerHeight();
				$(".left>div").css({
					"marginTop":_h / 2 + "px"
				});
				
				var _w = $(".item").innerWidth() - $(".yzm-b-2").innerWidth() - 40 -20;
				$(".item .yzm-b-1>input").css("width",_w + "px");
				
				//输入框获得焦点的样式
				$(".item input").focus(function(){
					$(".item").removeClass("input-focus");
					$(this).parents(".item").addClass("input-focus");
				})
			})
		</script>
		<script>
			$(document).ready(function() {
			 if (top != window) {
      			top.location.href = window.location.href;  
    		  } 
				
				//页面加载完毕才执行
				var _wt = $(".login-t").innerWidth();
				var _wlogo = $(".login-t>.logo").innerWidth();
				$(".login-t>.logo-title").css({
					"width":_wt - _wlogo - 30 + "px",
					"top":0,
					"paddingLeft": _wlogo + 20 + "px"
				});
				$(".login-t>.logo-title>.line").css({
					"left": _wlogo + 10 + "px"
				});
				var _ht  = $(".login-t").innerHeight();
				var _hlogo = $(".login-t>.logo").innerHeight();
				var _top = (_ht - _hlogo) / 2;
				_top = _top ? _top : 0;
				$(".login-t>.logo").css({
					"top":_top + "px" 
				});
				
				var li_count = $(".banner li").length;
				$(".banner").append($(".first").clone());
					//创建节点
				//轮播圆点按钮节点
				for(var j = 0; j < li_count; j++) {
					if(j == 0) {
						$('.item-tab').append('<li class="current"></li>');
					} else {
						$('.item-tab').append('<li></li>');
					}
				}
				$('.banner').css('width', (li_count + 1) * 100 + '%');
				$('.item-tab').css('width', li_count * 60 + 'px');
				$('.item-tab').css('margin-left', -li_count * 60 * 0.5  + 'px');
						
				var num = 0;
				//获取窗口宽度
				var liWidth = $(".right").width();
				var liHeight = $(".right").height();
				$('.banner li').css({
					width: liWidth,
					height: liHeight 
				});
				$('.banner li').width(liWidth);
				//轮播点
				$('.item-tab li').mouseover(function() {
					$(this).addClass('current').siblings().removeClass('current');
					var i = $(this).index();
					$('.banner').stop().animate({
						left: -i * liWidth
					}, 500);
					num = i;
					
				});
				//自动播放
				var timer = null;
				function prevPlay() {
					num--;
					if(num < 0) {
						$('.banner').css({
							left: -liWidth * li_count
						}).stop().animate({
							left: -liWidth * (li_count - 1)
						}, 500);
						num = li_count - 1;
					} else {
						$('.banner').stop().animate({
							left: -num * liWidth
						}, 500);
					}
					if(num == li_count - 1) {
						$('.item-tab li').eq(li_count - 1).addClass('current').siblings().removeClass('current');
					} else {
						$('.item-tab li').eq(num).addClass('current').siblings().removeClass('current');
					}
					
				}
				
				function nextPlay() {
					num++;
					if(num > li_count) {
						//播放到最后一张(复制页)后,悄悄地把图片跳到第一张,因为和第一张相同,所以难以发觉,
						$('.banner').css({
							left: 0
						}).stop().animate({
							left: -liWidth
						}, 500);
						num = 1;
					} else {
						$('.banner').stop().animate({
							left: -num * liWidth
						}, 500);
					}
					if(num == li_count) {
						$('.item-tab li').eq(0).addClass('current').siblings().removeClass('current');
					} else {
						$('.item-tab li').eq(num).addClass('current').siblings().removeClass('current');
					}
					
				}
				timer = setInterval(nextPlay, 2000);
			});
			
			function nextCode(){
				var url = "${ctx }/login.do?type=code&v="+Math.random();
				$("#imgCode").attr("src",url);
			}
		</script>
	</body>
</html>