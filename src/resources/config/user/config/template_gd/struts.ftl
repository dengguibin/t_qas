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
		<#assign subfix=''>
		<#list tname?split('_') as fiex>
			<#assign className>${className}${fiex?capitalize}</#assign>
			<#assign subfix>${fiex?lower_case}</#assign>
		</#list>
<!--  ********************************${tname?upper_case} config end********************************  -->

<package name="${className}" extends="default"
		namespace="请配置/${subfix}">
		
		<action name="queryInfo" class="${className?uncap_first}Action" method="queryInfo">
			<result name="select">请配置/${className}Info.jsp</result>
		</action>
		
		<action name="queryList" class="${className?uncap_first}Action" method="queryList">
			<result name="list">请配置/${className}List.jsp</result>
		</action>
		
		<action name="remove" class="${className?uncap_first}Action" method="remove">
		</action>
		
		<action name="toEdit" class="${className?uncap_first}Action" method="toEdit">
			<result name="toEdit">请配置/${className}Edit.jsp</result>
		</action>
		
		<action name="save" class="${className?uncap_first}Action" method="save">
			<result name="save" type="redirect">
			请配置/${subfix}/queryList.action?menuId=${"$"}{menuId}
			</result>
		</action>
	</package>
<!--  ********************************${tname?upper_case} config end********************************  -->
</#list>
</struts>
