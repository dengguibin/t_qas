/**
*/
package	com.deceen.system.organization.service;

import java.util.*;

import com.deceen.system.organization.model.QasEOrganization;
import com.deceen.system.organization.mapper.QasEOrganizationMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasEOrganizationAction.java
* @Description: qas_e_organization
* @author upaths@gmail.com  
* @date 2017-12-4 17:06:26
* @version V1.0   
*/
@Component("qasEOrganizationService")	
@SuppressWarnings({ "rawtypes","unused" })
public class QasEOrganizationService  extends CommonService {

		private QasEOrganizationMapper mapper;
	
		public List<QasEOrganization> getTree(String status){
			return mapper.list(status);
		}
		
		public List<QasEOrganization> getTree(){
			return mapper.listAll();
		}
		
		public List<QasEOrganization> selectTree(String orgname){
			return mapper.selectTree(orgname);
		}
		
		public List<QasEOrganization> selectChilds(String id){
			return mapper.queryByParentId(id);
		}
		
		private List<Object> getChildIds(String id){
			List<Object> ids = new ArrayList<Object>();
			List<QasEOrganization> bean=mapper.queryByParentId(id);
			for(QasEOrganization organization : bean){
				ids.add(organization.getId());
				ids.addAll(getChildIds(organization.getId()));
			}
			return ids;
		}
		
		public QasEOrganization select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasEOrganization  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasEOrganization bean){
			return mapper.update(bean);
		}
		
	
		public int updateWithDyna(QasEOrganization bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		/*public int[] batchInsert(List list){
			batchDelete(list, QasEOrganizationMapper.class.getName()+".insert");
			return 0;
		}
		*/
		public List list(QasEOrganization bean){
			return queryPageList(QasEOrganizationMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			List list = Arrays.asList(ids);
			batchDelete(list, QasEOrganizationMapper.class.getName()+".delete");
			return 0;
		};
			
		public QasEOrganizationMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasEOrganizationMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasEOrganizationMapper.class;
		}
}
