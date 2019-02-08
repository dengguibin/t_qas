<paths>
<#list wizard.tables as table>
		<#assign sname=''>
		<#list table?split('_') as fiex>
			<#assign sname>${sname}${fiex?capitalize}</#assign>
		</#list>
		<#if 1 == 2>
		<!--
		id:配置此 path 的 ID描述符号
		name 生成任务文件的名称
		type 生成文件的后缀名称
		encoding : 第个path 都有自己的编码规范，插件默认为 utf-8
		xpath : 在配置XML文件中，如果文件已经存在 那么 代码工具想做的事情是希望向某个节点位置的最后
		      追加某些配置说明 此配置内容 完全要 符合 JDOM 的XPATH 配置。
		      备注：此字段现在不用，如果文件存在的情况，那么调用 原文件的文本放入path.text 字段中。让模板去处理后再返回内容便可
		 source: 负责为向导器提供此次PATH 任务的模板在哪，相对于 模块的配置目录进行配置
		 target:如果选择不把流输出到额外的文件系统，那么此路径应该配置成相对工程应用的 相对路径名称
		        代码生成器负责解释到工程的相对目录。如果配置的目录不存在，工具会自动生成相应的目录。
		        并建立对应的文件。
		  description :向导功能的描述
		  备注：此XML文件是没有 TLD 来进行控制 配置的输入性。所以在配置的时候可以配置客户的信息到此
		  PATH 当中，所有的信息都会存储在 MAP 数据当中。请使用 path.datas.key来进行收集或者输出额外的内容
		  
		  在每次调用 模板来生成 文件的时候都会传入以下数据：
		  SelectionInfo :用户选择的路径信息和数据表信息
		  PathInfo ： 当前被 调用 PathInfo
		  List<MTable> metaDatas 当前选中的所有表的 元数据信息 
		-->
		</#if>
	<path id="${table}">
		<name>${table} Model</name>
		<encoding>UTF-8</encoding>
		<type>java</type>
		<xpath></xpath>
		<source>/template_gd/javabean.ftl</source>
		<target>${wizard.container}/${wizard.pack?replace(".", "/")}/model/${sname}.java</target>
		<description>JAVA BEAN MODEL</description>
	</path>
	
	<path id="${table}">
		<name>${table} Action</name>
		<encoding>UTF-8</encoding>
		<type>java</type>
		<xpath></xpath>
		<source>/template_gd/action.ftl</source>
		<target>${wizard.container}/${wizard.pack?replace(".", "/")}/action/${sname}Action.java</target>
		<description>JAVA ACTION</description>
	</path>
	
	<path id="${table}">
		<name>${table} service</name>
		<encoding>UTF-8</encoding>
		<type>java</type>
		<xpath></xpath>
		<source>/template_gd/service.ftl</source>
		<target>${wizard.container}/${wizard.pack?replace(".", "/")}/service/${sname}Service.java</target>
		<description>JAVA service</description>
	</path>

	<path id="${table}">
		<name>${table} Edit jsp</name>
		<encoding>UTF-8</encoding>
		<type>java</type>
		<xpath></xpath>
		<source>/template_gd/addJsp.ftl</source>
		<target>${wizard.container}/${wizard.pack?replace(".", "/")}/config/${sname}Edit.jsp</target>
		<description>JAVA service</description>
	</path>
	
   <path id="${table}">
		<name>${table}info jsp</name>
		<encoding>UTF-8</encoding>
		<type>java</type>
		<xpath></xpath>
		<source>/template_gd/infoJsp.ftl</source>
		<target>${wizard.container}/${wizard.pack?replace(".", "/")}/config/${sname}Info.jsp</target>
		<description>JAVA service</description>
	</path>
	
	<path id="${table}">
		<name>${table} list jsp</name>
		<encoding>UTF-8</encoding>
		<type>java</type>
		<xpath></xpath>
		<source>/template_gd/listJsp.ftl</source>
		<target>${wizard.container}/${wizard.pack?replace(".", "/")}/config/${sname}List.jsp</target>
		<description>JAVA service</description>
	</path>
	
	
	<path id="${table}">
		<name>${wizard.pack} ibatis</name>
		<encoding>UTF-8</encoding>
		<type>xml</type>
		<xpath>sqlMap</xpath>
		<source>/template/config.ftl</source>
		<target>${wizard.container}/${wizard.pack?replace(".", "/")}/mapper/${sname}Mapper.xml</target>
		<description>ibatis config</description>
	</path>
	
	
	<path id="${table}">
		<name>${table} mapper</name>
		<encoding>UTF-8</encoding>
		<type>java</type>
		<xpath></xpath>
		<source>/template/dao.ftl</source>
		<target>${wizard.container}/${wizard.pack?replace(".", "/")}/mapper/${sname}Mapper.java</target>
		<description>JAVA service</description>
	</path>
	
 </#list>
  <path id="${wizard.pack}">
		<name>${wizard.pack} spring</name>
		<encoding>UTF-8</encoding>
		<type>xml</type>
		<xpath>struts</xpath>
		<source>/template_gd/struts.ftl</source>
		<target>${wizard.container}/${wizard.pack?replace(".", "/")}/config/${wizard.pack?replace(".", "_")}_action.xml</target>
		<description>spring config</description>
	</path>
</paths>