package	com.upath.plat.auth.model;

import java.io.Serializable;
import java.util.Date;

import com.upath.plat.common.page.Pagination;

/**
* 
* @ClassName: TRmsMenuinfo.java   菜单ID
* @Description: t_rms_menuinfo   
* @author upaths@gmail.com  
* @date 2012-10-20 21:50:34
* @version V1.0   
*/	
@SuppressWarnings("serial")
public class TRmsMenuinfo  extends Pagination  implements Serializable { 	
	
	//菜单ID @PrimaryKey
	private Integer cdid;
	//系统ID 
	private Integer xtid;
	//菜单ID 
	private Integer pcdid;
	//菜单名称 
	private String cdmc;
	//菜单描述 
	private String cdms;
	//菜单层级 
	private Integer cdcj;
	//排序号 
	private Integer pxh;
	//链接地址 
	private String ljdz;
	//菜单JSON参数 
	private String cdcs;
	//链接方式 
	private Integer ljlx;
	//是否有效 
	private Integer sfyx;
	//创建时间 
	private Date cjsj;
	//创建人 
	private String cjr;
	//修改人
	private String xgr;
	// 修改时间 
	private Date xgsj;
	
	//编辑菜单时用户指定的角色ID组
	private String roleIds[];

	public String[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}

	public void setCdid(Integer cdid){
		this.cdid = cdid;
	}
  
	public Integer getCdid(){
		return this.cdid;
	}
	public void setXtid(Integer xtid){
		this.xtid = xtid;
	}
  
	public Integer getXtid(){
		return this.xtid;
	}
	public void setPcdid(Integer pcdid){
		this.pcdid = pcdid;
	}
  
	public Integer getPcdid(){
		return this.pcdid;
	}
	public void setCdmc(String cdmc){
		this.cdmc = cdmc;
	}
  
	public String getCdmc(){
		return this.cdmc;
	}
	public void setCdms(String cdms){
		this.cdms = cdms;
	}
  
	public String getCdms(){
		return this.cdms;
	}
	public void setCdcj(Integer cdcj){
		this.cdcj = cdcj;
	}
  
	public Integer getCdcj(){
		return this.cdcj;
	}
	public void setPxh(Integer pxh){
		this.pxh = pxh;
	}
  
	public Integer getPxh(){
		return this.pxh;
	}
	public void setLjdz(String ljdz){
		this.ljdz = ljdz;
	}
  
	public String getLjdz(){
		return this.ljdz;
	}
	public void setCdcs(String cdcs){
		this.cdcs = cdcs;
	}
  
	public String getCdcs(){
		return this.cdcs;
	}
	public void setLjlx(Integer ljlx){
		this.ljlx = ljlx;
	}
  
	public Integer getLjlx(){
		return this.ljlx;
	}
	public void setSfyx(Integer sfyx){
		this.sfyx = sfyx;
	}
  
	public Integer getSfyx(){
		return this.sfyx;
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

	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

	public Date getXgsj() {
		return xgsj;
	}

	public void setXgsj(Date xgsj) {
		this.xgsj = xgsj;
	}

}
