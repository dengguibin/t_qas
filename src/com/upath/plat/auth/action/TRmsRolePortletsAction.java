
/**
 */
package com.upath.plat.auth.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.tree.DefaultAttribute;
import org.dom4j.tree.DefaultElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.constant.PortletsConstant;
import com.upath.plat.auth.facade.IRole;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.auth.mapper.TRmsRolePortletsMapper;
import com.upath.plat.auth.mapper.TRmsUserPortletsMapper;
import com.upath.plat.auth.model.TRmsRolePortlets;
import com.upath.plat.auth.model.TRmsUserPortlets;
import com.upath.plat.auth.service.TRmsRolePortletsService;
import com.upath.plat.auth.service.TRmsUserPortletsService;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.cache.AuthCacheManager;
import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.common.util.StringUtil;

/**
 * @ClassName: TRmsRolePortletsAction.java
 * @Description: t_rms_role_portlets
 * @author upaths@gmail.com
 * @date2015-6-9 13:59:14
 * @version V1.0
 */
@Scope("prototype")
@Component("trmsRolePortletsAction")
@SuppressWarnings({ "rawtypes", "serial", "unchecked", "unused" })
public class TRmsRolePortletsAction extends BaseActionSupport {

	private static final String templatePath = "template/portlets-config.xml";
	private static final Logger log = Logger
			.getLogger(TRmsRolePortletsAction.class);

	private TRmsRolePortletsService service;

	private TRmsUserPortletsService trmsUserPortletsService;

	private TRmsRolePortlets bean;

	private List datas;

	private String proId;

	private String code;

	/**
	 * 根据某个模块获取信息
	 * 
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 * @throws URISyntaxException
	 */
	public String findDefaultPortlets() throws IOException, DocumentException,
			URISyntaxException {
		// ------------获取文件---------------------------
		// URL path =
		// Thread.currentThread().getContextClassLoader().getResource(templatePath);
		String path = getPath() + templatePath;
		File templateFile = new File(path);
		if (templateFile.exists() == false) {
			response.setContentType("text/html; charset=UTF-8");
			String script = "<script>alert('模板源文件不存在')</script>";
			response.getWriter().print(script);
			return null;
		}
		Map<String, String> roleModuleMap = new HashMap<String, String>();
		Map<String, Map<String, String>> resultMap = new HashMap<String, Map<String, String>>();// key是模块的ID，value是模块的详细信息
		List<Map<String, String>> projectAttrList = new ArrayList<Map<String, String>>();// 方案的信息，id，name
																							// 等属性
		List<Map<String, String>> rowList = new ArrayList<Map<String, String>>();// 所有行
		String encode = "utf-8";
		String text = FileUtils.readFileToString(templateFile, encode);
		Document document = DocumentHelper.parseText(text);
		Element root = document.getRootElement();
		Element modules = root.element(PortletsConstant.ROOT_MODULES);
		List moduleList = modules.elements(PortletsConstant.MODULE);
		// ----------------------获得模块信息的MAP key是模块Map<id,map<属性名称，属性值>>
		// -------------------------------------
		fullModuleMap(resultMap, moduleList);
		// ----------------------获得模块信息结束-------------------------------------
		// -----------------------获得方案列表模块列表------------------------------------

		Element projects = root.element(PortletsConstant.ROOT_PORTLETS);
		List projectList = projects.elements(PortletsConstant.PROJECT);
		if (projectList != null && projectList.size() > 0) {
			int len = projectList.size();
			for (int i = 0; i < len; i++) {
				Map<String, String> projectMap = new HashMap<String, String>();
				// ----------获得project（方案）的信息
				DefaultElement project = (DefaultElement) projectList.get(i);
				Iterator<?> alt = project.attributeIterator();
				while (alt.hasNext()) {
					DefaultAttribute defaultAttribute = (DefaultAttribute) alt
							.next();
					projectMap.put(defaultAttribute.getName(),
							defaultAttribute.getValue());
				}
				projectAttrList.add(projectMap);
				if (StringUtil.isBlank(proId) && i == 0) {
					proId = projectMap.get("id");
				}
				if (!StringUtil.equals(proId, projectMap.get("id"))) {
					continue;
				}
				// -----------获得模块角色列表------------------
				TRmsRolePortlets selectBean = new TRmsRolePortlets();
				selectBean.setProid(proId);
				List objList = service.queryNoPage(selectBean);

				if (objList != null && objList.size() > 0) {
					int objListSize = objList.size();
					for (int k = 0; k < objListSize; k++) {
						Map<String, Object> trmsRolePortletsMap = (Map<String, Object>) objList
								.get(k);
						String moduleId = String.valueOf(trmsRolePortletsMap
								.get("MODULEID"));
						String jsid = String.valueOf(trmsRolePortletsMap
								.get("JSID"));
						String v = roleModuleMap.get(moduleId);
						if (StringUtil.isEmpty(v)) {
							roleModuleMap.put(moduleId, jsid);
						} else {
							v = v + "," + jsid;
							roleModuleMap.put(moduleId, v);
						}
					}
				}
				// -----------获得列的信息------------
				Iterator ei = project
						.elementIterator(PortletsConstant.PROJECT_COLUMN);
				while (ei.hasNext()) {
					DefaultElement defaultElement = (DefaultElement) ei.next();
					// ---------获得行的信息------------
					Iterator roweiItl = defaultElement
							.elementIterator(PortletsConstant.COLUMN_ROW);
					while (roweiItl.hasNext()) {
						Map<String, String> rowMap = new HashMap<String, String>();
						DefaultElement rowei = (DefaultElement) roweiItl.next();
						fullRowMap(rowMap, rowei);
						rowList.add(rowMap);
					}
				}
			}
		}
		AuthCacheManager am = AuthCacheManager.getInstance();
		List<IRole> roles = am.getAllRoles();
		request.setAttribute("roleModuleMap", roleModuleMap);// 角色和模块的映射映射关系
		request.setAttribute("roles", roles);// 角色信息
		request.setAttribute("resultMap", resultMap);// 所有模块的信息
		request.setAttribute("projectAttrList", projectAttrList);// 方案的信息
		request.setAttribute("rowList", rowList);// 所有行的信息
		// -----------------------获得方案列表模块列表结束----------------------------------------------
		return FORWARD_LIST;
	}

