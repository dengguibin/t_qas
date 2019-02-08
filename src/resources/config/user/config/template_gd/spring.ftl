<#if path.exists == false>
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd"
	default-autowire="byName">
</#if>
<#if path.exists == true>
	<#assign fidx = path.text?index_of("</beans>")>
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
<bean id="${className}Service" parent="TxPatternBean">
	<property name="target">
		<bean  class="${wizard.pack}.service.${className}ServiceImp">
				<property name="dao">
					<ref bean="dao"/>
				</property>	
		</bean>
	</property>
</bean>
<!--  ********************************${tname?upper_case} config end********************************  -->
</#list>
</beans>
