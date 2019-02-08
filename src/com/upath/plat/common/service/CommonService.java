package com.upath.plat.common.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.executor.BatchExecutor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.upath.plat.common.dao.BaseDaoSupport;
import com.upath.plat.common.dao.PageHelperPlug;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.page.Ipage;
import com.upath.plat.common.page.Page;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.common.util.RequestHelper;

/**
 * 
 * @author upaths
 *
 */
@SuppressWarnings({ "rawtypes" })
public class CommonService implements ICommonService {

	private Logger logger = LoggerFactory.getLogger(CommonService.class);
	
	protected BaseDaoSupport dao;

	public BaseDaoSupport getDao() {
		return dao;
	}

	@Autowired
	@Qualifier(value = "dao")
	public void setDao(BaseDaoSupport dao) {
		this.dao = dao;
	}

	public int delete(String statement) {
		return this.dao.getSqlSession().delete(statement);
	}

	public int delete(String statement, Object parameter) {
		return this.dao.getSqlSession().delete(statement, parameter);
	}

	public int update(String statement) {
		return this.dao.getSqlSession().update(statement);
	}

	public int update(String statement, Object parameter) {
		return this.dao.getSqlSession().update(statement, parameter);
	}

	public int insert(String statement) {
		return this.dao.getSqlSession().insert(statement);
	}

	public int insert(String statement, Object parameter) {
		return this.dao.getSqlSession().insert(statement, parameter);
	}

	/**
	 * 鎵归噺鎻掑叆
	 * @param list 瑕佹洿鏂扮殑鏁版嵁鍒楄〃
	 * @param mapperId 瀵瑰簲鎵цMYBATIS閰嶇疆鐨凷QLID 鍏ㄨ矾寰�= namespace + id
	 * @return
	 * @throws SQLException
	 * @throws PlatformException
	 */
	public int[] batchInsert(List list,String mapperId) throws PlatformException{
		return batchActionOper(list,mapperId);
	}
	/**
	 * 鎵归噺鏇存柊
	 * @param list 瑕佹洿鏂扮殑鏁版嵁鍒楄〃
	 * @param mapperId 瀵瑰簲鎵цMYBATIS閰嶇疆鐨凷QLID 鍏ㄨ矾寰�= namespace + id
	 * @return
	 * @throws SQLException
	 * @throws PlatformException
	 */
	public int[] batchUpdate(List list,String mapperId)throws   PlatformException{
		return batchActionOper(list,mapperId);
	}
	/**
	 * 鎵归噺鍒犻櫎
	 * @param list 瑕佹洿鏂扮殑鏁版嵁鍒楄〃
	 * @param mapperId 瀵瑰簲鎵цMYBATIS閰嶇疆鐨凷QLID 鍏ㄨ矾寰�= namespace + id
	 * @return
	 * @throws SQLException
	 * @throws PlatformException
	 */
	public int[] batchDelete(List list,String mapperId) throws  PlatformException{
		return batchActionOper(list,mapperId);
	}
	
	protected int[] batchActionOper(List list,String mapperId) throws PlatformException{
		if(list == null || list.isEmpty()){
			throw new PlatformException("鍙傛暟閿欒锛岄渶瑕佹搷浣滅殑鍒楄〃涓嶈兘涓虹┖");
		}
		
		if(mapperId == null || "".equals(mapperId.trim())){
			throw new PlatformException("鍙傛暟閿欒锛岄渶瑕佹墽琛岀殑mapperId 涓嶈兘涓虹┖ ");
		}
		
		Configuration c =	this.dao.getSqlSession().getConfiguration();
		ManagedTransactionFactory managedTransactionFactory = new ManagedTransactionFactory();
		BatchExecutor batchExecutor = new BatchExecutor(c,managedTransactionFactory.newTransaction(this.dao.getSqlSession().getConnection(),false));
		MappedStatement mStmt =   c.getMappedStatement(mapperId);
		if(mStmt == null){
			throw new PlatformException("鍙傛暟閿欒锛屾棤娉曢�杩嘯"+mapperId+"]鎵惧埌瀵瑰簲鐨勯厤缃甅appedStatement");
		}
		try{
			for(Object obj:list){
				batchExecutor.doUpdate(mStmt, obj);
			}
		batchExecutor.flushStatements();
		}catch(SQLException e){
			throw new PlatformException("鎵归噺鎿嶄綔澶辫触",e);
		}
		return null;
	}
	
	
	public List queryList(String selectId, Object param) {
		return dao.getSqlSession().selectList(selectId, param);
	}

	public Map queryMap(String selectId, Object param) {
		return (Map) dao.getSqlSession().selectOne(selectId, param);
	}

	public Object queryObject(String selectId, Object param) {
		return dao.getSqlSession().selectOne(selectId, param);
	}

	public ISequence getPlatSequence() {
		return PlatUtil.getPlatSequence();
	}

	/**
	 * 浣跨敤鎻掍欢妯″紡鏉ヨ繘琛屽垎甯冪殑瀹炵幇
	 * 1锛氳В鍐矼YSQL鐨勫瓙鏌ヨ鏁堢巼浣庝笅鐨勯棶棰�
	 * 2锛氱郴缁熼粯璁や細浣跨敤璇锋眰涓婁笅鏂囩幆澧冧腑鐨勫垎椤典俊鎭潵杩涜瀹炵幇
	 */
	public List queryPageListWithPlug(String selectId , Object params){
		Ipage page = null;
		try{
			page = 	RequestHelper.getInstance().getCurrentPagination();
		}catch(Exception e){
			page = new Page();
		}
		if(page == null){
			page = new Page();
		}
		page.init();
		//浣跨敤蹇�鏌ヨ
		page.setMode(1);
		return queryPageListWithPlug(selectId,params,page);
	}
	
	/**
	 * 浣跨敤鎻掍欢妯″紡鏉ヨ繘琛屽垎甯冪殑瀹炵幇
	 * 鍙互鑷繁瀹氫箟Page鐨勬煡璇㈡柟娉�
	 */
	public List queryPageListWithPlug(String selectId , Object params,Ipage page){
		if(page == null){
			throw new PlatformException("鍒嗛〉鍙傛暟锛屼笉鍏佽涓虹┖");
		}
		List datas = null;
		try{
			PageHelperPlug.startPage(page);
			datas = this.dao.getSqlSession().selectList(selectId, params);
			try {
				HttpServletRequest request = 	RequestHelper.getInstance().getReuest();
				request.setAttribute("pdata", page);
			} catch (Exception e) {
				logger.warn("璋冪敤鍒嗛〉娌℃湁鍙戠幇Request璇锋眰瀵硅薄锛岃鍙傛暟涓幏鍙栧垎椤典俊鎭�");
			}
		}finally{
			//鏄剧ず绉婚櫎鍒嗛〉鍙傛暟
			PageHelperPlug.endPage();
		}
		return datas;
	}
	
	/*
	public List queryPageList(String selectId, Map param)
			throws PlatformException {
		return getPageList(selectId,param);
	}

	public List queryPageList(String selectId, IPagination param)
			throws PlatformException {
		return  getPageList(selectId,param);
	}
	*/
	public List queryPageList(String selectId , Object params){
		Ipage page = null;
		try{
			page = 	RequestHelper.getInstance().getCurrentPagination();
			if(page == null ){
				page = new Page();
			}
		}catch(Exception e){
			page = new Page();
		}
		page.init();
		page.setMode(1);
		return queryPageListWithPlug(selectId, params, page);
	}
}
