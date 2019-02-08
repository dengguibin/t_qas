/**
*/
package	com.upath.plat.auth.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: TRmsUserRole.java   用户角色关系ID
* @Description: t_rms_user_role   
* @author upaths@gmail.com  
* @date 2012-11-15 22:33:36
* @version V1.0   
*/
@SuppressWarnings({ "serial", "unused" })
public class TRmsUserRole extends Pagination implements Serializable{ 	
	
	//用户角色关系ID @PrimaryKey
	private String yhjsgxid;
	//用户ID 
	private String yhid;
	//角色ID 
	private Integer jsid;

	
	public void setYhid(String yhid){
		this.yhid = yhid;
	}
  
	public String getYhid(){
		return this.yhid;
	}
	public void setJsid(Integer jsid){
		this.jsid = jsid;
	}
  
	public Integer getJsid(){
		return this.jsid;
	}

	public String getYhjsgxid() {
		return yhjsgxid;
	}

	public void setYhjsgxid(String yhjsgxid) {
		this.yhjsgxid = yhjsgxid;
	}
}
