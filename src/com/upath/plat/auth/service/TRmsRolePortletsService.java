/**
*/
package	com.upath.plat.auth.service;

import java.util.*;

import com.upath.plat.auth.model.TRmsRolePortlets;
import com.upath.plat.auth.mapper.TRmsRolePortletsMapper;
import com.upath.plat.common.service.CommonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: TRmsRolePortletsAction.java
* @Description: t_rms_role_portlets
* @author upaths@gmail.com  
* @date 2015-6-9 13:59:14
* @version V1.0   
*/
@Component("tRmsRolePortletsService")	
@SuppressWarnings({ "rawtypes"})
public class TRmsRolePortletsService  extends CommonService {

		private TRmsRolePortletsMapper mapper;
	
		public TRmsRolePortlets select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(TRmsRolePortlets  bean){
			return	mapper.insert(bean);
		}
		
		public int update(TRmsRolePortlets bean){
			return mapper.update(bean);
		}
		
		/* 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(TRmsRolePortlets bean){
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			batchDelete(list, TRmsRolePortletsMapper.class.getName()+".insert");
			return 0;
		}
		*/
		public List list(TRmsRolePortlets bean){
			return queryPageList(TRmsRolePortletsMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			List list = Arrays.asList(ids);
			batchDelete(list, TRmsRolePortletsMapper.class.getName()+".delete");
			return 0;
		};
			
		public TRmsRolePortletsMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(TRmsRolePortletsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TRmsRolePortletsMapper.class;
		}

		public void batchInsert(List<TRmsRolePortlets> list, String mapperId,String projectId) {
			// TODO Auto-generated method stub
			mapper.deleteByProjectId(projectId);
			batchInsert(list, mapperId);
		}

		public List queryNoPage(TRmsRolePortlets trmsRolePortlets) {
			// TODO Auto-generated method stub
			return mapper.queryNoPage(trmsRolePortlets);
		}

		public List queryModuleId(TRmsRolePortlets trmsRolePortlets) {
			// TODO Auto-generated method stub
			return mapper.queryModuleId(trmsRolePortlets);
		}
}
