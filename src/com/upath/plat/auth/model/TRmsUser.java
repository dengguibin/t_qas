/**
*/
package	com.upath.plat.auth.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.auth.facade.IRole;
import com.upath.plat.common.page.Pagination;

/**
* 
* @ClassName: TRmsUser.java   用户ID
* @Description: t_rms_user   
* @author upaths@gmail.com  
* @date 2012-11-9 21:21:27
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TRmsUser extends Pagination implements Serializable{ 	
	
	//用户ID @PrimaryKey
	private String yhid;
	//用户类型 
	private Integer yhlx;
	//单位部门ID 
	private String bmid;
	//专业ID
	private String zyid;
	//用户简称 
	private String yhjc;
	//用户名称 
	private String yhmc;
	//用户称谓 
	private String yhcw;
	//最近登陆时间 
	private Date dlsj;
	//登陆IP 
	private String dlip;
	//手机号码 
	private String sjhm;
	//电子邮箱 
	private String dzyj;
	//家庭电话 
	private String jtdh;
	//工作电话 
	private String gzdh;
	//是否在线 
	private Integer sfzx;
	//是否有效 
	private Integer sfyx;
	//排序号 
	private Integer pxh;
	//个人主页 
	private String grzy;
	//创建时间 
	private Date cjsj;
	//创建人 
	private String cjr;
	//修改时间 
	private Date xgsj;
	//修改人 
	private String xgr;
	//用户密码 
	private String yhmm;
	//用户数据库唯一标识ID 
	private String uid;
	//用户CA绑定的键值，暂时未使用
	private String caid;
	
	//帐号状态[0:初始化,1:正常启用,2:禁用,3:帐号锁定]
	private int yhzt;
	
	/**在编辑用户的时候是否进行角色操作的标识
	 *  同时为了在更新的同时不影响其它的角色组。
	 *  此次更新的范围控制
	 *  */
	private List<IRole> rolesScope;

	//编辑用户时用户指定的角色ID组
	private String roleIds[];

	public List<IRole> getRolesScope() {
		return rolesScope;
	}

	public void setRolesScope(List<IRole> rolesScope) {
		this.rolesScope = rolesScope;
	}


	public String[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}

	
	public int getYhzt() {
		return yhzt;
	}

	public void setYhzt(int yhzt) {
		this.yhzt = yhzt;
	}

	public String getCaid() {
		return caid;
	}

	public void setCaid(String caid) {
		this.caid = caid;
	}

	public void setYhid(String yhid){
		this.yhid = yhid;
	}
  
	public String getYhid(){
		return this.yhid;
	}
	public void setYhlx(Integer yhlx){
		this.yhlx = yhlx;
	}
  
	public Integer getYhlx(){
		return this.yhlx;
	}
	
	public String getBmid() {
		return bmid;
	}

	public void setBmid(String bmid) {
		this.bmid = bmid;
	}

	public void setYhjc(String yhjc){
		this.yhjc = yhjc;
	}
  
	public String getYhjc(){
		return this.yhjc;
	}
	public void setYhmc(String yhmc){
		this.yhmc = yhmc;
	}
  
	public String getYhmc(){
		return this.yhmc;
	}
	public void setYhcw(String yhcw){
		this.yhcw = yhcw;
	}
  
	public String getYhcw(){
		return this.yhcw;
	}
	public void setDlsj(Date dlsj){
		this.dlsj = dlsj;
	}
  
	public Date getDlsj(){
		return this.dlsj;
	}
	public void setDlip(String dlip){
		this.dlip = dlip;
	}
  
	public String getDlip(){
		return this.dlip;
	}
	public void setSjhm(String sjhm){
		this.sjhm = sjhm;
	}
  
	public String getSjhm(){
		return this.sjhm;
	}
	public void setDzyj(String dzyj){
		this.dzyj = dzyj;
	}
  
	public String getDzyj(){
		return this.dzyj;
	}
	public void setJtdh(String jtdh){
		this.jtdh = jtdh;
	}
  
	public String getJtdh(){
		return this.jtdh;
	}
	public void setGzdh(String gzdh){
		this.gzdh = gzdh;
	}
  
	public String getGzdh(){
		return this.gzdh;
	}
	public void setSfzx(Integer sfzx){
		this.sfzx = sfzx;
	}
  
	public Integer getSfzx(){
		return this.sfzx;
	}
	public void setSfyx(Integer sfyx){
		this.sfyx = sfyx;
	}
  
	public Integer getSfyx(){
		return this.sfyx;
	}
	public void setPxh(Integer pxh){
		this.pxh = pxh;
	}
  
	public Integer getPxh(){
		return this.pxh;
	}
	public void setGrzy(String grzy){
		this.grzy = grzy;
	}
  
	public String getGrzy(){
		return this.grzy;
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
	public void setYhmm(String yhmm){
		this.yhmm = yhmm;
	}
  
	public String getYhmm(){
		return this.yhmm;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getZyid() {
		return zyid;
	}

	public void setZyid(String zyid) {
		this.zyid = zyid;
	}

}
