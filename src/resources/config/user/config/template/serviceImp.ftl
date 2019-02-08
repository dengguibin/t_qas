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
package	${wizard.pack}.service;
</#if>

import java.util.*;
import ${wizard.pack}.model.${className};
/**
* 
* @ClassName: ${className}Action.java
* @Description: ${tname}
* @author upaths@gmail.com  
* @date ${.now?datetime}
* @version V1.0   
*/
	
public class ${className}ServiceImp   implements ${className}Service{

}
	</#if>
</#list>
