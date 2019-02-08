<#if path.exists == true>
	<#assign fidx = path.text?index_of("</sqlMap>")>
	<#assign len = path.text?length>
	<#if fidx gt -1>
${path.text?substring(0,fidx)}
	<#assign endText = path.text?substring(fidx,len)>
	</#if>
</#if>
<#list tables as table>
<#if table.name == path.id>
<#assign  columns = table.columns>
<#assign  tname=table.name>
		<#assign className=''>
		<#list tname?split('_') as fiex>
			<#assign className>${className}${fiex?capitalize}</#assign>
		</#list>
<#if path.exists == false>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${wizard.pack}.mapper.${className}Mapper">
</#if>		
<#assign fields=''>
<#assign conditions=''>
<#assign dynaSql=''>
<#assign params=''>
<#assign updates=''>
<#assign multi = false>
<#list columns as column>
<#assign fields>${fields}${column.name?upper_case}<#if column_has_next>,</#if></#assign>
<#assign params>${params}${'#{'+column.name?lower_case+'}'}<#if column_has_next>,</#if></#assign>
<#assign updates>${updates}${column.name?upper_case}=${'#{'+column.name?lower_case+'}'}<#if column_has_next>,</#if></#assign>
<#assign dynaSql>   
${dynaSql}<if test="${column.name?lower_case} != null">  ${column.name?upper_case} = ${'#{'+column.name?lower_case+'}'},</if>
</#assign>  
<#if column.primary == true>
<#assign conditions>${conditions} <#if multi == true> AND </#if>${column.name?upper_case}=${'#{'}${column.name?lower_case}${'}'}</#assign>
<#assign multi = true>
</#if>
</#list>
<!--  ********************************${tname?upper_case} config begnin********************************  -->

<select id="select" resultType="${className}"> 
 SELECT ${fields} FROM  ${tname?upper_case} 
 WHERE  ${conditions}
</select>

<select id="list" parameterType="${className}" useCache="false"   resultType ="hashmap" >  
 <include refid="plat.ORACLE_PAGE_HEADER" />
 SELECT ${fields} FROM  ${tname?upper_case} 
 WHERE  1 = 1
 <!-- 
   ## 这里为查询的样例 修改完必须删除此些内容
 <if test="filed != null and filed != ''">
 AND COLUMN LIKE '%' ${'#{'}filed}  '%'
 </if>
  <if test="endTime != null and endTime != ''">
      	<![CDATA[  AND  ${'#{'}endTime} >= DATE_FORMAT(COLUMN,'%Y-%m-%d')]]>
  </if>
 -->
 <include refid="plat.ORACLE_PAGE_FOOTER" />
</select>

 <insert id="insert" parameterType="${className}">
 INSERT INTO ${tname?upper_case}   ( ${fields})
  VALUES ( ${params} )
</insert>

 <update id="update" parameterType="${className}">
 UPDATE ${tname?upper_case} SET  ${updates} 
 WHERE ${conditions}
</update>


 <delete id="delete">
   DELETE FROM ${tname?upper_case} WHERE  ${conditions}
</delete>

<!--动态进行更新 如果有需要请开启，否则请删除
 <update id="updateWithDyna" parameterType="${className}">
 UPDATE ${tname?upper_case} 
 <trim prefix="SET" suffixOverrides=",">
 ${dynaSql}
 </trim>  
 WHERE ${conditions}
</update>
-->
<!--  ********************************${tname?upper_case} config end********************************  -->
</#if>
</#list>

</mapper>
