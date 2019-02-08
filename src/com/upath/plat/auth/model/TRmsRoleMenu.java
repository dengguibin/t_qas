/**
*/
package	com.upath.plat.auth.model;

import java.io.Serializable;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: TRmsRoleMenu.java   角色菜单关系ID
* @Description: t_rms_role_menu   
* @author upaths@gmail.com  
* @date 2012-11-15 22:33:35
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TRmsRoleMenu extends Pagination implements Serializable{ 	
	
	//角色菜单关系ID @PrimaryKey
	private Integer jscdgxid;
	//菜单ID 
	private Integer cdid;
	//角色ID 
	private Integer jsid;
	//权限值
	private Integer qx;

	public void setJscdgxid(Integer jscdgxid){
		this.jscdgxid = jscdgxid;
	}
  
	public Integer getJscdgxid(){
		return this.jscdgxid;
	}
	public void setCdid(Integer cdid){
		this.cdid = cdid;
	}
  
	public Integer getCdid(){
		return this.cdid;
	}
	public void setJsid(Integer jsid){
		this.jsid = jsid;
	}
  
	public Integer getJsid(){
		return this.jsid;
	}

	public Integer getQx() {
		return qx;
	}

	public void setQx(Integer qx) {
		this.qx = qx;
	}
}
