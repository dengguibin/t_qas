/**
*/
package	com.upath.plat.common.modules.model;

import java.io.Serializable;
import java.util.Date;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: TCommonDocument.java   文档编号
* @Description: t_common_document   
* @author upaths@gmail.com  
* @date 2013-1-21 22:58:38
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TCommonDocument extends Pagination implements Serializable{ 	
	
	//文档编号 @PrimaryKey
	private String docid;
	//业务关联ID 
	private String businessid;
	//业务模块ID 
	private String moduleid;
	//扩展ID 
	private String appendid;
	//文档名称 
	private String name;
	//文档状态 
	private Integer state;
	//文档相对路径 
	private String path;
	//文档类型(0：文档，1：目录：2：镜像文件) 
	private Integer type;
	//文档内容类型 
	private String content;
	//文档大小 
	private String size;
	//文档属性 
	private Integer property;
	//文档标题 
	private String title;
	//文档后缀名称 
	private String subfix;
	//文档作者 
	private String author;
	//文档引用镜像ID 
	private String minorsid;
	//所属系统 
	private String systemid;
	//创建时间 
	private Date cjsj;
	//创建人 
	private String cjr;
	//修改时间 
	private Date xgsj;
	//修改人 
	private String xgr;

	public void setDocid(String docid){
		this.docid = docid;
	}
  
	public String getDocid(){
		return this.docid;
	}
	public void setBusinessid(String businessid){
		this.businessid = businessid;
	}
  
	public String getBusinessid(){
		return this.businessid;
	}
	public void setModuleid(String moduleid){
		this.moduleid = moduleid;
	}
  
	public String getModuleid(){
		return this.moduleid;
	}
	public void setAppendid(String appendid){
		this.appendid = appendid;
	}
  
	public String getAppendid(){
		return this.appendid;
	}
	public void setName(String name){
		this.name = name;
	}
  
	public String getName(){
		return this.name;
	}
	public void setState(Integer state){
		this.state = state;
	}
  
	public Integer getState(){
		return this.state;
	}
	public void setPath(String path){
		this.path = path;
	}
  
	public String getPath(){
		return this.path;
	}
	public void setType(Integer type){
		this.type = type;
	}
  
	public Integer getType(){
		return this.type;
	}
	public void setContent(String content){
		this.content = content;
	}
  
	public String getContent(){
		return this.content;
	}
	
	public void setProperty(Integer property){
		this.property = property;
	}
  
	public Integer getProperty(){
		return this.property;
	}
	public void setTitle(String title){
		this.title = title;
	}
  
	public String getTitle(){
		return this.title;
	}
	public void setSubfix(String subfix){
		this.subfix = subfix;
	}
  
	public String getSubfix(){
		return this.subfix;
	}
	public void setAuthor(String author){
		this.author = author;
	}
  
	public String getAuthor(){
		return this.author;
	}
	public void setMinorsid(String minorsid){
		this.minorsid = minorsid;
	}
  
	public String getMinorsid(){
		return this.minorsid;
	}
	public void setSystemid(String systemid){
		this.systemid = systemid;
	}
  
	public String getSystemid(){
		return this.systemid;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	
}
