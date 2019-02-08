<%@ page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<c:set var="base" value="<%=request.getRequestURI() %>"/>
<c:redirect url="/login.do"></c:redirect>