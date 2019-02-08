<#if path.exists == false>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
"http://struts.apache.org/dtds/struts-2.0.dtd">
<struts>
</#if>
<#if path.exists == true>
	<#assign fidx = path.text?index_of("</package>")>
	<#assign len = path.text?length>
	<#if fidx gt -1>
${path.text?substring(0,fidx)}
	<#assign endText = path.text?substring(fidx,len)>
	</#if>
</#if>
<#list tables as table>
<#assign  columns = table.columns>
<#assign  tname=table.name>
		<#assign className=''>
		<#list tname?split('_') as fiex>
			<#assign className>${className}${fiex?capitalize}</#assign>
		</#list>
<!--  ********************************${tname?upper_case} config end********************************  -->
<action name="${className}" class="${className}Action">
			<result name="list">/pages/common/dictionary/list.jsp</result>
			<result name="save">/pages/common/dictionary/selectList.jsp</result>
			<result name="select">/pages/common/dictionary/edit.jsp</result>
			<result name="delete">/pages/common/dictionary/edit.jsp</result>
</action>
<!--  ********************************${tname?upper_case} config end********************************  -->
</#list>
</struts>