	/**
	 * @return 预览默认门户
	 * @throws IOException
	 * @throws DocumentException
	 */
	public String showDefaultPortlets() throws IOException, DocumentException {
		// ------------获取文件---------------------------
		Map<String, Map<String, String>> resultMap = new HashMap<String, Map<String, String>>();// key是模块的ID，value是模块的详细信息
		Map<String, List<Map<String, String>>> rowMapList = new HashMap<String, List<Map<String, String>>>();// key是column的id属性
																												// value是row的内容list
		List<Map<String, String>> columnList = new ArrayList<Map<String, String>>();
		// URL path =
		// Thread.currentThread().getContextClassLoader().getResource("");
		// File templateFile = new File(path.getFile() + templatePath);
		String path = getPath() + templatePath;
		File templateFile = new File(path);
		if (templateFile.exists() == false) {
			response.setContentType("text/html; charset=UTF-8");
			String script = "<script>alert('模板源文件不存在')</script>";
			response.getWriter().print(script);
			return null;
		}
		String encode = "utf-8";
		String text = FileUtils.readFileToString(templateFile, encode);
		Document document = DocumentHelper.parseText(text);
		Element root = document.getRootElement();
		Element modules = root.element(PortletsConstant.ROOT_MODULES);
		List moduleList = modules.elements(PortletsConstant.MODULE);
		// ----------------------获得模块信息的MAP key是模块Map<id,map<属性名称，属性值>>
		// -------------------------------------
		fullModuleMap(resultMap, moduleList);
		// ----------------------获得模块信息结束-------------------------------------
		// -----------------------获得方案列表模块列表------------------------------------

		Element projects = root.element(PortletsConstant.ROOT_PORTLETS);
		List projectList = projects.elements(PortletsConstant.PROJECT);
		if (projectList != null && projectList.size() > 0) {
			int len = projectList.size();
			for (int i = 0; i < len; i++) {
				Map<String, String> projectMap = new HashMap<String, String>();
				// ----------获得project（方案）的信息
				DefaultElement project = (DefaultElement) projectList.get(i);
				Iterator alt = project.attributeIterator();
				while (alt.hasNext()) {
					DefaultAttribute defaultAttribute = (DefaultAttribute) alt
							.next();
					projectMap.put(defaultAttribute.getName(),
							defaultAttribute.getValue());
				}
				if (StringUtil.isBlank(proId) && i == 0) {
					proId = projectMap.get("id");
				}
				if (!StringUtil.equals(proId, projectMap.get("id"))) {
					continue;
				}
				// -----------获得列的信息------------
				Iterator ei = project
						.elementIterator(PortletsConstant.PROJECT_COLUMN);
				while (ei.hasNext()) {
					List<Map<String, String>> rowList = new ArrayList<Map<String, String>>();
					DefaultElement defaultElement = (DefaultElement) ei.next();
					Iterator colAttrIte = defaultElement.attributeIterator();
					Map<String, String> colAttrMap = new HashMap<String, String>();
					while (colAttrIte.hasNext()) {
						DefaultAttribute colDefaultAttribute = (DefaultAttribute) colAttrIte
								.next();
						colAttrMap.put(colDefaultAttribute.getName(),
								colDefaultAttribute.getValue());
					}
					columnList.add(colAttrMap);
					String columnId = colAttrMap.get("id");
					// ---------获得行的信息------------
					Iterator roweiItl = defaultElement
							.elementIterator(PortletsConstant.COLUMN_ROW);
					while (roweiItl.hasNext()) {
						Map<String, String> rowMap = new HashMap<String, String>();
						DefaultElement rowei = (DefaultElement) roweiItl.next();
						fullRowMap(rowMap, rowei);
						rowList.add(rowMap);
					}
					rowMapList.put(columnId, rowList);
				}
				break;
			}
		}
		request.setAttribute("resultMap", resultMap);
		request.setAttribute("columnList", columnList);
		request.setAttribute("rowMapList", rowMapList);
		// -----------------------获得方案列表模块列表结束----------------------------------------------
		return FORWARD_LIST;
	}

