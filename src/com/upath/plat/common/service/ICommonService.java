package com.upath.plat.common.service;

import java.util.List;
import java.util.Map;

import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.page.Ipage;
/**
 * 接口只对外提供数据查询的功能，
 * 进行数据更新操作的功能不建议对外进行功能，
 * 统一放在业务的Service里面进行统一调用
 * @author upaths
 *
 */
@SuppressWarnings({ "rawtypes"})
public interface ICommonService {
	
	List queryList(String selectId,Object param) throws PlatformException;
	
	List queryPageList(String selectId,Object param) throws PlatformException;
	/**
	 * 使用 Mybatis 的插件来进行分页
	 * @param selectId
	 * @param params
	 * @return
	 * @throws PlatformException
	 */
	List queryPageListWithPlug(String selectId , Object params,Ipage page) throws PlatformException;
	
	Object queryObject(String selectId,Object param) throws PlatformException;
	
	Map  queryMap(String selectId,Object param) throws PlatformException;
	
	ISequence getPlatSequence() throws PlatformException;
}
