package com.deceen.kettle.service;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.pentaho.di.core.Const;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.Result;
import org.pentaho.di.core.RowMetaAndData;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.exception.KettlePluginException;
import org.pentaho.di.core.exception.KettleSecurityException;
import org.pentaho.di.core.exception.KettleStepException;
import org.pentaho.di.core.logging.KettleLogStore;
import org.pentaho.di.core.logging.LogLevel;
import org.pentaho.di.core.parameters.UnknownParamException;
import org.pentaho.di.core.plugins.PluginRegistry;
import org.pentaho.di.core.plugins.RepositoryPluginType;
import org.pentaho.di.core.row.RowMetaInterface;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.repository.RepositoriesMeta;
import org.pentaho.di.repository.Repository;
import org.pentaho.di.repository.RepositoryDirectoryInterface;
import org.pentaho.di.repository.RepositoryMeta;
import org.pentaho.di.shared.SharedObjects;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.trans.step.RowAdapter;
import org.pentaho.di.trans.step.RowListener;
import org.pentaho.di.trans.step.StepInterface;
import org.springframework.stereotype.Component;

import com.deceen.kettle.model.DatabaseMetaParameter;
import com.upath.plat.common.util.StringUtil;

@Component("kettleService")	
public class KettleService {
	public final static String KETTLE_SHARE_XML_PATH="config/kettleShare/shared.xml";
	public final static String KETTLE_REPOSITORIES_XML_PATH="config/kettleShare/repositories.xml";
	public final static String PROPERTISE_PATH="config/kettleShare/repositories.properties";
	public static boolean isSetShared=false;
	
/*	static{
		try {
			long t = new Date().getTime();
			KettleEnvironment.init();
			System.out.println("---------------本次初始化环境的时间为："+ (new Date().getTime() -t )/1000+"秒-------------------");
		} catch (KettleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	public  void setSystemShare(String sharePath) throws UnsupportedEncodingException{
		if(StringUtil.isBlank(sharePath)){
			sharePath = getShareXmlPath();
		}
		System.setProperty(Const.KETTLE_SHARED_OBJECTS, sharePath);//所有转换文件共享改数据库配置
		isSetShared=true;
	}

	/**执行转换并获取某个步骤的值
	 * @param path文件路径
	 * @param stepName 步骤名称
	 * @param variableMap 设置变量变量         
	 * @param parameterValueMap 设置参数         
	 * @return
	 */
	public Map<String, Object> readFromStep(String path, String stepName,Map<String,String> variableMap,Map<String,String> parameterValueMap,String sharePath) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			KettleEnvironment.init();
			TransMeta transMeta = new TransMeta(path);
			setProperty(variableMap, parameterValueMap, sharePath, transMeta);
			Trans trans = new Trans(transMeta);
			trans.prepareExecution(null);
			final List<RowMetaAndData> rows = new ArrayList<RowMetaAndData>();
			RowListener rowListener = new RowAdapter() {
				public void rowWrittenEvent(RowMetaInterface rowMeta,
						Object[] row) throws KettleStepException {
					rows.add(new RowMetaAndData(rowMeta, row));
				}
			};
			StepInterface stepInterface = trans.findRunThread(stepName);
			stepInterface.addRowListener(rowListener);
			trans.startThreads();
			trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
				map.put("result", "failure");
			} else {
				map.put("result", "success");
			}
			org.pentaho.di.core.logging.LoggingBuffer loggingBuffer = KettleLogStore.getAppender();
		    StringBuffer logTextBuffer = loggingBuffer.getBuffer( trans.getLogChannel().getLogChannelId(), false );
		    map.put("logTextBuffer", logTextBuffer.toString());
			map.put("resultValue", rows);
			Result rs = trans.getResult();
			map.put("resultInfo", rs);
		} catch (KettleException e) {
			e.printStackTrace();
		}
		return map;
	}


	private void setProperty(Map<String, String> variableMap,
			Map<String, String> parameterValueMap, String sharePath,
			TransMeta transMeta) throws KettleException, UnknownParamException {
		//-------------共享数据库文件-----------------------
		if(StringUtil.isNotBlank(sharePath)&&!isSetShared){
			File shareFile  = new File(sharePath);
			if(shareFile.exists()){
				transMeta.setSharedObjectsFile(sharePath);
				transMeta.readSharedObjects();
			}
		}
		//--------------------设置变量-------------------
		if(variableMap!=null){
			Set<Entry<String, String>> entryset = variableMap.entrySet();
			for(Entry<String, String> entry:entryset){
				transMeta.setVariable(entry.getKey(), entry.getValue());
			}
		}
		//--------------------设置参数-------------------
		if(parameterValueMap!=null){
			Set<Entry<String, String>>parameterset = parameterValueMap.entrySet();
			for(Entry<String, String> entry:parameterset){
				transMeta.setParameterValue(entry.getKey(), entry.getValue());
			}
		}
	}

	
	/** 执行转换
	 * @param path文件路径
	 * @param variableMap 变量
	 * @return
	 */
	public Map<String, Object> excuteTran(String path,Map<String,String> variableMap,Map<String,String> parameterValueMap,String sharePath) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(StringUtil.isBlank(sharePath)){
				sharePath = getShareXmlPath();
			}
			KettleEnvironment.init();
			TransMeta transMeta = new TransMeta(path);
			setProperty(variableMap, parameterValueMap, sharePath, transMeta);
			Trans trans = new Trans(transMeta);
			trans.prepareExecution(null);
			trans.startThreads();
			trans.setLogLevel(LogLevel.BASIC);
			trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				map.put("result", "failure");
			} else {
				map.put("result", "success");
			}
			org.pentaho.di.core.logging.LoggingBuffer loggingBuffer = KettleLogStore.getAppender();
		    StringBuffer logTextBuffer = loggingBuffer.getBuffer( trans.getLogChannel().getLogChannelId(), false );
		    map.put("logTextBuffer", logTextBuffer.toString());
			Result rs = trans.getResult();
			map.put("resultInfo", rs);
		} catch (KettleException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**执行资源库内的tran
	 * @param databaseRepositoryInfo 资源库的信息
	 * @param variableMap 变量
	 * @param parameterValueMap 参数
	 * @param tranName  调用的专业名称
	 * @param sharePath
	 * @return
	 */
	public Map<String, Object> excuteDBTran(Map<String,String> variableMap,Map<String,String> parameterValueMap,String tranName,String sharePath) {
		 RepositoriesMeta repositoriesMeta = new RepositoriesMeta();  
		 Map<String, Object> map = new HashMap<String, Object>();
		try {
			Repository repository = initRepository(repositoriesMeta); 
			RepositoryDirectoryInterface directoryInterface = repository.loadRepositoryDirectoryTree();
		    TransMeta transMeta=repository.loadTransformation(tranName,directoryInterface,null,true,null);
		    setProperty(variableMap, parameterValueMap, sharePath, transMeta);
			Trans trans = new Trans(transMeta);
			trans.prepareExecution(null);
			trans.startThreads();
			trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				map.put("result", "failure");
			} else {
				map.put("result", "success");
			}
			org.pentaho.di.core.logging.LoggingBuffer loggingBuffer = KettleLogStore.getAppender();
		    StringBuffer logTextBuffer = loggingBuffer.getBuffer( trans.getLogChannel().getLogChannelId(), false );
		    map.put("logTextBuffer", logTextBuffer.toString());
			Result rs = trans.getResult();
			map.put("resultInfo", rs);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KettleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	public Map<String, Object> readFromDbStep(String stepName,Map<String,String> variableMap,Map<String,String> parameterValueMap,String tranName,String sharePath) {
		RepositoriesMeta repositoriesMeta = new RepositoriesMeta();  
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Repository repository = initRepository(repositoriesMeta); 
			RepositoryDirectoryInterface directoryInterface = repository.loadRepositoryDirectoryTree();
			TransMeta transMeta=repository.loadTransformation(tranName,directoryInterface,null,true,null);
			setProperty(variableMap, parameterValueMap, sharePath, transMeta);
			Trans trans = new Trans(transMeta);
			trans.prepareExecution(null);
			final List<RowMetaAndData> rows = new ArrayList<RowMetaAndData>();
			RowListener rowListener = new RowAdapter() {
				public void rowWrittenEvent(RowMetaInterface rowMeta,
						Object[] row) throws KettleStepException {
					rows.add(new RowMetaAndData(rowMeta, row));
				}
			};
			StepInterface stepInterface = trans.findRunThread(stepName);
			stepInterface.addRowListener(rowListener);
			trans.startThreads();
			trans.waitUntilFinished();
			if (trans.getErrors() != 0) {
				System.out.println("Error");
				map.put("result", "failure");
			} else {
				map.put("result", "success");
			}
			org.pentaho.di.core.logging.LoggingBuffer loggingBuffer = KettleLogStore.getAppender();
		    StringBuffer logTextBuffer = loggingBuffer.getBuffer( trans.getLogChannel().getLogChannelId(), false );
		    map.put("logTextBuffer", logTextBuffer.toString());
			map.put("resultValue", rows);
			Result rs = trans.getResult();
			map.put("resultInfo", rs);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KettleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	private Repository initRepository(RepositoriesMeta repositoriesMeta)throws UnsupportedEncodingException, IOException, KettleException,KettlePluginException, KettleSecurityException {
		FileInputStream inp;
		String path= getConPath()+KETTLE_REPOSITORIES_XML_PATH;
		inp = FileUtils.openInputStream(new File(path));
		repositoriesMeta.readDataFromInputStream(inp);
		String propath=getConPath()+PROPERTISE_PATH;
		FileInputStream propathinp = FileUtils.openInputStream(new File(propath));
		Properties p = new Properties();
		p.load(propathinp);
		RepositoryMeta repositoryMeta = repositoriesMeta.findRepository(p.getProperty("repositoryParameter.name"));
		Repository repository = PluginRegistry.getInstance().loadClass(RepositoryPluginType.class, repositoryMeta.getId(), Repository.class);  
		repository.init(repositoryMeta);  
		repository.connect(p.getProperty("login.name"),p.getProperty("login.pw"));
		return repository;
	}



	private String getShareXmlPath() throws UnsupportedEncodingException {
		String sharePath;
		String cpath = getConPath();
		sharePath=cpath+KETTLE_SHARE_XML_PATH;
		return sharePath;
	}


	private String getConPath() throws UnsupportedEncodingException {
		URL cllpath = Thread.currentThread().getContextClassLoader().getResource("");
		String cpath=cllpath.getPath();
		cpath=URLDecoder.decode(cpath, "UTF-8");
		return cpath;
	}


	/**执行一个job
	 * @param path 文件路径
	 */
	public void executeJob(String path) {
		try {
			KettleEnvironment.init();
			JobMeta jobMeta = new JobMeta(path, null);
			Job job = new Job(null, jobMeta);
			job.start();
			job.waitUntilFinished();
			
			if (job.getErrors() != 0) {
				System.out.println("Error encountered!");
			}
		} catch (KettleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** 动态修改共享连接信息
	 * @param filePath
	 * @param parameterList
	 * @return
	 * "DB", "MySQL", "JDBC", "localhost", "test", "3306", "user", "password"
	 */
	public  String changeDatabaseInTrans(String filePath,List<DatabaseMetaParameter> parameterList){
		  try {
			 if(StringUtil.isBlank(filePath)){
				  filePath = getShareXmlPath();
			 }
			KettleEnvironment.init();
			if(parameterList!= null && parameterList.size()>0){
				SharedObjects sharedObjects = new SharedObjects();
				for(DatabaseMetaParameter databaseMetaParameter:parameterList){
					DatabaseMeta databaseMeta = new DatabaseMeta(databaseMetaParameter.getName(), databaseMetaParameter.getType(),
							databaseMetaParameter.getAccess(), databaseMetaParameter.getHost(), databaseMetaParameter.getDb(),
							databaseMetaParameter.getPort(), databaseMetaParameter.getUser(), databaseMetaParameter.getPass());
					sharedObjects.storeObject(databaseMeta);
				}
				sharedObjects.setFilename(filePath);
				sharedObjects.saveToFile();
			}
		} catch (KettleException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}
	

}