	public String findUserPortlets() throws Exception {
		IUser user = getLoginUser();
		List<IRole> roleList = user.getRoles();
		Map<String, Map<String, String>> resultMap = new HashMap<String, Map<String, String>>();// key是模块的ID，value是模块的详细信息
		List<Map<String, String>> projectAttrList = new ArrayList<Map<String, String>>();// 方案的信息，id，name
																							// 等属性
		List<Map<String, String>> columnList = new ArrayList<Map<String, String>>();
		Map<String, List<Map<String, String>>> rowMapList = new HashMap<String, List<Map<String, String>>>();// key是column的id属性
																												// value是row的内容list
		// ---------解析模板--------------------
		String path = getPath() + templatePath;
		File templateFile = new File(path);
		if (templateFile.exists() == false) {
			response.setContentType("text/html; charset=UTF-8");
			String script = "<script>alert('模板源文件不存在')</script>";
			response.getWriter().print(script);
			return null;
		}
		String encode = "utf-8";
		String text = FileUtils.readFileToString(templateFile, encode);
		Document document = DocumentHelper.parseText(text);
		Element root = document.getRootElement();
		Element modules = root.element(PortletsConstant.ROOT_MODULES);
		List moduleList = modules.elements(PortletsConstant.MODULE);
		// ----------------------获得模块信息的MAP key是模块Map<id,map<属性名称，属性值>>
		// -------------------------------------
		fullModuleMap(resultMap, moduleList);
		Element projects = root.element(PortletsConstant.ROOT_PORTLETS);
		List projectList = projects.elements(PortletsConstant.PROJECT);
		if (projectList != null && projectList.size() > 0) {
			int len = projectList.size();
			for (int i = 0; i < len; i++) {
				Map<String, String> projectMap = new HashMap<String, String>();
				// ----------获得project（方案）的信息
				DefaultElement project = (DefaultElement) projectList.get(i);
				Iterator alt = project.attributeIterator();
				while (alt.hasNext()) {
					DefaultAttribute defaultAttribute = (DefaultAttribute) alt
							.next();
					projectMap.put(defaultAttribute.getName(),
							defaultAttribute.getValue());
				}
				projectAttrList.add(projectMap);
				if (StringUtil.isBlank(proId) && i == 0) {
					proId = projectMap.get("id");
				}
				if (!StringUtil.equals(proId, projectMap.get("id"))) {
					continue;
				}
				TRmsRolePortlets trmsRolePortlets = new TRmsRolePortlets();
				trmsRolePortlets.setRoleList(roleList);
				trmsRolePortlets.setProid(proId);
				// 根据角色去查找相关的模块权限
				List list = service.queryModuleId(trmsRolePortlets);
				// -----------获得列的信息------------
				Iterator ei = project
						.elementIterator(PortletsConstant.PROJECT_COLUMN);
				while (ei.hasNext()) {
					List<Map<String, String>> rowList = new ArrayList<Map<String, String>>();
					DefaultElement defaultElement = (DefaultElement) ei.next();
					Iterator colAttrIte = defaultElement.attributeIterator();
					Map<String, String> colAttrMap = new HashMap<String, String>();
					while (colAttrIte.hasNext()) {
						DefaultAttribute colDefaultAttribute = (DefaultAttribute) colAttrIte
								.next();
						colAttrMap.put(colDefaultAttribute.getName(),
								colDefaultAttribute.getValue());
					}
					columnList.add(colAttrMap);
					String columnId = colAttrMap.get("id");
					// ---------获得行的信息------------
					Iterator roweiItl = defaultElement
							.elementIterator(PortletsConstant.COLUMN_ROW);
					while (roweiItl.hasNext()) {
						Map<String, String> rowMap = new HashMap<String, String>();
						DefaultElement rowei = (DefaultElement) roweiItl.next();
						fullRowMap(rowMap, rowei);
						if (list.contains(rowMap
								.get(PortletsConstant.ROW_ATTR_REF))) {
							rowList.add(rowMap);
						}
					}
					rowMapList.put(columnId, rowList);
				}
			}
		}
		request.setAttribute("projectAttrList", projectAttrList);
		request.setAttribute("resultMap", resultMap);
		request.setAttribute("columnList", columnList);
		request.setAttribute("rowMapList", rowMapList);
		return FORWARD_LIST;
	}

