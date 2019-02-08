package	com.deceen.data.school.booksInLibrary.service;

import java.util.*;
import com.deceen.data.school.booksInLibrary.model.QasDBooksinlibrary;
import com.deceen.data.school.booksInLibrary.mapper.QasDBooksinlibraryMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDBooksinlibraryAction.java
* @Description: qas_d_booksinlibrary
* @author upaths@gmail.com  
* @date 2017-11-22 17:44:52
* @version V1.0   
*/
@Component("qasDBooksinlibraryService")	
@SuppressWarnings({ "rawtypes" })
public class QasDBooksinlibraryService  extends CommonService {

		private QasDBooksinlibraryMapper mapper;
	
		public QasDBooksinlibrary select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDBooksinlibrary  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDBooksinlibrary bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDBooksinlibrary bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDBooksinlibraryMapper.class.getName()+".insert");
		}
		
		public List list(Map map){
			return queryPageList(QasDBooksinlibraryMapper.class.getName()+".list", map);
		}
		
		public List list(QasDBooksinlibrary bean){
			Map map=new HashMap();
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getNumofbookScope()!=null && bean.getNumofbookScope()!=""  && "--请选择--".equals(bean.getNumofbookScope())==false){
				String numofbookScope=bean.getNumofbookScope();
				if(!numofbookScope.contains("以上")){
				Integer minScope=Integer.parseInt(numofbookScope.split("-")[0]);
				Integer maxScope=Integer.parseInt(numofbookScope.split("-")[1]);
				map.put("minScope", minScope);
				map.put("maxScope", maxScope);
				}else{
					numofbookScope=numofbookScope.replace("以上", "");
					map.put("numofbookScope", numofbookScope);
				}
			}
			
			if(bean.getStoragetime()!=null){
				Date storagetime=bean.getStoragetime();
				map.put("storagetime", storagetime);
			}
			return this.list(map);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDBooksinlibraryMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDBooksinlibraryMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDBooksinlibraryMapper.class;
		}
}
