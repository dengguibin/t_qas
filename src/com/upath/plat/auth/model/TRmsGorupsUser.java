/**
*/
package	com.upath.plat.auth.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: TRmsGorupsUser.java   用户组用户关系ID
* @Description: t_rms_gorups_user   
* @author upaths@gmail.com  
* @date 2012-11-17 17:22:21
* @version V1.0   
*/
@SuppressWarnings({"serial", "unused" })
public class TRmsGorupsUser extends Pagination implements Serializable{ 	
	
	//用户组用户关系ID @PrimaryKey
	private String yhzyhgxid;
	//用户组ID 
	private Integer yhzid;
	//用户ID 
	private String yhid;

	
	public void setYhzid(Integer yhzid){
		this.yhzid = yhzid;
	}
  
	public Integer getYhzid(){
		return this.yhzid;
	}
	public void setYhid(String yhid){
		this.yhid = yhid;
	}
  
	public String getYhid(){
		return this.yhid;
	}

	public String getYhzyhgxid() {
		return yhzyhgxid;
	}

	public void setYhzyhgxid(String yhzyhgxid) {
		this.yhzyhgxid = yhzyhgxid;
	}
}