	/**
	 * @return 查询用户个性化配置，如果没有就显示默认的配置
	 * @throws IOException
	 * @throws DocumentException
	 */
	public String findUserDevPortlets() throws Exception {
		Map<String, Map<String, String>> resultMap = new HashMap<String, Map<String, String>>();// key是模块的ID，value是模块的详细信息
		List<Map<String, String>> projectAttrList = new ArrayList<Map<String, String>>();// 方案的信息，id，name
																							// 等属性
		List<Map<String, String>> columnList = new ArrayList<Map<String, String>>();
		Map<String, List<Map<String, String>>> rowMapList = new HashMap<String, List<Map<String, String>>>();// key是column的id属性
																												// value是row的内容list
		// ---------解析模板--------------------
		String path = getPath() + templatePath;
		File templateFile = new File(path);
		if (templateFile.exists() == false) {
			response.setContentType("text/html; charset=UTF-8");
			String script = "<script>alert('模板源文件不存在')</script>";
			response.getWriter().print(script);
			return null;
		}
		String encode = "utf-8";
		String text = FileUtils.readFileToString(templateFile, encode);
		Document document = DocumentHelper.parseText(text);
		Element root = document.getRootElement();
		Element modules = root.element(PortletsConstant.ROOT_MODULES);
		List moduleList = modules.elements(PortletsConstant.MODULE);
		// ----------------------获得模块信息的MAP key是模块Map<id,map<属性名称，属性值>>
		// -------------------------------------
		fullModuleMap(resultMap, moduleList);
		IUser user = getLoginUser();
		List<IRole> roleList = user.getRoles();

		Element projects = root.element(PortletsConstant.ROOT_PORTLETS);
		List projectList = projects.elements(PortletsConstant.PROJECT);
		if (projectList != null && projectList.size() > 0) {
			Map<String, Map<String, String>> rmap = new HashMap<String, Map<String, String>>();
			int len = projectList.size();
			for (int i = 0; i < len; i++) {
				Map<String, String> projectMap = new HashMap<String, String>();
				// ----------获得project（方案）的信息
				DefaultElement project = (DefaultElement) projectList.get(i);
				Iterator alt = project.attributeIterator();
				while (alt.hasNext()) {
					DefaultAttribute defaultAttribute = (DefaultAttribute) alt
							.next();
					projectMap.put(defaultAttribute.getName(),
							defaultAttribute.getValue());
				}
				projectAttrList.add(projectMap);
				if (StringUtil.isBlank(proId) && i == 0) {
					proId = projectMap.get("id");
				}
				if (!StringUtil.equals(proId, projectMap.get("id"))) {
					continue;
				}
				// ---------------查询用户的模块列表-----------
				TRmsUserPortlets trmsUserPortlets = new TRmsUserPortlets();
				trmsUserPortlets.setProid(proId);
				trmsUserPortlets.setUserid(user.getUserId());
				List<Map<String, Object>> trmsUserPortletsList = trmsUserPortletsService
						.findList(trmsUserPortlets);
				boolean flag = false;
				if (trmsUserPortletsList != null
						&& trmsUserPortletsList.size() > 0) {
					flag = true;
					for (Map<String, Object> trmsUserPortletsMap : trmsUserPortletsList) {
						Map<String, String> rowMap = new HashMap<String, String>();
						String colId = String.valueOf(trmsUserPortletsMap
								.get("COL_Y"));
						String ref = String.valueOf(trmsUserPortletsMap
								.get("MODULEID"));
						String sfyx = String.valueOf(trmsUserPortletsMap
								.get("SFYX"));
						String colcount = String.valueOf(trmsUserPortletsMap
								.get("COLCOUNT") == null ? "1"
								: trmsUserPortletsMap.get("COLCOUNT"));
						String rowcount = String.valueOf(trmsUserPortletsMap
								.get("ROWCOUNT") == null ? "1"
								: trmsUserPortletsMap.get("ROWCOUNT"));
						rowMap.put(PortletsConstant.ROW_ATTR_REF, ref);
						rowMap.put("sfyx", sfyx);
						rowMap.put("colcount", colcount);
						rowMap.put("rowcount", rowcount);
						List<Map<String, String>> rlist = rowMapList.get(colId);
						if (rlist == null) {
							rlist = new ArrayList<Map<String, String>>();
							rlist.add(rowMap);
							rowMapList.put(colId, rlist);
						} else {
							rlist.add(rowMap);
						}
					}
				}
				TRmsRolePortlets trmsRolePortlets = new TRmsRolePortlets();
				trmsRolePortlets.setRoleList(roleList);
				trmsRolePortlets.setProid(proId);
				// 该用户所有的有权限的模块
				List list = service.queryModuleId(trmsRolePortlets);
				// -----------获得列的信息------------
				Iterator ei = project
						.elementIterator(PortletsConstant.PROJECT_COLUMN);

				while (ei.hasNext()) {
					List<Map<String, String>> rowList = new ArrayList<Map<String, String>>();
					DefaultElement defaultElement = (DefaultElement) ei.next();
					Iterator colAttrIte = defaultElement.attributeIterator();
					Map<String, String> colAttrMap = new HashMap<String, String>();
					while (colAttrIte.hasNext()) {
						DefaultAttribute colDefaultAttribute = (DefaultAttribute) colAttrIte
								.next();
						colAttrMap.put(colDefaultAttribute.getName(),
								colDefaultAttribute.getValue());
					}
					columnList.add(colAttrMap);
					String columnId = colAttrMap.get("id");
					// ---------获得行的信息------------
					Iterator roweiItl = defaultElement
							.elementIterator(PortletsConstant.COLUMN_ROW);
					while (roweiItl.hasNext()) {
						Map<String, String> rowMap = new HashMap<String, String>();
						DefaultElement rowei = (DefaultElement) roweiItl.next();
						fullRowMap(rowMap, rowei);
						// 如果角色授权里面包含有
						if (list.contains(rowMap
								.get(PortletsConstant.ROW_ATTR_REF))) {
							if (flag) {
								rmap.put(rowMap
										.get(PortletsConstant.ROW_ATTR_REF),
										rowMap);
							} else {
								rowMap.put("sfyx", "1");
								rowList.add(rowMap);
							}
						}
					}
					if (!flag) {
						rowMapList.put(columnId, rowList);
					}
				}
				if (flag) {
					Set<Entry<String, List<Map<String, String>>>> eset = rowMapList
							.entrySet();
					for (Entry<String, List<Map<String, String>>> entry : eset) {
						List<Map<String, String>> setList = entry.getValue();
						for (Map<String, String> m : setList) {
							String key = m.get(PortletsConstant.ROW_ATTR_REF);
							Map<String, String> tm = rmap.get(key);
							list.remove(key);
							if (tm != null) {
								m.putAll(tm);
							}
						}
					}
				}
				break;
			}
		}
		request.setAttribute("resultMap", resultMap);
		request.setAttribute("columnList", columnList);
		request.setAttribute("rowMapList", rowMapList);
		return FORWARD_LIST;
	}

