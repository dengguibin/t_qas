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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: ${className}Action.java
* @Description: ${tname}
* @author upaths@gmail.com  
* @date ${.now?datetime}
* @version V1.0   
*/
@Component("${className?uncap_first}Service")	
public class ${className}Service  extends CommonService {

		private ${className}Mapper mapper;
	
		public ${className} select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(${className}  bean){
			return	mapper.insert(bean);
		}
		
		public int update(${className} bean){
			return mapper.update(bean);
		}
		
		/* 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(${className} bean){
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			batchDelete(list, ${className}Mapper.class.getName()+".insert");
			return 0;
		}
		*/
		public List list(${className} bean){
			return queryPageList(${className}Mapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			List list = Arrays.asList(ids);
			batchDelete(list, ${className}Mapper.class.getName()+".delete");
			return 0;
		};
			
		public ${className}Mapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(${className}Mapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return ${className}Mapper.class;
		}
}
	</#if>
</#list>
