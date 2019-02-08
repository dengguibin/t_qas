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
/***/
package	${wizard.pack}.service;
</#if>
import java.util.*;
import ${wizard.pack}.model.${className};

import com.mine.common.exception.DBException;
import com.mine.framework.service.impl.CommonServiceImpl;
/**
* 
* @ClassName: ${className}Action.java
* @Description: ${tname}
* @author upaths@gmail.com  
* @date ${.now?datetime}
* @version V1.0   
*/
	
public class ${className}ServiceImp extends CommonServiceImpl    implements ${className}Service{

		//查询单体
	    public ${className} get${className}ById(Object id) throws DBException{
	    	if (id == null){ throw new NullPointerException("id");}
	   	 return (${className}) dao.getObject("${className}.select", id.toString());
	    }
	    
		//删除单体数据
		public int remove${className}ById(Object id) throws DBException{
			if (id == null){ throw new NullPointerException("id");}
			int rows =  dao.removeObject("${className}.remove", id.toString());
			return rows;
		}
		
		//删除多条数据
		public int remove${className}ById(Object[] ids) throws DBException{
			if (ids == null || ids.length == 0){ throw new NullPointerException("ids");}
				this.dao.removeBatchObject("${className}.remove", Arrays.asList(ids));
			return 0;
		}
		
		//更新单体数据
		public int update${className}(${className} bean) throws DBException{
			if (bean == null){ throw new NullPointerException("bean");}
		    int rows  = dao.updateObject("${className}.update", bean);
		   return rows;
		}
		
		//保存单体数据
		public int save${className}(${className} bean) throws DBException{
			  if (bean == null){ throw new NullPointerException("bean");}
			  int rows  = 1;
			  	dao.saveObject("${className}.insert", bean);
			  return rows;
		}
		
		//查询列表
		public List get${className}List(${className} bean) throws DBException{
			List datas = this.getPageLists("${className}.list", bean, null);
		    return datas;
		}
}
	</#if>
</#list>
