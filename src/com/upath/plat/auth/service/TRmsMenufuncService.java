/**
*/
package	com.upath.plat.auth.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.mapper.TRmsMenufuncMapper;
import com.upath.plat.auth.model.TRmsMenufunc;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.service.ISequence;
/**
* 
* @ClassName: TRmsMenufuncAction.java	
* @Description: t_rms_menufunc
* @author upaths@gmail.com  
* @date 2015-5-20 15:03:18
* @version V1.0   
*/
@Component("tRmsMenufuncService")	
@SuppressWarnings({ "rawtypes" })
public class TRmsMenufuncService  extends CommonService {

		private TRmsMenufuncMapper mapper;
	
		public TRmsMenufunc select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(TRmsMenufunc  bean){
			ISequence sequence = getPlatSequence();
			bean.setFuncid(sequence.getNextDeaultId("menu"));
			return	mapper.insert(bean);
		}
		
		public int update(TRmsMenufunc bean){
			return mapper.update(bean);
		}
		
		/* 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(TRmsMenufunc bean){
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			batchDelete(list, TRmsMenufuncMapper.class.getName()+".insert");
			return 0;
		}
		*/
		public List list(TRmsMenufunc bean){
			return queryPageList(TRmsMenufuncMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			List list = Arrays.asList(ids);
			batchDelete(list, TRmsMenufuncMapper.class.getName()+".delete");
			return 0;
		};
			
		public TRmsMenufuncMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(TRmsMenufuncMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TRmsMenufuncMapper.class;
		}
}
