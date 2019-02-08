package com.upath.plat.common.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.upath.plat.auth.facade.Menu;
/**
 * 构建树的
 * @author upaths
 * version 1.0.0
 * create date :2013-7-3 upath 代码生成平台
 * 联系邮箱： upaths@163.com
 * 项目托管地址：https://code.google.com/p/upath/
 * 修改时间：
 */
@SuppressWarnings({ "rawtypes", "unchecked"})
public class VTree {
	
	// 跟树进行关联绑定的数据项
	private Object data;
	// 树节点ID号
	private String tid;
	// 树的的父亲节点ID
	private String pid;
	// 节点名称
	private String name;
	// 父亲节点
	private VTree parent;
	// 子节点
	private List<VTree> sons;
	// 在整个树当中的层级
	private int level;
	
	public String getFdnCode() {
		if(getParent() == null){
			return this.tid;
		}else{
			return getParent().getFdnCode()+"|"+tid;
		}
	}

	private static final String ROOT = "ROOT";

	private VTree(String tid, String pid) {
		this.tid = tid;
		this.pid = pid;
	}

	//无参构造
	public VTree() {}
	
	/**针对诊断分析的左侧菜单
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException
	 * @throws CloneNotSupportedException 
	 */
	public VTree getCur(List menuAnaly) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, CloneNotSupportedException {
		VTree cur = buildVTree(menuAnaly, "menuId", "pcdid", SystemConfig.ANALY_MENUID);
		Menu menu = new Menu();
		menu.setCdmc("诊断分析");
		cur.setDatas(menu);
		return cur;
	}

	/**
	 * 
	 * @param datas 要进行构建树需要的数据 格式 为MAP
	 * @param tKey  指定MAP中哪个哉存放了树的ID项
	 * @param pKey  指定 MAP中哪个项存放了树的父节点ID
	 * @param rootId  根节点ID 如果为空。类会自动使用ROOT来进行构建
	 * @return 树
	 */
	public static VTree buildMapVTree(List<Map> datas, String tKey,String pKey, String rootId) {
		if (rootId == null) {
			rootId = ROOT;
		}
		VTree tree = new VTree(rootId, null);
		/*如果根节点是对应用数据的把数据绑定在根节点下面*/
		if(datas != null && datas.isEmpty() == false){
			for(int i = 0 ; i < datas.size() ; i++){
				Map data = datas.get(i);
				Object tid = data.get(tKey);
				if(rootId.equals(tid) == true){
					tree.setDatas(data);
					break;
				}
			}
		}
		buildMapTree(datas, tKey, pKey, tree, 0);
		return tree;
	}
	
