/**
*/
package	com.upath.plat.common.modules.service;

import java.util.*;

import com.upath.plat.common.modules.model.TCommonSql;
import com.upath.plat.common.modules.mapper.TCommonSqlMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.service.ISequence;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: TCommonSqlAction.java
* @Description: t_common_sql
* @author upaths@gmail.com  
* @date 2012-11-28 22:24:13
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes" })
public class TCommonSqlService extends CommonService  {
		
		private TCommonSqlMapper mapper;
	
		public TCommonSql select(TCommonSql bean){
			return	mapper.select(bean);
		}
		
		public void insert(TCommonSql  bean){
			ISequence seq = getPlatSequence();
			bean.setTid(seq.getNextDeaultId("SqlManager")+1000);
			mapper.insert(bean);
		}
		
		public void update(TCommonSql bean){
			bean.setUuid(IDGenerator.getUUID());
			bean.setXgsj(new Date());
			mapper.backupSql(bean);
			mapper.update(bean);
		}
		
		public List list(TCommonSql bean){
			return mapper.list(bean);
		}
		
		public void delete(TCommonSql bean){
			bean.setUuid(IDGenerator.getUUID());
			bean.setXgsj(new Date());
			mapper.backupSql(bean);
			mapper.delete(bean);
		}
		
		public TCommonSqlMapper getMapper() {
			return mapper;
		}

		public void setMapper(TCommonSqlMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TCommonSqlMapper.class;
		}
}
