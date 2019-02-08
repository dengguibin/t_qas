<#list tables as table>
	<#if table.name == path.id>
		<#assign  columns=table.columns>
		<#assign  tname=table.name>
		<#assign className=''>
		<#list tname?split('_') as fiex>
			<#assign className>${className}${fiex?capitalize}</#assign>
		</#list>
		
		<#assign pkMethod=''>
		<#list columns as column>
				<#if column.primary>
					<#assign pkMethod='${column.name?lower_case?cap_first}()'>
				</#if>
		</#list>
		
<#assign sindex = path.target?last_index_of('/')>		
<#if sindex  != -1 >
/**
*/
package	${wizard.pack}.action;
</#if>

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.common.action.BaseActionSupport;
import ${wizard.pack}.model.${className};
import ${wizard.pack}.service.${className}Service;

import net.sf.json.JSONObject;


/**
* @ClassName: ${className}Action.java
* @Description: ${tname}
* @author upaths@gmail.com  
* @date${.now?datetime}
* @version V1.0   
*/
@Scope("prototype")
@Component("${className?uncap_first}Action")	
public class ${className}Action  extends BaseActionSupport{

	private static final Logger log = Logger.getLogger(${className}Action.class);

	private  ${className}Service service;
	
	private ${className} bean;
	
	private List datas;
	
	//查询单条记录信息
	public String queryInfo() throws Exception {
		if(bean != null && bean.get${pkMethod} != null && "".equals(bean.get${pkMethod}) == false){
				bean = service.select(bean.get${pkMethod});
			}
		return FORWARD_SELECT;
	}
	
	//查询 列表信息
	public String queryList() throws Exception {
		if(bean == null){ 
			bean = new ${className}();
		}
		datas = service.list(bean);
		return FORWARD_LIST;
	}
	
	//进行更新和增加 的进入页面
	public String toEdit() throws Exception {
		//查询一次数据信息
		queryInfo();
		return FORWARD_TOEDIT;
	}
	
	//新增和更新操作
	public String save() throws Exception {
		if(bean != null  ){
			//主键记录已经存在，需要进行更新操作
			if(bean.get${pkMethod} != null && "".equals(bean.get${pkMethod}) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				${className} dsBean = service.select(bean.get${pkMethod});
				if(dsBean != null){
				// 如果数据库中有此记录信息，进行更新操作
					int rows = service.update(bean);
				}else{
					//是否需要输出数据不存在的异常
				}
			}else{
				int rows = service.insert(bean);
			}
			
		}
		return FORWARD_SAVE;	
	}
	
	/**
	 * 删除方法，如果ID 上是以","隔开的字符，会认为是一个数组,批量删除数据
	 */
	public String remove() throws Exception {
		Map result = new HashMap();
		result.put("status", "0");
		if(bean != null && bean.get${pkMethod} != null){
			String idArrs[] = bean.get${pkMethod}.split("[,]");
			boolean checkResult = true;
//程序是否需要对此数据进行数据检验,如果是请开启此部分的数据检验			
//			for(int i = 0 ; i < idArrs.length ; i++){
//					//是否有对应的数据存在
//					int rows = Integer.valueOf(((Map)service.get2Object("查询数据的行数", bean)).get("CNUM").toString());
//					if(rows > 0){
//						checkResult = false;
//						break;
//					}
//			}	
			if(checkResult == true){
				try{
					int rows = service.delete(idArrs);
					result.put("status", "1");
				}catch(Exception e){
					e.printStackTrace();
					result.put("message", e.getMessage());
				}
			}else{
				result.put("status", "2");
				result.put("message", "已经存在相关联的数据，请先删除");
			}
		}else{
			result.put("message","错误参数");
		}
		
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	
	
	public ${className}Service getService() {
		return service;
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
