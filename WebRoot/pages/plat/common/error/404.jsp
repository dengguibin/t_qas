<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/pages/t_qas/layout/header.jsp" %>
<script language="javascript">
	$(function(){
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
	$(window).resize(function(){  
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
    })  
	});  
</script> 

<body style="background:#edf6fa;">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:void(0);">首页</a></li>
    <li><a href="javascript:void(0);">404错误提示</a></li>
    </ul>
    </div>
    
    <div class="error">
    <h2>非常遗憾，您访问的页面不存在！</h2>
    <p>看到这个提示，就自认倒霉吧!</p>
    <div class="reindex"><a href="main.html" target="_parent">返回首页</a></div>
    </div>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>