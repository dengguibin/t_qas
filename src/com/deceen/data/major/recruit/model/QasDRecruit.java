package	com.deceen.data.major.recruit.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDRecruit.java   序号
* @Description: qas_d_recruit   
* @author upaths@gmail.com  
* @date 2017-11-23 16:10:01
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDRecruit extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //专业方向 
	private String directionid;
	 //计划招生数（人） 
	private Integer planenrolnum;
	 //实际录取<-->录取数（人） 
	private Integer enrolednum;
	 //实际报到情况报到数（人） 
	private Integer regnum;
	 //区域生源报到本地市报到数 
	private Integer localregnum;
	 //区域生源报到本省市报到数 
	private Integer provregnum;
	 //区域生源报到本区域报到数 
	private Integer arearegnum;
	 //报考本校原因<-->学校品牌报考数	 
	private Integer brandrsnnum;
	 //报考本校原因<-->专业爱好报考数 
	private Integer hobbiesrsnnum;
	 //报考本校原因<-->就业优势报考数 
	private Integer emprsnnum;
	 //报考本校原因<-->技能培养报考数 
	private Integer trainrsnnum;
	 //报考本校原因<-->地理位置报考数 
	private Integer sitersnnum;
	 //报考本校原因<-->他人推荐报考数 
	private Integer recommendrsnnum;
	 //报考本校原因<-->其他报考数 
	private Integer otherrsnnum;
	 //投档线超过上年分数 
	private Integer overlastyearscore;
	 //状态 
	private Integer status;
	 //创建人 
	private String createdby;
	 //创建时间 
	private Date createdtime;
	 //修改人 
	private String updatedby;
	 //修改时间 
	private Date updatedtime;
	 //租户 
	private String tenantid;
	 //入库时间（接口传输，导入） 
	private Date storagetime;

		 public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setDirectionid(String directionid){
			this.directionid = directionid;
		}
	  
		public String getDirectionid(){
			return this.directionid;
		}
		 public void setPlanenrolnum(Integer planenrolnum){
			this.planenrolnum = planenrolnum;
		}
	  
		public Integer getPlanenrolnum(){
			return this.planenrolnum;
		}
		 public void setEnrolednum(Integer enrolednum){
			this.enrolednum = enrolednum;
		}
	  
		public Integer getEnrolednum(){
			return this.enrolednum;
		}
		 public void setRegnum(Integer regnum){
			this.regnum = regnum;
		}
	  
		public Integer getRegnum(){
			return this.regnum;
		}
		 public void setLocalregnum(Integer localregnum){
			this.localregnum = localregnum;
		}
	  
		public Integer getLocalregnum(){
			return this.localregnum;
		}
		 public void setProvregnum(Integer provregnum){
			this.provregnum = provregnum;
		}
	  
		public Integer getProvregnum(){
			return this.provregnum;
		}
		 public void setArearegnum(Integer arearegnum){
			this.arearegnum = arearegnum;
		}
	  
		public Integer getArearegnum(){
			return this.arearegnum;
		}
		 public void setBrandrsnnum(Integer brandrsnnum){
			this.brandrsnnum = brandrsnnum;
		}
	  
		public Integer getBrandrsnnum(){
			return this.brandrsnnum;
		}
		 public void setHobbiesrsnnum(Integer hobbiesrsnnum){
			this.hobbiesrsnnum = hobbiesrsnnum;
		}
	  
		public Integer getHobbiesrsnnum(){
			return this.hobbiesrsnnum;
		}
		 public void setEmprsnnum(Integer emprsnnum){
			this.emprsnnum = emprsnnum;
		}
	  
		public Integer getEmprsnnum(){
			return this.emprsnnum;
		}
		 public void setTrainrsnnum(Integer trainrsnnum){
			this.trainrsnnum = trainrsnnum;
		}
	  
		public Integer getTrainrsnnum(){
			return this.trainrsnnum;
		}
		 public void setSitersnnum(Integer sitersnnum){
			this.sitersnnum = sitersnnum;
		}
	  
		public Integer getSitersnnum(){
			return this.sitersnnum;
		}
		 public void setRecommendrsnnum(Integer recommendrsnnum){
			this.recommendrsnnum = recommendrsnnum;
		}
	  
		public Integer getRecommendrsnnum(){
			return this.recommendrsnnum;
		}
		 public void setOtherrsnnum(Integer otherrsnnum){
			this.otherrsnnum = otherrsnnum;
		}
	  
		public Integer getOtherrsnnum(){
			return this.otherrsnnum;
		}
		 public void setOverlastyearscore(Integer overlastyearscore){
			this.overlastyearscore = overlastyearscore;
		}
	  
		public Integer getOverlastyearscore(){
			return this.overlastyearscore;
		}
		 public void setStatus(Integer status){
			this.status = status;
		}
	  
		public Integer getStatus(){
			return this.status;
		}
		 public void setCreatedby(String createdby){
			this.createdby = createdby;
		}
	  
		public String getCreatedby(){
			return this.createdby;
		}
		 public void setCreatedtime(Date createdtime){
			this.createdtime = createdtime;
		}
	  
		public Date getCreatedtime(){
			return this.createdtime;
		}
		 public void setUpdatedby(String updatedby){
			this.updatedby = updatedby;
		}
	  
		public String getUpdatedby(){
			return this.updatedby;
		}
		 public void setUpdatedtime(Date updatedtime){
			this.updatedtime = updatedtime;
		}
	  
		public Date getUpdatedtime(){
			return this.updatedtime;
		}
		 public void setTenantid(String tenantid){
			this.tenantid = tenantid;
		}
	  
		public String getTenantid(){
			return this.tenantid;
		}
		 public void setStoragetime(Date storagetime){
			this.storagetime = storagetime;
		}
	  
		public Date getStoragetime(){
			return this.storagetime;
		}
}