	public String hiddenUserPortlets() throws IOException {
		Map<String, String> result = new HashMap<String, String>();
		String columnData = request.getParameter("columnData");
		IUser user = getLoginUser();
		String userid = user.getUserId();
		try {
			TRmsUserPortlets trmsUserPortlets = new TRmsUserPortlets();
			trmsUserPortlets.setUserid(userid);
			trmsUserPortlets.setProid(proId);
			trmsUserPortlets.setModuleid(columnData);
			trmsUserPortletsService.deleteByPro(trmsUserPortlets);
			result.put("MSG", "TRUE");
		} catch (Exception e) {
			result.put("MSG", "FALSE");
		}
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}

	/**
	 * 获取用户所有有权限的行列表
	 * 
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public String findUserRowList() throws Exception {
		Map<String, Map<String, String>> resultMap = new HashMap<String, Map<String, String>>();// key是模块的ID，value是模块的详细信息
		IUser user = getLoginUser();
		List<IRole> roleList = user.getRoles();
		TRmsRolePortlets trmsRolePortlets = new TRmsRolePortlets();
		trmsRolePortlets.setRoleList(roleList);
		trmsRolePortlets.setProid(proId);
		String columnId = "";
		// 该用户所有的有权限的模块
		List<String> list = service.queryModuleId(trmsRolePortlets);
		String path = getPath() + templatePath;
		File templateFile = new File(path);
		if (templateFile.exists() == false) {
			response.setContentType("text/html; charset=UTF-8");
			String script = "<script>alert('模板源文件不存在')</script>";
			response.getWriter().print(script);
			return null;
		}
		String encode = "utf-8";
		String text = FileUtils.readFileToString(templateFile, encode);
		Document document = DocumentHelper.parseText(text);
		Element root = document.getRootElement();
		Element modules = root.element(PortletsConstant.ROOT_MODULES);
		List moduleList = modules.elements(PortletsConstant.MODULE);
		// ----------------------获得模块信息的MAP key是模块Map<id,map<属性名称，属性值>>
		// -------------------------------------
		fullModuleMap(resultMap, moduleList);
		// -----------获取用户所授权的信息-------
		TRmsUserPortlets trmsUserPortlets = new TRmsUserPortlets();
		trmsUserPortlets.setProid(proId);
		trmsUserPortlets.setSfyx(1);
		trmsUserPortlets.setUserid(user.getUserId());
		List<String> trmsUserPortletsList = trmsUserPortletsService
				.findRowList(trmsUserPortlets);
		List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
		Element projects = root.element(PortletsConstant.ROOT_PORTLETS);
		List projectList = projects.elements(PortletsConstant.PROJECT);
		Map<String, Map<String, String>> columnRowMap = new HashMap<String, Map<String, String>>();
		if (projectList != null && projectList.size() > 0) {
			int len = projectList.size();
			for (int i = 0; i < len; i++) {
				Map<String, String> projectMap = new HashMap<String, String>();
				// ----------获得project（方案）的信息
				DefaultElement project = (DefaultElement) projectList.get(i);
				Iterator alt = project.attributeIterator();
				while (alt.hasNext()) {
					DefaultAttribute defaultAttribute = (DefaultAttribute) alt
							.next();
					projectMap.put(defaultAttribute.getName(),
							defaultAttribute.getValue());
				}
				if (StringUtil.isBlank(proId) && i == 0) {
					proId = projectMap.get("id");
				}
				if (!StringUtil.equals(proId, projectMap.get("id"))) {
					continue;
				}
				// -----------获得列的信息------------
				Iterator ei = project
						.elementIterator(PortletsConstant.PROJECT_COLUMN);
				while (ei.hasNext()) {
					DefaultElement defaultElement = (DefaultElement) ei.next();
					Iterator colAttrIte = defaultElement.attributeIterator();
					Map<String, String> colAttrMap = new HashMap<String, String>();
					while (colAttrIte.hasNext()) {
						DefaultAttribute colDefaultAttribute = (DefaultAttribute) colAttrIte
								.next();
						colAttrMap.put(colDefaultAttribute.getName(),
								colDefaultAttribute.getValue());
					}
					columnId = colAttrMap.get("id");
					// ---------获得行的信息------------
					Iterator roweiItl = defaultElement
							.elementIterator(PortletsConstant.COLUMN_ROW);
					while (roweiItl.hasNext()) {
						Map<String, String> rowMap = new HashMap<String, String>();
						DefaultElement rowei = (DefaultElement) roweiItl.next();
						fullRowMap(rowMap, rowei);
						columnRowMap.put(
								rowMap.get(PortletsConstant.ROW_ATTR_REF),
								rowMap);
					}
				}
				break;
			}
		}
		for (String moldulId : list) {
			Map<String, String> m = resultMap.get(moldulId);
			m.putAll(columnRowMap.get(moldulId));
			if (trmsUserPortletsList.contains(moldulId)) {
				m.put("isCheck", "true");
			} else {
				m.put("isCheck", "false");
			}
			resultList.add(m);
		}
		request.setAttribute("resultList", resultList);
		request.setAttribute("columnId", columnId);
		return FORWARD_LIST;
	}

	public String updateUserPortlets() {
		String columnData = request.getParameter("columnData");
		String columnId = request.getParameter("columnId");
		String[] rowIdArray = StringUtil.split(columnData, ",");
		int len = rowIdArray.length;
		IUser user = getLoginUser();
		String userid = user.getUserId();
		List<TRmsUserPortlets> list = new ArrayList<TRmsUserPortlets>(len);
		if (rowIdArray.length > 0) {
			for (int i = 0; i < len; i++) {
				TRmsUserPortlets trmsUserPortlets = new TRmsUserPortlets();
				trmsUserPortlets.setCid(IDGenerator.getUUID());
				trmsUserPortlets.setUserid(userid);
				trmsUserPortlets.setProid(proId);
				trmsUserPortlets.setModuleid(rowIdArray[i]);
				trmsUserPortlets.setCol_y(columnId);
				trmsUserPortlets.setRow_x(i + 20);
				trmsUserPortlets.setCjr(userid);
				trmsUserPortlets.setCjsj(new Date());
				trmsUserPortlets.setSfyx(1);
				list.add(trmsUserPortlets);
			}
		}
		trmsUserPortletsService.batchInsertUserPortlets(list,
				TRmsUserPortletsMapper.class.getName() + ".insert", userid,
				proId);
		return FORWARD_SAVE;
	}

	public String saveUserDevPortlets() {
		String columnData = request.getParameter("columnData");
		JSONArray dataJson = JSONArray.fromObject(columnData);
		Object arrayObject = JSONArray.toArray(dataJson);
		IUser user = getLoginUser();
		String userid = user.getUserId();
		List<TRmsUserPortlets> list = new ArrayList<TRmsUserPortlets>();
		if (arrayObject != null) {
			Object[] array = (Object[]) arrayObject;
			int len = array.length;
			for (int i = 0; i < len; i++) {
				MorphDynaBean morphDynaBean = (MorphDynaBean) array[i];
				String column = String.valueOf(morphDynaBean.get("column"));
				String row = String.valueOf(morphDynaBean.get("row"));
				if (StringUtil.isNotEmpty(row)) {
					String[] rowArray = StringUtil.split(row, "#");
					int rowlen = rowArray.length;
					for (int k = 0; k < rowlen; k++) {
						String module = rowArray[k];
						String[] moduleArray = StringUtil.split(module, "@");
						int sfyx = 0;
						if (moduleArray != null && moduleArray.length > 1) {
							sfyx = Integer.valueOf(moduleArray[3]);
						}

						TRmsUserPortlets trmsUserPortlets = new TRmsUserPortlets();
						trmsUserPortlets.setColcount(Integer
								.valueOf(moduleArray[1]));
						trmsUserPortlets.setRowcount(Integer
								.valueOf(moduleArray[2]));
						trmsUserPortlets.setCid(IDGenerator.getUUID());
						trmsUserPortlets.setUserid(userid);
						trmsUserPortlets.setProid(proId);
						trmsUserPortlets.setModuleid(moduleArray[0]);
						trmsUserPortlets.setCol_y(column);
						trmsUserPortlets.setRow_x(k);
						trmsUserPortlets.setCjr(userid);
						trmsUserPortlets.setCjsj(new Date());
						trmsUserPortlets.setSfyx(sfyx);
						list.add(trmsUserPortlets);
					}
				}
			}
		}
		trmsUserPortletsService.batchInsert(list,
				TRmsUserPortletsMapper.class.getName() + ".insert", proId,
				userid);
		return FORWARD_SAVE;
	}

	private void fullRowMap(Map<String, String> rowMap, DefaultElement rowei) {
		Attribute ref = rowei.attribute(PortletsConstant.ROW_ATTR_REF);
		Attribute movable = rowei.attribute(PortletsConstant.ROW_ATTR_MOVABLE);
		Attribute closed = rowei.attribute(PortletsConstant.ROW_ATTR_CLOSED);
		Attribute show = rowei.attribute(PortletsConstant.ROW_ATTR_SHOW);
		Attribute id = rowei.attribute(PortletsConstant.ROW_ATTR_ID);
		rowMap.put(PortletsConstant.ROW_ATTR_REF, ref.getValue());
		rowMap.put(PortletsConstant.ROW_ATTR_ID, id.getValue());
		rowMap.put(PortletsConstant.ROW_ATTR_MOVABLE, movable == null ? "true"
				: movable.getValue());
		rowMap.put(PortletsConstant.ROW_ATTR_CLOSED, closed == null ? "true"
				: closed.getValue());
		rowMap.put(PortletsConstant.ROW_ATTR_SHOW,
				show == null ? "true" : show.getValue());
	}

	private void fullModuleMap(Map<String, Map<String, String>> resultMap,
			List moduleList) {
		if (moduleList != null && moduleList.size() > 0) {
			int size = moduleList.size();
			for (int i = 0; i < size; i++) {
				DefaultElement defaultElement = (DefaultElement) moduleList
						.get(i);
				// 获取ID的属性
				DefaultAttribute defaultAttribute = (DefaultAttribute) defaultElement
						.attribute("id");
				String id = defaultAttribute.getValue();
				Iterator elt = defaultElement.elementIterator();
				Map<String, String> proMap = new HashMap<String, String>();
				while (elt.hasNext()) {
					// 获取内容
					DefaultElement defaultelt = (DefaultElement) elt.next();
					String eleName = defaultelt.getName();
					String eleValue = defaultelt.getStringValue();
					proMap.put(eleName, eleValue);
				}
				resultMap.put(id, proMap);
			}
		}
	}

	public String saveRolePortlets() {
		Map<String, String> result = new HashMap<String, String>();
		try {

			result.put("result", "success");
			String roleData = request.getParameter("roleData");
			JSONArray dataJson = JSONArray.fromObject(roleData);
			Object arrayObject = JSONArray.toArray(dataJson);
			IUser user = getLoginUser();
			String userid = user.getUserId();
			List<TRmsRolePortlets> list = new ArrayList<TRmsRolePortlets>();
			if (arrayObject != null) {
				Object[] array = (Object[]) arrayObject;
				int len = array.length;
				for (int i = 0; i < len; i++) {
					MorphDynaBean morphDynaBean = (MorphDynaBean) array[i];
					String moduleId = String.valueOf(morphDynaBean
							.get("moduleId"));
					String roles = String.valueOf(morphDynaBean.get("roles"));
					if (StringUtil.isNotBlank(roles)) {
						String[] roleArray = StringUtil.split(roles, "#");
						int roleLen = roleArray.length;
						for (int j = 0; j < roleLen; j++) {
							String roleId = roleArray[j];
							TRmsRolePortlets trmsRolePortlets = new TRmsRolePortlets();
							trmsRolePortlets.setCid(IDGenerator.getUUID());
							trmsRolePortlets.setCjr(userid);
							trmsRolePortlets.setCjsj(new Date());
							trmsRolePortlets.setModuleid(moduleId);
							trmsRolePortlets.setJsid(Integer.valueOf(roleId));
							trmsRolePortlets.setPxh(j);
							trmsRolePortlets.setSfyx(1);
							trmsRolePortlets.setProid(proId);
							list.add(trmsRolePortlets);
						}
					}
				}
			}
			String mapperId = TRmsRolePortletsMapper.class.getName()
					+ ".insert";
			service.batchInsert(list, mapperId, proId);
			code = "200";
		} catch (Exception e) {
			code = "400";
		}
		request.setAttribute("proId", proId);
		return FORWARD_SAVE;
	}

	public String showTable() {
		System.out.println(request.getParameter("methodName"));
		return FORWARD_LIST;
	}

	public String todefaultUserPortlets() {
		IUser user = getLoginUser();
		String userid = user.getUserId();
		TRmsUserPortlets trmsUserPortlets = new TRmsUserPortlets();
		trmsUserPortlets.setUserid(userid);
		trmsUserPortlets.setProid(proId);
		trmsUserPortletsService.deleteByPro(trmsUserPortlets);

		return FORWARD_SAVE;
	}

	/**
	 * 解析全部默认配置模板
	 * 
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 * @throws URISyntaxException
	 */
	public String findAllPortlets() throws IOException, DocumentException,
			URISyntaxException {
		// ------------获取文件---------------------------
		String path = getPath() + templatePath;
		File templateFile = new File(path);
		if (templateFile.exists() == false) {
			response.setContentType("text/html; charset=UTF-8");
			String script = "<script>alert('模板源文件不存在')</script>";
			response.getWriter().print(script);
			return null;
		}
		Map<String, Map<String, String>> resultMap = new HashMap<String, Map<String, String>>();// key是模块的ID，value是模块的详细信息
		List<Map<String, String>> projectAttrList = new ArrayList<Map<String, String>>();// 方案的信息，id，name
																							// 等属性
		Map<String, List<String>> projectColumnList = new HashMap<String, List<String>>();// key
																							// 是方案的id，
																							// value
																							// 是column的id属性列表
		Map<String, List<Map<String, String>>> rowMapList = new HashMap<String, List<Map<String, String>>>();// key是column的id属性
																												// value是row的内容list
		String encode = "utf-8";
		String text = FileUtils.readFileToString(templateFile, encode);
		Document document = DocumentHelper.parseText(text);
		Element root = document.getRootElement();
		Element root_description = root
				.element(PortletsConstant.ROOT_DESCRIPTION);
		Element version = root.element(PortletsConstant.ROOT_VERSION);
		Element modules = root.element(PortletsConstant.ROOT_MODULES);
		List moduleList = modules.elements(PortletsConstant.MODULE);
		fullModuleMap(resultMap, moduleList);

		Element projects = root.element(PortletsConstant.ROOT_PORTLETS);
		List projectList = projects.elements(PortletsConstant.PROJECT);
		if (projectList != null && projectList.size() > 0) {
			int len = projectList.size();
			for (int i = 0; i < len; i++) {
				Map<String, String> projectMap = new HashMap<String, String>();
				// ----------获得project（方案）的信息
				DefaultElement project = (DefaultElement) projectList.get(i);
				Iterator<?> alt = project.attributeIterator();
				while (alt.hasNext()) {
					DefaultAttribute defaultAttribute = (DefaultAttribute) alt
							.next();
					projectMap.put(defaultAttribute.getName(),
							defaultAttribute.getValue());
				}
				projectAttrList.add(projectMap);
				if (StringUtil.isBlank(proId) && i == 0) {
					proId = projectMap.get("id");
				}
				if (!StringUtil.equals(proId, projectMap.get("id"))) {
					continue;
				}
				// -----------获得列的信息------------
				Iterator ei = project
						.elementIterator(PortletsConstant.PROJECT_COLUMN);
				List<String> columnIdList = new ArrayList<String>();
				while (ei.hasNext()) {
					List<Map<String, String>> rowList = new ArrayList<Map<String, String>>();
					Map<String, String> rowMap = new HashMap<String, String>();
					DefaultElement defaultElement = (DefaultElement) ei.next();
					Attribute columnAttr = defaultElement.attribute("id");
					String columnId = columnAttr.getValue();
					columnIdList.add(columnId);
					// ---------获得行的信息------------
					Iterator roweiItl = defaultElement
							.elementIterator(PortletsConstant.COLUMN_ROW);
					while (roweiItl.hasNext()) {
						DefaultElement rowei = (DefaultElement) roweiItl.next();
						fullRowMap(rowMap, rowei);
						rowList.add(rowMap);
					}
					rowMapList.put(columnId, rowList);
				}
				projectColumnList.put(projectMap.get("id"), columnIdList);
			}
		}
		request.setAttribute("resultMap", resultMap);
		request.setAttribute("projectAttrList", projectAttrList);
		request.setAttribute("projectColumnList", projectColumnList);
		request.setAttribute("rowMapList", rowMapList);

		// -----------------------获得方案列表模块列表结束----------------------------------------------
		return FORWARD_LIST;
	}

