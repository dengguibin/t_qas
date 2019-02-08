/**
*/
package	com.upath.plat.common.modules.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: TCommonSql.java   主键
* @Description: t_common_sql   
* @author upaths@gmail.com  
* @date 2012-11-28 22:24:13
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TCommonSql extends Pagination implements Serializable{ 	
	
	//主键 @PrimaryKey
	private Integer tid;
	//所属目录 
	private Integer ptid;
	//SQL名称 
	private String name;
	//SQL引用类型 
	private Integer rtype;
	//SQL类型 
	private String type;
	//SQL脚本内容 
	private String scripts;
	//结果返回类型 
	private String result;
	//结果返回完整类名 
	private String cpath;
	//SQL调用次数 
	private Integer times;
	//平均消耗时间 
	private Integer costs;
	//脚本说明 
	private String des;
	//创建时间 
	private Date cjsj;
	//创建人 
	private String cjr;
	//修改时间 
	private Date xgsj;
	//修改人 
	private String xgr;
	
	//数据备份的时候使用 UUID 数据库兼容
	private String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setTid(Integer tid){
		this.tid = tid;
	}
  
	public Integer getTid(){
		return this.tid;
	}
	public void setPtid(Integer ptid){
		this.ptid = ptid;
	}
  
	public Integer getPtid(){
		return this.ptid;
	}
	public void setName(String name){
		this.name = name;
	}
  
	public String getName(){
		return this.name;
	}
	public void setRtype(Integer rtype){
		this.rtype = rtype;
	}
  
	public Integer getRtype(){
		return this.rtype;
	}
	public void setType(String type){
		this.type = type;
	}
  
	public String getType(){
		return this.type;
	}

	public void setResult(String result){
		this.result = result;
	}
  
	public String getResult(){
		return this.result;
	}
	public void setCpath(String cpath){
		this.cpath = cpath;
	}
  
	public String getCpath(){
		return this.cpath;
	}
	public void setTimes(Integer times){
		this.times = times;
	}
  
	public Integer getTimes(){
		return this.times;
	}
	public void setCosts(Integer costs){
		this.costs = costs;
	}
  
	public Integer getCosts(){
		return this.costs;
	}
	public void setDes(String des){
		this.des = des;
	}
  
	public String getDes(){
		return this.des;
	}
	public void setCjsj(Date cjsj){
		this.cjsj = cjsj;
	}
  
	public Date getCjsj(){
		return this.cjsj;
	}
	public void setCjr(String cjr){
		this.cjr = cjr;
	}
  
	public String getCjr(){
		return this.cjr;
	}
	public void setXgsj(Date xgsj){
		this.xgsj = xgsj;
	}
  
	public Date getXgsj(){
		return this.xgsj;
	}
	public void setXgr(String xgr){
		this.xgr = xgr;
	}
  
	public String getXgr(){
		return this.xgr;
	}

	public String getScripts() {
		return scripts;
	}

	public void setScripts(String scripts) {
		this.scripts = scripts;
	}
}
