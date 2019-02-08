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
package	${wizard.pack}.action;
</#if>

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.common.action.BaseActionSupport;
import ${wizard.pack}.model.${className};
import ${wizard.pack}.service.${className}Service;



/**
* strut2 config :
* spring config :
* @ClassName: ${className}Action.java
* @Description: ${tname}
* @author upaths@gmail.com  
* @date${.now?datetime}
* @version V1.0   
*/

@Scope("prototype")
@Component("${className?uncap_first}Action")
public class ${className}Action extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(${className}Action.class);
	
	/*服务类*/
	private  ${className}Service service;
	
	/*操作实体*/
	private ${className} bean;
	
	/*查询列表数据*/
	private List datas ;
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		${className} data = service.select(bean);
		if(data != null){
			bean = data;
		}
		return FORWARD_SELECT;
	}
	
	/**
	 * 查询数据列表
	 * @return select
	 */
	public String list(){
		request.setAttribute("mapper",service.getMapperClass());
		return FORWARD_LIST;
	}
	
	/**
	 * 数据保存，首先从数据库检测一次是否存在 ，存在调用更新，否则调用插入
	 * @return select
	 */
	public String save(){
		boolean isNew = false;
		${className} data = service.select(bean);
			if(data != null){
				service.update(bean);
			}else{
				isNew = true;
				service.insert(bean);
			}
		return this.select();
	}
	
	/**
	 * 删除数据
	 * @return select
	 */
	public String delete(){
		service.delete(bean);
		return null;
	}
	
	
	@Autowired
	public void setService(${className}Service service) {
		this.service = service;
	}

	public ${className} getBean() {
		return bean;
	}

	public void setBean(${className} bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}
	</#if>
</#list>
