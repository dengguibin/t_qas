<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="com.upath.plat.common.util.SystemConfig"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/tld/x.tld"  prefix="x"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%> 
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%> 
<%@ taglib uri="/WEB-INF/tld/sql.tld" prefix="sql"%>
<%
System.out.println("当前访问URL:"+request.getRequestURL());
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- 在IE 8 下面会输入 变空白的情况出现,判定浏览器情况:  -->
<c:if test="${fn:indexOf(header['user-agent'],'MSIE 8.0') gt 0 }">
 <meta http-equiv="X-UA-Compatible" content="ie=7" />
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" > 
</c:if>
<base target="_self"/>
<c:set var="ctx" value="<%=request.getContextPath() %>" scope="request"/>
<c:set var="base" value="<%=request.getRequestURI() %>"/>
<!-- 
展现给用户系统正在进行页面加载的效果
 -->
 <c:if test="${importScript ne false}">
  <div id="loading"> 
		<div class="loading-indicator">
			<img src="${ctx }/skins/default/images/load.gif" width="24" height="24" style="margin-right:8px;float:left;vertical-align:top;" />
			<span id="loading-msg"><%=SystemConfig.SYSTEM_PAGE_LOADING %></span>  
		</div> 
  </div> 
 </c:if>
<x:cache subject="SYSTEMS" var="systemInfos"/>
<c:if test="${not empty  systemInfos}"><c:set var="systemInfo" value="${systemInfos[0] }"/></c:if>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="MSThemeCompatible" content="no" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="description" content="upath" />
<Meta http-equiv="Page-Enter" Content="blendTrans(Duration=0.5)" /> 
<meta http-equiv="keywords" content="${systemInfo.cname }" /> 
<meta http-equiv="description" content="upath" />
<link rel="icon" href="${ctx}/skins/common/favicon.ico" type="image/x-icon" />  
<link rel="shortcut icon" href="${ctx}/skins/common/favicon.ico" type="image/x-icon" />
<c:if test="${importStyle ne false}">
<link href="${ctx}/skins/default/main.css" rel="stylesheet" type="text/css" />
</c:if>
<c:if test="${importScript ne false}">
<script type="text/javascript" src="${ctx}/scripts/jquery-latest.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common/json2.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery.Validform.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery.autocomplete.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery.form.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery-jtemplates.js"></script>
</c:if>
<title>${systemInfo.cname }</title>
</head>