	// 查询单条记录信息
	public String queryInfo() throws Exception {
		if (bean != null && bean.getCid() != null
				&& "".equals(bean.getCid()) == false) {
			bean = service.select(bean.getCid());
		}
		return FORWARD_SELECT;
	}

	// 查询 列表信息
	public String queryList() throws Exception {
		if (bean == null) {
			bean = new TRmsRolePortlets();
		}
		datas = service.list(bean);
		return FORWARD_LIST;
	}

	// 进行更新和增加 的进入页面
	public String toEdit() throws Exception {
		// 查询一次数据信息
		queryInfo();
		return FORWARD_TOEDIT;
	}

	// 新增和更新操作
	public String save() throws Exception {
		if (bean != null) {
			// 主键记录已经存在，需要进行更新操作
			if (bean.getCid() != null && "".equals(bean.getCid()) == false) {
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				TRmsRolePortlets dsBean = service.select(bean.getCid());
				if (dsBean != null) {
					// 如果数据库中有此记录信息，进行更新操作
					int rows = service.update(bean);
				} else {
					// 是否需要输出数据不存在的异常
				}
			} else {
				bean.setCid(IDGenerator.getUUID());
				int rows = service.insert(bean);
			}

		}
		return FORWARD_SAVE;
	}

	/**
	 * 删除方法，如果ID 上是以","隔开的字符，会认为是一个数组,批量删除数据
	 */
	public String remove() throws Exception {
		Map result = new HashMap();
		result.put("status", "0");
		if (bean != null && bean.getCid() != null) {
			String idArrs[] = bean.getCid().split("[,]");
			boolean checkResult = true;
			// 程序是否需要对此数据进行数据检验,如果是请开启此部分的数据检验
			// for(int i = 0 ; i < idArrs.length ; i++){
			// //是否有对应的数据存在
			// int rows = Integer.valueOf(((Map)service.get2Object("查询数据的行数",
			// bean)).get("CNUM").toString());
			// if(rows > 0){
			// checkResult = false;
			// break;
			// }
			// }
			if (checkResult == true) {
				try {
					int rows = service.delete(idArrs);
					result.put("status", "1");
				} catch (Exception e) {
					e.printStackTrace();
					result.put("message", e.getMessage());
				}
			} else {
				result.put("status", "2");
				result.put("message", "已经存在相关联的数据，请先删除");
			}
		} else {
			result.put("message", "错误参数");
		}

		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}

	public String getPath() throws UnsupportedEncodingException {
		URL path = Thread.currentThread().getContextClassLoader()
				.getResource("");
		String cpath = path.getPath();
		cpath = URLDecoder.decode(cpath, "UTF-8");
		System.out.println("-------------配置文件地址为：" + cpath
				+ "-------------------");
		return cpath;
	}

	public TRmsRolePortletsService getService() {
		return service;
	}

	@Autowired
	public void setService(TRmsRolePortletsService service) {
		this.service = service;
	}

	public TRmsRolePortlets getBean() {
		return bean;
	}

	public void setBean(TRmsRolePortlets bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	@Autowired
	public void setTrmsUserPortletsService(
			TRmsUserPortletsService trmsUserPortletsService) {
		this.trmsUserPortletsService = trmsUserPortletsService;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
