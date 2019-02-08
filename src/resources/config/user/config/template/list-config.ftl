<#if path.exists == true>
	<#assign fidx = path.text?index_of("</sqlMap>")>
	<#assign len = path.text?length>
	<#if fidx gt -1>
${path.text?substring(0,fidx)}
	<#assign endText = path.text?substring(fidx,len)>
	</#if>
</#if>

<#if path.exists == false>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${wizard.pack}.mapper.Mapper">
</#if>	

<#list tables as table>

<#assign  columns = table.columns>
<#assign  tname=table.name>
		<#assign className=''>
		<#list tname?split('_') as fiex>
			<#assign className>${className}${fiex?capitalize}</#assign>
		</#list>
	
<#assign fields=''>
<#assign conditions=''>
<#assign params=''>
<#assign updates=''>
<#assign multi = false>
<#list columns as column>
<#assign fields>${fields}${column.name?upper_case}<#if column_has_next>,</#if></#assign>
<#assign params>${params}${'#{'+column.name?lower_case+'}'}<#if column_has_next>,</#if></#assign>
<#assign updates>${updates}${column.name?upper_case}=${'#{'+column.name?lower_case+'}'}<#if column_has_next>,</#if></#assign>
<#if column.primary == true>
<#assign conditions>${conditions} <#if multi == true> AND </#if>${column.name?upper_case}=${'#{'}${column.name?lower_case}${'}'}</#assign>
<#assign multi = true>
</#if>
</#list>

<select id="list${className}" resultType="${className}" >  
 SELECT ${fields} FROM  ${tname?upper_case} 
 WHERE   1 = 1
</select>

</#list>

</mapper>
