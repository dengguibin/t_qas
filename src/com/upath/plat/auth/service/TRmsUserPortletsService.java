/**
*/
package	com.upath.plat.auth.service;

import java.util.*;

import com.upath.plat.auth.model.TRmsUserPortlets;
import com.upath.plat.auth.mapper.TRmsUserPortletsMapper;
import com.upath.plat.common.service.CommonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: TRmsUserPortletsAction.java
* @Description: t_rms_user_portlets
* @author upaths@gmail.com  
* @date 2015-6-9 13:59:15
* @version V1.0   
*/
@Component("tRmsUserPortletsService")	
@SuppressWarnings({ "rawtypes" })
public class TRmsUserPortletsService  extends CommonService {

		private TRmsUserPortletsMapper mapper;
	
		public TRmsUserPortlets select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(TRmsUserPortlets  bean){
			return	mapper.insert(bean);
		}
		
		public int update(TRmsUserPortlets bean){
			return mapper.update(bean);
		}
		
		/* 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(TRmsUserPortlets bean){
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			batchDelete(list, TRmsUserPortletsMapper.class.getName()+".insert");
			return 0;
		}
		*/
		public List list(TRmsUserPortlets bean){
			return queryPageList(TRmsUserPortletsMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			List list = Arrays.asList(ids);
			batchDelete(list, TRmsUserPortletsMapper.class.getName()+".delete");
			return 0;
		};
			
		public TRmsUserPortletsMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(TRmsUserPortletsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TRmsUserPortletsMapper.class;
		}

		public List<Map<String, Object>> findList(
				TRmsUserPortlets trmsUserPortlets) {
			// TODO Auto-generated method stub
			return mapper.findList(trmsUserPortlets);
		}

		public void batchInsert(List<TRmsUserPortlets> list, String mapperId,String projectId, String userid) {
			// TODO Auto-generated method stub
			TRmsUserPortlets trmsUserPortlets = new TRmsUserPortlets();
			trmsUserPortlets.setUserid(userid);
			trmsUserPortlets.setProid(projectId);
			mapper.deleteByPro(trmsUserPortlets);
			batchInsert(list, mapperId);
		}

		public void deleteByPro(TRmsUserPortlets trmsUserPortlets) {
			// TODO Auto-generated method stub
			mapper.deleteByPro(trmsUserPortlets);
		}

		public List<String> findRowList(TRmsUserPortlets trmsUserPortlets) {
			// TODO Auto-generated method stub
			return mapper.findRowList(trmsUserPortlets);
		}

		public void batchInsertUserPortlets(List<TRmsUserPortlets> userPortletsList,
				String mapperId, String userid, String proId) {
			// TODO Auto-generated method stub
			Map<String,Object> objMap = new HashMap<String, Object>();
			objMap.put("userid", userid);
			objMap.put("proId", proId);
			objMap.put("userPortletsList", userPortletsList);
			mapper.deleteByList(objMap);
			batchInsert(userPortletsList, mapperId);
		}
}
