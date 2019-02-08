/**
*/
package	com.upath.plat.quartz.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upath.plat.common.cache.ISystemCache;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.quartz.mapper.TCommonSchedulingMapper;
import com.upath.plat.quartz.model.TCommonScheduling;
import com.upath.plat.quartz.scheduling.ScheduleCenter;
import com.upath.plat.quartz.scheduling.TaskUtils;
/**
* 
* @ClassName: TCommonSchedulingAction.java
* @Description: t_common_scheduling
* @author upaths@gmail.com  
* @date 2015-7-9 19:13:31
* @version V1.0   
*/
@Component("tCommonSchedulingService")	
@SuppressWarnings({ "rawtypes" })
public class TCommonSchedulingService  extends CommonService implements ISystemCache{

		private TCommonSchedulingMapper mapper;
	
		public TCommonScheduling select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(TCommonScheduling  bean) throws Exception{
			bean.setTaskid(IDGenerator.getUUID());
			if("1".equals(bean.getStates())){
				ScheduleCenter.getSchedulerManager().addJob(bean);
			}
			bean.setRuntimes(0);
			int result = mapper.insert(bean);
			return result;	
		}
		
		public int update(TCommonScheduling bean) throws Exception{
			int result = mapper.update(bean);
			if("1".equals(bean.getStates())){
				ScheduleCenter.getSchedulerManager().replaceJob(bean);
			} else if ("0".equals(bean.getStates())){
				if(ScheduleCenter.getSchedulerManager().getJobNameList().contains(bean.getTaskid())){
					ScheduleCenter.getSchedulerManager().pauseJob(bean.getTaskid());
				}
			}
			return result;
		}
		
		public int updateData(TCommonScheduling bean) throws Exception{
			return mapper.update(bean);
		}
		
		public int updateWithDyna(TCommonScheduling bean) throws Exception{
			int result =  mapper.updateWithDyna(bean);
			if("1".equals(bean.getStates())){
				ScheduleCenter.getSchedulerManager().replaceJob(bean);
			} else if ("0".equals(bean.getStates())){
				if(ScheduleCenter.getSchedulerManager().getJobNameList().contains(bean.getTaskid())){
					ScheduleCenter.getSchedulerManager().pauseJob(bean.getTaskid());
				}
			}
			return result;
		}
		
		public int updateStatus(TCommonScheduling bean) throws Exception{
			String idArrs[] = bean.getTaskid().split("[,]");
			int result = 0;
			List<String> JobNameList = ScheduleCenter.getSchedulerManager().getJobNameList();
			if ("1".equals(bean.getStates())){
				for (String id : idArrs) {
					bean.setTaskid(id);
					result +=  mapper.updateWithDyna(bean);
					TCommonScheduling scheduling = mapper.select(id);
					if(JobNameList.contains(id)){
						//存在 重启
//						ScheduleCenter.getSchedulerManager().resumeJob(id);
						ScheduleCenter.getSchedulerManager().replaceJob(scheduling);
					} else {
						// 不存在  新加job
						ScheduleCenter.getSchedulerManager().addJob(scheduling);
					}
				}
			} else if ("0".equals(bean.getStates())){
				for (String id : idArrs) {
					bean.setTaskid(id);
					result +=  mapper.updateWithDyna(bean);
					//暂停
					ScheduleCenter.getSchedulerManager().pauseJob(id);
				}
			}
			return result;
		}
		
		
		/* 需要时请开启,动态进行更新,批量插入实现
		public int[] batchInsert(List list){
			batchDelete(list, TCommonSchedulingMapper.class.getName()+".insert");
			return 0;
		}
		*/
		public List list(TCommonScheduling bean){
			return queryPageList(TCommonSchedulingMapper.class.getName()+".list", bean);
		}
			
		public List<TCommonScheduling> querylist(TCommonScheduling bean){
			return mapper.querylist(bean);
		}
		
		public int delete(Object id) throws Exception{
			int result = mapper.delete(id);
			ScheduleCenter.getSchedulerManager().deleteJob(id.toString());
			return result;
		};
		
		public int delete(Object[] ids) throws Exception{
			List list = Arrays.asList(ids);
			batchDelete(list, TCommonSchedulingMapper.class.getName()+".delete");
			for (Object id : list) {
				ScheduleCenter.getSchedulerManager().deleteJob(id.toString());
			}
			return 0;
		};
		
		public int updateQuartzStatus(Map<String, Object> params){
			return mapper.updateQuartzStatus(params);
		}
		
		/**
		 * 手动执行任务
		 * @param bean
		 * @throws Exception
		 */
		public void excuteJob(TCommonScheduling bean) throws Exception{
//			Class cls = Class.forName(bean.getJobclass().trim());
//			BaseStatefulJob job = (BaseStatefulJob) cls.newInstance();
//			job.manuallyExcute(bean);
			TaskUtils.invokMethod(bean);
		}
			
		public TCommonSchedulingMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(TCommonSchedulingMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TCommonSchedulingMapper.class;
		}
		
		//========下面是ISystemCache实现方法======================================
		@Override
		public void load() throws PlatformException {
			TCommonScheduling bean = new TCommonScheduling();
			bean.setStates("1");
			List<TCommonScheduling> jobList = querylist(bean);
			for (TCommonScheduling job : jobList) {
				try {
					updateStatus(job);
				} catch (Exception e) {
				}
			}
			
		}

		@Override
		public void reload() throws PlatformException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void release() throws PlatformException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void remove(String cacheCode) throws PlatformException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void reload(String cacheCode) throws PlatformException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
			
		}
}
