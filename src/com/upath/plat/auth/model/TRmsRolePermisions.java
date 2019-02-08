/**
*/
package	com.upath.plat.auth.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: TRmsRolePermisions.java   角色权限关系ID
* @Description: t_rms_role_permisions   
* @author upaths@gmail.com  
* @date 2012-11-14 22:14:36
* @version V1.0   
*/
@SuppressWarnings({ "serial", "unused" })
public class TRmsRolePermisions extends Pagination implements Serializable{ 	
	
	//角色权限关系ID @PrimaryKey
	private Integer jsqxgxid;
	//角色ID 
	private Integer jsid;
	//权限ID 
	private String qxid;

	public void setJsqxgxid(Integer jsqxgxid){
		this.jsqxgxid = jsqxgxid;
	}
  
	public Integer getJsqxgxid(){
		return this.jsqxgxid;
	}
	public void setJsid(Integer jsid){
		this.jsid = jsid;
	}
  
	public Integer getJsid(){
		return this.jsid;
	}
	public void setQxid(String qxid){
		this.qxid = qxid;
	}
  
	public String getQxid(){
		return this.qxid;
	}
}
