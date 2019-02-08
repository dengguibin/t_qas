<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true"%>
<%@page import="com.upath.plat.common.exception.PlatformException"%>
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
    <li><a href="javascript:void(0);">平台</a></li>
    <li><a href="javascript:void(0);">系统出错</a></li>
    </ul>
    </div>
    
    <div class="error">
    <h2>对不起,你访问的功能出错啦！</h2>
    <p>看到这个提示，就自认倒霉吧!</p>
    </div>
</body>
<%@include file="/pages/t_qas/layout/footer.jsp" %>