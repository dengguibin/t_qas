<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="com.upath.plat.common.util.SystemConfig"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/tld/x.tld"  prefix="x"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%> 
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%> 
<%@ taglib uri="/WEB-INF/tld/sql.tld" prefix="sql"%>
<%
System.out.println("当前访路径      :"+request.getAttribute("struts.request_uri"));
System.out.println("当前访问类      :"+request.getAttribute("_REQUEST_ACTION_NAME"));
System.out.println("当前响应JSP :"+request.getRequestURL());
%> 
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">-->
<!DOCTYPE html>
<html>
<head>
<base target="_self"/>
<c:set var="ctx" value="<%=request.getContextPath() %>" scope="request"/>
<c:set var="base" value="<%=request.getRequestURI() %>"/>
<!-- 
展现给用户系统正在进行页面加载的效果
 -->

<x:cache subject="SYSTEMS" var="systemInfos"/>
<c:if test="${not empty  systemInfos}"><c:set var="systemInfo" value="${systemInfos[0] }"/></c:if> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="MSThemeCompatible" content="no" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="description" content="upath" />
<meta http-equiv="Page-Enter" content="blendTrans(Duration=0.5)" /> 
<meta http-equiv="keywords" content="${systemInfo.cname }" /> 
<meta http-equiv="description" content="upath" />
<link rel="icon" href="${ctx}/skins/common/favicon.ico" type="image/x-icon" />  
<link rel="shortcut icon" href="${ctx}/skins/common/favicon.ico" type="image/x-icon" />
<c:if test="${importStyle ne false}">
<link href="${ctx}/skins/uimaker/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/skins/uimaker/css/select.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/scripts/plugins/select2-master/dist/css/select2.min.css" />
<link href="${ctx}/skins/default/mainUI.css" rel="stylesheet" type="text/css" />
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
<script type="text/javascript" src="${ctx}/scripts/uimaker/select-ui.min.js"></script>
<!--<script type="text/javascript" src="${ctx }/scripts/plugins/select2/js/select2.min.js"></script>-->
<script type="text/javascript" src="${ctx}/scripts/plugins/select2-master/dist/js/select2.min.js" ></script>
</c:if>
<title>${systemInfo.cname }</title>
</head>