	/**
	 * 把一个LIST对象转换成 树结构模式 (转换前的完善)
	 * @param datas 传的绑定数据
	 * @param tKeyFiled ID字段名称
	 * @param pKeyFiled 父ID字段名称
	 * @param rootId 要开始进行加载的树根ID
	 * @return VTree
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static VTree buildVTree(List datas, String tKeyFiled, String pKeyFiled, String rootId) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if (rootId == null) {
			rootId = ROOT;
		}
		VTree tree = new VTree(rootId, null);
		/*如果根节点是对应用数据的把数据绑定在根节点下面*/
		if(datas != null && datas.isEmpty() == false) {
			for(int i = 0; i < datas.size(); i++) {
				Object data = datas.get(i);
				Object tid = BeanUtils.getProperty(data, tKeyFiled);
				if(rootId.equals(tid) == true) {
					tree.setDatas(data);
					break;
				}
			}
		}
		buildTree(datas,tKeyFiled,pKeyFiled, tree, 0);
		return tree;
	}
	
	/**
	 * 把一个LIST对象转换成 树结构模式 (递归转换)
	 * @param datas 传的绑定数据
	 * @param tKeyFiled ID字段名称
	 * @param pKeyFiled 父ID字段名称
	 * @param current
	 * @param level
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	private static VTree buildTree(List datas, String tKeyFiled, String pKeyFiled, VTree current, int level) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		for (int i = 0; i < datas.size(); i++) {
			Object data = datas.get(i);
			Object tid = BeanUtils.getProperty(data, tKeyFiled);//菜单ID
			Object pid = BeanUtils.getProperty(data, pKeyFiled);//父菜单ID
			if (pid == null || "".equals(pid.toString())) {
				pid = ROOT;
			}
			if (current.getTid().equals(pid.toString()) == true) {
				if (current.getSons() == null) {
					current.setSons(new ArrayList<VTree>());
				}
				VTree tree = new VTree(tid.toString(), current.getTid());
				tree.setDatas(data);
				current.getSons().add(tree);
				tree.setParent(current);
				int next = level + 1;
				buildTree(datas,tKeyFiled,pKeyFiled,tree, next);//递归
			}
		}
		current.setLevel(level);
		return current;
	}

	private static VTree buildMapTree(List<Map> datas, String tKey,String pKey, VTree current, int level) {
		for (int i = 0; i < datas.size(); i++) {
			Map data = datas.get(i);
			Object tid = data.get(tKey);
			Object pid = data.get(pKey);
			if (pid == null || "".equals(pid.toString())) {
				pid = ROOT;
			}
			if (current.getTid().equals(pid.toString()) == true) {
				if (current.getSons() == null) {
					current.setSons(new ArrayList<VTree>());
				}
				VTree tree = new VTree(tid.toString(), current.getTid());
				tree.setDatas(data);
				current.getSons().add(tree);
				tree.setParent(current);
				int next = level + 1;
				buildMapTree(datas, tKey, pKey, tree, next);
			}
		}
		current.setLevel(level);
		return current;
	}
	
	/**
	 * 按照树的排序方案排序后的一组列表
	 * 
	 * 返回列表的形式把树中的所有数据返回
	 * 经常 是在列表中显示树的数据的时候进行调用 
	 * 同时会把树的层级 返回到MAP 中LEVEL
	 * @return
	 */
	public List asMapDataList() {
		List list = new ArrayList();
		traceList(list, this);
		return list;
	}
	
	public List asDataList(){
		return asMapDataList();
	}

	private void traceList(List list, VTree tree) {
		Object obj = tree.getDatas();
		if (obj instanceof Map) {
			Map map = (Map) obj;
			//树的的层级写入到此
			map.put("LEVEL", tree.getLevel());
			//树的是否是叶子节点写入到此
			map.put("ISLEAF", tree.getSons() == null);
			map.put("FDNCODE", getFdnCode());
		}
		if(obj != null){
			list.add(obj);
		}
		if (tree.getSons() != null) {
			for (int i = 0; i < tree.getSons().size(); i++) {
				traceList(list, tree.getSons().get(i));
			}
		}
	}
	/**
	 * 通过节点ID查找子树结构
	 * @param treeId
	 * @return
	 */
	public VTree getSubTree(String treeId) {
		if (treeId != null && "".equals(treeId) == false) {
			return findVTree(this, treeId);
		} else {
			return null;
		}
	}

	private VTree findVTree(VTree tree, String treeId) {
		if (tree.getTid().equals(treeId) == true) {
			return tree;
		} else {
			if (tree.getSons() != null && tree.getSons().isEmpty() == false) {
				for (int i = 0; i < tree.getSons().size(); i++) {
					VTree maTree = findVTree(tree.getSons().get(i), treeId);
					if (maTree != null) {
						return maTree;
					}
				}
			}
		}
		return null;
	}

	public VTree getParent() {
		return parent;
	}

	public List<VTree> getSons() {
		return sons;
	}

	public Object getDatas() {
		return data;
	}

	public void setDatas(Object datas) {
		this.data = datas;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setParent(VTree parent) {
		this.parent = parent;
	}

	public void setSons(List<VTree> sons) {
		this.sons = sons;
	}
	
}
