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
package	${wizard.pack}.model;
</#if>

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: ${className}.java   ${table.comments!''}
* @Description: ${tname}   
* @author upaths@gmail.com  
* @date ${.now?datetime}
* @version V1.0   
*/
	
public class ${className} extends Pagination implements Serializable{ 	
	
<#list columns as column>
	<#assign comments>${column.comments!''}<#t></#assign>
	 //${comments} ${(column.primary?string('@PrimaryKey',''))}
	 <#if column.sqlType?upper_case == 'TEXT' || column.sqlType?upper_case == 'MEDIUMTEXT'>
	private String  ${column.name?lower_case};
	 <#else>
	private ${column.javaType} ${column.name?lower_case};
	 </#if>
</#list>

<#list columns as column>
	<#assign lower = column.name?lower_case>
	<#assign cap = lower?cap_first>
	 <#if column.sqlType?upper_case == 'TEXT' || column.sqlType?upper_case == 'MEDIUMTEXT'>
	     public void set${cap}(String ${lower}){
			this.${lower} = ${lower};
		}
	  
		public String get${cap}(){
			return this.${lower};
		}
	 <#else>
		 public void set${cap}(${column.javaType} ${lower}){
			this.${lower} = ${lower};
		}
	  
		public ${column.javaType} get${cap}(){
			return this.${lower};
		}
	 </#if>
</#list>
}
	</#if>
</#list>
