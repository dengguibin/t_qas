<#list tables as table>
	<#if table.name == path.id>
		<#assign  columns=table.columns>
		<#assign  tname=table.name>
		<#assign className=''>
		<#list tname?split('_') as fiex>
			<#assign className>${className}${fiex?capitalize}</#assign>
		</#list>
<#assign sindex = path.target?last_index_of('/')>	
<#if sindex  != -1 >
/**
*/
package	${wizard.pack}.mapper;
</#if>

import java.util.*;
import org.springframework.stereotype.Component;

import ${wizard.pack}.model.${className};

@Component("${className?uncap_first}Mapper")
public interface ${className}Mapper {

	${className} select(Object id);
	
	int insert(${className} bean);
	
	int update(${className} bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(${className} bean);
	*/
	List  list(${className} bean);
	
	int delete(Object id);
	
}

</#if>
</#list>