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
import ${wizard.pack}.mapper.${className}Mapper;
import com.upath.plat.common.service.CommonService;
/**
* 
* @ClassName: ${className}Action.java
* @Description: ${tname}
* @author upaths@gmail.com  
* @date ${.now?datetime}
* @version V1.0   
*/
	
public class ${className}Service extends CommonService  {
		
		private ${className}Mapper mapper;
	
		public ${className} select(${className} bean){
			return	mapper.select(bean);
		}
		
		public void insert(${className}  bean){
			mapper.insert(bean);
		}
		
		public void update(${className} bean){
			mapper.update(bean);
		}
		
		public List list(${className} bean){
			return mapper.list(bean);
		}
		
		public void delete(${className} bean){
			mapper.delete(bean);
		}
		
		public ${className}Mapper getMapper() {
			return mapper;
		}

		public void setMapper(${className}Mapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return ${className}Mapper.class;
		}
}
	</#if>
</#list>
